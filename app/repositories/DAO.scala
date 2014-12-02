package repositories

import play.api.db.slick.Profile
import repositories.tables.{PlayerComponent, ResourceComponent}
import scala.slick.driver.ExtendedProfile


class DAO(override val profile: ExtendedProfile) extends ResourceComponent with PlayerComponent with Profile {
  import profile.simple._

  def create(implicit session: Session): Unit = {
    (players.ddl ++ resources.ddl).create
  }
}