package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Order
import org.example.domain.query.QOrder

open class OrderFinder : Finder<Long, Order>(org.example.domain.Order::class.java) {

  val alias = QOrder._alias

  /**
   * Start a new typed query.
   */
  fun where(): QOrder {
    return QOrder(db())
  }

}
