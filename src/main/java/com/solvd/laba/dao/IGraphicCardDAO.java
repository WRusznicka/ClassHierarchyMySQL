package com.solvd.laba.dao;

import com.solvd.laba.model.GraphicCard;

import java.util.List;

public interface IGraphicCardDAO extends IBaseDao<GraphicCard> {
    @Override
    GraphicCard getEntityById(int id);

    @Override
    List<GraphicCard> getEntities();

    @Override
    void insert(GraphicCard graphicCard);

    @Override
    void update(int id, GraphicCard graphicCard);

    @Override
    void delete(int id);
}
