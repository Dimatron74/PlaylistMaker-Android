
package com.example.playlistdmitry.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.playlistdmitry.R
import com.example.playlistdmitry.domain.model.Track
import com.example.playlistdmitry.util.toPx

class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cornerRadiusValue = 2

    companion object {
        private const val SEPARATOR = "\u2022"
    }


    private val trackNameTextView: TextView = itemView.findViewById(R.id.songTitle)
    private val artistNameTextView: TextView = itemView.findViewById(R.id.songArtist)
    private val artworkImageView: ImageView = itemView.findViewById(R.id.songImage)

    fun bind(track: Track) {
        trackNameTextView.text = track.trackName
        artistNameTextView.text =
            "${track.artistName} $SEPARATOR ${formatTrackDuration(track.trackTimeMillis)}"

        Glide.with(itemView)
            .load(track.artworkUrl100)
            .placeholder(R.drawable.placeholder_music)
            .transform(RoundedCorners(itemView.context.toPx(cornerRadiusValue).toInt()))
            .into(artworkImageView)
    }

    private fun formatTrackDuration(trackTimeMillis: Long): String {
        val minutes = (trackTimeMillis / 1000) / 60
        val seconds = (trackTimeMillis / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}