package dataFactory

import data.ComponenteData
import data.ProdutoData

class ProdutoFactory {

    companion object {
        fun criarProdutoComValorIgualA(valor: Double) : ProdutoData {
            val componente = ComponenteData(
                componenteNome = "Capa",
                componenteQnt = 1
            )
            return ProdutoData(
                produtoNome = "Samsung S10",
                produtoValor = valor,
                produtoCores = listOf("Azul"),
                produtoUrlMock = "",
                componentes = listOf(componente)
            )
        }
    }
}