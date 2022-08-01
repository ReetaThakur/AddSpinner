package com.example.addspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.addspinner.json.Brand
import com.example.addspinner.json.Category
import com.example.addspinner.json.ResponseDTO
import com.example.addspinner.json.Zone

class TableAdapter(var listTable: ArrayList<ArrayList<ResponseDTO>>,var brandList:ArrayList<Brand>,
                   var zoneList:ArrayList<Zone>) :
    RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.table_layout, parent, false)
            return TableViewHolder(view)


    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        var onetable = listTable[position]

  //      holder.BrandViewHolder(view).setData(onetable.brands, "Brands")
 //       holder.CategoryViewHolder(view).setData(onetable.categories, "Category")
//        holder.setData(onetable.categories,"Category")
//        holder.setData(onetable.states,"States")
//        holder.setData(onetable.zones,"Zones")

    }

    override fun getItemCount(): Int {
        when(listTable){
            listTable[0] -> return brandList.size

            listTable[1] -> return zoneList.size
        }
        return listTable.size
    }


    class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



 //       fun setData(list:ArrayList<>)

//        inner class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            var firstHearder: TextView = itemView.findViewById(R.id.firstHeader)
//        //    var recyclerView: RecyclerView = itemView.findViewById(R.id.rowRecyclerView)
//
//            fun setData(list: List<Any>, column: String) {
//                firstHearder.text = column
////                recyclerView.apply {
////                    val rowAdapter = BrandAdapter(list as ArrayList<Brand>)
////                    val vertically =
////                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
////                    val linearLayoutManager =
////                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
////                    adapter = rowAdapter
////                    layoutManager = linearLayoutManager
////                    addItemDecoration(vertically)
////
////                }
//            }
//        }
//
//        inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            var firstHearder: TextView = itemView.findViewById(R.id.firstHeader)
//         //   var recyclerView: RecyclerView = itemView.findViewById(R.id.rowRecyclerView)
//
//            fun setData(list: List<Any>, column: String) {
//                firstHearder.text = column
////                recyclerView.apply {
////                    val rowAdapter = CategoryAdapter(list as ArrayList<Category>)
////                    val vertically =
////                        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
////                    val linearLayoutManager =
////                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
////                    adapter = rowAdapter
////                    layoutManager = linearLayoutManager
////                    addItemDecoration(vertically)
////
////                }
//            }
//        }

    }
}