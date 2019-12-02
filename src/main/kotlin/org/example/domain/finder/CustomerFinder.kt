package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Customer
import org.example.domain.query.QCustomer

open class CustomerFinder : Finder<Long, Customer>(Customer::class.java) {

  fun findWithNames(someName: String): List<Customer> {

    return QCustomer()
      .or()
        .name.ieq(someName)
        .name.isNotNull
      .endOr()
      .findList()
  }
}
