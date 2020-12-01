package org.example.enums

object Status {

    sealed trait Status

    case object Created extends Status

    case object InProgress extends Status

    case object Done extends Status

}
