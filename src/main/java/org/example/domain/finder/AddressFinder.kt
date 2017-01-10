package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Address
import org.example.domain.query.QAddress

class AddressFinder : Finder<Long,Address> {

  val alias = QAddress._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Address::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Address::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QAddress {
     return QAddress(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QAddress {
     return QAddress(db()).text()
  }
}
