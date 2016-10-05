package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.NotesVO;
public class Notesdao {
	public void insert(NotesVO notesVO)
	{
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(notesVO);
			transaction.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public List search(NotesVO notesVO) {
		// TODO Auto-generated method stub	
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from NotesVO where userrecordid="+notesVO.getUserrecordid());
			ls = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}
	
	public void deletenotes(NotesVO notesVO) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.delete(notesVO);
			
			transaction.commit();
		
			session.flush();
			session.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public List searchnotesforclickonnotes(NotesVO notesVO) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from NotesVO where noteid="+notesVO.getNoteid());
			ls = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}
}
