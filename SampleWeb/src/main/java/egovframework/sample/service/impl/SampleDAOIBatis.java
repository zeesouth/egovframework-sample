package egovframework.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoIBatis")
public class SampleDAOIBatis implements SampleDAO {
	
	public SampleDAOIBatis() throws Exception {
		System.out.println("===> SampleDAOIBatis 생성");
	}
	
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("IBatis로 insertSample() 기능 처리");
	}
	
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("IBatis로 updateSample() 기능 처리");
	}
	
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("IBatis로 deleteSample() 기능 처리");
	}
	
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("IBatis로 selectSample() 기능 처리");
		return null;
	}
	
	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("IBatis로 selectSampleList() 기능 처리");
		return null;
	}

}
