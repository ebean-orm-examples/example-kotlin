package org.example.domain

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ProductTest {

  @Test
  fun insert() {

    val prod = Product("CH1", "Chair")
    prod.save()

    assertNotNull(prod)

    val ref = Product.ref(prod.id)

    assertNotNull(ref)

    ref.name
    assertEquals("Chair", ref.name)

    prod.description = "modify"
    prod.save()
  }
}
