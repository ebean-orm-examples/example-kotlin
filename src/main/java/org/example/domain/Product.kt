package org.example.domain

import io.ebean.annotation.Index
import org.example.domain.finder.ProductFinder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


/**
 * Product entity bean.
 */
@Entity
@Table(name = "product")
class Product : BaseModel {

  @Column(length = 22)
  val sku: String

  @Index
  @Column(length = 100)
  val name: String

  var description: String? = null

  constructor(sku: String, name: String) {
    this.sku = sku
    this.name = name
  }

  companion object : ProductFinder()
}
