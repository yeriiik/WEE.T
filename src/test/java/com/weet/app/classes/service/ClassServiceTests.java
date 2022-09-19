package com.weet.app.classes.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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

import com.weet.app.classes.domain.Criteria;
import com.weet.app.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/**/spring/**/*-context.xml"
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClassServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private ClassService service;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");
		
		assertNotNull(this.service);
		
		log.info("\t+ this.service: {}", this.service);
	} // beforeAll
	
	@Test
	void dummyTest() {;;}

	@Disabled
	@Test
	@Order(1)
	@DisplayName("1. ClassService.getList() test")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetList() throws ServiceException {
		log.trace("testGetList() invoked.");
		
		this.service.getListRecommend().forEach(log::info);
	} // testGetList


	// 페이징 테스트
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("2. ClassService.getClassPaging() test")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetClassPaging() throws ServiceException {
		log.trace("testGetClassPaging() invoked.");
		
		Criteria cri = new Criteria();
		
		List list = service.getClassPaging(cri);
		
		list.forEach(log::info);
	} // testGetClassPaging
} // end class
