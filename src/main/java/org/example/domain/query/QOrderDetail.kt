package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PDouble
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLong
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.OrderDetail
import org.example.domain.query.assoc.QAssocOrder
import org.example.domain.query.assoc.QAssocProduct

/**
 * Query bean for OrderDetail.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QOrderDetail : TQRootBean<OrderDetail, QOrderDetail> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QOrderDetail(true)
  }

  lateinit var id: PLong<QOrderDetail>
  lateinit var version: PLong<QOrderDetail>
  lateinit var whenCreated: PTimestamp<QOrderDetail>
  lateinit var whenModified: PTimestamp<QOrderDetail>
  lateinit var order: QAssocOrder<QOrderDetail>
  lateinit var orderQty: PInteger<QOrderDetail>
  lateinit var shipQty: PInteger<QOrderDetail>
  lateinit var unitPrice: PDouble<QOrderDetail>
  lateinit var product: QAssocProduct<QOrderDetail>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(OrderDetail::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(OrderDetail::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
