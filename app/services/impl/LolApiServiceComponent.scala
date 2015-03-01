package services.impl

import play.api.db.slick.Profile
import services.LolApiService

/**
 * Created by sandman on 12/3/14.
 */
class LolApiServiceComponent {
  this: Profile =>

  val lolApiService = new LolApiServiceImpl

  class LolApiServiceImpl extends LolApiService {
    def retrieveDataFromUser = {

    }
  }
}
