![Introdução ao Room](https://micilini.com/assets/img/android/room-android-micilini.png)

# Aprenda a utilizar a bilioteca Room com Kotlin (Android Studio)

Este repositório faz parte do conteúdo sobre [Introdução ao Room](https://micilini.com/conteudos/android/room) no portal da [Micilini.com](https://micilini.com), que contém algumas dicas de como utilizar o banco de dados Room com o Kotlin no Android Studio.

## Sobre o Projeto

Este sistema não é um aplicativo pronto, e não possui qualquer tipo de interação entre telas, visto que toda a lógica do banco de dados como a criação, seleção, inserção, atualização e remoção, está sendo declarada dentro do método ```onCreate``` presente na ```MainActivity```.

É importante ressaltar que as dicas aqui presentes estão utilizando o padrão de arquitetura de software chamado MVVM (Model View ViewModel).

Nos exemplos, estou utilizando duas formas de se trabalhar com o banco de dados, na primeira delas estou utilizando algumas anotações como ```@Insert```, ```@Update``` e ```@Delete``` para fazer operações de maneira automática no banco de dados, e em um segundo momento uso a anotação ```@Query``` para fazer ```seleções, inserções, atualizações e remoções```.

Todos os arquivos necessários foram comentados detalhadamente para o seu entendimento.

## Instalação 

Para usar este sistema é necessário que você já tenha instalado na sua máquina local o [Android Studio](https://developer.android.com/studio).

Com o ambiente já configurado, basta fazer o clone deste repositório para dentro do seu ambiente:

 ```git clone https://github.com/micilini/Room-Kotlin.git```

 Por fim, basta abrir a pasta do projeto com o Android Studio e esperar que ele faça a sincronização dos pacotes necessários.

## Por onde começar?

A ideia principal é que você entenda como funciona a comunicação com o banco de dados (SQLite) usando a biblioteca Room por meio do Kotlin.

Nesse caso, comece pelo arquivo ```MainActivity.kt``` e vá seguindo os comandos ali presentes.

## Posso reutilizar os arquivos no meu projeto?

Sim (e deve), a ideia deste projeto é que ele também sirva como template para suas proprias aplicações.

Sendo assim, existem alguns passos para fazer esta implementação:

1) Você vai precisar criar um  ```package ``` cujo nome será  ```repository``` e outro chamado ```model```.

2) Dentro da ```package``` chamada ```repository```, crie mais uma ```package``` chamada de ```dao```.

3) Dentro de ```repository``` crie um arquivo que vai representar o seu banco de dados (```UsuarioDataBase.kt```), e use a mesma lógica que você aprendeu no artigo da micilini.com.

4) Dentro de ```dao``` crie um arquivo que vai representar as operações que seu aplicativo fará no banco de dados (```UsuarioDAO.kt```), e use a mesma lógica que você aprendeu no artigo da micilini.com.

5) Dentro da pasta ```model``` crie um arquivo que vai representar a sua entidade (```UsuarioModel.kt```), e use a mesma lógica que você aprendeu no artigo da micilini.com.

7) Não se esqueça que este projeto usa o padrão MVVM, de modo que você é convidado a utilizar um ViewModel para tratar todas as interações com o Model.

