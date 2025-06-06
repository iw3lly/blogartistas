/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;


import br.com.bean.Usuario;
import br.com.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public void cadastrar(Usuario usuario) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.execute();
        con.close();
    }
    
    public Usuario login(String email, String senha) throws Exception {
    Connection con = Conexao.conectar();
    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, email);
    stmt.setString(2, senha);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));
        return usuario;
    }
    return null;
}

}
