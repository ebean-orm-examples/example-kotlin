package org.example.domain

import org.testng.annotations.Test

class ContactTest {

  @Test
  fun insert() {


    val cust = Customer("asd")
    //cust.name = "customer awesome"
    cust.save()

    val one = Contact("first", "last")
    one.customer = cust

    val two = Contact("asd", "asd")
    two.customer = cust

    one.save()
    two.save()
  }
}