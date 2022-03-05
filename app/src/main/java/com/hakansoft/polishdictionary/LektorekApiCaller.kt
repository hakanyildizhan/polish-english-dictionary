package com.hakansoft.polishdictionary

import android.util.Log
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.*
import okio.IOException
import ru.gildor.coroutines.okhttp.await

class LektorekApiCaller : IApiCaller {
    private val client = OkHttpClient()

    override suspend fun getDefinitions(searchTerm: String, ignoreDiacritics: Boolean, partOfSpeech: String): SearchResponse? {
        if (searchTerm.isNullOrEmpty()) {
            return null
        }

        var normalizedSearchTerm = normalizeString(searchTerm)
        var requestUrl = "/lapi/v2/public/index.php/polish/search/${normalizedSearchTerm}?page_size=20&pos=${partOfSpeech}&diacritics=${if (ignoreDiacritics) "true" else "false"}"

        val request = Request.Builder()
            .url("https://www.lektorek.org${requestUrl}")
            //.header(":authority:", "www.lektorek.org")
            //.header(":method:", "GET")
            //.header(":path:", requestUrl)
            //.header(":scheme:", "https")
            .header("accept", "application/json, text/javascript, */*; q=0.01")
            .header("accept-encoding", "gzip, deflate, br")
            .header("accept-language", "en,en-US;q=0.9,tr;q=0.8")
            .header("dnt", "1")
            .header("referrer", "https://www.lektorek.org/polish/")
            .header("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98\"")
            .header("sec-ch-ua-mobile", "?0")
            .header("sec-ch-ua-platform", "Windows")
            .header("sec-fetch-dest", "empty")
            .header("sec-fetch-mode", "cors")
            .header("sec-fetch-site", "same-origin")
            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
            .header("x-requested-with", "XMLHttpRequest")
            .build()

        try {
            var response: Response = this.client.newCall(request).await()
            var resp = response.body!!.string()
            return Json.decodeFromString<SearchResponse>(resp)
        } catch (e: Exception) {
            Log.v("APICALL", e.message.toString())
            return null
        }
    }

    fun normalizeString(word: String) : String {
        var str = StringBuilder()

        for (char in word) {
            if (char == 'ą') {
                str.append("%C4%85")
            } else if (char == 'ć') {
                str.append("%C4%87")
            } else if (char == 'ę') {
                str.append("%C4%99")
            } else if (char == 'ł') {
                str.append("%C5%82")
            } else if (char == 'ń') {
                str.append("%C5%84")
            } else if (char == 'ó') {
                str.append("%C3%B3")
            } else if (char == 'ś') {
                str.append("%C5%9B")
            } else if (char == 'ź') {
                str.append("%C5%BA")
            } else if (char == 'Ą') {
                str.append("%C4%84")
            } else if (char == 'Ć') {
                str.append("%C4%86")
            } else if (char == 'Ę') {
                str.append("%C4%98")
            } else if (char == 'Ł') {
                str.append("%C5%81")
            } else if (char == 'Ń') {
                str.append("%C5%83")
            } else if (char == 'Ó') {
                str.append("%C3%93")
            } else if (char == 'Ś') {
                str.append("%C5%9A")
            } else if (char == 'Ź') {
                str.append("%C5%B9")
            } else if (char == 'Ż') {
                str.append("%C5%BB")
            } else {
                str.append(char)
            }
        }
        return str.toString()
    }
}