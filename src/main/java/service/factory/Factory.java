package service.factory;

import service.connection.ConnectionI;
import service.connection.MySqlConnection;
import service.connection.OracleConnection;
import service.dao.MysqlDao;
import service.dao.OracleDao;
import service.dao.DaoI;

public class Factory {

     public static ConnectionI getConnObject(String key){
             switch (key){
                 case "oracle" : return new OracleConnection();
                 case "mysql":  return new MySqlConnection();
                 default: return null;
             }
      }


     public static DaoI getDaoObject(String key){
        switch (key){
            case "oracle" : return new OracleDao();
            case "mysql":  return new MysqlDao();
            default: return null;
        }
    }

}
