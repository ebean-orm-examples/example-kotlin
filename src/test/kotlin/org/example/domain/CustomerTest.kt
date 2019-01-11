package org.example.domain

import org.example.domain.query.QCustomer
import org.example.domain.query.QOrder
import org.junit.Test

open class CustomerTest {

  @Test
  open fun exampleAliasUse() {

    LoadExampleData().load()

    val cust = QCustomer._alias

    val orders = Order.where()
      //.orderDate.after(LocalDate.MIN)
      //.status.isIn(Order.Status.APPROVED, Order.Status.COMPLETE)

      .select(QOrder._alias.orderDate)
      .customer.fetchLazy(cust.name, cust.deleted)
      .findList()

    println(orders)

    if (true) {
      return
    }

    val list = Country.where()
      .name.istartsWith("New")
      //.notes.isNotNull
      .findList()

    println(list)

    val rob = Customer.where()
      //.codes.isNotEmpty
      .homeUrl.startsWith("someUrlPrefix")
      .name.ieq("Rob")
      .select(cust.name)//, cust.version)
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
