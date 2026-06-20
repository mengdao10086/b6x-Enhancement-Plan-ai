.class public final Lcom/blankj/utilcode/util/ConvertUtils;
.super Ljava/lang/Object;
.source "ConvertUtils.java"


# static fields
.field private static final BUFFER_SIZE:I = 0x2000

.field private static final HEX_DIGITS_LOWER:[C

.field private static final HEX_DIGITS_UPPER:[C


# direct methods
.method static constructor <clinit>()V
    .registers 2

    const/16 v0, 0x10

    new-array v1, v0, [C

    .line 42
    fill-array-data v1, :array_12

    sput-object v1, Lcom/blankj/utilcode/util/ConvertUtils;->HEX_DIGITS_UPPER:[C

    new-array v0, v0, [C

    .line 44
    fill-array-data v0, :array_26

    sput-object v0, Lcom/blankj/utilcode/util/ConvertUtils;->HEX_DIGITS_LOWER:[C

    return-void

    nop

    :array_12
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x41s
        0x42s
        0x43s
        0x44s
        0x45s
        0x46s
    .end array-data

    :array_26
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method

.method private constructor <init>()V
    .registers 3

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static bitmap2Bytes(Landroid/graphics/Bitmap;)[B
    .registers 1

    .line 378
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bitmap2Bytes(Landroid/graphics/Bitmap;)[B

    move-result-object p0

    return-object p0
.end method

.method public static bitmap2Bytes(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;I)[B
    .registers 3

    .line 385
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->bitmap2Bytes(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;I)[B

    move-result-object p0

    return-object p0
.end method

.method public static bitmap2Drawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;
    .registers 1

    .line 716
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bitmap2Drawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static bits2Bytes(Ljava/lang/String;)[B
    .registers 9

    .line 95
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x8

    rem-int/2addr v0, v1

    .line 96
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    div-int/2addr v2, v1

    if-eqz v0, :cond_24

    :goto_e
    if-ge v0, v1, :cond_22

    .line 100
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "0"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    :cond_22
    add-int/lit8 v2, v2, 0x1

    .line 104
    :cond_24
    new-array v0, v2, [B

    const/4 v3, 0x0

    move v4, v3

    :goto_28
    if-ge v4, v2, :cond_47

    move v5, v3

    :goto_2b
    if-ge v5, v1, :cond_44

    .line 107
    aget-byte v6, v0, v4

    shl-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, v0, v4

    mul-int/lit8 v7, v4, 0x8

    add-int/2addr v7, v5

    .line 108
    invoke-virtual {p0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    add-int/lit8 v7, v7, -0x30

    or-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, v0, v4

    add-int/lit8 v5, v5, 0x1

    goto :goto_2b

    :cond_44
    add-int/lit8 v4, v4, 0x1

    goto :goto_28

    :cond_47
    return-object v0
.end method

.method public static byte2FitMemorySize(J)Ljava/lang/String;
    .registers 3

    const/4 v0, 0x3

    .line 456
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ConvertUtils;->byte2FitMemorySize(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static byte2FitMemorySize(JI)Ljava/lang/String;
    .registers 9

    if-ltz p2, :cond_b5

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-ltz v0, :cond_ad

    const-wide/16 v0, 0x400

    cmp-long v0, p0, v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    const-string v3, "%."

    if-gez v0, :cond_33

    .line 475
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, "fB"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    new-array v0, v2, [Ljava/lang/Object;

    long-to-double p0, p0

    invoke-static {p0, p1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    aput-object p0, v0, v1

    invoke-static {p2, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_33
    const-wide/32 v4, 0x100000

    cmp-long v0, p0, v4

    if-gez v0, :cond_5e

    .line 477
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, "fKB"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    new-array v0, v2, [Ljava/lang/Object;

    long-to-double p0, p0

    const-wide/high16 v2, 0x4090000000000000L    # 1024.0

    div-double/2addr p0, v2

    invoke-static {p0, p1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    aput-object p0, v0, v1

    invoke-static {p2, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_5e
    const-wide/32 v4, 0x40000000

    cmp-long v0, p0, v4

    if-gez v0, :cond_89

    .line 479
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, "fMB"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    new-array v0, v2, [Ljava/lang/Object;

    long-to-double p0, p0

    const-wide/high16 v2, 0x4130000000000000L    # 1048576.0

    div-double/2addr p0, v2

    invoke-static {p0, p1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    aput-object p0, v0, v1

    invoke-static {p2, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 481
    :cond_89
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p2

    const-string v0, "fGB"

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    new-array v0, v2, [Ljava/lang/Object;

    long-to-double p0, p0

    const-wide/high16 v2, 0x41d0000000000000L    # 1.073741824E9

    div-double/2addr p0, v2

    invoke-static {p0, p1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p0

    aput-object p0, v0, v1

    invoke-static {p2, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 473
    :cond_ad
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "byteSize shouldn\'t be less than zero!"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 470
    :cond_b5
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "precision shouldn\'t be less than zero!"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static byte2MemorySize(JI)D
    .registers 5

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-gez v0, :cond_9

    const-wide/high16 p0, -0x4010000000000000L    # -1.0

    return-wide p0

    :cond_9
    long-to-double p0, p0

    int-to-double v0, p2

    div-double/2addr p0, v0

    return-wide p0
.end method

.method public static bytes2Bitmap([B)Landroid/graphics/Bitmap;
    .registers 1

    .line 371
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2Bitmap([B)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static bytes2Bits([B)Ljava/lang/String;
    .registers 7

    if-eqz p0, :cond_2d

    .line 78
    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_2d

    .line 79
    :cond_6
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 80
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_28

    aget-byte v3, p0, v2

    const/4 v4, 0x7

    :goto_12
    if-ltz v4, :cond_25

    shr-int v5, v3, v4

    and-int/lit8 v5, v5, 0x1

    if-nez v5, :cond_1d

    const/16 v5, 0x30

    goto :goto_1f

    :cond_1d
    const/16 v5, 0x31

    .line 82
    :goto_1f
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, -0x1

    goto :goto_12

    :cond_25
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    .line 85
    :cond_28
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_2d
    :goto_2d
    const-string p0, ""

    return-object p0
.end method

.method public static bytes2Chars([B)[C
    .registers 5

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 122
    :cond_4
    array-length v1, p0

    if-gtz v1, :cond_8

    return-object v0

    .line 124
    :cond_8
    new-array v0, v1, [C

    const/4 v2, 0x0

    :goto_b
    if-ge v2, v1, :cond_17

    .line 126
    aget-byte v3, p0, v2

    and-int/lit16 v3, v3, 0xff

    int-to-char v3, v3

    aput-char v3, v0, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    :cond_17
    return-object v0
.end method

.method public static bytes2Drawable([B)Landroid/graphics/drawable/Drawable;
    .registers 1

    .line 392
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2Drawable([B)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static bytes2HexString([B)Ljava/lang/String;
    .registers 2

    const/4 v0, 0x1

    .line 155
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ConvertUtils;->bytes2HexString([BZ)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static bytes2HexString([BZ)Ljava/lang/String;
    .registers 9

    const-string v0, ""

    if-nez p0, :cond_5

    return-object v0

    :cond_5
    if-eqz p1, :cond_a

    .line 168
    sget-object p1, Lcom/blankj/utilcode/util/ConvertUtils;->HEX_DIGITS_UPPER:[C

    goto :goto_c

    :cond_a
    sget-object p1, Lcom/blankj/utilcode/util/ConvertUtils;->HEX_DIGITS_LOWER:[C

    .line 169
    :goto_c
    array-length v1, p0

    if-gtz v1, :cond_10

    return-object v0

    :cond_10
    shl-int/lit8 v0, v1, 0x1

    .line 171
    new-array v0, v0, [C

    const/4 v2, 0x0

    move v3, v2

    :goto_16
    if-ge v2, v1, :cond_2f

    add-int/lit8 v4, v3, 0x1

    .line 173
    aget-byte v5, p0, v2

    shr-int/lit8 v6, v5, 0x4

    and-int/lit8 v6, v6, 0xf

    aget-char v6, p1, v6

    aput-char v6, v0, v3

    add-int/lit8 v3, v4, 0x1

    and-int/lit8 v5, v5, 0xf

    .line 174
    aget-char v5, p1, v5

    aput-char v5, v0, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_16

    .line 176
    :cond_2f
    new-instance p0, Ljava/lang/String;

    invoke-direct {p0, v0}, Ljava/lang/String;-><init>([C)V

    return-object p0
.end method

.method public static bytes2InputStream([B)Ljava/io/InputStream;
    .registers 2

    if-eqz p0, :cond_c

    .line 586
    array-length v0, p0

    if-gtz v0, :cond_6

    goto :goto_c

    .line 587
    :cond_6
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    return-object v0

    :cond_c
    :goto_c
    const/4 p0, 0x0

    return-object p0
.end method

.method public static bytes2JSONArray([B)Lorg/json/JSONArray;
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 278
    :cond_4
    :try_start_4
    new-instance v1, Lorg/json/JSONArray;

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, p0}, Ljava/lang/String;-><init>([B)V

    invoke-direct {v1, v2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_e} :catch_f

    return-object v1

    :catch_f
    move-exception p0

    .line 280
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    return-object v0
.end method

.method public static bytes2JSONObject([B)Lorg/json/JSONObject;
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 257
    :cond_4
    :try_start_4
    new-instance v1, Lorg/json/JSONObject;

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, p0}, Ljava/lang/String;-><init>([B)V

    invoke-direct {v1, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_e} :catch_f

    return-object v1

    :catch_f
    move-exception p0

    .line 259
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    return-object v0
.end method

.method public static bytes2Object([B)Ljava/lang/Object;
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 326
    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/ObjectInputStream;

    new-instance v2, Ljava/io/ByteArrayInputStream;

    invoke-direct {v2, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-direct {v1, v2}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_e} :catch_1f
    .catchall {:try_start_4 .. :try_end_e} :catchall_1d

    .line 327
    :try_start_e
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object p0
    :try_end_12
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_12} :catch_1b
    .catchall {:try_start_e .. :try_end_12} :catchall_2f

    .line 334
    :try_start_12
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V
    :try_end_15
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_15} :catch_16

    goto :goto_1a

    :catch_16
    move-exception v0

    .line 337
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :goto_1a
    return-object p0

    :catch_1b
    move-exception p0

    goto :goto_21

    :catchall_1d
    move-exception p0

    goto :goto_31

    :catch_1f
    move-exception p0

    move-object v1, v0

    .line 329
    :goto_21
    :try_start_21
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_24
    .catchall {:try_start_21 .. :try_end_24} :catchall_2f

    if-eqz v1, :cond_2e

    .line 334
    :try_start_26
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_26 .. :try_end_29} :catch_2a

    goto :goto_2e

    :catch_2a
    move-exception p0

    .line 337
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_2e
    :goto_2e
    return-object v0

    :catchall_2f
    move-exception p0

    move-object v0, v1

    :goto_31
    if-eqz v0, :cond_3b

    .line 334
    :try_start_33
    invoke-virtual {v0}, Ljava/io/ObjectInputStream;->close()V
    :try_end_36
    .catch Ljava/io/IOException; {:try_start_33 .. :try_end_36} :catch_37

    goto :goto_3b

    :catch_37
    move-exception v0

    .line 337
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 339
    :cond_3b
    :goto_3b
    throw p0
.end method

.method public static bytes2OutputStream([B)Ljava/io/OutputStream;
    .registers 3

    const/4 v0, 0x0

    if-eqz p0, :cond_39

    .line 602
    array-length v1, p0

    if-gtz v1, :cond_7

    goto :goto_39

    .line 605
    :cond_7
    :try_start_7
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_c} :catch_1c
    .catchall {:try_start_7 .. :try_end_c} :catchall_1a

    .line 606
    :try_start_c
    invoke-virtual {v1, p0}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_f} :catch_18
    .catchall {:try_start_c .. :try_end_f} :catchall_2c

    .line 614
    :try_start_f
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_12} :catch_13

    goto :goto_17

    :catch_13
    move-exception p0

    .line 617
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_17
    return-object v1

    :catch_18
    move-exception p0

    goto :goto_1e

    :catchall_1a
    move-exception p0

    goto :goto_2e

    :catch_1c
    move-exception p0

    move-object v1, v0

    .line 609
    :goto_1e
    :try_start_1e
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_21
    .catchall {:try_start_1e .. :try_end_21} :catchall_2c

    if-eqz v1, :cond_2b

    .line 614
    :try_start_23
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_26
    .catch Ljava/io/IOException; {:try_start_23 .. :try_end_26} :catch_27

    goto :goto_2b

    :catch_27
    move-exception p0

    .line 617
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_2b
    :goto_2b
    return-object v0

    :catchall_2c
    move-exception p0

    move-object v0, v1

    :goto_2e
    if-eqz v0, :cond_38

    .line 614
    :try_start_30
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_33
    .catch Ljava/io/IOException; {:try_start_30 .. :try_end_33} :catch_34

    goto :goto_38

    :catch_34
    move-exception v0

    .line 617
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 619
    :cond_38
    :goto_38
    throw p0

    :cond_39
    :goto_39
    return-object v0
.end method

.method public static bytes2Parcelable([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([B",
            "Landroid/os/Parcelable$Creator<",
            "TT;>;)TT;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 299
    :cond_4
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 300
    array-length v1, p0

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v2, v1}, Landroid/os/Parcel;->unmarshall([BII)V

    .line 301
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 302
    invoke-interface {p1, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object p0

    .line 303
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    return-object p0
.end method

.method public static bytes2String([B)Ljava/lang/String;
    .registers 2

    const-string v0, ""

    .line 215
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ConvertUtils;->bytes2String([BLjava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static bytes2String([BLjava/lang/String;)Ljava/lang/String;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 224
    :cond_4
    :try_start_4
    new-instance v0, Ljava/lang/String;

    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p0, p1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_d
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_d} :catch_e

    return-object v0

    :catch_e
    move-exception p1

    .line 226
    invoke-virtual {p1}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    .line 227
    new-instance p1, Ljava/lang/String;

    invoke-direct {p1, p0}, Ljava/lang/String;-><init>([B)V

    return-object p1
.end method

.method public static chars2Bytes([C)[B
    .registers 5

    if-eqz p0, :cond_15

    .line 138
    array-length v0, p0

    if-gtz v0, :cond_6

    goto :goto_15

    .line 139
    :cond_6
    array-length v0, p0

    .line 140
    new-array v1, v0, [B

    const/4 v2, 0x0

    :goto_a
    if-ge v2, v0, :cond_14

    .line 142
    aget-char v3, p0, v2

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    :cond_14
    return-object v1

    :cond_15
    :goto_15
    const/4 p0, 0x0

    return-object p0
.end method

.method public static dp2px(F)I
    .registers 1

    .line 730
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->dp2px(F)I

    move-result p0

    return p0
.end method

.method public static drawable2Bitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .registers 1

    .line 709
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->drawable2Bitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static drawable2Bytes(Landroid/graphics/drawable/Drawable;)[B
    .registers 1

    .line 399
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->drawable2Bytes(Landroid/graphics/drawable/Drawable;)[B

    move-result-object p0

    return-object p0
.end method

.method public static drawable2Bytes(Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap$CompressFormat;I)[B
    .registers 3

    .line 406
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->drawable2Bytes(Landroid/graphics/drawable/Drawable;Landroid/graphics/Bitmap$CompressFormat;I)[B

    move-result-object p0

    return-object p0
.end method

.method private static getSafeCharset(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    .line 756
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_c

    invoke-static {p0}, Ljava/nio/charset/Charset;->isSupported(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    :cond_c
    const-string p0, "UTF-8"

    :cond_e
    return-object p0
.end method

.method private static hex2Dec(C)I
    .registers 3

    const/16 v0, 0x30

    if-lt p0, v0, :cond_a

    const/16 v1, 0x39

    if-gt p0, v1, :cond_a

    sub-int/2addr p0, v0

    return p0

    :cond_a
    const/16 v0, 0x41

    if-lt p0, v0, :cond_16

    const/16 v1, 0x46

    if-gt p0, v1, :cond_16

    sub-int/2addr p0, v0

    add-int/lit8 p0, p0, 0xa

    return p0

    .line 207
    :cond_16
    new-instance p0, Ljava/lang/IllegalArgumentException;

    invoke-direct {p0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw p0
.end method

.method public static hexString2Bytes(Ljava/lang/String;)[B
    .registers 7

    .line 187
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_a

    new-array p0, v1, [B

    return-object p0

    .line 188
    :cond_a
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 189
    rem-int/lit8 v2, v0, 0x2

    if-eqz v2, :cond_23

    .line 190
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "0"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    add-int/lit8 v0, v0, 0x1

    .line 193
    :cond_23
    invoke-virtual {p0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object p0

    shr-int/lit8 v2, v0, 0x1

    .line 194
    new-array v2, v2, [B

    :goto_2f
    if-ge v1, v0, :cond_4a

    shr-int/lit8 v3, v1, 0x1

    .line 196
    aget-char v4, p0, v1

    invoke-static {v4}, Lcom/blankj/utilcode/util/ConvertUtils;->hex2Dec(C)I

    move-result v4

    shl-int/lit8 v4, v4, 0x4

    add-int/lit8 v5, v1, 0x1

    aget-char v5, p0, v5

    invoke-static {v5}, Lcom/blankj/utilcode/util/ConvertUtils;->hex2Dec(C)I

    move-result v5

    or-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    add-int/lit8 v1, v1, 0x2

    goto :goto_2f

    :cond_4a
    return-object v2
.end method

.method public static hexString2Int(Ljava/lang/String;)I
    .registers 2

    const/16 v0, 0x10

    .line 68
    invoke-static {p0, v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result p0

    return p0
.end method

.method public static input2OutputStream(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;
    .registers 8

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 547
    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    const/16 v2, 0x2000

    new-array v3, v2, [B

    :goto_d
    const/4 v4, 0x0

    .line 550
    invoke-virtual {p0, v3, v4, v2}, Ljava/io/InputStream;->read([BII)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_19

    .line 551
    invoke-virtual {v1, v3, v4, v5}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_18} :catch_24
    .catchall {:try_start_4 .. :try_end_18} :catchall_22

    goto :goto_d

    .line 559
    :cond_19
    :try_start_19
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_1c
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_1c} :catch_1d

    goto :goto_21

    :catch_1d
    move-exception p0

    .line 561
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_21
    return-object v1

    :catchall_22
    move-exception v0

    goto :goto_31

    :catch_24
    move-exception v1

    .line 555
    :try_start_25
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_28
    .catchall {:try_start_25 .. :try_end_28} :catchall_22

    .line 559
    :try_start_28
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_2b
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_2b} :catch_2c

    goto :goto_30

    :catch_2c
    move-exception p0

    .line 561
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_30
    return-object v0

    .line 559
    :goto_31
    :try_start_31
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_34
    .catch Ljava/io/IOException; {:try_start_31 .. :try_end_34} :catch_35

    goto :goto_39

    :catch_35
    move-exception p0

    .line 561
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 563
    :goto_39
    throw v0
.end method

.method public static inputStream2Bytes(Ljava/io/InputStream;)[B
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 579
    :cond_4
    invoke-static {p0}, Lcom/blankj/utilcode/util/ConvertUtils;->input2OutputStream(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;

    move-result-object p0

    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0

    return-object p0
.end method

.method public static inputStream2Lines(Ljava/io/InputStream;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const-string v0, ""

    .line 677
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ConvertUtils;->inputStream2Lines(Ljava/io/InputStream;Ljava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static inputStream2Lines(Ljava/io/InputStream;Ljava/lang/String;)Ljava/util/List;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    .line 684
    :try_start_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 685
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v3, p0, p1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_14} :catch_2b
    .catchall {:try_start_1 .. :try_end_14} :catchall_29

    .line 687
    :goto_14
    :try_start_14
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_1e

    .line 688
    invoke-interface {v1, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_1d} :catch_27
    .catchall {:try_start_14 .. :try_end_1d} :catchall_3b

    goto :goto_14

    .line 697
    :cond_1e
    :try_start_1e
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_21
    .catch Ljava/io/IOException; {:try_start_1e .. :try_end_21} :catch_22

    goto :goto_26

    :catch_22
    move-exception p0

    .line 700
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_26
    return-object v1

    :catch_27
    move-exception p0

    goto :goto_2d

    :catchall_29
    move-exception p0

    goto :goto_3d

    :catch_2b
    move-exception p0

    move-object v2, v0

    .line 692
    :goto_2d
    :try_start_2d
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_30
    .catchall {:try_start_2d .. :try_end_30} :catchall_3b

    if-eqz v2, :cond_3a

    .line 697
    :try_start_32
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_35
    .catch Ljava/io/IOException; {:try_start_32 .. :try_end_35} :catch_36

    goto :goto_3a

    :catch_36
    move-exception p0

    .line 700
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_3a
    :goto_3a
    return-object v0

    :catchall_3b
    move-exception p0

    move-object v0, v2

    :goto_3d
    if-eqz v0, :cond_47

    .line 697
    :try_start_3f
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_3f .. :try_end_42} :catch_43

    goto :goto_47

    :catch_43
    move-exception p1

    .line 700
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 702
    :cond_47
    :goto_47
    throw p0
.end method

.method public static inputStream2String(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    const-string v0, ""

    if-nez p0, :cond_5

    return-object v0

    .line 628
    :cond_5
    :try_start_5
    invoke-static {p0}, Lcom/blankj/utilcode/util/ConvertUtils;->input2OutputStream(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;

    move-result-object p0

    if-nez p0, :cond_c

    return-object v0

    .line 630
    :cond_c
    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0
    :try_end_14
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_5 .. :try_end_14} :catch_15

    return-object p0

    :catch_15
    move-exception p0

    .line 632
    invoke-virtual {p0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0
.end method

.method public static int2HexString(I)Ljava/lang/String;
    .registers 1

    .line 58
    invoke-static {p0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static jsonArray2Bytes(Lorg/json/JSONArray;)[B
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 290
    :cond_4
    invoke-virtual {p0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    return-object p0
.end method

.method public static jsonObject2Bytes(Lorg/json/JSONObject;)[B
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 269
    :cond_4
    invoke-virtual {p0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    return-object p0
.end method

.method public static memorySize2Byte(JI)J
    .registers 5

    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-gez v0, :cond_9

    const-wide/16 p0, -0x1

    return-wide p0

    :cond_9
    int-to-long v0, p2

    mul-long/2addr p0, v0

    return-wide p0
.end method

.method public static millis2FitTimeSpan(JI)Ljava/lang/String;
    .registers 3

    .line 538
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->millis2FitTimeSpan(JI)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static millis2TimeSpan(JI)J
    .registers 5

    int-to-long v0, p2

    .line 518
    div-long/2addr p0, v0

    return-wide p0
.end method

.method public static output2InputStream(Ljava/io/OutputStream;)Ljava/io/ByteArrayInputStream;
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 571
    :cond_4
    new-instance v0, Ljava/io/ByteArrayInputStream;

    check-cast p0, Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    return-object v0
.end method

.method public static outputStream2Bytes(Ljava/io/OutputStream;)[B
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 595
    :cond_4
    check-cast p0, Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0

    return-object p0
.end method

.method public static outputStream2String(Ljava/io/OutputStream;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    const-string v0, ""

    if-nez p0, :cond_5

    return-object v0

    .line 656
    :cond_5
    :try_start_5
    new-instance v1, Ljava/lang/String;

    invoke-static {p0}, Lcom/blankj/utilcode/util/ConvertUtils;->outputStream2Bytes(Ljava/io/OutputStream;)[B

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v1, p0, p1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_12
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_5 .. :try_end_12} :catch_13

    return-object v1

    :catch_13
    move-exception p0

    .line 658
    invoke-virtual {p0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0
.end method

.method public static parcelable2Bytes(Landroid/os/Parcelable;)[B
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 312
    :cond_4
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    const/4 v1, 0x0

    .line 313
    invoke-interface {p0, v0, v1}, Landroid/os/Parcelable;->writeToParcel(Landroid/os/Parcel;I)V

    .line 314
    invoke-virtual {v0}, Landroid/os/Parcel;->marshall()[B

    move-result-object p0

    .line 315
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    return-object p0
.end method

.method public static px2dp(F)I
    .registers 1

    .line 737
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->px2dp(F)I

    move-result p0

    return p0
.end method

.method public static px2sp(F)I
    .registers 1

    .line 751
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->px2sp(F)I

    move-result p0

    return p0
.end method

.method public static serializable2Bytes(Ljava/io/Serializable;)[B
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 350
    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/ObjectOutputStream;

    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    invoke-direct {v1, v2}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_e
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_e} :catch_22
    .catchall {:try_start_4 .. :try_end_e} :catchall_20

    .line 351
    :try_start_e
    invoke-virtual {v1, p0}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    .line 352
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p0
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_15} :catch_1e
    .catchall {:try_start_e .. :try_end_15} :catchall_32

    .line 359
    :try_start_15
    invoke-virtual {v1}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_18} :catch_19

    goto :goto_1d

    :catch_19
    move-exception v0

    .line 362
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :goto_1d
    return-object p0

    :catch_1e
    move-exception p0

    goto :goto_24

    :catchall_20
    move-exception p0

    goto :goto_34

    :catch_22
    move-exception p0

    move-object v1, v0

    .line 354
    :goto_24
    :try_start_24
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_27
    .catchall {:try_start_24 .. :try_end_27} :catchall_32

    if-eqz v1, :cond_31

    .line 359
    :try_start_29
    invoke-virtual {v1}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_2c
    .catch Ljava/io/IOException; {:try_start_29 .. :try_end_2c} :catch_2d

    goto :goto_31

    :catch_2d
    move-exception p0

    .line 362
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_31
    :goto_31
    return-object v0

    :catchall_32
    move-exception p0

    move-object v0, v1

    :goto_34
    if-eqz v0, :cond_3e

    .line 359
    :try_start_36
    invoke-virtual {v0}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_39
    .catch Ljava/io/IOException; {:try_start_36 .. :try_end_39} :catch_3a

    goto :goto_3e

    :catch_3a
    move-exception v0

    .line 362
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 364
    :cond_3e
    :goto_3e
    throw p0
.end method

.method public static sp2px(F)I
    .registers 1

    .line 744
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->sp2px(F)I

    move-result p0

    return p0
.end method

.method public static string2Bytes(Ljava/lang/String;)[B
    .registers 2

    const-string v0, ""

    .line 235
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/ConvertUtils;->string2Bytes(Ljava/lang/String;Ljava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static string2Bytes(Ljava/lang/String;Ljava/lang/String;)[B
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    .line 244
    :cond_4
    :try_start_4
    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object p0
    :try_end_c
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_c} :catch_d

    return-object p0

    :catch_d
    move-exception p1

    .line 246
    invoke-virtual {p1}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    .line 247
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    return-object p0
.end method

.method public static string2InputStream(Ljava/lang/String;Ljava/lang/String;)Ljava/io/InputStream;
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 643
    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-direct {v1, p0}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_11
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_11} :catch_12

    return-object v1

    :catch_12
    move-exception p0

    .line 645
    invoke-virtual {p0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0
.end method

.method public static string2OutputStream(Ljava/lang/String;Ljava/lang/String;)Ljava/io/OutputStream;
    .registers 3

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    .line 669
    :cond_4
    :try_start_4
    invoke-static {p1}, Lcom/blankj/utilcode/util/ConvertUtils;->getSafeCharset(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/ConvertUtils;->bytes2OutputStream([B)Ljava/io/OutputStream;

    move-result-object p0
    :try_end_10
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_10} :catch_11

    return-object p0

    :catch_11
    move-exception p0

    .line 671
    invoke-virtual {p0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    return-object v0
.end method

.method public static timeSpan2Millis(JI)J
    .registers 5

    int-to-long v0, p2

    mul-long/2addr p0, v0

    return-wide p0
.end method

.method public static view2Bitmap(Landroid/view/View;)Landroid/graphics/Bitmap;
    .registers 1

    .line 723
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->view2Bitmap(Landroid/view/View;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method
