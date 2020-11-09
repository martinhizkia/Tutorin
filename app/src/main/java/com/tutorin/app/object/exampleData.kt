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

    private val orderDesc = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vel lacus in felis pharetra malesuada vitae sed diam. Nulla vestibulum."
    )
    private val subjImg = intArrayOf(
        R.drawable.ic_business,
        R.drawable.ic_engineering,
        R.drawable.ic_humanities,
        R.drawable.ic_laws,
        R.drawable.ic_medical,
        R.drawable.ic_business,
        R.drawable.ic_engineering,
        R.drawable.ic_humanities,
        R.drawable.ic_laws,
        R.drawable.ic_medical
    )


    val listData: ArrayList<dataHistory>
        get() {
            val list = arrayListOf<dataHistory>()
            for (position in subjectName.indices) {
                val dataHistory = dataHistory()
                dataHistory.subjectName = subjectName[position]
                dataHistory.orderDetail = orderDesc[0]
                dataHistory.subjectPhoto = subjImg[position]
                list.add(dataHistory)
            }
            return list
        }
}