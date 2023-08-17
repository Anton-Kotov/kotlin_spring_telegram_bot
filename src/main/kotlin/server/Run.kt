package server

import com.github.kotlintelegrambot.echo.Bot
import com.github.kotlintelegrambot.echo.keyboards.keyboard
import com.github.kotlintelegrambot.entities.ChatId
import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class PostData(val message: String, val id: String, val buttons: List<Map<String, String>>)

@SpringBootApplication
@RestController
class Application {
	@PostMapping("/sendMessage")
	fun sendMessage(@RequestBody postData: PostData): ResponseEntity<String> {
		val dotenv = Dotenv.load()
		val telegramToken = dotenv["TELEGRAM_TOKEN"].toString()
		val bot = Bot(telegramToken).bot
		val keyboardMarkup = keyboard(postData.buttons)
		bot.sendMessage(chatId = ChatId.fromId(-855224636), text = postData.message, replyMarkup = keyboardMarkup)
		return ResponseEntity.ok("Данные успешно получены!")
	}
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(Application::class.java, *args)
		}
	}
}

