package org.example.domain.finder

import io.ebean.Finder
import org.example.domain.Country

open class CountryFinder : Finder<String, Country>(Country::class.java)


