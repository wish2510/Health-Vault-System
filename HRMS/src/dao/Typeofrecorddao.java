package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.Category_Of_RecordVO;
import vo.Type_Of_RecordVO;

public class Typeofrecorddao {

	public List search(Type_Of_RecordVO type_Of_RecordVO) {
		// TODO Auto-generated method stub	
		java.util.List ls =null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query  query=null;
			query = session.createQuery("from Type_Of_RecordVO where categoryofrecordid=" + type_Of_RecordVO.getCategoryofrecordid());
			ls = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ls;
	}
}
