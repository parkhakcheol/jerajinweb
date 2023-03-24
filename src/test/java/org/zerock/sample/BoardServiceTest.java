package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.service.BoardServiceImpl;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 프로그램을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//설정 파일을 불러와서 적용시킨다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //로그 출력 - 데이터 확인, 흐름 확인
public class BoardServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardServiceImpl service;
	
	@Test
	public void testExist() {
		log.info("\n서비스 테스트 ---------------------------------------------");
		log.info(service);
		log.info(service.getDao());
	}
	

}
