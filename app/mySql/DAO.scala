package mySql

import play.api.db.slick.Profile
import repositories.tables.{PlayerRepositoryComponent, ResourceRepositoryComponent}

import scala.slick.driver.ExtendedProfile


class DAO(override val profile: ExtendedProfile) extends ResourceRepositoryComponent with PlayerRepositoryComponent with Profile {
  import profile.simple._

  def create(implicit session: Session): Unit = {
    (players.ddl ++ resources.ddl).create
  }
}