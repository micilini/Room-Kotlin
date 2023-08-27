package com.example.room.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room.model.UsuarioModel
import com.example.room.repository.dao.UsuarioDAO

@Database(entities = [UsuarioModel::class], version = 3)//Criamos uma anotação, informando que esta é a classe do banco de dados, e as entidades (tabelas), devem estar inseridas uma a uma dentro dos colchetes. Observe que inserimos a versão atual da base de dados ali dentro.
abstract class UsuarioDataBase: RoomDatabase() {//No caso do Room, ele diz que precisa ser herdado para uma classe Abstrata, por esse motivo que a nossa classe UsuarioDataBase precisa ser do tipo 'abstract'

    abstract fun usuarioDAO(): UsuarioDAO//Referência de UsuarioDAO, pois iremos selecionar essa classe por meio da instancia do banco

    //Vamos criar um Singleton para que haja somente uma única instância de UsuarioDataBase

    companion object{
        private lateinit var INSTANCE: UsuarioDataBase//Criamos um atributo do tipo Lateinit que será inicializado posteriormente. Faz parte da lógica do Singleton

        fun getDataBase(context: Context): UsuarioDataBase{
            if(!::INSTANCE.isInitialized) {//Verifica se a instancia dessa classe já foi inicializada
                synchronized(UsuarioDataBase::class) {//Este comando é uma verificação do sistema operacional Android, que evita que duas Thread, executem o mesmo trecho de código, dando certeza que existe uma única instância do banco de dados
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, UsuarioDataBase::class.java, "usuariodb").addMigrations(
                            MIGRATION_1_2, MIGRATION_2_3).allowMainThreadQueries().build()//Cria uma instância do banco de dados enviando o contexto da classe, e o nome do banco de dados que será criado "usuariodb"
                    //Ali foi declarado o addMigrations que pode receber diversas instancias de Migrate, que nada mais são do que atualizações
                    //O AllowMainThreadQueries permite que o Room execute todas as consultas na Thread Principal
                    //Por fim chamamos build() para criar a instancia do Room com os dados do banco de dados
                }
            }
            return INSTANCE//Retorna a instância.
        }

        //Atributos abaixo representam instancias da classe de Migrate, e devemos cria-lo sempre quando queremos adicionar ou remover novas atualizações no banco de dados.

        //lembrando que as Migrations só serão executadas caso você modificar o parâmetro version setado na anotação @Database

        private val MIGRATION_1_2: Migration = object : Migration(1, 2){//Essas são as atualizações que o Room irá executar se o usuário estiver na versão 1 e for para a 2
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("")//Aqui podemos executar qualquer query do SQL
        }
        }

        private val MIGRATION_2_3: Migration = object : Migration(2, 3){//Essas são as atualizações que o Room irá executar se o usuário estiver na versão 2 e for para a 3
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("")//Aqui podemos executar qualquer query do SQL
        }
        }

    }

}