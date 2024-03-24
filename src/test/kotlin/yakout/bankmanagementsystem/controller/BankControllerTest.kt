package yakout.bankmanagementsystem.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*
import yakout.bankmanagementsystem.model.Bank

@SpringBootTest
@AutoConfigureMockMvc

internal class BankControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {
    val baseURL = "/api/banks"

    @Nested
    @DisplayName("GET method Test")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GETBank {
        val bankAccountNumber: Int = 5

        @Test
        fun `return the bank`() {
            mockMvc.get("$baseURL/$bankAccountNumber").andDo { print() }.andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    jsonPath("$.accountNumber") { value(5) }
                }

            }
        }

        @Nested
        @DisplayName("GET method for one bank")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class GETBanks {
            @Test
            fun `return all banks`() {
                mockMvc.get(baseURL).andDo { print() }.andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }

            }
        }


        @Nested
        @DisplayName("POST add new bank")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class POSTBanks {
            @Test
            fun `add new bank instance`() {
                // given
                val newBank = Bank(500, 1000.0, "test account owner")
                //When

                val performPost = mockMvc.post(baseURL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(newBank)

                }
                // then
                performPost.andDo { print() }.andExpect {
                    status { isCreated() }
                    jsonPath("$.accountNumber") { value(500) }
                }
            }

            @Test
            fun `return bad request when the bank already exists`() {
                // given
                val invalidNewBank = Bank(5, 1000.0, "test accoutn owner")
                //When

                val performPost = mockMvc.post(baseURL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(invalidNewBank)

                }
                // then
                performPost.andDo { print() }.andExpect {
                    status { isBadRequest() }
                }
            }

        }

        @Nested
        @DisplayName("Put request test")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class PatchRequest {
            @Test
            fun `check if patch request send positive status`() {

                //given

                val updatedBank = Bank(5, 300.0, "owner man")
                // when
                val performPatch = mockMvc.patch(baseURL) {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(updatedBank)

                }
                //then

                performPatch.andDo { print() }.andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updatedBank))
                    }
                }

            }
        }

        @Nested
        @DisplayName("Delete request test")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        inner class DeleteRequest {
            @Test
            fun `check if delete request send positive status`() {

                //given

                val bankAccountNumber = 20
                // when
                val performDelete = mockMvc.delete("$baseURL/$bankAccountNumber") {

                }
                //then

                performDelete.andDo { print() }.andExpect {
                    status { isOk() }

                }


            }
        }
    }
}


