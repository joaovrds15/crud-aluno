package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection conexao;
	
	public static Properties getProperties() throws IOException {
		Properties propriedades = new Properties();
		FileInputStream file = new FileInputStream("./properties/db.properties");
		propriedades.load(file);
		return propriedades;
	}
	
	public static Connection getConexao() throws IOException, SQLException {
		if (conexao == null) {
			Properties p = DB.getProperties();
			conexao = DriverManager.getConnection(p.getProperty("host"),p.getProperty("user"),p.getProperty("password"));
		}
		return conexao;
	}
	
	public static void closeConexao() throws SQLException {
		if (conexao != null) {
			conexao.close();
		}
	}
}
