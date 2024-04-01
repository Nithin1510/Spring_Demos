package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	@Override
	public void updateProduct(int productId, double price) {
		// TODO Auto-generated method stub
		productRepository.updateProduct(productId, price);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productRepository.deleteProduct(productId);
	}

	@Override
	public Product getId(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId);
		if(product == null)
			throw new ProductNotFoundException("Product not found");
		return product;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findAll();
		if(productList.isEmpty())
			throw new ProductNotFoundException("Product not found");
		return productList;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findByBrand(brand);
		if(productList.isEmpty())
			throw new ProductNotFoundException("Product not found");
		return productList;
	}

	@Override
	public List<Product> getByLesPrice(double price) throws ProductNotFoundException {
		List<Product> productList = productRepository.findByLesPrice(price);
		if(productList.isEmpty())
			throw new ProductNotFoundException("Product not found");
		return productList;
	}

	@Override
	public List<Product> getByCategoryAndPrice(String category, double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		List<Product> productList = productRepository.findByCategoryAndPrice(category, price);
		if(productList.isEmpty())
			throw new ProductNotFoundException("Product not found");
		return productList;
	}

}
