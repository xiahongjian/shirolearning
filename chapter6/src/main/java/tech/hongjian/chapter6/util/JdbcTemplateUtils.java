package tech.hongjian.chapter6.util;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author xiahongjian 
 * @time   2018-03-27 13:46:26
 *
 */
public class JdbcTemplateUtils {
	private static JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate jdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = createJdbcTemplate();
		}
		return jdbcTemplate;
	}
	
	private static JdbcTemplate createJdbcTemplate() {
		DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/shirolearning?characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("root");

        return new JdbcTemplate(ds);
	}
}
