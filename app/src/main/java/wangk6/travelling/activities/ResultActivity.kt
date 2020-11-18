package wangk6.travelling.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import op.wangk6.travelling.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(wangk6.travelling.activities.Constants.USER_NAME)
        tv_name.text = username
        val totalQuestions = intent.getIntExtra(wangk6.travelling.activities.Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(wangk6.travelling.activities.Constants.CORRECT_ANSWERs,0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}