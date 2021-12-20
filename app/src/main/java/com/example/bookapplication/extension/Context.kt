package com.example.bookapplication.extension

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog
import com.example.bookapplication.MainApplication
import com.example.bookapplication.R
import com.example.bookapplication.di.AppComponent

val Context.preferences: SharedPreferences
    get() = getSharedPreferences("book_app", Context.MODE_PRIVATE)

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> this.applicationContext.appComponent
    }

fun Context.showAlert(title: String?, message: String?){
    val builder = AlertDialog.Builder(this, R.style.AlertDialogTheme)
        .setMessage(message)
        .setTitle(title)
    val dialog: AlertDialog = builder.create()
    dialog.show()
}