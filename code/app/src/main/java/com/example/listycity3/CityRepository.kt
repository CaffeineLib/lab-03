package com.example.listycity3

import androidx.compose.runtime.mutableStateListOf

class CityRepository {
    private val _cities = mutableStateListOf(
        City("Edmonton", "AB"),
        City("Vancouver", "BC"),
        City("Toronto", "ON")
    )

    val cities: List<City>
        get() = _cities

    fun addCity(city:City){
        // past issues with sort. @Compostable treats as bag, learned to do insertion instead.
        val n = _cities.binarySearchBy(city.name){it.name}
        _cities.add(if (n<0) -n -1 else n, city) //go fig, sometimes binary search returns integers.

        /* For all this talk about Liskov Substitution Principals this badly breaks em.
            On the bright side there is a career for us to fulfil. */
    }   //---------------------------------------------------------------------------

}