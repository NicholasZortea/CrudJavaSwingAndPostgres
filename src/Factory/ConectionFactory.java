package Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
    private String url = "jdbc:postgresql://localhost:5432/banco";
    private String user = "postgres";
    private String password = "1234";
    
    
    public Connection criaConexao(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("conexao bem sucedida!");
            return connection;
        }catch(SQLException e){
            System.out.println("deu erro");
            throw new RuntimeException(e);
        }
}
}
