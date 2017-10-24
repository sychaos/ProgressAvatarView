package cloudist.cc.progressavatarview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cloudist.cc.library.CircleImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CircleImageView = findViewById<CircleImageView>(R.id.circle_image_view)
        CircleImageView.post {
            CircleImageView.startAnim()
        }
    }
}
