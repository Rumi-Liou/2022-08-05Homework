package com.example.springrestfulpratice.Service;

import com.example.springrestfulpratice.Modle.Meal;
import com.example.springrestfulpratice.Modle.Order;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Meal> mealList;
    List<Order> orderList;

    public OrderService(){
        this.mealList=new ArrayList<>();
        this.orderList=new ArrayList<>();
        this.mealList.add(new Meal("hamberger",50,"Delicious"));
        this.mealList.add(new Meal("French Fries",35,"French"));
        this.mealList.add(new Meal("Cola",1000,"drink"));
        this.orderList.add(new Order(1,300,"MIly",mealList));
        this.orderList.add(new Order(2,4000,"Kevin",mealList));

    }
    public List<Order> getAllOrder(){
        return this.orderList;
    }

    public Order getOrderById(int id){
        for (Order order:this.orderList){
          if(id==order.getSeq()){
              return order;
          }
          else if(order==null){
              return null;
          }
        }
        return null;
    }

    public Order creatOrder( Order order){
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder( int id,Order order){
        for(Order updateorder:this.orderList){
            if(id==order.getSeq()){
                updateorder.setWaiter(order.getWaiter());
                updateorder.setTotalPrice(order.getTotalPrice());
                return updateorder;
            }
            else if(updateorder==null){
                return null;
            }
        }
        return null;
    }

    public Order deleteOrder( int id){
        for(Order order:this.orderList){
            if(id==order.getSeq()){
                orderList.remove(id);
                return order;
            }
            else if(order==null){
                return null;
            }
        }
        return null;
    }
}
