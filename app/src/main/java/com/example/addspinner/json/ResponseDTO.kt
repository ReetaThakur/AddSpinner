package com.example.addspinner.json

data class ResponseDTO(
    val brands: List<Brand>,
    val categories: List<Category>,
    val channels: List<Any>,
    val netValue: String,
    val pendingNetValue: String,
    val pendingOrders: String,
    val states: List<State>,
    val submittedNetValue: String,
    val submittedOrders: String,
    val totalOrders: String,
    val zones: List<Zone>
)