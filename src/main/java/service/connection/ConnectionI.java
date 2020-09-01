package service.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
@Repository
public interface ConnectionI {


    Connection getConnection() throws SQLException;
}
