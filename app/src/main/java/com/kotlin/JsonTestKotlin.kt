package com.kotlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import org.json.JSONObject

/**
 * 单独的kt文件运行必须要新建一个kotlin项目再新建kt文件才能运行，在java项目中无法运行
 */
class JsonTestKotlin {

    companion object {

        fun gsonTest2(){
            /******************常规测试**************/
            val jsonString = """{"name":"John","age":30,"city":"New York"}"""
            val gson = Gson()
            val person = gson.fromJson(jsonString, Person::class.java)

            println("Name: ${person.name}")
            println("Age: ${person.age}")
            println("City: ${person.city}")
        }

        fun jsonTest1(){
            //            解析string类型的json字符串
            /**
             * 以下字节运行会抛出异常：
             * Exception in thread "main" java.lang.RuntimeException: Stub!
            at org.json.JSONObject.<init>(JSONObject.java:115)
            at com.kotlin.JsonTestKotlin$Companion.main(JsonTestKotlin.kt:16)
            at com.kotlin.JsonTestKotlin.main(JsonTestKotlin.kt)
             */
//            val jsonString = """{"name":"John","age":30,"city":"New York"}"""
//            val jsonObject = JSONObject(jsonString)
//
//            val name = jsonObject.getString("name")
//            val age = jsonObject.getInt("age")
//            val city = jsonObject.getString("city")
//
//            println("Name: $name")
//            println("Age: $age")
//            println("City: $city")
        }

        @JvmStatic
        fun main(args: Array<String>) { //运行单个kt文件使用快捷键：ctrl + shift + f10
            /*****************测试kaili***************/
            val function = RS485DeviceFunction( //实例化RS485DeviceFunction 类
                id = 1,
                knxAddress = mutableListOf("1/1/1"),
                dataType = 1,
                dataLength = 2,
                rs485port = 1,
                rs485Address = 2,
                rs485DeviceIndex = 3,
                type = "Test",
//                operation = 0,    //不设置默认值为 -1
                value = "Hello",
                exp = "World",
                protocolType = "Modbus"
            )
            val objectMapper = ObjectMapper()
            val jsonString2 = objectMapper.writeValueAsString(function)

            println("jackson拼接json格式的字符串:$jsonString2")
            /**
             * 输出结果:
             * jsonString:{"id":1,"knxAddress":["1/1/1"],"dataType":1,"dataLength":2,"rs485port":1,"rs485Address":2,
             * "rs485DeviceIndex":3,"type":"Test","operation":-1,"value":"Hello","exp":"World","protocolType":"Modbus"}
             */
//           jackson解析json字符串
            val objectMapper2 = ObjectMapper()
            val function2 = objectMapper2.readValue(jsonString2, RS485DeviceFunction::class.java)

            println("jackson解析json格式字符串:$function2")
            println("id:" + function2.id)
            /**
             * 输出结果:
             * jackson解析结果:RS485DeviceFunction(id=1, knxAddress=[1/1/1], dataType=1, dataLength=2, rs485port=1, rs485Address=2,
             * rs485DeviceIndex=3, type=Test, operation=-1, value=Hello, exp=World, protocolType=Modbus)
            id:1
             */
//            gson拼接解析方法-----------------------------------------------------------------------------------------
            val gson = Gson()

            val jsonString = gson.toJson(function)
            println("gson拼接json格式的字符串:$jsonString")

            val function3 = gson.fromJson(jsonString, RS485DeviceFunction::class.java)
            println("gson解析json格式的字符串:$function3")
            println("type:" + function3.type)
        }
    }

    fun setDeviceFunction(jsonStr: String):List<String>{
        val mapper = ObjectMapper()
        val deviceData2 = mapper.readValue(jsonStr, RS485DeviceFunction::class.java)
        println("id: ${deviceData2.id}")
        return emptyList()
    }


    class Person(val name: String, val age: Int, val city: String)
}


