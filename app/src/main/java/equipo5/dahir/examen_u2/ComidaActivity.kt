package equipo5.dahir.examen_u2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ComidaActivity : AppCompatActivity() {

    var comidas=ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comida)

        agregarComidas()

        var listview: ListView =findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this,comidas)
        listview.adapter=adaptador
    }

    fun agregarComidas(){
        comidas.add(Producto("Tacos",R.drawable.tacos,"Tacos varios",2.35))
        comidas.add(Producto("Burritos",R.drawable.burritos,"Burritos varios",11.79))
        comidas.add(Producto("Quesadillas",R.drawable.fajitaquesadilla,"Quesadillas de fajita",12.49))
        comidas.add(Producto("Huaraches",R.drawable.huarache,"Tortilla gruesa con frijoles",9.87))
        comidas.add(Producto("Torta",R.drawable.torta,"Tortas varias",10.95))
        comidas.add(Producto("Torta Cubana",R.drawable.tortacubana,"Torta cubana",12.35))
        comidas.add(Producto("Caldo de res",R.drawable.caldores,"Caldo de carne de res",5.99))
        comidas.add(Producto("Pozole",R.drawable.tacos,"Pozole(solo los fines de semana)",5.99))
        comidas.add(Producto("Menudo",R.drawable.tacos,"Menudo(miercoles a domingo)",5.99))
        comidas.add(Producto("Extras",R.drawable.salsa_bar,"Salsa con totopos",2.25))

    }

    private class AdaptadorProductos: BaseAdapter {
        var comidas=ArrayList<Producto>()
        var contexto: Context?=null

        constructor(context: Context, productos: ArrayList<Producto>){
            this.comidas=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return comidas.size
        }

        override fun getItem(p0: Int): Any {
            return comidas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=comidas[p0]
            var inflador= LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view,null)

            var imagen=vista.findViewById(R.id.producto_img) as ImageView
            var nombre=vista.findViewById(R.id.producto_nombre ) as TextView
            var desc=vista.findViewById(R.id.producto_desc) as TextView
            var precio=vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.descripcion)
            precio.setText("$${prod.precio}")
            return vista
        }
    }
}