package org.example.domain

import org.testng.annotations.Test
import kotlin.test.assertNotNull

class ProductTest {

  @Test
  fun insert() {

    var prod = Product("CH1", "Chair")
    prod.save()

    assertNotNull(prod)
  }
}