package com.axiaworks.tutorial.mvvm.response

import com.squareup.moshi.Json

data class QiitaItem(
    @Json(name = "rendered_body")
    val renderedBody: String,
    val body: String,
    val coediting: Boolean,
    @Json(name = "comments_count")
    val commentsCount: Int,
    @Json(name = "created_at")
    val createdAt: String,
    val group: QiitaGroup?,
    val id: String,
    @Json(name = "likes_count")
    val likesCount: Int,
    val private: Boolean,
    @Json(name = "reactions_count")
    val reactionsCount: Int,
    val tags: List<QiitaTag>,
    val title: String,
    @Json(name = "updated_at")
    val updatedAt: String,
    val url: String,
    val user: QiitaUser,
    @Json(name = "page_view_count")
    val pageViewCount: Int?
)

data class QiitaGroup(
    @Json(name = "created_at")
    val createdAt: String,
    val id: Int,
    val name: String,
    val private: Boolean,
    @Json(name = "updated_at")
    val updatedAt: String,
    @Json(name = "url_name")
    val urlName: String
)

data class QiitaTag(
    val name: String,
    val versions: List<String>
)

data class QiitaUser(
    val description: String?,
    @Json(name = "facebook_id")
    val facebookId: String?,
    @Json(name = "followees_count")
    val followeesCount: Int,
    @Json(name = "followers_count")
    val followersCount: Int,
    @Json(name = "github_login_name")
    val githubLoginName: String?,
    val id: String,
    @Json(name = "items_count")
    val itemsCount: Int,
    @Json(name = "linkedin_id")
    val linkedinId: String?,
    val location: String?,
    val name: String,
    val organization: String?,
    @Json(name = "permanent_id")
    val permanentId: Int,
    @Json(name = "profile_image_url")
    val profileImageUrl: String,
    @Json(name = "team_only")
    val teamOnly: Boolean,
    @Json(name = "twitter_screen_name")
    val twitterScreenName: String?,
    @Json(name = "web_site_url")
    val websiteUrl: String?
)