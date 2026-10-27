package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2274802010432

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ProfileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 1. Ánh xạ các thành phần giao diện
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvCourses = findViewById<ListView>(R.id.lvCourses)

        // 2. Nhận email từ LoginActivity
        val email = intent.getStringExtra("EMAIL")
        tvEmail.text = "Email: ${email ?: "Không có thông tin"}"

        // 3. Xử lý đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }

        // 4. Tạo danh sách ít nhất 5 học phần
        val courses = arrayOf(
            "Lập trình Android",
            "Lập trình Java",
            "Cơ sở dữ liệu",
            "Cấu trúc dữ liệu và giải thuật",
            "Phát triển ứng dụng Web"
        )

        // 5. Tạo ArrayAdapter để hiển thị dữ liệu
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            courses
        )

        lvCourses.adapter = adapter

        // 6. Xử lý sự kiện khi nhấn vào một học phần
        lvCourses.setOnItemClickListener { _, _, position, _ ->
            val selectedCourse = courses[position]

            Toast.makeText(
                this,
                "Bạn đã chọn: $selectedCourse",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
