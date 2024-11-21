package com.cardino.domain

import dev.forkhandles.values.DoubleValue
import dev.forkhandles.values.DoubleValueFactory
import dev.forkhandles.values.StringValue
import dev.forkhandles.values.StringValueFactory
import java.time.Instant


data class Customer(val id: Int, val name: String)

data class Equipment(val name: String, val value: String)

class Brand(name: String): StringValue(name) {
    companion object : StringValueFactory<Brand>(::Brand)
}

class Currency(name: Double): DoubleValue(name) {
    companion object : DoubleValueFactory<Currency>(::Currency, { it >= 0 })
}

data class Car(
    val id: Int,
    val brand: Brand,
    val model: String,
    val firstRegistration: Instant,
    val customer: Customer,
    val equipment: List<Equipment>,
    val sellingPrice: Currency,
    val createdAt: Instant = Instant.now() // TODO - explain why this is wrong
)
