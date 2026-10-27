package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2274802010432

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ các thành phần giao diện
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // Xử lý khi nhấn nút Đăng nhập
        btnLogin.setOnClickListener {

            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập email!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text = "Email không hợp lệ!"
                }

                password.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập mật khẩu!"
                }

                password.length < 6 -> {
                    tvStatus.text =
                        "Mật khẩu phải có ít nhất 6 ký tự!"
                }

                else -> {
                    tvStatus.text = "Xác thực thành công!"

                    // Chuyển sang ProfileActivity
                    val intent = Intent(
                        this@LoginActivity,
                        ProfileActivity::class.java
                    )

                    // Truyền email sang màn hình hồ sơ
                    intent.putExtra("EMAIL", email)

                    startActivity(intent)
                }
            }
        }
    }
}
