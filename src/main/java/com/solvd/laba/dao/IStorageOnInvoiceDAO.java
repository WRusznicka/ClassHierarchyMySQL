package com.solvd.laba.dao;

import com.solvd.laba.model.StorageOnInvoice;

import java.util.List;

public interface IStorageOnInvoiceDAO extends IBaseDao<StorageOnInvoice> {
    @Override
    StorageOnInvoice getEntityById(int id);

    @Override
    List<StorageOnInvoice> getEntities();

    @Override
    void insert(StorageOnInvoice storageOnInvoice);

    @Override
    void update(int id, StorageOnInvoice storageOnInvoice);

    @Override
    void delete(int id);
}
