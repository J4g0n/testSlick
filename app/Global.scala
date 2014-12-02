import play.api.GlobalSettings
import play.api.db.slick.Config.driver.simple._
import play.api.Application
import models._
import repositories.current._


object Global extends GlobalSettings {

  override def onStart(app: Application) {
    InitialData.insert()
  }

  object InitialData {
    def insert() = {
      db.withSession {
        implicit session:Session =>
          //Query(Resource)
          //val resourceOneId = dao.Resources.forInsert returning dao.Resources.id insert(Resource(None, "Great", "Engineer"))
      }
    }
  }
}