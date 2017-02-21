package house
/**
 * Created by gtohill on 16/02/17.
 */
class Person {

    String  firstName
    String  lastName
    String  sub_id
    String  houseId

    static constraints = {
        sub_id unique: true
    }

}
