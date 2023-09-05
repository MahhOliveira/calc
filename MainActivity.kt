import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextWeight = findViewById(R.id.editTextWeight)
        editTextHeight = findViewById(R.id.editTextHeight)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener { calculateBMI() }
    }

    private fun calculateBMI() {
        val weight = editTextWeight.text.toString().toDouble()
        val height = editTextHeight.text.toString().toDouble()

        if (weight <= 0 || height <= 0) {
            textViewResult.text = "Informe valores válidos."
            return
        }

        val bmi = weight / (height * height)
        val bmiResult = String.format("Seu IMC é %.2f", bmi)

        textViewResult.text = bmiResult
    }
}
