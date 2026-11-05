package com.kh.plant.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {
	/*
	 *  JDBC용 인터페이스
	 *  
	 *  - Connection : 데이터베이스와의 세션(연결)을 나타내는 인터페이스
	 *  -> 데이터베이스와의 통신 패널 연결
	 *  -> SQL문을 실행을 위한 Statement 객체 생성
	 *  -> 트랜잭션 관리
	 *  
	 *  - Statement : SQL문을 실행하고 결과를 받아오기 위한 인터페이스
 	 *  1. Statement : 정적 SQL문(완성된 SQL문) 실행 
	 *  2. PreparedStatement : 파라미터화된 SQL문을 실행
	 *  3. CallableStatement : 저장 프로시저 호출
	 *  
	 *  - ResultSet : Select문 수행결과를 담은 테이블 형태의 데이터 셋
	 *  -> 커서(cursor)라는 개념을 이용해서 데이터에 접근
	 *  -> 다양한 데이터타입을 변환해주는 메소드를 제공
	 * 
	 */

	public int save(HousePlantDto hpd) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT "
					 + "INTO "
					 	  + "HOUSEPLANT "
				   + "VALUES "
					 	  + "("
					 	  + "SEQ_PLANT_NO.NEXTVAL"
					 	+ ", '" + hpd.getPlantType() + "'"
					 	+ ", '" + hpd.getPlantName() + "'"
					 	  + ")";
		// SQL문에 문법적인 문제가 존재한다
		// SQLSyntaxErrorException이 발생
			
	    try {
			  // 1) JDBC Driver 등록
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  // 1. 패키지 경로 / 클래스 식별자에 오타가 발생할 경우
			  // 2. 프로잭트에 라이브버리를 추가하지 않아서 진짜 없는 경우
			  // -> ClassNotFoundException이 발생
			
			  // 2) Connection 타입 객체 생성(URL, username, password)
			  conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1"
									            ,"hospital"
		   							            ,"oracle");
			
			// 1. URl을 잘못적었을 수 있음
			// 2. 사용자 이름을 잘못적었을 수 있음
			// 3. 비밀번호를 잘못 적었을 수 있음
			//
			// 4. 서버가 안 열려(켜져)있을 수 있음
			// 5. 접속권환을 부여받지 못했을 경우
			// 6. 비밀번호 갱신을 안했을 수 있음
			// SQLException이 발생
			
			// 3) Statement 타입의 객체
			stmt = conn.createStatement();
			
			// 4) SQL문 실행 요청 및 응답 반환
			result = stmt.executeUpdate(sql);
			// INSERT 시 값에 문제가 있을 수 있음
			// 자료형이 문제
			// 제약조건 위배
			// 데이터의 크기가 컬럼의 크기보다 큼
			// DB서버에 문제
			// SQLException이 발생			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {			
			     stmt.close();
			     conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
		// DML 수행결과 반환
		return result;
	}	

	
	public List<HousePlantDto> view() {
		// 0) 필요한 변수 선언!
		// SELECT
		// 1. Connection
		// 2. Statement
		// 3. ResultSet
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<HousePlantDto> list = new ArrayList();
		
		String sql = """
						SELECT
							   PLANT_NO
							 , PLANT_NAME
							 , PLANT_TYPE
						  FROM
						  	   HOUSEPLANT
						 ORDER
						    BY
						       PLANT_NO DESC	   	
				     """;
		// 1)
			
		// 2) Connection 객체 생성
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1"
											  ,"hospital"
											  ,"oracle");
			// 3) Statement 객체 생성
			stmt = conn.createStatement();
			
			// 4) SQL문(SELECT) 실행요청 후 응답반환받기
			rset = stmt.executeQuery(sql);
			
			// 5) SELECT문의 핵심
			// 1 관엽식물 금천수
			// PLANT의 값을 담을 거니까 PLANT 모양에 담아야겠다
			// RDBMS == 테이블형태
			// Mapping 매핑한다
			// 서로 다른 형태의 데이터모델간의 연결을 정의하는 과정
			// JAVA == 객체형태
			
		    // rset.next();
			// 조회결과를 담은 ResultSet이 들어옴
			// => 한 행씩 접근해서 데이터를 뽑아내고 => DTO/VO 필드에 담기
			// => 커서를 한 줄 아래로 롬기고 존재한다 true/ 없다 false
			
			while(rset.next()) {
				
				// 현재 rset의 커서가 가리키고 있는 행의 데이터를
				// 하나씩 뽑아서 HousePlantDTO객체의 필드에 대입
				HousePlantDto h = new HousePlantDto();
				// ResultSet 객체로부터
				// 어떤 컬럼의 값을 뽑을건지 메소드를 호풀 인자값으로
				// 컬럼명을 전달
				// rset.getInt("컬럼명"); 
				// 컬럼값이 정수여서 int로 매핑할때
				// rset.getString("컬럼명");
				// 컬럼값이 문자열이기 떄문에 String으로 매핑할때 
				// rset.getDate("컬럼명");
				// 컬럼값이 날짜값이여서 java.sql.Date로 매핑할때 
				h.setPlantNo(rset.getInt("PLANT_NO"));
				h.setPlantName(rset.getString("PLANT_NAME"));
				h.setPlantType(rset.getString("PLANT_TYPE"));
				
				
				// 한행의 모든 컬럼값을
				// 각각의 필드에 담아 DTO객체로 옮겨담으면 매핑 완료
				// 몇 개 ? => 조회된 개수만큼
				
				// List, Set, Map
				// SELECT OPDER BY 정렬
				// 배영 X 개수를 몰라
				// List
				
				//list.add(h):
				list.add(h);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int edit(HousePlantDto hpd) {
		// UPDATE -> updatedRows
		int result = 0;
		String sql = "UPDATE "
						  + "HOUSEPLANT "
					  + "SET " 
						  + "PLANT_TYPE = '" + hpd.getPlantType() + "'"
						 + ",PLANT_NAME = '" + hpd.getPlantName() + "' "
					  + "WHERE "
						  + "PLANT_NO = " + hpd.getPlantNo();
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1"
														, "hospital"
														, "oracle"); 
			Statement stmt = conn.createStatement()){ 
			result = stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
