# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# signingConfigs.release.proguardFiles and signingConfigs.debug.proguardFiles
# in build.gradle.

-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile
-keep class com.example.logsystem.** { *; }
-keepclassmembers class com.example.logsystem.** { *; }