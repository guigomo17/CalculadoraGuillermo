package dev.lizarraga.interfazusuariocalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import dev.lizarraga.interfazusuariocalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var op: Int =0
    var nu1: Double = 0.0
    var te: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.btEqual.setOnClickListener {
            var nu2 = binding.tvResult.text.toString().toDouble()
            var re = 0.0
            when(op) {
                1-> re = nu1 + nu2
                2-> re = nu1 - nu2
                3-> re = nu1 * nu2
                4-> re = nu1 / nu2
            }
            binding.tvResult.setText(re.toString())
            te = ""
        }
        binding.btClear.setOnClickListener {
            binding.tvResult.setText("")
            te = ""
            op=0
        }
    }

    fun clNumber(view: View) {
        var nu2 = binding.tvResult.text.toString()
        when(view.id) {
               R.id.cero -> binding.tvResult.setText(nu2 + "0")
                R.id.uno -> binding.tvResult.setText(nu2 + "1")
                R.id.dos -> binding.tvResult.setText(nu2 + "2")
               R.id.tres -> binding.tvResult.setText(nu2 + "3")
             R.id.cuatro -> binding.tvResult.setText(nu2 + "4")
              R.id.cinco -> binding.tvResult.setText(nu2 + "5")
               R.id.seis -> binding.tvResult.setText(nu2 + "6")
              R.id.siete -> binding.tvResult.setText(nu2 + "7")
               R.id.ocho -> binding.tvResult.setText(nu2 + "8")
              R.id.nueve -> binding.tvResult.setText(nu2 + "9")
            R.id.btComma -> binding.tvResult.setText(nu2 + ".")
        }
    }

    fun clOperation(view: View) {
        var nu2 = binding.tvResult.text.toString()
        nu1 = nu2.toString().toDouble()
        binding.tvResult.setText("")
        when(view.id) {
            R.id.btAddition -> {
                te = nu2 + "+"
                op = 1
            }
            R.id.btSubtraction -> {
                te = nu2 + "-"
                op = 2
            }
            R.id.btMultiplication -> {
                te = nu2 + "*"
                op = 3
            }
            R.id.btDivision -> {
                te = nu2 + "/"
                op = 4
            }
        }
    }
}