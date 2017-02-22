package house

class PersonController {

   /* def index() {
        def persons = Person.list()
        [persons: persons]
    }*/

    /*def login(){
    }*/
    //returns authentication data
    def results(){
        String subId = params.retId
        String[] list = subId.split(',')
        redirect(action:'myHouse', controller:'house', params:params)
    }


    def createperson() {
    }

    def save() {
        def person = new Person(params)

        if(!person.save()){
            session['user']= person.sub_id
            def person1 = Person.executeQuery(
                    "SELECT p.firstName, p.lastName, p.sub_id " +
                            "FROM Person p " +
                            "WHERE p.sub_id = ${person.sub_id} ")
            LinkedList<String> list = new LinkedList<String>()
            String[] p = person1[0]
            for (int i = 0; i < p.length; i++) {
                String z = p[i]
                list.add(z)
                }

            [lists:list]

        }
        else{
            render "does not exist"
        }
        /*String houseId = person.houseId
        render(view: 'save.gsp', controller: 'house')*/
    }

    def authenticate() {

        def authPerson = new Person(params)
        String id = authPerson.sub_id
        def person = Person.executeQuery(
                "SELECT p.firstName, p.lastName, p.sub_id " +
                        "FROM Person p " +
                        "WHERE p.sub_id = ${id} ")

        if (person != null) {

            String[] p = person[0]
            if(p == null){
                redirect (action: 'index', controller: 'house', params:[message:"Please Create or Join a House"])
                return
            }
            LinkedList<String> list = new LinkedList<String>()
            for (int i = 0; i < p.length; i++) {
                String z = p[i]
                list.add(z)
                if (z.equals(id)) {
                    def subId = session[z]
                    def LinkedList<String> map = list
                    redirect (action: 'myHouse', controller: 'house', session)
                    return
                }
            }
        }
    }


    def list() {
        def person = Person.executeQuery(
                "SELECT p.firstName, p.lastName " +
                        "FROM Person p ")
        render person
    }
}