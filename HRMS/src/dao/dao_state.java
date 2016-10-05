package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.vo_state;

public class dao_state {

	public List select() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		Query qry = session.createQuery("from vo_state");
		List objlist = qry.list();
     
		tr.commit();
		
        session.close();
		return objlist;
		

	}

	public int insert(vo_state vs) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	Query qry = session.createQuery("from  vo_state as temp where temp.name='"+ vs.getName() +"' and  temp.ctrid='"+ vs.getCtrid() +"'");
			List objlist = qry.list();
	    		if(objlist.size()==0)
	    		    session.save(vs);
			
			tr.commit();
			session.close();
			return objlist.size(); 
			
	}

	public List select(String id) {
		// TODO Auto-generated method stub
	   
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("from  vo_state where ctrid='"+ id +"'");
		List objlist = qry.list();
     
		tr.commit();
		
        session.close();
		return objlist;
		
	
	}

	public List select_all() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("from  vo_state  vs,vo_country vc where vs.ctrid=vc.cntryid");
		List objlist = qry.list();
     
		tr.commit();
		
        session.close();
		return objlist;
		
	}

	public List select_all(String id) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("from  vo_state vs,vo_country vc where vs.stateid='"+ id +"'and vs.ctrid=vc.cntryid");
		List objlist = qry.list();
     
		tr.commit();
		
        session.close();
		return objlist;
		
		}

	public void update(vo_state vs) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vs);
		tr.commit();
		session.close();
		
	}

	public void delete(vo_state vs) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vs);
		tr.commit();
		session.close();
		
		
	}

}
