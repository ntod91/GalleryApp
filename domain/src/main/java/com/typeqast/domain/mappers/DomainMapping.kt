package com.typeqast.domain.mappers

interface DomainMapping<Local, Remote> {
    fun mapToDomain(remote: Remote): Local
}