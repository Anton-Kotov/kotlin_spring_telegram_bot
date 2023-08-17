package com.github.kotlintelegrambot.echo.keyboards

import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton


fun keyboard(buttonList: List<Map<String, String>>): InlineKeyboardMarkup {
    val list = mutableListOf<InlineKeyboardButton>()
    for (button in buttonList) {
        val label = button.getOrDefault("label", "")
        val id = button.getOrDefault("id", "")
        list.add(InlineKeyboardButton.CallbackData(text = label, callbackData = id))
    }
    return InlineKeyboardMarkup.create(buttons = listOf(list))
}
