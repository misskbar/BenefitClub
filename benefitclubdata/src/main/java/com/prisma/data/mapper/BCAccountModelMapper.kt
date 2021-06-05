package com.prisma.data.mapper

import com.prisma.data.cache.model.BCCacheModel
import com.prisma.data.model.BCBackendModel
import com.prisma.data.na.mapper.ItemModelMapper

class BCAccountModelMapper :
    ItemModelMapper<BCBackendModel.BCAccountModel, BCCacheModel.BCAccountModel> {
    override fun fromBackendModelToCacheModel(origin: BCBackendModel.BCAccountModel): BCCacheModel.BCAccountModel {
        return BCCacheModel.BCAccountModel(
            origin.id ?: "",
            origin.type ?: "",
            origin.first_name ?: "",
            origin.last_name ?: "",
            origin.identification ?: "",
            origin.gender ?: "",
            origin.birth_date ?: "",
            origin.nationality ?: "",
            origin.guest_mode ?: false,

            BCCacheModel.BCEmailUserModel(
                0,
                origin.emailUser.email ?: "",
                origin.emailUser.providerId ?: ""
            ),
            origin.addresses?.map {
                BCCacheModel.BCAddressModel(
                    it.id, it.type, it.street, it.number, it.floor,
                    it.apartment, it.city, it.state, it.typeCode, it.zipCode
                )
            } ?: listOf(),
            origin.validations?.map { BCCacheModel.BCValidationModel(it.type, it.validated) }
                ?: listOf(),
            origin.information_bank_account ?: "",
            origin.activity ?: "",
            origin.contact ?: "",
            origin.identification_type ?: "",
            origin.business_cuit ?: "",
            origin.accountStatus ?: "",
            origin.telephone ?: "",
            origin.telefono_fijo ?: "",
            origin.isSocial ?: false
        )
    }

    override fun fromCacheModelToBackendModel(origin: BCCacheModel.BCAccountModel): BCBackendModel.BCAccountModel {

        return BCBackendModel.BCAccountModel(
            origin.id,
            origin.type,
            origin.first_name,
            origin.last_name,
            origin.identification,
            origin.gender,
            origin.birth_date,
            origin.nationality,
            origin.guest_mode,
            BCBackendModel.BCEmailUserModel(origin.emaiUser.email, origin.emaiUser.providerId),
            origin.addresses.map {
                BCBackendModel.BCAddressModel(
                    it.id, it.type, it.street, it.number, it.floor,
                    it.apartment, it.city, it.state, it.typeCode, it.zipCode
                )
            },
            origin.validations.map { BCBackendModel.BCValidationModel(it.type, it.validated) },
            origin.information_bank_account,
            origin.activity,
            origin.contact,
            origin.identification_type,
            origin.business_cuit,
            origin.accountStatus,
            origin.telefonoMovil,
            origin.telefonoFijo,
            origin.isSocial
        )
    }
}