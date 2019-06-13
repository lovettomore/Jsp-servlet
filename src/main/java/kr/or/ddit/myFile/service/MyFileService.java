package kr.or.ddit.myFile.service;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.myFile.dao.IMyFileDao;
import kr.or.ddit.myFile.dao.MyFileDao;
import kr.or.ddit.myFile.model.MyFileVO;
import kr.or.ddit.paging.model.PageVO;

public class MyFileService implements IMyFileService {
	
	IMyFileDao myFileDao = new MyFileDao();
	
	@Override
	public List<MyFileVO> myFileList() {
		List<MyFileVO> myFileList = new ArrayList<MyFileVO>();
		myFileList = myFileDao.myFileList();
		return myFileList;
	}

	@Override
	public Map<String, Object> myFilePasingList(PageVO pageVO) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//myFilePagingList
		resultMap.put("myFileList", myFileDao.myFilePasingList(pageVO));
		
		int myFileCnt = myFileDao.myFileCnt();
		int paginationSize = (int)Math.ceil((double)myFileCnt/pageVO.getPageSize());
				
		resultMap.put("paginationSize", paginationSize);
	
		return resultMap;
	}

	@Override
	public List<MyFileVO> myFile(String file_bd_code) {
		List<MyFileVO> myFile = new ArrayList<MyFileVO>();
		myFile = myFileDao.myFile(file_bd_code);
		return myFile;
	}


}
