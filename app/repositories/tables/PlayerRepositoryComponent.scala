package repositories.tables

import models.Player
import play.api.db.slick.Profile
import repositories.PlayerRepository


/**
  * Created by sandman on 12/1/14.
  */
trait PlayerRepositoryComponent extends Profile {
   this: Profile =>

   val players = new Players

   import profile.simple._

   class Players extends Table[Player]("PLAYERS") with PlayerRepository {
     def id = column[Long]("ID", O.PrimaryKey)
     def name = column[String]("NAME")

     def * = id ~ name <> (Player, Player.unapply _)

     def forInsert = id ~ name  <> ({ t => Player(t._1, t._2)}, { (r: Player) => Some ((r.id, r.name))})
   }
 }
