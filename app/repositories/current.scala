package repositories

import play.api.db.slick.DB

// use this to do cake pattern
// https://github.com/playframework/play-slick/wiki/ScalaSlickDrivers
object current {
  val db = DB("default")
  val dao = new DAO(db.driver)
}