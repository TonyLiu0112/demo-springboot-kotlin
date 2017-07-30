package com.example.demo.dao.mapper

import com.example.demo.dao.entity.SecurityUserDO

interface SecurityUserDOMapper {

    fun insert(record: SecurityUserDO): Int

    fun insertSelective(record: SecurityUserDO): Int

    fun selectByPrimaryKey(id: Long): SecurityUserDO

    fun updateByPrimaryKeySelective(record: SecurityUserDO): Int

    fun updateByPrimaryKey(record: SecurityUserDO): Int

    fun selectAll(): List<SecurityUserDO>

}