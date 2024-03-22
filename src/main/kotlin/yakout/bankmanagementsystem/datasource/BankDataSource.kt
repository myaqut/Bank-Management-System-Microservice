package datasource

import model.Bank

interface BankDataSource {
    fun getBanks() : Collection<Bank>
}