package wangk6.travelling.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import op.wangk6.travelling.R
import wangk6.travelling.activities.QuizQuestionActivity
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.fragment_quiz.view.*

class QuizFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        view.btn_start.setOnClickListener {
            if (input_name.text?.isBlank()!!) {
                input_name.error = getString(R.string.input_empty)
            } else {
                activity?.let {
                    val intent = Intent(it, QuizQuestionActivity::class.java)
                    intent.putExtra(wangk6.travelling.activities.Constants.USER_NAME,input_name.text.toString() )
                    it.startActivity(intent)

                }
            }
        }

        return view
    }
}