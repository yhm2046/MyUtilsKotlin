package com.kotlin

/**
 *内部的Function类,同gateway中的一样
 */
data class RS485DeviceFunction(
    var id: Int,
    var knxAddress: MutableList<String> = mutableListOf(),
    var dataType: Int,
    var dataLength: Int,
    var rs485port: Int,
    var rs485Address: Int,
    var rs485DeviceIndex: Int,
    var type: String,
    var operation: Int = -1,    //默认值-1
    var value: String?, //可选参数
    var exp: String?,   //可选参数
    var protocolType: String? //可选参数
){  //无参构造函数
    constructor() : this(
        id = 0,
        dataType = 0,
        dataLength = 0,
        rs485port = 0,
        rs485Address = 0,
        rs485DeviceIndex = 0,
        type = "",
        value = null,
        exp = null,
        protocolType = ""
    )
}