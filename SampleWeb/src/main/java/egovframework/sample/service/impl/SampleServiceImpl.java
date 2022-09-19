package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name="daoJDBC")
	private SampleDAO sampleDAO;
	
	public void setSampleDAO(SampleDAO sampleDAO) {
		System.out.println("---> setSampleDAO 호출");
		this.sampleDAO = sampleDAO;
	}

	@Override
	public void insertSample(SampleVO vo) throws Exception {
		sampleDAO.insertSample(vo);
	}
	
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		sampleDAO.updateSample(vo);
	}
	
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		sampleDAO.deleteSample(vo);
	}
	
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		return sampleDAO.selectSample(vo);
	}
	
	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		return sampleDAO.selectSampleList(vo);
	}

}
