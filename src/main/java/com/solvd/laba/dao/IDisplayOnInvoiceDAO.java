package com.solvd.laba.dao;

import com.solvd.laba.model.DisplayOnInvoice;

import java.util.List;

public interface IDisplayOnInvoiceDAO extends IBaseDao<DisplayOnInvoice> {
    @Override
    DisplayOnInvoice getEntityById(int id);

    @Override
    List<DisplayOnInvoice> getEntities();

    @Override
    void insert(DisplayOnInvoice displayOnInvoice);

    @Override
    void update(int id, DisplayOnInvoice displayOnInvoice);

    @Override
    void delete(int id);
}
