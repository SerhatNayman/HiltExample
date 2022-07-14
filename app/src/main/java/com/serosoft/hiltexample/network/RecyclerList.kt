package com.serosoft.hiltexample.network

import java.security.acl.Owner

data class RecyclerList(val items: List<RecyclerData>)
data class RecyclerData(val name: String?, val description: String?, val owner: Owners?)
data class Owners(val avatar_url: String?)
