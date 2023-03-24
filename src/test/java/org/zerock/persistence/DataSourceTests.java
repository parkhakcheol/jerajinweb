package org.zerock.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.sample.Restaurant;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//테스트 프로그램을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//설정 파일을 불러와서 적용시킨다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;

	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testConnection() {
		// try (객체 선언 생성) { ~~ } catch() { ~~ } -> 객체 자동 닫기
		try (Connection con = dataSource.getConnection()) {
			String sql = "select sysdate from dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			log.info(rs.getString(1));
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMybatis() {
		// try (객체 선언 생성) { ~~ } catch() { ~~ } -> 객체 자동 닫기
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection con = dataSource.getConnection()) {
			log.info(session);
			String sql = "select sysdate from dual";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			log.info(rs.getString(1));
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
