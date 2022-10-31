package com.example.yogurt

import android.bluetooth.BluetoothDevice
import android.os.Environment
import androidx.databinding.library.BuildConfig
import androidx.multidex.BuildConfig.APPLICATION_ID
import com.dmcs.baseproject.util.ArrayQueue
import com.example.yogurt.BuildConfig.APPLICATION_ID
import org.apache.http.BuildConfig.APPLICATION_ID
import java.util.*
import kotlin.collections.ArrayList

object AppData {
    var Temp_Current_fragment:MyFragment? = null
    var Current_fragment:MyFragment? = null
    var fragment_Array:ArrayList<MyFragment> = ArrayList(100)
    var ID_NUMBER:Byte = 0
    var ID_NUMBER_MINI250_FLAG = false
    var Usb_Detached = true
    var disconnect_flag = false
    var disconnect_time:Long = 0
    var Connect = false
    var Connect_Type = -1
    var Reboot_flag=false
    var admin_flag:Int = 0
    var Speed_Index:Int = 0
    var Rspeed_Index:Int = 0
    var Message_flag=false
    var range_check=false
    var ParameterInitFlag=false
    var r = 0
    var testmini = false
    var file_focus = ""
    //기기 구분 tan이면 1 mini면 2 없으면 0
    var device_type = 0
    var speed_fragment = true
    var send_key = ""

    var electronic_type = 0
    var fragment_num = 1
    var latitude = 0.0
    var longitude = 0.0
    var latitude_st = ""
    var longitude_st = ""

    object Bluetooth{
        var bluetooth_name=""
        var mRemoteDevice: BluetoothDevice? = null
        var bluetooth_list = HashSet<BluetoothDevice>()
        var pairing_list:HashSet<BluetoothDevice> = HashSet<BluetoothDevice>()
    }

    var data_select_tab = 0
    var param_select_tab = 0

    object NewMini{
        var serial_errorf:Boolean = false
    }
    object Mini{
        var old = false

        var new_version:Int = 0
        var can_new_version:Int = 0
        var batt_type:Int = 0
        var Mini_drive_Para_num:Int = 0
        var safety_off_time:Int = 0
        var sleep_time_delay:Int = 0
        var switch3_input_type:Int = 0
        var can_baud_rate:Int = 0
        var Drive_type:Int = 0
        fun getDriveType_Str():String{
            if(Drive_type.toByte() == Stacker_Drive_type){
                return "Stacker"
            }else if(Drive_type.toByte() == AGV_Drive_type){
                return "AGV Type"
            }else if(Drive_type.toByte() == EVEC_Drive_type){
                return "EVEC Type"
            }else if(Drive_type.toByte() == MPS_Drive_type){
                return "MPS Type"
            }else{
                return "EV Type"
            }
        }
        var current_type:Int = 0
        var error_code:Int = 0

        var sminif:Int = 0
        var mini_can_driverf:Int = 0
        var drivetypef:Int = 0
        var stackerf:Int = 0
        var agvf:Int = 0
        var evecf:Int = 0
        var mpsf:Int = 0
        var sleepf:Int = 0
    }


    var Trac_Con_Version:Byte = 0x15.toByte() // 구(250), 110일반
    var Trac_Con_CAN_Version:Byte = 0x20.toByte() // CAN
    var Trac_Con_DT_Version:Byte = 0x21.toByte() // DT(110, 250)
    var Trac_Con_250_Version:Byte = 0x22.toByte() // 일반(250)

    var Mini_Drive_type:Byte = 0x80.toByte()
    var Stacker_Drive_type:Byte = 0x81.toByte()
    var AGV_Drive_type:Byte = 0x82.toByte()
    var EVEC_Drive_type:Byte = 0x83.toByte()
    var MPS_Drive_type:Byte = 0x84.toByte()

    var is_parameter_make_running=false
    var is_parameter_make_stop = false
    var is_parameter_make_complete=false

    object Protocol{
        var TAN_ID = 0x55.toByte()
        var SMINI20_CON_ID = 0x90.toByte()
        var MINI110_CON_ID = 0x91.toByte() // 일반
        var ID_NUMBER2 = 0x92.toByte()
        var MINI250_CON_ID = 0x93.toByte() // (구)Auto
        var MINICAN_CON_ID = 0x94.toByte() // CAN
        var EPSRB20_CON_ID = 0x95.toByte()
        var MINI_DT_ID = 0x56.toByte()
    }

    object Main {
//        val INTENT_ACTION_GRANT_USB = BuildConfig.APPLICATION_ID + ".GRANT_USB"

        @JvmField var arrQueue: ArrayQueue = ArrayQueue(128)
        var FilePath = ""
        var ErrorFilePath = Environment.getExternalStorageDirectory().toString() + "/DMCS/Error"
        var DeviceName = "기기가 연결되어있지 않습니다."
        var HwVer = ""
        var SwVer = ""
        var Mini_Version = 0
        var MotorRunFlag = false //
        var ParameterLayoutActive = false //Tx,Rx 통신 연결
    }
}