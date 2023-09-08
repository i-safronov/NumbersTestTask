package com.sfr.domain.repository

import com.sfr.domain.model.NumberInformationModel
import com.sfr.domain.model.NumberModel
import com.sfr.domain.model.UserNumberHistory

interface NumberRepository {

    fun getNumberInformation(numberModel: NumberModel, result: (NumberInformationModel) -> Unit, wasException: (Exception) -> Unit)
    fun getRandomNumberInformation(result: (NumberInformationModel) -> Unit, wasException: (Exception) -> Unit)
    fun getUserNumbersHistory(result: (List<UserNumberHistory>) -> Unit, wasException: (Exception) -> Unit)

    fun saveUserNumberHistory(userNumberHistory: UserNumberHistory, result: (List<UserNumberHistory>) -> Unit, wasException: (Exception) -> Unit)

}