package com.convertisseurchiffreenlettre.logics

class FrenchConversion (private val number: Double) {

    fun conversion () : String{
        return convertToFrench(number)
    }

    private fun convertToFrench(number: Double): String {
        return when {
            number in 0.0..10.0 -> convertSmallNumberToFrench(number)
            number in 11.0..19.0 -> convertTeensToFrench(number)
            number in 20.0..99.0 -> convertTensToFrench(number)
            number in 100.0..999.0 -> convertHundredsToFrench(number)
            number in 1000.0..999999.0 -> convertThousandsToFrench(number)
            number in 1000000.0..999999999.0 -> convertMillionsToFrench(number)
            number in 1000000000.0..999999999999.0 -> convertMilliardsToFrench(number)
            number in 1000000000000.0..999999999999999.0 -> convertBillionsToFrench(number)
            number in 1000000000000000.0..999999999999999999.0 -> convertTrillionsToFrench(number)
            number in 1000000000000000000.0..Double.MAX_VALUE -> convertTrilliardsToFrench(number)
            else -> "Nombre trop grand"
        }
    }

    // Convertion pour les petits nombres
    private fun convertSmallNumberToFrench(number: Double): String {
        return when (number.toInt()) {
            0 -> "zéro"
            1 -> "un"
            2 -> "deux"
            3 -> "trois"
            4 -> "quatre"
            5 -> "cinq"
            6 -> "six"
            7 -> "sept"
            8 -> "huit"
            9 -> "neuf"
            10 -> "dix"
            else -> "Nombre non pris en charge"
        }
    }

    // Convertion pour les nombres de 11 à 19
    private fun convertTeensToFrench(number: Double): String {
        return when (number.toInt()) {
            11 -> "onze"
            12 -> "douze"
            13 -> "treize"
            14 -> "quatorze"
            15 -> "quinze"
            16 -> "seize"
            17 -> "dix-sept"
            18 -> "dix-huit"
            19 -> "dix-neuf"
            else -> "Nombre non pris en charge"
        }
    }

    // Convertion pour les dizaines
    private fun convertTensToFrench(number: Double): String {
        val tens = (number / 10).toInt()
        val units = (number % 10).toInt()

        return when (tens) {
            2 -> if (units == 0) "vingt" else "vingt-${convertSmallNumberToFrench(units.toDouble())}"
            3 -> if (units == 0) "trente" else "trente-${convertSmallNumberToFrench(units.toDouble())}"
            4 -> if (units == 0) "quarante" else "quarante-${convertSmallNumberToFrench(units.toDouble())}"
            5 -> if (units == 0) "cinquante" else "cinquante-${convertSmallNumberToFrench(units.toDouble())}"
            6 -> if (units == 0) "soixante" else "soixante-${convertSmallNumberToFrench(units.toDouble())}"
            7 -> if (units == 0) "soixante-dix" else if (units == 1) "soixante-onze" else "soixante-${convertTeensToFrench((10 + units).toDouble())}"
            8 -> if (units == 0) "quatre-vingts" else "quatre-vingt-${convertSmallNumberToFrench(units.toDouble())}"
            9 -> if (units == 0) "quatre-vingt-dix" else if (units == 1) "quatre-vingt-onze" else "quatre-vingt-${convertTeensToFrench((10 + units).toDouble())}"
            else -> "Nombre non pris en charge"
        }
    }

    // Convertion pour les centaines
    private fun convertHundredsToFrench(number: Double): String {
        val hundreds = (number / 100).toInt()
        val remainder = number % 100
        return when (hundreds) {
            1 -> if (remainder == 0.0) "cent" else "cent ${convertToFrench(remainder)}"
            else -> "${convertSmallNumberToFrench(hundreds.toDouble())} cent${if (remainder == 0.0) "" else " ${convertToFrench(remainder)}"}"
        }
    }

    // Conversion pour les milliers
    private fun convertThousandsToFrench(number: Double): String {
        val thousands = (number / 1000).toInt()
        val remainder = number % 1000
        val thousandsPart = if (thousands == 1) "mille" else "${convertToFrench(thousands.toDouble())} mille"
        return if (remainder == 0.0) thousandsPart else "$thousandsPart ${convertToFrench(remainder)}"
    }

    private fun convertMillionsToFrench(number: Double): String {
        val millions = (number / 1000000).toInt()
        val remainder = number % 1000000
        val millionsPart = if (millions == 1) "un million" else "${convertToFrench(millions.toDouble())} millions"
        return if (remainder == 0.0) millionsPart else "$millionsPart ${convertToFrench(remainder)}"
    }

    private fun convertMilliardsToFrench(number: Double): String {
        val milliards = (number / 1000000000).toInt()
        val remainder = number % 1000000000
        val milliardsPart = if (milliards == 1) "un milliard" else "${convertToFrench(milliards.toDouble())} milliards"
        return if (remainder == 0.0) milliardsPart else "$milliardsPart ${convertToFrench(remainder)}"
    }

    private fun convertBillionsToFrench(number: Double): String {
        val billions = (number / 1000000000000).toInt()
        val remainder = number % 1000000000000
        val billionsPart = if (billions == 1) "un billion" else "${convertToFrench(billions.toDouble())} billions"
        return if (remainder == 0.0) billionsPart else "$billionsPart ${convertToFrench(remainder)}"
    }

    private fun convertTrillionsToFrench(number: Double): String {
        val trillions = (number / 1000000000000000).toInt()
        val remainder = number % 1000000000000000
        val trillionsPart = if (trillions == 1) "un trillion" else "${convertToFrench(trillions.toDouble())} trillions"
        return if (remainder == 0.0) trillionsPart else "$trillionsPart ${convertToFrench(remainder)}"
    }

    private fun convertTrilliardsToFrench(number: Double): String {
        val trilliards = (number / 1000000000000000000).toInt()
        val remainder = number % 1000000000000000000
        val trilliardsPart = if (trilliards == 1) "un trilliard" else "${convertToFrench(trilliards.toDouble())} trilliards"
        return if (remainder == 0.0) trilliardsPart else "$trilliardsPart ${convertToFrench(remainder)}"
    }

}