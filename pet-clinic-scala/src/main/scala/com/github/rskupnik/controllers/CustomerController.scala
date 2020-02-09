package com.github.rskupnik.controllers

import scala.jdk.CollectionConverters._
import scala.jdk.OptionConverters._
import com.github.rskupnik.model.Customer
import com.github.rskupnik.repositories.CustomerRepository
import org.springframework.web.bind.annotation._

// This controller uses constructor injection

@RestController
@RequestMapping(Array("/customers"))
class CustomerController(
    customerRepository: CustomerRepository
) {

  // Have to use arrays in annotations, which is a pain

  @GetMapping(value = Array("/{id}"), produces = Array("application/json"))
  def getCustomer(@PathVariable("id") id: Long) =
    customerRepository.findById(id).toScala

  @GetMapping(produces = Array("application/json"))
  def getAllCustomers() = customerRepository.findAll().asScala

  @GetMapping(value = Array("/formatted"), produces = Array("application/json"))
  def getAllCustomersFormatted() = {
    // Use JavaConverters to move between Scala and Java collections.
    customerRepository
      .findAll()
      .asScala
      .map(_.toString())
  }

  @PostMapping(produces = Array("application/json"),
               consumes = Array("application/json"))
  def addCustomer(@RequestBody customer: Customer) =
    customerRepository.save(customer)
}
