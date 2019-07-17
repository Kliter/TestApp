package com.example.testapp.githubbrowsersampleclone.vo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import com.google.gson.annotations.SerializedName

/**
 * Using name/owner_login as primary key instead of id since name/owner_login is always available vs id is not.
 */
@Entity(
    indices = [// クエリを高速化するために、指定したフィールドにインデックスをつけることができる。
        Index("id"),
        Index("owner_login")
    ],
    primaryKeys = ["name", "owner_login"]
)
class Repo(// デフォルトでは、Roomはクラス名をデータベーステーブル名として使用する。(Repoテーブルが存在するということ。)
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("full_name")
    val fullName: String,
    @field:SerializedName("description")
    val description: String?,
    @field:SerializedName("owner")
    @field:Embedded(prefix = "owner_")
    val owner: Owner,
    @field:SerializedName("stargazers_count")
    val stars: Int
) {
    data class Owner(
        @field:SerializedName("login")
        val login: String,
        @field:SerializedName("url")
        val url: String?
    )

    companion object {
        const val UNKNOWN_ID = -1
    }
}