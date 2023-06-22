/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author Nicholas
 */
public class CarroDAO {
    private ConectionFactory conexao;
    private int id;
    private String sql;
    private Carro carro;
    
     public CarroDAO(){
        this.conexao = new ConectionFactory();
    }
     
     public void fazUpdate(){
        try{
            this.sql = "Update carro set modelo = ?, placa = ?, ano = ?, cor = ?, fabricante = ?, preco = ? WHERE id = ?";
            Connection conn = this.conexao.criaConexao();
            PreparedStatement sql = conn.prepareStatement(this.sql);
            sql.setString(1, this.carro.getModelo());
            sql.setString(2, this.carro.getPlaca());
            sql.setString(3, this.carro.getAno());
            sql.setString(4, this.carro.getCor());
            sql.setString(5, this.carro.getFabricante());
            sql.setDouble(6, this.carro.getPreco());
            sql.setInt(7, this.id);
            sql.execute();
            
            sql.close();
            conn.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o cadastro!");
        }
        
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCarro(Carro carro){
        this.carro = carro;
    }
    
    public void cadastraCarro(){
        this.sql = "INSERT INTO carro (modelo, placa, ano, cor, fabricante, preco) VALUES (?, ?, ?, ?, ?, ?)";
        try{
        Connection conn = this.conexao.criaConexao();
        PreparedStatement insere = conn.prepareStatement(sql);
        insere.setString(1, this.carro.getModelo());
        insere.setString(2, this.carro.getPlaca());
        insere.setString(3, this.carro.getAno());
        insere.setString(4, this.carro.getCor());
        insere.setString(5, this.carro.getFabricante());
        insere.setDouble(6, this.carro.getPreco());
        insere.execute();
        System.out.println("Carro cadastrado com sucesso!");
        insere.close();
        conn.close();
        
        }catch(SQLException e){
            System.out.println("deu problema na insercao");
            e.printStackTrace();
        }     
    }
    
    public Carro consulta(){
        try{
            Carro novoCarro = new Carro();
            Connection conn = conexao.criaConexao();
            PreparedStatement statement = conn.prepareStatement("SELECT * from carro WHERE id = ?");
            statement.setInt(1, this.id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            novoCarro.setAno(rs.getString("ano"));
            novoCarro.setCor(rs.getString("cor"));
            novoCarro.setPlaca(rs.getString("placa"));
            novoCarro.setFabricante(rs.getString("fabricante"));
            novoCarro.setPreco(rs.getDouble("preco"));
            novoCarro.setModelo(rs.getString("modelo"));
            System.out.println("Consulta realizada com sucesso!");
            
            conn.close();
            statement.close();
            rs.close();
            return novoCarro;
            
        }catch(Exception e){
            System.out.println("Deu bo");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Esse id não existe!");
            
        }
        return null;
    }
    public void deletar(){
        try{
        Connection conn = this.conexao.criaConexao();
        PreparedStatement sql = conn.prepareStatement("delete from carro where id="+this.id);
        sql.execute();
        JOptionPane.showMessageDialog(null, "Delecao concluida com sucesso!");
        conn.close();
        sql.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "nao foi possível deletar o carro de id "+this.id);
        }
        
    }
    
    public ArrayList<ArrayList<String>> matrizTabela(){
        ArrayList<ArrayList<String>> matriz = new ArrayList<>();
        
        try{
            Connection conn = this.conexao.criaConexao();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM carro");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ArrayList<String> arrayString = new ArrayList<>();
            for(int i = 1; i<=7; i++){
                arrayString.add(String.valueOf(rs.getString(i)));
                
            }
            matriz.add(arrayString);
            }
            System.out.println("A consulta deu certo!");
            conn.close();
            statement.close();
            rs.close();
            return matriz;
            
        }catch(Exception e){
            System.out.println("DEU BO");
            
            e.printStackTrace();
        }
        
        
        return matriz;
    }
}
