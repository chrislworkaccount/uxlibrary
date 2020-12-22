package com.microsoft.teams.ux.illustration

import android.content.Context
import com.microsoft.teams.ux.R
import java.util.*

class IllustrationHelper() {

    companion object {
        @JvmStatic
        fun create(): IllustrationHelper = IllustrationHelper()

        fun fetchBaseIllustration(
            context: Context,
            key: String,
            listener: IllustrationListener
        ) {
            listener.onIllustrationFetched(
                fetchBaseIllustration(context, key),
                fetchColorMapForKey(context, key)
            )
        }

        fun fetchBaseIllustration(context: Context, key: String): Int {
            //return - some service fetch me my lottie file
            return R.raw.onboarding //this will come from a service. hard coded for now
        }

        fun fetchColorMapForKey(context: Context, key: String): String {
            val reader = (context.getAssets().open("color_profiles.json")
                ?: throw RuntimeException("Cannot open file: file name"))
                .bufferedReader()

            val lines = reader.useLines { sequence: Sequence<String> ->
                sequence.reduce { a, b -> "$a\n$b" }
            }
            return lines
        }
    }

    interface IllustrationListener {
        fun onIllustrationFetched(illustration: Int, colorMap: String)
    }
}
