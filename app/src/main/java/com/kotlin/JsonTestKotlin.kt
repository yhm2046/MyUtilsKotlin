package com.kotlin

import com.google.gson.Gson
import org.json.JSONObject

/**
 * 单独的kt文件运行必须要新建一个kotlin项目再新建kt文件才能运行，在java项目中无法运行
 */
class JsonTestKotlin {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello!")
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

            /********************************/
            val jsonString = """{"name":"John","age":30,"city":"New York"}"""
            val gson = Gson()
            val person = gson.fromJson(jsonString, Person::class.java)

            println("Name: ${person.name}")
            println("Age: ${person.age}")
            println("City: ${person.city}")
        }
    }

    class Person(val name: String, val age: Int, val city: String)
}


