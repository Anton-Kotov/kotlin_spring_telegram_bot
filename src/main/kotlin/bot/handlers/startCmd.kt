package com.github.kotlintelegrambot.echo.handlers

import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.entities.CallbackQuery
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.Message

fun startHandler(bot: Bot, message: Message) {
    if (message.text == "/start") {
        println(message.from?.username)
        println(message.from?.id)
        val text = """
            Вас приветствует бот компании Яндекс.
        """.trimIndent()
        bot.sendMessage(chatId = ChatId.fromId(-855224636), text = text)
    }
}

fun approveHandler(bot: Bot, message: CallbackQuery) {
    val userId = message.from.id
    val userName = message.from.username
    val chatId = message.message?.chat?.id
    val text = """
        Была нажата кнопка "${message.data}"
        userId = $userId
        userName = $userName
        chatId = $chatId
    """.trimIndent()
    bot.sendMessage(chatId = ChatId.fromId(userId), text = text)
}