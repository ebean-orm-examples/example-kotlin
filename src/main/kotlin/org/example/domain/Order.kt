package org.example.domain

import org.example.domain.finder.OrderFinder
import io.ebean.annotation.DocCode
import io.ebean.annotation.DocEmbedded
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Order entity bean.
 */
@Entity
@Table(name = "o_order")
class Order : BaseModel {

  enum class Status {
    NEW,
    APPROVED,
    SHIPPED,
    COMPLETE
  }

  @NotNull
  @DocCode
  var status: Status = Status.NEW

  var orderDate: LocalDate? = null

  var shipDate: LocalDate? = null

  @DocEmbedded(doc = "id,name")
  @ManyToOne @NotNull
  var customer: Customer

  @ManyToOne
  var shippingAddress: Address? = null

  @DocEmbedded(doc = "*,product(id,sku,name)")
  @OneToMany(mappedBy = "order", cascade = arrayOf(CascadeType.PERSIST))
  @OrderBy("id asc")
  var details: MutableList<OrderDetail> = ArrayList()

  constructor(customer: Customer) {
    this.customer = customer
  }

  companion object : OrderFinder()

  fun addItem(product: Product,  orderQty: Int, unitPrice: Double) {
    details.add(OrderDetail(product, orderQty, unitPrice))
  }
}
