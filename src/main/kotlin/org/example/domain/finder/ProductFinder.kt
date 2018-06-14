package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Product
import org.example.domain.query.QProduct

open class ProductFinder : Finder<Long, Product>(org.example.domain.Product::class.java) {

  val alias = QProduct._alias

  /**
   * Start a new typed query.
   */
  fun where(): QProduct {
    return QProduct(db())
  }

  /**
   * Start a new document store query.
   */
  fun text(): QProduct {
    return QProduct(db()).text()
  }
}
