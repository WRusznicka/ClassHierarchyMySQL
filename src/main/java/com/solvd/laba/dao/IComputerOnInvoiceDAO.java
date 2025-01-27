package com.solvd.laba.dao;

import com.solvd.laba.model.ComputerOnInvoice;

import java.util.List;

public interface IComputerOnInvoiceDAO extends IBaseDao<ComputerOnInvoice> {
    @Override
    ComputerOnInvoice getEntityById(int id);

    @Override
    List<ComputerOnInvoice> getEntities();

    @Override
    void insert(ComputerOnInvoice computerOnInvoice);

    @Override
    void update(int id, ComputerOnInvoice computerOnInvoice);

    @Override
    void delete(int id);
}
