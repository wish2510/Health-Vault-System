package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.Category_Of_RecordVO;
import vo.NotesVO;

public class Categoryofrecorddao {

	
	public List search(Category_Of_RecordVO category_Of_RecordVO) {
		// TODO Auto-generated method stub	
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from Category_Of_RecordVO");
			ls = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}

}
