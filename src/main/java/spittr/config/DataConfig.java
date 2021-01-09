package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
//    return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.H2)
//            .addScript("schema.sql")
//            .build();
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
    ds.setUsername("root");
    ds.setPassword("1115");
    return ds;
  }
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//    try {
//      System.out.println("getting current statistic table...");
//      System.out.println("Insert comment");
//      jdbcTemplate.update("insert into Spittle (message, created_at, latitude, longitude)" +
//                      " values (?, ?, ?, ?)",
//              "212",
//             "000",
//              121111,
//              12121111);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      System.err.println("sqlCheck");
//    }
    return jdbcTemplate;
    //return new JdbcTemplate(dataSource);
  }

}
