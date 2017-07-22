package com.tim.kotlinjakewharton.model

/**
 * Created by TIM on 22.07.2017.
 */

data class Owner (
    var login: String,
    var id: Int,
    var avatarUrl: String,
    var gravatarId: String,
    var url: String,
    var htmlUrl: String,
    var followersUrl: String,
    var followingUrl: String,
    var gistsUrl: String,
    var starredUrl: String,
    var subscriptionsUrl: String,
    var organizationsUrl: String,
    var reposUrl: String,
    var eventsUrl: String,
    var receivedEventsUrl: String,
    var type: String,
    var siteAdmin: Boolean
)
