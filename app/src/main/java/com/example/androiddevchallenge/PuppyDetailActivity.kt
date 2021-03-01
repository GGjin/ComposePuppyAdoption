package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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