package org.jetbrains.kotlinworkshop.student.introduction._3TaxiPark

// Find the most frequent trip interval duration (or several if there are many)
// among 0-9 minutes, 10-19 minutes, 20-29 minutes etc.
// If there's no duration info, return empty list.
fun TaxiPark.findTheMostFrequentTripDurations(): List<IntRange> {
    val countOfRanges = orders.map {
        val floor = (it.duration / 10) * 10
        val ceiling = floor + 9
        (floor..ceiling)
    }.groupingBy { it }.eachCount()

    val maxNumRides = countOfRanges.values.max()
    val maxRanges = countOfRanges.filter { it.value == maxNumRides }

    return maxRanges.keys.toList()
}