package com.nxr.service.impl;

import com.nxr.ProduceService;
import com.nxr.bean.Product;
import com.nxr.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer,Product> daoMap = new HashMap<>();

    static {
        Product p1 = new Product(1,"iphonex",9999,100);
        Product p2 = new Product(2,"冰箱",66,20);
        Product p3 = new Product(3,"洗衣机",77,30);
        Product p4 = new Product(4,"电话",88,40);
        Product p5 = new Product(5,"汽车",99,50);
        Product p6 = new Product(6,"椅子",19,80);
        Product p7 = new Product(7,"java编程思想",36,90);
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
        daoMap.put(p3.getId(),p3);
        daoMap.put(p4.getId(),p4);
        daoMap.put(p5.getId(),p5);
        daoMap.put(p6.getId(),p6);
        daoMap.put(p7.getId(),p7);
    }

    @Override
    public List<Product> listProduct() {
        return new ArrayList<>(daoMap.values());
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
