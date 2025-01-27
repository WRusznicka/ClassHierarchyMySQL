package com.solvd.laba.dao;

import com.solvd.laba.model.BatteryOnInvoice;

import java.util.List;

public interface IBatteryOnInvoiceDAO extends IBaseDao<BatteryOnInvoice> {
    @Override
    BatteryOnInvoice getEntityById(int id);

    @Override
    List<BatteryOnInvoice> getEntities();

    @Override
    void insert(BatteryOnInvoice batteryOnInvoice);

    @Override
    void update(int id, BatteryOnInvoice batteryOnInvoice);

    @Override
    void delete(int id);
}
