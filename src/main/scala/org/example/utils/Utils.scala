package org.example.utils

import java.lang.reflect.Type

import com.google.gson.{GsonBuilder, JsonElement, JsonObject, JsonSerializationContext, JsonSerializer}

object Utils {
    def mapToJson[A](src: A, map: Map[String, () => String]): String = {
        val gsonBuilder = new GsonBuilder
        val serializer = new JsonSerializer[A] {
            override def serialize(src: A,
                                   typeOfSrc: Type,
                                   jsonSerializationContext: JsonSerializationContext): JsonElement = {
                val json = new JsonObject

                for ((property, valueFunc) <- map) {
                    json.addProperty(property, valueFunc())
                }
                json
            }
        }
        gsonBuilder.registerTypeAdapter(classOf[A], serializer)

        val gson = gsonBuilder.create()
        gson.toJson(src)
    }
}
