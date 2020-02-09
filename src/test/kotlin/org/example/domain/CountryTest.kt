package org.example.domain

import io.ebean.DB
import org.assertj.core.api.Assertions.assertThat
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

  @Test
  fun saveAllVarargs() {

    val bean0 = Country("J0", "Junk0")
    val bean1 = Country("J1", "Junk1")
    val count = DB.saveAll(bean0, bean1)
    assertThat(count).isEqualTo(2)

    bean0.delete()
    bean1.delete()
  }

  @Test
  fun explicitTransaction() {

    val database = DB.getDefault()
    val txn = database.createTransaction()
    try {

      Country("FO", "Foo").save(txn)

      val found = QCountry(txn)
        .code.eq("FO").findOne()

      assertThat(found).isNotNull()
        .extracting { it?.name }
        .isEqualTo("Foo")

      val notFound = QCountry()
        .code.eq("FO").findOne()
      assertThat(notFound).isNull()

    } finally {
      txn.close()
    }

  }
}
