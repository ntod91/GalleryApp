package com.typeqast.data.dto

import com.typeqast.data.remote.models.GalleryEntityApi
import com.typeqast.domain.mappers.DomainMapping
import com.typeqast.domain.models.GalleryEntity
import java.util.function.Consumer

class GalleryDTO : DomainMapping<List<GalleryEntity>, List<GalleryEntityApi>> {
    override fun mapToDomain(remote: List<GalleryEntityApi>): List<GalleryEntity> {
        val domainImages = ArrayList<GalleryEntity>()
        remote.forEach(Consumer { domainImages.add(GalleryEntity(it.id, it.name, it.url)) })
        return domainImages.toList()
    }

}