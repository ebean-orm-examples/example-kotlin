package org.example.domain

import io.ebean.Model
import io.ebean.annotation.Length
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
class Country(code: String, name: String) : Model() {

  @Id
  @Length(2)
  var code: String = code

  @field:Size(max = 60)
  var name: String = name

  @Length(100)
  var description: String? = null

  @Length(200)
  var notes: String? = null

  override fun toString(): String {
    return "code:$code name:$name"
  }

  companion object Find : CountryFinder()
}
