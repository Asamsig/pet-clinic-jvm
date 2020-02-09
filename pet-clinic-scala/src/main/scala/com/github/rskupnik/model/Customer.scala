package com.github.rskupnik.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field

@Entity
case class Customer(@(Id @field)
                    @(GeneratedValue @field)
                    id: Long,

                    firstName: String,
                    lastName: String,

                    @(JsonIgnore @field)
                    @(OneToMany @field)(mappedBy = "owner")
                    pets: java.util.List[Pet]) {

  // Need to specify an empty constructor
  def this() {
    this(0, "", "", null)
  }
  override def toString: String = s"$firstName $lastName"
}