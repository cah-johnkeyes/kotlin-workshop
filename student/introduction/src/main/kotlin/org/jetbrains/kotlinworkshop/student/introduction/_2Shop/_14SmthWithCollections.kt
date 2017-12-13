package org.jetbrains.kotlinworkshop.student.introduction._2Shop

// Rewrite JavaCode.doSomethingStrangeWithCollection function to Kotlin.
fun doSomethingStrangeWithCollection(collection: Collection<String>) = collection
        .groupBy { s -> s.length }
        .values.maxBy { group -> group.size }

