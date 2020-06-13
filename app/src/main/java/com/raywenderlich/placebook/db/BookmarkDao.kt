package com.raywenderlich.placebook.db

import androidx.lifecycle.LiveData
import com.raywenderlich.placebook.model.Bookmark
import java.nio.charset.CodingErrorAction.IGNORE
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface BookmarkDao{

    @Query("SELECT * FROM Bookmark")
fun loadAll(): LiveData<List<Bookmark>>

    @Query ("SELECT * FROM Bookmark WHERE id = :bookmarkID")
fun loadBookmark (bookMarkId:Long):Bookmark

    @Query ("SELECT * FROM Bookmark WHERE id = bookmarkID")
    fun loadLiveBookmark (bookmarkId:Long):LiveData<Bookmark>

    @Insert (onConflict = IGNORE)
    fun insertBookmark(bookmark:Bookmark):Long

    @Update (onConflict = REPLACE)
    fun updateBookmark (bookmark:Bookmark)

    @Delete
    fun deleteBookmark(bookmark:Bookmark)}

