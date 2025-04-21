package dev.coinroutine.app.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import dev.coinroutine.app.core.database.portfolio.PortfolioDatabase

//fun getPortfolioDatabaseBuilder(): RoomDatabase.Builder<PortfolioDatabase> {
//    val dbFile = NSHomeDirectory() + "/portfolio.db"
//    return Room.databaseBuilder<PortfolioDatabase>(
//        name = dbFile,
//    )
//}

fun getPortfolioDatabaseBuilder(): RoomDatabase.Builder<PortfolioDatabase> {
    // Use a custom path for Windows during development
    val dbFile = "C:/Temp/portfolio.db" // Replace with your desired path
    return Room.databaseBuilder<PortfolioDatabase>(
        name = dbFile,
    )
}


//fun getPortfolioDatabaseBuilder(): RoomDatabase.Builder<PortfolioDatabase> {
//    val dbFile = getDatabasePath() // Retrieve the platform-specific database path
//    return Room.databaseBuilder(
//        PortfolioDatabase::class.toString(), // Pass the database class
//        dbFile // Pass the database file path
//    )