/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dao;
import br.com.bean.Estilo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author W3lly
 */


public class EstiloDAO {
    public void cadastrar(Estilo estilo) throws Exception {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO estilos (nome) VALUES (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, estilo.getNome());
        stmt.execute();
        con.close();
    }

    public List<Estilo> listar() throws Exception {
        List<Estilo> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM estilos ORDER BY nome";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estilo e = new Estilo();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            lista.add(e);
        }
        con.close();
        return lista;
    }
}
