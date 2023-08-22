package server

import com.github.kotlintelegrambot.echo.Bot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["package com.github.kotlintelegrambot.echo", "server"])
class Application: ApplicationRunner {

    @Autowired
    private lateinit var botTelegram: Bot

    override fun run(args: ApplicationArguments?) {
        // Запуск бота при старте приложения
        botTelegram.bot.startPolling()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }
}