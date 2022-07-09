/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.TelaLogin;
import view.Menu;

/**
 *
 * @author HARD INFO
 */
public class LoginControlador {
    private TelaLogin view;

    public LoginControlador(TelaLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Buscar usuario da view
        
        String usuario =  view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        
         Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuariodao = new UsuarioDAO(conexao);
          boolean existe =  usuariodao.existePorUsuarioESenha(usuarioAutenticar);
          
          //se existe permitir entrada no sistema
          
          if(existe){
              Menu telademenu = new Menu();
              telademenu.setVisible(true);
          }else{
              JOptionPane.showMessageDialog(view, "Usuario ou Senha Invalidos");
          }
        
        
  
    }
    
    
    
}
