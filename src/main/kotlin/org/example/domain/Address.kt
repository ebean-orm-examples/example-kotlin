package org.example.domain

import io.ebean.annotation.Length
import org.example.domain.finder.AddressFinder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.Size

/**
 * Address entity bean.
 */
@Entity
@Table(name = "o_address")
open class Address(

  @Column(length = 50)
  var line1: String,

  @ManyToOne
  var country: Country,

  @Size(max = 100)
  var line2: String? = null,

  @Length(100)
  var city: String? = null

) : BaseModel() {

  companion object Find : AddressFinder()
}
