package org.example.domain

import org.example.domain.finder.ContactFinder
import io.ebean.annotation.DbArray
import io.ebean.annotation.Length
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Contact entity bean.
 */
@Entity
@Table(name = "contact")
class Contact(

  @field:Size(max = 50)
  var firstName: String,

  @Length(50)
  var lastName: String) : BaseModel() {

  @Size(max = 200)
  var email: String? = null

  @Size(max = 20)
  var phone: String? = null

  @DbArray(length = 90)
  var tags: MutableSet<String> = mutableSetOf()

  @DbArray
  var scores: MutableSet<Int> = mutableSetOf()

  @NotNull
  @ManyToOne(optional = false)
  var customer: Customer? = null

  companion object Find : ContactFinder()
}
