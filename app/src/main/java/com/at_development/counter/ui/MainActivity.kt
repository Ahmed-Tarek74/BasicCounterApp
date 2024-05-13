package com.at_development.counter.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.at_development.counter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  val viewModel: CounterViewModel by viewModels { CounterViewModel.Factory }
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater) // Inflate using binding
        setContentView(viewBinding.root)

        viewModel.counter.observe(this) { counterValue ->
            // Update UI with new data
            viewBinding.counter.text = counterValue.toString()
        }

        viewBinding.plusBtn.setOnClickListener {
            viewModel.increaseCounter()
        }
        viewBinding.minusBtn.setOnClickListener {
            viewModel.decreaseCounter()
        }
        viewBinding.resetBtn.setOnClickListener {
            viewModel.resetCounter()
        }
    }


}