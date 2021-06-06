package com.prisma.di

import com.prisma.data.local.cache.model.BCCacheModel
import com.prisma.data.local.model.BCBackendModel
import com.prisma.domain.model.BCUIModel

class AccountUIModelMapperImpl : ItemUIModelMapper<BCBackendModel.BCAccountModel, BCCacheModel.BCAccountModel, BCUIModel.AccountModel>{

    override fun fromBackendModelToUIModel(origin: BCBackendModel.BCAccountModel): BCUIModel.AccountModel {
        return BCUIModel.AccountModel(origin.id ?: "",
            origin.type ?: "",
            origin.first_name ?: "",
            origin.last_name ?: "",
            origin.identification ?: "",
            origin.gender ?: "",
            origin.birth_date ?: "",
            origin.nationality ?: "",
            origin.guest_mode ?: false,
            BCUIModel.EmailUserModel(origin.emailUser.email, origin.emailUser.providerId
                ?: "") ?: BCUIModel.EmailUserModel(),
            origin.addresses!!.map {
                BCUIModel.AddressModel(it.id ?: 0, it.type ?: 0, it.street ?: "",
                    it.number ?: "", it.floor ?: "", it.apartment ?: "", it.city ?: "",
                    it.state ?: "", it.typeCode ?: "", it.zipCode ?: "")
            },
            origin.validations!!.map { BCUIModel.ValidationModel(it.type, it.validated) },
            origin.information_bank_account ?: "",
            origin.activity ?: "",
            origin.contact ?: "",
            origin.identification_type ?: "",
            origin.business_cuit ?: "",
            origin.accountStatus ?: "",
            origin.telephone ?: "",
            origin.telefono_fijo ?: ""
        )
    }

    override fun fromCacheModelToUIModel(origin: BCCacheModel.BCAccountModel): BCUIModel.AccountModel {
        return BCUIModel.AccountModel(origin.id,
            origin.type,
            origin.first_name,
            origin.last_name,
            origin.identification,
            origin.gender,
            origin.birth_date,
            origin.nationality,
            origin.guest_mode,
            BCUIModel.EmailUserModel(origin.emaiUser.email, origin.emaiUser.providerId),
            origin.addresses.map {
                BCUIModel.AddressModel(it.id ?: 0, it.type ?: 0, it.street ?: "",
                    it.number ?: "", it.floor ?: "", it.apartment ?: "", it.city ?: "",
                    it.state ?: "", it.typeCode ?: "", it.zipCode ?: "")
            },
            origin.validations.map { BCUIModel.ValidationModel(it.type, it.validated) },
            origin.information_bank_account,
            origin.activity,
            origin.contact,
            origin.identification_type,
            origin.business_cuit,
            origin.accountStatus,
            origin.telefonoMovil,
            origin.telefonoFijo
        )
    }
}