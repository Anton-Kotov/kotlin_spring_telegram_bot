package com.github.kotlintelegrambot.echo

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.echo.handlers.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Bot(@Value("\${bot.token}") telegramToken: String) {
    val bot = bot {
        token = telegramToken
        dispatch {
            text {
                startHandler(bot, message)
            }
            callbackQuery {
                callbackHandler(bot, callbackQuery)
            }
        }

    }
}
