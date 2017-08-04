package org.example.domain;

import io.ebean.annotation.SoftDelete
import org.example.domain.finder.CustomerFinder
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Customer entity bean.
 */
@Entity
@Table(name = "customer")
class Customer : BaseModel {

  @NotNull @Size(max = 100)
  var name: String?

  @SoftDelete
  var deleted: Boolean = false

  var registered: Date? = null

  @Lob
  var description: String? = null

  @Size(max = 1000)
  var comments: String? = null

  @ManyToOne(cascade = arrayOf(CascadeType.ALL))
  var billingAddress: Address? = null

  @ManyToOne(cascade = arrayOf(CascadeType.ALL))
  var shippingAddress: Address? = null

  @OneToMany(mappedBy = "customer", cascade = arrayOf(CascadeType.PERSIST))
  var contacts: MutableList<Contact> = ArrayList()

  constructor(name: String) {
    this.name = name
  }

  override fun toString(): String {
    return "customer(id:$id name:$name)"
  }

  companion object : CustomerFinder()
}
