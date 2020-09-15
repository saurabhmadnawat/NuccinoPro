package service;

import dao.MysqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ResultFetcher {

    @Autowired
    MysqlDao dao;


    public  List getResults(String keyword){

      return dao.getResults(keyword);

    }
    public  List getSuggestions(String searchQuery){

        List keywords=new ArrayList<String>();

        //filtering out stopwords
        List Stopwords= new ArrayList<String>();
        Stopwords.add("how");Stopwords.add("what");Stopwords.add("a");Stopwords.add("an");
        Stopwords.add("in");Stopwords.add("to");Stopwords.add("while");Stopwords.add(" ");
        Object [] keyWrds= Arrays.stream(searchQuery.split("\\+")).filter(str -> Stopwords.indexOf( str)==-1).toArray();


        for(Object k :keyWrds){
            keywords.add((String)k);
        }

        if(keywords.isEmpty()){
            return null;
        }
        System.out.println(keywords);
        return dao.getSuggestions(keywords);
    }
}
