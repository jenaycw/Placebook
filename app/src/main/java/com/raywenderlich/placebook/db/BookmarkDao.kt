package com.raywenderlich.placebook.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raywenderlich.placebook.model.Bookmark
import java.nio.charset.CodingErrorAction.IGNORE
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface BookmarkDao{

    @Query("SELECT * FROM Bookmark")
fun loadAll(): LiveData<List<Bookmark>>

    @Query("SELECT * FROM Bookmark WHERE id = :bookMarkId")
fun loadBookmark (bookMarkId:Long):Bookmark

    @Query ("SELECT * FROM Bookmark WHERE id = :bookmarkId")
    fun loadLiveBookmark (bookmarkId:Long):LiveData<Bookmark>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBookmark(bookmark: Bookmark): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBookmark (bookmark: Bookmark)

    @Delete
    fun deleteBookmark(bookmark:Bookmark)}

