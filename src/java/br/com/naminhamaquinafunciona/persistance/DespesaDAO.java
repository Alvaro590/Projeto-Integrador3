/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.ColecaoDespesas;
import br.com.naminhamaquinafunciona.model.Despesa;
import br.com.naminhamaquinafunciona.model.interfaces.Iterator;
import br.com.naminhamaquinafunciona.validation.SqlData;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class DespesaDAO {
    
    private Connection connection;
    
    public DespesaDAO() {
        this.connection = Conexao.getConnection();
    }
    
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public Despesa retornaDespesaPorId(int id) {
        try {
            String sql = "SELECT * FROM despesa WHERE id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Despesa obj = new Despesa(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valor"), rs.getDate("data_Despesa"), rs.getInt("num_conta"), rs.getInt("num_cartao"));
                return obj;
            }
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Despesa> imprimirDespesas(List<Despesa> lista) {
        SqlData padronizador = new SqlData();
        ColecaoDespesas nome = new ColecaoDespesas();
        nome.setDespesas(lista);
        int i = 1;
        List<Despesa> listaFormatada = new ArrayList<Despesa>();
        for (Iterator iter = nome.getIterator(); iter.hasNext();) {
            Despesa despesa = (Despesa) iter.next();            
            despesa.setData(padronizador.toPrint(despesa.getData()));


        }
        return listaFormatada;
    }
    
    public List<Despesa> listarDespesa() {
        List<Despesa> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM despesa";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Despesa obj = new Despesa();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setValor(rs.getDouble("valor"));
                obj.setData(rs.getDate("data_despesa"));
                obj.setNumConta(rs.getInt("num_conta"));
                obj.setNumCartao(rs.getInt("num_cartao"));
                lista.add(obj);
            }
            s.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DespesaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void inserirDespesa(Despesa despesa) {

     
        try {
            String sql = "INSERT INTO despesa (id, descricao, valor, data_despesa, num_conta, num_cartao) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, despesa.getId());
            ps.setString(2, despesa.getDescricao());
            ps.setDouble(3, despesa.getValor());
            ps.setDate(4, despesa.getData());
            ps.setInt(5, despesa.getNumConta());
            ps.setInt(6, despesa.getNumCartao());
            System.out.println(despesa.getId() + " " + despesa.getDescricao() + " " + despesa.getValor() + " " + despesa.getData() + " " + despesa.getNumConta() + " " + despesa.getNumCartao());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DespesaInserir.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
    
}
