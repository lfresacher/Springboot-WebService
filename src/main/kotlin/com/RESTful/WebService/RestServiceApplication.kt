/*
* A Tutorial Followed by https://theanirban.dev/build-rest-api-spring-boot-kotlin/
*/

package com.RESTful.WebService

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
object RestServiceApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(RestServiceApplication::class.java, *args)
    }
}