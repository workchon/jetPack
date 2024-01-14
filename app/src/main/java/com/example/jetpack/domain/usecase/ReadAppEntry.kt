package com.example.jetpack.domain.usecase

import com.example.jetpack.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() : Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}