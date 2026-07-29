.class public final Lcom/blankj/utilcode/util/LogUtils;
.super Ljava/lang/Object;
.source "LogUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/LogUtils$LogFormatter;,
        Lcom/blankj/utilcode/util/LogUtils$TagHead;,
        Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;,
        Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;,
        Lcom/blankj/utilcode/util/LogUtils$IFileWriter;,
        Lcom/blankj/utilcode/util/LogUtils$IFormatter;,
        Lcom/blankj/utilcode/util/LogUtils$Config;,
        Lcom/blankj/utilcode/util/LogUtils$TYPE;
    }
.end annotation


# static fields
.field public static final A:I = 0x7

.field private static final ARGS:Ljava/lang/String; = "args"

.field private static final BOTTOM_BORDER:Ljava/lang/String; = "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

.field private static final BOTTOM_CORNER:Ljava/lang/String; = "\u2514"

.field private static final CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

.field public static final D:I = 0x3

.field public static final E:I = 0x6

.field private static final EXECUTOR:Ljava/util/concurrent/ExecutorService;

.field private static final FILE:I = 0x10

.field private static final FILE_SEP:Ljava/lang/String;

.field public static final I:I = 0x4

.field private static final I_FORMATTER_MAP:Landroidx/collection/SimpleArrayMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/collection/SimpleArrayMap<",
            "Ljava/lang/Class;",
            "Lcom/blankj/utilcode/util/LogUtils$IFormatter;",
            ">;"
        }
    .end annotation
.end field

.field private static final JSON:I = 0x20

.field private static final LEFT_BORDER:Ljava/lang/String; = "\u2502 "

.field private static final LINE_SEP:Ljava/lang/String;

.field private static final MAX_LEN:I = 0x44c

.field private static final MIDDLE_BORDER:Ljava/lang/String; = "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504"

.field private static final MIDDLE_CORNER:Ljava/lang/String; = "\u251c"

.field private static final MIDDLE_DIVIDER:Ljava/lang/String; = "\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504"

.field private static final NOTHING:Ljava/lang/String; = "log nothing"

.field private static final NULL:Ljava/lang/String; = "null"

.field private static final PLACEHOLDER:Ljava/lang/String; = " "

.field private static final SIDE_DIVIDER:Ljava/lang/String; = "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

.field private static final T:[C

.field private static final TOP_BORDER:Ljava/lang/String; = "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

.field private static final TOP_CORNER:Ljava/lang/String; = "\u250c"

.field public static final V:I = 0x2

.field public static final W:I = 0x5

.field private static final XML:I = 0x30

.field private static simpleDateFormat:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/4 v0, 0x6

    new-array v0, v0, [C

    .line 76
    fill-array-data v0, :array_2e

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->T:[C

    const-string v0, "file.separator"

    .line 82
    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->FILE_SEP:Ljava/lang/String;

    const-string v0, "line.separator"

    .line 83
    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    .line 100
    new-instance v0, Lcom/blankj/utilcode/util/LogUtils$Config;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/blankj/utilcode/util/LogUtils$Config;-><init>(Lcom/blankj/utilcode/util/LogUtils$1;)V

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    .line 104
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    .line 106
    new-instance v0, Landroidx/collection/SimpleArrayMap;

    invoke-direct {v0}, Landroidx/collection/SimpleArrayMap;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->I_FORMATTER_MAP:Landroidx/collection/SimpleArrayMap;

    return-void

    :array_2e
    .array-data 2
        0x56s
        0x44s
        0x49s
        0x57s
        0x45s
        0x41s
    .end array-data
.end method

.method private constructor <init>()V
    .registers 3

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static varargs a([Ljava/lang/Object;)V
    .registers 3

    .line 157
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x7

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs aTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x7

    .line 161
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$1000()Ljava/lang/String;
    .registers 1

    .line 62
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->FILE_SEP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/blankj/utilcode/util/LogUtils$IFormatter;)Ljava/lang/Class;
    .registers 1

    .line 62
    invoke-static {p0}, Lcom/blankj/utilcode/util/LogUtils;->getTypeClassFromParadigm(Lcom/blankj/utilcode/util/LogUtils$IFormatter;)Ljava/lang/Class;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$1200()Landroidx/collection/SimpleArrayMap;
    .registers 1

    .line 62
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->I_FORMATTER_MAP:Landroidx/collection/SimpleArrayMap;

    return-object v0
.end method

.method static synthetic access$1300()[C
    .registers 1

    .line 62
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->T:[C

    return-object v0
.end method

.method static synthetic access$1400()Ljava/lang/String;
    .registers 1

    .line 62
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1500(Ljava/lang/Object;)Ljava/lang/String;
    .registers 1

    .line 62
    invoke-static {p0}, Lcom/blankj/utilcode/util/LogUtils;->formatObject(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static synthetic access$300(ILjava/lang/String;Ljava/lang/String;)V
    .registers 3

    .line 62
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2File(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Ljava/lang/String;)Z
    .registers 1

    .line 62
    invoke-static {p0}, Lcom/blankj/utilcode/util/LogUtils;->isMatchLogFileName(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method private static createOrExistsFile(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 5

    .line 537
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 538
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_10

    invoke-virtual {v0}, Ljava/io/File;->isFile()Z

    move-result p0

    return p0

    .line 539
    :cond_10
    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    invoke-static {v1}, Lcom/blankj/utilcode/util/UtilsBridge;->createOrExistsDir(Ljava/io/File;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_1c

    return v2

    .line 541
    :cond_1c
    :try_start_1c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->deleteDueLogs(Ljava/lang/String;Ljava/lang/String;)V

    .line 542
    invoke-virtual {v0}, Ljava/io/File;->createNewFile()Z

    move-result v0

    if-eqz v0, :cond_28

    .line 544
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->printDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_28
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_28} :catch_29

    :cond_28
    return v0

    :catch_29
    move-exception p0

    .line 548
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    return v2
.end method

.method public static varargs d([Ljava/lang/Object;)V
    .registers 3

    .line 125
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x3

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs dTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x3

    .line 129
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method private static deleteDueLogs(Ljava/lang/String;Ljava/lang/String;)V
    .registers 10

    .line 554
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getSaveDays()I

    move-result v1

    if-gtz v1, :cond_9

    return-void

    .line 555
    :cond_9
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 556
    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p0

    .line 557
    new-instance v1, Lcom/blankj/utilcode/util/LogUtils$3;

    invoke-direct {v1}, Lcom/blankj/utilcode/util/LogUtils$3;-><init>()V

    invoke-virtual {p0, v1}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_6c

    .line 563
    array-length v1, p0

    if-gtz v1, :cond_21

    goto :goto_6c

    .line 564
    :cond_21
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy_MM_dd"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 566
    :try_start_2c
    invoke-virtual {v1, p1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object p1

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getSaveDays()I

    move-result p1

    int-to-long v4, p1

    const-wide/32 v6, 0x5265c00

    mul-long/2addr v4, v6

    sub-long/2addr v2, v4

    .line 567
    array-length p1, p0

    const/4 v0, 0x0

    :goto_40
    if-ge v0, p1, :cond_6c

    aget-object v4, p0, v0

    .line 568
    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v5

    .line 569
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    .line 570
    invoke-static {v5}, Lcom/blankj/utilcode/util/LogUtils;->findDate(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 571
    invoke-virtual {v1, v5}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    cmp-long v5, v5, v2

    if-gtz v5, :cond_65

    .line 572
    sget-object v5, Lcom/blankj/utilcode/util/LogUtils;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    new-instance v6, Lcom/blankj/utilcode/util/LogUtils$4;

    invoke-direct {v6, v4}, Lcom/blankj/utilcode/util/LogUtils$4;-><init>(Ljava/io/File;)V

    invoke-interface {v5, v6}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    :try_end_65
    .catch Ljava/text/ParseException; {:try_start_2c .. :try_end_65} :catch_68

    :cond_65
    add-int/lit8 v0, v0, 0x1

    goto :goto_40

    :catch_68
    move-exception p0

    .line 584
    invoke-virtual {p0}, Ljava/text/ParseException;->printStackTrace()V

    :cond_6c
    :goto_6c
    return-void
.end method

.method public static varargs e([Ljava/lang/Object;)V
    .registers 3

    .line 149
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x6

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs eTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x6

    .line 153
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static file(ILjava/lang/Object;)V
    .registers 5

    or-int/lit8 p0, p0, 0x10

    .line 169
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static file(ILjava/lang/String;Ljava/lang/Object;)V
    .registers 5

    or-int/lit8 p0, p0, 0x10

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p2, v0, v1

    .line 177
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static file(Ljava/lang/Object;)V
    .registers 4

    .line 165
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/16 p0, 0x13

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static file(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/16 p1, 0x13

    .line 173
    invoke-static {p1, p0, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method private static findDate(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    const-string v0, "[0-9]{4}_[0-9]{2}_[0-9]{2}"

    .line 593
    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    .line 594
    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object p0

    .line 595
    invoke-virtual {p0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 596
    invoke-virtual {p0}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_15
    const-string p0, ""

    return-object p0
.end method

.method private static formatObject(ILjava/lang/Object;)Ljava/lang/String;
    .registers 3

    if-nez p1, :cond_5

    const-string p0, "null"

    return-object p0

    :cond_5
    const/16 v0, 0x20

    if-ne p0, v0, :cond_e

    .line 355
    invoke-static {p1, v0}, Lcom/blankj/utilcode/util/LogUtils$LogFormatter;->object2String(Ljava/lang/Object;I)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_e
    const/16 v0, 0x30

    if-ne p0, v0, :cond_17

    .line 356
    invoke-static {p1, v0}, Lcom/blankj/utilcode/util/LogUtils$LogFormatter;->object2String(Ljava/lang/Object;I)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 357
    :cond_17
    invoke-static {p1}, Lcom/blankj/utilcode/util/LogUtils;->formatObject(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static formatObject(Ljava/lang/Object;)Ljava/lang/String;
    .registers 3

    if-nez p0, :cond_5

    const-string p0, "null"

    return-object p0

    .line 362
    :cond_5
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->I_FORMATTER_MAP:Landroidx/collection/SimpleArrayMap;

    invoke-virtual {v0}, Landroidx/collection/SimpleArrayMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1e

    .line 363
    invoke-static {p0}, Lcom/blankj/utilcode/util/LogUtils;->getClassFromObject(Ljava/lang/Object;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/collection/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/LogUtils$IFormatter;

    if-eqz v0, :cond_1e

    .line 366
    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/LogUtils$IFormatter;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 369
    :cond_1e
    invoke-static {p0}, Lcom/blankj/utilcode/util/LogUtils$LogFormatter;->object2String(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static getClassFromObject(Ljava/lang/Object;)Ljava/lang/Class;
    .registers 4

    .line 1200
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    .line 1201
    invoke-virtual {p0}, Ljava/lang/Class;->isAnonymousClass()Z

    move-result v0

    if-nez v0, :cond_10

    invoke-virtual {p0}, Ljava/lang/Class;->isSynthetic()Z

    move-result v0

    if-eqz v0, :cond_63

    .line 1202
    :cond_10
    invoke-virtual {p0}, Ljava/lang/Class;->getGenericInterfaces()[Ljava/lang/reflect/Type;

    move-result-object v0

    .line 1204
    array-length v1, v0

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2b

    const/4 v1, 0x0

    .line 1205
    aget-object v0, v0, v1

    .line 1206
    :goto_1b
    instance-of v1, v0, Ljava/lang/reflect/ParameterizedType;

    if-eqz v1, :cond_26

    .line 1207
    check-cast v0, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {v0}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object v0

    goto :goto_1b

    .line 1209
    :cond_26
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_3e

    .line 1211
    :cond_2b
    invoke-virtual {p0}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object v0

    .line 1212
    :goto_2f
    instance-of v1, v0, Ljava/lang/reflect/ParameterizedType;

    if-eqz v1, :cond_3a

    .line 1213
    check-cast v0, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {v0}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object v0

    goto :goto_2f

    .line 1215
    :cond_3a
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_3e
    const-string v1, "class "

    .line 1218
    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4c

    const/4 v1, 0x6

    .line 1219
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_5a

    :cond_4c
    const-string v1, "interface "

    .line 1220
    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5a

    const/16 v1, 0xa

    .line 1221
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 1224
    :cond_5a
    :goto_5a
    :try_start_5a
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object p0
    :try_end_5e
    .catch Ljava/lang/ClassNotFoundException; {:try_start_5a .. :try_end_5e} :catch_5f

    return-object p0

    :catch_5f
    move-exception v0

    .line 1226
    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->printStackTrace()V

    :cond_63
    return-object p0
.end method

.method public static getConfig()Lcom/blankj/utilcode/util/LogUtils$Config;
    .registers 1

    .line 113
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    return-object v0
.end method

.method public static getCurrentLogFilePath()Ljava/lang/String;
    .registers 1

    .line 234
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils;->getCurrentLogFilePath(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getCurrentLogFilePath(Ljava/util/Date;)Ljava/lang/String;
    .registers 4

    .line 521
    invoke-static {}, Lcom/blankj/utilcode/util/LogUtils;->getSdf()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x0

    const/16 v1, 0xa

    .line 522
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 523
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->getDir()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->getFilePrefix()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "_"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    .line 525
    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->getProcessName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->getFileExtension()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static getFileName(Ljava/lang/StackTraceElement;)Ljava/lang/String;
    .registers 3

    .line 314
    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    return-object v0

    .line 318
    :cond_7
    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object p0

    const-string v0, "\\."

    .line 319
    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 320
    array-length v1, v0

    if-lez v1, :cond_19

    .line 321
    array-length p0, v0

    add-int/lit8 p0, p0, -0x1

    aget-object p0, v0, p0

    :cond_19
    const/16 v0, 0x24

    .line 323
    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_27

    const/4 v1, 0x0

    .line 325
    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 327
    :cond_27
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v0, ".java"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getLogFiles()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    .line 238
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getDir()Ljava/lang/String;

    move-result-object v0

    .line 239
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 240
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_17

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0

    .line 241
    :cond_17
    new-instance v0, Lcom/blankj/utilcode/util/LogUtils$2;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/LogUtils$2;-><init>()V

    invoke-virtual {v1, v0}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    .line 247
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 248
    invoke-static {v1, v0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    return-object v1
.end method

.method private static getSdf()Ljava/text/SimpleDateFormat;
    .registers 3

    .line 530
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->simpleDateFormat:Ljava/text/SimpleDateFormat;

    if-nez v0, :cond_11

    .line 531
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy_MM_dd HH:mm:ss.SSS "

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Lcom/blankj/utilcode/util/LogUtils;->simpleDateFormat:Ljava/text/SimpleDateFormat;

    .line 533
    :cond_11
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->simpleDateFormat:Ljava/text/SimpleDateFormat;

    return-object v0
.end method

.method private static getTypeClassFromParadigm(Lcom/blankj/utilcode/util/LogUtils$IFormatter;)Ljava/lang/Class;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/blankj/utilcode/util/LogUtils$IFormatter<",
            "TT;>;)",
            "Ljava/lang/Class;"
        }
    .end annotation

    .line 1174
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getGenericInterfaces()[Ljava/lang/reflect/Type;

    move-result-object v0

    .line 1176
    array-length v1, v0

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne v1, v2, :cond_10

    .line 1177
    aget-object p0, v0, v3

    goto :goto_18

    .line 1179
    :cond_10
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getGenericSuperclass()Ljava/lang/reflect/Type;

    move-result-object p0

    .line 1181
    :goto_18
    check-cast p0, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {p0}, Ljava/lang/reflect/ParameterizedType;->getActualTypeArguments()[Ljava/lang/reflect/Type;

    move-result-object p0

    aget-object p0, p0, v3

    .line 1182
    :goto_20
    instance-of v0, p0, Ljava/lang/reflect/ParameterizedType;

    if-eqz v0, :cond_2b

    .line 1183
    check-cast p0, Ljava/lang/reflect/ParameterizedType;

    invoke-interface {p0}, Ljava/lang/reflect/ParameterizedType;->getRawType()Ljava/lang/reflect/Type;

    move-result-object p0

    goto :goto_20

    .line 1185
    :cond_2b
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    const-string v0, "class "

    .line 1186
    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3d

    const/4 v0, 0x6

    .line 1187
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    goto :goto_4b

    :cond_3d
    const-string v0, "interface "

    .line 1188
    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4b

    const/16 v0, 0xa

    .line 1189
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 1192
    :cond_4b
    :goto_4b
    :try_start_4b
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object p0
    :try_end_4f
    .catch Ljava/lang/ClassNotFoundException; {:try_start_4b .. :try_end_4f} :catch_50

    return-object p0

    :catch_50
    move-exception p0

    .line 1194
    invoke-virtual {p0}, Ljava/lang/ClassNotFoundException;->printStackTrace()V

    const/4 p0, 0x0

    return-object p0
.end method

.method public static varargs i([Ljava/lang/Object;)V
    .registers 3

    .line 133
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs iTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x4

    .line 137
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method private static input2File(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    .line 607
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileWriter:Lcom/blankj/utilcode/util/LogUtils$IFileWriter;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$800(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$IFileWriter;

    move-result-object v1

    if-nez v1, :cond_d

    const/4 v1, 0x1

    .line 608
    invoke-static {p0, p1, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->writeFileFromString(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto :goto_14

    .line 610
    :cond_d
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileWriter:Lcom/blankj/utilcode/util/LogUtils$IFileWriter;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$800(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$IFileWriter;

    move-result-object v1

    invoke-interface {v1, p0, p1}, Lcom/blankj/utilcode/util/LogUtils$IFileWriter;->write(Ljava/lang/String;Ljava/lang/String;)V

    .line 612
    :goto_14
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mOnFileOutputListener:Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$900(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;

    move-result-object v1

    if-eqz v1, :cond_21

    .line 613
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mOnFileOutputListener:Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$900(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;

    move-result-object v0

    invoke-interface {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils$OnFileOutputListener;->onFileOutput(Ljava/lang/String;Ljava/lang/String;)V

    :cond_21
    return-void
.end method

.method private static isMatchLogFileName(Ljava/lang/String;)Z
    .registers 3

    .line 589
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "^"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->getFilePrefix()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static json(ILjava/lang/Object;)V
    .registers 5

    or-int/lit8 p0, p0, 0x20

    .line 185
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static json(ILjava/lang/String;Ljava/lang/Object;)V
    .registers 5

    or-int/lit8 p0, p0, 0x20

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p2, v0, v1

    .line 193
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static json(Ljava/lang/Object;)V
    .registers 4

    .line 181
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/16 p0, 0x23

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static json(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/16 p1, 0x23

    .line 189
    invoke-static {p1, p0, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs log(ILjava/lang/String;[Ljava/lang/Object;)V
    .registers 8

    .line 213
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogSwitch()Z

    move-result v1

    if-nez v1, :cond_9

    return-void

    :cond_9
    and-int/lit8 v1, p0, 0xf

    and-int/lit16 p0, p0, 0xf0

    .line 215
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLog2ConsoleSwitch()Z

    move-result v2

    const/16 v3, 0x10

    if-nez v2, :cond_1d

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLog2FileSwitch()Z

    move-result v2

    if-nez v2, :cond_1d

    if-ne p0, v3, :cond_5f

    .line 216
    :cond_1d
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mConsoleFilter:I
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$100(Lcom/blankj/utilcode/util/LogUtils$Config;)I

    move-result v2

    if-ge v1, v2, :cond_2a

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileFilter:I
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$200(Lcom/blankj/utilcode/util/LogUtils$Config;)I

    move-result v2

    if-ge v1, v2, :cond_2a

    return-void

    .line 217
    :cond_2a
    invoke-static {p1}, Lcom/blankj/utilcode/util/LogUtils;->processTagAndHead(Ljava/lang/String;)Lcom/blankj/utilcode/util/LogUtils$TagHead;

    move-result-object p1

    .line 218
    invoke-static {p0, p2}, Lcom/blankj/utilcode/util/LogUtils;->processBody(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    .line 219
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLog2ConsoleSwitch()Z

    move-result v2

    if-eqz v2, :cond_47

    if-eq p0, v3, :cond_47

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mConsoleFilter:I
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$100(Lcom/blankj/utilcode/util/LogUtils$Config;)I

    move-result v2

    if-lt v1, v2, :cond_47

    .line 220
    iget-object v2, p1, Lcom/blankj/utilcode/util/LogUtils$TagHead;->tag:Ljava/lang/String;

    iget-object v4, p1, Lcom/blankj/utilcode/util/LogUtils$TagHead;->consoleHead:[Ljava/lang/String;

    invoke-static {v1, v2, v4, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 222
    :cond_47
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLog2FileSwitch()Z

    move-result v2

    if-nez v2, :cond_4f

    if-ne p0, v3, :cond_5f

    :cond_4f
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileFilter:I
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$200(Lcom/blankj/utilcode/util/LogUtils$Config;)I

    move-result p0

    if-lt v1, p0, :cond_5f

    .line 223
    sget-object p0, Lcom/blankj/utilcode/util/LogUtils;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    new-instance v0, Lcom/blankj/utilcode/util/LogUtils$1;

    invoke-direct {v0, v1, p1, p2}, Lcom/blankj/utilcode/util/LogUtils$1;-><init>(ILcom/blankj/utilcode/util/LogUtils$TagHead;Ljava/lang/String;)V

    invoke-interface {p0, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    :cond_5f
    return-void
.end method

.method private static print2Console(ILjava/lang/String;Ljava/lang/String;)V
    .registers 5

    .line 495
    invoke-static {p0, p1, p2}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I

    .line 496
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mOnConsoleOutputListener:Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$600(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;

    move-result-object v1

    if-eqz v1, :cond_12

    .line 497
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mOnConsoleOutputListener:Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$600(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;

    move-result-object v0

    invoke-interface {v0, p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils$OnConsoleOutputListener;->onConsoleOutput(ILjava/lang/String;Ljava/lang/String;)V

    :cond_12
    return-void
.end method

.method private static print2Console(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .registers 5

    .line 376
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isSingleTagSwitch()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 377
    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/LogUtils;->processSingleTagMsg(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->printSingleTagMsg(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1e

    :cond_10
    const/4 v0, 0x1

    .line 379
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/LogUtils;->printBorder(ILjava/lang/String;Z)V

    .line 380
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->printHead(ILjava/lang/String;[Ljava/lang/String;)V

    .line 381
    invoke-static {p0, p1, p3}, Lcom/blankj/utilcode/util/LogUtils;->printMsg(ILjava/lang/String;Ljava/lang/String;)V

    const/4 p2, 0x0

    .line 382
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->printBorder(ILjava/lang/String;Z)V

    :goto_1e
    return-void
.end method

.method private static print2File(ILjava/lang/String;Ljava/lang/String;)V
    .registers 7

    .line 502
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 503
    invoke-static {}, Lcom/blankj/utilcode/util/LogUtils;->getSdf()Ljava/text/SimpleDateFormat;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    const/16 v3, 0xa

    .line 504
    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 505
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils;->getCurrentLogFilePath(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 506
    invoke-static {v0, v2}, Lcom/blankj/utilcode/util/LogUtils;->createOrExistsFile(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_39

    .line 507
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "create "

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, " failed!"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string p1, "LogUtils"

    invoke-static {p1, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_39
    const/16 v2, 0xb

    .line 510
    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 511
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/blankj/utilcode/util/LogUtils;->T:[C

    add-int/lit8 p0, p0, -0x2

    aget-char p0, v2, p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v1, "/"

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    sget-object p1, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 517
    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->input2File(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static printBorder(ILjava/lang/String;Z)V
    .registers 4

    .line 387
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result v0

    if-eqz v0, :cond_12

    if-eqz p2, :cond_d

    const-string p2, "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    goto :goto_f

    :cond_d
    const-string p2, "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    .line 388
    :goto_f
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    :cond_12
    return-void
.end method

.method private static printDeviceInfo(Ljava/lang/String;Ljava/lang/String;)V
    .registers 5

    .line 602
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileHead:Lcom/blankj/utilcode/util/UtilsBridge$FileHead;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$700(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/UtilsBridge$FileHead;

    move-result-object v1

    const-string v2, "Date of Log"

    invoke-virtual {v1, v2, p1}, Lcom/blankj/utilcode/util/UtilsBridge$FileHead;->addFirst(Ljava/lang/String;Ljava/lang/String;)V

    .line 603
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mFileHead:Lcom/blankj/utilcode/util/UtilsBridge$FileHead;
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$700(Lcom/blankj/utilcode/util/LogUtils$Config;)Lcom/blankj/utilcode/util/UtilsBridge$FileHead;

    move-result-object p1

    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UtilsBridge$FileHead;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->input2File(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static printHead(ILjava/lang/String;[Ljava/lang/String;)V
    .registers 8

    if-eqz p2, :cond_32

    .line 394
    array-length v0, p2

    const/4 v1, 0x0

    :goto_4
    if-ge v1, v0, :cond_25

    aget-object v2, p2, v1

    .line 395
    sget-object v3, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v3}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result v3

    if-eqz v3, :cond_1f

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u2502 "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :cond_1f
    invoke-static {p0, p1, v2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 397
    :cond_25
    sget-object p2, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {p2}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result p2

    if-eqz p2, :cond_32

    const-string p2, "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504"

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    :cond_32
    return-void
.end method

.method private static printMsg(ILjava/lang/String;Ljava/lang/String;)V
    .registers 8

    .line 402
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    .line 403
    div-int/lit16 v1, v0, 0x44c

    if-lez v1, :cond_23

    const/4 v2, 0x0

    move v3, v2

    :goto_a
    if-ge v2, v1, :cond_19

    add-int/lit16 v4, v3, 0x44c

    .line 407
    invoke-virtual {p2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, p1, v3}, Lcom/blankj/utilcode/util/LogUtils;->printSubMsg(ILjava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v2, v2, 0x1

    move v3, v4

    goto :goto_a

    :cond_19
    if-eq v3, v0, :cond_26

    .line 411
    invoke-virtual {p2, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p2

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->printSubMsg(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_26

    .line 414
    :cond_23
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->printSubMsg(ILjava/lang/String;Ljava/lang/String;)V

    :cond_26
    :goto_26
    return-void
.end method

.method private static printSingleTagMsg(ILjava/lang/String;Ljava/lang/String;)V
    .registers 13

    .line 461
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    .line 462
    sget-object v1, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result v2

    const/16 v3, 0x44c

    if-eqz v2, :cond_12

    add-int/lit8 v2, v0, -0x71

    div-int/2addr v2, v3

    goto :goto_14

    :cond_12
    div-int/lit16 v2, v0, 0x44c

    :goto_14
    if-lez v2, :cond_eb

    .line 464
    invoke-virtual {v1}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result v1

    const/4 v4, 0x0

    const-string v5, " "

    const/4 v6, 0x1

    if-eqz v1, :cond_a5

    .line 465
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v4, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    :goto_40
    const-string v1, "\u2502 "

    const-string v7, "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    if-ge v6, v2, :cond_7a

    .line 468
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v9, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit16 v7, v3, 0x44c

    .line 469
    invoke-virtual {p2, v3, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 468
    invoke-static {p0, p1, v1}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v6, v6, 0x1

    move v3, v7

    goto :goto_40

    :cond_7a
    add-int/lit8 v2, v0, -0x71

    if-eq v3, v2, :cond_ee

    .line 474
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 475
    invoke-virtual {p2, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 474
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_ee

    .line 478
    :cond_a5
    invoke-virtual {p2, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    :goto_ac
    if-ge v6, v2, :cond_ce

    .line 481
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v4, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit16 v4, v3, 0x44c

    .line 482
    invoke-virtual {p2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 481
    invoke-static {p0, p1, v1}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v6, v6, 0x1

    move v3, v4

    goto :goto_ac

    :cond_ce
    if-eq v3, v0, :cond_ee

    .line 486
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_ee

    .line 490
    :cond_eb
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    :cond_ee
    :goto_ee
    return-void
.end method

.method private static printSubMsg(ILjava/lang/String;Ljava/lang/String;)V
    .registers 8

    .line 419
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result v0

    if-nez v0, :cond_c

    .line 420
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    return-void

    .line 424
    :cond_c
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p2

    .line 425
    array-length v0, p2

    const/4 v1, 0x0

    :goto_14
    if-ge v1, v0, :cond_2d

    aget-object v2, p2, v1

    .line 426
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u2502 "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, p1, v2}, Lcom/blankj/utilcode/util/LogUtils;->print2Console(ILjava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_14

    :cond_2d
    return-void
.end method

.method private static varargs processBody(I[Ljava/lang/Object;)Ljava/lang/String;
    .registers 7

    if-eqz p1, :cond_3d

    .line 333
    array-length v0, p1

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_e

    .line 334
    aget-object p1, p1, v1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->formatObject(ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    goto :goto_3f

    .line 336
    :cond_e
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    .line 337
    array-length v0, p1

    :goto_14
    if-ge v1, v0, :cond_38

    .line 338
    aget-object v2, p1, v1

    const-string v3, "args["

    .line 339
    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 341
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] = "

    .line 342
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 344
    invoke-static {v2}, Lcom/blankj/utilcode/util/LogUtils;->formatObject(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    .line 345
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_14

    .line 347
    :cond_38
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_3f

    :cond_3d
    const-string p0, "null"

    .line 350
    :goto_3f
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p1

    if-nez p1, :cond_47

    const-string p0, "log nothing"

    :cond_47
    return-object p0
.end method

.method private static processSingleTagMsg(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 9

    .line 434
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    .line 435
    sget-object p1, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {p1}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogBorderSwitch()Z

    move-result p1

    const-string v0, " "

    const/4 v1, 0x0

    if-eqz p1, :cond_68

    .line 436
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    .line 437
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "\u2502 "

    if-eqz p2, :cond_47

    .line 439
    array-length v0, p2

    move v2, v1

    :goto_28
    if-ge v2, v0, :cond_3c

    aget-object v3, p2, v2

    .line 440
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, 0x1

    goto :goto_28

    :cond_3c
    const-string p2, "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504"

    .line 442
    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 444
    :cond_47
    sget-object p2, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p3, p2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p2

    array-length p3, p2

    :goto_4e
    if-ge v1, p3, :cond_62

    aget-object v0, p2, v1

    .line 445
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_4e

    :cond_62
    const-string p1, "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500"

    .line 447
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_87

    :cond_68
    if-eqz p2, :cond_84

    .line 450
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 451
    array-length p1, p2

    :goto_74
    if-ge v1, p1, :cond_84

    aget-object v0, p2, v1

    .line 452
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcom/blankj/utilcode/util/LogUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_74

    .line 455
    :cond_84
    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 457
    :goto_87
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static processTagAndHead(Ljava/lang/String;)Lcom/blankj/utilcode/util/LogUtils$TagHead;
    .registers 18

    .line 253
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mTagIsSpace:Z
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$500(Lcom/blankj/utilcode/util/LogUtils$Config;)Z

    move-result v1

    const-string v2, ": "

    const/4 v3, 0x0

    if-nez v1, :cond_17

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogHeadSwitch()Z

    move-result v1

    if-nez v1, :cond_17

    .line 254
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_158

    .line 256
    :cond_17
    new-instance v1, Ljava/lang/Throwable;

    invoke-direct {v1}, Ljava/lang/Throwable;-><init>()V

    invoke-virtual {v1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    .line 257
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getStackOffset()I

    move-result v4

    const/4 v5, 0x3

    add-int/2addr v4, v5

    .line 258
    array-length v6, v1

    const/4 v7, -0x1

    const/16 v8, 0x2e

    const/4 v9, 0x0

    if-lt v4, v6, :cond_54

    .line 259
    aget-object v1, v1, v5

    .line 260
    invoke-static {v1}, Lcom/blankj/utilcode/util/LogUtils;->getFileName(Ljava/lang/StackTraceElement;)Ljava/lang/String;

    move-result-object v1

    .line 261
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mTagIsSpace:Z
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$500(Lcom/blankj/utilcode/util/LogUtils$Config;)Z

    move-result v0

    if-eqz v0, :cond_4c

    invoke-static/range {p0 .. p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4c

    .line 262
    invoke-virtual {v1, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ne v0, v7, :cond_47

    move-object v0, v1

    goto :goto_4e

    .line 263
    :cond_47
    invoke-virtual {v1, v9, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_4e

    :cond_4c
    move-object/from16 v0, p0

    .line 265
    :goto_4e
    new-instance v1, Lcom/blankj/utilcode/util/LogUtils$TagHead;

    invoke-direct {v1, v0, v3, v2}, Lcom/blankj/utilcode/util/LogUtils$TagHead;-><init>(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v1

    .line 267
    :cond_54
    aget-object v6, v1, v4

    .line 268
    invoke-static {v6}, Lcom/blankj/utilcode/util/LogUtils;->getFileName(Ljava/lang/StackTraceElement;)Ljava/lang/String;

    move-result-object v10

    .line 269
    # getter for: Lcom/blankj/utilcode/util/LogUtils$Config;->mTagIsSpace:Z
    invoke-static {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->access$500(Lcom/blankj/utilcode/util/LogUtils$Config;)Z

    move-result v11

    if-eqz v11, :cond_73

    invoke-static/range {p0 .. p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_73

    .line 270
    invoke-virtual {v10, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v8

    if-ne v8, v7, :cond_6e

    move-object v7, v10

    goto :goto_75

    .line 271
    :cond_6e
    invoke-virtual {v10, v9, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    goto :goto_75

    :cond_73
    move-object/from16 v7, p0

    .line 273
    :goto_75
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->isLogHeadSwitch()Z

    move-result v8

    if-eqz v8, :cond_157

    .line 274
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    .line 275
    new-instance v3, Ljava/util/Formatter;

    invoke-direct {v3}, Ljava/util/Formatter;-><init>()V

    const/4 v8, 0x5

    new-array v11, v8, [Ljava/lang/Object;

    aput-object v2, v11, v9

    .line 278
    invoke-virtual {v6}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x1

    aput-object v12, v11, v13

    .line 279
    invoke-virtual {v6}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v12

    const/4 v14, 0x2

    aput-object v12, v11, v14

    aput-object v10, v11, v5

    .line 281
    invoke-virtual {v6}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    const/4 v10, 0x4

    aput-object v6, v11, v10

    const-string v6, "%s, %s.%s(%s:%d)"

    .line 276
    invoke-virtual {v3, v6, v11}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v3

    .line 282
    invoke-virtual {v3}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v3

    .line 283
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v11, " ["

    invoke-direct {v6, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v11, "]: "

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 284
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getStackDeep()I

    move-result v11

    if-gt v11, v13, :cond_d7

    .line 285
    new-instance v0, Lcom/blankj/utilcode/util/LogUtils$TagHead;

    new-array v1, v13, [Ljava/lang/String;

    aput-object v3, v1, v9

    invoke-direct {v0, v7, v1, v6}, Lcom/blankj/utilcode/util/LogUtils$TagHead;-><init>(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 289
    :cond_d7
    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getStackDeep()I

    move-result v0

    array-length v11, v1

    sub-int/2addr v11, v4

    .line 288
    invoke-static {v0, v11}, Ljava/lang/Math;->min(II)I

    move-result v0

    new-array v11, v0, [Ljava/lang/String;

    .line 292
    aput-object v3, v11, v9

    .line 293
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v14

    .line 294
    new-instance v3, Ljava/util/Formatter;

    invoke-direct {v3}, Ljava/util/Formatter;-><init>()V

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v15, "%"

    invoke-direct {v12, v15}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v12, "s"

    invoke-virtual {v2, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v12, v13, [Ljava/lang/Object;

    const-string v15, ""

    aput-object v15, v12, v9

    invoke-virtual {v3, v2, v12}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v2

    move v3, v13

    :goto_113
    if-ge v3, v0, :cond_151

    add-int v12, v3, v4

    .line 296
    aget-object v12, v1, v12

    .line 297
    new-instance v15, Ljava/util/Formatter;

    invoke-direct {v15}, Ljava/util/Formatter;-><init>()V

    new-array v10, v8, [Ljava/lang/Object;

    aput-object v2, v10, v9

    .line 300
    invoke-virtual {v12}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v10, v13

    .line 301
    invoke-virtual {v12}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v10, v14

    .line 302
    invoke-static {v12}, Lcom/blankj/utilcode/util/LogUtils;->getFileName(Ljava/lang/StackTraceElement;)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v10, v5

    .line 303
    invoke-virtual {v12}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    const/16 v16, 0x4

    aput-object v12, v10, v16

    const-string v12, "%s%s.%s(%s:%d)"

    .line 298
    invoke-virtual {v15, v12, v10}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    move-result-object v10

    .line 304
    invoke-virtual {v10}, Ljava/util/Formatter;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v11, v3

    add-int/lit8 v3, v3, 0x1

    move/from16 v10, v16

    goto :goto_113

    .line 306
    :cond_151
    new-instance v0, Lcom/blankj/utilcode/util/LogUtils$TagHead;

    invoke-direct {v0, v7, v11, v6}, Lcom/blankj/utilcode/util/LogUtils$TagHead;-><init>(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    :cond_157
    move-object v0, v7

    .line 310
    :goto_158
    new-instance v1, Lcom/blankj/utilcode/util/LogUtils$TagHead;

    invoke-direct {v1, v0, v3, v2}, Lcom/blankj/utilcode/util/LogUtils$TagHead;-><init>(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v1
.end method

.method public static varargs v([Ljava/lang/Object;)V
    .registers 3

    .line 117
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs vTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x2

    .line 121
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs w([Ljava/lang/Object;)V
    .registers 3

    .line 141
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x5

    invoke-static {v1, v0, p0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static varargs wTag(Ljava/lang/String;[Ljava/lang/Object;)V
    .registers 3

    const/4 v0, 0x5

    .line 145
    invoke-static {v0, p0, p1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static xml(ILjava/lang/String;)V
    .registers 5

    or-int/lit8 p0, p0, 0x30

    .line 201
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static xml(ILjava/lang/String;Ljava/lang/String;)V
    .registers 5

    or-int/lit8 p0, p0, 0x30

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p2, v0, v1

    .line 209
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static xml(Ljava/lang/String;)V
    .registers 4

    .line 197
    sget-object v0, Lcom/blankj/utilcode/util/LogUtils;->CONFIG:Lcom/blankj/utilcode/util/LogUtils$Config;

    invoke-virtual {v0}, Lcom/blankj/utilcode/util/LogUtils$Config;->getGlobalTag()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/16 p0, 0x33

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method public static xml(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/16 p1, 0x33

    .line 205
    invoke-static {p1, p0, v0}, Lcom/blankj/utilcode/util/LogUtils;->log(ILjava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method
