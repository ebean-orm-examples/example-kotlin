package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Order
import org.example.domain.query.QOrder

class OrderFinder : Finder<Long,Order> {

  val alias = QOrder._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Order::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Order::class.java, serverName)

  /**
   * Start a new typed query.
   */
  fun where(): QOrder {
     return QOrder(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QOrder {
     return QOrder(db()).text()
  }
}
