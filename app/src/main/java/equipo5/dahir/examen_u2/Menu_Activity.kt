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
        var btnmariscos: Button =findViewById(R.id.btn_maricos) as Button
        var btnbebidas: Button =findViewById(R.id.btn_bebidas) as Button
        var btnsalir: Button =findViewById(R.id.btn_salir) as Button


        btnComidas.setOnClickListener{
            var intent: Intent =Intent(this,ComidaActivity::class.java)
            startActivity(intent)
        }
        btnmariscos.setOnClickListener{
            var intent: Intent =Intent(this,MariscosActivity::class.java)
            startActivity(intent)
        }
        btnbebidas.setOnClickListener{
            var intent: Intent =Intent(this,BebidasActivity::class.java)
            startActivity(intent)
        }
        btnsalir.setOnClickListener{
            var intent: Intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}