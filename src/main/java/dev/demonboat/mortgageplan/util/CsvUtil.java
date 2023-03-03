package dev.demonboat.mortgageplan.util;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.demonboat.mortgageplan.model.NamedColumnBean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CsvUtil {

  private CsvUtil() {}

  private static List<NamedColumnBean> beanBuilder(Path path) {
    if (path == null) {
      throw new IllegalArgumentException("Path may not be null.");
    }
    System.out.println(path);

    try (var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      var csvBean = new CsvToBeanBuilder<NamedColumnBean>(reader)
        .withSeparator(',')
        .withType(NamedColumnBean.class)
        .withFilter(stringValues -> Arrays.stream(stringValues)
          .anyMatch(value -> value != null && value.length() > 0 && !value.equals(".")))
        .build();

      return new ArrayList<>(csvBean.parse());
    } catch (IOException e) {
      throw new IllegalStateException("Something went wrong reading file: <" + e + ">.");
    }
  }

  public static List<NamedColumnBean> getValuesFromCsv() {
    try {
      return CsvUtil.beanBuilder(getResource("csv/prospects.txt"));
    } catch (IOException e) {
      throw new IllegalArgumentException("File failed to load: <" + e + ">.");
    }
  }

  private static Path getResource(String location) throws IOException {
    URI uri = new ClassPathResource(location).getURI();
    Path path;

    if ("jar".equals(uri.getScheme())) {
      try (var fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
        path = fileSystem.getPath("/BOOT-INF/classes" + uri);
      }
    } else {
      path = Paths.get(uri);
    }
    return path;
  }
}
