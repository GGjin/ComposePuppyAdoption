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
package com.example.androiddevchallenge.repositories

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy

/**
 *  Create by GG on 2021/3/1
 *  mail is 769267317@qq.com
 */
object PuppiesRepository {

    private val nameList = mutableListOf(
        "小老虎",
        "小白",
        "旺财",
        "咪咪",
        "旺旺",
        "汪汪",
        "波波",
        "来福",
        "小狗",
    )

    private val fromList = mutableListOf(
        "广州",
        "上海",
        "武汉",
        "北京 朝阳",
        "北京 海淀",
        "北京 昌平",
        "北京 大兴",
        "南京 学院路",
        "南京 夫子庙",
        "西安",
        "成都",
        "长沙",
        "海口",
        "三亚",
    )

    private val picList = mutableListOf(
        R.drawable.puppy1,
        R.drawable.puppy2,
        R.drawable.puppy3,
        R.drawable.puppy4,
        R.drawable.puppy5,
        R.drawable.puppy6,
        R.drawable.puppy7,
        R.drawable.puppy8,
        R.drawable.puppy9,
        R.drawable.puppy10,
    )

    private val varietiesList = mutableListOf(
        "混血",
        "萨摩亚",
        "京巴",
        "藏獒",
        "狮子犬",
        "豹子",
        "狮子",
        "泰迪",
        "比熊",
    )

    private val colorList = mutableListOf(
        "黄色",
        "白色",
        "黑色",
        "金色",
        "绿色",
        "红色",
        "粉色",
        "混色",
    )

    private val sexList = mutableListOf(
        "公",
        "母",
        "不明",
    )

    private val introduceList = mutableListOf(
        "2013年10月28日，常给领养之家送水的工人带来只小狗，说是狗狗自己跑到他家店里的，后来就一直不走了，他是个工人没能力养它，请求领养之家收留，经过负责人同意，狗狗由领养之家收留，期待好心人的领养。",
        "2013年8月1日的晚上, 我们的工作人员魏小姐回来, 发现有人丢了一只咖啡色的小贵宾犬在领养之家的门外, 我们只好收养了它, 给它起名叫\\\"米其\\\".小家伙挺乖.",
        "2014年2月7日，义工谢小姐在海岸城转后海大道的转弯辅道上发现一只狗狗趴在那，见比较危险就下车想把狗狗带去人行道，可是走近才发现狗狗双后腿法动，嘴也是歪的，应该遭遇车祸，于是将它送去医院。经检查狗狗后腿、股骨头、嘴都骨折。经过手术治疗，现已康复，没有任何行动不便的地方，期待好人领养！",
        "2012年9月11日我们义工的表妹在罗湖书城后面的马路中间遇到它，当时在马路上来回奔跑，很危险。于是立刻拉住狗狗，并在周围城中村，宠物店等地牵着狗狗到处找其主人。但是经过3天的寻找仍没结果。现在义工表妹家中暂时寄养，等待新主人。",
        "2013年9月16日, 我们在网上看到有人说南山宜家超市停车场里有一只怀孕的母狗流浪多日, 而且狗狗经常向路人嚎叫,  我们担心会受到他人的伤害, 于是我们赶紧去救它, 当时母狗肚子很大, 我们想抓去做绝育, 结果没成功, 接连3天又去都没有再看到它, 等到20日看到时发现狗狗已经生产, 把小狗生在哪里我们也不知道, 结果在一个月里, 我们的负责人和义工谢小姐轮流每天下班后带肉去喂狗妈, 直到10月17日我们发现小狗在宜家停车场外的桥底下, 共有5只小狗, 已经会跑出来玩, 于是我们派人将它们一家全部带到领养之家喂养, 5个小狗中我们按个子大小排行来起名, 这只起名叫\\\"宜家3\\\".我们希望能有好心人来领养.",
        "2008.7在白石洲路边水果摊旁捡到,当时很赃,瘦的皮包骨,送往宠物医院检查,发现患有细小病,经及时治疗现已痊愈.由于身体原因需较长时间恢复,目前健康状况良好，于2009年七月已绝育.等待领养。",
        "2007，11被人救助送至领养之家。",
        "2011年6月11日晚12点多，我们义工谢小姐在自家小区喂流浪猫时遇到了这只狗狗，当时狗狗还跟着一位小姐进了电梯，可几分钟后狗狗自己又坐着电梯下来了，谢小姐在楼下等了近一小时也没人来找。狗狗当时很干净，只是因小雨，脚和肚子较湿较脏。保安说从来没在该小区见过这只狗狗，可能是附近小区走失的。随后的一个多星期，我们在周围小区、马路、网上都发帖寻找狗狗主人，但一直没消息，所以决定给狗狗找寻新主人。",
    )

    fun getData(size: Int = 50): MutableList<Puppy> {
        val list = mutableListOf<Puppy>()
        (0..size).forEach { _ ->
            list.add(
                Puppy(
                    pic = picList.random(), name = nameList.random(), age = (1..10).random(), from = fromList.random(),
                    varieties = "${varietiesList.random()} ${colorList.random()} ${sexList.random()}", introduce = introduceList.random()
                )
            )
        }
        return list
    }
}
