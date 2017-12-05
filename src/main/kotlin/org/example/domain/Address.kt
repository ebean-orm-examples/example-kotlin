package org.example.domain;

import org.example.domain.finder.AddressFinder
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.Size

/**
 * Address entity bean.
 */
@Entity
@Table(name = "o_address")
open class Address : BaseModel {

  companion object Find : AddressFinder()

  @Size(max = 100)
  var line1: String? = null

  @Size(max = 100)
  var line2: String? = null

  @Size(max = 100)
  var city: String? = null

  @ManyToOne(optional = false)
  var country: Country? = null

  constructor()

  constructor(line1: String, line2:String?, city:String?) {
    this.line1 = line1
    this.line2 = line2
    this.city = city
  }

}
