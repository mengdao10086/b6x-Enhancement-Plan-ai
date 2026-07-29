.class public final Lcom/blankj/utilcode/util/TimeUtils;
.super Ljava/lang/Object;
.source "TimeUtils.java"


# static fields
.field private static final CHINESE_ZODIAC:[Ljava/lang/String;

.field private static final SDF_THREAD_LOCAL:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/text/SimpleDateFormat;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final ZODIAC:[Ljava/lang/String;

.field private static final ZODIAC_FLAGS:[I


# direct methods
.method static constructor <clinit>()V
    .registers 13

    new-instance v0, Lcom/blankj/utilcode/util/TimeUtils$1;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/TimeUtils$1;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/TimeUtils;->SDF_THREAD_LOCAL:Ljava/lang/ThreadLocal;

    const-string v1, "\u7334"

    const-string v2, "\u9e21"

    const-string v3, "\u72d7"

    const-string v4, "\u732a"

    const-string v5, "\u9f20"

    const-string v6, "\u725b"

    const-string v7, "\u864e"

    const-string v8, "\u5154"

    const-string v9, "\u9f99"

    const-string v10, "\u86c7"

    const-string v11, "\u9a6c"

    const-string v12, "\u7f8a"

    filled-new-array/range {v1 .. v12}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/TimeUtils;->CHINESE_ZODIAC:[Ljava/lang/String;

    const/16 v0, 0xc

    new-array v0, v0, [I

    fill-array-data v0, :array_4e

    sput-object v0, Lcom/blankj/utilcode/util/TimeUtils;->ZODIAC_FLAGS:[I

    const-string v1, "\u6c34\u74f6\u5ea7"

    const-string v2, "\u53cc\u9c7c\u5ea7"

    const-string v3, "\u767d\u7f8a\u5ea7"

    const-string v4, "\u91d1\u725b\u5ea7"

    const-string v5, "\u53cc\u5b50\u5ea7"

    const-string v6, "\u5de8\u87f9\u5ea7"

    const-string v7, "\u72ee\u5b50\u5ea7"

    const-string v8, "\u5904\u5973\u5ea7"

    const-string v9, "\u5929\u79e4\u5ea7"

    const-string v10, "\u5929\u874e\u5ea7"

    const-string v11, "\u5c04\u624b\u5ea7"

    const-string v12, "\u6469\u7faf\u5ea7"

    filled-new-array/range {v1 .. v12}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/TimeUtils;->ZODIAC:[Ljava/lang/String;

    return-void

    nop

    :array_4e
    .array-data 4
        0x14
        0x13
        0x15
        0x15
        0x15
        0x16
        0x17
        0x17
        0x17
        0x18
        0x17
        0x16
    .end array-data
.end method

.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static date2Millis(Ljava/util/Date;)J
    .registers 3

    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    return-wide v0
.end method

.method public static date2String(Ljava/util/Date;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->date2String(Ljava/util/Date;Ljava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static date2String(Ljava/util/Date;Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object p1

    invoke-virtual {p1, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static date2String(Ljava/util/Date;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-virtual {p1, p0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseWeek(J)Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseWeek(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseWeek(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseWeek(Ljava/util/Date;)Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "E"

    sget-object v2, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-virtual {v0, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseZodiac(I)Ljava/lang/String;
    .registers 2

    sget-object v0, Lcom/blankj/utilcode/util/TimeUtils;->CHINESE_ZODIAC:[Ljava/lang/String;

    rem-int/lit8 p0, p0, 0xc

    aget-object p0, v0, p0

    return-object p0
.end method

.method public static getChineseZodiac(J)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseZodiac(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseZodiac(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getChineseZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getChineseZodiac(Ljava/util/Date;)Ljava/lang/String;
    .registers 3

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    sget-object p0, Lcom/blankj/utilcode/util/TimeUtils;->CHINESE_ZODIAC:[Ljava/lang/String;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    rem-int/lit8 v0, v0, 0xc

    aget-object p0, p0, v0

    return-object p0
.end method

.method public static getDate(JJI)Ljava/util/Date;
    .registers 5

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr p0, p2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static getDate(Ljava/lang/String;JI)Ljava/util/Date;
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->getDate(Ljava/lang/String;Ljava/text/DateFormat;JI)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static getDate(Ljava/lang/String;Ljava/text/DateFormat;JI)Ljava/util/Date;
    .registers 5

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr p0, p2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static getDate(Ljava/util/Date;JI)Ljava/util/Date;
    .registers 6

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide v0

    invoke-static {p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p0

    add-long/2addr v0, p0

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static getDateByNow(JI)Ljava/util/Date;
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowMills()J

    move-result-wide v0

    invoke-static {v0, v1, p0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getDate(JJI)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method private static getDefaultFormat()Ljava/text/SimpleDateFormat;
    .registers 1

    const-string v0, "yyyy-MM-dd HH:mm:ss"

    invoke-static {v0}, Lcom/blankj/utilcode/util/TimeUtils;->getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object v0

    return-object v0
.end method

.method public static getFitTimeSpan(JJI)Ljava/lang/String;
    .registers 5

    sub-long/2addr p0, p2

    invoke-static {p0, p1, p4}, Lcom/blankj/utilcode/util/TimeUtils;->millis2FitTimeSpan(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpan(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object p0

    invoke-static {p1, p0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    sub-long/2addr v0, p0

    invoke-static {v0, v1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2FitTimeSpan(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)Ljava/lang/String;
    .registers 6

    invoke-static {p0, p2}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    invoke-static {p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    sub-long/2addr v0, p0

    invoke-static {v0, v1, p3}, Lcom/blankj/utilcode/util/TimeUtils;->millis2FitTimeSpan(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpan(Ljava/util/Date;Ljava/util/Date;I)Ljava/lang/String;
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide v0

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide p0

    sub-long/2addr v0, p0

    invoke-static {v0, v1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2FitTimeSpan(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpanByNow(JI)Ljava/lang/String;
    .registers 5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {p0, p1, v0, v1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getFitTimeSpan(JJI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpanByNow(Ljava/lang/String;I)Ljava/lang/String;
    .registers 4

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowString()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v1

    invoke-static {p0, v0, v1, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getFitTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpanByNow(Ljava/lang/String;Ljava/text/DateFormat;I)Ljava/lang/String;
    .registers 4

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->getNowString(Ljava/text/DateFormat;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getFitTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFitTimeSpanByNow(Ljava/util/Date;I)Ljava/lang/String;
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowDate()Ljava/util/Date;

    move-result-object v0

    invoke-static {p0, v0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getFitTimeSpan(Ljava/util/Date;Ljava/util/Date;I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFriendlyTimeSpanByNow(J)Ljava/lang/String;
    .registers 11

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sub-long/2addr v0, p0

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-gez v2, :cond_1c

    new-array v0, v4, [Ljava/lang/Object;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v0, v3

    const-string p0, "%tc"

    invoke-static {p0, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1c
    const-wide/16 v5, 0x3e8

    cmp-long v2, v0, v5

    if-gez v2, :cond_25

    const-string p0, "\u521a\u521a"

    return-object p0

    :cond_25
    const-wide/32 v7, 0xea60

    cmp-long v2, v0, v7

    if-gez v2, :cond_40

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p0

    new-array p1, v4, [Ljava/lang/Object;

    div-long/2addr v0, v5

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, p1, v3

    const-string v0, "%d\u79d2\u524d"

    invoke-static {p0, v0, p1}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_40
    const-wide/32 v5, 0x36ee80

    cmp-long v2, v0, v5

    if-gez v2, :cond_5b

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p0

    new-array p1, v4, [Ljava/lang/Object;

    div-long/2addr v0, v7

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    aput-object v0, p1, v3

    const-string v0, "%d\u5206\u949f\u524d"

    invoke-static {p0, v0, p1}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_5b
    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getWeeOfToday()J

    move-result-wide v0

    cmp-long v2, p0, v0

    if-ltz v2, :cond_72

    new-array v0, v4, [Ljava/lang/Object;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v0, v3

    const-string p0, "\u4eca\u5929%tR"

    invoke-static {p0, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_72
    const-wide/32 v5, 0x5265c00

    sub-long/2addr v0, v5

    cmp-long v0, p0, v0

    if-ltz v0, :cond_89

    new-array v0, v4, [Ljava/lang/Object;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v0, v3

    const-string p0, "\u6628\u5929%tR"

    invoke-static {p0, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_89
    new-array v0, v4, [Ljava/lang/Object;

    invoke-static {p0, p1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v0, v3

    const-string p0, "%tF"

    invoke-static {p0, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFriendlyTimeSpanByNow(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->getFriendlyTimeSpanByNow(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFriendlyTimeSpanByNow(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getFriendlyTimeSpanByNow(J)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFriendlyTimeSpanByNow(Ljava/util/Date;)Ljava/lang/String;
    .registers 3

    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/TimeUtils;->getFriendlyTimeSpanByNow(J)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getMillis(JJI)J
    .registers 5

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr p0, p2

    return-wide p0
.end method

.method public static getMillis(Ljava/lang/String;JI)J
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->getMillis(Ljava/lang/String;Ljava/text/DateFormat;JI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getMillis(Ljava/lang/String;Ljava/text/DateFormat;JI)J
    .registers 5

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr p0, p2

    return-wide p0
.end method

.method public static getMillis(Ljava/util/Date;JI)J
    .registers 6

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide v0

    invoke-static {p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p0

    add-long/2addr v0, p0

    return-wide v0
.end method

.method public static getMillisByNow(JI)J
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowMills()J

    move-result-wide v0

    invoke-static {v0, v1, p0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getMillis(JJI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getNowDate()Ljava/util/Date;
    .registers 1

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    return-object v0
.end method

.method public static getNowMills()J
    .registers 2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public static getNowString()Ljava/lang/String;
    .registers 3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getNowString(Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1, p0}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;
    .registers 3

    sget-object v0, Lcom/blankj/utilcode/util/TimeUtils;->SDF_THREAD_LOCAL:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/text/SimpleDateFormat;

    if-nez v1, :cond_18

    new-instance v1, Ljava/text/SimpleDateFormat;

    invoke-direct {v1, p0}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_18
    return-object v1
.end method

.method public static getString(JJI)Ljava/lang/String;
    .registers 11

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v2

    move-wide v0, p0

    move-wide v3, p2

    move v5, p4

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/TimeUtils;->getString(JLjava/text/DateFormat;JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(JLjava/text/DateFormat;JI)Ljava/lang/String;
    .registers 6

    invoke-static {p3, p4, p5}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p3

    add-long/2addr p0, p3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;JI)Ljava/lang/String;
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->getString(Ljava/lang/String;Ljava/text/DateFormat;JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Ljava/text/DateFormat;JI)Ljava/lang/String;
    .registers 7

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr v0, p2

    invoke-static {v0, v1, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/util/Date;JI)Ljava/lang/String;
    .registers 5

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0, p1, p2, p3}, Lcom/blankj/utilcode/util/TimeUtils;->getString(Ljava/util/Date;Ljava/text/DateFormat;JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/util/Date;Ljava/text/DateFormat;JI)Ljava/lang/String;
    .registers 7

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide v0

    invoke-static {p2, p3, p4}, Lcom/blankj/utilcode/util/TimeUtils;->timeSpan2Millis(JI)J

    move-result-wide p2

    add-long/2addr v0, p2

    invoke-static {v0, v1, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getStringByNow(JI)Ljava/lang/String;
    .registers 4

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getStringByNow(JLjava/text/DateFormat;I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getStringByNow(JLjava/text/DateFormat;I)Ljava/lang/String;
    .registers 10

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowMills()J

    move-result-wide v0

    move-object v2, p2

    move-wide v3, p0

    move v5, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/TimeUtils;->getString(JLjava/text/DateFormat;JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getTimeSpan(JJI)J
    .registers 5

    sub-long/2addr p0, p2

    invoke-static {p0, p1, p4}, Lcom/blankj/utilcode/util/TimeUtils;->millis2TimeSpan(JI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpan(Ljava/lang/String;Ljava/lang/String;I)J
    .registers 4

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)J
    .registers 6

    invoke-static {p0, p2}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    invoke-static {p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    sub-long/2addr v0, p0

    invoke-static {v0, v1, p3}, Lcom/blankj/utilcode/util/TimeUtils;->millis2TimeSpan(JI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpan(Ljava/util/Date;Ljava/util/Date;I)J
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide v0

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->date2Millis(Ljava/util/Date;)J

    move-result-wide p0

    sub-long/2addr v0, p0

    invoke-static {v0, v1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2TimeSpan(JI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpanByNow(JI)J
    .registers 5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {p0, p1, v0, v1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getTimeSpan(JJI)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpanByNow(Ljava/lang/String;I)J
    .registers 4

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getNowString()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v1

    invoke-static {p0, v0, v1, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpanByNow(Ljava/lang/String;Ljava/text/DateFormat;I)J
    .registers 4

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->getNowString(Ljava/text/DateFormat;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getTimeSpan(Ljava/lang/String;Ljava/lang/String;Ljava/text/DateFormat;I)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getTimeSpanByNow(Ljava/util/Date;I)J
    .registers 3

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-static {p0, v0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getTimeSpan(Ljava/util/Date;Ljava/util/Date;I)J

    move-result-wide p0

    return-wide p0
.end method

.method public static getUSWeek(J)Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/TimeUtils;->getUSWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getUSWeek(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getUSWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getUSWeek(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getUSWeek(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getUSWeek(Ljava/util/Date;)Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "EEEE"

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-virtual {v0, p0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getValueByCalendarField(I)I
    .registers 2

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->get(I)I

    move-result p0

    return p0
.end method

.method public static getValueByCalendarField(JI)I
    .registers 4

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    invoke-virtual {v0, p2}, Ljava/util/Calendar;->get(I)I

    move-result p0

    return p0
.end method

.method public static getValueByCalendarField(Ljava/lang/String;I)I
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(Ljava/util/Date;I)I

    move-result p0

    return p0
.end method

.method public static getValueByCalendarField(Ljava/lang/String;Ljava/text/DateFormat;I)I
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0, p2}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(Ljava/util/Date;I)I

    move-result p0

    return p0
.end method

.method public static getValueByCalendarField(Ljava/util/Date;I)I
    .registers 3

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    invoke-virtual {v0, p1}, Ljava/util/Calendar;->get(I)I

    move-result p0

    return p0
.end method

.method private static getWeeOfToday()J
    .registers 3

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    const/16 v1, 0xb

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    const/16 v1, 0xd

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    const/16 v1, 0xc

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    const/16 v1, 0xe

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public static getZodiac(II)Ljava/lang/String;
    .registers 5

    sget-object v0, Lcom/blankj/utilcode/util/TimeUtils;->ZODIAC:[Ljava/lang/String;

    sget-object v1, Lcom/blankj/utilcode/util/TimeUtils;->ZODIAC_FLAGS:[I

    add-int/lit8 v2, p0, -0x1

    aget v1, v1, v2

    if-lt p1, v1, :cond_b

    goto :goto_f

    :cond_b
    add-int/lit8 p0, p0, 0xa

    rem-int/lit8 v2, p0, 0xc

    :goto_f
    aget-object p0, v0, v2

    return-object p0
.end method

.method public static getZodiac(J)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getZodiac(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getZodiac(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->getZodiac(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getZodiac(Ljava/util/Date;)Ljava/lang/String;
    .registers 3

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    const/4 p0, 0x2

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->get(I)I

    move-result p0

    add-int/lit8 p0, p0, 0x1

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->getZodiac(II)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static isAm()Z
    .registers 2

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v0

    if-nez v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method public static isAm(J)Z
    .registers 3

    const/16 v0, 0x9

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(JI)I

    move-result p0

    if-nez p0, :cond_a

    const/4 p0, 0x1

    goto :goto_b

    :cond_a
    const/4 p0, 0x0

    :goto_b
    return p0
.end method

.method public static isAm(Ljava/lang/String;)Z
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    const/16 v1, 0x9

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(Ljava/lang/String;Ljava/text/DateFormat;I)I

    move-result p0

    if-nez p0, :cond_e

    const/4 p0, 0x1

    goto :goto_f

    :cond_e
    const/4 p0, 0x0

    :goto_f
    return p0
.end method

.method public static isAm(Ljava/lang/String;Ljava/text/DateFormat;)Z
    .registers 3

    const/16 v0, 0x9

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(Ljava/lang/String;Ljava/text/DateFormat;I)I

    move-result p0

    if-nez p0, :cond_a

    const/4 p0, 0x1

    goto :goto_b

    :cond_a
    const/4 p0, 0x0

    :goto_b
    return p0
.end method

.method public static isAm(Ljava/util/Date;)Z
    .registers 2

    const/16 v0, 0x9

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->getValueByCalendarField(Ljava/util/Date;I)I

    move-result p0

    if-nez p0, :cond_a

    const/4 p0, 0x1

    goto :goto_b

    :cond_a
    const/4 p0, 0x0

    :goto_b
    return p0
.end method

.method public static isLeapYear(I)Z
    .registers 2

    rem-int/lit8 v0, p0, 0x4

    if-nez v0, :cond_8

    rem-int/lit8 v0, p0, 0x64

    if-nez v0, :cond_c

    :cond_8
    rem-int/lit16 p0, p0, 0x190

    if-nez p0, :cond_e

    :cond_c
    const/4 p0, 0x1

    goto :goto_f

    :cond_e
    const/4 p0, 0x0

    :goto_f
    return p0
.end method

.method public static isLeapYear(J)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->millis2Date(J)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isLeapYear(Ljava/util/Date;)Z

    move-result p0

    return p0
.end method

.method public static isLeapYear(Ljava/lang/String;)Z
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isLeapYear(Ljava/util/Date;)Z

    move-result p0

    return p0
.end method

.method public static isLeapYear(Ljava/lang/String;Ljava/text/DateFormat;)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isLeapYear(Ljava/util/Date;)Z

    move-result p0

    return p0
.end method

.method public static isLeapYear(Ljava/util/Date;)Z
    .registers 2

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    const/4 p0, 0x1

    invoke-virtual {v0, p0}, Ljava/util/Calendar;->get(I)I

    move-result p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isLeapYear(I)Z

    move-result p0

    return p0
.end method

.method public static isPm()Z
    .registers 1

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->isAm()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public static isPm(J)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->isAm(J)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isPm(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isAm(Ljava/lang/String;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isPm(Ljava/lang/String;Ljava/text/DateFormat;)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->isAm(Ljava/lang/String;Ljava/text/DateFormat;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isPm(Ljava/util/Date;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/TimeUtils;->isAm(Ljava/util/Date;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isToday(J)Z
    .registers 6

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getWeeOfToday()J

    move-result-wide v0

    cmp-long v2, p0, v0

    if-ltz v2, :cond_12

    const-wide/32 v2, 0x5265c00

    add-long/2addr v0, v2

    cmp-long p0, p0, v0

    if-gez p0, :cond_12

    const/4 p0, 0x1

    goto :goto_13

    :cond_12
    const/4 p0, 0x0

    :goto_13
    return p0
.end method

.method public static isToday(Ljava/lang/String;)Z
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/TimeUtils;->isToday(J)Z

    move-result p0

    return p0
.end method

.method public static isToday(Ljava/lang/String;Ljava/text/DateFormat;)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->isToday(J)Z

    move-result p0

    return p0
.end method

.method public static isToday(Ljava/util/Date;)Z
    .registers 3

    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/TimeUtils;->isToday(J)Z

    move-result p0

    return p0
.end method

.method public static isUsingNetworkProvidedTime()Z
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "auto_time"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/provider/Settings$Global;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_13

    move v2, v1

    :cond_13
    return v2
.end method

.method public static millis2Date(J)Ljava/util/Date;
    .registers 3

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    return-object v0
.end method

.method static millis2FitTimeSpan(JI)Ljava/lang/String;
    .registers 12

    if-gtz p2, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x5

    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result p2

    const-string v1, "\u79d2"

    const-string v2, "\u6beb\u79d2"

    const-string v3, "\u5929"

    const-string v4, "\u5c0f\u65f6"

    const-string v5, "\u5206\u949f"

    filled-new-array {v3, v4, v5, v1, v2}, [Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, 0x0

    cmp-long v2, p0, v2

    if-nez v2, :cond_31

    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "0"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    add-int/lit8 p2, p2, -0x1

    aget-object p1, v1, p2

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_31
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    if-gez v2, :cond_3e

    const-string v2, "-"

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    neg-long p0, p0

    :cond_3e
    new-array v0, v0, [I

    fill-array-data v0, :array_64

    const/4 v2, 0x0

    :goto_44
    if-ge v2, p2, :cond_5f

    aget v4, v0, v2

    int-to-long v5, v4

    cmp-long v5, p0, v5

    if-ltz v5, :cond_5c

    int-to-long v5, v4

    div-long v5, p0, v5

    int-to-long v7, v4

    mul-long/2addr v7, v5

    sub-long/2addr p0, v7

    invoke-virtual {v3, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v1, v2

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_5c
    add-int/lit8 v2, v2, 0x1

    goto :goto_44

    :cond_5f
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :array_64
    .array-data 4
        0x5265c00
        0x36ee80
        0xea60
        0x3e8
        0x1
    .end array-data
.end method

.method public static millis2String(J)Ljava/lang/String;
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static millis2String(JLjava/lang/String;)Ljava/lang/String;
    .registers 3

    invoke-static {p2}, Lcom/blankj/utilcode/util/TimeUtils;->getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object p2

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/TimeUtils;->millis2String(JLjava/text/DateFormat;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static millis2String(JLjava/text/DateFormat;)Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, p0, p1}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {p2, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static millis2TimeSpan(JI)J
    .registers 5

    int-to-long v0, p2

    div-long/2addr p0, v0

    return-wide p0
.end method

.method public static string2Date(Ljava/lang/String;)Ljava/util/Date;
    .registers 2

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static string2Date(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Date;
    .registers 2

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;

    move-result-object p0

    return-object p0
.end method

.method public static string2Date(Ljava/lang/String;Ljava/text/DateFormat;)Ljava/util/Date;
    .registers 2

    :try_start_0
    invoke-virtual {p1, p0}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object p0
    :try_end_4
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_4} :catch_5

    return-object p0

    :catch_5
    move-exception p0

    invoke-virtual {p0}, Ljava/text/ParseException;->printStackTrace()V

    const/4 p0, 0x0

    return-object p0
.end method

.method public static string2Millis(Ljava/lang/String;)J
    .registers 3

    invoke-static {}, Lcom/blankj/utilcode/util/TimeUtils;->getDefaultFormat()Ljava/text/SimpleDateFormat;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static string2Millis(Ljava/lang/String;Ljava/lang/String;)J
    .registers 2

    invoke-static {p1}, Lcom/blankj/utilcode/util/TimeUtils;->getSafeDateFormat(Ljava/lang/String;)Ljava/text/SimpleDateFormat;

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/TimeUtils;->string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J

    move-result-wide p0

    return-wide p0
.end method

.method public static string2Millis(Ljava/lang/String;Ljava/text/DateFormat;)J
    .registers 2

    :try_start_0
    invoke-virtual {p1, p0}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object p0

    invoke-virtual {p0}, Ljava/util/Date;->getTime()J

    move-result-wide p0
    :try_end_8
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_8} :catch_9

    return-wide p0

    :catch_9
    move-exception p0

    invoke-virtual {p0}, Ljava/text/ParseException;->printStackTrace()V

    const-wide/16 p0, -0x1

    return-wide p0
.end method

.method private static timeSpan2Millis(JI)J
    .registers 5

    int-to-long v0, p2

    mul-long/2addr p0, v0

    return-wide p0
.end method
