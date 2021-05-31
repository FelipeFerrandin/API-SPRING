package com.faculdade.webservice.app.message

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class MessageDTO {
    var id_mensagem: Int? = null
    var text_message: String? = null
}