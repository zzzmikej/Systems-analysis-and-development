fun main() {
    println("Primeira aula de Kotlin")
    println("asna")

    // Tipagem Dinamica
    val cidade = "São Paulo";
    val habitantes = 500_000
    val idh = 0.8765
    val temMetro = false

    // Tipagem Estática
    val time:String = "Corinthians"
    val torcedores:Int = 8_000_000
    val patrimonio:Double =  9_000_000_000_000.50
    val temMudial:Boolean = true

    val cpf = "12345678901"
    var endereco = "Rua Zé Ruela, 1000"

    // Variaveis criadas com val são imutaveis e não podem ser reatribuidas
    // cpf = "12345678"

    // Variaveis criadas com var são MUTÁVEIS. Podem ser reatribuidas
    endereco = "Rua Maria Bonita, 90"

    println("Na cidade ${cidade.uppercase()}")
}