package com.example.demo.controller

import com.example.demo.service.UserService
import com.wrench.utils.restfulapi.response.RestfulBuilder
import com.wrench.utils.restfulapi.response.RestfulResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController(val userService: UserService) {

    @GetMapping("users")
    fun getAllUser(): ResponseEntity<RestfulResponse<Any>> {
        return RestfulBuilder.ok(userService.getAllUser())
    }

}