package org.achumkin

import com.microsoft.playwright.BrowserType

fun getLaunchOptions(): BrowserType.LaunchOptions {
    return if (System.getenv("HEADFUL").toBoolean()) {
        BrowserType.LaunchOptions()
            .setHeadless(false)
            .setSlowMo(500.0)
    } else {
        BrowserType.LaunchOptions()
            .setHeadless(true)

    }
}
