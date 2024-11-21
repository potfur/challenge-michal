package com.cardino.adapter

import com.cardino.Fixutres.InMemoryCars
import com.cardino.domain.Brand
import com.cardino.domain.Car
import com.cardino.domain.Cars
import com.cardino.domain.Currency
import com.cardino.domain.Customer
import org.junit.jupiter.api.Test
import java.time.Instant
import kotlin.test.assertEquals

abstract class CarsTestCase {
    abstract val cars: Cars
    private val car = Car(
        id = 1,
        brand = Brand.of("Mercedes"),
        model = "220",
        firstRegistration = Instant.now(),
        customer = Customer(2, "Joe Doe"),
        equipment = emptyList(),
        sellingPrice = Currency.of(123.0),
        createdAt = Instant.EPOCH
    )

    @Test
    fun `it should store newly create car`() {
        cars.create(car)

        val result = cars.getById(car.id)

        assertEquals(car, result)
    }

    @Test
    fun `it should return cars created in specific month `() {
        cars.create(car)

        assertEquals(1, cars.getForMonth(Instant.EPOCH).size)
        assertEquals(0, cars.getForMonth(Instant.now()).size)
    }
}

class InMemoryCarsTest: CarsTestCase() {
    override val cars = InMemoryCars()
}

//class PostgresCarsTest: CarsTestCase() {
//    override val cars = PostgresCars()
//}
