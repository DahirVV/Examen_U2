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

class BebidasActivity : AppCompatActivity() {

    var bebidas=ArrayList<Producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebidas)

        agregarBebidas()

        var listview: ListView =findViewById(R.id.litview) as ListView
        var adaptador: AdaptadorProductos=AdaptadorProductos(this,bebidas)
        listview.adapter=adaptador

    }

    fun agregarBebidas(){
        bebidas.add(Producto("Bebidas",R.drawable.bebida_1,"Bebidas varias",2.35))
        bebidas.add(Producto("Bebidas c/alcohol",R.drawable.bebida_2,"Bebidas con alcohol",2.35))
        bebidas.add(Producto("La mamalona",R.drawable.bebida_3,"Michelada con camarones",12.99))
        bebidas.add(Producto("MIchelada",R.drawable.michelada,"Micheladas",6.75))
    }

    private class AdaptadorProductos: BaseAdapter {
        var bebidas=ArrayList<Producto>()
        var contexto: Context?=null

        constructor(context: Context, productos: ArrayList<Producto>){
            this.bebidas=productos
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return bebidas.size
        }

        override fun getItem(p0: Int): Any {
            return bebidas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=bebidas[p0]
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