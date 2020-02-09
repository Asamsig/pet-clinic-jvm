package com.github.rskupnik

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{
  Bean,
  ComponentScan,
  Configuration
}

@Configuration
@EnableAutoConfiguration
@ComponentScan
class PetClinicConfig {
  @Bean
  def objectMapper = {
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
  }
}

object PetClinicApplication extends App {
  SpringApplication.run(classOf[PetClinicConfig])
}
