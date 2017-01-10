package org.example.domain.query.assoc

import io.ebean.typequery.PDouble
import io.ebean.typequery.PEnum
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLong
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Order
import org.example.domain.Order.Status
import org.example.domain.query.QOrder

/**
 * Association query bean for AssocOrder.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocOrder<R>(name: String, root: R) : TQAssocBean<Order,R>(name, root) {

  lateinit var id: PLong<R>
  lateinit var version: PLong<R>
  lateinit var whenCreated: PTimestamp<R>
  lateinit var whenModified: PTimestamp<R>
  lateinit var fourty: PDouble<R>
  lateinit var status: PEnum<R,Status>
  lateinit var orderDate: PLocalDate<R>
  lateinit var shipDate: PLocalDate<R>
  lateinit var customer: QAssocCustomer<R>
  lateinit var shippingAddress: QAssocAddress<R>
  lateinit var details: QAssocOrderDetail<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
