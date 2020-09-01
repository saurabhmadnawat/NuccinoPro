package service.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class MySqlConnection implements ConnectionI {

    @Autowired
    MessageSource messageSource;

    @Override
    public Connection getConnection() throws SQLException {
        //System.out.println(messageSource);
        //System.out.println(this.messageSource.getMessage("url",null,null));
        DriverManager.registerDriver(new com.mysql.jdbc.Driver() );
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false","root","123");
        return con;



    }
}
