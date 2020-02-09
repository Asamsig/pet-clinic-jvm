package com.github.rskupnik

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PetClinicApplication {}

object PetClinicApplication extends App {
  SpringApplication.run(classOf[PetClinicApplication], args: _*)
}