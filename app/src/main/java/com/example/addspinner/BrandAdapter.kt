package com.example.addspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addspinner.json.*

class BrandAdapter(var listRow:ArrayList<Brand>):RecyclerView.Adapter<BrandAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        var oneBrand=listRow[position]
        holder.setBrands(oneBrand)

    }

    override fun getItemCount(): Int {
        return listRow.size
    }

    class TableViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       var firstItem:TextView=itemView.findViewById(R.id.firstItem)
        var showTarget:TextView=itemView.findViewById(R.id.targetItem)
        var showActual:TextView=itemView.findViewById(R.id.actualItem)
        var showpercentage:TextView=itemView.findViewById(R.id.percentageItem)

        fun setBrands(rowItem: Brand){
           firstItem.text=rowItem.brand
            showTarget.text=rowItem.target
            showActual.text=rowItem.actual
            showpercentage.text=rowItem.percent
        }
    }
}