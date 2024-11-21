package com.cardino.Fixutres

import com.cardino.domain.Car
import com.cardino.domain.Cars
import java.time.Instant
import java.time.ZoneOffset

class InMemoryCars : Cars {
    val storage = mutableMapOf<Int, Car>()
    override fun create(car: Car) {
        storage[car.id] = car
    }

    override fun getById(carId: Int): Car {
        return storage[carId] ?: throw Error("Car not found")
    }

    override fun getForMonth(date: Instant): List<Car> {
        val zonedDate = date.atZone(ZoneOffset.UTC)
        return storage.values.filter {
            it.createdAt.atZone(ZoneOffset.UTC).let { it.year == zonedDate.year && it.month == zonedDate.month }
        }
    }
}
