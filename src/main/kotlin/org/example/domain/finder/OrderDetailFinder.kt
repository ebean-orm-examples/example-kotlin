package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.OrderDetail
import org.example.domain.query.QOrderDetail

open class OrderDetailFinder : Finder<Long, OrderDetail>(OrderDetail::class.java) {

  val alias = QOrderDetail._alias

  /**
   * Start a new typed query.
   */
  fun where(): QOrderDetail {
     return QOrderDetail(db())
  }
}
