package org.example.domain

import org.example.service.LoadExampleData
import org.testng.annotations.Test
import org.example.domain.Customer.Companion.alias as c

open class CustomerTest {

  @Test
  open fun exampleAliasUse() {

    LoadExampleData().load()

    val cust = Customer.alias

    val customers = Customer
        .where()
          .name.istartsWith("Rob")
          .billingAddress.country.name.startsWith("New Ze")
          .or()
            .deleted.isNotNull
            .name.isNull
          .endOr()
        .findList()

    //val cust2 = TDCustom("Rob")

    val cust2 = cust
    sendTo(cust2, null)


    println("got $customers")
  }

  open fun sendTo(cust2: Any?, name: Address?) {

    if (cust2 is Customer && cust2.name != null) {
      doWithCustomer(cust2, cust2.name as String)
    }
  }

  open fun doWithCustomer(cust2: Customer, name: String) {


  }

//  open class TDCustom(name: String) : Customer(name) {
//
//  }
}