package com.example.addspinner

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addspinner.json.*
import com.example.addspinner.response.ApiService
import com.example.addspinner.response.Network
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.table_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class DashboardActivity : AppCompatActivity(), View.OnClickListener {


    var brandListSpinner = ArrayList<String>()
    var categoryListSpinner = ArrayList<String>()
    var retailerListSpinner = ArrayList<String>()
    var asmListSpinner = ArrayList<String>()
    var distributorListSpinner = ArrayList<String>()

    var brandListResponse = ArrayList<Brand>()
    var categoryListResponse = ArrayList<Category>()
    var stateListResponse = ArrayList<State>()
    var zoneListResponse = ArrayList<Zone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)
        supportActionBar?.title = "Dashboard Feature"
        setData()
        btnFrom.setOnClickListener(this)
        btnTo.setOnClickListener(this)


    }
    private fun setSpinners(){
        val brandAdapter = ArrayAdapter(
            this@DashboardActivity,
            android.R.layout.simple_spinner_dropdown_item, brandListSpinner
        )
        brandSpinner.adapter = brandAdapter
        brandSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == brandListSpinner[0]) {
                    (view as TextView).setTextColor(Color.GRAY)

                } else {
                    Toast.makeText(
                        this@DashboardActivity,
                        brandListSpinner[position],
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DashboardActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

        val categoryAdapter = ArrayAdapter(
            this@DashboardActivity,
            android.R.layout.simple_spinner_dropdown_item, categoryListSpinner
        )
        categorySpinner.adapter = categoryAdapter
        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == categoryListSpinner[0]) {
                    (view as TextView).setTextColor(Color.GRAY)

                } else {

                    Toast.makeText(
                        this@DashboardActivity,
                        brandListSpinner[position],
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DashboardActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

        val retailerAdapter = ArrayAdapter(
            this@DashboardActivity,
            android.R.layout.simple_spinner_dropdown_item, retailerListSpinner
        )

        retailerSpinner.adapter = retailerAdapter
        retailerSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == retailerListSpinner[0]) {
                    (view as TextView).setTextColor(Color.GRAY)

                } else {

                    Toast.makeText(
                        this@DashboardActivity,
                        brandListSpinner[position],
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DashboardActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

        val asmAdapter = ArrayAdapter(
            this@DashboardActivity,
            android.R.layout.simple_spinner_dropdown_item, asmListSpinner
        )
        asmSpinner.adapter = asmAdapter
        asmSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == asmListSpinner[0]) {
                    (view as TextView).setTextColor(Color.GRAY)

                } else {

                    Toast.makeText(
                        this@DashboardActivity,
                        brandListSpinner[position],
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DashboardActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

        val distributorAdapter = ArrayAdapter(
            this@DashboardActivity,
            android.R.layout.simple_spinner_dropdown_item, distributorListSpinner
        )
        distributorSpinner.adapter = distributorAdapter
        distributorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if (value == distributorListSpinner[0]) {
                    (view as TextView).setTextColor(Color.GRAY)

                } else {

                    Toast.makeText(
                        this@DashboardActivity,
                        brandListSpinner[position],
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@DashboardActivity, "Error", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun setBrandRecyclerView() {
        brandHeaderLayout.firstHeader.text = "Brand"
        val brandAdapter = BrandAdapter(brandListResponse)
        val linearLayoutManager = LinearLayoutManager(this)
        val verticalDivider=DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        brandRecyclerView.apply {
            adapter = brandAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(verticalDivider)
            isNestedScrollingEnabled = false

        }
    }
    private fun setCategoryRecyclerView() {
        categoryHeaderLayout.firstHeader.text="Category"
        val categoryAdapter = CategoryAdapter(categoryListResponse)
        val linearLayoutManager = LinearLayoutManager(this)
        val verticalDivider=DividerItemDecoration(this,DividerItemDecoration.VERTICAL)

        categoryRecyclerView.apply {
            adapter = categoryAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(verticalDivider)
            isNestedScrollingEnabled = false

        }
    }
    private fun setZoneRecyclerView() {
        zoneHeaderLayout.firstHeader.text="Zone"
        val zoneAdapter = ZoneAdapter(zoneListResponse)
        val linearLayoutManager = LinearLayoutManager(this)
        val verticalDivider=DividerItemDecoration(this,DividerItemDecoration.VERTICAL)

        zoneRecyclerView.apply {
            adapter = zoneAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(verticalDivider)
            isNestedScrollingEnabled = false

        }
    }
    private fun setStateRecyclerView() {
        stateHeaderLayout.firstHeader.text="State"
        val stateAdapter = StateAdapter(stateListResponse)
        val linearLayoutManager = LinearLayoutManager(this)
        val verticalDivider=DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        stateRecyclerView.apply {
            adapter = stateAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(verticalDivider)
            isNestedScrollingEnabled = false

        }

    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnFrom -> setDate(btnFrom)
            R.id.btnTo -> setDate(btnTo)

        }
    }

    private fun setDate(button: AppCompatButton) {
        val materialDatePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        materialDatePicker.show(supportFragmentManager, "Tag_Picker")
        materialDatePicker.addOnPositiveButtonClickListener {
            button.text = materialDatePicker.headerText
        }
    }

    private fun setData() {
        val apiService = Network.getRetrofit().create(ApiService::class.java)
        apiService.getService("uspa").enqueue(object : Callback<ResponseDTO> {
            override fun onResponse(
                call: Call<ResponseDTO>,
                response: Response<ResponseDTO>
            ) {
                val result = response.body()
                orderNumber.text = result?.totalOrders
                netOrderNumber.text = result?.netValue
                netPendingNumber.text = result?.pendingNetValue
                response.body()?.let {
                    setDataForSpinners(it)
                    brandListResponse.addAll(it.brands)
                    stateListResponse.addAll(it.states)
                    zoneListResponse.addAll(it.zones)
                    categoryListResponse.addAll(it.categories)
                }
                setBrandRecyclerView()
                setCategoryRecyclerView()
                setZoneRecyclerView()
                setStateRecyclerView()
                setSpinners()

                Toast.makeText(
                    this@DashboardActivity,
                    response.body()?.netValue.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, t.message, Toast.LENGTH_LONG)
                    .show()
            }

        })
    }

    private fun setDataForSpinners(responseDTO: ResponseDTO) {

        for (i in 0 until responseDTO.brands.size) {
            brandListSpinner.add(responseDTO.brands[i].brand)
        }
        for (i in 0 until responseDTO.categories.size) {
            categoryListSpinner.add(responseDTO.categories[i].category)
        }
    }


}