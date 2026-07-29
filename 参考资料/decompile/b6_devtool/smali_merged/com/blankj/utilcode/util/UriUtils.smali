.class public final Lcom/blankj/utilcode/util/UriUtils;
.super Ljava/lang/Object;
.source "UriUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static copyUri2Cache(Landroid/net/Uri;)Ljava/io/File;
    .registers 8

    const-string v0, ""

    const-string v1, "UriUtils"

    const-string v2, "copyUri2Cache() called"

    .line 320
    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    .line 323
    :try_start_a
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-virtual {v2, p0}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p0
    :try_end_16
    .catch Ljava/io/FileNotFoundException; {:try_start_a .. :try_end_16} :catch_4a
    .catchall {:try_start_a .. :try_end_16} :catchall_48

    .line 324
    :try_start_16
    new-instance v2, Ljava/io/File;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Application;->getCacheDir()Ljava/io/File;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-virtual {v4, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 325
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/UtilsBridge;->writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;)Z
    :try_end_3b
    .catch Ljava/io/FileNotFoundException; {:try_start_16 .. :try_end_3b} :catch_46
    .catchall {:try_start_16 .. :try_end_3b} :catchall_5a

    if-eqz p0, :cond_45

    .line 333
    :try_start_3d
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_40
    .catch Ljava/io/IOException; {:try_start_3d .. :try_end_40} :catch_41

    goto :goto_45

    :catch_41
    move-exception p0

    .line 335
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_45
    :goto_45
    return-object v2

    :catch_46
    move-exception v0

    goto :goto_4c

    :catchall_48
    move-exception v0

    goto :goto_5c

    :catch_4a
    move-exception v0

    move-object p0, v1

    .line 328
    :goto_4c
    :try_start_4c
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V
    :try_end_4f
    .catchall {:try_start_4c .. :try_end_4f} :catchall_5a

    if-eqz p0, :cond_59

    .line 333
    :try_start_51
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_54
    .catch Ljava/io/IOException; {:try_start_51 .. :try_end_54} :catch_55

    goto :goto_59

    :catch_55
    move-exception p0

    .line 335
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_59
    :goto_59
    return-object v1

    :catchall_5a
    move-exception v0

    move-object v1, p0

    :goto_5c
    if-eqz v1, :cond_66

    .line 333
    :try_start_5e
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_61
    .catch Ljava/io/IOException; {:try_start_5e .. :try_end_61} :catch_62

    goto :goto_66

    :catch_62
    move-exception p0

    .line 335
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 338
    :cond_66
    :goto_66
    throw v0
.end method

.method public static file2Uri(Ljava/io/File;)Landroid/net/Uri;
    .registers 3

    .line 58
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isFileExists(Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_8

    const/4 p0, 0x0

    return-object p0

    .line 60
    :cond_8
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".utilcode.fileprovider"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 61
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-static {v1, v0, p0}, Landroidx/core/content/FileProvider;->getUriForFile(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;

    move-result-object p0

    return-object p0
.end method

.method private static getFileFromUri(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/File;
    .registers 3

    const/4 v0, 0x0

    .line 268
    invoke-static {p0, v0, v0, p1}, Lcom/blankj/utilcode/util/UriUtils;->getFileFromUri(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    return-object p0
.end method

.method private static getFileFromUri(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .registers 11

    const-string v0, "com.google.android.apps.photos.content"

    .line 275
    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_20

    .line 276
    invoke-virtual {p0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6e

    .line 277
    new-instance p1, Ljava/io/File;

    invoke-virtual {p0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object p1

    :cond_20
    const-string v0, "com.tencent.mtt.fileprovider"

    .line 279
    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4a

    .line 280
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 281
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6e

    .line 282
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object p0

    .line 283
    new-instance p1, Ljava/io/File;

    const/16 p2, 0xa

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result p3

    invoke-virtual {v0, p2, p3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p0, p2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object p1

    :cond_4a
    const-string v0, "com.huawei.hidisk.fileprovider"

    .line 285
    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6e

    .line 286
    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 287
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_6e

    .line 288
    new-instance p0, Ljava/io/File;

    const-string p1, "/root"

    const-string p2, ""

    invoke-virtual {v0, p1, p2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object p0

    .line 292
    :cond_6e
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v0, "_data"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v3

    const/4 v6, 0x0

    move-object v2, p0

    move-object v4, p1

    move-object v5, p2

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object p1

    const/4 p2, 0x0

    const-string v1, "UriUtils"

    if-nez p1, :cond_a8

    .line 295
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, " parse failed(cursor is null). -> "

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v1, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object p2

    .line 299
    :cond_a8
    :try_start_a8
    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_ee

    .line 300
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    const/4 v2, -0x1

    if-le v0, v2, :cond_c2

    .line 302
    new-instance v2, Ljava/io/File;

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_be
    .catch Ljava/lang/Exception; {:try_start_a8 .. :try_end_be} :catch_112
    .catchall {:try_start_a8 .. :try_end_be} :catchall_110

    .line 315
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    return-object v2

    .line 304
    :cond_c2
    :try_start_c2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " parse failed(columnIndex: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " is wrong). -> "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_ea
    .catch Ljava/lang/Exception; {:try_start_c2 .. :try_end_ea} :catch_112
    .catchall {:try_start_c2 .. :try_end_ea} :catchall_110

    .line 315
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    return-object p2

    .line 308
    :cond_ee
    :try_start_ee
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " parse failed(moveToFirst return false). -> "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_10c
    .catch Ljava/lang/Exception; {:try_start_ee .. :try_end_10c} :catch_112
    .catchall {:try_start_ee .. :try_end_10c} :catchall_110

    .line 315
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    return-object p2

    :catchall_110
    move-exception p0

    goto :goto_134

    .line 312
    :catch_112
    :try_start_112
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v0, " parse failed. -> "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v1, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_130
    .catchall {:try_start_112 .. :try_end_130} :catchall_110

    .line 315
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    return-object p2

    :goto_134
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 316
    throw p0
.end method

.method public static res2Uri(Ljava/lang/String;)Landroid/net/Uri;
    .registers 3

    .line 48
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "android.resource://"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p0

    return-object p0
.end method

.method public static uri2Bytes(Landroid/net/Uri;)[B
    .registers 5

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 351
    :cond_4
    :try_start_4
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p0
    :try_end_10
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_10} :catch_26
    .catchall {:try_start_4 .. :try_end_10} :catchall_21

    .line 352
    :try_start_10
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->inputStream2Bytes(Ljava/io/InputStream;)[B

    move-result-object v0
    :try_end_14
    .catch Ljava/io/FileNotFoundException; {:try_start_10 .. :try_end_14} :catch_1f
    .catchall {:try_start_10 .. :try_end_14} :catchall_3d

    if-eqz p0, :cond_1e

    .line 360
    :try_start_16
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_19} :catch_1a

    goto :goto_1e

    :catch_1a
    move-exception p0

    .line 362
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_1e
    :goto_1e
    return-object v0

    :catch_1f
    move-exception v1

    goto :goto_28

    :catchall_21
    move-exception p0

    move-object v3, v0

    move-object v0, p0

    move-object p0, v3

    goto :goto_3e

    :catch_26
    move-exception v1

    move-object p0, v0

    .line 354
    :goto_28
    :try_start_28
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    const-string v1, "UriUtils"

    const-string v2, "uri to bytes failed."

    .line 355
    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_32
    .catchall {:try_start_28 .. :try_end_32} :catchall_3d

    if-eqz p0, :cond_3c

    .line 360
    :try_start_34
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_37
    .catch Ljava/io/IOException; {:try_start_34 .. :try_end_37} :catch_38

    goto :goto_3c

    :catch_38
    move-exception p0

    .line 362
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_3c
    :goto_3c
    return-object v0

    :catchall_3d
    move-exception v0

    :goto_3e
    if-eqz p0, :cond_48

    .line 360
    :try_start_40
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_43
    .catch Ljava/io/IOException; {:try_start_40 .. :try_end_43} :catch_44

    goto :goto_48

    :catch_44
    move-exception p0

    .line 362
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 365
    :cond_48
    :goto_48
    throw v0
.end method

.method public static uri2File(Landroid/net/Uri;)Ljava/io/File;
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 75
    :cond_4
    invoke-static {p0}, Lcom/blankj/utilcode/util/UriUtils;->uri2FileReal(Landroid/net/Uri;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_b

    return-object v0

    .line 77
    :cond_b
    invoke-static {p0}, Lcom/blankj/utilcode/util/UriUtils;->copyUri2Cache(Landroid/net/Uri;)Ljava/io/File;

    move-result-object p0

    return-object p0
.end method

.method public static uri2FileNoCacheCopy(Landroid/net/Uri;)Ljava/io/File;
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 88
    :cond_4
    invoke-static {p0}, Lcom/blankj/utilcode/util/UriUtils;->uri2FileReal(Landroid/net/Uri;)Ljava/io/File;

    move-result-object p0

    return-object p0
.end method

.method private static uri2FileReal(Landroid/net/Uri;)Ljava/io/File;
    .registers 18

    move-object/from16 v1, p0

    .line 98
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v2, "UriUtils"

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 100
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v3

    .line 101
    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v4

    const-string v5, "/"

    const/4 v6, 0x0

    const/4 v7, 0x0

    if-eqz v4, :cond_15e

    const-string v8, "/external/"

    const-string v9, "/external_path/"

    .line 103
    filled-new-array {v8, v9}, [Ljava/lang/String;

    move-result-object v8

    move v9, v7

    :goto_26
    const-string v10, " -> "

    const/4 v11, 0x2

    if-ge v9, v11, :cond_7b

    .line 105
    aget-object v11, v8, v9

    .line 106
    invoke-virtual {v4, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_78

    .line 107
    new-instance v12, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v14

    invoke-virtual {v14}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 108
    invoke-virtual {v4, v11, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 109
    invoke-virtual {v12}, Ljava/io/File;->exists()Z

    move-result v13

    if-eqz v13, :cond_78

    .line 110
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object v12

    :cond_78
    add-int/lit8 v9, v9, 0x1

    goto :goto_26

    :cond_7b
    const-string v8, "/files_path/"

    .line 116
    invoke-virtual {v4, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_ab

    .line 117
    new-instance v9, Ljava/io/File;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v12

    invoke-virtual {v12}, Landroid/app/Application;->getFilesDir()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 118
    invoke-virtual {v4, v8, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto/16 :goto_139

    :cond_ab
    const-string v8, "/cache_path/"

    .line 119
    invoke-virtual {v4, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_da

    .line 120
    new-instance v9, Ljava/io/File;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v12

    invoke-virtual {v12}, Landroid/app/Application;->getCacheDir()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 121
    invoke-virtual {v4, v8, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_139

    :cond_da
    const-string v8, "/external_files_path/"

    .line 122
    invoke-virtual {v4, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_109

    .line 123
    new-instance v9, Ljava/io/File;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v12

    invoke-virtual {v12, v6}, Landroid/app/Application;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 124
    invoke-virtual {v4, v8, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_139

    :cond_109
    const-string v8, "/external_cache_path/"

    .line 125
    invoke-virtual {v4, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_138

    .line 126
    new-instance v9, Ljava/io/File;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v12

    invoke-virtual {v12}, Landroid/app/Application;->getExternalCacheDir()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 127
    invoke-virtual {v4, v8, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    goto :goto_139

    :cond_138
    move-object v9, v6

    :goto_139
    if-eqz v9, :cond_15e

    .line 129
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_15e

    .line 130
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object v9

    :cond_15e
    const-string v8, "file"

    .line 134
    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_189

    if-eqz v4, :cond_16e

    .line 135
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v0

    .line 136
    :cond_16e
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-object v6

    .line 140
    :cond_189
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v4

    invoke-static {v4, v1}, Landroid/provider/DocumentsContract;->isDocumentUri(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v4

    const-string v8, "content"

    if-eqz v4, :cond_409

    const-string v4, "com.android.externalstorage.documents"

    .line 141
    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const-string v9, ":"

    const/4 v10, 0x1

    if-eqz v4, :cond_2ec

    .line 142
    invoke-static/range {p0 .. p0}, Landroid/provider/DocumentsContract;->getDocumentId(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 143
    invoke-virtual {v0, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 144
    aget-object v3, v0, v7

    const-string v4, "primary"

    .line 145
    invoke-virtual {v4, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1d3

    .line 146
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v0, v0, v10

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v1

    .line 150
    :cond_1d3
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v4

    const-string v8, "storage"

    invoke-virtual {v4, v8}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/storage/StorageManager;

    :try_start_1df
    const-string v8, "android.os.storage.StorageVolume"

    .line 152
    invoke-static {v8}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v8

    .line 153
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v9

    const-string v11, "getVolumeList"

    new-array v12, v7, [Ljava/lang/Class;

    invoke-virtual {v9, v11, v12}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v9

    const-string v11, "getUuid"

    new-array v12, v7, [Ljava/lang/Class;

    .line 154
    invoke-virtual {v8, v11, v12}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v11

    const-string v12, "getState"

    new-array v13, v7, [Ljava/lang/Class;

    .line 155
    invoke-virtual {v8, v12, v13}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v12

    const-string v13, "getPath"

    new-array v14, v7, [Ljava/lang/Class;

    .line 156
    invoke-virtual {v8, v13, v14}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v13

    const-string v14, "isPrimary"

    new-array v15, v7, [Ljava/lang/Class;

    .line 157
    invoke-virtual {v8, v14, v15}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v14

    const-string v15, "isEmulated"

    new-array v6, v7, [Ljava/lang/Class;

    .line 158
    invoke-virtual {v8, v15, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    new-array v8, v7, [Ljava/lang/Object;

    .line 160
    invoke-virtual {v9, v4, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 162
    invoke-static {v4}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v8

    move v9, v7

    :goto_224
    if-ge v9, v8, :cond_2d0

    .line 164
    invoke-static {v4, v9}, Ljava/lang/reflect/Array;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v15

    const-string v10, "mounted"

    move-object/from16 v16, v4

    new-array v4, v7, [Ljava/lang/Object;

    .line 167
    invoke-virtual {v12, v15, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v10, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_24b

    const-string v4, "mounted_ro"

    new-array v10, v7, [Ljava/lang/Object;

    .line 168
    invoke-virtual {v12, v15, v10}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_249

    goto :goto_24b

    :cond_249
    move v4, v7

    goto :goto_24c

    :cond_24b
    :goto_24b
    const/4 v4, 0x1

    :goto_24c
    if-nez v4, :cond_24f

    goto :goto_2a0

    :cond_24f
    new-array v4, v7, [Ljava/lang/Object;

    .line 174
    invoke-virtual {v14, v15, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_26c

    new-array v4, v7, [Ljava/lang/Object;

    .line 175
    invoke-virtual {v6, v15, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_26c

    goto :goto_2a0

    :cond_26c
    new-array v4, v7, [Ljava/lang/Object;

    .line 179
    invoke-virtual {v11, v15, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    if-eqz v4, :cond_2a0

    .line 181
    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2a0

    .line 182
    new-instance v3, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    new-array v6, v7, [Ljava/lang/Object;

    invoke-virtual {v13, v15, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x1

    aget-object v0, v0, v5

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_29f
    .catch Ljava/lang/Exception; {:try_start_1df .. :try_end_29f} :catch_2a7

    return-object v3

    :cond_2a0
    :goto_2a0
    add-int/lit8 v9, v9, 0x1

    move-object/from16 v4, v16

    const/4 v10, 0x1

    goto/16 :goto_224

    :catch_2a7
    move-exception v0

    .line 186
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " parse failed. "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " -> 1_0"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 189
    :cond_2d0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 1_0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1

    :cond_2ec
    const-string v4, "com.android.providers.downloads.documents"

    .line 192
    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_381

    .line 193
    invoke-static/range {p0 .. p0}, Landroid/provider/DocumentsContract;->getDocumentId(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 194
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_31a

    .line 195
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed(id is null). -> 1_1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1

    :cond_31a
    const-string v3, "raw:"

    .line 198
    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_32d

    .line 199
    new-instance v1, Ljava/io/File;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    return-object v1

    :cond_32d
    const-string v3, "msf:"

    .line 200
    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_33c

    .line 201
    invoke-virtual {v0, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    aget-object v0, v0, v3

    .line 206
    :cond_33c
    :try_start_33c
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3
    :try_end_340
    .catch Ljava/lang/Exception; {:try_start_33c .. :try_end_340} :catch_37f

    const-string v0, "content://downloads/all_downloads"

    const-string v5, "content://downloads/my_downloads"

    const-string v6, "content://downloads/public_downloads"

    .line 211
    filled-new-array {v6, v0, v5}, [Ljava/lang/String;

    move-result-object v0

    :goto_34a
    const/4 v5, 0x3

    if-ge v7, v5, :cond_363

    .line 217
    aget-object v5, v0, v7

    .line 218
    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-static {v5, v3, v4}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v5

    :try_start_357
    const-string v6, "1_1"

    .line 220
    invoke-static {v5, v6}, Lcom/blankj/utilcode/util/UriUtils;->getFileFromUri(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/File;

    move-result-object v5
    :try_end_35d
    .catch Ljava/lang/Exception; {:try_start_357 .. :try_end_35d} :catch_360

    if-eqz v5, :cond_360

    return-object v5

    :catch_360
    :cond_360
    add-int/lit8 v7, v7, 0x1

    goto :goto_34a

    .line 228
    :cond_363
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 1_1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1

    :catch_37f
    const/4 v1, 0x0

    return-object v1

    :cond_381
    const-string v4, "com.android.providers.media.documents"

    .line 231
    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3e0

    .line 232
    invoke-static/range {p0 .. p0}, Landroid/provider/DocumentsContract;->getDocumentId(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 233
    invoke-virtual {v0, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 234
    aget-object v3, v0, v7

    const-string v4, "image"

    .line 236
    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_39f

    .line 237
    sget-object v1, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    :goto_39d
    const/4 v2, 0x1

    goto :goto_3b5

    :cond_39f
    const-string v4, "video"

    .line 238
    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3aa

    .line 239
    sget-object v1, Landroid/provider/MediaStore$Video$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    goto :goto_39d

    :cond_3aa
    const-string v4, "audio"

    .line 240
    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3c4

    .line 241
    sget-object v1, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    goto :goto_39d

    :goto_3b5
    new-array v3, v2, [Ljava/lang/String;

    .line 247
    aget-object v0, v0, v2

    aput-object v0, v3, v7

    const-string v0, "_id=?"

    const-string v2, "1_2"

    .line 248
    invoke-static {v1, v0, v3, v2}, Lcom/blankj/utilcode/util/UriUtils;->getFileFromUri(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0

    .line 243
    :cond_3c4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 1_2"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1

    .line 250
    :cond_3e0
    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3ed

    const-string v0, "1_3"

    .line 251
    invoke-static {v1, v0}, Lcom/blankj/utilcode/util/UriUtils;->getFileFromUri(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0

    .line 254
    :cond_3ed
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 1_4"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1

    .line 258
    :cond_409
    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_416

    const-string v0, "2"

    .line 259
    invoke-static {v1, v0}, Lcom/blankj/utilcode/util/UriUtils;->getFileFromUri(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0

    .line 262
    :cond_416
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {p0 .. p0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " parse failed. -> 3"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1
.end method
