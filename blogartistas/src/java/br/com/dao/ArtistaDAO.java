/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;



import br.com.bean.Artista;
import java.sql.*;
import java.util.*;

public class ArtistaDAO {
    public void cadastrar(Artista artista) throws Exception {
    Connection con = Conexao.conectar();
    String sql = "INSERT INTO artistas (nome, biografia, estilo_id, foto) VALUES (?, ?, ?, ?)";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, artista.getNome());
    stmt.setString(2, artista.getBiografia());
    stmt.setInt(3, artista.getEstiloId());
    stmt.setString(4, artista.getFoto());
    stmt.execute();
    con.close();
}


    public List<Artista> listar() throws Exception {
        List<Artista> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT a.id, a.nome, a.biografia, e.nome AS estilo_nome " +
                     "FROM artistas a JOIN estilos e ON a.estilo_id = e.id ORDER BY a.nome";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Artista a = new Artista();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setBiografia(rs.getString("biografia"));
            a.setEstiloNome(rs.getString("estilo_nome"));
            lista.add(a);
        }
        con.close();
        return lista;
    }
    public void excluir(int id) throws Exception {
    Connection con = Conexao.conectar();
    String sql = "DELETE FROM artistas WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, id);
    stmt.execute();
    con.close();
}

public void atualizar(Artista artista) throws Exception {
    Connection con = Conexao.conectar();
    String sql = "UPDATE artistas SET nome = ?, biografia = ?, estilo_id = ? WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, artista.getNome());
    stmt.setString(2, artista.getBiografia());
    stmt.setInt(3, artista.getEstiloId());
    stmt.setInt(4, artista.getId());
    stmt.execute();
    con.close();
}

public Artista buscarPorId(int id) throws Exception {
    Connection con = Conexao.conectar();
    String sql = "SELECT * FROM artistas WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();
    Artista a = new Artista();
    if (rs.next()) {
        a.setId(rs.getInt("id"));
        a.setNome(rs.getString("nome"));
        a.setBiografia(rs.getString("biografia"));
        a.setEstiloId(rs.getInt("estilo_id"));
        a.setFoto(rs.getString("foto"));
    }
    con.close();
    return a;
}

}

