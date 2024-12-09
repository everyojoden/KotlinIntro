package entities

class Product(
    var id: Int,
    var name:String,
    var quantity: Float?,
    var reference: String,
    var image: String,
    var description: String,
    var price: Float,
    val isAvaliable: Boolean,
    val hasDiscount: Boolean,
    val discountPercent: Float): ProductUseCase
{

    fun recalculateTotalAmount(){

    }

    companion object {
        var discountPercent : Float = 3f
        val reference = "El nombre que toque"
        fun sumaDosNumeros(valueA: Int, valueB:Int) = valueA + valueB

    }

    override fun isProductAvaliable(id: Int): Boolean {
        return true
    }
}



