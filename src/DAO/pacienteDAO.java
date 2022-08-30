/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entidades.Paciente;
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
public class pacienteDAO {
    
    private static String SQL_INSERT ="INSERT INTO paciente (nome, cpf, email, sexo, telefone, datanasc ) VALUES (?,?,?,?,?,?)";
    private static String SQL_UPDATE="UPDATE paciente SET nome=? , cpf=?, email=?, sexo=?, telefone=?, datanasc=? WHERE idpaciente=?";
    private static String SQL_DELETE = "DELETE FROM paciente WHERE idpaciente=?";
    private static String SQL_SELECT = "SELECT * FROM paciente";
    
    
    public static int cadastrar(Paciente pac){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, pac.getNome());
            stmt.setString(2,  pac.getCpf());
            stmt.setString(3,  pac.getEmail());
            stmt.setString(4,  pac.getSexo());
            stmt.setString(5,  pac.getTelefone());
            stmt.setString(6,  pac.getDatanasc());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(pacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
    
    
    
    public static int alterar(Paciente pac){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pac.getNome());
            stmt.setString(2,  pac.getCpf());
            stmt.setString(3,  pac.getEmail());
            stmt.setString(4,  pac.getSexo());
            stmt.setString(5,  pac.getTelefone());
            stmt.setString(6,  pac.getDatanasc());
            stmt.setInt(7,pac.getIdpaciente());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(pacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(pacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(pacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return rs   ;
}
     public List<Paciente> buscaNome(String nomepesq){
         
        List<Paciente> lista = new ArrayList<>();
        
        String query;
        query = "{ call pesquisar_pacientes_sp(?) }";
        ResultSet resultado;
          
        try(
                Connection conn = BDConexao.getConnection();
                CallableStatement stmt = conn.prepareCall(query);
            ){
            
            stmt.setString(1, nomepesq);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                Paciente pac = new Paciente();
                pac.setIdpaciente(resultado.getInt("idpaciente"));
                pac.setNome(resultado.getString("nome"));
                pac.setCpf(resultado.getString("cpf"));
                pac.setEmail(resultado.getString("email"));
                pac.setSexo(resultado.getString("sexo"));
                pac.setTelefone(resultado.getString("telefone"));
                pac.setDatanasc(resultado.getString("datanasc"));

                lista.add(pac);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao listar pacientes");
//            System.out.println(ex.getMessage());
        }
          return lista;
     }
}
