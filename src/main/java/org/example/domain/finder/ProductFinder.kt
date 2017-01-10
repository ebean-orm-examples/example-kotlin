package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Product
import org.example.domain.query.QProduct

class ProductFinder : Finder<Long,Product> {

  val alias = QProduct._alias

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Product::class.java)

  /**
   * Construct with a given EbeanServer.
   */
  constructor(serverName: String) : super(Product::class.java, serverName)

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
