.class public Lcom/blankj/utilcode/util/MapUtils;
.super Ljava/lang/Object;
.source "MapUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/MapUtils$Transformer;,
        Lcom/blankj/utilcode/util/MapUtils$Closure;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static forAllDo(Ljava/util/Map;Lcom/blankj/utilcode/util/MapUtils$Closure;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map<",
            "TK;TV;>;",
            "Lcom/blankj/utilcode/util/MapUtils$Closure<",
            "TK;TV;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_25

    if-nez p1, :cond_5

    goto :goto_25

    .line 140
    :cond_5
    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p0

    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_d
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_25

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 141
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Lcom/blankj/utilcode/util/MapUtils$Closure;->execute(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_d

    :cond_25
    :goto_25
    return-void
.end method

.method public static isEmpty(Ljava/util/Map;)Z
    .registers 1

    if-eqz p0, :cond_b

    .line 104
    invoke-interface {p0}, Ljava/util/Map;->size()I

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

.method public static isNotEmpty(Ljava/util/Map;)Z
    .registers 1

    .line 116
    invoke-static {p0}, Lcom/blankj/utilcode/util/MapUtils;->isEmpty(Ljava/util/Map;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static varargs newHashMap([Landroid/util/Pair;)Ljava/util/HashMap;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">([",
            "Landroid/util/Pair<",
            "TK;TV;>;)",
            "Ljava/util/HashMap<",
            "TK;TV;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    if-eqz p0, :cond_1e

    .line 42
    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1e

    .line 45
    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1e

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_1b

    .line 47
    :cond_14
    iget-object v4, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object v3, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v0, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1e
    :goto_1e
    return-object v0
.end method

.method public static varargs newHashTable([Landroid/util/Pair;)Ljava/util/Hashtable;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">([",
            "Landroid/util/Pair<",
            "TK;TV;>;)",
            "Ljava/util/Hashtable<",
            "TK;TV;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .line 84
    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    if-eqz p0, :cond_1e

    .line 85
    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1e

    .line 88
    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1e

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_1b

    .line 90
    :cond_14
    iget-object v4, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object v3, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v0, v4, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1e
    :goto_1e
    return-object v0
.end method

.method public static varargs newLinkedHashMap([Landroid/util/Pair;)Ljava/util/LinkedHashMap;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">([",
            "Landroid/util/Pair<",
            "TK;TV;>;)",
            "Ljava/util/LinkedHashMap<",
            "TK;TV;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .line 54
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    if-eqz p0, :cond_1e

    .line 55
    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1e

    .line 58
    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1e

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_1b

    .line 60
    :cond_14
    iget-object v4, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object v3, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v0, v4, v3}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_1b
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1e
    :goto_1e
    return-object v0
.end method

.method public static varargs newTreeMap(Ljava/util/Comparator;[Landroid/util/Pair;)Ljava/util/TreeMap;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Comparator<",
            "TK;>;[",
            "Landroid/util/Pair<",
            "TK;TV;>;)",
            "Ljava/util/TreeMap<",
            "TK;TV;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    if-eqz p0, :cond_21

    .line 71
    new-instance v0, Ljava/util/TreeMap;

    invoke-direct {v0, p0}, Ljava/util/TreeMap;-><init>(Ljava/util/Comparator;)V

    if-eqz p1, :cond_20

    .line 72
    array-length p0, p1

    if-nez p0, :cond_d

    goto :goto_20

    .line 75
    :cond_d
    array-length p0, p1

    const/4 v1, 0x0

    :goto_f
    if-ge v1, p0, :cond_20

    aget-object v2, p1, v1

    if-nez v2, :cond_16

    goto :goto_1d

    .line 77
    :cond_16
    iget-object v3, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    iget-object v2, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v0, v3, v2}, Ljava/util/TreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    :cond_20
    :goto_20
    return-object v0

    .line 69
    :cond_21
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "comparator must not be null"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static varargs newUnmodifiableMap([Landroid/util/Pair;)Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "V:",
            "Ljava/lang/Object;",
            ">([",
            "Landroid/util/Pair<",
            "TK;TV;>;)",
            "Ljava/util/Map<",
            "TK;TV;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    .line 36
    invoke-static {p0}, Lcom/blankj/utilcode/util/MapUtils;->newHashMap([Landroid/util/Pair;)Ljava/util/HashMap;

    move-result-object p0

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object p0

    return-object p0
.end method

.method public static size(Ljava/util/Map;)I
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    .line 127
    :cond_4
    invoke-interface {p0}, Ljava/util/Map;->size()I

    move-result p0

    return p0
.end method

.method public static toString(Ljava/util/Map;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, "null"

    return-object p0

    .line 181
    :cond_5
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static transform(Ljava/util/Map;Lcom/blankj/utilcode/util/MapUtils$Transformer;)Ljava/util/Map;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K1:",
            "Ljava/lang/Object;",
            "V1:",
            "Ljava/lang/Object;",
            "K2:",
            "Ljava/lang/Object;",
            "V2:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map<",
            "TK1;TV1;>;",
            "Lcom/blankj/utilcode/util/MapUtils$Transformer<",
            "TK1;TV1;TK2;TV2;>;)",
            "Ljava/util/Map<",
            "TK2;TV2;>;"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p0, :cond_22

    if-nez p1, :cond_6

    goto :goto_22

    .line 156
    :cond_6
    :try_start_6
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 157
    new-instance v2, Lcom/blankj/utilcode/util/MapUtils$1;

    invoke-direct {v2, p1, v1}, Lcom/blankj/utilcode/util/MapUtils$1;-><init>(Lcom/blankj/utilcode/util/MapUtils$Transformer;Ljava/util/Map;)V

    invoke-static {p0, v2}, Lcom/blankj/utilcode/util/MapUtils;->forAllDo(Ljava/util/Map;Lcom/blankj/utilcode/util/MapUtils$Closure;)V
    :try_end_18
    .catch Ljava/lang/IllegalAccessException; {:try_start_6 .. :try_end_18} :catch_1e
    .catch Ljava/lang/InstantiationException; {:try_start_6 .. :try_end_18} :catch_19

    return-object v1

    :catch_19
    move-exception p0

    .line 168
    invoke-virtual {p0}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_22

    :catch_1e
    move-exception p0

    .line 166
    invoke-virtual {p0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    :cond_22
    :goto_22
    return-object v0
.end method
