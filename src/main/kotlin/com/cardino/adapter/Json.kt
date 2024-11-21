package com.cardino.adapter

import com.cardino.domain.Brand
import com.cardino.domain.Currency
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.http4k.format.ConfigurableJackson
import org.http4k.format.asConfigurable
import org.http4k.format.value
import org.http4k.format.withStandardMappings

val Json = ConfigurableJackson(
    KotlinModule.Builder()
        .build()
        .asConfigurable()
        .withStandardMappings()
        .value(Brand)
        .value(Currency)
        .done()
        .deactivateDefaultTyping()
        .configure(FAIL_ON_NULL_FOR_PRIMITIVES, true)
        .configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(FAIL_ON_IGNORED_PROPERTIES, false)
)
