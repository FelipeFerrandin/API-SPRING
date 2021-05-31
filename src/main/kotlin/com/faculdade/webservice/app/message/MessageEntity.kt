package com.faculdade.webservice.app.message

import javax.persistence.*

@Entity // Objeto que demonstra copia da tabela do banco
data class MessageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false) // NOT NULL
    var text_message: String? = null
)
