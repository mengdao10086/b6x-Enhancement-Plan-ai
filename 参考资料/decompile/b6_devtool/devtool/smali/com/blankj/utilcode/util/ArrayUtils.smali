.class public Lcom/blankj/utilcode/util/ArrayUtils;
.super Ljava/lang/Object;
.source "ArrayUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/ArrayUtils$Closure;
    }
.end annotation


# static fields
.field public static final INDEX_NOT_FOUND:I = -0x1


# direct methods
.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static add([BB)[B
    .registers 3

    invoke-static {p1}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p1

    sget-object v0, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static add([BIB)[B
    .registers 4

    invoke-static {p2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object p2

    sget-object v0, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static add([BI[B)[B
    .registers 4

    sget-object v0, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [B

    return-object p0
.end method

.method public static add([B[B)[B
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static add([CC)[C
    .registers 3

    invoke-static {p1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object p1

    sget-object v0, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static add([CIC)[C
    .registers 4

    invoke-static {p2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object p2

    sget-object v0, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static add([CI[C)[C
    .registers 4

    sget-object v0, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [C

    return-object p0
.end method

.method public static add([C[C)[C
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static add([DD)[D
    .registers 3

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    sget-object p2, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static add([DID)[D
    .registers 4

    invoke-static {p2, p3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p2

    sget-object p3, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static add([DI[D)[D
    .registers 4

    sget-object v0, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [D

    return-object p0
.end method

.method public static add([D[D)[D
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static add([FF)[F
    .registers 3

    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p1

    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static add([FIF)[F
    .registers 4

    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p2

    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static add([FI[F)[F
    .registers 4

    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [F

    return-object p0
.end method

.method public static add([F[F)[F
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static add([II)[I
    .registers 3

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static add([III)[I
    .registers 4

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static add([II[I)[I
    .registers 4

    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [I

    return-object p0
.end method

.method public static add([I[I)[I
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static add([JIJ)[J
    .registers 4

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p2

    sget-object p3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [J

    return-object p0
.end method

.method public static add([JI[J)[J
    .registers 4

    sget-object v0, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [J

    return-object p0
.end method

.method public static add([JJ)[J
    .registers 3

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    sget-object p2, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [J

    return-object p0
.end method

.method public static add([J[J)[J
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [J

    return-object p0
.end method

.method public static add([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;ITT;)[TT;"
        }
    .end annotation

    if-eqz p0, :cond_b

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    goto :goto_11

    :cond_b
    if-eqz p2, :cond_18

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    :goto_11
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0

    :cond_18
    const/4 p0, 0x1

    new-array p0, p0, [Ljava/lang/Object;

    const/4 p1, 0x0

    const/4 p2, 0x0

    aput-object p2, p0, p1

    return-object p0
.end method

.method public static add([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;I[TT;)[TT;"
        }
    .end annotation

    if-eqz p0, :cond_b

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    goto :goto_15

    :cond_b
    if-eqz p2, :cond_1c

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    :goto_15
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0

    :cond_1c
    const/4 p0, 0x0

    return-object p0
.end method

.method public static add([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;TT;)[TT;"
        }
    .end annotation

    if-eqz p0, :cond_7

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_10

    :cond_7
    if-eqz p1, :cond_e

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    goto :goto_10

    :cond_e
    const-class v0, Ljava/lang/Object;

    :goto_10
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static add([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;[TT;)[TT;"
        }
    .end annotation

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static add([SIS)[S
    .registers 4

    invoke-static {p2}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object p2

    sget-object v0, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static add([SI[S)[S
    .registers 4

    sget-object v0, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [S

    return-object p0
.end method

.method public static add([SS)[S
    .registers 3

    invoke-static {p1}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object p1

    sget-object v0, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static add([S[S)[S
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static add([ZIZ)[Z
    .registers 4

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p2

    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static add([ZI[Z)[Z
    .registers 4

    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    :cond_a
    check-cast p0, [Z

    return-object p0
.end method

.method public static add([ZZ)[Z
    .registers 3

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static add([Z[Z)[Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static varargs asArrayList([Ljava/lang/Object;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p0, :cond_12

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_12

    :cond_b
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    invoke-interface {v0, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_12
    :goto_12
    return-object v0
.end method

.method public static varargs asLinkedList([Ljava/lang/Object;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    if-eqz p0, :cond_12

    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_12

    :cond_b
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    invoke-interface {v0, p0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_12
    :goto_12
    return-object v0
.end method

.method public static varargs asList([Ljava/lang/Object;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    if-eqz p0, :cond_b

    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_b

    :cond_6
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    return-object p0

    :cond_b
    :goto_b
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static varargs asUnmodifiableList([Ljava/lang/Object;)Ljava/util/List;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static contains([BB)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([BB)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([CC)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([CC)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([DD)Z
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DD)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([DDD)Z
    .registers 11

    const/4 v3, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DDID)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_d

    const/4 p0, 0x1

    goto :goto_e

    :cond_d
    const/4 p0, 0x0

    :goto_e
    return p0
.end method

.method public static contains([FF)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([FF)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([II)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([II)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([JJ)Z
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([JJ)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([SS)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([SS)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static contains([ZZ)Z
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([ZZ)I

    move-result p0

    const/4 p1, -0x1

    if-eq p0, p1, :cond_9

    const/4 p0, 0x1

    goto :goto_a

    :cond_9
    const/4 p0, 0x0

    :goto_a
    return p0
.end method

.method public static copy([B)[B
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([BII)[B

    move-result-object p0

    return-object p0
.end method

.method public static copy([C)[C
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([CII)[C

    move-result-object p0

    return-object p0
.end method

.method public static copy([D)[D
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([DII)[D

    move-result-object p0

    return-object p0
.end method

.method public static copy([F)[F
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([FII)[F

    move-result-object p0

    return-object p0
.end method

.method public static copy([I)[I
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([III)[I

    move-result-object p0

    return-object p0
.end method

.method public static copy([J)[J
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([JII)[J

    move-result-object p0

    return-object p0
.end method

.method public static copy([Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([Ljava/lang/Object;II)[Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static copy([S)[S
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([SII)[S

    move-result-object p0

    return-object p0
.end method

.method public static copy([Z)[Z
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([ZII)[Z

    move-result-object p0

    return-object p0
.end method

.method public static equals([B[B)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result p0

    return p0
.end method

.method public static equals([C[C)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([C[C)Z

    move-result p0

    return p0
.end method

.method public static equals([D[D)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([D[D)Z

    move-result p0

    return p0
.end method

.method public static equals([F[F)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([F[F)Z

    move-result p0

    return p0
.end method

.method public static equals([I[I)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([I[I)Z

    move-result p0

    return p0
.end method

.method public static equals([Ljava/lang/Object;[Ljava/lang/Object;)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->deepEquals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static equals([S[S)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([S[S)Z

    move-result p0

    return p0
.end method

.method public static equals([Z[Z)Z
    .registers 2

    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([Z[Z)Z

    move-result p0

    return p0
.end method

.method public static forAllDo(Ljava/lang/Object;Lcom/blankj/utilcode/util/ArrayUtils$Closure;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Object;",
            "Lcom/blankj/utilcode/util/ArrayUtils$Closure<",
            "TE;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_dd

    if-nez p1, :cond_6

    goto/16 :goto_dd

    :cond_6
    instance-of v0, p0, [Ljava/lang/Object;

    const/4 v1, 0x0

    if-eqz v0, :cond_18

    check-cast p0, [Ljava/lang/Object;

    array-length v0, p0

    :goto_e
    if-ge v1, v0, :cond_c3

    aget-object v2, p0, v1

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_18
    instance-of v0, p0, [Z

    if-eqz v0, :cond_30

    check-cast p0, [Z

    array-length v0, p0

    :goto_1f
    if-ge v1, v0, :cond_c3

    aget-boolean v2, p0, v1

    if-eqz v2, :cond_28

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_2a

    :cond_28
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_2a
    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1f

    :cond_30
    instance-of v0, p0, [B

    if-eqz v0, :cond_45

    check-cast p0, [B

    array-length v0, p0

    :goto_37
    if-ge v1, v0, :cond_c3

    aget-byte v2, p0, v1

    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_37

    :cond_45
    instance-of v0, p0, [C

    if-eqz v0, :cond_5a

    check-cast p0, [C

    array-length v0, p0

    :goto_4c
    if-ge v1, v0, :cond_c3

    aget-char v2, p0, v1

    invoke-static {v2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_4c

    :cond_5a
    instance-of v0, p0, [S

    if-eqz v0, :cond_6f

    check-cast p0, [S

    array-length v0, p0

    :goto_61
    if-ge v1, v0, :cond_c3

    aget-short v2, p0, v1

    invoke-static {v2}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_61

    :cond_6f
    instance-of v0, p0, [I

    if-eqz v0, :cond_84

    check-cast p0, [I

    array-length v0, p0

    :goto_76
    if-ge v1, v0, :cond_c3

    aget v2, p0, v1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_76

    :cond_84
    instance-of v0, p0, [J

    if-eqz v0, :cond_99

    check-cast p0, [J

    array-length v0, p0

    :goto_8b
    if-ge v1, v0, :cond_c3

    aget-wide v2, p0, v1

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_8b

    :cond_99
    instance-of v0, p0, [F

    if-eqz v0, :cond_ae

    check-cast p0, [F

    array-length v0, p0

    :goto_a0
    if-ge v1, v0, :cond_c3

    aget v2, p0, v1

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_a0

    :cond_ae
    instance-of v0, p0, [D

    if-eqz v0, :cond_c4

    check-cast p0, [D

    array-length v0, p0

    :goto_b5
    if-ge v1, v0, :cond_c3

    aget-wide v2, p0, v1

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_b5

    :cond_c3
    return-void

    :cond_c4
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Not an array: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_dd
    :goto_dd
    return-void
.end method

.method public static get(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->get(Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static get(Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    .registers 3

    if-nez p0, :cond_3

    return-object p2

    :cond_3
    :try_start_3
    invoke-static {p0, p1}, Ljava/lang/reflect/Array;->get(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_7} :catch_8

    return-object p0

    :catch_8
    return-object p2
.end method

.method public static getLength(Ljava/lang/Object;)I
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method public static indexOf([BB)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([BBI)I

    move-result p0

    return p0
.end method

.method public static indexOf([BBI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    const/4 p2, 0x0

    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    aget-byte v1, p0, p2

    if-ne p1, v1, :cond_f

    return p2

    :cond_f
    add-int/lit8 p2, p2, 0x1

    goto :goto_7

    :cond_12
    return v0
.end method

.method public static indexOf([CC)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([CCI)I

    move-result p0

    return p0
.end method

.method public static indexOf([CCI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    const/4 p2, 0x0

    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    aget-char v1, p0, p2

    if-ne p1, v1, :cond_f

    return p2

    :cond_f
    add-int/lit8 p2, p2, 0x1

    goto :goto_7

    :cond_12
    return v0
.end method

.method public static indexOf([DD)I
    .registers 4

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DDI)I

    move-result p0

    return p0
.end method

.method public static indexOf([DDD)I
    .registers 11

    const/4 v3, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DDID)I

    move-result p0

    return p0
.end method

.method public static indexOf([DDI)I
    .registers 8

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    const/4 p3, 0x0

    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p3, v0, :cond_18

    aget-wide v2, p0, p3

    cmpl-double v0, p1, v2

    if-nez v0, :cond_15

    return p3

    :cond_15
    add-int/lit8 p3, p3, 0x1

    goto :goto_b

    :cond_18
    return v1
.end method

.method public static indexOf([DDID)I
    .registers 10

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    const/4 p3, 0x0

    :cond_b
    sub-double v2, p1, p4

    add-double/2addr p1, p4

    :goto_e
    array-length p4, p0

    if-ge p3, p4, :cond_1f

    aget-wide p4, p0, p3

    cmpl-double v0, p4, v2

    if-ltz v0, :cond_1c

    cmpg-double p4, p4, p1

    if-gtz p4, :cond_1c

    return p3

    :cond_1c
    add-int/lit8 p3, p3, 0x1

    goto :goto_e

    :cond_1f
    return v1
.end method

.method public static indexOf([FF)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([FFI)I

    move-result p0

    return p0
.end method

.method public static indexOf([FFI)I
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    const/4 p2, 0x0

    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p2, v0, :cond_18

    aget v0, p0, p2

    cmpl-float v0, p1, v0

    if-nez v0, :cond_15

    return p2

    :cond_15
    add-int/lit8 p2, p2, 0x1

    goto :goto_b

    :cond_18
    return v1
.end method

.method public static indexOf([II)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([III)I

    move-result p0

    return p0
.end method

.method public static indexOf([III)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    const/4 p2, 0x0

    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    aget v1, p0, p2

    if-ne p1, v1, :cond_f

    return p2

    :cond_f
    add-int/lit8 p2, p2, 0x1

    goto :goto_7

    :cond_12
    return v0
.end method

.method public static indexOf([JJ)I
    .registers 4

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([JJI)I

    move-result p0

    return p0
.end method

.method public static indexOf([JJI)I
    .registers 7

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p3, :cond_7

    const/4 p3, 0x0

    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p3, v1, :cond_14

    aget-wide v1, p0, p3

    cmp-long v1, p1, v1

    if-nez v1, :cond_11

    return p3

    :cond_11
    add-int/lit8 p3, p3, 0x1

    goto :goto_7

    :cond_14
    return v0
.end method

.method public static indexOf([Ljava/lang/Object;Ljava/lang/Object;)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([Ljava/lang/Object;Ljava/lang/Object;I)I

    move-result p0

    return p0
.end method

.method public static indexOf([Ljava/lang/Object;Ljava/lang/Object;I)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    const/4 p2, 0x0

    :cond_7
    if-nez p1, :cond_14

    :goto_9
    array-length p1, p0

    if-ge p2, p1, :cond_23

    aget-object p1, p0, p2

    if-nez p1, :cond_11

    return p2

    :cond_11
    add-int/lit8 p2, p2, 0x1

    goto :goto_9

    :cond_14
    :goto_14
    array-length v1, p0

    if-ge p2, v1, :cond_23

    aget-object v1, p0, p2

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_20

    return p2

    :cond_20
    add-int/lit8 p2, p2, 0x1

    goto :goto_14

    :cond_23
    return v0
.end method

.method public static indexOf([SS)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([SSI)I

    move-result p0

    return p0
.end method

.method public static indexOf([SSI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    const/4 p2, 0x0

    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    aget-short v1, p0, p2

    if-ne p1, v1, :cond_f

    return p2

    :cond_f
    add-int/lit8 p2, p2, 0x1

    goto :goto_7

    :cond_12
    return v0
.end method

.method public static indexOf([ZZ)I
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([ZZI)I

    move-result p0

    return p0
.end method

.method public static indexOf([ZZI)I
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    const/4 p2, 0x0

    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p2, v0, :cond_16

    aget-boolean v0, p0, p2

    if-ne p1, v0, :cond_13

    return p2

    :cond_13
    add-int/lit8 p2, p2, 0x1

    goto :goto_b

    :cond_16
    return v1
.end method

.method public static isEmpty(Ljava/lang/Object;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p0

    if-nez p0, :cond_8

    const/4 p0, 0x1

    goto :goto_9

    :cond_8
    const/4 p0, 0x0

    :goto_9
    return p0
.end method

.method public static isSameLength(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p1

    if-ne p0, p1, :cond_c

    const/4 p0, 0x1

    goto :goto_d

    :cond_c
    const/4 p0, 0x0

    :goto_d
    return p0
.end method

.method public static lastIndexOf([BB)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([BBI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([BBI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    aget-byte v1, p0, p2

    if-ne p1, v1, :cond_14

    return p2

    :cond_14
    add-int/lit8 p2, p2, -0x1

    goto :goto_d

    :cond_17
    return v0
.end method

.method public static lastIndexOf([CC)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([CCI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([CCI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    aget-char v1, p0, p2

    if-ne p1, v1, :cond_14

    return p2

    :cond_14
    add-int/lit8 p2, p2, -0x1

    goto :goto_d

    :cond_17
    return v0
.end method

.method public static lastIndexOf([DD)I
    .registers 4

    const v0, 0x7fffffff

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([DDI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([DDD)I
    .registers 11

    const v3, 0x7fffffff

    move-object v0, p0

    move-wide v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([DDID)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([DDI)I
    .registers 8

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    return v1

    :cond_b
    array-length v0, p0

    if-lt p3, v0, :cond_11

    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_11
    :goto_11
    if-ltz p3, :cond_1d

    aget-wide v2, p0, p3

    cmpl-double v0, p1, v2

    if-nez v0, :cond_1a

    return p3

    :cond_1a
    add-int/lit8 p3, p3, -0x1

    goto :goto_11

    :cond_1d
    return v1
.end method

.method public static lastIndexOf([DDID)I
    .registers 10

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    return v1

    :cond_b
    array-length v0, p0

    if-lt p3, v0, :cond_11

    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_11
    sub-double v2, p1, p4

    add-double/2addr p1, p4

    :goto_14
    if-ltz p3, :cond_24

    aget-wide p4, p0, p3

    cmpl-double v0, p4, v2

    if-ltz v0, :cond_21

    cmpg-double p4, p4, p1

    if-gtz p4, :cond_21

    return p3

    :cond_21
    add-int/lit8 p3, p3, -0x1

    goto :goto_14

    :cond_24
    return v1
.end method

.method public static lastIndexOf([FF)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([FFI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([FFI)I
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    return v1

    :cond_b
    array-length v0, p0

    if-lt p2, v0, :cond_11

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_11
    :goto_11
    if-ltz p2, :cond_1d

    aget v0, p0, p2

    cmpl-float v0, p1, v0

    if-nez v0, :cond_1a

    return p2

    :cond_1a
    add-int/lit8 p2, p2, -0x1

    goto :goto_11

    :cond_1d
    return v1
.end method

.method public static lastIndexOf([II)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([III)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([III)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    aget v1, p0, p2

    if-ne p1, v1, :cond_14

    return p2

    :cond_14
    add-int/lit8 p2, p2, -0x1

    goto :goto_d

    :cond_17
    return v0
.end method

.method public static lastIndexOf([JJ)I
    .registers 4

    const v0, 0x7fffffff

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([JJI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([JJI)I
    .registers 7

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p3, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p3, v1, :cond_d

    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_d
    :goto_d
    if-ltz p3, :cond_19

    aget-wide v1, p0, p3

    cmp-long v1, p1, v1

    if-nez v1, :cond_16

    return p3

    :cond_16
    add-int/lit8 p3, p3, -0x1

    goto :goto_d

    :cond_19
    return v0
.end method

.method public static lastIndexOf([Ljava/lang/Object;Ljava/lang/Object;)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([Ljava/lang/Object;Ljava/lang/Object;I)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([Ljava/lang/Object;Ljava/lang/Object;I)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    if-nez p1, :cond_19

    :goto_f
    if-ltz p2, :cond_27

    aget-object p1, p0, p2

    if-nez p1, :cond_16

    return p2

    :cond_16
    add-int/lit8 p2, p2, -0x1

    goto :goto_f

    :cond_19
    :goto_19
    if-ltz p2, :cond_27

    aget-object v1, p0, p2

    invoke-virtual {p1, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_24

    return p2

    :cond_24
    add-int/lit8 p2, p2, -0x1

    goto :goto_19

    :cond_27
    return v0
.end method

.method public static lastIndexOf([SS)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([SSI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([SSI)I
    .registers 5

    const/4 v0, -0x1

    if-nez p0, :cond_4

    return v0

    :cond_4
    if-gez p2, :cond_7

    return v0

    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    aget-short v1, p0, p2

    if-ne p1, v1, :cond_14

    return p2

    :cond_14
    add-int/lit8 p2, p2, -0x1

    goto :goto_d

    :cond_17
    return v0
.end method

.method public static lastIndexOf([ZZ)I
    .registers 3

    const v0, 0x7fffffff

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([ZZI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([ZZI)I
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    return v1

    :cond_b
    array-length v0, p0

    if-lt p2, v0, :cond_11

    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_11
    :goto_11
    if-ltz p2, :cond_1b

    aget-boolean v0, p0, p2

    if-ne p1, v0, :cond_18

    return p2

    :cond_18
    add-int/lit8 p2, p2, -0x1

    goto :goto_11

    :cond_1b
    return v1
.end method

.method public static varargs newArray([Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    return-object p0
.end method

.method public static varargs newBooleanArray([Z)[Z
    .registers 1

    return-object p0
.end method

.method public static varargs newByteArray([B)[B
    .registers 1

    return-object p0
.end method

.method public static varargs newCharArray([C)[C
    .registers 1

    return-object p0
.end method

.method public static varargs newDoubleArray([D)[D
    .registers 1

    return-object p0
.end method

.method public static varargs newFloatArray([F)[F
    .registers 1

    return-object p0
.end method

.method public static varargs newIntArray([I)[I
    .registers 1

    return-object p0
.end method

.method public static varargs newLongArray([J)[J
    .registers 1

    return-object p0
.end method

.method public static varargs newShortArray([S)[S
    .registers 1

    return-object p0
.end method

.method private static realAdd(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .registers 7

    const-string v0, "Index: "

    const/4 v1, 0x0

    if-nez p0, :cond_29

    if-nez p1, :cond_10

    const/4 p0, 0x1

    invoke-static {p3, p0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p0

    invoke-static {p0, v1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    return-object p0

    :cond_10
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, ", Length: 0"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_29
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v2

    if-gt p1, v2, :cond_46

    if-ltz p1, :cond_46

    add-int/lit8 v0, v2, 0x1

    invoke-static {p3, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p3

    invoke-static {p0, v1, p3, v1, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p3, p1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    if-ge p1, v2, :cond_45

    add-int/lit8 p2, p1, 0x1

    sub-int/2addr v2, p1

    invoke-static {p0, p1, p3, p2, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_45
    return-object p3

    :cond_46
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, ", Length: "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .registers 7

    if-nez p0, :cond_6

    if-nez p2, :cond_6

    const/4 p0, 0x0

    return-object p0

    :cond_6
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p3

    invoke-static {p2}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    const-string v1, "Index: "

    if-nez p3, :cond_32

    if-nez p1, :cond_19

    invoke-static {p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_19
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, ", array1 Length: 0"

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_32
    if-nez v0, :cond_39

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_39
    if-gt p1, p3, :cond_6a

    if-ltz p1, :cond_6a

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int v2, p3, v0

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x0

    if-ne p1, p3, :cond_55

    invoke-static {p0, v2, v1, v2, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p2, v2, v1, p3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_69

    :cond_55
    if-nez p1, :cond_5e

    invoke-static {p2, v2, v1, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p0, v2, v1, v0, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_69

    :cond_5e
    invoke-static {p0, v2, v1, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p2, v2, v1, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/2addr v0, p1

    sub-int/2addr p3, p1

    invoke-static {p0, p1, v1, v0, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_69
    return-object v1

    :cond_6a
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p2, ", array1 Length: "

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 6

    if-nez p0, :cond_6

    if-nez p1, :cond_6

    const/4 p0, 0x0

    return-object p0

    :cond_6
    if-nez p0, :cond_d

    invoke-static {p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_d
    if-nez p1, :cond_14

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_14
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    invoke-static {p1}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    add-int v3, v0, v1

    invoke-static {v2, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {p0, v3, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {p1, v3, v2, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

.method private static realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .registers 6

    const/4 v0, 0x0

    if-eqz p0, :cond_1a

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int/lit8 v2, p2, 0x1

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p0, v0, v1, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move v0, p2

    goto :goto_1f

    :cond_1a
    const/4 p0, 0x1

    invoke-static {p2, p0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    :goto_1f
    invoke-static {v1, v0, p1}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    return-object v1
.end method

.method private static realCopy(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v1

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method private static realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, 0x0

    if-gez p1, :cond_8

    move p1, v0

    :cond_8
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v1

    if-le p2, v1, :cond_f

    move p2, v1

    :cond_f
    sub-int/2addr p2, p1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    if-gtz p2, :cond_1f

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_1f
    invoke-static {v1, p2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {p0, p1, v1, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v1
.end method

.method private static remove(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 6

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    if-ltz p1, :cond_25

    if-ge p1, v0, :cond_25

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int/lit8 v2, v0, -0x1

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    const/4 v3, 0x0

    invoke-static {p0, v3, v1, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    if-ge p1, v2, :cond_24

    add-int/lit8 v2, p1, 0x1

    sub-int/2addr v0, p1

    add-int/lit8 v0, v0, -0x1

    invoke-static {p0, v2, v1, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_24
    return-object v1

    :cond_25
    new-instance p0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Index: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v1, ", Length: "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static remove([BI)[B
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static remove([CI)[C
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static remove([DI)[D
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static remove([FI)[F
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static remove([II)[I
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static remove([JI)[J
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [J

    return-object p0
.end method

.method public static remove([Ljava/lang/Object;I)[Ljava/lang/Object;
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static remove([SI)[S
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static remove([ZI)[Z
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static removeElement([BB)[B
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([BB)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([B)[B

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([BI)[B

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([CC)[C
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([CC)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([C)[C

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([CI)[C

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([DD)[D
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DD)I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([D)[D

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([DI)[D

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([FF)[F
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([FF)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([F)[F

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([FI)[F

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([II)[I
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([II)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([I)[I

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([II)[I

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([JJ)[J
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([JJ)I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([J)[J

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([JI)[J

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([SS)[S
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([SS)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([S)[S

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([SI)[S

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([ZZ)[Z
    .registers 3

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([ZZ)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([Z)[Z

    move-result-object p0

    return-object p0

    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([ZI)[Z

    move-result-object p0

    return-object p0
.end method

.method public static reverse([B)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-byte v2, p0, v0

    aget-byte v3, p0, v1

    aput-byte v3, p0, v0

    aput-byte v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([C)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-char v2, p0, v0

    aget-char v3, p0, v1

    aput-char v3, p0, v0

    aput-char v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([D)V
    .registers 7

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-wide v2, p0, v0

    aget-wide v4, p0, v1

    aput-wide v4, p0, v0

    aput-wide v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([F)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget v2, p0, v0

    aget v3, p0, v1

    aput v3, p0, v0

    aput v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([I)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget v2, p0, v0

    aget v3, p0, v1

    aput v3, p0, v0

    aput v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([J)V
    .registers 7

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-wide v2, p0, v0

    aget-wide v4, p0, v1

    aput-wide v4, p0, v0

    aput-wide v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([Ljava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)V"
        }
    .end annotation

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-object v2, p0, v0

    aget-object v3, p0, v1

    aput-object v3, p0, v0

    aput-object v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([S)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-short v2, p0, v0

    aget-short v3, p0, v1

    aput-short v3, p0, v0

    aput-short v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static reverse([Z)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    aget-boolean v2, p0, v0

    aget-boolean v3, p0, v1

    aput-boolean v3, p0, v0

    aput-boolean v2, p0, v1

    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_16
    return-void
.end method

.method public static set(Ljava/lang/Object;ILjava/lang/Object;)V
    .registers 3

    if-nez p0, :cond_3

    return-void

    :cond_3
    invoke-static {p0, p1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    return-void
.end method

.method public static sort([B)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([B)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([C)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([C)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([D)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([D)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([F)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([F)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([I)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([I)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([J)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([J)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([Ljava/lang/Object;Ljava/util/Comparator;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;",
            "Ljava/util/Comparator<",
            "-TT;>;)V"
        }
    .end annotation

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0, p1}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([S)V
    .registers 3

    if-eqz p0, :cond_a

    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([S)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static subArray([BII)[B
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static subArray([CII)[C
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static subArray([DII)[D
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static subArray([FII)[F
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static subArray([III)[I
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static subArray([JII)[J
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [J

    return-object p0
.end method

.method public static subArray([Ljava/lang/Object;II)[Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;II)[TT;"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static subArray([SII)[S
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static subArray([ZII)[Z
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static toObject([Z)[Ljava/lang/Boolean;
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Boolean;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Boolean;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1f

    aget-boolean v2, p0, v1

    if-eqz v2, :cond_18

    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_1a

    :cond_18
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_1a
    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1f
    return-object v0
.end method

.method public static toObject([B)[Ljava/lang/Byte;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Byte;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Byte;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Byte;

    aget-byte v3, p0, v1

    invoke-direct {v2, v3}, Ljava/lang/Byte;-><init>(B)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([C)[Ljava/lang/Character;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Character;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Character;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Character;

    aget-char v3, p0, v1

    invoke-direct {v2, v3}, Ljava/lang/Character;-><init>(C)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([D)[Ljava/lang/Double;
    .registers 6

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Double;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Double;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Double;

    aget-wide v3, p0, v1

    invoke-direct {v2, v3, v4}, Ljava/lang/Double;-><init>(D)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([F)[Ljava/lang/Float;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Float;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Float;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Float;

    aget v3, p0, v1

    invoke-direct {v2, v3}, Ljava/lang/Float;-><init>(F)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([I)[Ljava/lang/Integer;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Integer;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Integer;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Integer;

    aget v3, p0, v1

    invoke-direct {v2, v3}, Ljava/lang/Integer;-><init>(I)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([J)[Ljava/lang/Long;
    .registers 6

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Long;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Long;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Long;

    aget-wide v3, p0, v1

    invoke-direct {v2, v3, v4}, Ljava/lang/Long;-><init>(J)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toObject([S)[Ljava/lang/Short;
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Short;

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Short;

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    new-instance v2, Ljava/lang/Short;

    aget-short v3, p0, v1

    invoke-direct {v2, v3}, Ljava/lang/Short;-><init>(S)V

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1d
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Byte;)[B
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [B

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [B

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Byte;->byteValue()B

    move-result v2

    aput-byte v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Byte;B)[B
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [B

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [B

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Byte;->byteValue()B

    move-result v2

    :goto_1b
    aput-byte v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Character;)[C
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [C

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [C

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Character;->charValue()C

    move-result v2

    aput-char v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Character;C)[C
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [C

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [C

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Character;->charValue()C

    move-result v2

    :goto_1b
    aput-char v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Double;)[D
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [D

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [D

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    aput-wide v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Double;D)[D
    .registers 7

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [D

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [D

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move-wide v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    :goto_1b
    aput-wide v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Float;)[F
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [F

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [F

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    aput v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Float;F)[F
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [F

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [F

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    :goto_1b
    aput v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Integer;)[I
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [I

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [I

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    aput v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Integer;I)[I
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [I

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [I

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    :goto_1b
    aput v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Long;)[J
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [J

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [J

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    aput-wide v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Long;J)[J
    .registers 7

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [J

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [J

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move-wide v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    :goto_1b
    aput-wide v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Short;)[S
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [S

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [S

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Short;->shortValue()S

    move-result v2

    aput-short v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Short;S)[S
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [S

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [S

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Short;->shortValue()S

    move-result v2

    :goto_1b
    aput-short v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Boolean;)[Z
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Z

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Z

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    aget-object v2, p0, v1

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    aput-boolean v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1c
    return-object v0
.end method

.method public static toPrimitive([Ljava/lang/Boolean;Z)[Z
    .registers 5

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Z

    return-object p0

    :cond_b
    array-length v0, p0

    new-array v0, v0, [Z

    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    :cond_17
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    :goto_1b
    aput-boolean v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_20
    return-object v0
.end method

.method public static toString(Ljava/lang/Object;)Ljava/lang/String;
    .registers 4

    if-nez p0, :cond_5

    const-string p0, "null"

    return-object p0

    :cond_5
    instance-of v0, p0, [Ljava/lang/Object;

    if-eqz v0, :cond_10

    check-cast p0, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/util/Arrays;->deepToString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_10
    instance-of v0, p0, [Z

    if-eqz v0, :cond_1b

    check-cast p0, [Z

    invoke-static {p0}, Ljava/util/Arrays;->toString([Z)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1b
    instance-of v0, p0, [B

    if-eqz v0, :cond_26

    check-cast p0, [B

    invoke-static {p0}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_26
    instance-of v0, p0, [C

    if-eqz v0, :cond_31

    check-cast p0, [C

    invoke-static {p0}, Ljava/util/Arrays;->toString([C)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_31
    instance-of v0, p0, [D

    if-eqz v0, :cond_3c

    check-cast p0, [D

    invoke-static {p0}, Ljava/util/Arrays;->toString([D)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_3c
    instance-of v0, p0, [F

    if-eqz v0, :cond_47

    check-cast p0, [F

    invoke-static {p0}, Ljava/util/Arrays;->toString([F)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_47
    instance-of v0, p0, [I

    if-eqz v0, :cond_52

    check-cast p0, [I

    invoke-static {p0}, Ljava/util/Arrays;->toString([I)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_52
    instance-of v0, p0, [J

    if-eqz v0, :cond_5d

    check-cast p0, [J

    invoke-static {p0}, Ljava/util/Arrays;->toString([J)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_5d
    instance-of v0, p0, [S

    if-eqz v0, :cond_68

    check-cast p0, [S

    invoke-static {p0}, Ljava/util/Arrays;->toString([S)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_68
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Array has incompatible type: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
