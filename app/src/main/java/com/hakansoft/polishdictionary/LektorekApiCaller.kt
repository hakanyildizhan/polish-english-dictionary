package com.hakansoft.polishdictionary

import android.util.Log
import okhttp3.*
import okio.IOException
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class LektorekApiCaller : IApiCaller {
    private val client = OkHttpClient()

    override fun getDefinitions(searchTerm: String, ignoreDiacritics: Boolean, partOfSpeech: String): SearchResponse? {
        if (searchTerm.isNullOrEmpty()) {
            return null
        }

        val request = Request.Builder()
            .url("https://www.lektorek.org/lapi/v2/public/index.php/polish/search/${searchTerm}")
            .addHeader(":authority:", "www.lektorek.org")
            .addHeader(":method:", "GET")
            .addHeader(":path:", "/lapi/v2/public/index.php/polish/search/${searchTerm}?page_size=20&pos=${partOfSpeech}&diacritics=${if (ignoreDiacritics) "true" else "false"}")
            .addHeader(":scheme:", "https")
            .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
            .addHeader("accept-encoding", "gzip, deflate, br")
            .addHeader("accept-language", "en,en-US;q=0.9,tr;q=0.8")
            .addHeader("dnt", "1")
            .addHeader("referrer", "https://www.lektorek.org/polish/")
            .addHeader("x-requested-with", "XMLHttpRequest")
            .build()

        //var apiResponse: SearchResponse? = null
        /*
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.v("APICALL", e.message.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                apiResponse = Json.decodeFromString<SearchResponse>(response.body.toString())
            }
        })
        */

        try {
            var response: Response = this.client.newCall(request).execute()
            return Json.decodeFromString<SearchResponse>(response.body.toString())
        } catch (e: Exception) {
            Log.v("APICALL", e.message.toString())
        }

        return null
        //return apiResponse
    }
}