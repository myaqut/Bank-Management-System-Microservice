package datasource.mock

import datasource.BankDataSource
import model.Bank
import org.springframework.stereotype.Repository

@Repository
class mockBankDataSource : BankDataSource {
    val banks = listOf(Bank(5, 200.0, "owner man"))
    override fun getBanks(): Collection<Bank> = banks
}