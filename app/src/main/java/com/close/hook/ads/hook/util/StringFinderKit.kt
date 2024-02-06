package com.close.hook.ads.hook.util

import org.luckypray.dexkit.result.MethodData

object StringFinderKit {

    fun findMethodsWithString(searchString: String): List<MethodData>? {
        DexKitUtil.initializeDexKitBridge()

        val packageName = DexKitUtil.context.packageName
        val foundMethods = DexKitUtil.getCachedOrFindMethods(packageName) {
            DexKitUtil.getBridge().findMethod {
      //        searchPackages(listOf("okhttp3"))
                matcher {
                    usingStrings = listOf(searchString)
                }
            }?.toList()
        }

        DexKitUtil.releaseBridge()
        return foundMethods
    }
}
