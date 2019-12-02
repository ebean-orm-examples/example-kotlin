package org.example.domain

import org.example.domain.query.QContact
import org.example.domain.query.QCountry
import org.example.domain.query.QCustomer
import org.example.domain.query.QOrder
import org.junit.Test
import java.time.Instant
import org.example.domain.query.QCustomer.Companion._alias as c

open class CustomerTest {

  @Test
  open fun exampleAliasUse() {

    LoadExampleData().load()

    val maxWhen: Instant =
      QContact()
        .select("max(whenModified)::Instant")
        .findSingleAttribute()

    println("got $maxWhen")

    val con = QContact._alias

    val customers2 = QCustomer()
      .select(c.name, c.version, c.whenCreated)
      .contacts.fetch(con.email)
      .name.istartsWith("Rob")
      .findList()

    val orders = QOrder()
      //.orderDate.after(LocalDate.MIN)
      //.status.isIn(Order.Status.APPROVED, Order.Status.COMPLETE)

      .select(QOrder._alias.orderDate)
      .customer.fetchLazy(c.name, c.deleted)
      .findList()

    println(orders)

    if (true) {
      return
    }

    val list = QCountry()
      .name.istartsWith("New")
      //.notes.isNotNull
      .findList()

    println(list)

    val rob = QCustomer()
      //.codes.isNotEmpty
      .homeUrl.startsWith("someUrlPrefix")
      .name.ieq("Rob")
      .select(c.name)//, cust.version)
      .findOne()

    rob?.let {
      print("hello ${rob.id} ${rob.name}")
    }

    val customers = QCustomer()
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
