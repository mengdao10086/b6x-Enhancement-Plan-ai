.class public final Lcom/blankj/utilcode/util/ProcessUtils;
.super Ljava/lang/Object;
.source "ProcessUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getAllBackgroundProcesses()Ljava/util/Set;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 131
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 132
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    .line 133
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    if-eqz v0, :cond_2d

    .line 135
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 136
    iget-object v2, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    invoke-static {v1, v2}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    goto :goto_1b

    :cond_2d
    return-object v1
.end method

.method public static getCurrentProcessName()Ljava/lang/String;
    .registers 2

    .line 213
    invoke-static {}, Lcom/blankj/utilcode/util/ProcessUtils;->getCurrentProcessNameByFile()Ljava/lang/String;

    move-result-object v0

    .line 214
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_b

    return-object v0

    .line 215
    :cond_b
    invoke-static {}, Lcom/blankj/utilcode/util/ProcessUtils;->getCurrentProcessNameByAms()Ljava/lang/String;

    move-result-object v0

    .line 216
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_16

    return-object v0

    .line 217
    :cond_16
    invoke-static {}, Lcom/blankj/utilcode/util/ProcessUtils;->getCurrentProcessNameByReflect()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getCurrentProcessNameByAms()Ljava/lang/String;
    .registers 5

    const-string v0, ""

    .line 236
    :try_start_2
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-string v2, "activity"

    invoke-virtual {v1, v2}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager;

    if-nez v1, :cond_11

    return-object v0

    .line 238
    :cond_11
    invoke-virtual {v1}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_3c

    .line 239
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_1e

    goto :goto_3c

    .line 240
    :cond_1e
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    .line 241
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_26
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 242
    iget v4, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v4, v2, :cond_26

    .line 243
    iget-object v4, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    if-eqz v4, :cond_26

    .line 244
    iget-object v0, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_3c} :catch_3c

    :catch_3c
    :cond_3c
    :goto_3c
    return-object v0
.end method

.method private static getCurrentProcessNameByFile()Ljava/lang/String;
    .registers 3

    const-string v0, "/proc/"

    .line 223
    :try_start_2
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/cmdline"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 224
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/FileReader;

    invoke-direct {v2, v1}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 225
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 226
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_33
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_33} :catch_34

    return-object v1

    :catch_34
    move-exception v0

    .line 229
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    const-string v0, ""

    return-object v0
.end method

.method private static getCurrentProcessNameByReflect()Ljava/lang/String;
    .registers 5

    .line 257
    :try_start_0
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    .line 258
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "mLoadedApk"

    invoke-virtual {v1, v2}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    const/4 v2, 0x1

    .line 259
    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 260
    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 262
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v3, "mActivityThread"

    invoke-virtual {v1, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 263
    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 264
    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 266
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "getProcessName"

    const/4 v3, 0x0

    new-array v4, v3, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    .line 267
    invoke-virtual {v1, v0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_3c} :catch_3d

    goto :goto_43

    :catch_3d
    move-exception v0

    .line 269
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    const-string v0, ""

    :goto_43
    return-object v0
.end method

.method public static getForegroundProcessName()Ljava/lang/String;
    .registers 11

    const-string v0, "android:get_usage_stats"

    .line 56
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-string v2, "activity"

    invoke-virtual {v1, v2}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager;

    .line 58
    invoke-virtual {v1}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_33

    .line 59
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_33

    .line 60
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_33

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 61
    iget v3, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v4, 0x64

    if-ne v3, v4, :cond_1e

    .line 63
    iget-object v0, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    return-object v0

    .line 68
    :cond_33
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 69
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.settings.USAGE_ACCESS_SETTINGS"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/high16 v3, 0x10000

    .line 71
    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v3

    .line 72
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "ProcessUtils"

    invoke-static {v5, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    const-string v4, ""

    if-gtz v3, :cond_5f

    const-string v0, "getForegroundProcessName: noun of access to usage information."

    .line 74
    invoke-static {v5, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-object v4

    .line 80
    :cond_5f
    :try_start_5f
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v6, 0x0

    invoke-virtual {v1, v3, v6}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 82
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v3

    const-string v6, "appops"

    invoke-virtual {v3, v6}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/AppOpsManager;

    .line 83
    iget v6, v1, Landroid/content/pm/ApplicationInfo;->uid:I

    iget-object v7, v1, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v3, v0, v6, v7}, Landroid/app/AppOpsManager;->checkOpNoThrow(Ljava/lang/String;ILjava/lang/String;)I

    move-result v6

    if-eqz v6, :cond_8e

    const/high16 v6, 0x10000000

    .line 86
    invoke-virtual {v2, v6}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 87
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v6

    invoke-virtual {v6, v2}, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V

    .line 89
    :cond_8e
    iget v2, v1, Landroid/content/pm/ApplicationInfo;->uid:I

    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v3, v0, v2, v1}, Landroid/app/AppOpsManager;->checkOpNoThrow(Ljava/lang/String;ILjava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_9e

    const-string v0, "getForegroundProcessName: refuse to device usage stats."

    .line 92
    invoke-static {v5, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    return-object v4

    .line 96
    :cond_9e
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "usagestats"

    .line 97
    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    move-object v5, v0

    check-cast v5, Landroid/app/usage/UsageStatsManager;

    const/4 v0, 0x0

    if-eqz v5, :cond_bd

    .line 100
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    const-wide/32 v1, 0x240c8400

    sub-long v7, v9, v1

    const/4 v6, 0x4

    .line 103
    invoke-virtual/range {v5 .. v10}, Landroid/app/usage/UsageStatsManager;->queryUsageStats(IJJ)Ljava/util/List;

    move-result-object v1

    goto :goto_be

    :cond_bd
    move-object v1, v0

    :goto_be
    if-eqz v1, :cond_f0

    .line 106
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_c7

    goto :goto_f0

    .line 108
    :cond_c7
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    move-object v2, v0

    :cond_cc
    :goto_cc
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_e8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/usage/UsageStats;

    if-eqz v2, :cond_e6

    .line 110
    invoke-virtual {v3}, Landroid/app/usage/UsageStats;->getLastTimeUsed()J

    move-result-wide v5

    invoke-virtual {v2}, Landroid/app/usage/UsageStats;->getLastTimeUsed()J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-lez v5, :cond_cc

    :cond_e6
    move-object v2, v3

    goto :goto_cc

    :cond_e8
    if-nez v2, :cond_eb

    goto :goto_ef

    .line 114
    :cond_eb
    invoke-virtual {v2}, Landroid/app/usage/UsageStats;->getPackageName()Ljava/lang/String;

    move-result-object v0
    :try_end_ef
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_5f .. :try_end_ef} :catch_f1

    :goto_ef
    return-object v0

    :cond_f0
    :goto_f0
    return-object v4

    :catch_f1
    move-exception v0

    .line 116
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    return-object v4
.end method

.method public static isMainProcess()Z
    .registers 2

    .line 204
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/blankj/utilcode/util/ProcessUtils;->getCurrentProcessName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static killAllBackgroundProcesses()Ljava/util/Set;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 151
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 152
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    .line 153
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    if-nez v1, :cond_18

    return-object v2

    .line 155
    :cond_18
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_39

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 156
    iget-object v3, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    array-length v5, v3

    :goto_2c
    if-ge v4, v5, :cond_1c

    aget-object v6, v3, v4

    .line 157
    invoke-virtual {v0, v6}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 158
    invoke-interface {v2, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_2c

    .line 161
    :cond_39
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    .line 162
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_41
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 163
    iget-object v1, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    array-length v3, v1

    move v5, v4

    :goto_51
    if-ge v5, v3, :cond_41

    aget-object v6, v1, v5

    .line 164
    invoke-interface {v2, v6}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    add-int/lit8 v5, v5, 0x1

    goto :goto_51

    :cond_5b
    return-object v2
.end method

.method public static killBackgroundProcesses(Ljava/lang/String;)Z
    .registers 5

    .line 180
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 181
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x1

    if-eqz v1, :cond_65

    .line 182
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_1a

    goto :goto_65

    .line 183
    :cond_1a
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1e
    :goto_1e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 184
    iget-object v3, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1e

    .line 185
    invoke-virtual {v0, p0}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    goto :goto_1e

    .line 188
    :cond_3a
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_65

    .line 189
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_47

    goto :goto_65

    .line 190
    :cond_47
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_4b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_65

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 191
    iget-object v1, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->pkgList:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4b

    const/4 p0, 0x0

    return p0

    :cond_65
    :goto_65
    return v2
.end method
