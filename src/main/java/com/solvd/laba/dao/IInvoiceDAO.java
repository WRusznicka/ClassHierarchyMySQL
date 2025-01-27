package com.solvd.laba.dao;

import com.solvd.laba.model.Invoice;

import java.util.List;

public interface IInvoiceDAO extends IBaseDao<Invoice> {
    @Override
    Invoice getEntityById(int id);

    @Override
    List<Invoice> getEntities();

    @Override
    void insert(Invoice invoice);

    @Override
    void update(int id, Invoice invoice);

    @Override
    void delete(int id);
}
