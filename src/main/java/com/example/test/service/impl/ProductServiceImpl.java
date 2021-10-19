package com.example.test.service.impl;

import com.example.test.pojo.Product;
import com.example.test.repository.ProductRepository;
import com.example.test.service.ProductService;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void createProduct(Product product) {
    productRepository.save(product);
  }
  @Override
  public void updateProduct(String id, Product newProduct) {
    Product product = productRepository.findById(id).orElse(newProduct);
    product.setId(newProduct.getId());
    product.setName(newProduct.getName());
    productRepository.save(product);

  }
  @Override
  public void deleteProduct(String id) {
    productRepository.deleteById(id);

  }
  @Override
  public Collection<Product> getProducts() {
    return productRepository.findAll();
  }
}
