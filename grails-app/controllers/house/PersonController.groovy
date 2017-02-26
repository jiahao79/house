package house

class PersonController {

    def index() {
        def persons = Person.list()
        [persons: persons]
    }

    def login() {
    }
    //returns authentication data
    def results() {
        if (params.retId != null) {
            String subId = params.retId
            String[] list = subId.split(',')
            redirect(action: 'myHouse', controller: 'house', params: params)
        } else {
            redirect(action: 'createperson')
        }
    }


    def createperson() {
    }

    def saveperson() {
        def person = new Person(params)

        if (!person.save()) {
            session['user'] = person.sub_id
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

            [lists: list]

        } else {
            render "does not exist"
        }
        /*String houseId = person.houseId
        render(view: 'save.gsp', controller: 'house')*/
    }

    def authenticate() {
        //get user google OAuth information
        def auth = params.retId

        try {
            String[] list = auth.split(',')
            String authId = list[0]
            def person = Person.executeQuery(
                    "SELECT p.firstName, p.lastName, p.sub_id " +
                            "FROM Person p  " +
                            "WHERE p.sub_id = '${authId}' ")

            String[] p = person[0]

            if (!(authId in p)) {
                //person is not in database
                redirect(action: 'index', controller: 'house',
                        params: [message: "Please Create or Join a House", person: auth])
            } else {
                chain(action: 'myHouse', controller: 'house', model: [object: p])

                //person exists in database
                /*String[] retList = new String[3]
                boolean flag = false
                //store list of person details
                for (int i = 0; i < p.length; i++) {
                    String z = p[i]
                    retList[i] = z
                    if (z == authId) {
                        flag = true
                        //def subId = session[z]
                    }
                }
                if (flag) {
                    chain(action: 'myHouse', controller: 'house', model: [object: retList])
                }*/
            }
        }
        catch (Exception ex) {
            render "You are not signed into your Google Account. Please sign-in to google to proceed"
        }
    }
}


