package ir.mjahanbazi.customtogglebutton

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
                addRule(RelativeLayout.CENTER_IN_PARENT)
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
