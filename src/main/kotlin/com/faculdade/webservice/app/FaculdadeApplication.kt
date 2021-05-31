package com.faculdade.webservice.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.faculdade.webservice.app.message",
        "com.faculdade.webservice.app.framework.error",
        "com.faculdade.webservice.app.framework.webConfig"
    ]
)
class FaculdadeApplication

fun main(args: Array<String>) {
    SpringApplication.run(FaculdadeApplication::class.java, *args)
}
