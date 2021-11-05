package com.randhir.foodxme.model.product

public class ProductMenu {
    var neme: String = ""
    var isSelected: Boolean = false


    constructor(neme: String, isSelected: Boolean) {
        this.neme = neme
        this.isSelected = isSelected
    }
}