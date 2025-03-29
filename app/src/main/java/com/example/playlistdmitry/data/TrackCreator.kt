package com.example.playlistdmitry.data

import com.example.playlistdmitry.data.model.TrackDto
import com.example.playlistdmitry.domain.model.Track

object TrackCreator {

    fun map(dto: TrackDto): Track {
        return Track(
            trackId = dto.trackId,
            trackName = dto.trackName, // Название трека
            artistName = dto.artistName, // Имя исполнителя
            trackTimeMillis = dto.trackTimeMillis, // Длительность трека в миллисекундах
            artworkUrl100 = dto.artworkUrl100, // Ссылка на обложку трека (100x100 пикселей)
            collectionName = dto.collectionName, // Название альбома
            releaseDate = dto.releaseDate, // Дата выпуска
            primaryGenreName = dto.primaryGenreName, // Основной жанр
            country = dto.country, // Страна
            previewUrl = dto.previewUrl // Ссылка на превью трека
        )
    }

    fun map(track: Track): TrackDto {
        return TrackDto(
            trackId = track.trackId, // Уникальный идентификатор трека
            trackName = track.trackName, // Название трека
            artistName = track.artistName, // Имя исполнителя
            trackTimeMillis = track.trackTimeMillis, // Длительность трека в миллисекундах
            artworkUrl100 = track.artworkUrl100, // Ссылка на обложку трека (100x100 пикселей)
            collectionName = track.collectionName, // Название альбома
            releaseDate = track.releaseDate, // Дата выпуска
            primaryGenreName = track.primaryGenreName, // Основной жанр
            country = track.country, // Страна
            previewUrl = track.previewUrl // Ссылка на превью трека
        )
    }
}