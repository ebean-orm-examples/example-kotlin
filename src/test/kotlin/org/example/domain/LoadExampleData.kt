package org.example.domain

import io.ebean.Ebean
import io.ebean.EbeanServer

class LoadExampleData {

  companion object Once {
    var runOnce: Boolean = false
  }

  private val server: EbeanServer = Ebean.getDefaultServer()

  private var contactEmailNum: Int = 1

  fun load() {

    if (runOnce) {
      return
    }

    runOnce = true

    val txn = server.beginTransaction()
    try {
      if (Country.query().findCount() > 0) {
        return;
      }
      //deleteAll()
      insertCountries()
      insertProducts()
      insertTestCustAndOrders()

      txn.commit()
    } finally {
      txn.end()
    }
  }

//  private fun deleteAll() {
//    OrderDetail.query().delete()
//    Order.query().delete()
//    Contact.query().delete()
//    Customer.query().delete()
//    Address.query().delete()
//    Country.query().delete()
//    Product.query().delete()
//  }

  private fun insertCountries() {

    Country("NZ", "New Zealand").save()
    Country("AU", "Australia").save()
  }

  private fun insertProducts() {

    Product("Chair", "C001").save()
    Product("Desk", "DSK1").save()
    Product("C002", "Computer").save()

    val product = Product(sku = "C003", name = "Printer")
    product.description = "A Colour printer"
    product.save()
  }

  private fun insertTestCustAndOrders() {

    val cust1 = insertCustomer("Rob")
    val cust2 = insertCustomerNoAddress()
    insertCustomerFiona()
    insertCustomerNoContacts("NoContactsCust")

    insertCustomer("Roberto")

    createOrder1(cust1)
    createOrder2(cust2)
    createOrder3(cust1)
    createOrder4(cust1)
  }

  private fun insertCustomerFiona(): Customer {

    val c = createCustomer("Fiona", "12 Apple St", "West Coast Rd", 1)
    c.contacts.add(createContact("Fiona", "Black"))
    c.contacts.add(createContact("Tracy", "Red"))
    c.save()
    return c
  }

  private fun createContact(firstName: String, lastName: String): Contact {

    val contact = Contact(firstName, lastName)
    contact.email = (contact.lastName + (contactEmailNum++) + "@test.com").toLowerCase()
    return contact
  }

  private fun insertCustomerNoContacts(name: String): Customer {

    val customer = createCustomer(name, "15 Kumera Way", "Bos town", 1)
    customer.save()
    return customer
  }

  private fun insertCustomerNoAddress(): Customer {

    val customer = Customer("Customer NoAddress")
    customer.contacts.add(createContact("Jack", "Black"))
    customer.save()
    return customer
  }

  private fun insertCustomer(name: String): Customer {
    val customer = createCustomer(name, "1 Banana St", "P.O.Box 1234", 1)
    customer.save()
    return customer
  }

  private fun createCustomer(name: String, shippingStreet: String?, billingStreet: String?, contactSuffix: Int): Customer {

    val customer = Customer(name)
    if (contactSuffix > 0) {
      customer.contacts.add(Contact("Jim$contactSuffix", "Cricket"))
      customer.contacts.add(Contact("Fred$contactSuffix", "Blue"))
      customer.contacts.add(Contact("Bugs$contactSuffix", "Bunny"))
    }

    val nz = Country.ref("NZ")

    if (shippingStreet != null) {
      val shipAddress = Address(shippingStreet, nz)
      shipAddress.line2 = "Sandringham"
      shipAddress.city = "Auckland"

      customer.shippingAddress = shipAddress
    }

    if (billingStreet != null) {

      val address = Address(
        line1 = billingStreet,
        line2 = "St Lukes",
        city = "Auckland",
        country = nz)

      with(address) {
        line1 = billingStreet
        line2 = "St Lukes"
        city = "Auckland"
        country = nz
      }

      customer.billingAddress =
        with(Address(billingStreet, nz)) {
          line2 = "St Lukes"
          city = "Auckland"
          this
        }

    }

    return customer
  }

  private fun createOrder1(customer: Customer): Order {

    return with(Order(customer)) {
      addItem(Product.ref(1), 22, 12.0)
      details.add(OrderDetail(Product.ref(1), 5, 10.50))
      details.add(OrderDetail(Product.ref(2), 3, 1.10))
      details.add(OrderDetail(Product.ref(3), 1, 2.00))
      save()
      this
    }
  }

  private fun createOrder2(customer: Customer) {

    with(Order(customer)) {
      status = Order.Status.SHIPPED
      this.details.add(OrderDetail(Product.ref(1), 4, 10.50))
      save()
    }
  }

  private fun createOrder3(customer: Customer) {

    with(Order(customer)) {
      status = Order.Status.COMPLETE
      this.details.add(OrderDetail(Product.ref(1), 3, 10.50))
      this.details.add(OrderDetail(Product.ref(3), 40, 2.10))
      save()
    }
  }

  private fun createOrder4(customer: Customer) {

    with(Order(customer)) {
      save()
    }
  }
}
