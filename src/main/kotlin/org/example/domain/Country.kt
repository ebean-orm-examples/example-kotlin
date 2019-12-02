package org.example.domain

import org.example.domain.finder.CountryFinder
import io.ebean.Model
import io.ebean.annotation.Length
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

    @Id @Length(2)
    var code: String,

    @field:Size(max=60)
    var name: String

) : Model() {

  @Length(100)
  var description: String? = null

  @Length(200)
  var notes: String? = null

  override fun toString(): String {
    return "code:$code name:$name"
  }


  companion object Find : CountryFinder()
}
