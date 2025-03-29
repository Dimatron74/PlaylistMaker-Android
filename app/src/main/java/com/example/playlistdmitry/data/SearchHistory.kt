
package com.example.playlistdmitry.data

import android.content.Context
import android.content.SharedPreferences
import com.example.playlistdmitry.data.model.TrackDto
import com.example.playlistdmitry.domain.model.Track
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SearchHistory(private val context: Context) {
    companion object {
        private const val SEARCH_PREFS_NAME = "SearchPrefs"
        private const val SEARCH_TEXT_KEY = "searchHistoryText"
        private const val MAX_HISTORY_SIZE = 10
    }

    private val sharedPreferences: SharedPreferences by lazy {

        context.getSharedPreferences(SEARCH_PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveHistory(newTrack: Track) {

        val trackDto = TrackCreator.map(newTrack)

        val historyList = getHistory().toMutableList()

        historyList.removeAll { it.trackId == newTrack.trackId }

        historyList.add(0, trackDto)

        if (historyList.size > MAX_HISTORY_SIZE) {
            historyList.removeAt(historyList.size - 1)
        }
        val historyJson = Gson().toJson(historyList)
        sharedPreferences.edit().putString(SEARCH_TEXT_KEY, historyJson).apply()
    }

    fun getHistory(): List<TrackDto> {
        val historyJson = sharedPreferences.getString(SEARCH_TEXT_KEY, null)
        return if (historyJson != null) {
            try {
                val historyType = object : TypeToken<MutableList<TrackDto>>() {}.type
                Gson().fromJson<MutableList<TrackDto>>(historyJson, historyType).toList()
            } catch (e: Exception) {
                mutableListOf()
            }
        } else {
            mutableListOf()
        }
    }

    fun clearHistory() {
        sharedPreferences.edit().remove(SEARCH_TEXT_KEY).apply()
    }
}