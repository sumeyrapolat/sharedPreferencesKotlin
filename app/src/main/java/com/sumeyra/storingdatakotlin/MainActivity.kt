package com.sumeyra.storingdatakotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sumeyra.storingdatakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPreferences -> XML File -> key - value
        //putInt() getInt()
        sharedPreferences = this.getSharedPreferences("com.sumeyra.storingdatakotlin", MODE_PRIVATE)
        val userSharedPreferences = sharedPreferences.getInt("myAge",-1)
        if (userSharedPreferences == -1){
            binding.textView.text ="Your Age: "
        }else{
            binding.textView.text= "Your age: ${userSharedPreferences}"
        }

    }

    fun save(view : View){
    val myAge= binding.editTextText.text.toString().toIntOrNull()
        if (myAge!=null){
            // stringin içine kod ya da değişkeni verebilmek için ${} koyuyoruz
            binding.textView.text ="Your Age: ${myAge}"
            sharedPreferences.edit().putInt("myAge", myAge).commit()
        } else{
            binding.textView.text ="Please Enter Your Age"
        }

    }

    fun delete(view : View){
        val userSharedPreferences = sharedPreferences.getInt("myAge",-1)
        if (userSharedPreferences != -1){

            sharedPreferences.edit().remove("myAge").apply()
            binding.textView.text="Your Age: "
        }

    }

}