package org.example.domain

import org.example.domain.finder.ProductFinder
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


/**
 * Product entity bean.
 */
@Entity
@Table(name = "product")
class Product : BaseModel {

  @NotNull
  @Size(max = 22)
  val sku: String

  //@NotNull
  @Size(max = 100)
  val name: String

  constructor(sku: String, name: String) {
    this.sku = sku
    this.name = name
  }

  companion object : ProductFinder()
}
