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
@ParseClassName("HealthData")
class HealthData : ParseObject() {

    fun getAge(): String? {
        return getString(KEY_AGE)
    }

    fun setAge(age: String) {
        put(KEY_AGE, age)
    }

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

    fun getHeightInches(): Number? {
        return getNumber(KEY_HEIGHT_INCHES)
    }

    fun setHeightInches(heightInches: Number) {
        put(KEY_HEIGHT_INCHES, heightInches)
    }

    fun getWeight(): Number? {
        return getNumber(KEY_WEIGHT)
    }

    fun setWeight(weight: Number) {
        put(KEY_WEIGHT, weight)
    }

    fun getHeartRate(): Number? {
        return getNumber(KEY_HEARTRATE)
    }

    fun setHeartRate(heartRate: Number) {
        put(KEY_HEARTRATE, heartRate)
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
        const val KEY_AGE = "Age"
        const val KEY_WEIGHT = "Weight"
        const val KEY_HEIGHT_FEET = "HeightFeet"
        const val KEY_HEIGHT_INCHES = "HeightInches"
        const val KEY_HEARTRATE = "HeartRate"
        const val KEY_MALE = "Male"
        const val KEY_FEMALE = "Female"
        const val KEY_USER = "user"

    }
}