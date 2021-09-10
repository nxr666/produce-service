package com.nxr.controller;

import com.nxr.bean.Product;
import com.nxr.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/product")
public class ProduceController {

    private static Logger logger = LoggerFactory.getLogger(ProduceController.class);

    @Value("${server.port}")
    private int port;

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public List<Product> listProduct() {
        return productService.listProduct();
    }

    @GetMapping("/find")
    public Product findById(@RequestParam("id") int id) {
        logger.info("produce service find");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(product.getName()+" data from port="+port);
        return result;

    }
}
