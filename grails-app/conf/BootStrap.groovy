import racetrack.*
import grails.util.GrailsUtil

class BootStrap {

    def init = { servletContext ->
    	switch(GrailsUtil.environment) {
    		case "development":
    			println "development"
		    	def jane = new Runner(
			                       firstName:"Jane",
			                       lastName:"Doe",
			                       dateOfBirth:(new Date() - 365*30),
			                       gender:"F",
			                       address:"123 Main St",
			                       city:"Madrid",
			                       state:"M",
			                       zipcode:"12345",
			                       email:"jane@whereever.com"
		                       )
		    	jane.save()
		    	if(jane.hasErrors()){
		    		println jane.errors
		    	}

				def trot = new Race(
		                   name:"LXS",
		                   startDate:(new Date() + 90),
		                   city:"Duck",
		                   state:"M",
		                   distance:5.0,
		                   cost:20.0,
		                   maxRunners:350
		                   )
		        trot.save()
		        if(trot.hasErrors()){
		          println trot.errors
		        }
		        
		        def reg = new Registration(
		                  paid:false,
		                  runner:jane,
		                  race:trot
		                  )
		        reg.save()
		        if(reg.hasErrors()){
		          println reg.errors
		        }    	
    			break
    		case "production": break
    	}
    }
    def destroy = {
    }
}
