package com.prisma.data.cache.model

import androidx.annotation.Keep
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.prisma.data.cache.BC_ACCOUNT_TABLE_NAME
import com.prisma.data.cache.BC_ADDRESS_TABLE_NAME
import com.prisma.data.cache.BC_USER_EMAIL
import com.prisma.data.cache.BC_VALIDATIONS_TABLE_NAME
import com.prisma.data.cache.converters.BCAddressModelConverter
import com.prisma.data.model.BCBackendModel
import java.io.Serializable

@Keep
 object BCCacheModel {

     @Entity(tableName = BC_ACCOUNT_TABLE_NAME)
     @Keep
     @SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
     data class BCAccountModel(
             @PrimaryKey @SerializedName("id") var id: String = "",
             val type: String = "",
             val first_name: String = "",
             val last_name: String = "",
             val identification: String = "",
             val gender: String = "",
             val birth_date: String = "",
             val nationality: String = "",
             val guest_mode: Boolean = false,
             @Embedded(prefix = "emailUser_") val emaiUser: BCEmailUserModel = BCEmailUserModel(),
             @TypeConverters(BCAddressModelConverter::class)
             var addresses: List<BCAddressModel>,
             val validations: List<BCValidationModel> = listOf(),
             val information_bank_account: String = "",
             val activity: String = "",
             val contact: String = "",
             val identification_type: String = "",
             val business_cuit: String = "",
             var accountStatus: String = "",
             var telefonoMovil: String = "",
             var telefonoFijo: String = "",
             var isSocial: Boolean = false
     ) : Serializable

     @Entity(tableName = BC_ADDRESS_TABLE_NAME)
     @Keep
     data class BCAddressModel(
             @PrimaryKey
             var id: Int? = 0,
             val type: Int? = 0,
             val street: String? = "",
             val number: String? = "",
             val floor: String? = "",
             val apartment: String? = "",
             val city: String? = "",
             val state: String? = "",
             val typeCode: String? = "",
             val zipCode: String? = ""
     ) : Serializable

     @Entity(tableName = BC_USER_EMAIL)
     @Keep
     data class BCEmailUserModel(
             @PrimaryKey(autoGenerate = true)
             val id: Int = 0,
             val email: String = "",
             var providerId: String = ""
     ) {
         constructor(backendModel: BCBackendModel.BCEmailUserModel) : this(
                 email = backendModel.email,
                 providerId = backendModel.providerId
         )
     }

     @Entity(tableName = BC_VALIDATIONS_TABLE_NAME)
     @Keep
     data class BCValidationModel(
             val type: String = "",
             var validated: Boolean = false
     )
 }