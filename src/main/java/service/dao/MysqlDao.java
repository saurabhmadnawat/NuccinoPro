package service.dao;


import service.connection.ConnectionI;
import service.factory.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MysqlDao implements DaoI {

    @Override
    public List getResults(String keyword) {
        try {
            Connection conn=Factory.getConnObject("mysql").getConnection();
            StringTokenizer st1 =
                    new StringTokenizer(keyword, " ");
            List tokens=new ArrayList<String>();
            while (st1.hasMoreTokens()) {
                tokens.add(st1.nextToken());
            }
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<tokens.size();i++){

                System.out.println(tokens.get(i));

                if(i==(tokens.size()-1)){
                    sb.append("?");
                }
                else{
                    sb.append("?,");
                }
            }

            System.out.println(sb);
            PreparedStatement stmt= conn.prepareStatement("select description,hperlink from EngineData where keyword IN ("+sb+")");
           stmt.setString(1,keyword);
           int idx=1;
           for(Object o:tokens){
               stmt.setString(idx,(String) o);
               idx++;
           }

           ResultSet rs=stmt.executeQuery();
           List resutls=new ArrayList<ArrayList<String>>();

           while (rs.next()){
               List l= new ArrayList<String>();
               l.add( rs.getString(1));
               l.add( rs.getString(2));
               resutls.add(l);
              // l.clear();
           }
           return resutls;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        catch (Exception e ){
            e.printStackTrace();
            return null;
        }

        //return null;
    }
}
