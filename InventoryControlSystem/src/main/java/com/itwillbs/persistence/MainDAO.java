package com.itwillbs.persistence;

import java.util.Date;
import java.util.List;

public interface MainDAO {
	
	public String getTodayMonth() throws Exception;
	
	public List<String> getDayList() throws Exception;
	
	public String getSellTotal(String date) throws Exception;
	
	public List<String> getReleaseDay(String month) throws Exception;

	public List<String> getStoreDay(String month) throws Exception;	

}// dao
