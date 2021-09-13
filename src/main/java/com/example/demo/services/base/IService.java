package com.example.demo.services.base;

import com.example.demo.domain.base.IEntity;

public interface IService<T extends IEntity> {

    T add(T entity);

    T update(T entity, Long id);

    T delete(Long id);

    T findOne(Long id);

    void softDelete(Long id);

    void preAdd(T entity);

}
