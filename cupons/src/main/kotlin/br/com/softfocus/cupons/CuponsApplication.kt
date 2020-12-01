package br.com.softfocus.cupons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CuponsApplication

fun main(args: Array<String>) {
	runApplication<CuponsApplication>(*args)
}
