package yakout.bankmanagementsystem.datasource.mock

import yakout.bankmanagementsystem.datasource.BankDataSource
import yakout.bankmanagementsystem.model.Bank
import org.springframework.stereotype.Repository
import yakout.bankmanagementsystem.repository.BankRepository

@Repository
class mockBankDataSource(val bankRepository: BankRepository) : BankDataSource {
    override fun getBanks(): Collection<Bank> = bankRepository.findAll()
    override fun getBank(accountNumber: Int): Bank = bankRepository.findById(accountNumber)
        .orElseThrow { NoSuchElementException("Could  not find bank with the account number : $accountNumber") }

    override fun createBank(bank: Bank): Bank {
        if (bankRepository.existsById(bank.accountNumber)) {
            throw IllegalArgumentException("the bank with account number : ${bank.accountNumber}is already added")
        }
        bankRepository.save(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = bankRepository.findById(bank.accountNumber)
            .orElseThrow { NoSuchElementException("Could  not find bank with the account number : ${bank.accountNumber}") }
        bankRepository.save(bank)
        return bank

    }

    override fun deleteBank(accountNumber: Int): Bank {
        val bankToDelte = bankRepository.findById(accountNumber)
            .orElseThrow { NoSuchElementException("Could  not find bank with the account number : $accountNumber") }

        bankRepository.deleteById(accountNumber)
        return bankToDelte
    }
}