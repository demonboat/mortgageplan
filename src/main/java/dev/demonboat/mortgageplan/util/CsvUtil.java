package dev.demonboat.mortgageplan.util;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.demonboat.mortgageplan.model.NamedColumnBean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CsvUtil {

  private CsvUtil() {}

  private static List<NamedColumnBean> beanBuilder(InputStream stream) throws IOException {
    if (stream == null) {
      stream = new ClassPathResource("csv/prospects.txt").getInputStream();
    }
    try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
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

  public static List<NamedColumnBean> getValuesFromCsv(final InputStream stream) {
    try {
      return CsvUtil.beanBuilder(stream);
    } catch (IOException e) {
      throw new IllegalStateException("File failed to load: <" + e + ">.");
    }
  }
}
