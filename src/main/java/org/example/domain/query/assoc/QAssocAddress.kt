package org.example.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Address
import org.example.domain.query.QAddress

/**
 * Association query bean for AssocAddress.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocAddress<R>(name: String, root: R) : TQAssocBean<Address,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var line1: PString<R>
  lateinit var line2: PString<R>
  lateinit var city: PString<R>
  lateinit var country: QAssocCountry<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
