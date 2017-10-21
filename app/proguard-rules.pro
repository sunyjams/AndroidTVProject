# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\adt-bundle-windows-x86_64-20140702\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# 代码压缩比 5
-optimizationpasses 5
# 忽略警告
# -ignorewarning
# 不适用大小写混合
-dontusemixedcaseclassnames
# 不去忽略非公共库的类
-dontskipnonpubliclibraryclasses
# 不去忽略非公共的库的类成员
-dontskipnonpubliclibraryclassmembers
# 不做预校验
-dontpreverify
# 混淆后生成映射文件
-verbose
# apk 包内所有 class 的内部结构
-dump class_files.txt
# 未混淆的类和成员
-printseeds seeds.txt
# 列出从 apk 中删除的代码
-printusage unused.txt
# 指定映射文件
-printmapping mapping.txt
# 指定混淆是采用的算法，一般不改变
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
# 保护 Annotation 不被混淆
-keepattributes *Annotation*
# 避免混淆泛型
-keepattributes Signature
# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

# Android 系统控件
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends andriod.view.View
-keep public class com.android.vending.licensing.ILicensingService

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# 确保 layout 里面写的 onClick 不被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

# 保持枚举 enum 类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保持序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keepnames class * implements java.io.Serializable

# 保持为Js互交添加的类不被混淆
-keepattributes *JavascriptInterface*

# 保持资源类不被混淆
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Google Gson
-keep class sun.misc.Unsafe { *; }
-keep class sun.misc.Unsafe {
    <fields>;
    <methods>;
}
-keep class com.google.**{*;}