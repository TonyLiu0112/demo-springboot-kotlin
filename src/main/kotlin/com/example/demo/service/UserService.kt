package com.example.demo.service

import com.example.demo.dao.mapper.SecurityUserDOMapper
import com.example.demo.service.bean.UserResponse
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

@Service
class UserService(val mapper: SecurityUserDOMapper) {

    fun getAllUser(): MutableList<UserResponse> {
        val records = mapper.selectAll()
        val responses: MutableList<UserResponse> = mutableListOf()
        records.forEach({ user ->
            val response: UserResponse = UserResponse()
            BeanUtils.copyProperties(user, response)
            responses.add(response)
        })
        return responses
    }

}