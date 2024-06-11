package com.pilotes.pilotes_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pilotes.pilotes_app.model.Order;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {

}
