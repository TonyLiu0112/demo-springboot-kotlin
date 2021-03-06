package com.example.demo.controller

import com.alibaba.fastjson.JSONObject
import com.example.demo.service.bean.OrderResponse
import com.example.demo.service.bean.OrderResquest
import com.wrench.utils.restfulapi.RestTemplateWrapper
import com.wrench.utils.restfulapi.response.ErrorResponse
import com.wrench.utils.restfulapi.response.RestfulBuilder
import com.wrench.utils.restfulapi.response.RestfulResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.function.Consumer

@RestController
@RequestMapping("client")
class ClientController(val restTemplateWrapper: RestTemplateWrapper) {

    private val log: Logger = LoggerFactory.getLogger(ClientController::class.java)

    val baseUri: String = "http://localhost:8080/trade/orders/"

    @GetMapping("orders/{id}")
    fun getOrder(@PathVariable("id") id: Long): ResponseEntity<RestfulResponse<Any>> {
        val restfulResponse = restTemplateWrapper.get(baseUri + id, OrderResponse::class.java)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        if (restfulResponse.status == HttpStatus.BAD_REQUEST) {
            val errRes = restfulResponse.errData
            log.info("${errRes.code} ${errRes.message}")
            return RestfulBuilder.badRequest(restfulResponse.data)
        } else {
            val orderRes = restfulResponse.data as OrderResponse
            log.info("$orderRes")
            return RestfulBuilder.ok(restfulResponse.data)
        }
    }

    @GetMapping("orders")
    fun getOrder(): ResponseEntity<RestfulResponse<Any>> {
        val restfulResponse = restTemplateWrapper.getList(baseUri, OrderResponse::class.java)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        val datas = restfulResponse.data as MutableList<*>
        datas.forEach(Consumer { t ->
            run {
                val record = t as OrderResponse
                print(record.id)
                print(record.orderName)
            }
        })
        return RestfulBuilder.ok(restfulResponse.data, "成功")
    }

    @GetMapping("save/orders")
    fun save(): ResponseEntity<RestfulResponse<Any>> {
        val req = OrderResquest()
        req.id = 1
        req.orderName = "吃嘛嘛香"
        req.time = "2019-09-08"
        val restfulResponse = restTemplateWrapper.post(baseUri, req)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        return RestfulBuilder.ok(restfulResponse.data)
    }

    @GetMapping("save2/orders")
    fun save2(): ResponseEntity<RestfulResponse<Any>> {
        val req = OrderResquest()
        req.id = 1
        req.orderName = "吃嘛嘛香"
        req.time = "2019-09-08"
        val restfulResponse = restTemplateWrapper.postList(baseUri, req, OrderResponse::class.java)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        return RestfulBuilder.ok(restfulResponse.data)
    }

    @GetMapping("delete/orders")
    fun delete1(): ResponseEntity<RestfulResponse<Any>> {
        val restfulResponse = restTemplateWrapper.delete(baseUri + "1")
        log.info(JSONObject.toJSONString(restfulResponse, true))
        return RestfulBuilder.ok(restfulResponse.data)
    }

    @GetMapping("delete2/orders")
    fun delete2(): ResponseEntity<RestfulResponse<Any>> {
        val req = OrderResquest()
        req.id = 1
        req.orderName = "吃嘛嘛香"
        req.time = "2019-09-08"
        val restfulResponse = restTemplateWrapper.delete(baseUri, req)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        return RestfulBuilder.ok(restfulResponse.data)
    }

    @GetMapping("put/orders")
    fun put(): ResponseEntity<RestfulResponse<Any>> {
        val req = OrderResquest()
        req.id = 1
        req.orderName = "吃嘛嘛香"
        req.time = "2019-09-08"
        val restfulResponse = restTemplateWrapper.put(baseUri + "34", req, OrderResponse::class.java)
        log.info(JSONObject.toJSONString(restfulResponse, true))
        return RestfulBuilder.ok(restfulResponse.data)
    }

}