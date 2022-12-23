package com.noweshed.cointracker.data.util

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.noweshed.cointracker.presentation.viewmodel.CryptoViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by noweshedakram on 23/12/22.
 */
class ApiWorker(
    private val context: Context,
    private val workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    @Inject
    lateinit var cryptoViewModel: CryptoViewModel

    override suspend fun doWork(): Result {
        return try {
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.ENGLISH)
            val currentDate = time.format(Date())
            Log.i("ApiWorker", "Completed $currentDate")
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}