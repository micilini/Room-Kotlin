package com.example.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuario")
class UsuarioModel {

    @PrimaryKey(autoGenerate = true)//Significa que o id é a chave primaria com auto incremento (autoGenerate) ativado
    @ColumnInfo(name = "id_usuario")//Diz ao Room que o atributo abaixo é uma coluna, e que o nome dessa coluna será "idade"
    var id_usuario: Int = 0//Esse atributo representa uma coluna do tipo Int

    @ColumnInfo(name = "nome")//Diz ao Room que o atributo abaixo é uma coluna, e que o nome dessa coluna será "nome"
    var nome: String = ""//Esse atributo representa uma coluna do tipo String

    @ColumnInfo(name = "idade")//Diz ao Room que o atributo abaixo é uma coluna, e que o nome dessa coluna será "idade"
    var idade: Int = 0//Esse atributo representa uma coluna do tipo Int

    //Lembrando que os atributos acima precisam ser inicializados com valores, mas não se preocupe, pois o que estes valores não irão influenciar em nada nossa base de dados.

}