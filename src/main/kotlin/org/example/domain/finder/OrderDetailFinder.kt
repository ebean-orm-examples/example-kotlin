package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.OrderDetail
import org.example.domain.query.QOrderDetail

open class OrderDetailFinder : Finder<Long,OrderDetail> {

  val alias = QOrderDetail._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(OrderDetail::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(OrderDetail::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QOrderDetail {
     return QOrderDetail(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QOrderDetail {
     return QOrderDetail(db()).text()
  }
}
