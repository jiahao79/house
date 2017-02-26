package house

class HouseController {

    def index() {
        def mess = params['message']
        def person  = params['person']
        String[] p = person.split(',')
        Person per = new Person()
        per.sub_id = p[0]
        per.firstName = p[2]
        [message:mess, person:per]

        //use for getting members of a specific house
        /*def house = House.executeQuery(
                "SELECT h.houseName, p.firstName, p.lastName  "+
                        "FROM Person p "+
                        "JOIN House h ON p.houseId = h.houseId "+
                        "WHERE h.houseId = '001'")
        render house*/
    }
    def createhouse(){
        render per

    }

    //controller takes person to their house
    def myHouse(){
        def authItem = chainModel.object//params['object']
        [persons:authItem]
    }

    def save(){
        def house = new House(params)
        house.save()
        redirect(action:'addroommate', params:[message:"House Added Successfully"])

    }

    def addroommate(){

    }

    //method sends email to roommates added by house creator
    def sendLink(){

    }

    def personsave(){
        def person = new Person(params)
        person.save()
        render (view:"save.gsp")
    }


    def completed(){
        render "Completed"
    }

    def list(){
        //use for getting list of all houses
        def house = House.executeQuery(
                "SELECT h.houseName, h.houseId "+
                        "FROM House h ")
        render house
    }
}
