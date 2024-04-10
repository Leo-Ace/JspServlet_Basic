package com.de1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.de1.configs.ConnectDB;
import com.de1.entities.Product;

public class ProductImpl implements IProductDao {
	Connection conn = null;

	@Override
	public List<Product> getAll() {
		conn = ConnectDB.openConnection();
		List<Product> data = new ArrayList<Product>();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from products order by productId");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product product = new Product(
							rs.getString("productId"),
							rs.getString("productName"),
							rs.getInt("price"),
							rs.getInt("quantity"),
							rs.getString("description"),
							rs.getBoolean("status")
						);
				data.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return data;
	}

	@Override
	public Product getById(String productId) {
		conn = ConnectDB.openConnection();
		Product product = null;
		try {
			PreparedStatement pst = conn.prepareStatement("select * from products where productId = ?");
			pst.setString(1, productId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				product = new Product(
							rs.getString("productId"),
							rs.getString("productName"),
							rs.getInt("price"),
							rs.getInt("quantity"),
							rs.getString("description"),
							rs.getBoolean("status")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return product;
	}

	@Override
	public List<Product> getByPrice(int from, int to) {
		conn = ConnectDB.openConnection();
		List<Product> data = new ArrayList<Product>();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from products where price between ? and ? order by productId");
			pst.setInt(1, from);
			pst.setInt(2, to);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Product product = new Product(
							rs.getString("productId"),
							rs.getString("productName"),
							rs.getInt("price"),
							rs.getInt("quantity"),
							rs.getString("description"),
							rs.getBoolean("status")
						);
				data.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return data;
	}

	@Override
	public boolean insert(Product product) {
		conn = ConnectDB.openConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("insert into products values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setInt(3, product.getPrice());
			pst.setInt(4, product.getQuantity());
			pst.setString(5, product.getDescription());
			pst.setBoolean(6, product.isStatus());
			return pst.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		conn = ConnectDB.openConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("update products set productName = ?, price = ?, quantity = ?, description = ?, status = ? where productId = ?");
			pst.setString(1, product.getProductName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getQuantity());
			pst.setString(4, product.getDescription());
			pst.setBoolean(5, product.isStatus());
			pst.setString(6, product.getProductId());
			return pst.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean delete(String productId) {
		conn = ConnectDB.openConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("delete from products where productId = ?");
			pst.setString(1, productId);
			ResultSet rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectDB.closeConnection(conn);
		}
		return false;
	}

}
