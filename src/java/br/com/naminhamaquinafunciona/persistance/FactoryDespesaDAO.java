/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.persistance;

import br.com.naminhamaquinafunciona.model.Despesa;

/**
 *
 * @author Usuário
 */
public class FactoryDespesaDAO {

    public void FactoryExecutaMetodo(String metodo, Despesa despesa) {
        DespesaAbstract nova;
        if (metodo.equalsIgnoreCase("inserir")) {
            nova = new DespesaInserir();
            nova.executarMetodo(despesa);
        }
        if (metodo.equalsIgnoreCase("alterar")) {
            nova = new DespesaAlterar();
            nova.executarMetodo(despesa);
        }
        if (metodo.equalsIgnoreCase("remover")) {
            nova = new DespesaRemover();
            nova.executarMetodo(despesa);
        }

    }

}
