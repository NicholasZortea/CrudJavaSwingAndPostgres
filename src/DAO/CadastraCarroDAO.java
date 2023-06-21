package DAO;
import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class CadastraCarroDAO {
    private String modelo;
    private String placa;
    private String ano;
    private String cor;
    private String fabricante;
    private double preco;
    private String sql = "INSERT INTO carro (modelo, placa, ano, cor, fabricante, preco) VALUES (?, ?, ?, ?, ?, ?)";
    private ConectionFactory conection;
    public CadastraCarroDAO(){
        this.conection = new ConectionFactory();
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void cadastraCarro(){
        
        try{
        Connection conexao = this.conection.criaConexao();
        PreparedStatement insere = conexao.prepareStatement(sql);
        insere.setString(1, modelo);
        insere.setString(2, placa);
        insere.setString(3, ano);
        insere.setString(4, cor);
        insere.setString(5, fabricante);
        insere.setDouble(6, preco);
        insere.execute();
        System.out.println("Carro cadastrado com sucesso!");
        insere.close();
        conexao.close();
        
        }catch(SQLException e){
            System.out.println("deu problema na insercao");
            e.printStackTrace();
        }     
    }
    
}
