package com.example.room.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.room.model.UsuarioModel

@Dao//Indica que essa classe deste arquivo é uma DAO, e se encarrega de fazer todas as operações de Insert, Select, Delete e Update relacionados com a tabela Usuario
interface UsuarioDAO {

    /*
    Este é o arquivo responsável por tratar todas as operações no banco de dados.
    */

    //Insert: Anotação que informa ao Room que o método abaixo é responsável por fazer inserções na tabela Usuario
    //Diferente de outras linguagens de programação ou métodos do Kotlin, em que devemos escrever uma Query como "INSERT INTO ...", aqui acontece de forma automática.
    //Bastando apenas que você envie como parâmetro uma instância da classe UsuarioModel (que contém as colunas), onde cada atributo existente naquela classe esteja com seus respectivos valores alterados.
    //É dessa forma que o Room trabalha, pois de baixo dos panos, ele se encarrega de criar os comandos de inserção manual.
    //Retorno Long? É importante ressaltar que o método insert não precisa de retorno. Nesse caso o Long representa um valor numérico que conta o total de registros que foram inseridos.
    //É por meio do Long que saberemos que o insert foi executado com sucesso, pois podemos verificar se Long > 0, e caso positivo a inserção foi realizada.
    @Insert
    fun insertUser(usuario: UsuarioModel): Long

    //Update: Anotação que informa ao Room que o método abaixo é responsável por fazer atualizações na tabela Usuario
    //Diferente de outras linguagens de programação ou métodos do Kotlin, em que devemos escrever uma Query como "UPDATE FROM...", aqui acontece de forma automática.
    //Bastando apenas que você envie como parâmetro uma instância da classe UsuarioModel (que contém as colunas), onde cada atributo existente naquela classe esteja com seus respectivos valores alterados.
    //Mas espera aí? Como o Room saberá que por exemplo: "Eu quero atualizar o id = 7" ou quem sabe "Quero atualizar todos os ids diferente de 2" ou ainda "atualizar o id = 8 e/ou nome = Roll"?
    //Retorno Int? Assim como no insert, ele também é opcional, e diferente dele, seu retorno é tipo Int.
    //É por meio do Long que saberemos que o insert foi executado com sucesso, pois podemos verificar se Long > 0, e caso positivo a inserção foi realizada.
    @Update
    fun updateUser(usuario: UsuarioModel): Int

    //Delete: Anotação que informa ao Room que o método abaixo é responsável por fazer remoções na tabela Usuario
    //Diferente de outras linguagens de programação ou métodos do Kotlin, em que devemos escrever uma Query como "DELETE FROM...", aqui acontece de forma automática.
    //Bastando apenas que você envie como parâmetro o id que você quer que seja removido.
    //No caso do delete, ele já entende que o parâmetro id é o que desejamos remover, e por de baixo dos panos, esse atrelamento acontece de forma automática.
    @Delete
    fun deleteUser(usuario: UsuarioModel)

    //Query: Anotação que informa ao Room que o método abaixo é responsável por fazer consultas (select) na tabela Usuario.
    //Aqui nós devemos informar dentro dos parêntesis a query do SQL. Observe que estamos passando o parâmetro que recebemos no método get para dentro da query por meio dos dois pontos :id
    //Observe também que o retorno desse método é do tipo UsuarioModel. Como se trata de apenas um único registro, ele só vai retornar um único id, um único nome, e uma única idade. De modo que o Room salve esses valores dentro dos atributos em uma nova instância de UsuarioModel para que você consiga selecionar esses atributos mais tarde.
    @Query("SELECT * FROM Usuario WHERE id_usuario = :id")
    fun get(id: Int): UsuarioModel

    //Funciona da mesma forma que a Query acima, a diferença é que vamos trazer todos os registros existentes na tabela Usuario.
    //Veja que o retorno da função GetAll, é uma lista, e isso é obvio, pois podemos ter mais de um registro na tabela. E essa lista nada mais é do que uma instância da classe UsuarioModel, e aqui já sabemos como funciona esse processo ;)
    @Query("SELECT * FROM Usuario")
    fun getAll(): List<UsuarioModel>

    //Observe como dentro do DAO tudo transcorre de uma maneira simples, não acha?
    //Dessa forma conseguimos abstrair todos aqueles códigos de múltiplas linhas repetidas, como visto neste repositório: https://github.com/micilini/learn-sqlite-kotlin/blob/main/app/src/main/java/com/example/bancodedados/repository/UserRepository.kt.
    //Para algo mais simples e compacto.
    //É claro que por de baixo dos panos, o Room faz uso da classe do SQLOpenHelper, logo, tudo o que escrevemos aqui acaba se transformando em algo muito parecido com o arquivo que vimos no link acima.
    //A diferença é que quem se preocupa com isso é o ROOM e não você :D

    @Query("INSERT INTO Usuario (nome, idade) VALUES (:nome, :idade)")
    fun insertManual(nome: String, idade: Int)

    @Query("UPDATE Usuario SET nome = :nome, idade = :idade WHERE id_usuario = :id_usuario")
    fun updateManual(id_usuario: Int, nome: String, idade: Int)

    @Query("UPDATE Usuario SET nome = :nome WHERE id_usuario = :id_usuario")//Note que aqui podemos fazer o update parcial, já que estamos realizando uma operação manual
    fun updateManualParcial(id_usuario: Int, nome: String)

    @Query("DELETE FROM Usuario WHERE id_usuario > 15")//Aqui estamos realizando um delete manual, sem a necessidade de passar parâmetros, mas caso desejar você pode passar
    fun deleteManual()


}