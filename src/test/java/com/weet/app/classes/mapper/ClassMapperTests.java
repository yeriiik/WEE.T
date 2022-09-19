package com.weet.app.classes.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

import com.weet.app.classes.domain.ClassVO;
import com.weet.app.classes.domain.Criteria;
import com.weet.app.exception.DAOException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)

@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClassMapperTests {

	
	@Setter(onMethod_= {@Autowired})
	private ClassMapper mapper;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");	
		
		assertNotNull(this.mapper);
		log.info("\t+ 1. this.mapper: {}", this.mapper);
		log.info("\t+ 2. type: {}", this.mapper.getClass().getName());
	} // beforeAll
	
	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. ClassMapper.getList() test")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetList() throws DAOException {
		log.trace("testGetList() invoked.");
		
		List<ClassVO> list = this.mapper.selectClassNew();
		Objects.requireNonNull(list);
		list.forEach(log::info);
	} // testGetList
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. selectClassPaging test")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testselectClassPaging() throws DAOException {
		log.trace("testselectClassPaging() invoked.");
		
		Criteria cri = new Criteria();
		
		List list = this.mapper.selectClassPaging(cri);
		Objects.requireNonNull(list);
		list.forEach(log::info);
	} // testGetList
} // end class
