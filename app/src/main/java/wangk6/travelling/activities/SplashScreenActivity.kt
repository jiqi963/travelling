package wangk6.travelling.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import op.wangk6.travelling.R
import kotlinx.android.synthetic.main.splashscreen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)

    Logo.alpha =0f
    Logo.animate().setDuration(1500).alpha(1f).withEndAction {
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        finish()
    }
    }
}