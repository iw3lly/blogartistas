/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;

/**
 *
 * @author W3lly
 */
import br.com.bean.Post;
import java.sql.*;
import java.util.*;

public class PostDAO {
    public void cadastrar(Post post) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO posts (titulo, conteudo, usuario_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, post.getTitulo());
        stmt.setString(2, post.getConteudo());
        stmt.setInt(3, post.getUsuarioId());
        stmt.execute();
        con.close();
    }

    public List<Post> listar() throws Exception {
        List<Post> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT p.*, u.nome AS autor FROM posts p JOIN usuarios u ON p.usuario_id = u.id ORDER BY p.data_postagem DESC";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Post p = new Post();
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("titulo"));
            p.setConteudo(rs.getString("conteudo"));
            p.setData(rs.getString("data_postagem"));
            p.setUsuarioId(rs.getInt("usuario_id"));
            p.setAutor(rs.getString("autor"));
            lista.add(p);
        }
        con.close();
        return lista;
    }

    public void excluir(int id, int usuarioId) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM posts WHERE id = ? AND usuario_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setInt(2, usuarioId);
        stmt.execute();
        con.close();
    }

    public void atualizar(Post post) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "UPDATE posts SET titulo = ?, conteudo = ? WHERE id = ? AND usuario_id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, post.getTitulo());
        stmt.setString(2, post.getConteudo());
        stmt.setInt(3, post.getId());
        stmt.setInt(4, post.getUsuarioId());
        stmt.execute();
        con.close();
    }

    public Post buscarPorId(int id) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM posts WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Post p = new Post();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("titulo"));
            p.setConteudo(rs.getString("conteudo"));
            p.setUsuarioId(rs.getInt("usuario_id"));
        }
        con.close();
        return p;
    }
}
