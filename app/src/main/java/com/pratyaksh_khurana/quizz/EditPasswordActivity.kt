package com.pratyaksh_khurana.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.pratyaksh_khurana.quizz.Login.LoginViewModel
import com.pratyaksh_khurana.quizz.databinding.ActivityEditPasswordBinding

class EditPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPasswordBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("user").toString()
        //already present in database
        val password = intent.getStringExtra("password").toString()
        val id = intent.getStringExtra("id").toString().toInt()

        binding.changePasswordBtn.setOnClickListener {

            if (binding.newPassword.text.toString()
                    .isEmpty() || binding.oldPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()
            } else if (binding.oldPassword.text.toString().trim() != password) {
                Toast.makeText(this, "Прошлый пароль неверен", Toast.LENGTH_SHORT).show()
            } else if (binding.newPassword.text.toString() == password) {
                Toast.makeText(this, "Прошлый пароль совпадает с нововведеным", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Пароль обновлен", Toast.LENGTH_SHORT)
                    .show()

                viewModel.update(binding.newPassword.text.toString(), username)
            }
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}
