package mySql

import play.api.db.slick.DB

// use this to do cake pattern
// https://github.com/playframework/play-slick/wiki/ScalaSlickDrivers
// http://playlatam.wordpress.com/tag/cake-pattern/
object AppDB {
  import play.api.Play.current

  val db = DB("default")
  val dao = new DAO(db.driver)
}