import exercicegrupo1.Entities.Contact

fun  main(){

    //Collections

    //List
    var myList: List<Int>
    myList = listOf(1,2,3,4,5,6,7,8)

    //val myNewArrayList = arrayListOf(myList)

    // ArrayList
    var myArrayList: ArrayList<Contact> = arrayListOf(
        Contact(
            name = "Pepe",
            lastName = "Rodriguez",
            phoneNumber = "666666666",
            email = "pepe@rudo.es",
            nickName = "Pepe",
            isFavourite = false
        )
    )

    val contact = Contact(
        name = "Pepe",
        lastName = "Rodriguez",
        phoneNumber = "666666666",
        email = "pepe@rudo.es",
        nickName = "Pepe",
        isFavourite = false
    )


    myArrayList.add(contact)
    myArrayList.remove(contact)
    myArrayList.removeAt(0)
    myArrayList.clear()


    myArrayList.toList()
    myArrayList.toMutableList()

    //Mutable List
    val myMutableList: MutableList<String>
    myMutableList = mutableListOf("", "lala")
    myMutableList.add("saludos")

    myMutableList.toList()
    myMutableList.toMutableList()


    //Arrays
    val myArray = arrayOf(2.0f,3.0f,5f,7f)
    val arrayInts = intArrayOf(2,3,4,5,6,7)
    val array3 = Array(5) {0}
    val arrayChars = charArrayOf('a','b','c')

    //HashMaps

    val myMap = mapOf(
        "a" to 1,
        "b" to 2,
        "c" to 3
    )

    myMap.size
    myMap.keys
    val result = myMap["a"]

    var mapFound: Int = 0

    myMap.takeIf { it.containsKey("f") }?.let {result ->
        result["f"]?.let{ indexContent ->
            mapFound = indexContent
        }
    }

    myMap.takeIf { it.containsKey("f") }?.let {mapp ->
        myMutableList.let{ listt ->
            mapp["f"]?.let {indexContent ->
                mapFound = indexContent

                listt.add(mapFound.toString())

            }
        }
    }

    val myMutableMap = myMap.toMutableMap()
    myMutableMap.remove("a")
    myMutableMap.put("Banco",123)
    myMutableMap.clear()

    //HashMap

    val hashMap = HashMap<String, Int>()
    hashMap.put("a",1)
}