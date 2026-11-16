package org.talentotech.model;

import java.util.List;

public class Pedido {
    private int id;
    private List<ItemPedido> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido() {
    }

    public Pedido(List<ItemPedido> items) {
        this.items = items;
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }
}
