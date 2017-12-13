package org.jetbrains.kotlinworkshop.student.introduction._2Shop

fun main(args: Array<String>) {
    val list = listOf(-1, 3, 0, -5, 7)

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)
    println(hasZero)  // true

    val allZeros: Boolean = list.all(isZero)
    println(allZeros)  // false

    val numberOfZeros: Int = list.count(isZero)
    println(numberOfZeros)  // 1

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
    println(firstPositiveNumber) // 3
}

// Return true if the customer is from the given city
fun Customer.isFrom(city: City) = this.city == city

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City) = this.customers.all { it.isFrom(city) }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City) = this.customers.any { it.isFrom(city) }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City) = this.customers.count { it.isFrom(city) }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City) = this.customers.find { it.isFrom(city) }
