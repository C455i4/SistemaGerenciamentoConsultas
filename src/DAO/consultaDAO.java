/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Consulta;
import Entidades.Medico;
import Entidades.Paciente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miriam
 */
public class consultaDAO {
    private static String SQL_INSERT ="INSERT INTO consulta (dataatend, horario, idpaciente, idmedico ) VALUES (?,?,?,?)";
    private static String SQL_UPDATE="UPDATE consulta SET dataatend=?, horario=?, idpaciente=?, idmedico=? WHERE idconsulta=?";
    private static String SQL_DELETE = "DELETE FROM consulta WHERE idconsulta=?";
    private static String SQL_SELECT = "SELECT * FROM consulta INNER JOIN paciente ON paciente.idpaciente = consulta.idpaciente INNER JOIN medico ON medico.idmedico = consulta.idmedico";
    
    public static int cadastrar(Consulta c){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, c.getDataatend());
            stmt.setString(2, c.getHorario());
            stmt.setInt(3, c.getPaciente().getIdpaciente());
            stmt.setInt(4, c.getMedico().getIdmedico());
            
            
            result =stmt.executeUpdate();
            
        } catch (SQLException ex) {
             Logger.getLogger(consultaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
   public static int alterar(Consulta c){
        Connection con = BDConexao.getConnection();
        int result =0;
        
        try{
            PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, c.getDataatend());
            stmt.setString(2, c.getHorario());
            stmt.setInt(3, c.getPaciente().getIdpaciente());
            stmt.setInt(4, c.getMedico().getIdmedico());
            stmt.setInt(5,c.getIdconsulta());
            
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
             Logger.getLogger(consultaDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return result;
}
     public List<Consulta> ListaTodas(){
          Connection con = BDConexao.getConnection();
         
          List<Consulta> lista = new ArrayList<>();
          String sql = "SELECT * FROM consulta INNER JOIN paciente ON paciente.idpaciente = consulta.idpaciente INNER JOIN medico ON medico.idmedico = consulta.idmedico";
     
          try(PreparedStatement stmt = con.prepareStatement(sql)){
              ResultSet resultado = stmt.executeQuery();
              while(resultado.next()){
                  Consulta c = new Consulta();
                  c.setIdconsulta(resultado.getInt("consulta.idconsulta"));
                  c.setDataatend(resultado.getString("consulta.dataatend"));
                  c.setHorario(resultado.getString("consulta.horario"));
                  
                  Medico m = new Medico();
                  m.setIdmedico(resultado.getInt("medico.idmedico"));
                  m.setNome(resultado.getString("medico.nome"));
                  c.setMedico(m);
                  
                  Paciente p = new Paciente();
                  p.setIdpaciente(resultado.getInt("paciente.idpaciente"));
                  p.setNome(resultado.getString("paciente.nome"));
                  c.setPaciente(p);
                  
                  lista.add(c);
              }
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, "Erro ao listar consultas");
          }
          return lista;
     }
     public List<Consulta> buscaData(String datapesq){
          Connection con = BDConexao.getConnection();
         
          List<Consulta> lista = new ArrayList<>();
          String sql = "SELECT * FROM consulta INNER JOIN paciente ON paciente.idpaciente = consulta.idpaciente INNER JOIN medico ON medico.idmedico = consulta.idmedico WHERE consulta.dataatend = ?";
     
          try(PreparedStatement stmt = con.prepareStatement(sql)){
              stmt.setString(1, datapesq);
              ResultSet resultado = stmt.executeQuery();
              while(resultado.next()){
                  Consulta c = new Consulta();
                  c.setIdconsulta(resultado.getInt("consulta.idconsulta"));
                  c.setDataatend(resultado.getString("consulta.dataatend"));
                  c.setHorario(resultado.getString("consulta.horario"));
                  
                  Medico m = new Medico();
                  m.setIdmedico(resultado.getInt("medico.idmedico"));
                  m.setNome(resultado.getString("medico.nome"));
                  c.setMedico(m);
                  
                  Paciente p = new Paciente();
                  p.setIdpaciente(resultado.getInt("paciente.idpaciente"));
                  p.setNome(resultado.getString("paciente.nome"));
                  c.setPaciente(p);
                  
                  lista.add(c);
              }
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, "Erro ao listar consultas");
          }
          return lista;
     }
     
}
