package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import argonaut._, Argonaut._
import sys.process._

class Application extends Controller {


  /*case class req (
		//var repo: String,
		var port:String) {}

object req {
	implicit def CommentCodecJson: CodecJson[req] = 
		casecodec2(req.apply, req.unapply)(
				"repo",
				"port")
}
  */
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def startContainer(repo: String, port :String): Stream[String] = {
    val cmd = Seq("bash","myscript.sh", port, repo)
    cmd.lineStream
    }
  
  def deploy = Action { request =>
  var recv = request.body.asJson.toString
    var received= recv slice(5, recv.length-1)
    println(received)
    var decodedjson : Map[String,String] = received.decodeOption[Map[String,String]].get
    println(decodedjson)
    val repo = decodedjson("repo")
    val port = decodedjson("port")
    //val targetp:String ="1234"
    var x = startContainer(repo,port) 
    Ok(x.mkString("\n"))
  }
  
  
  
}
