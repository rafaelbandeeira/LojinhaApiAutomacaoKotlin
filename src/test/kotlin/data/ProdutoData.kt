package data

data class ProdutoData(
    val produtoNome: String,
    val produtoValor: Double,
    val produtoCores: List<String>,
    val produtoUrlMock: String,
    val componentes: List<ComponenteData>
)
