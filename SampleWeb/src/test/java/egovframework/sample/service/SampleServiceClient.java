package egovframework.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleServiceClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 1. Spring 컨테이너를 구한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext (
				"egovframework/spring/context-*.xml");
		
		// 2. Spring 컨테이너로부터 SampleServiceImpl 객체를 Lookup 한다.
		SampleService sampleService = (SampleService) container.getBean("sampleService");
		SampleVO vo = new SampleVO();
		vo.setTitle("아이디 자동 생성 테스트");
		vo.setRegUser("테스터");
		vo.setContent("아이디 자동...");
		
		sampleService.insertSample(vo);
		
		List<SampleVO> sampleList = sampleService.selectSampleList(vo);
		System.out.println("[ Sample List ]");
		for(SampleVO sample : sampleList) {
			System.out.println("---> "+sample.toString());
		}
		
		// 3. Spring 컨테이너를 종료한다.
		container.close();
	}

}