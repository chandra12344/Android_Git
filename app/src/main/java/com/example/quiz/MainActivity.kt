package com.example.quiz

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiztestapp.ItemsViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CustomAdapter
    var i: Int = 0
    var r: Int = 0
    var w: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
//        binding.rec.layoutManager = LinearLayoutManager(this)
        binding.rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rec.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return true
            }
        })
        val mList = ArrayList<ItemsViewModel>()
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "1) Android is -",
                "an operating system",
                "a web browser",
                "a web server",
                "None of the above",
                "A"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "  2) Under which of the following Android is licensed?",
                "a) OSS",
                "b) Sourceforge",
                "c) Apache/MIT",
                "d) None of the above",
                "C"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                " 3) For which of the following Android is mainly developed?",
                "a)  Servers",
                "b)  Desktops",
                "c)  Laptops",
                "d)  Mobile devices",
                "D"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "4) Which of the following is the first mobile phone released that ran the Android OS?",
                "a)  HTC Hero",
                "b) Google gPhone",
                "c) T - Mobile G1",
                "d) None of the above",
                "C"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "5) Which of the following virtual machine is used by the Android operating system?",
                "a) JVM",
                "b)  Dalvik virtual machine",
                "c)  Simple virtual machine",
                "d) None of the above",
                "B"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "6) Android is based on which of the following language?",
                "a) Java",
                "b) C++",
                "c) C",
                "d) None of the above",
                "A"
            )
        )
        mList.add(
            ItemsViewModel(
                R.drawable.ic_baseline_folder_24,
                "7) APK stands for -",
                "a) Android Phone Kit",
                "b) Android Page Kit",
                "c) Android Package Kit",
                "d) None of the above",
                "C"
            )
        )
        adapter = CustomAdapter(mList, this)
        binding.rec.adapter = adapter

        adapter.notifyDataSetChanged()
        binding.nextm.setOnClickListener {
            var str = sharedPreference.getString("userAns", "defaultName")
            if (str.equals("defaultName")) {
                Toast.makeText(this, "Please Select One Option!!", Toast.LENGTH_LONG).show()
            } else {
                if (i == 6) {
                    if (str!!.equals(mList[i].rightAnstion)) {
                        r++
                    } else {
                        w++
                    }
                    binding.quizlayout.visibility = View.GONE
                    binding.result.visibility = View.VISIBLE
                    binding.iCount.text="Wrong : "+w;
                    binding.cCount.text="Right : "+r
                    binding.sCount.text="Your Score : "+r*5
                } else {
                    if (i == 5) {
                        binding.nextm.text = "Submit"
                    }
                    if (str!!.equals(mList[i].rightAnstion)) {
                        r++
                    } else {
                        w++
                    }
                    i++
                    binding.rec.scrollToPosition(i);
                }
                editor.putString("userAns", "defaultName")
                editor.commit()
            }


        }
        binding.finish.setOnClickListener {
            finish()
        }
        setContentView(binding.root)
    }
}