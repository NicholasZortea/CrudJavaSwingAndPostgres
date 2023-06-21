package DAO;
import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Carro;

public class ConsultaCarroDAO {
    private int ID;
    private ConectionFactory conexao;
    public ConsultaCarroDAO(){
        this.conexao = new ConectionFactory();
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Carro consulta(){
        Carro carro = new Carro();
        
        try{
            Connection conn = conexao.criaConexao();
            PreparedStatement sql = conn.prepareStatement("select * from carro WHERE id ="+this.ID);
            ResultSet rs = sql.executeQuery();
            rs.next();
            carro.setAno(rs.getString("ano"));
            carro.setCor(rs.getString("cor"));
            carro.setPlaca(rs.getString("placa"));
            carro.setFabricante(rs.getString("fabricante"));
            carro.setPreco(rs.getDouble("preco"));
            carro.setModelo(rs.getString("modelo"));
            System.out.println("Consulta realizada com sucesso!");
            conn.close();
            sql.close();
            rs.close();
            return carro;
        }catch(Exception e){
            System.out.println("Deu bo");
            JOptionPane.showMessageDialog(null, "Esse id não existe!");
            
        }
        return null;
    }
}
