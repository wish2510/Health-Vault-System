package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.vo_city;

public class dao_city {

	public List select() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from vo_city");
		List list  = query.list();
		tr.commit();
		session.close();
		return list;
		
		
		
		}

	public int insert(vo_city vci) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		Query query = session.createQuery("from vo_city as temp where temp.stateid='"+ vci.getStateid()  +"' and temp.name='"+ vci.getName()+"'");
		List list = query.list();
		
		
		
		if(query.list().size()==0)
			session.save(vci);
		
		tr.commit();
		session.close();
		
		return list.size();
	}

	public List select(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	Query query =session.createQuery("from vo_city as temp where temp.stateid='"+ id + "'");
		List list = query.list();
		
	tr.commit();
	session.close();
		
		return list;
	}

	public void delete(vo_city vci) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vci);
		tr.commit();
		session.close();
		
	}

	public List select_all() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	Query query = session.createQuery("from vo_city tc,vo_state ts,vo_country tct  where tc.stateid=ts.stateid and ts.ctrid=tct.cntryid");
		List list = query.list();
		
		tr.commit();
		session.close();
		
		return list;
	}

	public List select_all(String parameter) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		Query query = session.createQuery("from vo_city tc,vo_state ts  where tc.cityid='"+parameter+"' and tc.stateid=ts.stateid ");
		
		List list = query.list();
		
		tr.commit();
		session.close();
		
		
		return list;
	}

	public void update(vo_city vci) {
		// TODO Auto-generated method stub
		
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vci);
		tr.commit();
		session.close();
				
	}
		
	}


