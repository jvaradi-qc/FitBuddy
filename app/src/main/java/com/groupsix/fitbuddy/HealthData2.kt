package com.groupsix.fitbuddy.fragments

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser
import java.util.*

// Age : String
// Male: Boolean
// Female: Boolean
// HeightFeet: Number
// HeightInches: Number
// Weight: Number
// HeartRate: Number
// user : User
// createdAt : Date
@ParseClassName("HealthData2")
class HealthData2 : ParseObject() {

    fun getMale(): Boolean? {
        return getBoolean(KEY_MALE)
    }

    fun setMale(male: Boolean) {
        put(KEY_MALE, male)
    }

    fun getFemale(): Boolean? {
        return getBoolean(KEY_FEMALE)
    }

    fun setFemale(female: Boolean) {
        put(KEY_FEMALE, female)
    }

    fun getHeightFeet(): Number? {
        return getNumber(KEY_HEIGHT_FEET)
    }

    fun setHeightFeet(heightFeet: Number) {
        put(KEY_HEIGHT_FEET, heightFeet)
    }

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    fun setUser(parseUser: ParseUser) {
        put(KEY_USER, parseUser)
    }

    fun getTime(): Date? {
        return getCreatedAt()
    }

    companion object {
        const val KEY_MALE = "Male"
        const val KEY_FEMALE = "Female"
        const val KEY_HEIGHT_FEET = "HeightFeet"
        const val KEY_USER = "user"

    }
}