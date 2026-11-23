package com.example.module3_1_6.data

data class CardItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageRes: Int
)

val cardItems = listOf(
    CardItem(1, "Камера", "Съёмка фото и видео", android.R.drawable.ic_menu_camera),
    CardItem(2, "Галерея", "Просмотр изображений", android.R.drawable.ic_menu_gallery),
    CardItem(3, "Звонки", "Список вызовов", android.R.drawable.ic_menu_call),
    CardItem(4, "Компас", "Определение направления", android.R.drawable.ic_menu_compass),
    CardItem(5, "Заметки", "Редактирование текста", android.R.drawable.ic_menu_edit),
    CardItem(6, "Сообщения", "Отправка сообщений", android.R.drawable.ic_menu_send),
    CardItem(7, "Карта", "Поиск мест на карте", android.R.drawable.ic_menu_mapmode),
    CardItem(8, "Поиск", "Поиск по устройству", android.R.drawable.ic_menu_search),
    CardItem(9, "Настройки", "Параметры приложения", android.R.drawable.ic_menu_preferences),
    CardItem(10, "Календарь", "Планирование дел", android.R.drawable.ic_menu_my_calendar)
)
