package com.how2java.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
//hibernate ��ܴ������ݿ�����
public class CategoryDao {
	//����һ������
	public void add(Category p){
//		List<category>result=new ArrayList<>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//����id��ȡһ������
	public Category get(int id){
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Category p=(Category) s.get(Category.class, id);
		s.close();
		sf.close();
		return p;
	}
	//����idɾ��һ������
	public void delete(int id){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		Category p = (Category)s.get(Category.class, id);
		s.delete(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//����һ������
	public void update(Category p){
//		List<category>result=new ArrayList<>();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
	//��ѯcategory����������
	public List<Category> list(){
		List<Category>result=new ArrayList();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s =sf.openSession();
		s.beginTransaction();
		Query q =s.createQuery("from Category");
		result=q.list();
		s.close();
		sf.close();
		return result;
	}
}
