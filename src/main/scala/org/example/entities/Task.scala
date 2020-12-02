package org.example.entities

import org.example.enums.Status._
import org.example.utils.Utils

case class Task(taskName: String, status: Status) {
    def mapToJson: String = {
        val mappedProperties = Map(
            "name" -> (() => taskName),
            "status" -> (() => status.toString)
        )
        Utils.mapToJson(this, mappedProperties)
    }
}
