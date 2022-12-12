package com.shoppi.android.util

import android.content.Context

class AssetLoader {

    fun getJsonString(context : Context, FileName : String) : String? {

        return kotlin.runCatching {
            loadAsset(context, FileName)
        }.getOrNull()

    }
    // loadAsset은 여기 클래스에서만 생성되고, getJsonString 함수로 호출되어 외부에서 불러지도록 할것임
    private fun loadAsset(context : Context, fileName : String) : String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }

}