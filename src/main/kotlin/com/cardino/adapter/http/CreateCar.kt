package com.cardino.adapter.http

import com.cardino.adapter.Json
import com.cardino.domain.Brand
import com.cardino.domain.Car
import com.cardino.domain.Cars
import com.cardino.domain.Currency
import com.cardino.domain.Customer
import org.http4k.contract.meta
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import java.time.Instant

val createCarPayloadLens = Json.autoBody<Car>().toLens()
val createCarPayloadExample = Car(
    id = 1,
    brand = Brand.of("Mercedes"),
    model = "220",
    firstRegistration = Instant.now(),
    customer = Customer(2, "Joe Doe"),
    equipment = emptyList(),
    sellingPrice = Currency.of(123.0),
    createdAt = Instant.EPOCH
)

fun CreateCar(cars: Cars) =
    "/car" meta {
    } bindContract Method.POST to { r: Request ->
        cars.create(createCarPayloadLens(r))
        Response(Status.OK)
    }
