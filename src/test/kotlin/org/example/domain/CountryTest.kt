package org.example.domain

import io.ebean.DB
import org.example.domain.query.QCountry
import org.junit.Test

class CountryTest {

  @Test
  fun insert() {

    Country("GB", "Britain").save()
    Country("FR", "France").save()
    Country("GR", "Germany").save()


    val gbRef = Country.ref("GB")

    val foundGb = Country.byId("GB")
    println("gb: $foundGb")

    val c = QCountry._alias

    val newOnes = QCountry()
      .name.startsWith("Brit")
      .select(c.code)
      .findList()

    println("new ones: $newOnes")

    val list = QCountry()
      .name.icontains("many")
      .findList()

  }

  @Test
  fun transactionUse() {

    DB.execute {

      Country("FJ", "Fiji").save()
      Country("TO", "Tonga").save()
      Country("WS", "Samoa").save()
    }
  }
}
