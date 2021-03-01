package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R
import java.io.Serializable

/**
 *  Create by GG on 2021/3/1
 *  mail is 769267317@qq.com
 */
data class Puppy(
    val pic: Int? = R.drawable.puppy1,
    val name: String? = "名字",
    val age: Int? = 5,
    val from: String? = "地点",
    val varieties: String? = "品种",
    val introduce: String? = "介绍",
) : Serializable
