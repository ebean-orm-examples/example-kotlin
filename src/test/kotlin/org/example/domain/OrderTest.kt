package org.example.domain

import org.example.domain.query.QOrder
import org.junit.Test

class OrderTest {


  @Test
  fun findMost() {

    LoadExampleData().load()

    val o = QOrder._alias

    val list = Order.where()
      .id.greaterOrEqualTo(1)
      .order()
      .id.asc()
      .select(o.id, o.orderDate)
      .details.fetchLazy()
      .findList()


    val ref = Order.ref(42)
    //ref.status

    val byId = Order.byId(42)

    println(list)
  }
}
