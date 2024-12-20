package com.pratyaksh_khurana.quizz

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pratyaksh_khurana.quizz.History.HistoryEntity
import com.pratyaksh_khurana.quizz.History.HistoryViewModel
import com.pratyaksh_khurana.quizz.Questions.QuestionEntity
import com.pratyaksh_khurana.quizz.Questions.QuestionViewModel
import com.pratyaksh_khurana.quizz.databinding.ActivityQuestionBinding
import java.util.*

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private lateinit var subjectChosen: String
    private lateinit var userName: String

    private var i = 0
    private var correct = 0
    private var incorrect = 0
    private var points = 0
    private var totalPoints = 0


    //for saving history of user
    private val viewModel1: HistoryViewModel by viewModels()

    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userName = intent.getStringExtra("user").toString()
        //subject chosen from previous activity
        subjectChosen = intent.getStringExtra("subject").toString()

        //set subject chosen
        binding.subject.text = getString(R.string.chosenSubject, subjectChosen)

        when (subjectChosen) {
            "Proger" -> {
                getProgerQues()
            }
            "Design" -> {
                getDesignQues()
            }
            "Analytics" -> {
                getAnalyticsQues()
            }
        }


        //on press back button return to subject chosen activity
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    //render questions on screen
    @SuppressLint("StringFormatMatches")
    private fun renderQuesOnScreen(question: List<QuestionEntity>, index: Int) {

        //reset all options to default state
        binding.op1.isChecked = true

        if (i == 4) {
            binding.nextBtn.text = "Финиш"
        }
        //all questions over
        //head to finish result activity
        // as of now it heads to subject activity
        if (i > 4) {
            Toast.makeText(
                this,
                "Верных = $correct, неверных $incorrect, очков $points   ",
                Toast.LENGTH_SHORT
            ).show()

//            totalPoints = viewModel1.getTotalPointsOfUser(userName) + points
//            Toast.makeText(this,totalPoints.toString(),Toast.LENGTH_LONG).show()

            viewModel1.insert(
                HistoryEntity(
                    id = null,
                    username = userName,
                    subject = subjectChosen,
                    earned = points,
                    date = currentDate(),
                    time = currentTime()
                )
            )

            //head to result activity to show the results of current transaction
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("subject", subjectChosen)
            intent.putExtra("correct", correct)
            intent.putExtra("incorrect", incorrect)
            intent.putExtra("currentDate", currentDate())
            intent.putExtra("currentTime", currentTime())
            intent.putExtra("pointScoredCurrent", points)
            //total points scored in particular subject
            intent.putExtra("totalPointsTillDate", totalPoints)

            startActivity(intent)
        } else {

            val idx = (index + 1)
            idx.toString()
            binding.questionNumber.text = getString(R.string.questionNumber, idx)
            binding.questionText.text = question[index].question
            binding.op1.text = question[index].op1
            binding.op2.text = question[index].op2
            binding.op3.text = question[index].op3
            binding.op4.text = question[index].op4

            binding.nextBtn.setOnClickListener {

                if (binding.op1.isChecked || binding.op2.isChecked || binding.op3.isChecked || binding.op4.isChecked) {

                    //calculate points and number of right and wrong answers
                    if (binding.op1.isChecked) {
                        if (binding.op1.text.toString() == question[index].answer) {
                            //correct answer
                            correct()
                        } else {
                            //wrong answer
                            incorrect()
                        }
                    } else if (binding.op2.isChecked) {
                        if (binding.op2.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    } else if (binding.op3.isChecked) {
                        if (binding.op3.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    } else if (binding.op4.isChecked) {
                        if (binding.op4.text.toString() == question[index].answer) {
                            correct()
                        } else {
                            incorrect()
                        }
                    }

                    i++
                    renderQuesOnScreen(question, i)

                } else {
                    Toast.makeText(this, "Select an answer", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    //correct answer +5
    private fun correct() {
        correct++
        points += 5
    }

    //incorrect answer -2
    private fun incorrect() {
        incorrect++
        points -= 2
    }

    //get all question of particular subject
    private fun getProgerQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("Proger")
        renderQuesOnScreen(l, 0)
    }

    private fun getDesignQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("Design")
        renderQuesOnScreen(l, 0)
    }

    private fun getAnalyticsQues() {
        val l: List<QuestionEntity> = viewModel.getAllQuestions("Analytics")
        renderQuesOnScreen(l, 0)
    }

    //    get current date
    private fun currentDate(): String {
        return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
    }

    // get current time
    private fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    override fun onRestart() {
        onBackPressed()
        super.onRestart()
    }


}