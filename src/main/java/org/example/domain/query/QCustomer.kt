package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PBoolean
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.PUtilDate
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Customer
import org.example.domain.query.assoc.QAssocAddress
import org.example.domain.query.assoc.QAssocContact

/**
 * Query bean for Customer.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QCustomer : TQRootBean<Customer, QCustomer> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QCustomer(true)
  }

  lateinit var id: PLong<QCustomer>
  lateinit var version: PLong<QCustomer>
  lateinit var whenCreated: PTimestamp<QCustomer>
  lateinit var whenModified: PTimestamp<QCustomer>
  lateinit var name: PString<QCustomer>
  lateinit var deleted: PBoolean<QCustomer>
  lateinit var registered: PUtilDate<QCustomer>
  lateinit var comments: PString<QCustomer>
  lateinit var billingAddress: QAssocAddress<QCustomer>
  lateinit var shippingAddress: QAssocAddress<QCustomer>
  lateinit var contacts: QAssocContact<QCustomer>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Customer::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Customer::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
