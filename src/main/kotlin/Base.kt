internal enum class Level {
    Basic,
    Intermediate,
    Difficult
}

internal class User(val name: String)

internal data class EducationalContent(var name: String, val duration: Int = 60)

internal data class Formation(val name: String, var content: List<EducationalContent>) {
    private val attach = mutableListOf<User>()

    fun matricular(usuario: User) {
        // TODO: "Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $attach)."
    }
}

fun main() {
    // TODO: "Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las."
    // TODO: "Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão."
}