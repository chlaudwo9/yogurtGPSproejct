package com.dmcs.op.util

import android.R.attr.*
import android.os.*
import kotlin.concurrent.thread
import kotlin.experimental.and


object Util {
    fun toHexString(buf: ByteArray, len: Int): String? {
        val sb = StringBuffer()
        sb.append("0x")
        for (i in 0 until len) {
            sb.append(Integer.toHexString(0x0100 + (buf[i] and 0x00FF.toByte())).substring(1))
        }
        return sb.toString()
    }

    fun byte2short(src: ByteArray, index: Int): Int {
        val s1: Int = (src[index + 1].toInt() and 0xFF)
        val s2: Int = (src[index].toInt() and 0xFF)
        return (s1 shl 8) + (s2 shl 0)
    }

    fun DecToBit(data: Byte): ByteArray {
        var byte :ByteArray = ByteArray(8)
        byte[0] = if((data and 1.toByte()) == 1.toByte()) 1 else 0  // 1번쨰 비트가 1일 경우 1 or 0
        byte[1] = if((data and 2.toByte()) == 2.toByte()) 1 else 0  // 2번째 비트가 2일 경우 1 or 0
        byte[2] = if((data and 4.toByte()) == 4.toByte()) 1 else 0
        byte[3] = if((data and 8.toByte()) == 8.toByte()) 1 else 0
        byte[4] = if((data and 16.toByte()) == 16.toByte()) 1 else 0
        byte[5] = if((data and 32.toByte()) == 32.toByte()) 1 else 0
        byte[6] = if((data and 64.toByte()) == 64.toByte()) 1 else 0
        byte[7] = if((data and 128.toByte()) == 128.toByte()) 1 else 0

        return byte // 스위치 리스트 (1:켜짐 0:꺼짐)
    }
}