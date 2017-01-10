package org.example.domain.query

import io.ebean.EbeanServer
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.PTimestamp
import io.ebean.typequery.TQRootBean
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Contact
import org.example.domain.query.assoc.QAssocCustomer

/**
 * Query bean for Contact.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QContact : TQRootBean<Contact, QContact> {

  companion object {
    /**
     * shared 'Alias' instance used to provide
     * properties to select and fetch clauses
     */
    val _alias = QContact(true)
  }

  lateinit var id: PLong<QContact>
  lateinit var version: PLong<QContact>
  lateinit var whenCreated: PTimestamp<QContact>
  lateinit var whenModified: PTimestamp<QContact>
  lateinit var firstName: PString<QContact>
  lateinit var lastName: PString<QContact>
  lateinit var email: PString<QContact>
  lateinit var phone: PString<QContact>
  lateinit var customer: QAssocCustomer<QContact>


  /**
   * Construct with a given EbeanServer.
   */
  constructor(server: EbeanServer) : super(Contact::class.java, server)

  /**
   * Construct using the default EbeanServer.
   */
  constructor() : super(Contact::class.java)

  /**
   * Construct for Alias.
   */
  private constructor(dummy: Boolean) : super(dummy)
}
