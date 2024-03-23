package yakout.bankmanagementsystem.service

import org.springframework.stereotype.Service
import yakout.bankmanagementsystem.datasource.BankDataSource
import yakout.bankmanagementsystem.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.getBanks()
    fun getBank(accountNumber: Int): Bank = dataSource.getBank(accountNumber)
    fun createBank(bank: Bank): Bank = dataSource.createBank(bank)

}