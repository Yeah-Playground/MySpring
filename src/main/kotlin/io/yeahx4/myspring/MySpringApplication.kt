package io.yeahx4.myspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MySpringApplication

fun main(args: Array<String>) {
	runApplication<MySpringApplication>(*args)
}
