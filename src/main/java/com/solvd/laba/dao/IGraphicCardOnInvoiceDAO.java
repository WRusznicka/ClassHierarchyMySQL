package com.solvd.laba.dao;

import com.solvd.laba.model.GraphicCardOnInvoice;

import java.util.List;

public interface IGraphicCardOnInvoiceDAO extends IBaseDao<GraphicCardOnInvoice> {
    @Override
    GraphicCardOnInvoice getEntityById(int id);

    @Override
    List<GraphicCardOnInvoice> getEntities();

    @Override
    void insert(GraphicCardOnInvoice graphicCardOnInvoice);

    @Override
    void update(int id, GraphicCardOnInvoice graphicCardOnInvoice);

    @Override
    void delete(int id);
}
