package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.UserLoginVO;
import vo.UserRecordVO;
public class UserRecorddao {
		public void insert(UserRecordVO userrecordVO)
		{
			try {		
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(userrecordVO);
				transaction.commit();
				session.flush();
				session.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
		public List search(UserRecordVO userRecordVO) {
			// TODO Auto-generated method stub		
			java.util.List ls =null;
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Query  query=null;
				query = session.createQuery("from UserLoginVO login,UserProfileVO profile, UserRecordVO record, ReferingClinicVO refer where profile.userid=record.userid and login.userid=record.userid and refer.clinicid=record.clinicid and record.userid="+ userRecordVO.getUserid());
				ls = query.list();
				}
			catch (Exception e) {
				// TODO: handle exception
				}

			return ls;
		}

		public void delete(UserRecordVO userRecordVO) {

			try {
				Query query = null;
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Transaction transaction = session.beginTransaction();
				System.out.println("HIIIII"+userRecordVO.getUserRecordid());
				if(userRecordVO.getUserRecordid()!=null)
					query = session.createQuery("delete from UserRecordVO where userRecordid ="+userRecordVO.getUserRecordid());
				else
					query = session.createQuery("delete from UserRecordVO where userid ="+userRecordVO.getUserid());
				query.executeUpdate();
				transaction.commit();
				session.flush();
				session.close();

			} 
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
				

		}

		public List searchpersonalrecord(UserRecordVO userRecordVO) {
			java.util.List ls =null;
			
			try {
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				Query  query=null;
				query = session.createQuery("from UserRecordVO where userRecordid="+ userRecordVO.getUserRecordid());
				
					
				ls = query.list();
				

			} catch (Exception e) {
				// TODO: handle exception
			}

			return ls;
		}
	
	
}

