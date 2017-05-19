package org.example.domain;

import io.ebean.Model
import io.ebean.annotation.WhenCreated
import io.ebean.annotation.WhenModified
import java.sql.Timestamp
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

/**
 * Base domain object with Id, version, whenCreated and whenUpdated.
 *
 * <p>
 * Extending Model to enable the 'active record' style.
 *
 * <p>
 * whenCreated and whenUpdated are generally useful for maintaining external search services (like
 * elasticsearch) and audit.
 */
@MappedSuperclass
abstract class BaseModel : Model() {

  @Id
  var id: Long? = null

  @Version
  var version: Long? = null

  @WhenCreated
  var whenCreated: Timestamp? = null

  @WhenModified
  var whenModified: Timestamp? = null

}
