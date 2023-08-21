package server

import BotProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(BotProperties::class)
class BotConfiguration {
    // Компоненты и бины связанные с конфигурацией
}
