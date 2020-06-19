package org.example.domain;

import io.ebean.annotation.DbArray
import io.ebean.annotation.Length
import io.ebean.annotation.SoftDelete
import org.example.domain.finder.CustomerFinder
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

  enum class Colour {
    RED, BLUE
  }

  var other: String? = null

  @NotNull
  @Size(max = 100)
  var name: String = name

  @SoftDelete
  var deleted: Boolean = false

  var registered: Date? = null

  @DbArray
  var codes: MutableList<String> = mutableListOf()

  @DbArray
  var flags: List<Colour> = listOf()

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
