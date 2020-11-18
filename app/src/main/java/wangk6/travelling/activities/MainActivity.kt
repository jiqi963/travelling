package wangk6.travelling.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import op.wangk6.travelling.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_translate, R.id.navigation_quiz, R.id.navigation_about
            )
        )
        navView.setupWithNavController(navController)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        }else{
            Toast.makeText(applicationContext,"Press back again to exit the app",Toast.LENGTH_LONG).show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}