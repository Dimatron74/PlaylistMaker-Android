
package com.example.playlistdmitry.domain.model

import android.os.Parcelable  // Импорт интерфейса Parcelable для сериализации объектов
import kotlinx.parcelize.Parcelize  // Импорт аннотации для автоматической реализации Parcelable

@Parcelize

data class Track(
    val trackId: Long,              // Уникальный идентификатор трека
    val trackName: String,          // Название трека
    val artistName: String,         // Имя исполнителя
    val trackTimeMillis: Long,      // Длительность трека в миллисекундах
    val artworkUrl100: String,      // URL обложки трека размером 100x100 пикселей
    val collectionName: String?,    // Название альбома (может быть null)
    val releaseDate: String?,       // Дата выпуска трека (может быть null)
    val primaryGenreName: String?,  // Основной жанр трека (может быть null)
    val country: String?,           // Страна происхождения трека (может быть null)
    val previewUrl: String,         // URL для предварительного прослушивания трека
    var inFavorites: Boolean = false  // Флаг, указывающий, находится ли трек в избранном (по умолчанию false)
) : Parcelable {  // Класс реализует Parcelable для передачи между компонентами Android

    val artworkUrl512
        get() = artworkUrl100?.replaceAfterLast('/', "512x512bb.jpg")  // Заменяет часть URL для получения большей обложки
}