package com.convertisseurchiffreenlettre.logics

class EnglishConversion (val number : Double){

    fun converter() : String{
        return convertToEnglish(number)
    }
    //Convertion en Anglais
    // Conversion pour l'anglais avec Long
    private fun convertToEnglish(number: Double): String {
        return when {
            number in 0.0..10.0 -> convertSmallNumberToEnglish(number)
            number in 11.0..19.0 -> convertTeensToEnglish(number)
            number in 20.0..99.0 -> convertTensToEnglish(number)
            number in 100.0..999.0 -> convertHundredsToEnglish(number)
            number in 1000.0..999999.0 -> convertThousandsToEnglish(number)
            number in 1000000.0..999999999.0 -> convertMillionsToEnglish(number)
            number in 1000000000.0..999999999999.0 -> convertMilliardsToEnglish(number)
            number in 1000000000000.0..999999999999999.0 -> convertBillionsToEnglish(number)
            number in 1000000000000000.0..999999999999999999.0 -> convertTrillionsToEnglish(number)
            number in 1.0e18..Double.MAX_VALUE -> convertTrilliardsToEnglish(number)
            else -> "Number too large"
        }
    }

    // Conversion des petites unités
    private fun convertSmallNumberToEnglish(number: Double): String {
        return when (number.toInt()) {
            0 -> "zero"
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            6 -> "six"
            7 -> "seven"
            8 -> "eight"
            9 -> "nine"
            10 -> "ten"
            else -> "Unsupported number"
        }
    }

    // Conversion des nombres entre 11 et 19
    private fun convertTeensToEnglish(number: Double): String {
        return when (number.toInt()) {
            11 -> "eleven"
            12 -> "twelve"
            13 -> "thirteen"
            14 -> "fourteen"
            15 -> "fifteen"
            16 -> "sixteen"
            17 -> "seventeen"
            18 -> "eighteen"
            19 -> "nineteen"
            else -> "Unsupported number"
        }
    }

    // Conversion des dizaines
    private fun convertTensToEnglish(number: Double): String {
        val tens = (number / 10).toInt()
        val units = (number % 10).toInt()

        return when (tens) {
            2 -> if (units == 0) "twenty" else "twenty-${convertSmallNumberToEnglish(units.toDouble())}"
            3 -> if (units == 0) "thirty" else "thirty-${convertSmallNumberToEnglish(units.toDouble())}"
            4 -> if (units == 0) "forty" else "forty-${convertSmallNumberToEnglish(units.toDouble())}"
            5 -> if (units == 0) "fifty" else "fifty-${convertSmallNumberToEnglish(units.toDouble())}"
            6 -> if (units == 0) "sixty" else "sixty-${convertSmallNumberToEnglish(units.toDouble())}"
            7 -> if (units == 0) "seventy" else "seventy-${convertSmallNumberToEnglish(units.toDouble())}"
            8 -> if (units == 0) "eighty" else "eighty-${convertSmallNumberToEnglish(units.toDouble())}"
            9 -> if (units == 0) "ninety" else "ninety-${convertSmallNumberToEnglish(units.toDouble())}"
            else -> "Unsupported number"
        }
    }

    // Conversion des centaines
    private fun convertHundredsToEnglish(number: Double): String {
        val hundreds = (number / 100).toInt()
        val remainder = number % 100
        val hundredsPart = "${convertSmallNumberToEnglish(hundreds.toDouble())} hundred"
        return if (remainder == 0.0) hundredsPart else "$hundredsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des milliers
    private fun convertThousandsToEnglish(number: Double): String {
        val thousands = (number / 1000).toInt()
        val remainder = number % 1000
        val thousandsPart = "${convertToEnglish(thousands.toDouble())} thousand"
        return if (remainder == 0.0) thousandsPart else "$thousandsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des millions
    private fun convertMillionsToEnglish(number: Double): String {
        val millions = (number / 1_000_000).toInt()
        val remainder = number % 1_000_000
        val millionsPart = if (millions == 1) "one million" else "${convertToEnglish(millions.toDouble())} million"
        return if (remainder == 0.0) millionsPart else "$millionsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des milliards
    private fun convertMilliardsToEnglish(number: Double): String {
        val billions = (number / 1_000_000_000).toInt()
        val remainder = number % 1_000_000_000
        val billionsPart = if (billions == 1) "one billion" else "${convertToEnglish(billions.toDouble())} billion"
        return if (remainder == 0.0) billionsPart else "$billionsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des billions
    private fun convertBillionsToEnglish(number: Double): String {
        val trillions = (number / 1_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000
        val trillionsPart = if (trillions == 1) "one trillion" else "${convertToEnglish(trillions.toDouble())} trillion"
        return if (remainder == 0.0) trillionsPart else "$trillionsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des trillions
    private fun convertTrillionsToEnglish(number: Double): String {
        val trillions = (number / 1_000_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000_000
        val trillionsPart = if (trillions == 1) "one trilliard" else "${convertToEnglish(trillions.toDouble())} trilliard"
        return if (remainder == 0.0) trillionsPart else "$trillionsPart ${convertToEnglish(remainder)}"
    }

    // Conversion des trilliards
    private fun convertTrilliardsToEnglish(number: Double): String {
        val trilliards = (number / 1_000_000_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000_000_000
        val trilliardsPart = if (trilliards == 1) "one quadrillion" else "${convertToEnglish(trilliards.toDouble())} quadrillion"
        return if (remainder == 0.0) trilliardsPart else "$trilliardsPart ${convertToEnglish(remainder)}"
    }


}