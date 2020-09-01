package service;

import service.dao.DaoI;
import service.factory.Factory;

import java.util.List;



public class ResultFetcher {


    public static List getResults(String keyword){

       DaoI dataAcessObj=Factory.getDaoObject("mysql");
      return dataAcessObj.getResults(keyword);



    }
}
