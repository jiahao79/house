package house

class HouseController {

    def index() {
        [message:getParams()]
        //use for getting members of a specific house
        /*def house = House.executeQuery(
                "SELECT h.houseName, p.firstName, p.lastName  "+
                        "FROM Person p "+
                        "JOIN House h ON p.houseId = h.houseId "+
                        "WHERE h.houseId = '001'")
        render house*/
    }
    def createhouse(){

    }

    //controller takes person to their house
    def myHouse(){
        [message:getParams()]
    }

    def save(){
        def house = new House(params)
        house.save()
        String houseId = house.houseId
        String houseName = house.houseName
        [house:house]

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
