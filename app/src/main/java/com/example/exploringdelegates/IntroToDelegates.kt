package com.example.exploringdelegates

fun main() {
    val alice = Coders()
    val ken = Designers()
    val olive = Testers()
    val tiberius = SuperEmployee(alice, ken, olive)

    tiberius.code()
    tiberius.design()
    tiberius.test()
}

//    Consider a Super Employee
//    Secret to their success is that they delegate their work to other employees

// SuperEmployee implements both coding and designing
// however it delegates these implementations to other employees using `by`
internal class SuperEmployee(coder: WhoCanCode, designer: WhoCanDesign, tester: WhoCanTest) :
    WhoCanCode by coder, WhoCanDesign by designer, WhoCanTest by tester

//    Skill sets
internal interface WhoCanCode {
    fun code()
}

internal interface WhoCanDesign {
    fun design()
}

internal interface WhoCanTest {
    fun test()
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

internal class Testers: WhoCanTest {
    override fun test() {
        println("Employee who can test stuff")
    }
}
