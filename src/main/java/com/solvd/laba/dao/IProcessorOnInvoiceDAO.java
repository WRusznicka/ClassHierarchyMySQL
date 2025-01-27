package com.solvd.laba.dao;

import com.solvd.laba.model.ProcessorOnInvoice;

import java.util.List;

public interface IProcessorOnInvoiceDAO extends IBaseDao<ProcessorOnInvoice> {
    @Override
    ProcessorOnInvoice getEntityById(int id);

    @Override
    List<ProcessorOnInvoice> getEntities();

    @Override
    void insert(ProcessorOnInvoice processorOnInvoice);

    @Override
    void update(int id, ProcessorOnInvoice processorOnInvoice);

    @Override
    void delete(int id);
}
