package server

import BotProperties
import com.github.kotlintelegrambot.echo.Bot
import com.github.kotlintelegrambot.echo.keyboards.keyboard
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class PostData(val message: String, val id: String, val buttons: List<Map<String, String>>)
@RestController
class Controller (private val botProperties: BotProperties,
				   private val botTelegram: Bot) {
    @PostMapping("/sendMessage")
    fun sendMessage(@RequestBody postData: PostData): ResponseEntity<String> {

        val currentChatId = botProperties.currentChatId
        val keyboardMarkup = keyboard(postData)

        botTelegram.bot.sendMessage(
            chatId = ChatId.fromId(currentChatId),
            text = postData.message, replyMarkup = keyboardMarkup
        )
        return ResponseEntity.ok("Данные успешно получены!")
    }
}