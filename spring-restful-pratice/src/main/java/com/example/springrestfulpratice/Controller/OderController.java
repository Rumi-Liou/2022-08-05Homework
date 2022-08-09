package com.example.springrestfulpratice.Controller;

import com.example.springrestfulpratice.Service.OrderService;
import com.example.springrestfulpratice.Modle.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrder(){
        List<Order> orderList=this.orderService.getAllOrder();
        return orderList;
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        Order order=this.orderService.getOrderById(id);
        return order;
    }
    @PostMapping()
    public Order creatOrder(@RequestBody Order order){
        Order creatOrder=this.orderService.creatOrder(order);
        return creatOrder;
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id,@RequestBody Order order){
        Order updateOrder=this.orderService.updateOrder(id, order);
        return updateOrder;
    }
    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable int id){
        Order deleteOrder=this.orderService.deleteOrder(id);
        return null;
    }
}
