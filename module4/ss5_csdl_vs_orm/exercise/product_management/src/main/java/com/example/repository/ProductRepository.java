package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> showList() {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findId(int id) {
        TypedQuery<Product> typedQuery=ConnectionUtil.entityManager.createQuery
                ("select s from Product as s where s.id=:id", Product.class);
        typedQuery.setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete1(Product product) {
        EntityTransaction entityTransaction=ConnectionUtil.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectionUtil.entityManager.remove(findId(product.getId()));
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(Product product) {
        return null;
    }
}
