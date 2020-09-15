package dao;

import org.springframework.dao.DataAccessException;

public class DataAccessExcpn extends DataAccessException{

	public DataAccessExcpn(String msg) {
		super(msg);
		
	}
	
	public DataAccessExcpn(String msg, Throwable ex) {
		super(msg,ex);
		
	}

}
