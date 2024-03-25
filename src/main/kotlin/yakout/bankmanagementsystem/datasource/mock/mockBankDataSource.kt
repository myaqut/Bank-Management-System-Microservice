package yakout.bankmanagementsystem.datasource.mock
import yakout.bankmanagementsystem.datasource.BankDataSource
import yakout.bankmanagementsystem.model.Bank
import org.springframework.stereotype.Repository
import yakout.bankmanagementsystem.repository.BankRepository

@Repository
class mockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank(5, 200.0, "owner man"),
        Bank(20, 300.0, "Test Name")
    )


    override fun getBanks(): Collection<Bank> = BankRepository.findAll()
    override fun getBank(accountNumber: Int): Bank = banks.firstOrNull() { it.accountNumber == accountNumber }
        ?: throw NoSuchElementException("Could  not find bank with the account number : $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("the bank with account number : ${bank.accountNumber}is already added")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull() { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could  not find bank with the account number : $bank.accountNumber")
        banks.remove(currentBank)
        banks.add(currentBank)
        return bank

    }

    override fun deleteBank(accountNumber: Int): Bank {
        val currentBank = banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could  not find bank with the account number : $accountNumber")
        banks.remove(currentBank)
        return currentBank
    }
}