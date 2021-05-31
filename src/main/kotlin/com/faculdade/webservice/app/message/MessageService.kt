package com.faculdade.webservice.app.message

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service // indica um componente de serviço na camada de negócios.
class MessageService {
    @Autowired //Anotacao de injecao de dependencia
    private lateinit var messageRepository: MessageRepository

    @Autowired //Anotacao de injecao de dependencia
    private lateinit var jdbcTemplate: JdbcTemplate

    fun getAllMessages(): Iterable<MessageEntity> {
        return messageRepository.findAll()
    }

    fun getMessagesById(idMessage: Int): MessageEntity {
        return messageRepository.findById(idMessage).get()
    }

    fun addNewMessage(payload: MessageDTO): String {
        val messageEntity = MessageEntity()
        messageEntity.text_message = payload.text_message
        messageRepository.save(messageEntity)
        return "Salvo com sucesso"
    }

    fun editMessage(payload: MessageDTO): String {
        payload.id_mensagem?.let {
            messageRepository.findById(it).map { message ->
                message.text_message = payload.text_message
                messageRepository.save(message)
            }
        }
        return "Editado com sucesso"
    }

    fun deleteMessage(idMessage: Int): String {
        messageRepository.deleteById(idMessage)
        return "Deletado com sucesso"
    }

    fun getAllMessagesCustom(): MutableList<MessageDTO> {
        // jdbcTemplate.queryForList e possivel fazer paginacao
        return jdbcTemplate.query("SELECT * FROM message_entity") { result, _ ->
            createMessage(
                result.getInt("id"),
                result.getString("text_message")
            )
        }
    }

    @Transactional // significa que qualquer falha faz com que toda a operação seja revertida para seu estado anterior e relance a exceção original.
    fun createNewMessageCustom(payload: MessageDTO): String {
        jdbcTemplate.execute("INSERT INTO message_entity (text_message) VALUES ('${payload.text_message}')")
        return "Inserido com sucesso"
    }

    private fun createMessage(idMessage: Int, textMessage: String): MessageDTO {
        val messageDTO = MessageDTO()
        messageDTO.id_mensagem = idMessage
        messageDTO.text_message = textMessage
        return messageDTO
    }

}