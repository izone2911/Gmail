package com.example.gmailrecycleview

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVCustom(val items:ArrayList<itemModel>): RecyclerView.Adapter<RVCustom.myViewHolder>() {
    class myViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var tag:TextView;
        lateinit var mesName:TextView;
        lateinit var mes:TextView;
        lateinit var date:TextView;
        lateinit var check:ImageButton;
       init{
           tag = itemView.findViewById<TextView>(R.id.tag);
           mesName = itemView.findViewById<TextView>(R.id.name);
           mes = itemView.findViewById<TextView>(R.id.mes);
           date = itemView.findViewById<TextView>(R.id.date);
           check = itemView.findViewById<ImageButton>(R.id.check);
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false);
        return myViewHolder(itemView);
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.tag.text = items[position].name[0].toString();
        holder.mesName.text = items[position].name;
        holder.mes.text = items[position].mes;
        holder.date.text = items[position].date;
        var style = arrayListOf<GradientDrawable>();
        repeat(4){
            var s = GradientDrawable();
            s.shape = GradientDrawable.OVAL
            s.setColor(Color.rgb((127.5 * (1 + Math.sin(it.toDouble()))).toInt(),(127.5 * (1 + Math.sin(it.toDouble()+2))).toInt(),(127.5 * (1 + Math.sin(it.toDouble()+4))).toInt()))
            style.add(s);
        }

        holder.tag.setBackground(style[position%4]);
        if(items[position].checked)holder.check.setImageResource(R.drawable.star__1_);else holder.check.setImageResource(R.drawable.star);
        holder.check.setOnClickListener {items[position].checked = !items[position].checked;
            notifyDataSetChanged();
        }

    }
}