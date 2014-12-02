package repositories

import play.api.db.slick.Profile
import repositories.tables.ResourceComponent
import scala.slick.driver.ExtendedProfile


class DAL(override val profile: ExtendedProfile) extends ResourceComponent with Profile {
  import profile.simple._

  def create(implicit session: Session): Unit = {
    resources.ddl.create //helper method to create all tables
  }
}