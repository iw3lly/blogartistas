/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bean;

/**
 *
 * @author W3lly
 */
public class Post {
    private int id;
    private String titulo;
    private String conteudo;
    private String data;
    private int usuarioId;
    private String autor;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
}
