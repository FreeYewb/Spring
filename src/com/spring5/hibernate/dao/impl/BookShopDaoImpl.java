package com.spring5.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring5.hibernate.dao.BookShopDao;
import com.spring5.hibernate.exception.BookStockException;
import com.spring5.hibernate.exception.UserAccountException;
@Repository
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//不推荐使用 HibernateTemplate 和 HibernateDaoSupport
	//因为这样会导致 Dao 和 Spring 的 API 进行耦合
	//可以移植性变差
//	private HibernateTemplate hibernateTemplate;
	
	//获取和当前线程绑定的Session.
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Integer)query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		// TODO Auto-generated method stub
		String hql2 = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		
		int stock = (int) getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		if(stock == 0) {
			throw new BookStockException("库存不足");
		}
		
		String hql = "UPDATE Book b SET b.stock = b.stock -1 WHERE b.isbn = ?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();

	}

	@Override
	public void updateUserAccount(String username, int price) {
		// TODO Auto-generated method stub
		//	验证余额是否足够
		String hql2 = "SELECT a.balance FROM Account a WHERE a.username = ?";
		int balance =  (int) getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if (balance < price) {
			throw new UserAccountException("余额不足");
		}
		
		String hql = "UPDATE Account a SET a.balance = a.banlance - ? WHERE a.username = ?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
		
	}

}
