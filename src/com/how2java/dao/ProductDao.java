package com.how2java.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;
//hibernate ��ܴ������ݿ�����
public class ProductDao {
	//����һ������
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
	//����id��ȡһ������
	public Product get(int id){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Product p=(Product) s.get(Product.class, id);
		s.close();
		sf.close();
		return p;
	}
	//����idɾ��һ������
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
	//����һ������
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
	//��ѯproduct����������
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
