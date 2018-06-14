package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Contact
import org.example.domain.query.QContact

open class ContactFinder : Finder<Long, Contact>(Contact::class.java) {

  val alias = QContact._alias

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
