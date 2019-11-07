package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository {
//    private List<Lang> languages;
//
//    LangRepository() {
//        languages = new ArrayList<>();
//        languages.add(new Lang(1, "Hello", "en"));
//        languages.add(new Lang(2, "Siemanko", "pl"));
//    }

    Optional<Lang> findById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lang result = session.get(Lang.class, id);

        transaction.commit();
        session.close();
        return Optional.ofNullable(result);

//        return languages.stream()
//                .filter(l -> l.getId().equals(id))
//                .findFirst();
    }

}
