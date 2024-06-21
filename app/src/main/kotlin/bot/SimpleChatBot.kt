package bot

import java.util.*

fun main() = SimpleChatBot().start()

class SimpleChatBot {

    fun start() = multipleChoice()

    /**
     * https://hyperskill.org/projects/126/stages/672/implement
     *
     * Multiple choice
     * Description
     * At the final stage, you will improve your simple bot so that it can give you a test
     * and check your answers. The test should be a multiple-choice quiz about programming
     * with any number of options. Your bot has to repeat the test until you answer correctly
     * and congratulate you upon completion.
     *
     * Objective
     * Your bot can ask anything you want, but there are two rules for your output:
     *
     * the line with the test should end with the question mark character;
     * an option starts with a digit followed by the dot (1., 2., 3., 4.)
     * If a user enters an incorrect answer, the bot may print a message:
     *
     * Please, try again.
     *
     * The program should stop on the correct answer and print Congratulations, have a nice day! at the end.
     *
     * Example
     * The greater-than symbol followed by a space (> ) represents the user input.
     * Note that it's not part of the input.
     *
     * Example 1: a dialogue with the final version of your bot
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * > Max
     * What a great name you have, Max!
     * Let me guess your age.
     * Enter remainders of dividing your age by 3, 5 and 7.
     * > 1
     * > 2
     * > 1
     * Your age is 22: that's a good time to start programming!
     * Now I will prove to you that I can count to any number you want.
     * > 3
     * 0!
     * 1!
     * 2!
     * 3!
     * Let's test your programming knowledge.
     * Why do we use methods?
     * 1. To repeat a statement multiple times.
     * 2. To decompose a program into several small subroutines.
     * 3. To determine the execution time of a program.
     * 4. To interrupt the execution of a program.
     * > 4
     * Please, try again.
     * > 2
     * Congratulations, have a nice day!
     *
     * The program must end with the Congratulations, have a nice day! message.
     *
     * Use the provided template to simplify your work. You can change the text if you want. Please note that we use functions to make it easy to understand the program and add new code to it or edit later.
     */

    private fun multipleChoice() {
        fun currentYear() = Calendar.getInstance().get(Calendar.YEAR).toString();
        val botname by lazy { "Aid" }
        greet(botname, currentYear()) // change it as you need
        remindName()
        guessAge()
        count()
        askQuestion()
        println(
            """
            Why do we use methods?
            1. To repeat a statement multiple times.
            2. To decompose a program into several small subroutines.
            3. To determine the execution time of a program.
            4. To interrupt the execution of a program.
        """.trimIndent()
        )
        var incorrectAnswer = true
        do {
//        print("> ")
            val answer = readln()
            incorrectAnswer = answer != "2"
            if (incorrectAnswer) println("Please, try again.")
        } while (incorrectAnswer)
        end()

    }

    private fun askQuestion() {
        println("Let's test your programming knowledge.")
    }

    private fun greet(assistantName: String, birthYear: String) {
        println("Hello! My name is ${assistantName}.")
        println("I was created in ${birthYear}.")
        println("Please, remind me your name.")
    }

    private fun remindName() {
        val name = readln() //scanner.nextLine()
        println("What a great name you have, ${name}!")
    }

    private fun guessAge() {
        println("Let me guess your age.")
        println("Enter remainders of dividing your age by 3, 5 and 7.")
        val rem3 = readln().toInt()// scanner.nextInt()
        val rem5 = readln().toInt()// scanner.nextInt()
        val rem7 = readln().toInt()// scanner.nextInt()
        val age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105
        println("Your age is ${age}; that's a good time to start programming!")
    }

    private fun count() {
        println("Now I will prove to you that I can count to any number you want.")
        val num = readln().toInt()// scanner.nextInt()
        for (i in 0..num) {
            print(i)
            println("!")
        }
    }

    private fun test() {
        println("Let's test your programming knowledge.")
        // write your code here
    }

    private fun end() {
        println("Congratulations, have a nice day!") // Do not change this text
    }


    /**
     * https://hyperskill.org/projects/126/stages/671/implement
     *
     * Learning numbers
     * Description
     * Now you will teach your bot to count. It's going to become an expert in numbers!
     *
     * Objective
     * In this stage, you will program the bot to count from 0 to any positive number users enter.
     *
     * Example
     * The greater-than symbol followed by a space (> ) represents the user input.
     * Note that it's not part of the input.
     *
     * Example 1: a dialogue with the new version of the bot
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * > Max
     * What a great name you have, Max!
     * Let me guess your age.
     * Enter remainders of dividing your age by 3, 5 and 7.
     * > 1
     * > 2
     * > 1
     * Your age is 22; that's a good time to start programming!
     * Now I will prove to you that I can count to any number you want.
     * > 5
     * 0!
     * 1!
     * 2!
     * 3!
     * 4!
     * 5!
     * Completed, have a nice day!
     *
     * Note: each number starts with a new line, and after a number, the bot should print the exclamation mark.
     *
     * Use the provided template to simplify your work. You can change the text if you want, but be especially careful when counting numbers.
     */
    fun learingNumbers() {
        fun currentYear() = Calendar.getInstance().get(Calendar.YEAR);
        val botname by lazy { "Aid" }
        fun botGreeting() = print(
            """
        |Hello! My name is ${botname}.
        |I was created in ${currentYear()}.
        |Please, remind me your name.
        |> 
    """.trimMargin()
        )

        @SuppressWarnings("MagicNumber")
        fun calculateOrdinaryAge(remainder3: Int, remainder5: Int, remainder7: Int) =
            (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        botGreeting()
        val yourName = readln()
        println("What a great name you have, ${yourName}!")
        println("Let me guess your age.")
        println("Enter remainders of dividing your age by 3, 5 and 7.")
        print("> ")
        val remainder3 = readln().toInt()
        print("> ")
        val remainder5 = readln().toInt()
        print("> ")
        val remainder7 = readln().toInt()
        val ordinaryAge = calculateOrdinaryAge(remainder3, remainder5, remainder7)
        println("Your age is $ordinaryAge; that's a good time to start programming!")
        println("Now I will prove to you that I can count to any number you want.")
        val scanner = Scanner(System.`in`)
        scanner.use {
            val number = scanner.nextInt()
            (0..number).forEach { println("$it!") }
        }
        println("Completed, have a nice day!")
    }


    /**
     * https://hyperskill.org/projects/126/stages/670/implement
     *
     * Guess the age
     * Description
     * Keep improving your bot by developing new skills for it. We suggest a
     * simple guessing game that will predict the age of a user.
     *
     * It's based on a simple math trick. First, take a look at this formula:
     *
     * age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
     *
     * The numbers remainder3, remainder5, and remainder7 are the remainders of
     * division by 3, 5, and 7 respectively.
     *
     * It turns out that for each number ranging from 0 to 104, the calculation will
     * result in the number itself. This perfectly fits the ordinary age range, doesn't it?
     * Ask the user for the remainders and use them to guess the age!
     *
     * Objective
     * In this stage, you will introduce yourself to the bot. It will greet you by your name and then try to guess your age using arithmetic operations.
     *
     * Your program should print the following lines:
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * What a great name you have, Max!
     * Let me guess your age.
     * Enter remainders of dividing your age by 3, 5 and 7.
     * Your age is {yourAge}; that's a good time to start programming!
     *
     * Read three numbers from the standard input. Assume that all the numbers will be given on separate lines.
     *
     * Instead of {yourAge}, the bot will print the age determined according to the special formula discussed above.
     *
     * Example
     * The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.
     *
     * Example 1: a dialogue with the bot
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * > Max
     * What a great name you have, Max!
     * Let me guess your age.
     * Enter remainders of dividing your age by 3, 5 and 7.
     * > 1
     * > 2
     * > 1
     * Your age is 22; that's a good time to start programming!
     *
     * Use the provided template to simplify your work. You can change the text but not the number of printed lines.
     */
    fun guessTheAge() {
        fun currentYear() = Calendar.getInstance().get(Calendar.YEAR);
        val botname by lazy { "Aid" }
        fun botGreeting() = println(
            """
        |Hello! My name is ${botname}.
        |I was created in ${currentYear()}.
        |Please, remind me your name.
    """.trimMargin()
        )

        @SuppressWarnings("MagicNumber")
        fun calculateOrdinaryAge(remainder3: Int, remainder5: Int, remainder7: Int) =
            (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        botGreeting()
        val yourName = readln()
        println("What a great name you have, ${yourName}!")
        println("Let me guess your age.")
        println("Enter remainders of dividing your age by 3, 5 and 7.")
        print("> ")
        val remainder3 = readln().toInt()
        print("> ")
        val remainder5 = readln().toInt()
        print("> ")
        val remainder7 = readln().toInt()
        val ordinaryAge = calculateOrdinaryAge(remainder3, remainder5, remainder7)
        println("Your age is $ordinaryAge; that's a good time to start programming!")

    }

    /**
     * https://hyperskill.org/projects/126/stages/669/implement
     *
     * Print your name
     * Description
     * The greeting part is great, but chatbots are also supposed to interact with a user. It's time to implement this functionality.
     *
     * Objective
     * In this stage, you will introduce yourself to the bot so that it can greet you by your name.
     *
     * Your program should print the following lines:
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * What a great name you have, {yourName}!
     *
     * You may change the name and the creation year of your bot if you want.
     *
     * Instead of {yourName}, the bot must print your name entered from the standard input.
     *
     * Example
     * The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.
     *
     * Example 1: a dialogue with the bot
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     * Please, remind me your name.
     * > Max
     * What a great name you have, Max!
     *
     * Use the provided template to simplify your work. You can change the text but not the number of printed lines.
     *
     */
    fun printYourName() {
        fun currentYear() = Calendar.getInstance().get(Calendar.YEAR);
        val botname by lazy { "Aid" }
        fun botGreeting() = println(
            """
        |Hello! My name is ${botname}.
        |I was created in ${currentYear()}.
        |Please, remind me your name.
    """.trimMargin()
        )
        botGreeting()
        val yourName = readln()
        println("What a great name you have, ${yourName}!")


    }

    /**
     * https://hyperskill.org/projects/126/stages/668/implement
     *
     * Chatty Bot welcomes you
     * Description
     * Digital personal assistants help people to drive cars,
     * plan their day, and buy things online. In a sense, they
     * are simplified versions of artificial intelligence with
     * whom you can talk.
     *
     * In this project, you will develop step by step a simple bot
     * that will help you study programming.
     *
     * Objective
     * For the first stage, you will write a bot that displays a greeting,
     * its name, and the year it was created. First impressions count!
     *
     * Your program should print the following lines:
     *
     * Hello! My name is {botName}.
     * I was created in {birthYear}.
     *
     * Instead of {botName}, print any name you choose and replace {birthYear}
     * with the current year (four digits). You don't need to take any input in this stage.
     *
     * Example
     * Output:
     *
     * Hello! My name is Aid.
     * I was created in 2023.
     *
     * Here's the result with your bot named Aid, and 2023 as its birth year.
     * Feel free to modify the values, but make sure to print exactly two lines.
     *
     */
    fun chattyBotWelcomesYou() {
        fun currentYear() = Calendar.getInstance().get(Calendar.YEAR);
        val botname = "Aid"
        println("Hello! My name is $botname\nI was created in ${currentYear()}")
    }

    /**
     * Job
     *
     * Julia wants to get a job. By the laws of the country she lives in, she can have a job only if her age is within 18 to 59 years inclusive.
     *
     * Depending on the input age, output true if she can get a job, otherwise output false.
     *
     * Sample Input 1:
     *
     * 25
     *
     * Sample Output 1:
     *
     * true
     *
     * Sample Input 2:
     *
     * 16
     *
     * Sample Output 2:
     *
     * false
     */
    fun job() {
        println(readln().toInt() in 18..59)
    }


    /**
     * https://hyperskill.org/diagnostics/step/11228
     *
     * How to learn the whole Kotlin per one task
     * Write a program that reads five words from the standard input and outputs the words in one line. In the output, the words should be separated by a single space.
     *
     * Sample Input 1:
     *
     * Never
     * gonna
     * give
     * you
     * up
     *
     * Sample Output 1:
     *
     * Never gonna give you up
     *
     * Sample Input 2:
     *
     * Never
     * gonna
     * let
     * you
     * down
     *
     * Sample Output 2:
     *
     * Never gonna let you down
     *
     * Sample Input 3:
     *
     * Never
     * gonna
     * run
     * around
     * and
     *
     * Sample Output 3:
     *
     * Never gonna run around and
     */
    fun first() {
        println(Array(5) { readln() }.toList().joinToString(" "))
    }

}