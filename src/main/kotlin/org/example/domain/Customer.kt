package org.example.domain;

import org.example.domain.finder.CustomerFinder
import io.ebean.annotation.DbArray
import io.ebean.annotation.Length
import io.ebean.annotation.SoftDelete
import java.net.URL
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.CascadeType.PERSIST
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Customer entity bean.
 */
@Entity
@Table(name = "customer")
class Customer(name: String) : BaseModel() {

  var other: String? = null

  @NotNull @Size(max = 100)
  var name: String = name

  @SoftDelete
  var deleted: Boolean = false

  var registered: Date? = null

  @DbArray
  var codes: MutableList<String> = mutableListOf()

  @Lob
  var description: String? = null

  @Length(120)
  var homeUrl: URL? = null

  @Size(max = 1000)
  var comments: String? = null

  @ManyToOne(cascade = [ALL])
  var billingAddress: Address? = null

  @ManyToOne(cascade = [ALL])
  var shippingAddress: Address? = null

  @OneToMany(mappedBy = "customer", cascade = [PERSIST])
  var contacts: MutableList<Contact> = mutableListOf()

  override fun toString(): String {
    return "customer(id:$id name:$name)"
  }

  companion object : CustomerFinder()
}
