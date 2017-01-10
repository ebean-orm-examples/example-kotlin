package org.example.domain

import org.testng.annotations.Test

class OrderTest {


  @Test
  fun findMost() {

    val list = Order.where()
        //.fifty.isTrue
        .fourty.greaterThan(12)
        .findList()

    val ref = Order.ref(42)
    //ref.status

    val byId = Order.byId(42)

    println(list)
  }
}