import models.Resource
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
      val dal = getDal

      getDb.withSession {
        implicit session:Session =>
          dal.create
          //Query(Resource)
          val resourceOneId = dal.resources.forInsert returning dal.resources.id insert(Resource(None, "Great", "Engineer"))
          Logger.info(s"$resourceOneId")
      }
    }
  }
}