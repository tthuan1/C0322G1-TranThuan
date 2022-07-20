package com.example.repository;

import com.example.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class SongRepository implements ISongRepository {

    Session session=null;


    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = ConnectionUtil.entityManager.createQuery("select s from Song as s", Song.class);
        return query.getResultList();
    }

//    @Override
//    public void save(Song song) {
//        Transaction transaction = null;
//        try {
//            session = ConnectionUtil.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save( song);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
@Override
public void save(Song song) {
    EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
    entityTransaction.begin();
    ConnectionUtil.entityManager.persist(song);
    entityTransaction.commit();
}

    @Override
    public Song findById(int id) {
        TypedQuery<Song> typedQuery=ConnectionUtil.entityManager.createQuery
                ("select s from Song as s where s.id=:id", Song.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void edit(Song song) {
        EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void delete(Song song) {
        EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(findById(song.getId()));
        entityTransaction.commit();
    }
}
