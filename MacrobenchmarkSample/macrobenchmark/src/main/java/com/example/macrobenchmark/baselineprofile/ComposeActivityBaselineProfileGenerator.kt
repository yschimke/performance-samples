/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.macrobenchmark.baselineprofile

import android.content.Intent
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import com.example.benchmark.macro.base.util.TARGET_PACKAGE
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposeActivityBaselineProfileGenerator : BaselineProfileGeneratorScaffold() {


    override fun MacrobenchmarkScope.profileBlock() {
        // Start into the Compose Activity
        startActivityAndWait(
            Intent()
                .setAction("$TARGET_PACKAGE.COMPOSE_ACTIVITY")
        )

        // Scrolling through the Compose journey
        with(device) {
            findObject(By.res("myLazyColumn")).also {
                it.setGestureMargin(device.displayWidth / 10)
                it.fling(Direction.DOWN)
                it.fling(Direction.UP)
            }
        }

    }
}