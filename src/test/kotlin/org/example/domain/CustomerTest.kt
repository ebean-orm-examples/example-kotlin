package org.example.domain

import org.example.service.LoadExampleData
import org.testng.annotations.Test
import java.time.LocalDate
import org.example.domain.Customer.Companion.alias as c

open class CustomerTest {

  @Test
  open fun exampleAliasUse() {

    LoadExampleData().load()

    val cust = Customer.alias

    val orders = Order.where()
      .orderDate.after(LocalDate.MIN)
      .status.isIn(Order.Status.APPROVED, Order.Status.COMPLETE)
      .findList()

    println(orders)

    val list = Country.where()
      .name.istartsWith("New")
      .findList()

    println(list)

    val rob = Customer.where()
      .name.ieq("Rob")
      .select(cust.name, cust.version)
      .findOne()

    rob?.let {
      print("hello ${rob.id} ${rob.name}")
    }

    val customers = Customer
        .where()
          .name.istartsWith("Rob")
          .billingAddress.country.name.startsWith("New Ze")
          .or()
            .deleted.isNotNull
            .name.isNull
          .endOr()
        .findList()

    println("got customers: $customers")
  }

}