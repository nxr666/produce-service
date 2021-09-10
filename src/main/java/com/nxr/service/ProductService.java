package com.nxr.service;

import com.nxr.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    Product findById(int id);
}
