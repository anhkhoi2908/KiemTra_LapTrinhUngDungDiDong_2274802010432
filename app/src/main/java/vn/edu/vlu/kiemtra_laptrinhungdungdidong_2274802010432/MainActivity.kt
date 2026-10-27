package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2274802010432
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Nhận email từ LoginActivity
        val email = intent.getStringExtra("EMAIL")

        // Hiển thị email
        tvEmail.text = "Email: ${email ?: "Không có thông tin"}"

        // Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
