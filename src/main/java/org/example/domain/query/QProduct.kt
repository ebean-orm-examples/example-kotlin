package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Product

/**
 * Query bean for Product.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QProduct : TQRootBean<Product, QProduct> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QProduct(true)
  }

  lateinit var id: PLong<QProduct>
  lateinit var version: PLong<QProduct>
  lateinit var whenCreated: PTimestamp<QProduct>
  lateinit var whenModified: PTimestamp<QProduct>
  lateinit var sku: PString<QProduct>
  lateinit var name: PString<QProduct>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Product::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Product::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
