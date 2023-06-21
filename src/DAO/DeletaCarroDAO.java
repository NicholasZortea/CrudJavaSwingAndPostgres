/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeletaCarroDAO {
    ConectionFactory conexao;
    int idDeletar;
    
    public DeletaCarroDAO(){
        this.conexao = new ConectionFactory();
    }
    
    public void setIdDeletar(int id){
        this.idDeletar = id;
    }
    
    public void deletar(){
        try{
        Connection conn = this.conexao.criaConexao();
        PreparedStatement sql = conn.prepareStatement("delete from carro where id="+this.idDeletar);
        sql.execute();
        JOptionPane.showMessageDialog(null, "Delecao concluida com sucesso!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "nao foi possível deletar o carro de id "+this.idDeletar);
        }
        
    }
    
    
}
