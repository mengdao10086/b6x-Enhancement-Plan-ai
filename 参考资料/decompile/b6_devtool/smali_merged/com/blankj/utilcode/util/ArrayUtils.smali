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

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static add([BB)[B
    .registers 3

    .line 531
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

    .line 841
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

    .line 716
    sget-object v0, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 718
    :cond_a
    check-cast p0, [B

    return-object p0
.end method

.method public static add([B[B)[B
    .registers 2

    .line 616
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static add([CC)[C
    .registers 3

    .line 536
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

    .line 836
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

    .line 709
    sget-object v0, Ljava/lang/Character;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 711
    :cond_a
    check-cast p0, [C

    return-object p0
.end method

.method public static add([C[C)[C
    .registers 2

    .line 611
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static add([DD)[D
    .registers 3

    .line 541
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

    .line 866
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

    .line 751
    sget-object v0, Ljava/lang/Double;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 753
    :cond_a
    check-cast p0, [D

    return-object p0
.end method

.method public static add([D[D)[D
    .registers 2

    .line 641
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static add([FF)[F
    .registers 3

    .line 546
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

    .line 861
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

    .line 744
    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 746
    :cond_a
    check-cast p0, [F

    return-object p0
.end method

.method public static add([F[F)[F
    .registers 2

    .line 636
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static add([II)[I
    .registers 3

    .line 551
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

    .line 851
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

    .line 730
    sget-object v0, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 732
    :cond_a
    check-cast p0, [I

    return-object p0
.end method

.method public static add([I[I)[I
    .registers 2

    .line 626
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static add([JIJ)[J
    .registers 4

    .line 856
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

    .line 737
    sget-object v0, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 739
    :cond_a
    check-cast p0, [J

    return-object p0
.end method

.method public static add([JJ)[J
    .registers 3

    .line 556
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

    .line 631
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

    .line 820
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    goto :goto_11

    :cond_b
    if-eqz p2, :cond_18

    .line 822
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 826
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

    .line 692
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    goto :goto_15

    :cond_b
    if-eqz p2, :cond_1c

    .line 694
    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v0

    .line 698
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

    .line 520
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

    .line 521
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

    .line 601
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static add([SIS)[S
    .registers 4

    .line 846
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

    .line 723
    sget-object v0, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 725
    :cond_a
    check-cast p0, [S

    return-object p0
.end method

.method public static add([SS)[S
    .registers 3

    .line 561
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

    .line 621
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static add([ZIZ)[Z
    .registers 4

    .line 831
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

    .line 703
    sget-object v0, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->realAddArr(Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    if-nez p0, :cond_a

    const/4 p0, 0x0

    return-object p0

    .line 705
    :cond_a
    check-cast p0, [Z

    return-object p0
.end method

.method public static add([ZZ)[Z
    .registers 3

    .line 526
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

    .line 606
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

    .line 1986
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p0, :cond_12

    .line 1987
    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_12

    .line 1988
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

    .line 1994
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    if-eqz p0, :cond_12

    .line 1995
    array-length v1, p0

    if-nez v1, :cond_b

    goto :goto_12

    .line 1996
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

    .line 1973
    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_b

    .line 1976
    :cond_6
    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    return-object p0

    .line 1974
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

    .line 1981
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    invoke-static {p0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static contains([BB)Z
    .registers 2

    .line 1400
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

    .line 1352
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

    .line 1492
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

    .line 1496
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

    .line 1544
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

    .line 1256
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

    .line 1208
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

    .line 1160
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

    .line 1304
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

    .line 1592
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

    .line 393
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

    .line 387
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

    .line 399
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

    .line 405
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

    .line 375
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

    .line 369
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

    .line 363
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

    .line 381
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

    .line 411
    array-length v1, p0

    invoke-static {p0, v0, v1}, Lcom/blankj/utilcode/util/ArrayUtils;->subArray([ZII)[Z

    move-result-object p0

    return-object p0
.end method

.method public static equals([B[B)Z
    .registers 2

    .line 164
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result p0

    return p0
.end method

.method public static equals([C[C)Z
    .registers 2

    .line 168
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([C[C)Z

    move-result p0

    return p0
.end method

.method public static equals([D[D)Z
    .registers 2

    .line 172
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([D[D)Z

    move-result p0

    return p0
.end method

.method public static equals([F[F)Z
    .registers 2

    .line 176
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([F[F)Z

    move-result p0

    return p0
.end method

.method public static equals([I[I)Z
    .registers 2

    .line 180
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([I[I)Z

    move-result p0

    return p0
.end method

.method public static equals([Ljava/lang/Object;[Ljava/lang/Object;)Z
    .registers 2

    .line 156
    invoke-static {p0, p1}, Ljava/util/Arrays;->deepEquals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static equals([S[S)Z
    .registers 2

    .line 184
    invoke-static {p0, p1}, Ljava/util/Arrays;->equals([S[S)Z

    move-result p0

    return p0
.end method

.method public static equals([Z[Z)Z
    .registers 2

    .line 160
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

    .line 2050
    :cond_6
    instance-of v0, p0, [Ljava/lang/Object;

    const/4 v1, 0x0

    if-eqz v0, :cond_18

    .line 2051
    check-cast p0, [Ljava/lang/Object;

    .line 2052
    array-length v0, p0

    :goto_e
    if-ge v1, v0, :cond_c3

    .line 2053
    aget-object v2, p0, v1

    .line 2054
    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    .line 2056
    :cond_18
    instance-of v0, p0, [Z

    if-eqz v0, :cond_30

    .line 2057
    check-cast p0, [Z

    .line 2058
    array-length v0, p0

    :goto_1f
    if-ge v1, v0, :cond_c3

    .line 2059
    aget-boolean v2, p0, v1

    if-eqz v2, :cond_28

    .line 2060
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_2a

    :cond_28
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_2a
    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_1f

    .line 2062
    :cond_30
    instance-of v0, p0, [B

    if-eqz v0, :cond_45

    .line 2063
    check-cast p0, [B

    .line 2064
    array-length v0, p0

    :goto_37
    if-ge v1, v0, :cond_c3

    .line 2065
    aget-byte v2, p0, v1

    .line 2066
    invoke-static {v2}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_37

    .line 2068
    :cond_45
    instance-of v0, p0, [C

    if-eqz v0, :cond_5a

    .line 2069
    check-cast p0, [C

    .line 2070
    array-length v0, p0

    :goto_4c
    if-ge v1, v0, :cond_c3

    .line 2071
    aget-char v2, p0, v1

    .line 2072
    invoke-static {v2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_4c

    .line 2074
    :cond_5a
    instance-of v0, p0, [S

    if-eqz v0, :cond_6f

    .line 2075
    check-cast p0, [S

    .line 2076
    array-length v0, p0

    :goto_61
    if-ge v1, v0, :cond_c3

    .line 2077
    aget-short v2, p0, v1

    .line 2078
    invoke-static {v2}, Ljava/lang/Short;->valueOf(S)Ljava/lang/Short;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_61

    .line 2080
    :cond_6f
    instance-of v0, p0, [I

    if-eqz v0, :cond_84

    .line 2081
    check-cast p0, [I

    .line 2082
    array-length v0, p0

    :goto_76
    if-ge v1, v0, :cond_c3

    .line 2083
    aget v2, p0, v1

    .line 2084
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_76

    .line 2086
    :cond_84
    instance-of v0, p0, [J

    if-eqz v0, :cond_99

    .line 2087
    check-cast p0, [J

    .line 2088
    array-length v0, p0

    :goto_8b
    if-ge v1, v0, :cond_c3

    .line 2089
    aget-wide v2, p0, v1

    .line 2090
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_8b

    .line 2092
    :cond_99
    instance-of v0, p0, [F

    if-eqz v0, :cond_ae

    .line 2093
    check-cast p0, [F

    .line 2094
    array-length v0, p0

    :goto_a0
    if-ge v1, v0, :cond_c3

    .line 2095
    aget v2, p0, v1

    .line 2096
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_a0

    .line 2098
    :cond_ae
    instance-of v0, p0, [D

    if-eqz v0, :cond_c4

    .line 2099
    check-cast p0, [D

    .line 2100
    array-length v0, p0

    :goto_b5
    if-ge v1, v0, :cond_c3

    .line 2101
    aget-wide v2, p0, v1

    .line 2102
    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lcom/blankj/utilcode/util/ArrayUtils$Closure;->execute(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_b5

    :cond_c3
    return-void

    .line 2105
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

    .line 115
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->get(Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static get(Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    .registers 3

    if-nez p0, :cond_3

    return-object p2

    .line 130
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

    .line 99
    :cond_4
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method public static indexOf([BB)I
    .registers 3

    const/4 v0, 0x0

    .line 1360
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

    .line 1370
    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    .line 1371
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

    .line 1312
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

    .line 1322
    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    .line 1323
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

    .line 1408
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

    .line 1412
    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DDID)I

    move-result p0

    return p0
.end method

.method public static indexOf([DDI)I
    .registers 8

    .line 1416
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    const/4 p3, 0x0

    .line 1422
    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p3, v0, :cond_18

    .line 1423
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

    .line 1431
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

    .line 1439
    :goto_e
    array-length p4, p0

    if-ge p3, p4, :cond_1f

    .line 1440
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

    .line 1504
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([FFI)I

    move-result p0

    return p0
.end method

.method public static indexOf([FFI)I
    .registers 5

    .line 1508
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    const/4 p2, 0x0

    .line 1514
    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p2, v0, :cond_18

    .line 1515
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

    .line 1216
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

    .line 1226
    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    .line 1227
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

    .line 1168
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

    .line 1178
    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p3, v1, :cond_14

    .line 1179
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

    .line 1104
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

    .line 1115
    :goto_9
    array-length p1, p0

    if-ge p2, p1, :cond_23

    .line 1116
    aget-object p1, p0, p2

    if-nez p1, :cond_11

    return p2

    :cond_11
    add-int/lit8 p2, p2, 0x1

    goto :goto_9

    .line 1121
    :cond_14
    :goto_14
    array-length v1, p0

    if-ge p2, v1, :cond_23

    .line 1122
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

    .line 1264
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

    .line 1274
    :cond_7
    :goto_7
    array-length v1, p0

    if-ge p2, v1, :cond_12

    .line 1275
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

    .line 1552
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([ZZI)I

    move-result p0

    return p0
.end method

.method public static indexOf([ZZI)I
    .registers 5

    .line 1556
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    const/4 p2, 0x0

    .line 1562
    :cond_b
    :goto_b
    array-length v0, p0

    if-ge p2, v0, :cond_16

    .line 1563
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

    .line 88
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

    .line 103
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

    .line 1379
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

    .line 1388
    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    .line 1389
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    .line 1392
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

    .line 1331
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

    .line 1340
    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    .line 1341
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    .line 1344
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

    .line 1448
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

    .line 1452
    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([DDID)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([DDI)I
    .registers 8

    .line 1456
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    return v1

    .line 1461
    :cond_b
    array-length v0, p0

    if-lt p3, v0, :cond_11

    .line 1462
    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_11
    :goto_11
    if-ltz p3, :cond_1d

    .line 1465
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

    .line 1473
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p3, :cond_b

    return v1

    .line 1478
    :cond_b
    array-length v0, p0

    if-lt p3, v0, :cond_11

    .line 1479
    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_11
    sub-double v2, p1, p4

    add-double/2addr p1, p4

    :goto_14
    if-ltz p3, :cond_24

    .line 1484
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

    .line 1523
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([FFI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([FFI)I
    .registers 5

    .line 1527
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    return v1

    .line 1532
    :cond_b
    array-length v0, p0

    if-lt p2, v0, :cond_11

    .line 1533
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_11
    :goto_11
    if-ltz p2, :cond_1d

    .line 1536
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

    .line 1235
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

    .line 1244
    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    .line 1245
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    .line 1248
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

    .line 1187
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

    .line 1196
    :cond_7
    array-length v1, p0

    if-lt p3, v1, :cond_d

    .line 1197
    array-length p3, p0

    add-int/lit8 p3, p3, -0x1

    :cond_d
    :goto_d
    if-ltz p3, :cond_19

    .line 1200
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

    .line 1131
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

    .line 1140
    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    .line 1141
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    if-nez p1, :cond_19

    :goto_f
    if-ltz p2, :cond_27

    .line 1145
    aget-object p1, p0, p2

    if-nez p1, :cond_16

    return p2

    :cond_16
    add-int/lit8 p2, p2, -0x1

    goto :goto_f

    :cond_19
    :goto_19
    if-ltz p2, :cond_27

    .line 1151
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

    .line 1283
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

    .line 1292
    :cond_7
    array-length v1, p0

    if-lt p2, v1, :cond_d

    .line 1293
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_d
    :goto_d
    if-ltz p2, :cond_17

    .line 1296
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

    .line 1571
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ArrayUtils;->lastIndexOf([ZZI)I

    move-result p0

    return p0
.end method

.method public static lastIndexOf([ZZI)I
    .registers 5

    .line 1575
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_8

    return v1

    :cond_8
    if-gez p2, :cond_b

    return v1

    .line 1580
    :cond_b
    array-length v0, p0

    if-lt p2, v0, :cond_11

    .line 1581
    array-length p2, p0

    add-int/lit8 p2, p2, -0x1

    :cond_11
    :goto_11
    if-ltz p2, :cond_1b

    .line 1584
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

    .line 875
    invoke-static {p3, p0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p0

    .line 876
    invoke-static {p0, v1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    return-object p0

    .line 873
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

    .line 879
    :cond_29
    invoke-static {p0}, Ljava/lang/reflect/Array;->getLength(Ljava/lang/Object;)I

    move-result v2

    if-gt p1, v2, :cond_46

    if-ltz p1, :cond_46

    add-int/lit8 v0, v2, 0x1

    .line 883
    invoke-static {p3, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p3

    .line 884
    invoke-static {p0, v1, p3, v1, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 885
    invoke-static {p3, p1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    if-ge p1, v2, :cond_45

    add-int/lit8 p2, p1, 0x1

    sub-int/2addr v2, p1

    .line 887
    invoke-static {p0, p1, p3, p2, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_45
    return-object p3

    .line 881
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

    .line 759
    :cond_6
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p3

    .line 760
    invoke-static {p2}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    const-string v1, "Index: "

    if-nez p3, :cond_32

    if-nez p1, :cond_19

    .line 765
    invoke-static {p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    .line 763
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

    .line 768
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_39
    if-gt p1, p3, :cond_6a

    if-ltz p1, :cond_6a

    .line 773
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int v2, p3, v0

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x0

    if-ne p1, p3, :cond_55

    .line 775
    invoke-static {p0, v2, v1, v2, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 776
    invoke-static {p2, v2, v1, p3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_69

    :cond_55
    if-nez p1, :cond_5e

    .line 778
    invoke-static {p2, v2, v1, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 779
    invoke-static {p0, v2, v1, v0, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_69

    .line 781
    :cond_5e
    invoke-static {p0, v2, v1, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 782
    invoke-static {p2, v2, v1, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/2addr v0, p1

    sub-int/2addr p3, p1

    .line 783
    invoke-static {p0, p1, v1, v0, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_69
    return-object v1

    .line 771
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

    .line 647
    invoke-static {p1}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_d
    if-nez p1, :cond_14

    .line 650
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->realCopy(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    .line 652
    :cond_14
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    .line 653
    invoke-static {p1}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v1

    .line 654
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    add-int v3, v0, v1

    invoke-static {v2, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    const/4 v3, 0x0

    .line 655
    invoke-static {p0, v3, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 656
    invoke-static {p1, v3, v2, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method

.method private static realAddOne(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    .registers 6

    const/4 v0, 0x0

    if-eqz p0, :cond_1a

    .line 569
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result p2

    .line 570
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int/lit8 v2, p2, 0x1

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    .line 571
    invoke-static {p0, v0, v1, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move v0, p2

    goto :goto_1f

    :cond_1a
    const/4 p0, 0x1

    .line 573
    invoke-static {p2, p0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    .line 575
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

    .line 417
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

    .line 478
    :cond_8
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v1

    if-le p2, v1, :cond_f

    move p2, v1

    :cond_f
    sub-int/2addr p2, p1

    .line 483
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    if-gtz p2, :cond_1f

    .line 485
    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    .line 487
    :cond_1f
    invoke-static {v1, p2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    .line 488
    invoke-static {p0, p1, v1, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v1
.end method

.method private static remove(Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 6

    .line 1085
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->getLength(Ljava/lang/Object;)I

    move-result v0

    if-ltz p1, :cond_25

    if-ge p1, v0, :cond_25

    .line 1090
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    add-int/lit8 v2, v0, -0x1

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    const/4 v3, 0x0

    .line 1091
    invoke-static {p0, v3, v1, v3, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    if-ge p1, v2, :cond_24

    add-int/lit8 v2, p1, 0x1

    sub-int/2addr v0, p1

    add-int/lit8 v0, v0, -0x1

    .line 1093
    invoke-static {p0, v2, v1, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_24
    return-object v1

    .line 1087
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

    .line 980
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

    .line 995
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

    .line 1010
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

    .line 1026
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

    .line 1041
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

    .line 1056
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

    .line 926
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

    .line 1071
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

    .line 965
    :cond_4
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Z

    return-object p0
.end method

.method public static removeElement([BB)[B
    .registers 3

    .line 985
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([BB)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 987
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([B)[B

    move-result-object p0

    return-object p0

    .line 989
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([BI)[B

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([CC)[C
    .registers 3

    .line 1000
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([CC)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 1002
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([C)[C

    move-result-object p0

    return-object p0

    .line 1004
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([CI)[C

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([DD)[D
    .registers 3

    .line 1015
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([DD)I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_c

    .line 1017
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([D)[D

    move-result-object p0

    return-object p0

    .line 1020
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([DI)[D

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([FF)[F
    .registers 3

    .line 1031
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([FF)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 1033
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([F)[F

    move-result-object p0

    return-object p0

    .line 1035
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([FI)[F

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([II)[I
    .registers 3

    .line 1046
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([II)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 1048
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([I)[I

    move-result-object p0

    return-object p0

    .line 1050
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([II)[I

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([JJ)[J
    .registers 3

    .line 1061
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([JJ)I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_c

    .line 1063
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([J)[J

    move-result-object p0

    return-object p0

    .line 1065
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([JI)[J

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 3

    .line 955
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 957
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    return-object p0

    .line 959
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([SS)[S
    .registers 3

    .line 1076
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([SS)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 1078
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([S)[S

    move-result-object p0

    return-object p0

    .line 1080
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([SI)[S

    move-result-object p0

    return-object p0
.end method

.method public static removeElement([ZZ)[Z
    .registers 3

    .line 970
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->indexOf([ZZ)I

    move-result p1

    const/4 v0, -0x1

    if-ne p1, v0, :cond_c

    .line 972
    invoke-static {p0}, Lcom/blankj/utilcode/util/ArrayUtils;->copy([Z)[Z

    move-result-object p0

    return-object p0

    .line 974
    :cond_c
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/ArrayUtils;->remove([ZI)[Z

    move-result-object p0

    return-object p0
.end method

.method public static reverse([B)V
    .registers 5

    if-nez p0, :cond_3

    return-void

    .line 285
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 288
    aget-byte v2, p0, v0

    .line 289
    aget-byte v3, p0, v1

    aput-byte v3, p0, v0

    .line 290
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

    .line 269
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 272
    aget-char v2, p0, v0

    .line 273
    aget-char v3, p0, v1

    aput-char v3, p0, v0

    .line 274
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

    .line 301
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 304
    aget-wide v2, p0, v0

    .line 305
    aget-wide v4, p0, v1

    aput-wide v4, p0, v0

    .line 306
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

    .line 317
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 320
    aget v2, p0, v0

    .line 321
    aget v3, p0, v1

    aput v3, p0, v0

    .line 322
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

    .line 237
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 240
    aget v2, p0, v0

    .line 241
    aget v3, p0, v1

    aput v3, p0, v0

    .line 242
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

    .line 221
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 224
    aget-wide v2, p0, v0

    .line 225
    aget-wide v4, p0, v1

    aput-wide v4, p0, v0

    .line 226
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

    .line 205
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 208
    aget-object v2, p0, v0

    .line 209
    aget-object v3, p0, v1

    aput-object v3, p0, v0

    .line 210
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

    .line 253
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 256
    aget-short v2, p0, v0

    .line 257
    aget-short v3, p0, v1

    aput-short v3, p0, v0

    .line 258
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

    .line 333
    :cond_3
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    const/4 v1, 0x0

    :goto_7
    if-le v0, v1, :cond_16

    .line 336
    aget-boolean v2, p0, v0

    .line 337
    aget-boolean v3, p0, v1

    aput-boolean v3, p0, v0

    .line 338
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

    .line 145
    :cond_3
    invoke-static {p0, p1, p2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    return-void
.end method

.method public static sort([B)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2006
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2007
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([B)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([C)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2011
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2012
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([C)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([D)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2016
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2017
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([D)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([F)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2021
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2022
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([F)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([I)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2026
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2027
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([I)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([J)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2031
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2032
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

    .line 2001
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2002
    :cond_7
    invoke-static {p0, p1}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static sort([S)V
    .registers 3

    if-eqz p0, :cond_a

    .line 2036
    array-length v0, p0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_7

    goto :goto_a

    .line 2037
    :cond_7
    invoke-static {p0}, Ljava/util/Arrays;->sort([S)V

    :cond_a
    :goto_a
    return-void
.end method

.method public static subArray([BII)[B
    .registers 3

    .line 452
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [B

    return-object p0
.end method

.method public static subArray([CII)[C
    .registers 3

    .line 447
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [C

    return-object p0
.end method

.method public static subArray([DII)[D
    .registers 3

    .line 457
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [D

    return-object p0
.end method

.method public static subArray([FII)[F
    .registers 3

    .line 462
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [F

    return-object p0
.end method

.method public static subArray([III)[I
    .registers 3

    .line 437
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [I

    return-object p0
.end method

.method public static subArray([JII)[J
    .registers 3

    .line 432
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

    .line 427
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/Object;

    return-object p0
.end method

.method public static subArray([SII)[S
    .registers 3

    .line 442
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ArrayUtils;->realSubArray(Ljava/lang/Object;II)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [S

    return-object p0
.end method

.method public static subArray([ZII)[Z
    .registers 3

    .line 467
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

    .line 1961
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Boolean;

    return-object p0

    .line 1964
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Boolean;

    .line 1965
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1f

    .line 1966
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

    .line 1820
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Byte;

    return-object p0

    .line 1823
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Byte;

    .line 1824
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1825
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

    .line 1632
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Character;

    return-object p0

    .line 1635
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Character;

    .line 1636
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1637
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

    .line 1867
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Double;

    return-object p0

    .line 1870
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Double;

    .line 1871
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1872
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

    .line 1914
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Float;

    return-object p0

    .line 1917
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Float;

    .line 1918
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1919
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

    .line 1726
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Integer;

    return-object p0

    .line 1729
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Integer;

    .line 1730
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1731
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

    .line 1679
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Long;

    return-object p0

    .line 1682
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Long;

    .line 1683
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1684
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

    .line 1773
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Ljava/lang/Short;

    return-object p0

    .line 1776
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Ljava/lang/Short;

    .line 1777
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1d

    .line 1778
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

    .line 1791
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [B

    return-object p0

    .line 1794
    :cond_b
    array-length v0, p0

    new-array v0, v0, [B

    .line 1795
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1796
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

    .line 1805
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [B

    return-object p0

    .line 1808
    :cond_b
    array-length v0, p0

    new-array v0, v0, [B

    .line 1809
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1810
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1811
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

    .line 1603
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [C

    return-object p0

    .line 1606
    :cond_b
    array-length v0, p0

    new-array v0, v0, [C

    .line 1607
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1608
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

    .line 1617
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [C

    return-object p0

    .line 1620
    :cond_b
    array-length v0, p0

    new-array v0, v0, [C

    .line 1621
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1622
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1623
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

    .line 1838
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [D

    return-object p0

    .line 1841
    :cond_b
    array-length v0, p0

    new-array v0, v0, [D

    .line 1842
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1843
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

    .line 1852
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [D

    return-object p0

    .line 1855
    :cond_b
    array-length v0, p0

    new-array v0, v0, [D

    .line 1856
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1857
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move-wide v2, p1

    goto :goto_1b

    .line 1858
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

    .line 1885
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [F

    return-object p0

    .line 1888
    :cond_b
    array-length v0, p0

    new-array v0, v0, [F

    .line 1889
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1890
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

    .line 1899
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [F

    return-object p0

    .line 1902
    :cond_b
    array-length v0, p0

    new-array v0, v0, [F

    .line 1903
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1904
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1905
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

    .line 1697
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [I

    return-object p0

    .line 1700
    :cond_b
    array-length v0, p0

    new-array v0, v0, [I

    .line 1701
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1702
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

    .line 1711
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [I

    return-object p0

    .line 1714
    :cond_b
    array-length v0, p0

    new-array v0, v0, [I

    .line 1715
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1716
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1717
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

    .line 1650
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [J

    return-object p0

    .line 1653
    :cond_b
    array-length v0, p0

    new-array v0, v0, [J

    .line 1654
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1655
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

    .line 1664
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [J

    return-object p0

    .line 1667
    :cond_b
    array-length v0, p0

    new-array v0, v0, [J

    .line 1668
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1669
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move-wide v2, p1

    goto :goto_1b

    .line 1670
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

    .line 1744
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [S

    return-object p0

    .line 1747
    :cond_b
    array-length v0, p0

    new-array v0, v0, [S

    .line 1748
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1749
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

    .line 1758
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [S

    return-object p0

    .line 1761
    :cond_b
    array-length v0, p0

    new-array v0, v0, [S

    .line 1762
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1763
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1764
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

    .line 1932
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Z

    return-object p0

    .line 1935
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Z

    .line 1936
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_1c

    .line 1937
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

    .line 1946
    :cond_4
    array-length v0, p0

    const/4 v1, 0x0

    if-nez v0, :cond_b

    new-array p0, v1, [Z

    return-object p0

    .line 1949
    :cond_b
    array-length v0, p0

    new-array v0, v0, [Z

    .line 1950
    :goto_e
    array-length v2, p0

    if-ge v1, v2, :cond_20

    .line 1951
    aget-object v2, p0, v1

    if-nez v2, :cond_17

    move v2, p1

    goto :goto_1b

    .line 1952
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

    .line 2118
    :cond_5
    instance-of v0, p0, [Ljava/lang/Object;

    if-eqz v0, :cond_10

    .line 2119
    check-cast p0, [Ljava/lang/Object;

    invoke-static {p0}, Ljava/util/Arrays;->deepToString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2120
    :cond_10
    instance-of v0, p0, [Z

    if-eqz v0, :cond_1b

    .line 2121
    check-cast p0, [Z

    invoke-static {p0}, Ljava/util/Arrays;->toString([Z)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2122
    :cond_1b
    instance-of v0, p0, [B

    if-eqz v0, :cond_26

    .line 2123
    check-cast p0, [B

    invoke-static {p0}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2124
    :cond_26
    instance-of v0, p0, [C

    if-eqz v0, :cond_31

    .line 2125
    check-cast p0, [C

    invoke-static {p0}, Ljava/util/Arrays;->toString([C)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2126
    :cond_31
    instance-of v0, p0, [D

    if-eqz v0, :cond_3c

    .line 2127
    check-cast p0, [D

    invoke-static {p0}, Ljava/util/Arrays;->toString([D)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2128
    :cond_3c
    instance-of v0, p0, [F

    if-eqz v0, :cond_47

    .line 2129
    check-cast p0, [F

    invoke-static {p0}, Ljava/util/Arrays;->toString([F)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2130
    :cond_47
    instance-of v0, p0, [I

    if-eqz v0, :cond_52

    .line 2131
    check-cast p0, [I

    invoke-static {p0}, Ljava/util/Arrays;->toString([I)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2132
    :cond_52
    instance-of v0, p0, [J

    if-eqz v0, :cond_5d

    .line 2133
    check-cast p0, [J

    invoke-static {p0}, Ljava/util/Arrays;->toString([J)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2134
    :cond_5d
    instance-of v0, p0, [S

    if-eqz v0, :cond_68

    .line 2135
    check-cast p0, [S

    invoke-static {p0}, Ljava/util/Arrays;->toString([S)Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 2137
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
