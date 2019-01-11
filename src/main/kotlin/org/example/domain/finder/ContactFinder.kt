package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Contact
import org.example.domain.query.QContact

open class ContactFinder : Finder<Long, Contact>(Contact::class.java) {

  fun where(): QContact {
    return QContact()
  }

}
