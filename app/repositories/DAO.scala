package repositories

import play.api.db.slick.Profile
import repositories.tables.ResourceComponent
import scala.slick.driver.ExtendedProfile
import scala.slick.lifted.{DDL}

class DAO(override val profile: ExtendedProfile) extends ResourceComponent with Profile 