package yakout.bankmanagementsystem.repository

import yakout.bankmanagementsystem.model.Bank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BankRepository : JpaRepository<Bank, Int> {
}