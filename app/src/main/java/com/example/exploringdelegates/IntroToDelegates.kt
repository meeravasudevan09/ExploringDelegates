package com.example.exploringdelegates

fun main() {
    val alice = Coders()
    val ken = Designers()
    val tiberius = SuperEmployee(alice, ken)

    tiberius.code()
    tiberius.design()
}

//    Consider a Super Employee
//    Secret to their success is that they delegate their work to other employees

// SuperEmployee implements both coding and designing
// however it delegates these implementations to other employees using `by`
internal class SuperEmployee(coder: WhoCanCode, designer: WhoCanDesign) : WhoCanCode by coder, WhoCanDesign by designer

//    Skill sets
internal interface WhoCanCode {
    fun code()
}

internal interface WhoCanDesign {
    fun design()
}

//    Employees with different skills
internal class Coders : WhoCanCode {
    override fun code() {
        println("Employee who can code stuff")
    }
}

internal class Designers : WhoCanDesign {
    override fun design() {
        println("Employee who can design stuff")
    }
}

