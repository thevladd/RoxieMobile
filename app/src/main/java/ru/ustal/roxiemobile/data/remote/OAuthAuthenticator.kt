package ru.ustal.roxiemobile.data.remote

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import ru.ustal.roxiemobile.App
import ru.ustal.roxiemobile.R

class OAuthAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request {

        return response.request.newBuilder()
            .header("Authorization", App.get().getString(R.string.pixels_api_key))
            .build()
    }

}