package com.github.kotlintelegrambot.echo.keyboards

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import server.PostData


fun inlineKeyboard(data: PostData): InlineKeyboardMarkup {
    val list = mutableListOf<InlineKeyboardButton>()
    for (button in data.buttons) {
        val label = button.getOrDefault("label", "")
        val id = button.getOrDefault("id", "")
        // Записываем messageId и buttonId в callbackData
        list.add(InlineKeyboardButton.CallbackData(text = label, callbackData = "$id;${data.id}"))
    }
    return InlineKeyboardMarkup.create(buttons = listOf(list))
}
