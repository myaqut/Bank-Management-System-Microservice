package yakout.bankmanagementsystem.repository

import yakout.bankmanagementsystem.model.Bank
import org.springframework.data.jpa.repository.JpaRepository

interface BankRepository : JpaRepository<Bank, Int> {
}