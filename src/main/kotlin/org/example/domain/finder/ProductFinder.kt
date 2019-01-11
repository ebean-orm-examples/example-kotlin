package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Product

open class ProductFinder : Finder<Long, Product>(org.example.domain.Product::class.java) {

}
