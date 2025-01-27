package com.solvd.laba.dao;

import com.solvd.laba.model.ServiceOnInvoice;

import java.util.List;

public interface IServiceOnInvoiceDAO extends IBaseDao<ServiceOnInvoice> {
    @Override
    ServiceOnInvoice getEntityById(int id);

    @Override
    List<ServiceOnInvoice> getEntities();

    @Override
    void insert(ServiceOnInvoice serviceOnInvoice);

    @Override
    void update(int id, ServiceOnInvoice serviceOnInvoice);

    @Override
    void delete(int id);
}
