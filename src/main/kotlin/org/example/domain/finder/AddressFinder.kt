package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Address
import org.example.domain.query.QAddress

open class AddressFinder : Finder<Long, Address>(Address::class.java) {

  val alias = QAddress._alias

  /**
   * Start a new typed query.
   */
  fun where(): QAddress {
     return QAddress(db())
  }
}
