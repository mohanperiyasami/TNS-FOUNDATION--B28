package com.tns.orderdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderDetailsRepository extends JpaRepository<OrderDetails, Integer>{

}