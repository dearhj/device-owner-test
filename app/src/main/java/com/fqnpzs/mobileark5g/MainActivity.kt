package com.fqnpzs.mobileark5g

import android.annotation.SuppressLint
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fiberhome.mobiark.mdm.MDMAdminReceiver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            println("系统中预设包名是？   ${getProfileOwnerComponent(this)}")
            val mClass = Class.forName("android.app.admin.DevicePolicyManager")
            val setAdmin = mClass.getMethod(
                "setActiveAdmin",
                ComponentName::class.java,
                Boolean::class.java,
                Int::class.java
            )
            setAdmin.isAccessible = true
            setAdmin.invoke(
                getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager,
                ComponentName("com.fqnpzs.mobileark5g", MDMAdminReceiver::class.java.name),
                true,
                0
            )


            val setDevice = mClass.getMethod(
                "setProfileOwner",
                ComponentName::class.java,
                String::class.java,
                Int::class.java
            )
            setDevice.isAccessible = true
            setDevice.invoke(
                getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager,
                ComponentName("com.fqnpzs.mobileark5g", MDMAdminReceiver::class.java.name),
                "com.fqnpzs.mobileark5g",
                0
            )
        }
    }

    /**
     * 获取系统预设的包名
    frameworks\base\core\res\res\values\config.xml
    <string name="config_defaultSupervisionProfileOwnerComponent" translatable="false">com.android.systemfunction/com.android.systemfunction.AdminReceiver</string>
     */
    @SuppressLint("PrivateApi")
    private fun getProfileOwnerComponent(context: Context): String {
        return try {
            val c = Class.forName("com.android.internal.R\$string")
            val obj = c.newInstance()
            val field = c.getField("config_defaultSupervisionProfileOwnerComponent")
            val id = field.getInt(obj)
            context.getString(id)
        } catch (e: Exception) {
            ""
        }
    }
}