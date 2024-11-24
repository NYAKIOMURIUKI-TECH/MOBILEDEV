import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.charityapp.R
import androidx.recyclerview.widget.RecyclerView


class OrganizationAdapter(
    private val context: Context,
    private val organizations: List<Organization>
) : RecyclerView.Adapter<OrganizationAdapter.OrganizationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_organization, parent, false)
        return OrganizationViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        val organization = organizations[position]
        holder.nameTextView.text = organization.name
        holder.descriptionTextView.text = organization.description

        // Handle item click
        holder.itemView.setOnClickListener {
            // When clicked, open the detailed screen
            val intent = Intent(context, OrganizationDetailActivity::class.java).apply {
                putExtra("name", organization.name)
                putExtra("description", organization.description)
                putExtra("website", organization.website)
                putExtra("donationLink", organization.donationLink)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = organizations.size

    class OrganizationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }
}
