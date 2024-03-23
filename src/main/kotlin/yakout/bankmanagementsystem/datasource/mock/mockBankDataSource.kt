package yakout.bankmanagementsystem.datasource.mock

import yakout.bankmanagementsystem.datasource.BankDataSource
import yakout.bankmanagementsystem.model.Bank
import org.springframework.stereotype.Repository

@Repository
class mockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank(5, 200.0, "owner man"),
        Bank(20, 300.0, "Test Name")
    )


    override fun getBanks(): Collection<Bank> = banks
    override fun getBank(accountNumber: Int): Bank {
        return banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could  not find bank with the account number : $accountNumber")
    }

    override fun createBank(bank: Bank): Bank {
        if(banks.any{it.accountNumber==bank.accountNumber}){
            throw IllegalArgumentException("the bank with account number : ${bank.accountNumber }is already added")
        }
        banks.add(bank)
        return bank
    }
}