package racetrack

class LoginTagLib {
	def loginControl = {
		if(request.getSession(false) && session.user){
			out << "Bienvenido ${session.user.login} "
			out << """${link(action:"logout",controller:"user"){"Salir"}}"""
		} else {
			out << """${link(action:"login",controller:"user"){"Entrar"}}"""
		}
	}

}
