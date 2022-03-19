package equipo5.dahir.examen_u2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var btnComidas: Button =findViewById(R.id.btn_comidas) as Button

        btnComidas.setOnClickListener{
            var intent: Intent =Intent(this,ProductosActivity::class.java)
            startActivity(intent)
        }
    }
}