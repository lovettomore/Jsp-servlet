package kr.or.ddit.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.dao.DBDao;
import kr.or.ddit.dao.IDBDao;
import kr.or.ddit.model.DBVO;

public class DBService implements IDBService{

	private IDBDao dbDao = new DBDao(); 
	
	@Override
	public List<DBVO> dbList() {
		List<DBVO> dbList = new ArrayList<DBVO>();
		dbList = dbDao.dbList();
		return dbList;
	}

}
