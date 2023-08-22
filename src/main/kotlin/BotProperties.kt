import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("bot")
data class BotProperties(val token: String, val currentChatId: Long) {
}

