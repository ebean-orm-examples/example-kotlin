package org.example.domain

import org.example.service.LoadExampleData
import org.testng.annotations.Test
import java.util.stream.LongStream

class OrderTest {


  @Test
  fun findMost() {

    LoadExampleData().load()

    val list = Order.where()
            .id.greaterOrEqualTo(1)
            .order()
              .id.asc()
        .findList()

    val some = list.filter { it.id != null }

//    val foundJim = some.find { order ->
//      order.customer.name.startsWith("Rob")
//    }

    //some.parallelStream().flatMapToLong { LongStream.of(it.id ?: 1)}

    val ref = Order.ref(42)
    //ref.status

    val byId = Order.byId(42)

    println(list)
  }
}