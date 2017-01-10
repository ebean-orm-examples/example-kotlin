package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Country
import org.example.domain.query.QCountry

open class CountryFinder : Finder<String, Country> {

  val alias = QCountry._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Country::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Country::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QCountry {
    return QCountry(db())
  }


}
