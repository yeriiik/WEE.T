package com.weet.app.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataSourceTests {
	
	// hikariDataSource를 테스트하기 위한 빈 주입 시그널 전송
	@Autowired
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private HikariConfig config;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.dataSource);
		log.trace("\t+ dataSource: {}", this.dataSource);
		
		assertNotNull(this.config);
		log.trace("\t+ config: {}", this.config);
	} // beforeAll
	
	@Disabled
	@Test
	@Order(2)
	@DisplayName("testHikariConfig Test")
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testHikariConfig() {
		log.trace("testHikariConfig() invoked.");
		
		log.info("\t+ 1. getDriverClassName: {}", this.config.getDriverClassName());
		log.info("\t+ 2. getJdbcUrl: {}", this.config.getJdbcUrl());
		log.info("\t+ 3. getUsername: {}", this.config.getUsername());
		log.info("\t+ 4. getPassword: {}", this.config.getPassword());
		
		log.info("\t+ 5. getMaximumPoolSize: {}", this.config.getMaximumPoolSize());
		log.info("\t+ 6. getMinimumIdle: {}", this.config.getMinimumIdle());
		log.info("\t+ 7. getIdleTimeout: {}", this.config.getIdleTimeout());
		log.info("\t+ 8. getConnectionTimeout: {}", this.config.getConnectionTimeout());
		log.info("\t+ 9. getConnectionTestQuery: {}", this.config.getConnectionTestQuery());
		log.info("\t+ 10. getDataSourceJNDI: {}", this.config.getDataSourceJNDI());
		log.info("\t+ 11. getPoolName: {}", this.config.getPoolName());
	} // testHikariConfig
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testHikariCP Test")
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testHikariCP() throws SQLException {
		log.trace("testHikariCP() invoked.");
		
		Connection conn = this.dataSource.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT\r\n"
				+ "    user_id, class_type, class_title, class_trainer_name, class_fee, class_avg_star\r\n"
				+ "FROM\r\n"
				+ "    t_class");
		
		while(rs.next()) {
			String userId = rs.getString("user_id");
			String classType = rs.getString("class_type");
			String classTitle = rs.getString("class_title");
			String classTrainerName = rs.getString("class_trainer_name");
			String classFee = rs.getString("class_fee");
			String classAvgStar = rs.getString("class_avg_star");
			
			String classList = String.format(
				"%s, %s, %s, %s, %s, %s",
				userId , classType, classTitle, classTrainerName, classFee,
				classAvgStar);
			
			log.info(classList);
		} // while
	} // testHikariCP

} // end class
