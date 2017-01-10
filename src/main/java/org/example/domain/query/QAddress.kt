package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Address
import org.example.domain.query.assoc.QAssocCountry

/**
 * Query bean for Address.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAddress : TQRootBean<Address, QAddress> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QAddress(true)
  }

  lateinit var id: PLong<QAddress>
  lateinit var version: PLong<QAddress>
  lateinit var whenCreated: PTimestamp<QAddress>
  lateinit var whenModified: PTimestamp<QAddress>
  lateinit var line1: PString<QAddress>
  lateinit var line2: PString<QAddress>
  lateinit var city: PString<QAddress>
  lateinit var country: QAssocCountry<QAddress>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Address::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Address::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
