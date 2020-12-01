package org.example.entities

import org.example.enums.Status._

case class Task(taskName: String, status: Status)
