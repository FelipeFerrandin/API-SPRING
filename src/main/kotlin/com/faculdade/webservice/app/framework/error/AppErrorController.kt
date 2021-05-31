package com.faculdade.webservice.app.framework.error

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AppErrorController : ErrorController {

    @RequestMapping(path = ["/error"])
    @ResponseBody
    fun getErrorPath(): String? {
        return "404 - Nenhuma pagina foi encontrada"
    }
}