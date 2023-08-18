package server

import BotProperties
import com.github.kotlintelegrambot.echo.Bot
import com.github.kotlintelegrambot.echo.keyboards.keyboard
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class PostData(val message: String, val id: String, val buttons: List<Map<String, String>>)

@SpringBootApplication(scanBasePackages = ["package com.github.kotlintelegrambot.echo", "server"])
@RestController
@EnableConfigurationProperties(BotProperties::class)
class Application (private val botProperties: BotProperties,
				   private val botTelegram: Bot) : ApplicationRunner {

	override fun run(args: ApplicationArguments?) {
		// Запуск бота при старте приложения
		botTelegram.bot.startPolling()
	}
	@PostMapping("/sendMessage")
	fun sendMessage(@RequestBody postData: PostData): ResponseEntity<String> {

		val currentChatId = botProperties.currentChatId
		val keyboardMarkup = keyboard(postData)

		botTelegram.bot.sendMessage(chatId = ChatId.fromId(currentChatId),
			text = postData.message, replyMarkup = keyboardMarkup)
		return ResponseEntity.ok("Данные успешно получены!")
	}
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(Application::class.java, *args)
		}
	}
}

