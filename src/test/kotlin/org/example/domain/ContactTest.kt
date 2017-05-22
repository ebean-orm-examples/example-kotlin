package org.example.domain

import org.testng.annotations.Test

class ContactTest {

  @Test
  fun insert() {

    val cust = Customer("asd")
    cust.name = "customer awesome"
    cust.save()

    val one = Contact("first", "last")
    one.customer = cust
    one.tags.addAll(setOf("red","black"))

    val two = Contact("asd", "asd")
    two.customer = cust

    Contact.where()
      .firstName.isIn("asd")
      .setMaxRows(1)
      .findOneOrEmpty()

    one.save()
    two.save()
  }
}