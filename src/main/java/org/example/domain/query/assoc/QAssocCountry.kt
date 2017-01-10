package org.example.domain.query.assoc

import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TQProperty
import io.ebean.typequery.TypeQueryBean
import org.example.domain.Country
import org.example.domain.query.QCountry

/**
 * Association query bean for AssocCountry.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocCountry<R>(name: String, root: R) : TQAssocBean<Country,R>(name, root) {

  lateinit var code: PString<R>
  lateinit var name: PString<R>

  // type safe fetch(properties) using varargs not supported yet ...
}
