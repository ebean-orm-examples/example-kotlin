package org.example.domain;

import io.ebean.Model
import org.example.domain.finder.CountryFinder
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

/**
 * Country entity bean.
 * <p>
 * Uses constructor with properties having default values.
 */
@Entity
@Table(name = "country")
class Country(

    @Id @Size(max = 2)
    var code: String,

    @Size(max = 60)
    var name: String

) : Model() {

  override fun toString(): String {
    return "code:$code name:$name"
  }

  companion object : CountryFinder()

}
