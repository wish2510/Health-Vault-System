package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.UserLoginVO;
import vo.UserProfileVO;
	public class UserProfiledao {
			public void insert(UserProfileVO userprofileVO)
			{
				try {		
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session = sessionFactory.openSession();
					Transaction transaction = session.beginTransaction();
					session.save(userprofileVO);
					transaction.commit();
					session.flush();
					session.close();
				} 
				catch (Exception e) {
					// TODO: handle exception	
					e.printStackTrace();
				}
			}
			public void delete(UserProfileVO profileVO) {
				// TODO Auto-generated method stub
				try {
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session = sessionFactory.openSession();
					Transaction transaction = session.beginTransaction();
					session.delete(profileVO);
					transaction.commit();
					session.flush();
					session.close();
					} 
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}

			public List fetch(UserProfileVO userProfileVO) {
			
				
						java.util.List ls =null;
						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
						Session session = sessionFactory.openSession();
						
						Query  query=null;
						query=session.createQuery("from UserProfileVO where userid="+userProfileVO.getUserid());
						ls = query.list();
						session.flush();
						session.close();

						return ls;
				

				// TODO Auto-generated method stub
				
			}

			public void update(UserProfileVO profileVO)
			{
				try {
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session = sessionFactory.openSession();
					
					Transaction transaction = session.beginTransaction();
					
					session.saveOrUpdate(profileVO);
				
					transaction.commit();
					session.flush();
					session.close();

				} 
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
					
					
			}
			public List fu3(UserProfileVO userProfileVO) {
				// TODO Auto-generated method stub
				java.util.List ls =null;
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				query=session.createQuery("from UserProfileVO profile where profile.userid="+userProfileVO.getUserid());
				ls = query.list();
				return ls;
				
			}

		
		
	}



