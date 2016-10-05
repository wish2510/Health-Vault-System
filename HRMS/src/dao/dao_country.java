package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.vo_country;
public class dao_country {
	public List select_id() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("from  vo_country");
		List objlist = qry.list();
		tr.commit();
        session.close();
		return objlist;
	}
	public int insert(vo_country vc) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("NAME  "+ vc.getName());
	Query qry = session.createQuery("from  vo_country as ctr where ctr.name='" +vc.getName() + "'");
	List objlist = qry.list();
	System.out.println("faf"+ objlist.size());
	if(objlist.size()==0)
	{
	session.save(vc);
	}
	tr.commit();
	session.close();
	return objlist.size(); 
	}
	
	public List select() {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		Query qry = session.createQuery("from  vo_country");
		List objlist = qry.list();
     
		tr.commit();
        session.close();
		return objlist;
		
	}

	public void delete(String parameter) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("delete from  vo_country as temp where temp.cntryid='"+ parameter +"'");
		qry.executeUpdate();
		tr.commit();
        session.close();
	
		
	}

	public List select(String id) {
		// TODO Auto-generated method stub

		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("from  vo_country where cntryid='"+ id +"'");
		List objlist = qry.list();

		System.out.println("JFDSAGLAS"+ objlist.size());
       session.close();
		return objlist;
		
		
	}

	public void update(vo_country vc) {
		// TODO Auto-generated method stub
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	
		session.update(vc);
		System.out.println("UPDATED");
		tr.commit();
        session.close();		
	}
	
	

}
