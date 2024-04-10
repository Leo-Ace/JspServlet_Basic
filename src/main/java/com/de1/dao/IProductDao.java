package com.de1.dao;

import java.util.List;

import com.de1.entities.Product;

public interface IProductDao {
	public List<Product> getAll();
	public Product getById(String productId);
	public List<Product> getByPrice(int from, int to);
	
	public boolean insert(Product product);
	public boolean update(Product product);
	
	public boolean delete(String productId);
}
