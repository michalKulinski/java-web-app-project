package app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;


class LangRepository {

    List<Lang> findAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Lang> result = session.createQuery("from Lang", Lang.class).list();

        transaction.commit();
        session.close();
        return result;
    }

    Optional<Lang> findById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Optional<Lang> result = Optional.ofNullable(session.get(Lang.class, id));

        transaction.commit();
        session.close();
        return result;

    }

}
