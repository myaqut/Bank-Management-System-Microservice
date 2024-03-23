package yakout.bankmanagementsystem.service

import io.mockk.mockk
import io.mockk.verify
import jakarta.activation.DataSource
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import yakout.bankmanagementsystem.datasource.BankDataSource

internal class BankServiceTest{
    val dataSource : BankDataSource = mockk(relaxed = true)
    val bankservice = BankService(dataSource)


    @Test
    fun `call the data source to retrieve data`(){
    val banks = bankservice.getBanks()
        verify(exactly = 1) {  dataSource.getBanks()}

    }
}