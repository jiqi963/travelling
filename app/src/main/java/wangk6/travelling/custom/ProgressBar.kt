package wangk6.travelling.custom

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import op.wangk6.travelling.R

class ProgressBar(context: Context) {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val view: View = inflater.inflate(R.layout.progress_bar, null)
    private val dialog = Dialog(context, R.style.AppTheme_ProgressBar)

    fun show(){
        dialog.setContentView(view)
        dialog.show()
    }

    fun dismiss(){
        dialog.dismiss()
    }

}