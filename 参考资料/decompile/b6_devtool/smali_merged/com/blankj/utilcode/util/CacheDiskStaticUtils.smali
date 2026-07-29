.class public final Lcom/blankj/utilcode/util/CacheDiskStaticUtils;
.super Ljava/lang/Object;
.source "CacheDiskStaticUtils.java"


# static fields
.field private static sDefaultCacheDiskUtils:Lcom/blankj/utilcode/util/CacheDiskUtils;


# direct methods
.method public constructor <init>()V
    .registers 1

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clear()Z
    .registers 1

    .line 445
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->clear(Lcom/blankj/utilcode/util/CacheDiskUtils;)Z

    move-result v0

    return v0
.end method

.method public static clear(Lcom/blankj/utilcode/util/CacheDiskUtils;)Z
    .registers 1

    .line 951
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->clear()Z

    move-result p0

    return p0
.end method

.method public static getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .registers 2

    .line 252
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getBitmap(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static getBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 3

    .line 263
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static getBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/Bitmap;
    .registers 3

    .line 732
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getBitmap(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static getBitmap(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/Bitmap;
    .registers 2

    .line 718
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static getBytes(Ljava/lang/String;)[B
    .registers 2

    .line 64
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getBytes(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)[B

    move-result-object p0

    return-object p0
.end method

.method public static getBytes(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)[B
    .registers 2

    .line 488
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getBytes(Ljava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static getBytes(Ljava/lang/String;[B)[B
    .registers 3

    .line 75
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getBytes(Ljava/lang/String;[BLcom/blankj/utilcode/util/CacheDiskUtils;)[B

    move-result-object p0

    return-object p0
.end method

.method public static getBytes(Ljava/lang/String;[BLcom/blankj/utilcode/util/CacheDiskUtils;)[B
    .registers 3

    .line 502
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getBytes(Ljava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static getCacheCount()I
    .registers 1

    .line 426
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getCacheCount(Lcom/blankj/utilcode/util/CacheDiskUtils;)I

    move-result v0

    return v0
.end method

.method public static getCacheCount(Lcom/blankj/utilcode/util/CacheDiskUtils;)I
    .registers 1

    .line 930
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getCacheCount()I

    move-result p0

    return p0
.end method

.method public static getCacheSize()J
    .registers 2

    .line 417
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getCacheSize(Lcom/blankj/utilcode/util/CacheDiskUtils;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getCacheSize(Lcom/blankj/utilcode/util/CacheDiskUtils;)J
    .registers 3

    .line 920
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getCacheSize()J

    move-result-wide v0

    return-wide v0
.end method

.method private static getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;
    .registers 1

    .line 956
    sget-object v0, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->sDefaultCacheDiskUtils:Lcom/blankj/utilcode/util/CacheDiskUtils;

    if-eqz v0, :cond_5

    goto :goto_9

    :cond_5
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getInstance()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    :goto_9
    return-object v0
.end method

.method public static getDrawable(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    .registers 2

    .line 298
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDrawable(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static getDrawable(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    .registers 3

    .line 309
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDrawable(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static getDrawable(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/drawable/Drawable;
    .registers 3

    .line 789
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getDrawable(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static getDrawable(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Landroid/graphics/drawable/Drawable;
    .registers 2

    .line 775
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getDrawable(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    .registers 2

    .line 205
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getJSONArray(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONArray;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONArray(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONArray;
    .registers 2

    .line 660
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONArray(Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONArray;
    .registers 3

    .line 216
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getJSONArray(Ljava/lang/String;Lorg/json/JSONArray;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONArray;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONArray(Ljava/lang/String;Lorg/json/JSONArray;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONArray;
    .registers 3

    .line 674
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getJSONArray(Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONArray;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    .registers 2

    .line 158
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getJSONObject(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONObject;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONObject(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONObject;
    .registers 2

    .line 602
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONObject(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .registers 3

    .line 169
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getJSONObject(Ljava/lang/String;Lorg/json/JSONObject;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONObject;

    move-result-object p0

    return-object p0
.end method

.method public static getJSONObject(Ljava/lang/String;Lorg/json/JSONObject;Lcom/blankj/utilcode/util/CacheDiskUtils;)Lorg/json/JSONObject;
    .registers 3

    .line 616
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getJSONObject(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object p0

    return-object p0
.end method

.method public static getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Landroid/os/Parcelable$Creator<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 347
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Landroid/os/Parcelable$Creator<",
            "TT;>;",
            "Lcom/blankj/utilcode/util/CacheDiskUtils;",
            ")TT;"
        }
    .end annotation

    .line 836
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Landroid/os/Parcelable$Creator<",
            "TT;>;TT;)TT;"
        }
    .end annotation

    .line 362
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Landroid/os/Parcelable$Creator<",
            "TT;>;TT;",
            "Lcom/blankj/utilcode/util/CacheDiskUtils;",
            ")TT;"
        }
    .end annotation

    .line 853
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getParcelable(Ljava/lang/String;Landroid/os/Parcelable$Creator;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getSerializable(Ljava/lang/String;)Ljava/lang/Object;
    .registers 2

    .line 397
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getSerializable(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getSerializable(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;
    .registers 2

    .line 896
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getSerializable(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getSerializable(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    .line 408
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getSerializable(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getSerializable(Ljava/lang/String;Ljava/lang/Object;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/Object;
    .registers 3

    .line 910
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getSerializable(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    .line 110
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getString(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/String;
    .registers 2

    .line 545
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    .line 121
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getString(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getString(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Ljava/lang/String;
    .registers 3

    .line 559
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .registers 3

    .line 231
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    .registers 4

    .line 242
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/graphics/Bitmap;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/Bitmap;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 707
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/graphics/Bitmap;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 692
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    .registers 3

    .line 277
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;I)V
    .registers 4

    .line 288
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 764
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 749
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/os/Parcelable;)V
    .registers 3

    .line 323
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/os/Parcelable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/os/Parcelable;I)V
    .registers 4

    .line 334
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Landroid/os/Parcelable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/os/Parcelable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 821
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/os/Parcelable;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Landroid/os/Parcelable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 806
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Landroid/os/Parcelable;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/io/Serializable;)V
    .registers 3

    .line 376
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Ljava/io/Serializable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/io/Serializable;I)V
    .registers 4

    .line 387
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Ljava/io/Serializable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/io/Serializable;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 885
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Ljava/io/Serializable;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/io/Serializable;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 870
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Ljava/io/Serializable;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3

    .line 89
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;I)V
    .registers 4

    .line 100
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Ljava/lang/String;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 534
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Ljava/lang/String;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 519
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONArray;)V
    .registers 3

    .line 184
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Lorg/json/JSONArray;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONArray;I)V
    .registers 4

    .line 195
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Lorg/json/JSONArray;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONArray;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 649
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Lorg/json/JSONArray;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONArray;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 634
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Lorg/json/JSONArray;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONObject;)V
    .registers 3

    .line 135
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Lorg/json/JSONObject;Lcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONObject;I)V
    .registers 4

    .line 148
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;Lorg/json/JSONObject;ILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONObject;ILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 591
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Lorg/json/JSONObject;I)V

    return-void
.end method

.method public static put(Ljava/lang/String;Lorg/json/JSONObject;Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 576
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method

.method public static put(Ljava/lang/String;[B)V
    .registers 3

    .line 43
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;[BLcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;[BI)V
    .registers 4

    .line 54
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->put(Ljava/lang/String;[BILcom/blankj/utilcode/util/CacheDiskUtils;)V

    return-void
.end method

.method public static put(Ljava/lang/String;[BILcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 4

    .line 477
    invoke-virtual {p3, p0, p1, p2}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;[BI)V

    return-void
.end method

.method public static put(Ljava/lang/String;[BLcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 3

    .line 462
    invoke-virtual {p2, p0, p1}, Lcom/blankj/utilcode/util/CacheDiskUtils;->put(Ljava/lang/String;[B)V

    return-void
.end method

.method public static remove(Ljava/lang/String;)Z
    .registers 2

    .line 436
    invoke-static {}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->getDefaultCacheDiskUtils()Lcom/blankj/utilcode/util/CacheDiskUtils;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->remove(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Z

    move-result p0

    return p0
.end method

.method public static remove(Ljava/lang/String;Lcom/blankj/utilcode/util/CacheDiskUtils;)Z
    .registers 2

    .line 941
    invoke-virtual {p1, p0}, Lcom/blankj/utilcode/util/CacheDiskUtils;->remove(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static setDefaultCacheDiskUtils(Lcom/blankj/utilcode/util/CacheDiskUtils;)V
    .registers 1

    .line 33
    sput-object p0, Lcom/blankj/utilcode/util/CacheDiskStaticUtils;->sDefaultCacheDiskUtils:Lcom/blankj/utilcode/util/CacheDiskUtils;

    return-void
.end method
