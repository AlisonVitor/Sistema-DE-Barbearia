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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastro;

/**
 *
 * @author HARD INFO
 */
public class CadastroControlador {
    
    private Cadastro view;

    public CadastroControlador(Cadastro view) {
        this.view = view;
    }

    public void salvaUsuario(){
        
        String usuario =  view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioXandi = new Usuario(usuario, senha);
        
        try {
         
            
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuariodao = new UsuarioDAO(conexao);
            usuariodao.insert(usuarioXandi);
            
            JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
