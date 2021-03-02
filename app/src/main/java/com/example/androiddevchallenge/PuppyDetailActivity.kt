/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy

/**
 *  Create by GG on 2021/3/1
 *  mail is 769267317@qq.com
 */
class PuppyDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppyBean: Puppy = intent.getSerializableExtra("data") as Puppy
        setContent {
            DetailView(puppyBean)
        }
    }
}

@Composable
fun DetailView(it: Puppy) {
    Card(
        Modifier
            .padding(8.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = it.pic!!),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            val height = 32.dp
            Spacer(Modifier.height(height))
            val padding = Modifier.padding(16.dp)
            Column(modifier = padding) {
                Text(
                    "狗狗名称:  \n${it.name}",
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(height))
                Text(
                    "狗狗年龄:  \n${it.age}",
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(height))
                Text(
                    "狗狗来自:  \n${it.from}",
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(height))
                Text(
                    "狗狗品种:  \n${it.varieties}",
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(height))
                Text(
                    "狗狗介绍:  \n${it.introduce}",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
