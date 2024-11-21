package com.cardino.adapter.http

import com.cardino.Fixutres.InMemoryCars
import com.cardino.domain.Brand
import com.cardino.domain.Car
import com.cardino.domain.Currency
import com.cardino.domain.Customer
import org.http4k.contract.contract
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.with
import org.http4k.filter.debug
import org.junit.jupiter.api.Test
import java.time.Instant
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CreateCarTest {
    val cars = InMemoryCars()
    val handler = contract { routes += CreateCar(cars) }.debug()

    @Test
    fun `it allows for car creation`() {
        val response = Request(POST, "/car")
            .with(
                createCarPayloadLens of Car(
                    id = 1,
                    brand = Brand.of("Mercedes"),
                    model = "220",
                    firstRegistration = Instant.now(),
                    customer = Customer(2, "Joe Doe"),
                    equipment = emptyList(),
                    sellingPrice = Currency.of(123.0),
                    createdAt = Instant.EPOCH
                )
            )
            .use(handler)

        assertTrue(response.status.successful)
        assertEquals(1, cars.storage.size)
    }
}
