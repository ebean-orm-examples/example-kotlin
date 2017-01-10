package org.example.domain

import org.testng.annotations.Test
import org.example.domain.Customer.Companion.alias as c

class CustomerTest {

  @Test
  fun exampleAliasUse() {

    val cust = Customer.alias

    Customer
        .where()
          .name.istartsWith("Rob")
          .billingAddress.country.name.startsWith("New Ze")
          .or()
            .deleted.isNotNull
            .name.isNull
          .endOr()
        .select(cust.name, c.registered)
        .findList()
  }
}