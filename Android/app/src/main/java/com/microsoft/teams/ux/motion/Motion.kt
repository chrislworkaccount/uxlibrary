package com.microsoft.teams.ux.motion

import android.animation.AnimatorSet
import android.content.Context
import android.view.View
import com.microsoft.teams.ux.model.MotionKey
import java.util.*

class Motion {

    val mMotionPlayer: MotionPlayer = MotionPlayer(this)
    val mAnimatorSet: AnimatorSet = AnimatorSet()
    fun animatorSet() : AnimatorSet? {
       return null
    }

    fun build() : MotionPlayer {
        return mMotionPlayer
    }

    fun applyTo(view: View, vararg motionType: MotionType): Motion {
        return this

    }

    fun applyWithKey(key: MotionKey, vararg view: View?): Motion {
        return this
    }
}

