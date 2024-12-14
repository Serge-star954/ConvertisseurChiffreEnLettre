package com.convertisseurchiffreenlettre.logics

class SpanishConversion(val number : Double) {

    fun conversion(): String{
        return convertToSpanish(number)
    }


    private fun convertToSpanish(number: Double): String {
        return when {
            number in 0.0..10.0 -> convertSmallNumberToSpanish(number)
            number in 11.0..19.0 -> convertTeensToSpanish(number)
            number in 20.0..99.0 -> convertTensToSpanish(number)
            number in 100.0..999.0 -> convertHundredsToSpanish(number)
            number in 1000.0..999999.0 -> convertThousandsToSpanish(number)
            number in 1000000.0..999999999.0 -> convertMillionsToSpanish(number)
            number in 1000000000.0..999999999999.0 -> convertMilliardsToSpanish(number)
            number in 1000000000000.0..999999999999999.0 -> convertBillionsToSpanish(number)
            number in 1000000000000000.0..999999999999999999.0 -> convertTrillionsToSpanish(number)
            number in 1000000000000000000.0..Double.MAX_VALUE -> convertTrilliardsToSpanish(number)
            else -> "Número demasiado grande"
        }
    }

    // Conversion des unités
    private fun convertSmallNumberToSpanish(number: Double): String {
        return when (number) {
            0.0 -> "cero"
            1.0 -> "uno"
            2.0 -> "dos"
            3.0 -> "tres"
            4.0 -> "cuatro"
            5.0 -> "cinco"
            6.0 -> "seis"
            7.0 -> "siete"
            8.0 -> "ocho"
            9.0 -> "nueve"
            10.0 -> "diez"
            else -> "Número no soportado"
        }
    }

    // Conversion des nombres entre 11 et 19
    private fun convertTeensToSpanish(number: Double): String {
        return when (number) {
            11.0 -> "once"
            12.0 -> "doce"
            13.0 -> "trece"
            14.0 -> "catorce"
            15.0 -> "quince"
            16.0 -> "dieciséis"
            17.0 -> "diecisiete"
            18.0 -> "dieciocho"
            19.0 -> "diecinueve"
            else -> "Número no soportado"
        }
    }

    // Conversion des dizaines
    private fun convertTensToSpanish(number: Double): String {
        val tens = number / 10
        val units = number % 10

        return when (tens) {
            2.0 -> if (units == 0.0) "veinte" else "veinti${convertSmallNumberToSpanish(units)}"
            3.0 -> if (units == 0.0) "treinta" else "treinta y ${convertSmallNumberToSpanish(units)}"
            4.0 -> if (units == 0.0) "cuarenta" else "cuarenta y ${convertSmallNumberToSpanish(units)}"
            5.0 -> if (units == 0.0) "cincuenta" else "cincuenta y ${convertSmallNumberToSpanish(units)}"
            6.0 -> if (units == 0.0) "sesenta" else "sesenta y ${convertSmallNumberToSpanish(units)}"
            7.0 -> if (units == 0.0) "setenta" else "setenta y ${convertSmallNumberToSpanish(units)}"
            8.0 -> if (units == 0.0) "ochenta" else "ochenta y ${convertSmallNumberToSpanish(units)}"
            9.0 -> if (units == 0.0) "noventa" else "noventa y ${convertSmallNumberToSpanish(units)}"
            else -> "Número no soportado"
        }
    }

    // Conversion des centaines
    private fun convertHundredsToSpanish(number: Double): String {
        val hundreds = number / 100
        val remainder = number % 100
        val hundredsPart = when (hundreds) {
            1.0 -> if (remainder == 0.0) "cien" else "ciento"
            2.0 -> "doscientos"
            3.0 -> "trescientos"
            4.0 -> "cuatrocientos"
            5.0 -> "quinientos"
            6.0 -> "seiscientos"
            7.0 -> "setecientos"
            8.0 -> "ochocientos"
            9.0 -> "novecientos"
            else -> ""
        }
        return if (remainder == 0.0) hundredsPart else "$hundredsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des milliers
    private fun convertThousandsToSpanish(number: Double): String {
        val thousands = number / 1000
        val remainder = number % 1000
        val thousandsPart = if (thousands == 1.0) "mil" else "${convertToSpanish(thousands)} mil"
        return if (remainder == 0.0) thousandsPart else "$thousandsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des millions
    private fun convertMillionsToSpanish(number: Double): String {
        val millions = number / 1000000
        val remainder = number % 1000000
        val millionsPart = if (millions == 1.0) "un millón" else "${convertToSpanish(millions)} millones"
        return if (remainder == 0.0) millionsPart else "$millionsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des milliards
    private fun convertMilliardsToSpanish(number: Double): String {
        val billions = number / 1000000000
        val remainder = number % 1000000000
        val billionsPart = if (billions == 1.0) "un mil millones" else "${convertToSpanish(billions)} mil millones"
        return if (remainder == 0.0) billionsPart else "$billionsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des billions (trillions)
    private fun convertBillionsToSpanish(number: Double): String {
        val billions = number / 1000000000000L
        val remainder = number % 1000000000000L
        val billionsPart = if (billions == 1.0) "mil billón" else "${convertToSpanish(billions)} mil billones"
        return if (remainder == 0.0) billionsPart else "$billionsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des trillions
    private fun convertTrillionsToSpanish(number: Double): String {
        val trillions = number / 1000000000000000L
        val remainder = number % 1000000000000000L
        val trillionsPart = if (trillions == 1.0) "un trillón" else "${convertToSpanish(trillions)} trillones"
        return if (remainder == 0.0) trillionsPart else "$trillionsPart ${convertToSpanish(remainder)}"
    }

    // Conversion des trilliards
    private fun convertTrilliardsToSpanish(number: Double): String {
        val trilliards = number / 1000000000000000000L
        val remainder = number % 1000000000000000000L
        val trilliardsPart = if (trilliards == 1.0) "un trilliardo" else "${convertToSpanish(trilliards)} trilliardos"
        return if (remainder == 0.0) trilliardsPart else "$trilliardsPart ${convertToSpanish(remainder)}"
    }

}