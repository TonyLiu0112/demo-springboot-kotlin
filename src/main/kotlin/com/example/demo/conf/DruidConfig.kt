package com.example.demo.conf

import com.alibaba.druid.pool.DruidDataSource
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
@MapperScan("com.example.demo.dao.mapper")
class DruidConfig {

    @Value("\${spring.datasource.connectionInfo.url}")
    private val dbUrl: String? = null

    @Value("\${spring.datasource.connectionInfo.username}")
    private val username: String? = null

    @Value("\${spring.datasource.connectionInfo.password}")
    private val password: String? = null

    @Value("\${spring.datasource.connectionInfo.driverClassName}")
    private val driverClassName: String? = null

    @Value("\${spring.datasource.initialSize}")
    private val initialSize: Int = 0

    @Value("\${spring.datasource.minIdle}")
    private val minIdle: Int = 0

    @Value("\${spring.datasource.maxActive}")
    private val maxActive: Int = 0

    @Value("\${spring.datasource.maxWait}")
    private val maxWait: Long = 0

    @Value("\${spring.datasource.timeBetweenEvictionRunsMillis}")
    private val timeBetweenEvictionRunsMillis: Long = 0

    @Value("\${spring.datasource.minEvictableIdleTimeMillis}")
    private val minEvictableIdleTimeMillis: Long = 0

    @Value("\${spring.datasource.validationQuery}")
    private val validationQuery: String? = null

    @Value("\${spring.datasource.testWhileIdle}")
    private val testWhileIdle: Boolean = false

    @Value("\${spring.datasource.testOnBorrow}")
    private val testOnBorrow: Boolean = false

    @Value("\${spring.datasource.testOnReturn}")
    private val testOnReturn: Boolean = false

    @Value("\${spring.datasource.poolPreparedStatements}")
    private val poolPreparedStatements: Boolean = false

    @Value("\${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private val maxPoolPreparedStatementPerConnectionSize: Int = 0

    @Value("\${spring.datasource.filters}")
    private val filters: String? = null

    @Value("{spring.datasource.connectionProperties}")
    private val connectionProperties: String? = null

    @Bean
    @Primary
    @Throws(Exception::class)
    fun dataSource(): DruidDataSource {
        val datasource = DruidDataSource()
        datasource.url = this.dbUrl
        datasource.username = username
        datasource.password = password
        datasource.driverClassName = driverClassName
        datasource.initialSize = initialSize
        datasource.minIdle = minIdle
        datasource.maxActive = maxActive
        datasource.maxWait = maxWait
        datasource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis
        datasource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis
        datasource.validationQuery = validationQuery
        datasource.isTestWhileIdle = testWhileIdle
        datasource.isTestOnBorrow = testOnBorrow
        datasource.isTestOnReturn = testOnReturn
        datasource.isPoolPreparedStatements = poolPreparedStatements
        datasource.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize
        datasource.setFilters(filters)
        datasource.setConnectionProperties(connectionProperties)
        return datasource
    }
}