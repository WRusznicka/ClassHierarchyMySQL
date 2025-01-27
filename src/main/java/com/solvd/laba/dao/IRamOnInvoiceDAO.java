package com.solvd.laba.dao;

import com.solvd.laba.model.RAMOnInvoice;

import java.util.List;

public interface IRamOnInvoiceDAO extends IBaseDao<RAMOnInvoice> {
    @Override
    RAMOnInvoice getEntityById(int id);

    @Override
    List<RAMOnInvoice> getEntities();

    @Override
    void insert(RAMOnInvoice ramOnInvoice);

    @Override
    void update(int id, RAMOnInvoice ramOnInvoice);

    @Override
    void delete(int id);
}
