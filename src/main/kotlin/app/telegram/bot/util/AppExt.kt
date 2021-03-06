package app.telegram.bot.util

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.reflect.KClass

fun retrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

fun <T : Any> Retrofit.create(clazz: KClass<T>): T = this.create(clazz.java)

fun ClosedRange<Int>.random() = Random().nextInt((endInclusive + 1) - start) +  start
fun <T> List<T>.random() = this[(0 until this.size).random()]
//fun String.containsIgnoreCase(string: String) = this.contains(string, ignoreCase = true)

fun getStartMessage(nickname: String) = "Hello, $nickname, let's start! Use /help command for get start"

fun getHelpMessage() = """
    Commands:

    /start -> Send hello message
    /help -> Send this message
    /post_random -> Send random post from the top on post api site
    /posts_random -> Send random posts from the top on post api site
    /post_relevant -> Send relevant post from site api
    /posts_relevant -> Send relevant posts from site api

    Phrases:

    Send me ["query"] post -> Send me "Android" post
    Send me ["query"] post -> Send me "Android" posts
    Send me [number] posts -> Send me 10 posts
    Send me [number] ["query"] posts -> Send me 3 "Android" posts
""".trimIndent()
