package wangk6.travelling.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import op.wangk6.travelling.R
import kotlinx.android.synthetic.main.activity_quiz_question.*


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPositon: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionlist = wangk6.travelling.activities.Constants.getQuestions()
        Log.i("Question Size", "${questionlist.size}")

        mUserName = intent.getStringExtra(wangk6.travelling.activities.Constants.USER_NAME)

        mQuestionList = wangk6.travelling.activities.Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion() {
        val question: Question? = mQuestionList!![mCurrentPositon - 1]

        defaultOptionView()

        if (mCurrentPositon == mQuestionList!!.size) {
            btn_submit.text = getString(R.string.finish)
        } else {
            btn_submit.text = getString(R.string.submit)
        }

        progress_bar.progress = mCurrentPositon
        tv_progeress.text = "$mCurrentPositon" + "/" + progress_bar.max

        tv_quesion.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectOptionView(tv_option_four, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPositon++

                    when {
                        mCurrentPositon <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this, getString(R.string.finishQuiz), Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(wangk6.travelling.activities.Constants.USER_NAME, mUserName)
                                .putExtra(wangk6.travelling.activities.Constants.CORRECT_ANSWERs,mCorrectAnswer)
                                .putExtra(wangk6.travelling.activities.Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPositon - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    if (mCurrentPositon == mQuestionList!!.size) {
                        btn_submit.text = getString(R.string.finish)
                    } else {
                        btn_submit.text = getString(R.string.next)
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }

    }


    private fun selectOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_options_bg)
    }
}