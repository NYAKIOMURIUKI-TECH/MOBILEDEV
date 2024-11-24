import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.charityapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OrganizationAdapter
    private lateinit var organizations: List<Organization>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of organizations
        organizations = listOf(
            Organization("UNICEF", "UNICEF works for children's rights worldwide.", "https://www.unicef.org", "https://www.unicef.org/donate"),
            Organization("Red Cross", "Red Cross provides emergency assistance and disaster relief.", "https://www.redcross.org", "https://www.redcross.org/donate"),
            Organization("World Health Organization", "WHO leads global efforts to improve health and well-being.", "https://www.who.int", "https://www.who.int/donate")
        )

        // Set the adapter to RecyclerView
        adapter = OrganizationAdapter(this, organizations)
        recyclerView.adapter = adapter
    }
}

