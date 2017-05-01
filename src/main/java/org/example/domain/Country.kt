package org.example.domain

import io.ebean.Model
import org.example.domain.finder.CountryFinder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Country entity bean.
 * <p>
 * Uses constructor with properties having default values.
 */
@Entity
@Table(name = "country")
class Country(

    @Id @Column(length = 2)
    var code: String,

    @Column(length = 60)
    var name: String

) : Model() {

  override fun toString(): String {
    return "code:$code name:$name"
  }

  companion object : CountryFinder()

}
