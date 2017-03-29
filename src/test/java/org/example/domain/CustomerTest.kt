package org.example.domain

import org.example.service.LoadExampleData
import org.testng.annotations.Test
import org.example.domain.Customer.Companion.alias as c

class CustomerTest {

  @Test
  fun exampleAliasUse() {

    LoadExampleData().load()

    val cust = Customer.alias

    val list = Customer
        .where()
          .name.istartsWith("Rob")
          .billingAddress.country.name.startsWith("New Ze")
          .or()
            .deleted.isNotNull
            .name.isNull
          .endOr()
        .select(cust.name, c.registered)
        .findList()

    println("got $list")
  }
}