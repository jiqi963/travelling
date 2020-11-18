package wangk6.travelling.activities

import op.wangk6.travelling.R


object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERs : String ="correct_answers"

    fun getQuestions(): ArrayList<wangk6.travelling.activities.Question> {
        val questionsList = ArrayList<wangk6.travelling.activities.Question>()

        val que1 = wangk6.travelling.activities.Question(
            1,
            "Which national flag is this?",
            R.drawable.maori,
            "Maori",
            "Eskimos ",
            "Armenian",
            "Jewish",
            1
        )

        val que2 = wangk6.travelling.activities.Question(
            2,
            "Which cooking method is this?",
            R.drawable.hangi,
            "BBQ",
            "IMU",
            "Sun-dried Potato",
            "Hangi",
            4
        )

        val que3 = wangk6.travelling.activities.Question(
            3,
            "Which build is this?",
            R.drawable.marae,
            "Cinema",
            "Mall",
            "Marae",
            "Theater",
            3
        )

        val que4 = wangk6.travelling.activities.Question(
            4,
            "What is this?",
            R.drawable.pounamu,
            "Pounamu",
            "Emerald",
            "Turquoise",
            "Olivine",
            1
        )

        val que5 = wangk6.travelling.activities.Question(
            5,
            "What is this?",
            R.drawable.haka,
            "Hip Hop",
            "Jazz",
            "Ballet",
            "Haka",
            4
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)

        return questionsList
    }
}