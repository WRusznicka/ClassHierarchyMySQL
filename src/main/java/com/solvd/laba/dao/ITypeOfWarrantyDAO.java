package com.solvd.laba.dao;

import com.solvd.laba.model.TypeOfWarranty;

import java.util.List;

public interface ITypeOfWarrantyDAO extends IBaseDao<TypeOfWarranty> {
    @Override
    TypeOfWarranty getEntityById(int id);

    @Override
    List<TypeOfWarranty> getEntities();

    @Override
    void insert(TypeOfWarranty typeOfWarranty);

    @Override
    void update(int id, TypeOfWarranty typeOfWarranty);

    @Override
    void delete(int id);
}
