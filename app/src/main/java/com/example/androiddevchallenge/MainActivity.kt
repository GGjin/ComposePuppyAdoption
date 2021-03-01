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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.repositories.PuppiesRepository
import com.example.androiddevchallenge.ui.theme.MyTheme

val puppyList = mutableStateListOf<Puppy>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                title = "宠物收养"
                HomeView(puppyList = puppyList, onclick = {
                    val intent = Intent(this, PuppyDetailActivity::class.java)
                    intent.putExtra("data", it)
                    startActivity(intent)
                })
            }
        }
        puppyList.addAll(PuppiesRepository.getData())
        puppyList.shuffle()
    }
}

@Composable
fun HomeView(puppyList: SnapshotStateList<Puppy>, onclick: ((puppy: Puppy) -> Unit)) {
    LazyColumn(
        modifier = Modifier.padding(4.dp)
    ) {
        items(puppyList) { it ->
            Card(
                Modifier
                    .padding(2.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clickable(onClick = {
                        onclick.invoke(it)
                    })
            ) {
                val padding = Modifier.padding(4.dp)
                Row {
                    Image(
                        painter = painterResource(id = it.pic!!),
                        contentDescription = null,
                        modifier = Modifier
                            .width(170.dp)
                            .padding(4.dp),
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = padding) {
                        Text(
                            "狗狗名称:  ${it.name}",
                            maxLines = 2
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "狗狗年龄:  ${it.age}",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "狗狗来自:  ${it.from}",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

