package dataFactory

import data.UsuarioData

class UsuarioFactory {

    companion object {
        fun acessarComUsuario(
            username: String,
            password: String
        ) = UsuarioData(username, password)
    }
}