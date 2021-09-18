package com.example.demo.controller.base;

import com.example.demo.domain.base.IEntity;
import com.example.demo.model.base.BaseModel;

import java.util.List;

public interface IBaseController<E extends BaseModel, T extends IEntity>{

    E modelizeEntity(T entity);

    List<E> modelizeList(List<T> entities);
}
