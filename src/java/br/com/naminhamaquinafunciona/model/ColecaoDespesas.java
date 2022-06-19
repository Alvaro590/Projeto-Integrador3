/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.naminhamaquinafunciona.model;

import br.com.naminhamaquinafunciona.model.interfaces.Container;
import br.com.naminhamaquinafunciona.model.interfaces.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class ColecaoDespesas implements Container {

    private List<Despesa> despesas = new ArrayList<>();

    ;

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    @Override
    public Iterator getIterator() {
        return new CollectionofDespesasIterate();
    }

    private class CollectionofDespesasIterate implements Iterator {

        int i;
        Despesa despesa = new Despesa();

        @Override
        public boolean hasNext() {
            return despesas.get(i) != null;
        }

        @Override
        public Despesa next() {
            if (this.hasNext()) {
                despesa = despesas.get(i);
                return despesa;
            }
            return null;
        }
    }
}
