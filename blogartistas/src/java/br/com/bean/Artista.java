/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bean;

public class Artista {
    private int id;
    private String nome;
    private String biografia;
    private int estiloId;
    private String estiloNome;

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public int getEstiloId() { return estiloId; }
    public void setEstiloId(int estiloId) { this.estiloId = estiloId; }

    public String getEstiloNome() { return estiloNome; }
    public void setEstiloNome(String estiloNome) { this.estiloNome = estiloNome; }

private String foto;
public String getFoto() { return foto; }
public void setFoto(String foto) { this.foto = foto; }
}