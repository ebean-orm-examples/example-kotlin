package org.example.domain;

import org.example.domain.finder.CustomerFinder
import io.ebean.annotation.DbArray
import io.ebean.annotation.Length
import io.ebean.annotation.SoftDelete
import java.net.URL
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

  @DbArray
  var codes: MutableList<String> = ArrayList()

  @Lob
  var description: String? = null

  @Length(120)
  var homeUrl: URL? = null

  @Size(max = 1000)
  var comments: String? = null

  @ManyToOne(cascade = [CascadeType.ALL])
  var billingAddress: Address? = null

  @ManyToOne(cascade = [CascadeType.ALL])
  var shippingAddress: Address? = null

  @OneToMany(mappedBy = "customer", cascade = [CascadeType.PERSIST])
  var contacts: MutableList<Contact> = ArrayList()

  constructor(name: String) {
    this.name = name
  }

  override fun toString(): String {
    return "customer(id:$id name:$name)"
  }

  companion object : CustomerFinder()
}
