package models

import play.api.data.Form

case class Login (username: String, password: String)

  object Login {
    val loginForm = Form(
      mapping(
        "username" -> nonEmptyText,
        "password" -> nonEmptyText
      )
      (Login.apply)(Login.unapply)
    )
  }


