package com.pilotes.pilotes_app.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pilotes.pilotes_app.dao.OrderDao;
import com.pilotes.pilotes_app.dao.UserDao;
import com.pilotes.pilotes_app.dto.OrderDTO;
import com.pilotes.pilotes_app.dto.UserDTO;
import com.pilotes.pilotes_app.model.Order;
import com.pilotes.pilotes_app.model.User;
import com.pilotes.pilotes_app.resquest.SaveOrderRequest;

import jakarta.transaction.Transactional;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Service
@Transactional
public class PilotesServiceImpl {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderDao orderDao;
	
	public List<UserDTO> getAllUsers(){
		return mapUsersToDto(userDao.findAll());
	}
	
	public void saveOrder(SaveOrderRequest saveOrderRequest){
		Order order = new Order();
		order.setNumberOfPilotes(saveOrderRequest.getNumberOfPilotes());
		order.setOrderTotal(new BigDecimal(1.33).multiply(BigDecimal.valueOf(saveOrderRequest.getNumberOfPilotes())));
		order.setDeliveryAddress(saveOrderRequest.getDeliveryAddress());	
		order.setStatus(true);
		User user = userDao.findById(saveOrderRequest.getUserId()).get();
		order.setUser(user);
		orderDao.save(order);
		Mono.delay(Duration.ofSeconds(15))
	      .subscribeOn(Schedulers.boundedElastic()).subscribe( e -> {
	    	 order.setStatus(false);
	    	 orderDao.save(order);
	    });
	}
	
	public List<UserDTO> findByNameContains(String name) {
		return mapUsersToDto(userDao.findByNameContaining(name));		
	}
	
	public List<UserDTO> findByNameStarsWith(String name) {
		return mapUsersToDto(userDao.findByNameStartsWith(name));		
	}
	
	public List<UserDTO> mapUsersToDto(List<User> users){
		List<UserDTO> finalUsers = users.stream().map(e -> {
			UserDTO userDto = new UserDTO();
			userDto.setId(e.getId());
			userDto.setName(e.getName());
			userDto.setPhone(e.getPhone());
			List<OrderDTO> orders = new ArrayList<>();
			for(Order order :e.getOrders()) {
				OrderDTO orderDto = new OrderDTO();
				orderDto.setDeliveryAddress(order.getDeliveryAddress());
				orderDto.setId(order.getId());
				orderDto.setNumberOfPilotes(order.getNumberOfPilotes());
				orderDto.setOrderTotal(order.getOrderTotal());
				orderDto.setStatus(order.isStatus());
				orders.add(orderDto);
			}
			userDto.setOrders(orders);
			return userDto;
		}).collect(Collectors.toList());
		
		return finalUsers;
	}

}
