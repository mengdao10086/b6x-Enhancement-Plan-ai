.class public Landroidx/core/math/MathUtils;
.super Ljava/lang/Object;
.source "MathUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addExact(II)I
    .registers 3

    add-int v0, p0, p1

    xor-int/2addr p0, v0

    xor-int/2addr p1, v0

    and-int/2addr p0, p1

    if-ltz p0, :cond_8

    return v0

    :cond_8
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "integer overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static addExact(JJ)J
    .registers 6

    add-long v0, p0, p2

    xor-long/2addr p0, v0

    xor-long/2addr p2, v0

    and-long/2addr p0, p2

    const-wide/16 p2, 0x0

    cmp-long p0, p0, p2

    if-ltz p0, :cond_c

    return-wide v0

    :cond_c
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static clamp(DDD)D
    .registers 7

    cmpg-double v0, p0, p2

    if-gez v0, :cond_5

    return-wide p2

    :cond_5
    cmpl-double p2, p0, p4

    if-lez p2, :cond_a

    return-wide p4

    :cond_a
    return-wide p0
.end method

.method public static clamp(FFF)F
    .registers 4

    cmpg-float v0, p0, p1

    if-gez v0, :cond_5

    return p1

    :cond_5
    cmpl-float p1, p0, p2

    if-lez p1, :cond_a

    return p2

    :cond_a
    return p0
.end method

.method public static clamp(III)I
    .registers 3

    if-ge p0, p1, :cond_3

    return p1

    :cond_3
    if-le p0, p2, :cond_6

    return p2

    :cond_6
    return p0
.end method

.method public static clamp(JJJ)J
    .registers 7

    cmp-long v0, p0, p2

    if-gez v0, :cond_5

    return-wide p2

    :cond_5
    cmp-long p2, p0, p4

    if-lez p2, :cond_a

    return-wide p4

    :cond_a
    return-wide p0
.end method

.method public static decrementExact(I)I
    .registers 2

    const/high16 v0, -0x80000000

    if-eq p0, v0, :cond_7

    add-int/lit8 p0, p0, -0x1

    return p0

    :cond_7
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string v0, "integer overflow"

    invoke-direct {p0, v0}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static decrementExact(J)J
    .registers 4

    const-wide/high16 v0, -0x8000000000000000L

    cmp-long v0, p0, v0

    if-eqz v0, :cond_a

    const-wide/16 v0, 0x1

    sub-long/2addr p0, v0

    return-wide p0

    :cond_a
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static incrementExact(I)I
    .registers 2

    const v0, 0x7fffffff

    if-eq p0, v0, :cond_8

    add-int/lit8 p0, p0, 0x1

    return p0

    :cond_8
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string v0, "integer overflow"

    invoke-direct {p0, v0}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static incrementExact(J)J
    .registers 4

    const-wide v0, 0x7fffffffffffffffL

    cmp-long v0, p0, v0

    if-eqz v0, :cond_d

    const-wide/16 v0, 0x1

    add-long/2addr p0, v0

    return-wide p0

    :cond_d
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static multiplyExact(II)I
    .registers 6

    int-to-long v0, p0

    int-to-long p0, p1

    mul-long/2addr v0, p0

    long-to-int p0, v0

    int-to-long v2, p0

    cmp-long p1, v2, v0

    if-nez p1, :cond_a

    return p0

    :cond_a
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "integer overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static multiplyExact(JJ)J
    .registers 10

    mul-long v0, p0, p2

    invoke-static {p0, p1}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    invoke-static {p2, p3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v4

    or-long/2addr v2, v4

    const/16 v4, 0x1f

    ushr-long/2addr v2, v4

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_33

    cmp-long v2, p2, v4

    if-eqz v2, :cond_1e

    div-long v2, v0, p2

    cmp-long v2, v2, p0

    if-nez v2, :cond_2b

    :cond_1e
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long p0, p0, v2

    if-nez p0, :cond_33

    const-wide/16 p0, -0x1

    cmp-long p0, p2, p0

    if-eqz p0, :cond_2b

    goto :goto_33

    :cond_2b
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_33
    :goto_33
    return-wide v0
.end method

.method public static negateExact(I)I
    .registers 2

    const/high16 v0, -0x80000000

    if-eq p0, v0, :cond_6

    neg-int p0, p0

    return p0

    :cond_6
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string v0, "integer overflow"

    invoke-direct {p0, v0}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static negateExact(J)J
    .registers 4

    const-wide/high16 v0, -0x8000000000000000L

    cmp-long v0, p0, v0

    if-eqz v0, :cond_8

    neg-long p0, p0

    return-wide p0

    :cond_8
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static subtractExact(II)I
    .registers 3

    sub-int v0, p0, p1

    xor-int/2addr p1, p0

    xor-int/2addr p0, v0

    and-int/2addr p0, p1

    if-ltz p0, :cond_8

    return v0

    :cond_8
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "integer overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static subtractExact(JJ)J
    .registers 6

    sub-long v0, p0, p2

    xor-long/2addr p2, p0

    xor-long/2addr p0, v0

    and-long/2addr p0, p2

    const-wide/16 p2, 0x0

    cmp-long p0, p0, p2

    if-ltz p0, :cond_c

    return-wide v0

    :cond_c
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "long overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static toIntExact(J)I
    .registers 5

    long-to-int v0, p0

    int-to-long v1, v0

    cmp-long p0, v1, p0

    if-nez p0, :cond_7

    return v0

    :cond_7
    new-instance p0, Ljava/lang/ArithmeticException;

    const-string p1, "integer overflow"

    invoke-direct {p0, p1}, Ljava/lang/ArithmeticException;-><init>(Ljava/lang/String;)V

    throw p0
.end method
