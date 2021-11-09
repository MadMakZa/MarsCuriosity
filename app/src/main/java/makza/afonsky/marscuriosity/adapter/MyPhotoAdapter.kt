package makza.afonsky.marscuriosity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_container.view.*
import makza.afonsky.marscuriosity.R
import makza.afonsky.marscuriosity.data.Photos

class MyPhotoAdapter(private val context: Context, private val photoList: MutableList<Photos>):
    RecyclerView.Adapter<MyPhotoAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.ivPhoto

        fun bind(listItem: Photos) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.ivPhoto}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_container, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = photoList[position]
        holder.bind(listItem)

        Picasso.get().load(photoList[position].imgSrc).into(holder.image)
    }

}