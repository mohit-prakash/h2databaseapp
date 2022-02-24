package com.mps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mps.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
