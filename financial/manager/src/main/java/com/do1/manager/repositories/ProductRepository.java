package com.do1.manager.repositories;

import javax.persistence.criteria.CriteriaUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.do1.entity.Product;



public interface ProductRepository  extends CrudRepository<Product, String>, JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

}
