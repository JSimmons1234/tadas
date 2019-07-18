package models

import play.api.data.Form
import play.api.data.Form
import scala.collection.mutable.ArrayBuffer

case class Login {username: String, password: String)
  {

    object Login {
      val loginForm = Form(
        mapping(
          "username" -> nonEmptyText,
          "password" -> nonEmptyText
        )
        (Longin.apply)(Login.unapply)
      )
    }

    val arrayBuffer
  }

}
