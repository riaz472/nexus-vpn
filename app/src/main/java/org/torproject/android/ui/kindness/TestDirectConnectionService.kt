package org.torproject.android.ui.kindness

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import org.torproject.android.util.DiskUtils
import org.torproject.android.util.Prefs
import org.torproject.jni.TorService

class TestDirectConnectionService : TorService() {
    companion object {
        const val TTL = 90000L
        const val TAG = "DirectTorTestService"

        fun startTorServiceTest(activity: Activity) {
            val minimalTorrc = """
                RunAsDaemon 1
                AvoidDiskWrites 1
            """.trimIndent()
            DiskUtils.flushTextToFile(getTorrc(activity), minimalTorrc, false)
            with(activity) {
                bindService(
                    Intent(activity, TestDirectConnectionService::class.java),
                    object : ServiceConnection {
                        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                            Log.wtf(TAG, "onServiceConnected")
                        }

                        override fun onServiceDisconnected(p0: ComponentName?) {
                            Log.wtf(TAG, "onServiceDisconnected")
                        }
                    },
                    BIND_AUTO_CREATE
                )
            }
            activity.startService(Intent(activity, TestDirectConnectionService::class.java).apply {
                action = ACTION_START
            })
        }

    }

    override fun onCreate() {
        super.onCreate()
        Handler(Looper.getMainLooper()).postDelayed({
            Log.wtf(TAG, "Timed out $TTL milliseconds trying a direct connection to tor...")
            stopSelf()
        }, TTL)
    }

    override fun onDestroy() {
        super.onDestroy()
        Prefs.testingKindnessMode = false
    }
}