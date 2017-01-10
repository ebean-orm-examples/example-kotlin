package org.example.domain.query.assoc

import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Product
import org.example.domain.query.QProduct

/**
 * Association query bean for AssocProduct.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocProduct<R>(name: String, root: R) : TQAssocBean<Product,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var sku: PString<R>
  lateinit var name: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
