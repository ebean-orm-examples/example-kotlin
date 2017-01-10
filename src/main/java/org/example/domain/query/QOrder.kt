package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PEnum
import io.ebean.typequery.PLocalDate
import io.ebean.typequery.PLong
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Order
import org.example.domain.Order.Status
import org.example.domain.query.assoc.QAssocAddress
import org.example.domain.query.assoc.QAssocCustomer
import org.example.domain.query.assoc.QAssocOrderDetail

/**
 * Query bean for Order.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QOrder : TQRootBean<Order, QOrder> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QOrder(true)
  }

  lateinit var id: PLong<QOrder>
  lateinit var version: PLong<QOrder>
  lateinit var whenCreated: PTimestamp<QOrder>
  lateinit var whenModified: PTimestamp<QOrder>
  lateinit var fourty: PDouble<QOrder>
  lateinit var status: PEnum<QOrder,Status>
  lateinit var orderDate: PLocalDate<QOrder>
  lateinit var shipDate: PLocalDate<QOrder>
  lateinit var customer: QAssocCustomer<QOrder>
  lateinit var shippingAddress: QAssocAddress<QOrder>
  lateinit var details: QAssocOrderDetail<QOrder>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Order::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Order::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
