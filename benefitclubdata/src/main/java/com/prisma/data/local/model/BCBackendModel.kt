package com.prisma.data.local.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.prisma.data.na.backend.model.BackendModel
import java.io.Serializable

object BCBackendModel{

    @Keep
    data class BCAccountModel(
        @SerializedName("id") var id: String? = "",
        @SerializedName("type") var type: String? = "",
        @SerializedName("first_name") var first_name: String? = "",
        @SerializedName("last_name") var last_name: String? = "",
        @SerializedName("identification") var identification: String? = "",
        @SerializedName("gender") var gender: String? = "",
        @SerializedName("birth_date") var birth_date: String? = "",
        @SerializedName("nationality") var nationality: String? = "",
        @SerializedName("guest_mode") var guest_mode: Boolean? = false,
        @SerializedName("user") var emailUser: BCEmailUserModel = BCEmailUserModel(),
        @SerializedName("addresses") var addresses: List<BCAddressModel>? = listOf(),
        @SerializedName("validations") var validations: List<BCValidationModel>? = listOf(),
        @SerializedName("information_bank_account") var information_bank_account: String? = "",
        @SerializedName("activity") var activity: String? = "",
        @SerializedName("contact") var contact: String? = "",
        @SerializedName("identification_type") var identification_type: String? = "",
        @SerializedName("business_cuit") var business_cuit: String? = "",
        @SerializedName("account_status") var accountStatus: String? = "",
        @SerializedName("telefono_movil") var telephone: String? = "",
        @SerializedName("telefono_fijo") var telefono_fijo: String? = "",
        @SerializedName("isSocial") var isSocial: Boolean? = false
    ) : Serializable

    @Keep
    data class BCEmailUserModel(
            @SerializedName("email") var email: String = "",
            @SerializedName("providerId") var providerId: String = ""
    ) : Serializable


    @Keep
    data class BCAddressModel(
            @SerializedName("id") var id: Int? = 0,
            @SerializedName("type") var type: Int? = 0,
            @SerializedName("street") var street: String? = "",
            @SerializedName("number") var number: String? = "",
            @SerializedName("floor") var floor: String? = "",
            @SerializedName("apartment") var apartment: String? = "",
            @SerializedName("city") var city: String? = "",
            @SerializedName("state") var state: String? = "",
            @SerializedName("type_code") var typeCode: String? = "",
            @SerializedName("zip_code") var zipCode: String? = ""
    ) : Serializable

    @Keep
    data class BCValidationModel(
            @SerializedName("type") var type: String = "",
            @SerializedName("validated") var validated: Boolean = false
    ) : Serializable

    @Keep
    data class BCErrorModel(
        @SerializedName("http_code") var http_code: Int = 0,
        @SerializedName("error") var error: String? = "",
        @SerializedName("error_description") var error_description: String? = ""
    ) : Serializable


}