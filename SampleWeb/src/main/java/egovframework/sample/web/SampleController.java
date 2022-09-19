package egovframework.sample.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.sample.service.SampleVO;
import egovframework.sample.service.impl.SampleDAOJDBC;

@Controller
public class SampleController {
	
	@RequestMapping(value="/insertSample.do", method=RequestMethod.GET)
	public String insertSampleView(SampleVO vo) throws Exception {
		System.out.println("등록 화면으로 이동");
		vo.setTitle("SAMPLE 등록입니다.");
		vo.setRegUser("테스터");
		vo.setContent("SAMPLE 등록 테스트 중입니다.");
		return "insertSample";
		
	}
	
	@RequestMapping(value="/insertSample.do", method=RequestMethod.POST)
	public String insertSample(SampleVO vo, SampleDAOJDBC sampleDAO) throws Exception {
		System.out.println("등록 처리");
		sampleDAO.insertSample(vo);
		return "forward:selectSampleList.do";
		
	}
	
	@RequestMapping(value="/updateSample.do")
	public String updateSample(SampleVO vo, SampleDAOJDBC sampleDAO) throws Exception {
		sampleDAO.updateSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo, SampleDAOJDBC sampleDAO) throws Exception {
		sampleDAO.deleteSample(vo);
		return "forward:selectSampleList.do";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping(value="/selectSample.do")
	public String selectSample(SampleVO vo, SampleDAOJDBC sampleDAO, Model model) throws Exception {
		model.addAttribute("sample", sampleDAO.selectSample(vo));
		return "selectSample";
	}
	
	@RequestMapping(value="/selectSampleList.do")
	public String selectSampleList(SampleVO vo, SampleDAOJDBC sampleDAO, Model model) throws Exception {
		model.addAttribute("sample", sampleDAO.selectSampleList(vo));
		return "selectSampleList";
	}
}
