package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Dados {
    private Statement stmt;
    public Connection conn;  
    
    
    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarSqlServer();
    }
    
    public void desconectar() throws SQLException {
        conn.close();
    }
    /*
    private Statement conectarSqlServer() throws ClassNotFoundException, SQLException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://DESKTOP-RNHNFJ0\\SQLEXPRESS:1433;DatabaseName=Locadora";
        String usuario = "projeto";
        String senha = "123";
        Class.forName(driver);
        //obtem uma conexao com o sgbd
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }
    */
    private Statement conectarSqlServer() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/locadora";
        String usuario = "root";
        String senha = "";
        Class.forName(driver);
        //obtem uma conexao com o sgbd
        conn = DriverManager.getConnection(url, usuario, senha);
        stmt = conn.createStatement();
        return stmt;
    }   
}


// localhots = conectar no pc de todo mundo, que tenha acesso ao nome do banco, login e senha.
