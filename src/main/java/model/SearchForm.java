package model;



public class SearchForm {
  private String keyword;


    public SearchForm() {

    }

    public SearchForm(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
