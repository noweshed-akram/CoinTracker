package com.noweshed.cointracker.presentation.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.noweshed.cointracker.R
import com.noweshed.cointracker.data.util.ApiWorker
import com.noweshed.cointracker.data.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiRequest = PeriodicWorkRequestBuilder<ApiWorker>(
            Duration.ofMinutes(Constants.SCHEDULE_TIME)
        )
        apiRequest.build()

        val request: PeriodicWorkRequest = apiRequest.build()

        WorkManager.getInstance().enqueueUniquePeriodicWork(
            "apiReq",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )

    }
}