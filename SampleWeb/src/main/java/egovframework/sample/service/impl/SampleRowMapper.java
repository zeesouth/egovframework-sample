package egovframework.sample.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import egovframework.sample.service.SampleVO;

public class SampleRowMapper implements RowMapper<SampleVO> {

	@Override
	public SampleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SampleVO sample = new SampleVO();
		sample.setId(rs.getString("ID"));
		sample.setTitle(rs.getString("TITLE"));
		sample.setRegUser(rs.getString("REG_USER"));
		sample.setContent(rs.getString("CONTENT"));
		sample.setRegDate(rs.getDate("REG_DATE"));
		return sample;
	}

	
	
}
