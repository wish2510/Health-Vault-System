package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.ActivityListVO;


public class ActivityListdao {

	public void insert(ActivityListVO activityListVO)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.save(activityListVO);
		
			transaction.commit();
			session.flush();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
			
		}

}
