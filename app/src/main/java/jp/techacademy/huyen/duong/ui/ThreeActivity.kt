package jp.techacademy.huyen.duong.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.SimpleAdapter
import jp.techacademy.huyen.duong.ui.databinding.ActivityThreeBinding

class ThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val value = intent.getStringExtra("value")
        binding.textview.setText(value)
        // List view
        val list = ArrayList<Map<String,String>>()
        for (i in 1..5) {
            var map = HashMap<String,String>()
            map["main"] = "メイン　$i"
            map["sub"] = "サブ　$i"
            list.add(map)
        }
        val adapter = SimpleAdapter(this,
            list,android.R.layout.simple_list_item_2 ,
            arrayOf("main","sub"),
            intArrayOf(android.R.id.text1,android.R.id.text2)
        )
        binding.listview.adapter = adapter
        binding.listview.setOnItemClickListener(AdapterView.OnItemClickListener({ parent, view, position, id ->
            Log.d(MY_TAG, "ポジション：$position")
        }))
    }
}