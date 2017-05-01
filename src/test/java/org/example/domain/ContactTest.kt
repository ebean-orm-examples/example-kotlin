package org.example.domain

import org.example.service.LoadExampleData
import org.testng.annotations.Test

class ContactTest {

  @Test
  fun insert() {

    LoadExampleData().load()

//    val cust = Customer("asd")
//    cust.name = "customer awesome"
//    cust.save()
//
//    val one = Contact("first", "last")
//    one.customer = cust
//
//    val two = Contact("asd", "asd")
//    two.customer = cust

//    val maybeCust = Customer.one(12L)
//    if (maybeCust.ifPresent({
//
//    }))
//    if (maybeCust.isPresent) {
//      val customer = maybeCust.get()
//    }


    val c = Customer.where().id.eq(45L).findUnique()
    c?.name = "Rob"

    val customer = Customer.byId(1L)
    customer?.let {
      customer.billingAddress?.line1 = "some street"
    }
    if (customer == null) {
      println("was null")
    }

    customer?.let {
      customer.billingAddress?.line1 = "ad"
    }
  }
}