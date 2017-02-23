package house
/**
 * Created by gtohill on 16/02/17.
 */
class BootStrap {
    def init = { servletContext ->

        if(House.count()==0) {

            new House(houseName: '1stHouse', houseId: '000').save()
            new House(houseName: '2ndHouse', houseId: '001').save()
            new House(houseName: '3rdHouse', houseId: '002').save()
        }
        // Initialize an empty task list
        //def myTaskList = new TaskList(name: "Ethan's List").save()

        //Add 4 perons to house

        if (Person.count() == 0) {
            new Person(firstName: 'Gary', lastName: 'Tohill', sub_id:'107726694172578448865', houseId: '000' ).save()
            new Person(firstName: 'Rupi', lastName: 'Bains', sub_id: '113', houseId: '000').save()
            new Person(firstName: 'Mark', lastName: 'Johnson', sub_id: '114', houseId: '001').save()
            new Person(firstName: 'Waylan', lastName: 'Smithers', sub_id: '115', houseId: '001').save()
            new Person(firstName: 'Bart', lastName: 'Simpson', sub_id: '116', houseId: '002').save()
            new Person(firstName: 'Homer', lastName: 'Simpson', sub_id: '117', houseId: '002').save()
            new Person(firstName: 'Marge', lastName: 'Simpson', sub_id: '118', houseId: '002').save()
            new Person(firstName: 'Lisa', lastName: 'Simpson', sub_id: '119', houseId: '002').save()

        }

    }

    def destroy = {
    }
}
