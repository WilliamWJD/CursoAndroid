package com.example.projeto

import java.util.Scanner
import java.util.UUID

class Pessoa(
    var id: String,
    var nome: String,
    var idade: Int
)

fun main() {

    val scanner = Scanner(System.`in`)
    val listaPessoas = mutableListOf<Pessoa>()
    var opcao: Int

    do {
        opcao = mostrarMenu(scanner)

        when (opcao) {
            1 -> cadastrar(scanner, listaPessoas)
            2 -> listar(listaPessoas)
            3 -> pesquisar(scanner, listaPessoas)
            4 -> alterar(scanner, listaPessoas)
            5 -> remover(scanner, listaPessoas)
            6 -> println("Sistema finalizado")
            else -> println("Opção inválida")
        }

    } while (opcao != 6)
}

fun mostrarMenu(scanner: Scanner): Int {
    println("\n1 - Cadastrar")
    println("2 - Listar")
    println("3 - Pesquisar")
    println("4 - Alterar")
    println("5 - Remover")
    println("6 - Finalizar")
    print("Escolha uma opcao: ")

    val opcao = scanner.nextInt()
    scanner.nextLine()

    return opcao
}

fun cadastrar(scanner: Scanner, lista: MutableList<Pessoa>) {

    print("Nome: ")
    val nome = scanner.nextLine()

    print("Idade: ")
    val idade = scanner.nextInt()
    scanner.nextLine()

    if (idade <= 0) {
        println("Idade invalida")
        return
    }

    val id = UUID.randomUUID().toString()

    val pessoa = Pessoa(id, nome, idade)
    lista.add(pessoa)

    println("Pessoa cadastrada com sucesso! ID: $id")
}

fun listar(lista: List<Pessoa>) {

    if (lista.isEmpty()) {
        println("Nenhum registro encontrado")
        return
    }

    println("\nLista de Pessoas:")

    lista.forEach {
        println("ID: ${it.id} | Nome: ${it.nome} | Idade: ${it.idade}")
    }
}

fun pesquisar(scanner: Scanner, lista: List<Pessoa>) {

    print("Digite o ID: ")
    val id = scanner.nextLine()

    val pessoa = lista.find { it.id == id }

    if (pessoa != null) {
        println("Encontrado -> Nome: ${pessoa.nome} | Idade: ${pessoa.idade}")
    } else {
        println("Pessoa não encontrada")
    }
}

fun alterar(scanner: Scanner, lista: MutableList<Pessoa>) {

    print("Digite o ID para alterar: ")
    val id = scanner.nextLine()

    val pessoa = lista.find { it.id == id }

    if (pessoa == null) {
        println("Pessoa não encontrada")
        return
    }

    print("Novo nome: ")
    val nome = scanner.nextLine()

    print("Nova idade: ")
    val idade = scanner.nextInt()

    scanner.nextLine()

    pessoa.nome = nome
    pessoa.idade = idade

    println("Registro alterado com sucesso")
}

fun remover(scanner: Scanner, lista: MutableList<Pessoa>) {

    print("Digite o ID para remover: ")
    val id = scanner.nextLine()

    val pessoa = lista.find { it.id == id }

    if (pessoa != null) {
        lista.remove(pessoa)
        println("Registro removido")
    } else {
        println("Pessoa não encontrada")
    }
}
