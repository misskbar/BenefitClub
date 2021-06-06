package com.prisma.domain.model

import androidx.annotation.Keep
import java.io.Serializable

object BCUIModel {

    data class AccountModel(
        var id: String = "",
        var type: String = "",
        var first_name: String = "",
        var last_name: String = "",
        var identification: String = "",
        var gender: String = "",
        var birth_date: String = "",
        var nationality: String = "",
        var guest_mode: Boolean = false,
        var emailUser: EmailUserModel = EmailUserModel(),
        var addresses: List<AddressModel> = listOf(),
        var validations: List<ValidationModel> = listOf(),
        var information_bank_account: String = "",
        var activity: String = "",
        var contact: String = "",
        var identification_type: String = "",
        var business_cuit: String = "",
        var accountStatus: String = "",
        var telephone: String = "",
        var telefono_fijo: String = ""
    ) : Serializable

    data class EmailUserModel(
        val email: String = "",
        val providerId: String = ""
    )

    data class AddressModel(
        val id: Int = 0,
        var type: Int = 0,
        var street: String = "",
        var number: String = "",
        var floor: String = "",
        var apartment: String = "",
        var city: String = "",
        var state: String = "",
        val typeCode: String = "",
        var zipCode: String = ""
    ) : Serializable

    data class ValidationModel(
        val type: String = "",
        val validated: Boolean = false
    ) : Serializable


    data class ErrorModel(
        val code: Int? = 0,
        val error: String? = "",
        val error_description: String? = ""
    )


    class BackendCallStatus {
        companion object {
            const val OK = "OK"
            const val FAIL = "FAIL"
        }
    }


    class BackendError {
        companion object {
            const val NO_NETWORK = "NO_NETWORK_ERROR"
            const val UNKNOWN_HOST = "UNKNOWN_HOST"
        }
    }
}