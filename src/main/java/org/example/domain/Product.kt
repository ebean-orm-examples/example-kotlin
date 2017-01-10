package org.example.domain

import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


/**
 * Product entity bean.
 */
@Entity
@Table(name = "product")
class Product (

 @NotNull @Size(max = 20)
 var sku: String,

 @NotNull @Size(max = 100)
 var name: String

) : BaseModel()
