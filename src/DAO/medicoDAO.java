/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Medico;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miriam
 */
public class medicoDAO {
    private static String SQL_INSERT ="INSERT INTO medico (nome, crm, email, telefone,especializacao ) VALUES (?,?,?,?,?)";
    private static String SQL_UPDATE="UPDATE medico SET nome=? , crm=?, email=?, telefone=?, especializacao=? WHERE idmedico=?";
    private static String SQL_DELETE = "DELETE FROM medico WHERE idmedico=?";
    private static String SQL_SELECT = "SELECT * FROM medico";
    
    public static int cadastrar(Medico med){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, med.getNome());
            stmt.setString(2,  med.getCrm());
            stmt.setString(3,  med.getEmail());
            stmt.setString(4,  med.getTelefone());
            stmt.setString(5,  med.getEspecializacao());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(medicoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
    
    
    
    public static int alterar(Medico med){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
             stmt.setString(1, med.getNome());
            stmt.setString(2,  med.getCrm());
            stmt.setString(3,  med.getEmail());
            stmt.setString(4,  med.getTelefone());
            stmt.setString(5,  med.getEspecializacao());
            stmt.setInt(6,med.getIdmedico());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(medicoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
    
    
    
     public static int excluir(int id){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id);
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(medicoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
     public static  ResultSet consulta(){
        Connection con = BDConexao.getConnection();
        ResultSet rs =null;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_SELECT);
            
            
            rs =stmt.executeQuery();
            
        } catch (SQLException ex) {
             Logger.getLogger(medicoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return rs   ;
}
     public List<Medico> buscaNome(String nomepesq){
         
        List<Medico> lista = new ArrayList<>();
        
        String query;
        query = "{ call pesquisar_medico_sp(?) }";
        ResultSet resultado;
          
        try(
                Connection conn = BDConexao.getConnection();
                CallableStatement stmt = conn.prepareCall(query);
            ){
            
            stmt.setString(1, nomepesq);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                Medico med = new Medico();
                med.setIdmedico(resultado.getInt("idmedico"));
                med.setNome(resultado.getString("nome"));
                med.setCrm(resultado.getString("crm"));
                med.setEmail(resultado.getString("email"));
                med.setTelefone(resultado.getString("telefone"));
                med.setEspecializacao(resultado.getString("especializacao"));
                

                lista.add(med);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao listar medicos!");
//            System.out.println(ex.getMessage());
        }
          return lista;
     }
}
