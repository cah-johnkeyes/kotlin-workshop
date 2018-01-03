package org.jetbrains.kotlinworkshop.student.introduction._3TaxiPark

// Find all passengers that were taken by this driver more than once
fun TaxiPark.findFrequentPassengers(driver: Driver): List<Passenger> = orders
        .filter { it.driver == driver }
        .flatMap { it.passengers }
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .keys.toList()