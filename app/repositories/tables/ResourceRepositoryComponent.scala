package repositories.tables

import models.Resource
import play.api.db.slick.Profile
import repositories.ResourceRepository


/**
 * Created by sandman on 12/1/14.
 */
trait ResourceRepositoryComponent extends Profile {
  this: Profile =>

  val resources = new Resources

  import profile.simple._

  class Resources extends Table[Resource]("RESOURCES") with ResourceRepository {
    def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
    def first = column[String]("FIRST")
    def last = column[String]("LAST")

    def * = id.? ~ first ~ last <> (Resource, Resource.unapply _)

    def forInsert = first ~ last  <> ({ t => Resource(None, t._1, t._2)}, { (r: Resource) => Some ((r.first, r.last))})
  }
}
