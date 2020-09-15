package controller;


import model.SearchForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import dao.MysqlDao;
import service.ResultFetcher;

import java.util.*;

@Controller
public class EngineController {

   @Autowired
    ResultFetcher service;


      @GetMapping("/Engine")
    String getEngine(@ModelAttribute("sf") SearchForm sf){

          return "engineForm";
    }

    @PostMapping("/Engine")
    ModelAndView postEngine(@ModelAttribute("sf") SearchForm sf){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


       List results= service.getResults(sf.getKeyword());


        if(results==null) {
        return new ModelAndView("error");
       }

        stopWatch.stop();

        Map m=new HashMap<String,Object>();
        m.put("searchResult",results);
        m.put("timeTaken",stopWatch.getTotalTimeSeconds());
        m.put("searchQuery",sf.getKeyword());
        m.put("numResults",results.size());
        return  new ModelAndView("searchResult",m);
    }

    @PostMapping("/searchSuggestions")
    ModelAndView getSuggestions(@RequestBody String body){
        String [] requestPayload=body.split("=");

        if(requestPayload.length<=1){
            return new ModelAndView("test","suggestions",null);
        }


        System.out.println(requestPayload[1]);
        // call service
         List suggestions=service.getSuggestions(requestPayload[1]);


        //List suggestions=dao.getSuggestions(keywords);

        System.out.print( "Suggestions:");
        System.out.println(suggestions);

        return new ModelAndView("test","suggestions",suggestions);
    }




}
