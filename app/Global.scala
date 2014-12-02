import models.{Player, Resource}
import play.api.{Logger, GlobalSettings, Application}
import play.api.db.slick.Config.driver.simple._
import repositories.AppDB._
import play.api.Play.current


object Global extends GlobalSettings {

  override def onStart(app: Application) {
    InitialData.insert()
  }

  object InitialData {

    def insert() = {

      db.withSession {
        implicit session:Session =>
          dao.create
          //Query(Resource)
          val resourceOneId = dao.resources.forInsert returning dao.resources.id insert(Resource(None, "Great", "Engineer"))
          dao.players.insert(Player(2,"simon"))
          Logger.info(s"$resourceOneId")
      }
    }
  }
}