package com.cardino.domain

import java.time.Instant

interface Cars {
    fun create(car: Car)
    fun getById(carId: Int): Car
    fun getForMonth(date: Instant): List<Car>
}
