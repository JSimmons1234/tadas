package controllers

import javax.inject.Inject
import models.Login
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class LoginController @Inject()(val messagesApi: MessagesApi, environment: play.api.Environment) extends Controller with I18nSupport {

  def getLoginPage() = Action { implicit request: =>
    Ok(views.html.loginPage(Login.loginForm))
  }

  def postLoginForm() = Action { implicit request =>
    Login.loginForm.bindFromRequest.fold({ badLoginForm =>
      BadRequest(views.html.loginPage(badLoginForm))
    }, { login =>
      if (Login.userList.contains(login))
        Redirect("/portfolio")
      else {
        Login.userList.foreach(println)
        Login.userList.append(login)
        Redirect("/portfolio")
      }
    })
  }

}
