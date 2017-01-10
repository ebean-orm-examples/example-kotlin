package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Contact
import org.example.domain.query.QContact

class ContactFinder : Finder<Long,Contact> {

  val alias = QContact._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Contact::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Contact::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QContact {
     return QContact(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QContact {
     return QContact(db()).text()
  }
}
