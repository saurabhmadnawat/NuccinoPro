package dao;


import java.util.List;

public interface DaoI {

    List getResults(String keyword);
    List getSuggestions(List keywords);


}
