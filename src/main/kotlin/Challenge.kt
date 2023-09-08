internal enum class ChallengeLevel {
    Basic,
    Intermediate,
    Difficult
}

internal class ChallengeUser(val name: String)

internal data class ChallengeEducationalContent(var name: String, val duration: Int = 60)

internal fun <T> List<T>.test(content: T): String {
    val test =
        if (this.isNotEmpty() && content == this.last()) {
            "."
        } else ";"

    return test
}

internal data class ChallengeFormation(val name: String, val level: ChallengeLevel, var content: List<ChallengeEducationalContent>) {
    private val attach = mutableListOf<ChallengeUser>()

    fun enroll(users: List<ChallengeUser>? = null, user: ChallengeUser? = null) {
        // TODO: "Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $attach)."
        if (users != null) {
            attach.addAll(users)
            println("Usuários ${users.map { userItem -> userItem.name }}, matriculados com sucesso!")
        }

        if (user != null) {
            attach.add(user)
            println("Usuário ${user.name}, matriculado com sucesso!")
        }
    }

    fun allEnrolls() {
        for (attached in attach) {
            println("   . ${attached.name}${attach.test(attached)}")
        }
    }
}

fun main() {
    // TODO: "Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las."
    // TODO: "Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão."
    println("Possíveis usuários:")
    val listOfUsers = listOf(
        ChallengeUser(name = "Ana Clara Guerra dos Santos"),
        ChallengeUser(name = "Felipe Guerra dos Santos")
    )

    println("Nome dos usuários: ${listOfUsers.map { users -> users.name }}") // Ana Clara Guerra dos Santos

    val firstChallengeFormationContents =
        listOf(
            ChallengeEducationalContent(
                name = "Mercado de trabalho para o desenvolvedor Android",
                duration = 2
            ),
            ChallengeEducationalContent(
                name = "Introdução a lógica de programação",
                duration = 8
            ),
            ChallengeEducationalContent(
                name = "Primeiros passos com Kotlin",
                duration = 24
            ),
            ChallengeEducationalContent(
                name = "Primeiros passos com Android",
                duration = 8
            ),
            ChallengeEducationalContent(
                name = "Resumo do conteúdo apresentado na formação",
                duration = 16
            ),
            ChallengeEducationalContent(
                name = "Para onde ir agora?",
                duration = 2
            )
        )

    val firstChallengeFormation =
        ChallengeFormation(
            name = "Android Developer",
            level = ChallengeLevel.Intermediate,
            content = firstChallengeFormationContents
        )

    println()
    println("Testes da primeira formação:") // Android Developer tests:
    println("- Formação:")
    println("   . ${firstChallengeFormation.name}")
    println("   . Nível: ${firstChallengeFormation.level}")
    println("   . Conteúdos:")
    for (content in firstChallengeFormationContents) {
        println("       . ${content.name} e duração de ${content.duration} hora${firstChallengeFormationContents.test(content)}")
    }
    println()
    println("- Matrícula:")
    firstChallengeFormation.enroll(listOfUsers)
    firstChallengeFormation.enroll(user = ChallengeUser("Maria Guerra"))
    println()
    println("- Lista de usuários matriculados:")
    firstChallengeFormation.allEnrolls()

    val secondChallengeFormationContents =
        listOf(
            ChallengeEducationalContent(
                name = "Mercado de trabalho para o desenvolvedor Backend",
                duration = 2
            ),
            ChallengeEducationalContent(
                name = "Introdução a lógica de programação",
                duration = 8
            ),
            ChallengeEducationalContent(
                name = "Primeiros passos com Java para backend",
                duration = 24
            ),
            ChallengeEducationalContent(
                name = "Primeiros passos com Kotlin para backend",
                duration = 8
            ),
            ChallengeEducationalContent(
                name = "Resumo do conteúdo apresentado na formação",
                duration = 16
            ),
            ChallengeEducationalContent(
                name = "Para onde ir agora?",
                duration = 2
            )
        )

    val secondChallengeFormation =
        ChallengeFormation(
            name = "Backend Developer",
            level = ChallengeLevel.Difficult,
            content = firstChallengeFormationContents
        )

    println()
    println("Testes da segunda formação:")
    println("- Formação:")
    println("   . ${secondChallengeFormation.name}")
    println("   . Nível: ${secondChallengeFormation.level}")
    println("   . Conteúdos:")
    for (content in secondChallengeFormationContents) {
        println("       . ${content.name} e duração de ${content.duration} hora${secondChallengeFormationContents.test(content)}")
    }
    println()
    println("- Matrícula:")
    secondChallengeFormation.enroll(listOfUsers)
    println()
    println("- Lista de usuários matriculados:")
    secondChallengeFormation.allEnrolls()
}