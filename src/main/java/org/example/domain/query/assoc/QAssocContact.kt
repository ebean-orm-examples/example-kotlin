package org.example.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Contact
import org.example.domain.query.QContact

/**
 * Association query bean for AssocContact.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocContact<R>(name: String, root: R) : TQAssocBean<Contact,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var firstName: PString<R>
  lateinit var lastName: PString<R>
  lateinit var email: PString<R>
  lateinit var phone: PString<R>
  lateinit var customer: QAssocCustomer<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
