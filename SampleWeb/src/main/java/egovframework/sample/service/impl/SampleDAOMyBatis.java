package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoMyBatis")
public class SampleDAOMyBatis extends EgovAbstractMapper implements SampleDAO, SampleMapper {
	
	@Resource(name="sampleMapper")
	private SampleMapper mybatis;
	
	public SampleDAOMyBatis() throws Exception {
		System.out.println("===> SampleDAOMyBatis 생성");
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleMapper#insertSample(egovframework.sample.service.SampleVO)
	 */
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis로 insertSample() 기능 처리");
		// insert("insertSample", vo);
		mybatis.insertSample(vo);
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleMapper#updateSample(egovframework.sample.service.SampleVO)
	 */
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis로 updateSample() 기능 처리");
		// update("updateSample", vo);
		mybatis.updateSample(vo);
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleMapper#deleteSample(egovframework.sample.service.SampleVO)
	 */
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis로 deleteSample() 기능 처리");
		// delete("deleteSample", vo);
		mybatis.deleteSample(vo);
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleMapper#selectSample(egovframework.sample.service.SampleVO)
	 */
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("MyBatis로 selectSample() 기능 처리");
		// return (SampleVO) selectOne("selectSample", vo);
		return (SampleVO) mybatis.selectSample(vo);
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleMapper#selectSampleList(egovframework.sample.service.SampleVO)
	 */
	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("MyBatis로 selectSampleList() 기능 처리");
		// return selectList("selectSampleList", vo);
		return mybatis.selectSampleList(vo);
	}

}
