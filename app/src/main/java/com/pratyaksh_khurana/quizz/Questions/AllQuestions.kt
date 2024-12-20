package com.pratyaksh_khurana.quizz.Questions

class AllQuestions {

    fun insertAll(): List<QuestionEntity> {

        val iList: MutableList<QuestionEntity> = mutableListOf()

        val q1 = QuestionEntity(
            id = null,
            question = "Какой из следующих языков программирования является языком высокого уровня?",
            op1 = "Assembly",
            op2 = "Python",
            op3 = "C",
            op4 = "C++",
            answer = "Python",
            subject = "Proger"
        )
        val q2 = QuestionEntity(
            id = null,
            question = "Что такое переменная в программировании?",
            op1 = "Это место для хранения данных",
            op2 = "Это функция, которая выполняет операции",
            op3 = "Это ошибка в коде",
            op4 = "Ни один из вышеперечисленных",
            answer = "Это место для хранения данных",
            subject = "Proger"
        )
        val q3 = QuestionEntity(
            id = null,
            question = "Какой из следующих операторов используется для сравнения в Java?",
            op1 = "=",
            op2 = "==",
            op3 = "===",
            op4 = "====",
            answer = "==",
            subject = "Proger"
        )
        val q4 = QuestionEntity(
            id = null,
            question = "Что такое Git?",
            op1 = "Это система контроля версий",
            op2 = "Это язык программирования",
            op3 = "Это текстовый редактор",
            op4 = "Это системная программа",
            answer = "Это система контроля версий",
            subject = "Proger"
        )
        val q5 = QuestionEntity(
            id = null,
            question = "Что такое A/B тестирование?",
            op1 = "Это метод сравнения двух вариантов для определения более эффективного",
            op2 = "Это способ управления проектами  ",
            op3 = "Это метод программирования",
            op4 = "Это математическая функция",
            answer = "Это метод сравнения двух вариантов для определения более эффективного",
            subject = "Proger"
        )
        val q6 = QuestionEntity(
            id = null,
            question = "Какой из следующих форматов изображений лучше всего подходит для веб-дизайна?",
            op1 = "JPEG",
            op2 = "BMP",
            op3 = "TIFF",
            op4 = "PNG",
            answer = "JPEG",
            subject = "Design"
        )
        val q7 = QuestionEntity(
            id = null,
            question = "Что такое wireframe?",
            op1 = "Схематическое представление интерфейса",
            op2 = "Финальный дизайн",
            op3 = "Метод рисования",
            op4 = "Графический интерфейс",
            answer = "Схематическое представление интерфейса",
            subject = "Design"
        )
        val q8 = QuestionEntity(
            id = null,
            question = "Какой из следующих стилей дизайна акцентирует внимание на простоте и минимализме?",
            op1 = "Минимализм",
            op2 = "Барокко",
            op3 = "Ренессанс",
            op4 = "Ар деко",
            answer = "Минимализм",
            subject = "Design"
        )
        val q9 = QuestionEntity(
            id = null,
            question = "Что такое UX-дизайн?",
            op1 = "Дизайн пользовательского опыта",
            op2 = "Дизайн пользовательского интерфейса.",
            op3 = "Дизайн графики.",
            op4 = "Дизайн гарганты",
            answer = "Дизайн пользовательского опыта.",
            subject = "Design"
        )
        val q10 = QuestionEntity(
            id = null,
            question = "Что такое цветовая палитра?",
            op1 = "Набор цветов, используемых в дизайне.",
            op2 = "Метод рисования.",
            op3 = "Тип шрифта",
            op4 = "Это paint",
            answer = "Набор цветов, используемых в дизайне.",
            subject = "Design"
        )

        val q11 = QuestionEntity(
            id = null,
            question = "Что такое бизнес-аналитика?",
            op1 = "Это процесс анализа данных для принятия бизнес-решений",
            op2 = "Это метод программирования",
            op3 = "Это способ управления проектами",
            op4 = "Это метод аналитики",
            answer = "Это процесс анализа данных для принятия бизнес-решений",
            subject = "Analytics"
        )
        val q12 = QuestionEntity(
            id = null,
            question = "Какой из следующих инструментов часто используется для визуализации данных?",
            op1 = "Excel",
            op2 = "Notepad",
            op3 = "Word",
            op4 = "Powerpoint",
            answer = "Excel",
            subject = "Analytics"
        )
        val q13 = QuestionEntity(
            id = null,
            question = "Что такое KPI?",
            op1 = "Ключевые показатели эффективности",
            op2 = "Ключевые параметры информации",
            op3 = "Ключевые принципы интеграции",
            op4 = "Ключевые случаи в интеграции",
            answer = "Ключевые показатели эффективности",
            subject = "Analytics"
        )
        val q14 = QuestionEntity(
            id = null,
            question = "Какой метод анализа данных используется для выявления закономерностей?",
            op1 = "SWOT-анализ",
            op2 = "Регрессионный анализ",
            op3 = "PEST-анализ",
            op4 = "Анализ",
            answer = "Регрессионный анализ",
            subject = "Analytics"
        )
        val q15 = QuestionEntity(
            id = null,
            question = "Что такое SWOT-анализ?",
            op1 = "Это метод оценки сильных и слабых сторон, возможностей и угроз",
            op2 = "Это способ управления проектами",
            op3 = "Это метод программирования",
            op4 = "Это метод анализа",
            answer = "Это метод оценки сильных и слабых сторон, возможностей и угроз",
            subject = "Analytics"
        )

        iList.add(q1)
        iList.add(q2)
        iList.add(q3)
        iList.add(q4)
        iList.add(q5)
        iList.add(q6)
        iList.add(q7)
        iList.add(q8)
        iList.add(q9)
        iList.add(q10)
        iList.add(q11)
        iList.add(q12)
        iList.add(q13)
        iList.add(q14)
        iList.add(q15)

        return iList
    }
}