package jp.techacademy.huyen.duong.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView.OnItemClickListener
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import jp.techacademy.huyen.duong.ui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button1.setText("ボタン")
        binding.button1.setOnClickListener(this)
        binding.textview.setText("テキストビュー")
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button1 -> binding.textview.setText(binding.edittext.text.toString())
            R.id.button2 -> showAleartDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
            R.id.button5 -> showImageView()
            R.id.button6 -> showListView(binding.edittext.text.toString())
        }
    }
    // aleart dialog
    private fun showAleartDialog() {
        val aleartDialog = AlertDialog.Builder(this)
        aleartDialog.setTitle("アラトダイアログ")
        aleartDialog.setMessage("ダイアログメッセージ")
        aleartDialog.setPositiveButton("肯定"){
            dialog,which -> Log.d(MY_TAG,"肯定ボタン")
        }
        aleartDialog.setNeutralButton("中立"){
            _,_ -> Log.d(MY_TAG,"中立ボタン") // 使わない引数:　_
        }
        aleartDialog.setNegativeButton("否定"){
            _,_-> Log.d(MY_TAG,"否定ボタン")
        }
        val aleart = aleartDialog.create()
        aleart.show()
    }
    // Time picker Dialog
    private fun showTimePickerDialog() {
        Log.d(MY_TAG,"Time picker")
        val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener({
            view,hour,minute -> Log.d(MY_TAG, "$hour : $minute")
        }), 17, 7, true)
        timePickerDialog.show()
    }
    // Date picker Dialog
    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener({
            _,year,month,date -> Log.d(MY_TAG,"$date / $month / $year")
        }),2023,11,13)// month: 0-11
        datePickerDialog.show()
    }
    //show image view
    private fun showImageView() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
    //show List view
    private fun showListView(value : String) {
        val intent = Intent(this, ThreeActivity::class.java)
        intent.putExtra("value",value)
        startActivity(intent)
    }
}

const val MY_TAG: String = "MY_TAG"