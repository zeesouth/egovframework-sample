package egovframework.sample.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;
import egovframework.sample.service.impl.SampleDAOJDBC;

@Controller
@SessionAttributes("sample")
public class SampleController {
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/insertSample.do", method=RequestMethod.GET)
	public String insertSampleView(SampleVO vo) throws Exception {
		System.out.println("등록 화면으로 이동");
		vo.setTitle("SAMPLE 등록입니다.");
		vo.setRegUser("테스터");
		vo.setContent("SAMPLE 등록 테스트 중입니다.");
		return "insertSample";
		
	}
	
	@RequestMapping(value="/insertSample.do", method=RequestMethod.POST)
	public String insertSample(SampleVO vo) throws Exception {
		System.out.println("등록 처리");
		sampleService.insertSample(vo);
		return "forward:selectSampleList.do";
		
	}
	
	@RequestMapping(value="/updateSample.do")
	public String updateSample(@ModelAttribute("sample") SampleVO vo) throws Exception {
		sampleService.updateSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo) throws Exception {
		sampleService.deleteSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@RequestMapping(value="/selectSample.do")
	public String selectSample(SampleVO vo, Model model) throws Exception {
		model.addAttribute("sample", sampleService.selectSample(vo));
		return "selectSample";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping(value="/selectSampleList.do")
	public String selectSampleList(SampleVO vo, Model model) throws Exception {
		model.addAttribute("sampleList", sampleService.selectSampleList(vo));
		return "selectSampleList";
	}
}
