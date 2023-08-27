package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room.model.UsuarioModel
import com.example.room.repository.UsuarioDataBase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Comandos do Room:

        //Instancia de Room
        val usuarioDatabase = UsuarioDataBase.getDataBase(this).usuarioDAO()//Aqui estamos instanciando a classe do Room, ao mesmo tempo que estamos retornando a classe de usuarioDao

        //Insert, observe como fazemos o insert, passando uma instância de UsuarioModel, com os atributos alterados:
        val retornoInsert = usuarioDatabase.insertUser(UsuarioModel().apply {
            this.nome = "Micilini Roll"
            this.idade = 23
        })

        Log.d("Retorno Insert", "$retornoInsert")

        //Update, observe como fazemos o update, bastando passar o id_usuario, que o Room já entende que é ele que gostaríamos de Atualizar.
        val retornoUpdate = usuarioDatabase.updateUser(UsuarioModel().apply {
            this.id_usuario = 1
            this.nome = "Micilini Roll - Atualizado"
        })
        //Após a atualização a idade será trocada para o valor 0, uma vez que por esse meio não é possível fazer uma atualização parcial, ou seja, somente do nome

        //Delete, observe que fazemos o delete, bastando apenas informar o id_usuario, não é necessário.
        usuarioDatabase.deleteUser(UsuarioModel().apply {
            this.id_usuario = 2
        })//Note que o próximo id_usuario que será inserido será o 3 em diante, pois o 2 foi apagado e não existirá mais...

        //Select, observe como é simples fazer uma consulta no banco de dados a fim de retornar dados:
        val retornoSelectUnico = usuarioDatabase.get(1)//Retorna o primeiro registro

        Log.d("Retorno Único", "id_usuario: ${retornoSelectUnico.id_usuario}, nome: ${retornoSelectUnico.nome}, idade: ${retornoSelectUnico.idade}")

        val retornoSelectMultiplo = usuarioDatabase.getAll()//Retorna todos os registros

        for(item in retornoSelectMultiplo){
            Log.d("Retorno Múltiplo", "id_usuario: ${item.id_usuario}, nome: ${item.nome}, idade: ${item.idade}")
        }

        //Realizando Insert, Update e Delete manuais:

        usuarioDatabase.insertManual("Gabriel Solano", 30)//Também podemos fazer insertManual por meio do @Query, bastando apenas digitar "INSERT INTO..."

        usuarioDatabase.updateManual(3, "Gabriel Solano - Atualizado", 28)//Exemplo de atualização completa

        usuarioDatabase.updateManualParcial(4, "Mic Rollis")//Exemplo de atualização parcial

        usuarioDatabase.deleteManual()//Remove todos os id_usuario que forem maiores do que 15

    }
}