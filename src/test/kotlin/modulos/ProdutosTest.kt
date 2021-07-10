package modulos

import dataFactory.ProdutoFactory
import dataFactory.UsuarioFactory
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Testes de API Rest do módulo de Produto")
class ProdutosTest {
    private lateinit var token: String

    @BeforeEach
    fun setup() {
        baseURI = "http://165.227.93.41"
        basePath = "lojinha"

        token =
            given()
                .contentType(ContentType.JSON)
                .body(UsuarioFactory.acessarComUsuario(
                    "admin",
                    "admin"
                ))
            .`when`()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token")
    }

    @Test
    @DisplayName("Validar que o valor 0.00 é proibido")
    fun testValidarLimitesZeradoProibidoValorProduto() {
        given()
            .contentType(ContentType.JSON)
            .header("token", token)
            .body(ProdutoFactory.criarProdutoComValorIgualA(0.00))
        .`when`()
            .post("/v2/produtos")
        .then()
            .assertThat()
                .body("error", equalTo(
                    "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"
                ))
                .statusCode(422)
    }

    @Test
    @DisplayName("Validar que o valor 7000.01 é proibido")
    fun testValidarLimitesSuperiorProibidoValorProduto() {
        given()
            .contentType(ContentType.JSON)
            .header("token", token)
            .body(ProdutoFactory.criarProdutoComValorIgualA(7000.01))
        .`when`()
            .post("/v2/produtos")
        .then()
            .assertThat()
                .body("error", equalTo(
                    "O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"
                ))
                .statusCode(422)
    }
}