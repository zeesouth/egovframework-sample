package egovframework.sample.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;
import egovframework.sample.service.common.JDBCUtil;

@Repository("daoJDBC")
public class SampleDAOJDBC implements SampleDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER,"
			+ "CONTENT, REG_DATE) VALUES (?, ?, ?, ?, SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	
	private final String SAMPLE_LIST_TITLE = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE TITLE LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_CONTENT = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE CONTENT LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	
	public SampleDAOJDBC() throws Exception {
		System.out.println("===> SampleDAOJDBC 생성");
	}
	
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("JDBC로 insertSample() 기능 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_INSERT);
		stmt.setString(1, vo.getId());
		stmt.setString(2, vo.getTitle());
		stmt.setString(3, vo.getRegUser());
		stmt.setString(4, vo.getContent());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("JDBC로 updateSample() 기능 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_UPDATE);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getRegUser());
		stmt.setString(3, vo.getContent());
		stmt.setString(4, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("JDBC로 deleteSample() 기능 처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_DELETE);
		stmt.setString(1, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt, conn);
	}
	
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("JDBC로 selectSample() 기능 처리");
		SampleVO sample = null;
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_GET);
		stmt.setString(1, vo.getId());
		rs = stmt.executeQuery();
		if(rs.next()) {
			sample = new SampleVO();
			sample.setId(rs.getString("ID"));
			sample.setTitle(rs.getString("TITLE"));
			sample.setRegUser(rs.getString("REG_USER"));
			sample.setContent(rs.getString("CONTENT"));
			sample.setRegDate(rs.getDate("REG_DATE"));
		}
		JDBCUtil.close(rs, stmt, conn);
		return sample;
	}
	
	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("JDBC로 selectSampleList() 기능 처리");
		List<SampleVO> sampleList = new ArrayList<SampleVO>();
		conn = JDBCUtil.getConnection();
		if(vo.getSearchCondition().equals("TITLE")) {
			stmt = conn.prepareStatement(SAMPLE_LIST_TITLE);
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			stmt = conn.prepareStatement(SAMPLE_LIST_CONTENT);
		}
		stmt.setString(1, vo.getSearchKeyword());
		rs = stmt.executeQuery();
		while(rs.next()) {
			SampleVO sample = new SampleVO();
			sample.setId(rs.getString("ID"));
			sample.setTitle(rs.getString("TITLE"));
			sample.setRegUser(rs.getString("REG_USER"));
			sample.setContent(rs.getString("CONTENT"));
			sample.setRegDate(rs.getDate("REG_DATE"));
			sampleList.add(sample);
		}
		JDBCUtil.close(rs,stmt,conn);
		return sampleList;
	}

}
