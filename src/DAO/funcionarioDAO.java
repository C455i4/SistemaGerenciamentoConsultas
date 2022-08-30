/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entidades.Funcionario;
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
public class funcionarioDAO {
    private static String SQL_INSERT ="INSERT INTO funcionario (nome, cpf, email, telefone,dataadmissao, sexo ) VALUES (?,?,?,?,?,?)";
    private static String SQL_UPDATE="UPDATE funcionario SET nome=? , cpf=?, email=?, telefone=?, dataadmissao=?, sexo=? WHERE idfunc=?";
    private static String SQL_DELETE = "DELETE FROM funcionario WHERE idfunc=?";
    private static String SQL_SELECT = "SELECT * FROM funcionario";
    
    public static int cadastrar(Funcionario func){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, func.getNome());
            stmt.setString(2,  func.getCpf());
            stmt.setString(3,  func.getEmail());
            stmt.setString(4,  func.getTelefone());
            stmt.setString(5,  func.getDataadmissao());
            stmt.setString(6,  func.getSexo());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
    
    
    
    public static int alterar(Funcionario func){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
           stmt.setString(1, func.getNome());
            stmt.setString(2,  func.getCpf());
            stmt.setString(3,  func.getEmail());
            stmt.setString(4,  func.getTelefone());
            stmt.setString(5,  func.getDataadmissao());
            stmt.setString(6,  func.getSexo());
            stmt.setInt(7,func.getIdfunc());
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(funcionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return rs   ;
}
     public List<Funcionario> buscaNome(String nomepesq){
         
        List<Funcionario> lista = new ArrayList<>();
        
        String query;
        query = "{ call pesquisar_funcionario_sp(?) }";
        ResultSet resultado;
          
        try(
                Connection conn = BDConexao.getConnection();
                CallableStatement stmt = conn.prepareCall(query);
            ){
            
            stmt.setString(1, nomepesq);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                Funcionario f = new Funcionario();
                f.setIdfunc(resultado.getInt("idfunc"));
                f.setNome(resultado.getString("nome"));
                f.setCpf(resultado.getString("cpf"));
                f.setEmail(resultado.getString("email"));
                f.setTelefone(resultado.getString("telefone"));
                f.setDataadmissao(resultado.getString("dataadmissao"));
                f.setSexo(resultado.getString("sexo"));
                

                lista.add(f);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao listar medicos!");
//            System.out.println(ex.getMessage());
        }
          return lista;
     }
}
