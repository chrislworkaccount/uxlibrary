package com.microsoft.teams.ux.illustration

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import com.microsoft.teams.ux.R
import com.microsoft.teams.ux.model.Keys
import com.microsoft.teams.ux.model.Theme
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap
import kotlin.collections.filter as filter


open class Illustration @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), IllustrationHelper.IllustrationListener {
    val mIllustrationView: LottieAnimationView = LottieAnimationView(context)
    var mKey: Int = 0
    var mTheme: Int = 0
    var mColorMap: String = ""

    override fun onIllustrationFetched(illustration: Int, colorMap: String) {
        mColorMap = colorMap
        mIllustrationView.setAnimation(illustration)
        mIllustrationView.setOnClickListener(View.OnClickListener {
            parseColorFilter(getEnumStringForTheme(mTheme), mColorMap)
        })
        addView(mIllustrationView)
    }

    fun applyColorFilter(cmap: LinkedTreeMap<String, String>) {
        val filter = SimpleColorFilter(Color.parseColor(cmap.get("color")))
        val keyPath = parseKeyPath(cmap.get("keypath") as String)
        val callback = LottieValueCallback<ColorFilter>(filter)
        mIllustrationView.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback)
    }

    fun parseColorFilter(theme: String, json: String) {
        var versions =
            Gson().fromJson(
                json,
                ArrayList::class.java
            ) as List<LinkedTreeMap<String, ArrayList<LinkedTreeMap<String, String>>>>
        for (cmaps in versions as ArrayList<LinkedTreeMap<String, String>>) {
            if (cmaps.get("version").equals(theme)) {
                for (ltm in cmaps.get("colormaps") as ArrayList<LinkedTreeMap<String, String>>) {
                    applyColorFilter(ltm)
                }
            }
        }
    }

    fun parseKeyPath(parts: String): KeyPath {
        val keys: List<String> = parts?.split(",") as List<String>
        return KeyPath(keys[0], keys[1], keys[2], "**")
    }

    fun getEnumStringForTheme(enum: Int): String {
        return Theme.values()[enum].name.toLowerCase(Locale.ENGLISH)
    }

    fun getEnumStringForKey(enum: Int): String {
        return Keys.values()[enum].name.toLowerCase(Locale.ENGLISH)
    }

    init {
        gravity = CENTER_IN_PARENT
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.Illustration)
            mKey = a.getInt(R.styleable.Illustration_illustration_key, 0)
            mTheme = a.getInt(R.styleable.Illustration_illustration_theme, 0)
            IllustrationHelper.fetchBaseIllustration(context, getEnumStringForKey(mKey), this)
        }
    }
}