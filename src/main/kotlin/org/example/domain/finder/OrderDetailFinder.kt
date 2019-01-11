package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.OrderDetail

open class OrderDetailFinder : Finder<Long, OrderDetail>(OrderDetail::class.java) {

}
