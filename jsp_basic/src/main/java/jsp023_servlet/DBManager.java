package jsp023_servlet;

import java.sql.Connection;
import javax.naming.*;
import javax.sql.*;

public class DBManager {
	public static Connection conn;

	public DBManager() { super(); }
	
	public Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mbasic");
			conn = ds.getConnection();
		}catch(Exception e) {e.printStackTrace();}
		return conn;
		
	}

}
