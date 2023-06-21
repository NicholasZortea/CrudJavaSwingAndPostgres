/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author Nicholas
 */
public class AtualizaCarroDAO {
    private ConectionFactory conexao;
    private int id;
    private String sql = "Update carro set modelo = ?, placa = ?, ano = ?, cor = ?, fabricante = ?, preco = ? WHERE id = ?";
    private Carro carro;
    public AtualizaCarroDAO(){
        this.conexao = new ConectionFactory();
    }
    public void fazUpdate(){
        try{
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
}
