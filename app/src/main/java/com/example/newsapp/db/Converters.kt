package com.example.newsapp.db

import androidx.room.TypeConverter
import com.example.newsapp.data.Source

class Converters {

    //TypeConverters are needed for convert Custom Object to primitive

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(source: String): Source {
        return Source(source, source)
    }
}