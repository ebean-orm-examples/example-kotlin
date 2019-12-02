package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Contact

open class ContactFinder : Finder<Long, Contact>(Contact::class.java)

