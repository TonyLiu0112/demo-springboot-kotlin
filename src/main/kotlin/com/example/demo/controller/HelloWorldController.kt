package com.example.demo.controller

import com.example.demo.service.User
import com.wrench.utils.restfulapi.RestTemplateWrapper
import com.wrench.utils.restfulapi.response.RestfulBuilder.ok
import com.wrench.utils.restfulapi.response.RestfulResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("demo")
class HelloWorldController(_restWrapper: RestTemplateWrapper) {

    val logger: Logger = LoggerFactory.getLogger(HelloWorldController::class.java)

    val restWrapper: RestTemplateWrapper = _restWrapper

    @GetMapping("hello")
    fun hello(@RequestParam("name") name: String) = name + " say: Hello Kotlin!"

    @GetMapping("log")
    fun printLog() = logger.info("haha")

    @DeleteMapping("delete/{id}")
    fun deleteById(@PathVariable("id") id: String): ResponseEntity<RestfulResponse<Any>> {
        print("根据id $id 删除成功")
        return ok(id)
    }

    @DeleteMapping("delete")
    fun deleteByObject(@RequestBody user: User): ResponseEntity<RestfulResponse<Any>> {
        val user1 = user.copy(age = 100)
        return ok(user1)
    }

    @DeleteMapping("delete1")
    fun deleteByParam(@RequestParam("id") id: String): ResponseEntity<RestfulResponse<Any>> {
        print("根据id参数 $id 删除成功")
        return ok(id)
    }

    @PutMapping("put")
    fun doPut(@RequestBody user: User): ResponseEntity<RestfulResponse<Any>> {
        return ok(user.copy(name = "dabao", age = 22))
    }

    @GetMapping("test")
    fun test(): ResponseEntity<RestfulResponse<Any>> {
        val user: User = User("Tony", 20)
        val response = restWrapper.put("http://localhost:8080/demo/put", user)
        return ok(response.getData())
    }

}

