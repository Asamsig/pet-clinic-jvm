package com.github.rskupnik.model

import javax.persistence._

import scala.annotation.meta.field

@Entity
case class Pet(@(Id @field)
               @(GeneratedValue @field)
               id: Long,

               name: String,

               @(ManyToOne @field)
               @(JoinColumn @field)(name = "ownerId", nullable = false)
               owner: Customer) {
  // Need to specify an empty constructor
  def this() {
    this(0, "", null)
  }
  override def toString: String = name
}