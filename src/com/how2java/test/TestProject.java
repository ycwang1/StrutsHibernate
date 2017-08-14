package com.how2java.test;

import com.how2java.dao.ProductDao;
import com.how2java.pojo.Product;

public class TestProject {
	public static void main(String[]args){
		ProductDao pd = new ProductDao();
		Product p =pd.get(1);
		System.out.println(p.getName());
	}
}
