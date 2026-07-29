.class Landroidx/core/location/LocationRequestCompat$Api19Impl;
.super Ljava/lang/Object;
.source "LocationRequestCompat.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/location/LocationRequestCompat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Api19Impl"
.end annotation


# static fields
.field private static sCreateFromDeprecatedProviderMethod:Ljava/lang/reflect/Method;

.field private static sLocationRequestClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class<",
            "*>;"
        }
    .end annotation
.end field

.field private static sSetExpireInMethod:Ljava/lang/reflect/Method;

.field private static sSetFastestIntervalMethod:Ljava/lang/reflect/Method;

.field private static sSetNumUpdatesMethod:Ljava/lang/reflect/Method;

.field private static sSetQualityMethod:Ljava/lang/reflect/Method;


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toLocationRequest(Landroidx/core/location/LocationRequestCompat;Ljava/lang/String;)Ljava/lang/Object;
    .registers 12

    const/4 v0, 0x0

    :try_start_1
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    if-nez v1, :cond_d

    const-string v1, "android.location.LocationRequest"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    :cond_d
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sCreateFromDeprecatedProviderMethod:Ljava/lang/reflect/Method;

    const/4 v2, 0x3

    const/4 v3, 0x2

    const/4 v4, 0x4

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-nez v1, :cond_35

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    const-string v7, "createFromDeprecatedProvider"

    new-array v8, v4, [Ljava/lang/Class;

    const-class v9, Ljava/lang/String;

    aput-object v9, v8, v5

    sget-object v9, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v9, v8, v6

    sget-object v9, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    aput-object v9, v8, v3

    sget-object v9, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v9, v8, v2

    invoke-virtual {v1, v7, v8}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sCreateFromDeprecatedProviderMethod:Ljava/lang/reflect/Method;

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    :cond_35
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sCreateFromDeprecatedProviderMethod:Ljava/lang/reflect/Method;

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p1, v4, v5

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getIntervalMillis()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    aput-object p1, v4, v6

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getMinUpdateDistanceMeters()F

    move-result p1

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    aput-object p1, v4, v3

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    aput-object p1, v4, v2

    invoke-virtual {v1, v0, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    if-nez p1, :cond_5c

    return-object v0

    :cond_5c
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetQualityMethod:Ljava/lang/reflect/Method;

    if-nez v1, :cond_73

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    const-string v2, "setQuality"

    new-array v3, v6, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetQualityMethod:Ljava/lang/reflect/Method;

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    :cond_73
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetQualityMethod:Ljava/lang/reflect/Method;

    new-array v2, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getQuality()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v1, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetFastestIntervalMethod:Ljava/lang/reflect/Method;

    if-nez v1, :cond_9b

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    const-string v2, "setFastestInterval"

    new-array v3, v6, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetFastestIntervalMethod:Ljava/lang/reflect/Method;

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    :cond_9b
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetFastestIntervalMethod:Ljava/lang/reflect/Method;

    new-array v2, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getMinUpdateIntervalMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v1, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getMaxUpdates()I

    move-result v1

    const v2, 0x7fffffff

    if-ge v1, v2, :cond_dd

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetNumUpdatesMethod:Ljava/lang/reflect/Method;

    if-nez v1, :cond_cc

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    const-string v2, "setNumUpdates"

    new-array v3, v6, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetNumUpdatesMethod:Ljava/lang/reflect/Method;

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    :cond_cc
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetNumUpdatesMethod:Ljava/lang/reflect/Method;

    new-array v2, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getMaxUpdates()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v1, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    :cond_dd
    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getDurationMillis()J

    move-result-wide v1

    const-wide v3, 0x7fffffffffffffffL

    cmp-long v1, v1, v3

    if-gez v1, :cond_112

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetExpireInMethod:Ljava/lang/reflect/Method;

    if-nez v1, :cond_101

    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sLocationRequestClass:Ljava/lang/Class;

    const-string v2, "setExpireIn"

    new-array v3, v6, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetExpireInMethod:Ljava/lang/reflect/Method;

    invoke-virtual {v1, v6}, Ljava/lang/reflect/Method;->setAccessible(Z)V

    :cond_101
    sget-object v1, Landroidx/core/location/LocationRequestCompat$Api19Impl;->sSetExpireInMethod:Ljava/lang/reflect/Method;

    new-array v2, v6, [Ljava/lang/Object;

    invoke-virtual {p0}, Landroidx/core/location/LocationRequestCompat;->getDurationMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p0

    aput-object p0, v2, v5

    invoke-virtual {v1, p1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_112
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_112} :catch_113
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_112} :catch_113
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_112} :catch_113
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_112} :catch_113

    :cond_112
    return-object p1

    :catch_113
    return-object v0
.end method
