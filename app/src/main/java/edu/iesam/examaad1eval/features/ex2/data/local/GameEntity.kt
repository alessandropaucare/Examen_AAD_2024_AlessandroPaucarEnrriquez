package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.Player

const val TABLE_NAME = "games"

@Entity(TABLE_NAME)
@TypeConverters(Converters::class)
data class GameEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "first_name") val title: String?,
    @ColumnInfo(name = "last_name") val player: List<Player>
)
