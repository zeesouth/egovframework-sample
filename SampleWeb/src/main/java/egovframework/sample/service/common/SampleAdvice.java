package egovframework.sample.service.common;

import java.sql.SQLException;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import egovframework.sample.service.SampleVO;

public class SampleAdvice {
	
	public void beforeLogic(JoinPoint jp) {
		String method=jp.getSignature().getName();
		Object[] args=jp.getArgs();
		System.out.println("[사전 처리] "+method+"() 메소드 ARGS 정보 : "+args[0].toString());
	}
	
	public void afterReturningLogic(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후 처리] "+method+"() 메소드 리턴 값을 받아서 동작");
		if(returnObj instanceof List) {
			List<SampleVO> sampleList = (List<SampleVO>) returnObj;
			System.out.println("검색된 데이터 : "+sampleList.size()+"건");
		}
	}
	
	public void afterThrowingLogic(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] "+method+"() 메소드 수행 중 예외 발생!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적절한 아규먼트 정보가 입력되었습니다.");
		} else if(exceptObj instanceof SQLException) {
			System.out.println("데이터베이스 연동에 문제가 발생했습니다.");
		} else {
			System.out.println("문제 발생!");
		}
	}
	
	public void afterLogic() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
	
	public Object aroundLogic(ProceedingJoinPoint pjp) throws Throwable {
		String method=pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method+"() 메소드 수행에 걸린 시간 : "
				+stopWatch.getTotalTimeMillis()+"(ms)초");
		return obj;
	}
}
