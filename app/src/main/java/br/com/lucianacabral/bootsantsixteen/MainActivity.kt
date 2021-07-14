package br.com.lucianacabral.bootsantsixteen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.lucianacabral.bootsantsixteen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button
    lateinit var mViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDados()
        initClick()
    }

    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.txtContador
        binding.btnDados
        binding.btnMostrar

        mViewModel.mContador.observe(this, Observer { valor ->
            binding.txtContador.setText(valor)
        })
    }

    private fun initClick() {
        binding.btnDados.setOnClickListener {
            mViewModel.Contador()

        }
        
        binding.btnMostrar.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "valor contador: ${mViewModel.mContador.value}",
                Toast.LENGTH_SHORT).show()
        }
    }
}