package cloudist.cc.progressavatarview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cloudist.cc.library.ProgressAvatarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CircleImageView = findViewById<ProgressAvatarView>(R.id.circle_image_view)
        CircleImageView.post {
            CircleImageView.startAnim()
        }

        CircleImageView.postDelayed({
            CircleImageView.finishAnim()
        }, 3000)
    }
}
