package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.ShareRecordVO;

public class ShareRecorddao {

	public void insert(ShareRecordVO shareRecordVO) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Query  query=null;
			
			System.out.println("pppppppppppppppppp");
			query=session.createQuery("from ShareRecordVO where userrecordid='"+shareRecordVO.getUserrecordid()+"' and trustedcontact='"+shareRecordVO.getTrustedcontact()+"'");
			List ls = query.list();
			System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP      "+ls);
			if(ls.size()==0)
			session.save(shareRecordVO);		
			
			transaction.commit();
			session.flush();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public List searchsharecontact(ShareRecordVO shareRecordVO) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query  query=null;
		
		query=session.createQuery("from ShareRecordVO share,UserLoginVO login,UserProfileVO profile,vo_country cntry, vo_state state where share.trustedcontact=login.userid and login.userid=profile.userid and cntry.cntryid=profile.country and state.stateid=profile.state and trustee="+shareRecordVO.getTrustee());
		
		ls = query.list();
		

	return ls;

	}

	public void deletesharecontact(ShareRecordVO shareRecordVO) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery("delete from ShareRecordVO where sharerecordid ="+shareRecordVO.getSharerecordid() );
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

	public List searchtrustee(ShareRecordVO shareRecordVO) {
		// TODO Auto-generated method stub
		java.util.List ls =null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query  query=null;
		
		query=session.createQuery("from ShareRecordVO share,UserLoginVO login,UserProfileVO profile,vo_country cntry, vo_state state,UserRecordVO record where share.trustee=login.userid and login.userid=profile.userid and cntry.cntryid=profile.country and state.stateid=profile.state and record.userRecordid=share.userrecordid and trustedcontact="+shareRecordVO.getTrustedcontact());
		
		ls = query.list();
		

		return ls;
	}

}
