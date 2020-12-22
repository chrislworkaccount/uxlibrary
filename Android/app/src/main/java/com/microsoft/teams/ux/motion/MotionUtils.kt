package com.microsoft.teams.ux.motion

import android.content.Context
import android.view.View
import com.microsoft.teams.ux.model.MotionKey
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MotionUtils {
    var mMotionConfigs: HashMap<String, MotionConfig> = HashMap()
    val mMotionConfig: MotionConfig = MotionConfig()

    fun parseMotionConfigs(json: String) {
        val view1: View? = null
        val view2: View? = null
        val view3: View? = null


        val overlayInChatOnEnterPlayer: MotionPlayer = Motion().applyWithKey(MotionKey.OVERLAY_IN_CHAT_ON_REVEAL,
            view1, view2, view3
        ).build()
        overlayInChatOnEnterPlayer.play()
    }

    fun fetchMotionConfigs(context: Context): String {
        val reader = (context.getAssets().open("motion_comfigs.json")
            ?: throw RuntimeException("Cannot open file: file name"))
            .bufferedReader()

        val lines = reader.useLines { sequence: Sequence<String> ->
            sequence.reduce { a, b -> "$a\n$b" }
        }
        return lines
    }
}