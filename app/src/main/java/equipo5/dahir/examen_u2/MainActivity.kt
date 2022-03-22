package equipo5.dahir.examen_u2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnmenu: Button =findViewById(R.id.btn_get_started) as Button

        btnmenu.setOnClickListener{
            var intent: Intent = Intent(this,Menu_Activity::class.java)
            startActivity(intent)
        }
    }
}