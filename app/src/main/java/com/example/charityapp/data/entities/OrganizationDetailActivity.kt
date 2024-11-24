import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.charityapp.R


class OrganizationDetailActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var websiteTextView: TextView
    private lateinit var donationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organization_detail)

        nameTextView = findViewById(R.id.nameTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        websiteTextView = findViewById(R.id.websiteTextView)
        donationButton = findViewById(R.id.donationButton)

        // Get data passed from previous activity
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val website = intent.getStringExtra("website")
        val donationLink = intent.getStringExtra("donationLink")

        // Set data to views
        nameTextView.text = name
        descriptionTextView.text = description
        websiteTextView.text = website

        // Handle donation button click
        donationButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(donationLink))
            startActivity(intent)
        }
    }
}
