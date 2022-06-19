/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;

/**
 *
 * @author Usuário
 */
public class Banco {
    
    private int id;
    private String descricao;
    
    public Banco(){
        
    }
    
    public Banco(String descricao) {
        this.descricao = descricao;
    }

    public Banco(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    
    
    public int getId() {
        return id;
    }   
    
    public void setId(int id) {
        this.id= id;
    } 

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ", descricao=" + descricao + '}';
    }

    
    
    
    
}
