# Custom ToggleButton with Kotlin
A custom switch class with modification in :
- On icon
- Off icon
- Disable icon
- Enable icon


## Tech Stack
Kotlin

<p align="center">Off status</p>
<p align="center">
  <img src="https://github.com/mahbubejahanbazi/Togcustom_toggle_buttongleButton/blob/main/images/off_status.jpg" />
  
</p>

<p align="center">On status</p>
<p align="center">
  <img src="https://github.com/mahbubejahanbazi/custom_toggle_button/blob/main/images/on_status.jpg" />
</p>

<p align="center">Disable status</p>
<p align="center">
  <img src="https://github.com/mahbubejahanbazi/custom_toggle_button/blob/main/images/disable_status.jpg" />
</p>

## Source code

CustomFlatToggle.kt
```kotlin
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


    fun setIcons(onIcon: Drawable, offIcon: Drawable, disableIcon: Drawable) {
        this.disableIcon = disableIcon
        selector = StateListDrawable()
        selector.addState(intArrayOf(android.R.attr.state_checked), onIcon)
        selector.addState(intArrayOf(), offIcon)
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
```

MainActivity.kt
```kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val root: RelativeLayout = findViewById(R.id.main_activity_root);
        val cBFlatToggleBtn = CustomFlatToggle(this);
        val drawableOn = resources.getDrawable(R.drawable.ic_filter_on, null)
        val drawableOff = resources.getDrawable(R.drawable.ic_filter_off, null)
        val drawableDisable = resources.getDrawable(R.drawable.ic_filter_disable, null)
        cBFlatToggleBtn.setIcons(drawableOn, drawableOff, drawableDisable)
        cBFlatToggleBtn.id = ViewCompat.generateViewId()
        root.addView(cBFlatToggleBtn, object : RelativeLayout.LayoutParams(200, 200) {
            init {
                addRule(RelativeLayout.ALIGN_PARENT_TOP)
                addRule(RelativeLayout.CENTER_HORIZONTAL)
                topMargin=200
            }
        })
        val button = Button(this);
        button.text = "Disable filter"
        button.transformationMethod = null
        button.setOnClickListener(View.OnClickListener {
            if (cBFlatToggleBtn.isEnabled) {
                button.text = "Enable filter"
                cBFlatToggleBtn.isEnabled = false
            } else {
                button.text = "Disable filter"
                cBFlatToggleBtn.isEnabled = true
            }
        })
        root.addView(button, object : RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT) {
            init {
                addRule(RelativeLayout.BELOW, cBFlatToggleBtn.id)
                addRule(RelativeLayout.CENTER_HORIZONTAL)
                topMargin = 100
            }
        })
    }
}
```


## Contact

mjahanbazi@protonmail.com