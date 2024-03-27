package yakout.bankmanagementsystem.datasource.mock

import org.springframework.data.repository.findByIdOrNull
import yakout.bankmanagementsystem.datasource.BankDataSource
import yakout.bankmanagementsystem.model.Bank
import org.springframework.stereotype.Repository
import yakout.bankmanagementsystem.repository.BankRepository

@Repository
class mockBankDataSource(private val BankRepository: BankRepository) : BankDataSource {

    override fun getBanks(): Collection<Bank> = BankRepository.findAll()
    override fun getBank(accountNumber: Int): Bank = BankRepository.findById(accountNumber)
        .orElseThrow { NoSuchElementException("Could  not find bank with the account number : $accountNumber") }

    override fun createBank(bank: Bank): Bank {
        if (BankRepository.existsById(bank.accountNumber)) {
            throw IllegalArgumentException("the bank with account number : ${bank.accountNumber}is already added")
        }
        BankRepository.save(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        BankRepository.findByIdOrNull(bank.accountNumber)
            ?: throw NoSuchElementException("Could  not find bank with the account number : $bank.accountNumber")


        BankRepository.save(bank)

        return bank

    }

    override fun deleteBank(accountNumber: Int): Bank {
        val currentBank = BankRepository.findByIdOrNull(accountNumber)
            ?: throw NoSuchElementException("Could  not find bank with the account number : $accountNumber")
        BankRepository.deleteById(accountNumber)
        return currentBank
    }
}