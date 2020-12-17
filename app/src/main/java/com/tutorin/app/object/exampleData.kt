package com.tutorin.app.`object`

import com.tutorin.app.R


object exampleData {
    private val subjectName = arrayOf("Politic Psychology",
        "Chemistry",
        "Biology",
        "Physics",
        "Quantum Physics",
        "Object-Oriented Programming",
        "Organic Chemistry",
        "Electrical Physics",
        "Thermodynamics",
        "Algorithm")

    private val expOrderID = arrayOf(
        12312333,
        12313173,
        12313123,
        12312333,
        12313173,
        12313123,
        12312333,
        12313173,
        12313123,
        12312333)

    private val expOrderDate = arrayOf(
        "12 Sept 2019",
        "23 Oct 2020",
        "11 Sept 2001",
        "15 Jan 2093",
        "23 Nov 2031",
        "10 Jun 2013",
        "23 Oct 2020",
        "11 Sept 2001",
        "15 Jan 2093",
        "23 Nov 2031"
    )
    private val expTutorName = arrayOf(
        "Roy Keane",
        "Harry Keane",
        "Frank Underwood",
        "Jon Snow",
        "Harry Styles",
        "Elon Musk",
        "Maudy Ayunda",
        "Justinus Lhaksana",
        "Jesse Lingard",
        "Bernie Sanders")

    private val expTariff = arrayOf(
        50000,
        120000,
        123555,
        50000,
        120000,
        123555,
        50000,
        120000,
        123555,
        501235)

    private val expReview = arrayOf(
        "Asik banget ngajarnya anjing"
    )

/*
    val listData: ArrayList<dataHistory>
        get() {
            val list = arrayListOf<dataHistory>()
            for (position in subjectName.indices) {
                val dataHistory = dataHistory()
                dataHistory.orderSubject = subjectName[position]
                dataHistory.orderID = expOrderID[position].toString()
                dataHistory.orderDate = expOrderDate[position]
                dataHistory.tutorName = expTutorName[position]
                dataHistory.tariff = expTariff[position]
                dataHistory.tutorReview = expReview[0]
                list.add(dataHistory)
            }
            return list
        }
        */
}