package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PString
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Country

/**
 * Query bean for Country.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QCountry : TQRootBean<Country, QCountry> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QCountry(true)
  }

  lateinit var code: PString<QCountry>
  lateinit var name: PString<QCountry>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Country::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Country::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
