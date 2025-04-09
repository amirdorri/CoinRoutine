package dev.coinroutine.app.core.util

import kotlin.math.pow


actual fun formatFiat(amount: Double, showDecimal: Boolean): String {
    return when {
        !showDecimal -> {
            // Round to integer
            val rounded = amount.toLong()
            "$ ${rounded.toString().addThousandSeparator()}"
        }
        amount >= 0.01 -> {
            // Two decimal places
            val formatted = roundToDecimalPlaces(amount, 2)
            "$ $formatted"
        }
        else -> {
            // Eight decimal places
            val formatted = roundToDecimalPlaces(amount, 8)
            "$ $formatted"
        }
    }
}

actual fun formatCoinUnit(amount: Double, symbol: String): String {
    // Always show eight decimal places
    val formatted = roundToDecimalPlaces(amount, 8)
    return "$formatted $symbol"
}

actual fun formatPercentage(amount: Double): String {
    // Always show two decimal places
    val prefix = if (amount >= 0) "+" else ""
    val formatted = roundToDecimalPlaces(amount, 2)
    return "$prefix$formatted %"
}
private fun roundToDecimalPlaces(value: Double, decimalPlaces: Int): String {
    val factor = 10.0.pow(decimalPlaces)
    val rounded = (value * factor).toLong() / factor
    return rounded.toString().addDecimalSeparator(decimalPlaces)
}
private fun String.addThousandSeparator(): String {
    return reversed().chunked(3).joinToString(",").reversed()
}

private fun String.addDecimalSeparator(decimalPlaces: Int): String {
    val parts = split(".")
    val integerPart = parts[0]
    val decimalPart = parts.getOrElse(1) { "" }.padEnd(decimalPlaces, '0').take(decimalPlaces)
    return "$integerPart.$decimalPart"
}









//import platform.Foundation.NSNumber
//import platform.Foundation.NSNumberFormatter
//import platform.Foundation.NSNumberFormatterDecimalStyle
//
//
//actual fun formatFiat(amount: Double, showDecimal: Boolean): String {
//    val numberFormatter = NSNumberFormatter()
//    numberFormatter.numberStyle = NSNumberFormatterDecimalStyle
//
//    when {
//        showDecimal.not() -> {
//            numberFormatter.minimumFractionDigits = 0.toULong()
//            numberFormatter.maximumFractionDigits = 0.toULong()
//        }
//
//        amount >= 0.01 -> {
//            numberFormatter.minimumFractionDigits = 2.toULong()
//            numberFormatter.maximumFractionDigits = 2.toULong()
//        }
//
//        else -> {
//            numberFormatter.minimumFractionDigits = 8.toULong()
//            numberFormatter.maximumFractionDigits = 8.toULong()
//        }
//    }
//
//    val formatterAmount = numberFormatter.stringFromNumber(NSNumber(amount))
//    return if (formatterAmount != null) "$ $formatterAmount" else ""
//}
//
//actual fun formatCoinUnit(amount: Double, symbol: String): String {
//    val numberFormatter = NSNumberFormatter()
//    numberFormatter.numberStyle = NSNumberFormatterDecimalStyle
//    numberFormatter.minimumFractionDigits = 8.toULong()
//    numberFormatter.maximumFractionDigits = 8.toULong()
//
//    return numberFormatter.stringFromNumber(NSNumber(amount)) + " $symbol"
//}
//
//actual fun formatPercentage(amount: Double): String {
//    val numberFormatter = NSNumberFormatter()
//    numberFormatter.numberStyle = NSNumberFormatterDecimalStyle
//    numberFormatter.minimumFractionDigits = 2.toULong()
//    numberFormatter.maximumFractionDigits = 2.toULong()
//    val prefix = if (amount >= 0) "+" else ""
//
//    return prefix + numberFormatter.stringFromNumber(NSNumber(amount)) + " %"
//}
//
