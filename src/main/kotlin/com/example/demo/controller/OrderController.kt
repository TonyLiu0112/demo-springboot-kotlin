package com.example.demo.controller

import com.example.demo.service.bean.OrderResponse
import com.example.demo.service.bean.OrderResquest
import com.wrench.utils.restfulapi.response.RestfulBuilder
import com.wrench.utils.restfulapi.response.RestfulResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("trade")
class OrderController {

    @GetMapping("orders/{id}")
    fun getOrder(@PathVariable("id") id: Long): ResponseEntity<RestfulResponse<Any>> {
        val order = OrderResponse()
        order.id = id
        order.orderName = "满汉全席"
        order.time = "2017-09-09"
        return RestfulBuilder.ok(order)
    }

    @GetMapping("orders")
    fun getOrders(): ResponseEntity<RestfulResponse<Any>> {
        val list = mutableListOf<OrderResponse>()
        val order = OrderResponse()
        order.id = 10
        order.orderName = "好酒好肉"
        order.time = "2017-01-01"
        list.add(order)
        return RestfulBuilder.ok(list)
    }

    @PostMapping("orders")
    fun saveOrder(@RequestBody orderRequest: OrderResquest): ResponseEntity<RestfulResponse<Any>> {
        val order = OrderResponse()
        order.id = 10
        order.orderName = "好酒好肉"
        order.time = "2017-01-01"
        return RestfulBuilder.created(order)
    }

    @DeleteMapping("orders/{id}")
    fun delete1(@PathVariable("id") id: Long): ResponseEntity<RestfulResponse<Any>> {
        return RestfulBuilder.deleted("success to remove $id")
    }

    @DeleteMapping("orders")
    fun delete2(@RequestBody() orderRequest: OrderResquest): ResponseEntity<RestfulResponse<Any>> {
        return RestfulBuilder.deleted("success to remove ${orderRequest.id}")
    }

    @PutMapping("orders/{id}")
    fun modify(@PathVariable("id") id: Long, @RequestBody orderRequest: OrderResquest): ResponseEntity<RestfulResponse<Any>> {
        print("修改 -> ${orderRequest.id} ${orderRequest.orderName}")
        val order = OrderResponse()
        order.id = 10
        order.orderName = "好酒好肉"
        order.time = "2017-01-01"
        return RestfulBuilder.ok(order)
    }

}