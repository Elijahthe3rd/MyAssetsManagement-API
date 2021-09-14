package za.co.commandquality.AssetManagement.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Configuration
@EnableSwagger2
public class PostgresDatasource {

    @Bean
    @ConfigurationProperties( "app.datasource" )
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder.create().type( HikariDataSource.class ).build();
    }

    @Bean
    public Docket userApi(){
        return  new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( RequestHandlerSelectors.basePackage("za.co.commandquality.AssetManagement.controller"))
                .paths( PathSelectors.any())
                .build()
                .apiInfo(apiEndPointInfo());
    }
    public ApiInfo apiEndPointInfo() {
        return new ApiInfoBuilder().title("Spring Boot Rest('Asset-Management') API").description("user Management API")
                .contact(new Contact("Elijah Sepuru", "website.com/quodahFromTheHood", "elijah@commandquality.co.za"))
                .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("0.0.1-SNAPSHOT").build();

    }

}
