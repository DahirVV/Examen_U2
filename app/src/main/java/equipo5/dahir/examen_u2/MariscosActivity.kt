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

class MariscosActivity : AppCompatActivity() {
    var mariscos=ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comida)

        agregarMariscos()

        var listview: ListView =findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this,mariscos)
        listview.adapter=adaptador
    }

    fun agregarMariscos(){
        mariscos.add(Producto("Caldo de cangrejo",R.drawable.caldomariscos,"Caldo de cangrejo frescos",11.99))
        mariscos.add(Producto("Sopa de mariscos",R.drawable.caldomariscos,"Sopa de mariscos frescos",15.75))
        mariscos.add(Producto("Tacos de pescado",R.drawable.tacos2,"Sopa de mariscos frescos",2.35))
        mariscos.add(Producto("Tostada de ceviche",R.drawable.tostceviche,"Tostada de ceviche de pescado",3.55)
    }

    private class AdaptadorProductos: BaseAdapter {
        var mariscos=ArrayList<Producto>()
        var contexto: Context?=null

        constructor(context: Context, productos: ArrayList<Producto>){
            this.mariscos=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return mariscos.size
        }

        override fun getItem(p0: Int): Any {
            return mariscos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=mariscos[p0]
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