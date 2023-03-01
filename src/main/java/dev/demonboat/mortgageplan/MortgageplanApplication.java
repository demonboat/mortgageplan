package dev.demonboat.mortgageplan;

import dev.demonboat.mortgageplan.model.NamedColumnBean;
import dev.demonboat.mortgageplan.service.ProspectServiceImpl;
import dev.demonboat.mortgageplan.util.CsvUtil;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MortgageplanApplication {

    public static void main(String[] args) {
      SpringApplication.run(MortgageplanApplication.class, args);

      List<NamedColumnBean> prospectList = CsvUtil.getValuesFromCsv();
      var prospects = prospectList.stream()
        .map(ProspectServiceImpl::toProspect)
        .toList();

      // For the purpose of displaying the output that was in the specification.
      var index = 0;
      for (var prospect : prospects) {
        index++;
        System.out.print("Prospect " + index + ":" + prospect.customerOutput());
      }
    }

  @Bean
  public OpenAPI customOpenAPI(@Value("${springdoc.api-docs.version}") String appVersion) {
    return new OpenAPI()
           .components(new Components())
           .info(new Info().title("Prospects API").version(appVersion)
                 .license(new License().name("Apache 2.0").url("https://springdoc.org")));
  }
}
