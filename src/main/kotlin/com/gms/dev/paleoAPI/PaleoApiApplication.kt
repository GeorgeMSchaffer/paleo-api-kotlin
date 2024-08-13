package com.gms.dev.paleoAPI

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class PaleoApiApplication

fun main(args: Array<String>) {
	runApplication<PaleoApiApplication>(*args)
}
