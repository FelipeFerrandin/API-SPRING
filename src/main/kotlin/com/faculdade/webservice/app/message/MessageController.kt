package com.faculdade.webservice.app.message

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController //  indica um componente controlador na camada de apresentação.
@RequestMapping(path = ["/"])
class MessageController {
    @Autowired
    private lateinit var messageService: MessageService

    @GetMapping(path = ["/message/list"])
    @ResponseBody
    fun getAllMessages(): Iterable<MessageEntity> {
        return messageService.getAllMessages()
    }

    @GetMapping(path = ["/message/{idMessage}"])
    @ResponseBody
    fun getMessagesById(@PathVariable idMessage: Int): MessageEntity {
        return messageService.getMessagesById(idMessage)
    }

    @PostMapping(path = ["/message/add"])
    @ResponseBody
    fun addNewMessage(@RequestBody payload: MessageDTO): String {
        return messageService.addNewMessage(payload)
    }

    @PutMapping(path = ["/message/edit"])
    fun editMessage(@RequestBody payload: MessageDTO): String {
        return messageService.editMessage(payload)
    }

    @DeleteMapping(path = ["/message/delete/{idMessage}"])
    fun deleteMessage(@PathVariable idMessage: Int): String {
        return messageService.deleteMessage(idMessage)
    }

    @GetMapping(path = ["/message/list/custom"])
    fun getCustom(): MutableList<MessageDTO> {
        return messageService.getAllMessagesCustom()
    }

    @PostMapping(path = ["/message/create/custom"])
    fun createNewMessageCustom(@RequestBody payload: MessageDTO): String {
        return messageService.createNewMessageCustom(payload)
    }

}