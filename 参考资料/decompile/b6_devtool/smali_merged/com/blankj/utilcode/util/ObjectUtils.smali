.class public final Lcom/blankj/utilcode/util/ObjectUtils;
.super Ljava/lang/Object;
.source "ObjectUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static compare(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)I
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;TT;",
            "Ljava/util/Comparator<",
            "-TT;>;)I"
        }
    .end annotation

    if-ne p0, p1, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    .line 198
    :cond_4
    invoke-interface {p2, p0, p1}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p0

    :goto_8
    return p0
.end method

.method public static equals(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 2

    if-eq p0, p1, :cond_d

    if-eqz p0, :cond_b

    .line 188
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_b

    goto :goto_d

    :cond_b
    const/4 p0, 0x0

    goto :goto_e

    :cond_d
    :goto_d
    const/4 p0, 0x1

    :goto_e
    return p0
.end method

.method public static getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;TT;)TT;"
        }
    .end annotation

    if-nez p0, :cond_3

    return-object p1

    :cond_3
    return-object p0
.end method

.method public static hashCode(Ljava/lang/Object;)I
    .registers 1

    if-eqz p0, :cond_7

    .line 270
    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result p0

    goto :goto_8

    :cond_7
    const/4 p0, 0x0

    :goto_8
    return p0
.end method

.method public static varargs hashCodes([Ljava/lang/Object;)I
    .registers 1

    .line 277
    invoke-static {p0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method public static isEmpty(Landroid/util/LongSparseArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 124
    invoke-virtual {p0}, Landroid/util/LongSparseArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroid/util/SparseArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 102
    invoke-virtual {p0}, Landroid/util/SparseArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroid/util/SparseBooleanArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 106
    invoke-virtual {p0}, Landroid/util/SparseBooleanArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroid/util/SparseIntArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 110
    invoke-virtual {p0}, Landroid/util/SparseIntArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroid/util/SparseLongArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 119
    invoke-virtual {p0}, Landroid/util/SparseLongArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroidx/collection/LongSparseArray;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 114
    invoke-virtual {p0}, Landroidx/collection/LongSparseArray;->size()I

    move-result p0

    if-nez p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Landroidx/collection/SimpleArrayMap;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 98
    invoke-virtual {p0}, Landroidx/collection/SimpleArrayMap;->isEmpty()Z

    move-result p0

    if-eqz p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Ljava/lang/CharSequence;)Z
    .registers 1

    if-eqz p0, :cond_f

    .line 86
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result p0

    if-nez p0, :cond_d

    goto :goto_f

    :cond_d
    const/4 p0, 0x0

    goto :goto_10

    :cond_f
    :goto_f
    const/4 p0, 0x1

    :goto_10
    return p0
.end method

.method public static isEmpty(Ljava/lang/Object;)Z
    .registers 3

    const/4 v0, 0x1

    if-nez p0, :cond_4

    return v0

    .line 44
    :cond_4
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->isArray()Z

    move-result v1

    if-eqz v1, :cond_15

    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v1

    if-nez v1, :cond_15

    return v0

    .line 47
    :cond_15
    instance-of v1, p0, Ljava/lang/CharSequence;

    if-eqz v1, :cond_24

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_24

    return v0

    .line 50
    :cond_24
    instance-of v1, p0, Ljava/util/Collection;

    if-eqz v1, :cond_32

    move-object v1, p0

    check-cast v1, Ljava/util/Collection;

    invoke-interface {v1}, Ljava/util/Collection;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_32

    return v0

    .line 53
    :cond_32
    instance-of v1, p0, Ljava/util/Map;

    if-eqz v1, :cond_40

    move-object v1, p0

    check-cast v1, Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_40

    return v0

    .line 56
    :cond_40
    instance-of v1, p0, Landroidx/collection/SimpleArrayMap;

    if-eqz v1, :cond_4e

    move-object v1, p0

    check-cast v1, Landroidx/collection/SimpleArrayMap;

    invoke-virtual {v1}, Landroidx/collection/SimpleArrayMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4e

    return v0

    .line 59
    :cond_4e
    instance-of v1, p0, Landroid/util/SparseArray;

    if-eqz v1, :cond_5c

    move-object v1, p0

    check-cast v1, Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    if-nez v1, :cond_5c

    return v0

    .line 62
    :cond_5c
    instance-of v1, p0, Landroid/util/SparseBooleanArray;

    if-eqz v1, :cond_6a

    move-object v1, p0

    check-cast v1, Landroid/util/SparseBooleanArray;

    invoke-virtual {v1}, Landroid/util/SparseBooleanArray;->size()I

    move-result v1

    if-nez v1, :cond_6a

    return v0

    .line 65
    :cond_6a
    instance-of v1, p0, Landroid/util/SparseIntArray;

    if-eqz v1, :cond_78

    move-object v1, p0

    check-cast v1, Landroid/util/SparseIntArray;

    invoke-virtual {v1}, Landroid/util/SparseIntArray;->size()I

    move-result v1

    if-nez v1, :cond_78

    return v0

    .line 69
    :cond_78
    instance-of v1, p0, Landroid/util/SparseLongArray;

    if-eqz v1, :cond_86

    move-object v1, p0

    check-cast v1, Landroid/util/SparseLongArray;

    invoke-virtual {v1}, Landroid/util/SparseLongArray;->size()I

    move-result v1

    if-nez v1, :cond_86

    return v0

    .line 73
    :cond_86
    instance-of v1, p0, Landroidx/collection/LongSparseArray;

    if-eqz v1, :cond_94

    move-object v1, p0

    check-cast v1, Landroidx/collection/LongSparseArray;

    invoke-virtual {v1}, Landroidx/collection/LongSparseArray;->size()I

    move-result v1

    if-nez v1, :cond_94

    return v0

    .line 77
    :cond_94
    instance-of v1, p0, Landroid/util/LongSparseArray;

    if-eqz v1, :cond_a1

    check-cast p0, Landroid/util/LongSparseArray;

    .line 78
    invoke-virtual {p0}, Landroid/util/LongSparseArray;->size()I

    move-result p0

    if-nez p0, :cond_a1

    return v0

    :cond_a1
    const/4 p0, 0x0

    return p0
.end method

.method public static isEmpty(Ljava/util/Collection;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 90
    invoke-interface {p0}, Ljava/util/Collection;->isEmpty()Z

    move-result p0

    if-eqz p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isEmpty(Ljava/util/Map;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 94
    invoke-interface {p0}, Ljava/util/Map;->isEmpty()Z

    move-result p0

    if-eqz p0, :cond_9

    goto :goto_b

    :cond_9
    const/4 p0, 0x0

    goto :goto_c

    :cond_b
    :goto_b
    const/4 p0, 0x1

    :goto_c
    return p0
.end method

.method public static isNotEmpty(Landroid/util/LongSparseArray;)Z
    .registers 1

    .line 177
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroid/util/LongSparseArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroid/util/SparseArray;)Z
    .registers 1

    .line 155
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroid/util/SparseArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroid/util/SparseBooleanArray;)Z
    .registers 1

    .line 159
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroid/util/SparseBooleanArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroid/util/SparseIntArray;)Z
    .registers 1

    .line 163
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroid/util/SparseIntArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroid/util/SparseLongArray;)Z
    .registers 1

    .line 172
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroid/util/SparseLongArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroidx/collection/LongSparseArray;)Z
    .registers 1

    .line 167
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroidx/collection/LongSparseArray;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Landroidx/collection/SimpleArrayMap;)Z
    .registers 1

    .line 151
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Landroidx/collection/SimpleArrayMap;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Ljava/lang/CharSequence;)Z
    .registers 1

    .line 139
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Ljava/lang/Object;)Z
    .registers 1

    .line 134
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Ljava/util/Collection;)Z
    .registers 1

    .line 143
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isNotEmpty(Ljava/util/Map;)Z
    .registers 1

    .line 147
    invoke-static {p0}, Lcom/blankj/utilcode/util/ObjectUtils;->isEmpty(Ljava/util/Map;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)TT;"
        }
    .end annotation

    .line 205
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    return-object p0
.end method

.method public static requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    if-eqz p0, :cond_3

    return-object p0

    .line 214
    :cond_3
    new-instance p0, Ljava/lang/NullPointerException;

    invoke-direct {p0, p1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static varargs requireNonNulls([Ljava/lang/Object;)V
    .registers 4

    .line 225
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 226
    array-length v0, p0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_f

    aget-object v2, p0, v1

    .line 227
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_f
    return-void
.end method

.method public static toString(Ljava/lang/Object;)Ljava/lang/String;
    .registers 1

    .line 251
    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static toString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_6

    .line 260
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_6
    return-object p1
.end method
