package ir.mjahanbazi.customtogglebutton

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatToggleButton

open class CustomFlatToggle : AppCompatToggleButton {
    private lateinit var selector: StateListDrawable
    private lateinit var disableIcon: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        text = null
        textOn = null
        textOff = null
    }


    fun setIcons(iconOn: Drawable, iconOff: Drawable, drawableDisable: Drawable) {
        disableIcon = drawableDisable
        selector = StateListDrawable()
        selector.addState(intArrayOf(android.R.attr.state_checked), iconOn)
        selector.addState(intArrayOf(), iconOff)
        background = selector
    }

    override fun setEnabled(enabled: Boolean) {
        if (enabled) {
            background = selector
        } else {
            background = disableIcon
        }
        super.setEnabled(enabled)
    }

}

