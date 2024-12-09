package entities

interface ProductUseCase {
    fun isProductAvaliable(id: Int): Boolean
}