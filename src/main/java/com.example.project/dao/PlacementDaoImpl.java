package com.example.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.project.bean.Placement;
import com.example.project.utils.SessionUtil;

public class PlacementDaoImpl implements PlacementDao {
    @Override
    public boolean createOffer(Placement placement) {
        try (Session session = SessionUtil.getSession()) {
            System.out.println(placement);
            Transaction transaction = session.beginTransaction();
            session.save(placement);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

}
