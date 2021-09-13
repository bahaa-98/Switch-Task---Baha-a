package com.example.demo.domain.base;

import java.io.Serializable;
import java.time.ZonedDateTime;

public interface IEntity {

    Serializable getId();

    void setId(Long id);

    ZonedDateTime getDateCreated();

    void setDateCreated(ZonedDateTime dateCreated);

    Boolean getActive();

    void setActive(Boolean active);
}
