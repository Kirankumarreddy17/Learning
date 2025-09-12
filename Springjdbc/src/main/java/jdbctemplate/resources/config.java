package jdbctemplate.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class config {
   
	@Bean
	public DriverManagerDataSource  datasource()
	{
		
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/wiprotraining");
		datasource.setUsername("root");
		datasource.setPassword("KiranKumar@17");
		return datasource;	
	}
	
	@Bean
	public JdbcTemplate myjdbc()
	{
		JdbcTemplate myjdbc=new JdbcTemplate();
		myjdbc.setDataSource(datasource());
		
		return myjdbc;
	}
	
	
}