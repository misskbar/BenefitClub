package com.prisma.benefitclub

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject

class DependenciesProvider(activity: AppCompatActivity) {
    val accountViewModel: AccountViewModel by activity.inject()

}