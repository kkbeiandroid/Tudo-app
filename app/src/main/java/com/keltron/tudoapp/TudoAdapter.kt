package com.keltron.tudoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_task_item.view.*

class TudoAdapter(private val tudos:MutableList<Tudo>): RecyclerView.Adapter<TudoAdapter.TudoViewHolder>()   {

    //viewholder class
    class TudoViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    //creating view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TudoViewHolder {
        return TudoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_task_item,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: TudoViewHolder, position: Int) {
        val currentTudo = tudos.get(position)
        holder.itemView.textView.text = currentTudo.tudo;
        holder.itemView.checkBox.isChecked = currentTudo.isChecked
        holder.itemView.checkBox.setOnCheckedChangeListener{_,isChecked,->}
        currentTudo.isChecked = !currentTudo.isChecked
    }

    override fun getItemCount(): Int {
        return  tudos.size
    }
    // add  item
 fun addTudo(tudo: Tudo){
     tudos.add(tudo)
     notifyItemInserted(tudos.size -1)
 }
}