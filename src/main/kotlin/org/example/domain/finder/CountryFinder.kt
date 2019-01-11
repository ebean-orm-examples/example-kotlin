package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Country
import org.example.domain.query.QCountry

open class CountryFinder : Finder<String, Country>(Country::class.java) {

  fun where(): QCountry {
    return QCountry()
  }

}
