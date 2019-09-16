package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.OrderItemEntity;
import com.upgrad.FoodOrderingApp.service.entity.OrdersEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderItemDao {

    @PersistenceContext
    private EntityManager entityManager;



    public List getItemsByPopularity() {
        try{
            List l = entityManager.createNamedQuery("getItemsByPopularity", OrderItemEntity.class).getResultList();
            return l;
        }catch (NoResultException nre) {
            return null;
        }
    }

    public OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity){
        entityManager.persist(orderItemEntity);
        return orderItemEntity;
    }

    public List<OrderItemEntity> getOrderItemsByOrder(OrdersEntity ordersEntity) {
        try {
            List<OrderItemEntity> orderItemEntities = entityManager.createNamedQuery("getOrderItemsByOrder",OrderItemEntity.class).setParameter("orders",ordersEntity).getResultList();
            return orderItemEntities;
        }catch (NoResultException nre){
            return null;
        }
    }
}
