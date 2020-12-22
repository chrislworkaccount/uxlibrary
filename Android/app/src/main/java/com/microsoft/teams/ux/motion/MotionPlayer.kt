package com.microsoft.teams.ux.motion

open class MotionPlayer constructor(motion: Motion) : AbstractMotionPlayer() {

    val mMotion = motion
    fun play() {
        if (mAnimationEnabled) mMotion.animatorSet()?.start() else return
    }

    fun pause() {
        //no-op pause
    }

    fun reverse() {
        //no-op reverse
    }
}

