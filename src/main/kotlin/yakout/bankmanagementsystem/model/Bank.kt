package yakout.bankmanagementsystem.model
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bank")
data class Bank(
    @Id
    val accountNumber: Int = 0, // Default value for ID
    val balance: Double = 0.0, // Default value for balance
    val accountOwner: String = "" // Default value for accountOwner
)
