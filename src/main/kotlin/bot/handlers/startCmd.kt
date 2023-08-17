package com.github.kotlintelegrambot.echo.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.CallbackQuery
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message

fun startHandler(bot: Bot, message: Message) {
    if (message.text == "/start") {
        val text = """
            Вас приветствует бот компании Яндекс.
        """.trimIndent()
        val userId = message.from?.id
        if (userId != null) {
            bot.sendMessage(chatId = ChatId.fromId(userId), text = text)
        }
    }
}
fun callbackHandler(bot: Bot, message: CallbackQuery) {
    val (buttonId, messageId) = message.data.split(";")
    val userId = message.from.id
    val userName = message.from.username
    val chatId = message.message?.chat?.id
    val text = """
        Была нажата кнопка "$buttonId"
        messageId = $messageId
        userId = $userId
        userName = $userName
        chatId = $chatId
    """.trimIndent()
    bot.sendMessage(chatId = ChatId.fromId(userId), text = text)
}