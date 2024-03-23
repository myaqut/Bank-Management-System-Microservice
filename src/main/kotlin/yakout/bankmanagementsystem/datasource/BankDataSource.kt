package yakout.bankmanagementsystem.datasource

import yakout.bankmanagementsystem.model.Bank

interface BankDataSource {
    fun getBanks(): Collection<Bank>
    fun getBank(accountNumber : Int): Bank
    fun createBank(bank: Bank): Bank
}