package org.jetbrains.kotlinworkshop.student.introduction._3TaxiPark

// Find passengers that used discounts for majority of the trips
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val standardRides = orders
            .filter { it.discount == null }
            .flatMap { it.passengers }
            .groupingBy { it }.eachCount()

    val discountRides = orders
            .filterNot { it.discount == null }
            .flatMap { it.passengers }
            .groupingBy { it }.eachCount()

    return discountRides.filter { standardRides[it.key] ?: 0 < it.value }.keys
}