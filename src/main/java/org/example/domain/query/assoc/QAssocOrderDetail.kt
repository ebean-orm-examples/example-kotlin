package org.example.domain.query.assoc

import io.ebean.typequery.PDouble
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.OrderDetail
import org.example.domain.query.QOrderDetail

/**
 * Association query bean for AssocOrderDetail.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocOrderDetail<R>(name: String, root: R) : TQAssocBean<OrderDetail,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var order: QAssocOrder<R>
  lateinit var orderQty: PInteger<R>
  lateinit var shipQty: PInteger<R>
  lateinit var unitPrice: PDouble<R>
  lateinit var product: QAssocProduct<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
