package com.example.addspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addspinner.json.*

class StateAdapter(var listRow:ArrayList<State>):RecyclerView.Adapter<StateAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        var oneState=listRow[position]
        holder.setStates(oneState)

    }

    override fun getItemCount(): Int {
        return listRow.size
    }

    class TableViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       var firstItem:TextView=itemView.findViewById(R.id.firstItem)
        var showTarget:TextView=itemView.findViewById(R.id.targetItem)
        var showActual:TextView=itemView.findViewById(R.id.actualItem)
        var showpercentage:TextView=itemView.findViewById(R.id.percentageItem)

        fun setStates(oneState: State){
           firstItem.text=oneState.state
            showTarget.text=oneState.target
            showActual.text=oneState.actual
            showpercentage.text=oneState.percent
        }
    }
}