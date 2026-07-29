.class public final Lcom/blankj/utilcode/util/CollectionUtils;
.super Ljava/lang/Object;
.source "CollectionUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/CollectionUtils$Predicate;,
        Lcom/blankj/utilcode/util/CollectionUtils$Transformer;,
        Lcom/blankj/utilcode/util/CollectionUtils$Closure;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static addAll(Ljava/util/Collection;Ljava/util/Enumeration;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Ljava/util/Enumeration<",
            "TE;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_13

    if-nez p1, :cond_5

    goto :goto_13

    :cond_5
    :goto_5
    invoke-interface {p1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v0

    if-eqz v0, :cond_13

    invoke-interface {p1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_5

    :cond_13
    :goto_13
    return-void
.end method

.method public static addAll(Ljava/util/Collection;Ljava/util/Iterator;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Ljava/util/Iterator<",
            "TE;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_13

    if-nez p1, :cond_5

    goto :goto_13

    :cond_5
    :goto_5
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_13

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_5

    :cond_13
    :goto_13
    return-void
.end method

.method public static addAll(Ljava/util/Collection;[Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;[TE;)V"
        }
    .end annotation

    if-eqz p0, :cond_f

    if-eqz p1, :cond_f

    array-length v0, p1

    if-nez v0, :cond_8

    goto :goto_f

    :cond_8
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    invoke-interface {p0, p1}, Ljava/util/Collection;->addAll(Ljava/util/Collection;)Z

    :cond_f
    :goto_f
    return-void
.end method

.method public static addIgnoreNull(Ljava/util/Collection;Ljava/lang/Object;)Z
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;TE;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-eqz p1, :cond_d

    invoke-interface {p0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_d

    const/4 v0, 0x1

    :cond_d
    return v0
.end method

.method public static cardinality(Ljava/lang/Object;Ljava/util/Collection;)I
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(TE;",
            "Ljava/util/Collection<",
            "TE;>;)I"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Ljava/util/Set;

    if-eqz v1, :cond_d

    invoke-interface {p1, p0}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result p0

    return p0

    :cond_d
    if-nez p0, :cond_22

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_13
    :goto_13
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_39

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    if-nez p1, :cond_13

    add-int/lit8 v0, v0, 0x1

    goto :goto_13

    :cond_22
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_26
    :goto_26
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_39

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_26

    add-int/lit8 v0, v0, 0x1

    goto :goto_26

    :cond_39
    return v0
.end method

.method public static collect(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Transformer;)Ljava/util/Collection;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E1:",
            "Ljava/lang/Object;",
            "E2:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE1;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Transformer<",
            "TE1;TE2;>;)",
            "Ljava/util/Collection<",
            "TE2;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p0, :cond_20

    if-nez p1, :cond_a

    goto :goto_20

    :cond_a
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_e
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_20

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Transformer;->transform(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_e

    :cond_20
    :goto_20
    return-object v0
.end method

.method public static containsAny(Ljava/util/Collection;Ljava/util/Collection;)Z
    .registers 6

    const/4 v0, 0x0

    if-eqz p0, :cond_3b

    if-nez p1, :cond_6

    goto :goto_3b

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v2

    const/4 v3, 0x1

    if-ge v1, v2, :cond_26

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_15
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3b

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_15

    return v3

    :cond_26
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_2a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3b

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p0, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2a

    return v3

    :cond_3b
    :goto_3b
    return v0
.end method

.method public static countMatches(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)I
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)I"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p0, :cond_1d

    if-nez p1, :cond_6

    goto :goto_1d

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_a
    :goto_a
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1d

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_1d
    :goto_1d
    return v0
.end method

.method public static disjunction(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 8

    if-nez p0, :cond_a

    if-nez p1, :cond_a

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0

    :cond_a
    if-nez p0, :cond_12

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p0

    :cond_12
    if-nez p1, :cond_1a

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p1

    :cond_1a
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v1

    invoke-static {p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v2

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3, p0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v3, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_33
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_5f

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v3

    invoke-static {p1, v2}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    invoke-static {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v4

    invoke-static {p1, v2}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v5

    invoke-static {v4, v5}, Ljava/lang/Math;->min(II)I

    move-result v4

    sub-int/2addr v3, v4

    const/4 v4, 0x0

    :goto_57
    if-ge v4, v3, :cond_33

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_57

    :cond_5f
    return-object v0
.end method

.method public static exists(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p0, :cond_1c

    if-nez p1, :cond_6

    goto :goto_1c

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_a
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    const/4 p0, 0x1

    return p0

    :cond_1c
    :goto_1c
    return v0
.end method

.method public static filter(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_1d

    if-nez p1, :cond_5

    goto :goto_1d

    :cond_5
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_9
    :goto_9
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    invoke-interface {p0}, Ljava/util/Iterator;->remove()V

    goto :goto_9

    :cond_1d
    :goto_1d
    return-void
.end method

.method public static find(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)Ljava/lang/Object;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)TE;"
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p0, :cond_1b

    if-nez p1, :cond_6

    goto :goto_1b

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_a
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    return-object v1

    :cond_1b
    :goto_1b
    return-object v0
.end method

.method public static forAllDo(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Closure;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Closure<",
            "TE;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_1b

    if-nez p1, :cond_5

    goto :goto_1b

    :cond_5
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    const/4 v0, 0x0

    :goto_a
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v2, v0, 0x1

    invoke-interface {p1, v0, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Closure;->execute(ILjava/lang/Object;)V

    move v0, v2

    goto :goto_a

    :cond_1b
    :goto_1b
    return-void
.end method

.method public static get(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    if-ltz p1, :cond_b9

    instance-of v0, p0, Ljava/util/Map;

    if-eqz v0, :cond_19

    check-cast p0, Ljava/util/Map;

    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object p0

    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_19
    instance-of v0, p0, Ljava/util/List;

    if-eqz v0, :cond_24

    check-cast p0, Ljava/util/List;

    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_24
    instance-of v0, p0, [Ljava/lang/Object;

    if-eqz v0, :cond_2d

    check-cast p0, [Ljava/lang/Object;

    aget-object p0, p0, p1

    return-object p0

    :cond_2d
    instance-of v0, p0, Ljava/util/Iterator;

    const-string v1, "Entry does not exist: "

    const/4 v2, -0x1

    if-eqz v0, :cond_5c

    check-cast p0, Ljava/util/Iterator;

    :goto_36
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_49

    add-int/lit8 p1, p1, -0x1

    if-ne p1, v2, :cond_45

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_45
    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_36

    :cond_49
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_5c
    instance-of v0, p0, Ljava/util/Collection;

    if-eqz v0, :cond_6b

    check-cast p0, Ljava/util/Collection;

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_6b
    instance-of v0, p0, Ljava/util/Enumeration;

    if-eqz v0, :cond_97

    check-cast p0, Ljava/util/Enumeration;

    :goto_71
    invoke-interface {p0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v0

    if-eqz v0, :cond_84

    add-int/lit8 p1, p1, -0x1

    if-ne p1, v2, :cond_80

    invoke-interface {p0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_80
    invoke-interface {p0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    goto :goto_71

    :cond_84
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_97
    :try_start_97
    invoke-static {p0, p1}, Ljava/lang/reflect/Array;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0
    :try_end_9b
    .catch Ljava/lang/IllegalArgumentException; {:try_start_97 .. :try_end_9b} :catch_9c

    return-object p0

    :catch_9c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Unsupported object type: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_b9
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Index cannot be negative: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/Object;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    if-nez p0, :cond_8

    return-object v0

    :cond_8
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_c
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_34

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    const/4 v3, 0x1

    if-nez v2, :cond_27

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_c

    :cond_27
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    add-int/2addr v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_c

    :cond_34
    return-object v0
.end method

.method private static getFreq(Ljava/lang/Object;Ljava/util/Map;)I
    .registers 2

    invoke-interface {p1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Integer;

    if-eqz p0, :cond_d

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    return p0

    :cond_d
    const/4 p0, 0x0

    return p0
.end method

.method public static intersection(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 7

    if-eqz p0, :cond_3e

    if-nez p1, :cond_5

    goto :goto_3e

    :cond_5
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v1

    invoke-static {p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v2

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3, p0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v3, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_1e
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_3d

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v3

    invoke-static {p1, v2}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    const/4 v4, 0x0

    :goto_35
    if-ge v4, v3, :cond_1e

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_35

    :cond_3d
    return-object v0

    :cond_3e
    :goto_3e
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0
.end method

.method public static isEmpty(Ljava/util/Collection;)Z
    .registers 1

    if-eqz p0, :cond_b

    invoke-interface {p0}, Ljava/util/Collection;->size()I

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

.method public static isEqualCollection(Ljava/util/Collection;Ljava/util/Collection;)Z
    .registers 6

    const/4 v0, 0x0

    if-eqz p0, :cond_43

    if-nez p1, :cond_6

    goto :goto_43

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v2

    if-eq v1, v2, :cond_11

    return v0

    :cond_11
    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p0}, Ljava/util/Map;->size()I

    move-result v1

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v2

    if-eq v1, v2, :cond_24

    return v0

    :cond_24
    invoke-interface {p0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_41

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2, p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v3

    invoke-static {v2, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v2

    if-eq v3, v2, :cond_2c

    return v0

    :cond_41
    const/4 p0, 0x1

    return p0

    :cond_43
    :goto_43
    return v0
.end method

.method public static isNotEmpty(Ljava/util/Collection;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method public static isProperSubCollection(Ljava/util/Collection;Ljava/util/Collection;)Z
    .registers 5

    const/4 v0, 0x0

    if-eqz p0, :cond_17

    if-nez p1, :cond_6

    goto :goto_17

    :cond_6
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v2

    if-ge v1, v2, :cond_17

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->isSubCollection(Ljava/util/Collection;Ljava/util/Collection;)Z

    move-result p0

    if-eqz p0, :cond_17

    const/4 v0, 0x1

    :cond_17
    :goto_17
    return v0
.end method

.method public static isSubCollection(Ljava/util/Collection;Ljava/util/Collection;)Z
    .registers 6

    const/4 v0, 0x0

    if-eqz p0, :cond_29

    if-nez p1, :cond_6

    goto :goto_29

    :cond_6
    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v1

    invoke-static {p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object p1

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_12
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_27

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v3

    invoke-static {v2, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v2

    if-le v3, v2, :cond_12

    return v0

    :cond_27
    const/4 p0, 0x1

    return p0

    :cond_29
    :goto_29
    return v0
.end method

.method public static varargs newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/ArrayList<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p0, :cond_17

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_17

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_17

    aget-object v3, p0, v2

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_17
    :goto_17
    return-object v0
.end method

.method public static varargs newArrayListNotNull([Ljava/lang/Object;)Ljava/util/ArrayList;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/ArrayList<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p0, :cond_1a

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1a

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1a

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_17

    :cond_14
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :goto_17
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1a
    :goto_1a
    return-object v0
.end method

.method public static varargs newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/HashSet<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    if-eqz p0, :cond_17

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_17

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_17

    aget-object v3, p0, v2

    invoke-virtual {v0, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_17
    :goto_17
    return-object v0
.end method

.method public static varargs newHashSetNotNull([Ljava/lang/Object;)Ljava/util/HashSet;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/HashSet<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    if-eqz p0, :cond_1a

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1a

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1a

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_17

    :cond_14
    invoke-virtual {v0, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    :goto_17
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1a
    :goto_1a
    return-object v0
.end method

.method public static varargs newLinkedList([Ljava/lang/Object;)Ljava/util/LinkedList;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/LinkedList<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    if-eqz p0, :cond_17

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_17

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_17

    aget-object v3, p0, v2

    invoke-virtual {v0, v3}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_17
    :goto_17
    return-object v0
.end method

.method public static varargs newLinkedListNotNull([Ljava/lang/Object;)Ljava/util/LinkedList;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/LinkedList<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    if-eqz p0, :cond_1a

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_1a

    :cond_b
    array-length v1, p0

    const/4 v2, 0x0

    :goto_d
    if-ge v2, v1, :cond_1a

    aget-object v3, p0, v2

    if-nez v3, :cond_14

    goto :goto_17

    :cond_14
    invoke-virtual {v0, v3}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    :goto_17
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    :cond_1a
    :goto_1a
    return-object v0
.end method

.method public static newSynchronizedCollection(Ljava/util/Collection;)Ljava/util/Collection;
    .registers 1

    invoke-static {p0}, Ljava/util/Collections;->synchronizedCollection(Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object p0

    return-object p0
.end method

.method public static varargs newTreeSet(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Comparator<",
            "TE;>;[TE;)",
            "Ljava/util/TreeSet<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0, p0}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    if-eqz p1, :cond_17

    array-length p0, p1

    if-nez p0, :cond_b

    goto :goto_17

    :cond_b
    array-length p0, p1

    const/4 v1, 0x0

    :goto_d
    if-ge v1, p0, :cond_17

    aget-object v2, p1, v1

    invoke-virtual {v0, v2}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    :cond_17
    :goto_17
    return-object v0
.end method

.method public static varargs newTreeSetNotNull(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Comparator<",
            "TE;>;[TE;)",
            "Ljava/util/TreeSet<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0, p0}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    if-eqz p1, :cond_1a

    array-length p0, p1

    if-nez p0, :cond_b

    goto :goto_1a

    :cond_b
    array-length p0, p1

    const/4 v1, 0x0

    :goto_d
    if-ge v1, p0, :cond_1a

    aget-object v2, p1, v1

    if-nez v2, :cond_14

    goto :goto_17

    :cond_14
    invoke-virtual {v0, v2}, Ljava/util/TreeSet;->add(Ljava/lang/Object;)Z

    :goto_17
    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    :cond_1a
    :goto_1a
    return-object v0
.end method

.method public static newUnmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;
    .registers 1

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object p0

    return-object p0
.end method

.method public static varargs newUnmodifiableList([Ljava/lang/Object;)Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/List<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object p0

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static varargs newUnmodifiableListNotNull([Ljava/lang/Object;)Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">([TE;)",
            "Ljava/util/List<",
            "TE;>;"
        }
    .end annotation

    .annotation runtime Ljava/lang/SafeVarargs;
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->newArrayListNotNull([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object p0

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static removeAll(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Ljava/util/Collection<",
            "TE;>;)",
            "Ljava/util/Collection<",
            "TE;>;"
        }
    .end annotation

    if-nez p0, :cond_8

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0

    :cond_8
    if-nez p1, :cond_10

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p1

    :cond_10
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_19
    :goto_19
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2d

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_19

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_19

    :cond_2d
    return-object v0
.end method

.method public static retainAll(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Ljava/util/Collection<",
            "TE;>;)",
            "Ljava/util/Collection<",
            "TE;>;"
        }
    .end annotation

    if-eqz p0, :cond_23

    if-nez p1, :cond_5

    goto :goto_23

    :cond_5
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_e
    :goto_e
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_22

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_e

    :cond_22
    return-object v0

    :cond_23
    :goto_23
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0
.end method

.method public static select(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)Ljava/util/Collection;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)",
            "Ljava/util/Collection<",
            "TE;>;"
        }
    .end annotation

    if-eqz p0, :cond_27

    if-nez p1, :cond_5

    goto :goto_27

    :cond_5
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_12
    :goto_12
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_26

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_12

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_12

    :cond_26
    return-object v0

    :cond_27
    :goto_27
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0
.end method

.method public static selectRejected(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Predicate;)Ljava/util/Collection;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Predicate<",
            "TE;>;)",
            "Ljava/util/Collection<",
            "TE;>;"
        }
    .end annotation

    if-eqz p0, :cond_27

    if-nez p1, :cond_5

    goto :goto_27

    :cond_5
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_12
    :goto_12
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_26

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils$Predicate;->evaluate(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_12

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_12

    :cond_26
    return-object v0

    :cond_27
    :goto_27
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0
.end method

.method public static shuffle(Ljava/util/List;)V
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List<",
            "TT;>;)V"
        }
    .end annotation

    invoke-static {p0}, Ljava/util/Collections;->shuffle(Ljava/util/List;)V

    return-void
.end method

.method public static size(Ljava/lang/Object;)I
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    instance-of v1, p0, Ljava/util/Map;

    if-eqz v1, :cond_f

    check-cast p0, Ljava/util/Map;

    invoke-interface {p0}, Ljava/util/Map;->size()I

    move-result p0

    goto :goto_4c

    :cond_f
    instance-of v1, p0, Ljava/util/Collection;

    if-eqz v1, :cond_1a

    check-cast p0, Ljava/util/Collection;

    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result p0

    goto :goto_4c

    :cond_1a
    instance-of v1, p0, [Ljava/lang/Object;

    if-eqz v1, :cond_22

    check-cast p0, [Ljava/lang/Object;

    array-length p0, p0

    goto :goto_4c

    :cond_22
    instance-of v1, p0, Ljava/util/Iterator;

    if-eqz v1, :cond_36

    check-cast p0, Ljava/util/Iterator;

    :goto_28
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_34

    add-int/lit8 v0, v0, 0x1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    goto :goto_28

    :cond_34
    move p0, v0

    goto :goto_4c

    :cond_36
    instance-of v1, p0, Ljava/util/Enumeration;

    if-eqz v1, :cond_48

    check-cast p0, Ljava/util/Enumeration;

    :goto_3c
    invoke-interface {p0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v1

    if-eqz v1, :cond_34

    add-int/lit8 v0, v0, 0x1

    invoke-interface {p0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    goto :goto_3c

    :cond_48
    :try_start_48
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result p0
    :try_end_4c
    .catch Ljava/lang/IllegalArgumentException; {:try_start_48 .. :try_end_4c} :catch_4d

    :goto_4c
    return p0

    :catch_4d
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unsupported object type: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static sizeIsEmpty(Ljava/lang/Object;)Z
    .registers 4

    const/4 v0, 0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    instance-of v1, p0, Ljava/util/Collection;

    if-eqz v1, :cond_f

    check-cast p0, Ljava/util/Collection;

    invoke-interface {p0}, Ljava/util/Collection;->isEmpty()Z

    move-result p0

    return p0

    :cond_f
    instance-of v1, p0, Ljava/util/Map;

    if-eqz v1, :cond_1a

    check-cast p0, Ljava/util/Map;

    invoke-interface {p0}, Ljava/util/Map;->isEmpty()Z

    move-result p0

    return p0

    :cond_1a
    instance-of v1, p0, [Ljava/lang/Object;

    const/4 v2, 0x0

    if-eqz v1, :cond_27

    check-cast p0, [Ljava/lang/Object;

    array-length p0, p0

    if-nez p0, :cond_25

    goto :goto_26

    :cond_25
    move v0, v2

    :goto_26
    return v0

    :cond_27
    instance-of v1, p0, Ljava/util/Iterator;

    if-eqz v1, :cond_33

    check-cast p0, Ljava/util/Iterator;

    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p0

    xor-int/2addr p0, v0

    return p0

    :cond_33
    instance-of v1, p0, Ljava/util/Enumeration;

    if-eqz v1, :cond_3f

    check-cast p0, Ljava/util/Enumeration;

    invoke-interface {p0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result p0

    xor-int/2addr p0, v0

    return p0

    :cond_3f
    :try_start_3f
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result p0
    :try_end_43
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3f .. :try_end_43} :catch_48

    if-nez p0, :cond_46

    goto :goto_47

    :cond_46
    move v0, v2

    :goto_47
    return v0

    :catch_48
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unsupported object type: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static subtract(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 3

    if-nez p0, :cond_8

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0

    :cond_8
    if-nez p1, :cond_10

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p1

    :cond_10
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_19
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_27

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_19

    :cond_27
    return-object v0
.end method

.method public static toString(Ljava/util/Collection;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, "null"

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static transform(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Transformer;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E1:",
            "Ljava/lang/Object;",
            "E2:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Collection<",
            "TE1;>;",
            "Lcom/blankj/utilcode/util/CollectionUtils$Transformer<",
            "TE1;TE2;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_2b

    if-nez p1, :cond_5

    goto :goto_2b

    :cond_5
    instance-of v0, p0, Ljava/util/List;

    if-eqz v0, :cond_21

    check-cast p0, Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object p0

    :goto_f
    invoke-interface {p0}, Ljava/util/ListIterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2b

    invoke-interface {p0}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/blankj/utilcode/util/CollectionUtils$Transformer;->transform(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/ListIterator;->set(Ljava/lang/Object;)V

    goto :goto_f

    :cond_21
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/CollectionUtils;->collect(Ljava/util/Collection;Lcom/blankj/utilcode/util/CollectionUtils$Transformer;)Ljava/util/Collection;

    move-result-object p1

    invoke-interface {p0}, Ljava/util/Collection;->clear()V

    invoke-interface {p0, p1}, Ljava/util/Collection;->addAll(Ljava/util/Collection;)Z

    :cond_2b
    :goto_2b
    return-void
.end method

.method public static union(Ljava/util/Collection;Ljava/util/Collection;)Ljava/util/Collection;
    .registers 7

    if-nez p0, :cond_a

    if-nez p1, :cond_a

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-object p0

    :cond_a
    if-nez p0, :cond_12

    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p0

    :cond_12
    if-nez p1, :cond_1a

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    return-object p1

    :cond_1a
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p0}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v1

    invoke-static {p1}, Lcom/blankj/utilcode/util/CollectionUtils;->getCardinalityMap(Ljava/util/Collection;)Ljava/util/Map;

    move-result-object v2

    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3, p0}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v3, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_33
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_52

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    invoke-static {p1, v1}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v3

    invoke-static {p1, v2}, Lcom/blankj/utilcode/util/CollectionUtils;->getFreq(Ljava/lang/Object;Ljava/util/Map;)I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    const/4 v4, 0x0

    :goto_4a
    if-ge v4, v3, :cond_33

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_4a

    :cond_52
    return-object v0
.end method
