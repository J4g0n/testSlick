package repositories

import play.api.Play.current

// use this to do cake pattern
// https://github.com/playframework/play-slick/wiki/ScalaSlickDrivers
// http://playlatam.wordpress.com/tag/cake-pattern/
object AppDB extends DBeable {
  lazy val database = getDb
  lazy val dal = getDal
}