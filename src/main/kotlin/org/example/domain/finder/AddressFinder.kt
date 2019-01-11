package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Address

open class AddressFinder : Finder<Long, Address>(Address::class.java)

