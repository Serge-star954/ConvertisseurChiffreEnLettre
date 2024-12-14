package com.convertisseurchiffreenlettre.logics

class GermanConversion(val number : Double) {

    fun conversion() : String {
        return convertToGerman(number)
    }

    private fun convertToGerman(number: Double): String {
        return when {
            number in 0.0..10.0 -> convertSmallNumberToGerman(number)
            number in 11.0..19.0 -> convertTeensToGerman(number)
            number in 20.0..99.0 -> convertTensToGerman(number)
            number in 100.0..999.0 -> convertHundredsToGerman(number)
            number in 1000.0..999999.0 -> convertThousandsToGerman(number)
            number in 1_000_000.0..999_999_999.0 -> convertMillionsToGerman(number)
            number in 1_000_000_000.0..999_999_999_999.0 -> convertMilliardsToGerman(number)
            number in 1_000_000_000_000.0..999_999_999_999_999.0 -> convertBillionsToGerman(number)
            number in 1_000_000_000_000_000.0..999_999_999_999_999_999.0 -> convertTrillionToGerman(number)
            number in 1_000_000_000_000_000_000.0..Double.MAX_VALUE -> convertTrilliardToGerman(number)
            else -> "Zahl zu groß"
        }
    }

    // Conversion des petits nombres
    private fun convertSmallNumberToGerman(number: Double): String {
        return when (number) {
            0.0 -> "null"
            1.0 -> "eins"
            2.0 -> "zwei"
            3.0 -> "drei"
            4.0 -> "vier"
            5.0 -> "fünf"
            6.0 -> "sechs"
            7.0 -> "sieben"
            8.0 -> "acht"
            9.0 -> "neun"
            10.0 -> "zehn"
            else -> "Nicht unterstützte Zahl"
        }
    }

    // Conversion des nombres entre 11 et 19
    private fun convertTeensToGerman(number: Double): String {
        return when (number) {
            11.0 -> "elf"
            12.0 -> "zwölf"
            13.0 -> "dreizehn"
            14.0 -> "vierzehn"
            15.0 -> "fünfzehn"
            16.0 -> "sechzehn"
            17.0 -> "siebzehn"
            18.0 -> "achtzehn"
            19.0 -> "neunzehn"
            else -> "Nicht unterstützte Zahl"
        }
    }

    // Conversion des dizaines
    private fun convertTensToGerman(number: Double): String {
        val tens = (number / 10).toInt()
        val units = (number % 10).toInt()
        return when (tens) {
            2 -> if (units == 0) "zwanzig" else "${convertSmallNumberToGerman(units.toDouble())}undzwanzig"
            3 -> if (units == 0) "dreißig" else "${convertSmallNumberToGerman(units.toDouble())}unddreißig"
            4 -> if (units == 0) "vierzig" else "${convertSmallNumberToGerman(units.toDouble())}undvierzig"
            5 -> if (units == 0) "fünfzig" else "${convertSmallNumberToGerman(units.toDouble())}undfünfzig"
            6 -> if (units == 0) "sechzig" else "${convertSmallNumberToGerman(units.toDouble())}undsechzig"
            7 -> if (units == 0) "siebzig" else "${convertSmallNumberToGerman(units.toDouble())}undsiebzig"
            8 -> if (units == 0) "achtzig" else "${convertSmallNumberToGerman(units.toDouble())}undachtzig"
            9 -> if (units == 0) "neunzig" else "${convertSmallNumberToGerman(units.toDouble())}undneunzig"
            else -> "Nicht unterstützte Zahl"
        }
    }

    // Conversion des centaines
    private fun convertHundredsToGerman(number: Double): String {
        val hundreds = (number / 100).toInt()
        val remainder = number % 100
        val hundredsPart = if (hundreds == 1) "einhundert" else "${convertSmallNumberToGerman(hundreds.toDouble())}hundert"
        return if (remainder == 0.0) hundredsPart else "$hundredsPart ${convertToGerman(remainder)}"
    }

    private fun convertThousandsToGerman(number: Double): String {
        val thousands = (number / 1000).toInt()
        val remainder = number % 1000
        val thousandsPart = if (thousands == 1) "eintausend" else "${convertToGerman(thousands.toDouble())}tausend"
        return if (remainder == 0.0) thousandsPart else "$thousandsPart ${convertToGerman(remainder)}"
    }

    private fun convertMillionsToGerman(number: Double): String {
        val millions = (number / 1_000_000).toInt()
        val remainder = number % 1_000_000
        val millionsPart = if (millions == 1) "eine Million" else "${convertToGerman(millions.toDouble())} Millionen"
        return if (remainder == 0.0) millionsPart else "$millionsPart ${convertToGerman(remainder)}"
    }

    private fun convertMilliardsToGerman(number: Double): String {
        val milliards = (number / 1_000_000_000).toInt()
        val remainder = number % 1_000_000_000
        val milliardsPart = if (milliards == 1) "eine Milliarde" else "${convertToGerman(milliards.toDouble())} Milliarden"
        return if (remainder == 0.0) milliardsPart else "$milliardsPart ${convertToGerman(remainder)}"
    }

    private fun convertBillionsToGerman(number: Double): String {
        val billions = (number / 1_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000
        val billionsPart = if (billions == 1) "eine Billion" else "${convertToGerman(billions.toDouble())} Billionen"
        return if (remainder == 0.0) billionsPart else "$billionsPart ${convertToGerman(remainder)}"
    }

    private fun convertTrillionToGerman(number: Double): String {
        val trillions = (number / 1_000_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000_000
        val trillionsPart = if (trillions == 1) "eine Trillion" else "${convertToGerman(trillions.toDouble())} Trillionen"
        return if (remainder == 0.0) trillionsPart else "$trillionsPart ${convertToGerman(remainder)}"
    }

    private fun convertTrilliardToGerman(number: Double): String {
        val trilliards = (number / 1_000_000_000_000_000_000).toInt()
        val remainder = number % 1_000_000_000_000_000_000
        val trilliardsPart = if (trilliards == 1) "eine Trilliarde" else "${convertToGerman(trilliards.toDouble())} Trilliarden"
        return if (remainder == 0.0) trilliardsPart else "$trilliardsPart ${convertToGerman(remainder)}"
    }

}