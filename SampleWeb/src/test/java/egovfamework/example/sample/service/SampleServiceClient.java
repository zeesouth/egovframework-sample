package egovfamework.example.sample.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import egovframework.sample.service.SampleService;

public class SampleServiceClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AbstractApplicationContext container = new GenericXmlApplicationContext(
				"egovframework/spring/context-common.xml");
		
		SampleService sampleService 
			= (SampleService) container.getBean("sampleService");
		sampleService.insertSample();
		sampleService.selectSampleList();
		
		container.close();
		
	}

}
