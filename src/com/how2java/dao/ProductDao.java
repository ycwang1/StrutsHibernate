package com.how2java.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;
//hibernate 框架处理数据库数据
public class ProductDao {
	//新增一条数据
	public void add(Product p){
//		List<Product>result=new ArrayList<>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//根据id获取一条数据
	public Product get(int id){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Product p=(Product) s.get(Product.class, id);
		s.close();
		sf.close();
		return p;
	}
	//根据id删除一条数据
	public void delete(int id){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Product p = (Product)s.get(Product.class, id);
		s.delete(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//更新一条数据
	public void update(Product p){
//		List<Product>result=new ArrayList<>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//查询product表所有数据
	public List<Product> list(){
		List<Product>result=new ArrayList();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s =sf.openSession();
		s.beginTransaction();
		Query q =s.createQuery("from Product");
		result=q.list();
		s.close();
		sf.close();
		return result;
	}
}
