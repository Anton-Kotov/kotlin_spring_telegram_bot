package com.github.kotlintelegrambot.echo

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.echo.handlers.*
import io.github.cdimascio.dotenv.Dotenv

class Bot(telegramToken: String) {
    val bot = bot {
        token = telegramToken
        dispatch {
            text {
                startHandler(bot, message)
            }
            callbackQuery {
                approveHandler(bot, callbackQuery)
            }
        }

    }


}

fun main() {
    val dotenv = Dotenv.load()
    val telegramToken = dotenv["TELEGRAM_TOKEN"].toString()
    val bot = Bot(telegramToken)
    bot.bot.startPolling()
}
