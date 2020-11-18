package wangk6.travelling.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import op.wangk6.travelling.R
import wangk6.travelling.activities.DarkTheme
import wangk6.travelling.activities.PhrasesActivity
import wangk6.travelling.enums.DownloadStatus
import wangk6.travelling.helpers.Language
import wangk6.travelling.helpers.RawDataAsyncTask
import wangk6.travelling.helpers.YandexAsyncTask
import wangk6.travelling.interfaces.IDataDownloadAvailable
import wangk6.travelling.interfaces.IDataDownloadComplete
import kotlinx.android.synthetic.main.fragment_translate.*
import java.util.*

class TranslateFragment : Fragment(), IDataDownloadAvailable,
    IDataDownloadComplete {
    private lateinit var rawDataAsyncTask: RawDataAsyncTask
    lateinit var mTTS: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val languages: Array<String> = resources.getStringArray(R.array.languages)
        populateSpinner(spinLang, languages)

        mTTS = TextToSpeech(context!!, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {

                val countrychoose = spinLang.selectedItem.toString()
                val langCode: String

                when (countrychoose) {
                    "Portuguese" -> langCode = "pt" // Brazil
                    "Spanish" -> langCode = "es" // México
                    "Chinese" -> langCode = "zh" // China
                    "Dutch" -> langCode = "nl" // Suriname
                    "French" -> langCode = "fr" // Canada
                    "Italian" -> langCode = "it" // Italy
                    "German" -> langCode = "de" // German
                    "Japanese" -> langCode = "ja" // Japan
                    else -> langCode = "en" // English-English
                }
                mTTS.language = Locale(langCode)
            } else {
                Log.e("TTS", "Initilization Failed!")
            }
        })

        btn_example.setOnClickListener {
            activity?.let {
                val intent = Intent(it, PhrasesActivity::class.java)
                it.startActivity(intent)
            }
        }

        btn_speech.setOnClickListener {
            //get text from edit text
            val toSpeak = txtVLang.text.toString()

            if (txtVLang.text?.isBlank()!!) {
                Toast.makeText(context!!,"Nothing to speech",Toast.LENGTH_LONG).show()
            } else {
                //if there is text in edit text
                mTTS.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
            }
        }

        btnLang.setOnClickListener {

            val fromLang = "en-"
            val language = Language()
            val toLang: String = language.code(spinLang.selectedItem.toString())
            val formatLang: String = fromLang + toLang
            if (edtTxtLang.text?.isBlank()!!) {
                edtTxtLang.error = getString(R.string.input_empty)
            } else {
                val url: String = createURI(
                    getString(R.string.base_url), getString(
                        R.string.key
                    ),
                    edtTxtLang.text.toString(), formatLang
                )
                rawDataAsyncTask =
                    RawDataAsyncTask(
                        this,
                        context!!
                    )
                rawDataAsyncTask.execute(url)
            }
        }

        // toggle button
        fun View.setSelectedIfDarkTheme() {
            isSelected = DarkTheme.isEnabled(context)
        }
        dayNightToggleButton.setSelectedIfDarkTheme()
        dayNightToggleButton.setOnClickListener {
            DarkTheme.apply(enabled = it.isSelected.not())
            it.setSelectedIfDarkTheme()
        }
    }

    private fun populateSpinner(spinner: Spinner, array: Array<String>) {
        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(context!!, layoutID, array)
    }

    private fun createURI(
        baseURL: String, key: String, text: String,
        lang: String
    ): String {
        return Uri.parse(baseURL)
            .buildUpon()
            .appendQueryParameter("key", key)
            .appendQueryParameter("text", text)
            .appendQueryParameter("lang", lang)
            .build().toString()
    }

    override fun onDataAvailable(data: String) {
        Log.d(
            getString(R.string.TAG), getString(
                R.string.on_data_available, data
            )
        )
        txtVLang.text = data
    }

    override fun onError(e: Exception) {
        Log.d(
            getString(R.string.TAG), getString(
                R.string.on_error, e.message
            )
        )
    }

    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            val yandexAsyncTask = YandexAsyncTask(this)
            yandexAsyncTask.execute(data)
        }
    }



}