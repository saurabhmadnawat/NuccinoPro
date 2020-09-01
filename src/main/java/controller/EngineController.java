package controller;


import model.SearchForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ResultFetcher;

import java.util.List;

@Controller
public class EngineController {

   /* @Autowired
    private MessageSource messageSource;
*/

      @GetMapping("/Engine")
    String getEngine(@ModelAttribute("sf") SearchForm sf){
        return "engineForm";
    }

    @PostMapping("/Engine")
    ModelAndView postEngine(@ModelAttribute("sf") SearchForm sf){
        System.out.println(sf.getKeyword());
       List results= ResultFetcher.getResults(sf.getKeyword());
       if(results==null) {
        return new ModelAndView("error");
       }
        System.out.println(results);

        return  new ModelAndView("searchResult","searchResult",results);
    }




}
