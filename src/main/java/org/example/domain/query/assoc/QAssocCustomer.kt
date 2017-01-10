package org.example.domain.query.assoc

import io.ebean.typequery.PBoolean
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.PUtilDate
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Customer
import org.example.domain.query.QCustomer

/**
 * Association query bean for AssocCustomer.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocCustomer<R>(name: String, root: R) : TQAssocBean<Customer,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var name: PString<R>
  lateinit var deleted: PBoolean<R>
  lateinit var registered: PUtilDate<R>
  lateinit var comments: PString<R>
  lateinit var billingAddress: QAssocAddress<R>
  lateinit var shippingAddress: QAssocAddress<R>
  lateinit var contacts: QAssocContact<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
