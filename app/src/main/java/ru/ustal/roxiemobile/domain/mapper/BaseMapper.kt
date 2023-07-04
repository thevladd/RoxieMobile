package ru.ustal.roxiemobile.domain.mapper

abstract class BaseMapper<Input, Output> {
    abstract fun map(input: Input): Output

    fun mapList(inputList: List<Input>): List<Output> {
        return inputList.map { map(it) }
    }
}