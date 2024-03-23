package datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import yakout.bankmanagementsystem.datasource.mock.mockBankDataSource

internal class mockBankDataSourceTest {
    val mockBankDataSource = mockBankDataSource()

    @Test
    fun `should return a list of banks`() {

        val banks = mockBankDataSource.getBanks()
        assertThat(banks).isNotEmpty

        assertThat(banks).allMatch { it.accountOwner.isNotEmpty()}
        assertThat(banks).allMatch { it.accountNumber != 0  }


    }
}