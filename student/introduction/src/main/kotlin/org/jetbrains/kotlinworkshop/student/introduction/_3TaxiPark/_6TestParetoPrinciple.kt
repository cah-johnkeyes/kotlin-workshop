package org.jetbrains.kotlinworkshop.student.introduction._3TaxiPark

// Check whether 20% of the drivers make 80% of the profit
const val DRIVER_PERCENT: Double = 0.2
const val PROFIT_PERCENT: Double = 0.8

fun TaxiPark.profitByDriver(driver: Driver) = orders
        .filter { it.driver == driver }
        .sumByDouble { it.cost }

fun TaxiPark.checkParetoPrinciple(): Boolean {
    val expectedDriverTotal = Math.floor(allDrivers.count() * DRIVER_PERCENT).toInt()
    val expectedProfitTotal = orders.sumByDouble { it.cost } * PROFIT_PERCENT
    val profitsByDriver = allDrivers.map { it to profitByDriver(it) }
            .sortedByDescending { it.second }
    val actualProfit = profitsByDriver.take(expectedDriverTotal).sumByDouble { it.second }

    return actualProfit > expectedProfitTotal
}