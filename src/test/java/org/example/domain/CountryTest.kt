package org.example.domain

import io.ebean.Ebean
import org.testng.annotations.Test

class CountryTest {

  @Test
  fun insert() {

    Country("NZ", "New Zealand").save()

    Country("NC", "New Caledonia").save()

    Country("AU", "Australia").save()


    Country.deleteById("NC")

    val nzRef = Country.ref("NZ")

    val foundNz = Country.byId("NZ")
    println("nz: $foundNz")

    val c = Country.alias

    val newOnes = Country.where()
        .name.startsWith("New")
        .select(c.code, c.name)
        .findList()

    println("new ones: $newOnes")

    val list = Ebean.find(Country::class.java)
        .findList()

    println(list)
  }
}