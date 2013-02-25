package racetrack

class Race {
	String name
	Date startDate
	String city
	String state
	BigDecimal distance
	BigDecimal cost
	Integer maxRunners = 100000

    static constraints = {
    	name(blank:false, maxSize:50)
        startDate()
        city()
        state(inList:["TO", "M", "CU", "AV"])
        distance(min:0.0)
        cost(min:0.0, max:100.0)
        maxRunners(min:0, max:100000)
		startDate(validator: {return (it > new Date())})
    }

    static hasMany = [registrations:Registration]

    BigDecimal inMiles(){
        return distance * 0.6214
	}

    String toString(){
        return "${name}, ${startDate.format('dd/MM/yyyy')}"
    }
}
