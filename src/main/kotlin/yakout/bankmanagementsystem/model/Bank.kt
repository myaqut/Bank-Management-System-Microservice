package yakout.bankmanagementsystem.model
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Bank")
data class Bank(
    @Id
    val accountNumber: Int,
    val balance: Double,
    val accountOwner: String
)