package com.microsoft.teams.ux.motion

import android.content.Context
import android.view.animation.Interpolator

class MotionConfig {

    val motionType: List<MotionType> = ArrayList()
    var mMotionKey: String? = null
    var mDuration: Int = 0
    var mType: MotionType = MotionType.SCALE_IN
    var mInterpolator: Interpolator? = null

    fun fetchMotionConfigForKey(context: Context, key: String): String {
        val reader = (context.getAssets().open("motion_config.json")
            ?: throw RuntimeException("Cannot open file: file name"))
            .bufferedReader()

        val lines = reader.useLines { sequence: Sequence<String> ->
            sequence.reduce { a, b -> "$a\n$b" }
        }
        return lines
    }

}