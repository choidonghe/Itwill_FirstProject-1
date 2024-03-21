package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.InspectionVO;
import com.itwillbs.persistence.InspectionDAO;

@Service
public class InspectionServiceImpl implements InspectionService{
	
	private static final Logger logger = LoggerFactory.getLogger(InspectionServiceImpl.class);
	@Inject
	private InspectionDAO idao;
	
	@Override
	public List<InspectionVO> getInspectionList() throws Exception {
		logger.debug(" List<InspectionVO> getInspectionList() 실행 ");
		return idao.inspectionList();
	}

	@Override
	public InspectionVO read(String pno) throws Exception {
		logger.debug(" read(String pno) 실행 ");
		return idao.inspectionRead(pno);
	}

	@Override
    public void modify(InspectionVO vo) throws Exception {
        logger.debug(" modify(InspectionVO vo) 실행 ");
        idao.inspectionUpdate(vo);
        idao.moveToStock();
    } 

	@Override
	public void updateRemain(InspectionVO vo) throws Exception {
		logger.debug(" updateRemain() 실행 ");
		
	}

	@Override
	public List<InspectionVO> getInspectionDiv2() throws Exception {
		logger.debug(" List<InspectionVO> getInspectionDiv2() 호출 ");
		return idao.div2();
	}

	@Override
	public List<InspectionVO> getInspectionDiv3() throws Exception {
		logger.debug(" List<InspectionVO> getInspectionDiv3() 호출 ");
		return idao.div3();
	}

}
