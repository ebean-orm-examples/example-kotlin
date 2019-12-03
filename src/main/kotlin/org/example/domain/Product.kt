package org.example.domain

import org.example.domain.finder.ProductFinder
import io.ebean.annotation.Index
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


/**
 * Product entity bean.
 */
@Entity
@Table(name = "product")
class Product(sku: String, name: String) : BaseModel() {

  @Column(length = 22)
  val sku: String = sku

  @Index
  @Column(length = 100)
  val name: String = name

  var description: String? = null

  companion object Find : ProductFinder()
}
