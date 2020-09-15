package dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
@Repository
public class MysqlDao implements DaoI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List getResults(String searchQuery) {

        try {


            List results=new ArrayList<ArrayList<String>>();
            Object arr[]={searchQuery};
            results=jdbcTemplate.query("select Question,Answer from EngineData2 where Question=?", arr, new RowMapper <ArrayList<String>>() {
                @Override
                public ArrayList<String> mapRow(ResultSet rs, int rownumber) throws SQLException {
                    ArrayList<String> l = new ArrayList<String>();

                    l.add(rs.getString(1));
                    l.add(rs.getString(2));

                    return l;

                }

            });
            if(!results.isEmpty()){
                return results;
            }

            StringTokenizer st1 =
                    new StringTokenizer(searchQuery, " ");
            List tokens=new ArrayList<String>();

            while (st1.hasMoreTokens()) {
                tokens.add(st1.nextToken());
            }

            //filtering out tokens
            List Stopwords= new ArrayList<String>();
            Stopwords.add("how");Stopwords.add("what");Stopwords.add("a");Stopwords.add("an");
            Stopwords.add("in");Stopwords.add("to");Stopwords.add("while");Stopwords.add(" ");
            Object [] keyWrds= Arrays.stream(tokens.toArray()).filter(str -> Stopwords.indexOf( str)==-1).toArray();


            StringBuffer st=new StringBuffer();
            for(int i=0;i<keyWrds.length;i++){
                if(i==keyWrds.length-1){
                    st.append("Question LIKE ? ");
                }
                else{
                    st.append("Question LIKE ? or ");
                }
            }



            results=jdbcTemplate.query(
                    "select Question,Answer from EngineData2 where "+st,
                    new PreparedStatementSetter() {
                        public void setValues(PreparedStatement preparedStatement) throws
                                SQLException {
                            int idx=1;
                            for(Object keyWrd:keyWrds){
                                preparedStatement.setString(idx++,"%"+(String)keyWrd+"%");
                            }
                        }
                    },
                    new RowMapper <ArrayList<String>>(){
                        @Override
                        public ArrayList<String> mapRow(ResultSet rs, int rownumber) throws SQLException {
                            ArrayList<String> l = new ArrayList<String>();

                            l.add(rs.getString(1));
                            l.add(rs.getString(2));

                            return l;

                        }
                    }
            );



            return results;

        }

        catch (Exception e ){
            e.printStackTrace();
            return null;
        }

        //return null;
    }

    @Override
    public List getSuggestions(List keywords) {

        try {

            StringBuffer st=new StringBuffer();
            for(int i=0;i<keywords.size();i++){
                if(i==keywords.size()-1){
                      st.append("Question LIKE ? ");
                }
                else{
                    st.append("Question LIKE ? or ");
                }
            }


            List questions=new ArrayList<String>();
            questions=jdbcTemplate.query(
                    "select Question from EngineData2 where "+st,
                    new PreparedStatementSetter() {
                        public void setValues(PreparedStatement preparedStatement) throws
                                SQLException {
                            int idx=1;
                            for(Object keyWrd:keywords){
                                preparedStatement.setString(idx++,"%"+(String)keyWrd+"%");
                            }
                        }
                    },
                    new RowMapper<String>(){
                        @Override
                        public String mapRow(ResultSet rs, int rownumber) throws SQLException {

                            return rs.getString(1);

                        }
                    }
            );

            return questions;
        }

        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
