/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Nicholas
 */
public class Geral extends javax.swing.JFrame{
    
    Object[][] data = null;
    String[] colunas = {"id", "modelo","placa","ano","cor","fabricante","preco"};
    JTable tabela = new JTable(data, colunas);
    JScrollPane scrollPane = new JScrollPane(tabela);
    
    
}
