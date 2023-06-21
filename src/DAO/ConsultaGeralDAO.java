package DAO;

import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nicholas
 */
public class ConsultaGeralDAO {
    private ConectionFactory conexao;

    public ConsultaGeralDAO(){
        this.conexao = new ConectionFactory();
    }
    
    public ArrayList<ArrayList<String>> matrizTabela(){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        
        try{
            Connection conn = this.conexao.criaConexao();
            PreparedStatement sql = conn.prepareStatement("SELECT * FROM carro");
            ResultSet rs = sql.executeQuery();
            while (rs.next()){
                ArrayList<String> arrayString = new ArrayList<>();
            for(int i = 1; i<=7; i++){
                arrayString.add(String.valueOf(rs.getString(i)));
                
            }
            matriz.add(arrayString);
            }
            System.out.println("A consulta deu certo!");
            return matriz;
            
        }catch(Exception e){
            System.out.println("DEU BO");
            
            e.printStackTrace();
        }
        
        
        return matriz;
    }
}