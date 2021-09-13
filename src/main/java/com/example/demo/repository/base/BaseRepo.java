package com.example.demo.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepo <T, ID extends Serializable> extends JpaRepository<T,ID>, PagingAndSortingRepository<T,ID> {

}
