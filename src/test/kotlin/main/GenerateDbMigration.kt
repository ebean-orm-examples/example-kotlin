package main

import io.ebean.Platform
import io.ebean.dbmigration.DbMigration

fun main(args : Array<String>) {

  // optionally specify the version and name
  //System.setProperty("ddl.migration.version", "1.2_33");
  //System.setProperty("ddl.migration.name", "");

  // generate a migration using drops from a prior version
  //System.setProperty("ddl.migration.pendingDropsFor", "1.1");

  val dbMigration = DbMigration()
  dbMigration.setPlatform(Platform.POSTGRES)

  dbMigration.generateMigration()
}
