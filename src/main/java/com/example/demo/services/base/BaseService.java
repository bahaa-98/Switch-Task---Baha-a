package com.example.demo.services.base;

import com.example.demo.domain.Driver;
import com.example.demo.domain.base.IEntity;
import com.example.demo.exceptions.BackEndException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.utils.ApiMessage;
import com.example.demo.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Transactional(readOnly = true)
public abstract class BaseService<T extends IEntity> implements IService<T>, Serializable {

    private static final long serialVersionUID = 1L;

    protected abstract JpaRepository<T, Long> getRepository();

    @Autowired
    protected ResourceBundleMessageSource messageSource;

    @Override
    @Transactional(readOnly = false)
    public T add(T entity) {
        preAdd(entity);
        getRepository().save(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public T update(T entity, Long id) {
        preUpdate(entity,id);
        getRepository().save(entity);
        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public T delete(Long id) {
        T entity = getRepository().getById(id);

        if(!getRepository().existsById((Long) entity.getId()))
            throw new ValidationException(Helper.getLocaleMessage("Invalid.id",messageSource));

        else

            getRepository().deleteById(id);

        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public T findOne(Long id) {
        T entity = getRepository().getById(id);

        if(!getRepository().existsById((Long) entity.getId()))
            throw new ValidationException(Helper.getLocaleMessage("Invalid.id",messageSource));

        return entity;
    }

    @Override
    @Transactional(readOnly = false)
    public void softDelete(Long id) {
        T entity = getRepository().getById(id);

        if(!getRepository().existsById((Long) entity.getId()))
            throw new ValidationException(Helper.getLocaleMessage("Invalid.id", messageSource));
        else

            entity.setActive(false);
            getRepository().save(entity);

    }

    @Override
    @Transactional(readOnly = false)
    public void preAdd(T entity) {
        entity.setDateCreated(ZonedDateTime.now());
    }

    public void preUpdate(T entity,Long id){
        entity.setId(id);
    }
}
