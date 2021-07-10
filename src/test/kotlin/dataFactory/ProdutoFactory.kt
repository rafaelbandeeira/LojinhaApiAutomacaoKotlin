package dataFactory

import data.ComponenteData
import data.ProdutoData

class ProdutoFactory {

    companion object {
        val componente = ComponenteData(
            componenteNome = "Capa",
            componenteQnt = 1
        )

        fun criarProdutoComValorIgualA(valor: Double) =
            ProdutoData(
                produtoNome = "Samsung S10",
                produtoValor = valor,
                produtoCores = listOf("Azul"),
                produtoUrlMock = "",
                componentes = listOf(componente)
            )
    }
}