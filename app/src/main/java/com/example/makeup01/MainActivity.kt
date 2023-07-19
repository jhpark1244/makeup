package com.example.makeup01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makeup01.adapter.MakeUpTypeAdapter
import com.example.makeup01.data.MakeUpTypeData
import com.example.makeup01.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val makeUpTypeAdapter = MakeUpTypeAdapter()
    private val makeUpTypeData: ArrayList<MakeUpTypeData> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setData()
        setRV()
    }

    private fun setRV() {
        binding.rvMakeUpType.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = makeUpTypeAdapter.apply {
                itemClick = {oldPosition, newPosition ->

                    try{makeUpTypeAdapter.data[oldPosition].doSelected = false}catch(_: Exception){}
                    try{makeUpTypeAdapter.data[newPosition].doSelected = true}catch(_: Exception){}

                    selectedPosion = newPosition
                    reDrawItem(oldPosition, newPosition)

                    //Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setData() {
        makeUpTypeData.add(MakeUpTypeData("Gloamophic", false, false))
        makeUpTypeData.add(MakeUpTypeData("Glamoween", true, false))
        makeUpTypeData.add(MakeUpTypeData("Daniel chinchila", false, false))
        makeUpTypeData.add(MakeUpTypeData("Kwan Usamanee", false, false))
        makeUpTypeData.add(MakeUpTypeData("코스튬", false, false))
        makeUpTypeData.add(MakeUpTypeData("AR 메이크 오버", true, false))
        makeUpTypeData.add(MakeUpTypeData("K-pop", false, false))
        makeUpTypeData.add(MakeUpTypeData("J-pop", false, false))
        makeUpTypeData.add(MakeUpTypeData("christmas", true, false))
        makeUpTypeData.add(MakeUpTypeData("Winter", false, false))
        makeUpTypeData.add(MakeUpTypeData("옴므", true, false))
        makeUpTypeData.add(MakeUpTypeData("A/w", true, false))
        makeUpTypeData.add(MakeUpTypeData("내추럴", false, false))
        makeUpTypeData.add(MakeUpTypeData("summner", false, false))
        makeUpTypeData.add(MakeUpTypeData("Sweetie", false, false))

        makeUpTypeAdapter.setData(makeUpTypeData)
    }
}