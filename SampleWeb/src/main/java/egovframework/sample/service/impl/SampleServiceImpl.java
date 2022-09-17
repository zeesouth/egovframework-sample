package egovframework.sample.service.impl;

import egovframework.sample.service.SampleService;

public class SampleServiceImpl implements SampleService {
	

	
	public SampleServiceImpl() throws Exception {
		System.out.println("===> SampleServiceImpl 생성");
	}
	
	@Override
	public void insertSample() throws Exception {
		System.out.println("SampleSevice--Sample 등록");
	}
	
	@Override
	public void updateSample() throws Exception {
		System.out.println("SampleSevice--Sample 수정");
	}
	
	@Override
	public void deleteSample() throws Exception {
		System.out.println("SampleSevice--Sample 삭제");
	}
	
	@Override
	public void selectSample() throws Exception {
		System.out.println("SampleSevice--Sample 상세 조회");
	}
	
	@Override
	public void selectSampleList() throws Exception {
		System.out.println("SampleSevice--Sample 목록 검색");
	}
	

}
