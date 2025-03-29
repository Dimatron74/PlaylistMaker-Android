package com.example.playlistdmitry.data.sharing

import com.example.playlistdmitry.domain.sharing.model.EmailData

interface ExternalNavigator {

    fun shareLink(link: String)

    fun openLink(link: String)

    fun openEmail(email: EmailData)
}