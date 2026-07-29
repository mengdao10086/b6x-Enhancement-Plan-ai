.class public Landroidx/constraintlayout/core/ArrayLinkedVariables;
.super Ljava/lang/Object;
.source "ArrayLinkedVariables.java"

# interfaces
.implements Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;


# static fields
.field private static final DEBUG:Z = false

.field private static final FULL_NEW_CHECK:Z = false

.field static final NONE:I = -0x1

.field private static epsilon:F = 0.001f


# instance fields
.field private ROW_SIZE:I

.field private candidate:Landroidx/constraintlayout/core/SolverVariable;

.field currentSize:I

.field private mArrayIndices:[I

.field private mArrayNextIndices:[I

.field private mArrayValues:[F

.field protected final mCache:Landroidx/constraintlayout/core/Cache;

.field private mDidFillOnce:Z

.field private mHead:I

.field private mLast:I

.field private final mRow:Landroidx/constraintlayout/core/ArrayRow;


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method constructor <init>(Landroidx/constraintlayout/core/ArrayRow;Landroidx/constraintlayout/core/Cache;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    const/16 v1, 0x8

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->candidate:Landroidx/constraintlayout/core/SolverVariable;

    new-array v2, v1, [I

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    new-array v2, v1, [I

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    new-array v1, v1, [F

    iput-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    const/4 v1, -0x1

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    iput-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    iput-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mCache:Landroidx/constraintlayout/core/Cache;

    return-void
.end method


# virtual methods
.method public add(Landroidx/constraintlayout/core/SolverVariable;FZ)V
    .registers 12

    sget v0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->epsilon:F

    neg-float v1, v0

    cmpl-float v1, p2, v1

    if-lez v1, :cond_c

    cmpg-float v0, p2, v0

    if-gez v0, :cond_c

    return-void

    :cond_c
    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    const/4 v2, -0x1

    const/4 v3, 0x1

    if-ne v0, v2, :cond_49

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    iget-object p3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aput p2, p3, v1

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget p3, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    aput p3, p2, v1

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget p3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    aput v2, p2, p3

    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    add-int/2addr p2, v3

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->addToRow(Landroidx/constraintlayout/core/ArrayRow;)V

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    add-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    iget-boolean p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-nez p1, :cond_48

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length p3, p2

    if-lt p1, p3, :cond_48

    iput-boolean v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    array-length p1, p2

    sub-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_48
    return-void

    :cond_49
    move v4, v1

    move v5, v2

    :goto_4b
    if-eq v0, v2, :cond_aa

    iget v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v4, v6, :cond_aa

    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v6, v6, v0

    iget v7, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v6, v7, :cond_9a

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v2, v1, v0

    add-float/2addr v2, p2

    sget p2, Landroidx/constraintlayout/core/ArrayLinkedVariables;->epsilon:F

    neg-float v4, p2

    cmpl-float v4, v2, v4

    const/4 v6, 0x0

    if-lez v4, :cond_6b

    cmpg-float p2, v2, p2

    if-gez p2, :cond_6b

    move v2, v6

    :cond_6b
    aput v2, v1, v0

    cmpl-float p2, v2, v6

    if-nez p2, :cond_99

    iget p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    if-ne v0, p2, :cond_7c

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget p2, p2, v0

    iput p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    goto :goto_82

    :cond_7c
    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v1, p2, v0

    aput v1, p2, v5

    :goto_82
    if-eqz p3, :cond_89

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_89
    iget-boolean p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-eqz p2, :cond_8f

    iput v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_8f
    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    sub-int/2addr p2, v3

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    sub-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    :cond_99
    return-void

    :cond_9a
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v6, v6, v0

    iget v7, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ge v6, v7, :cond_a3

    move v5, v0

    :cond_a3
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v6, v0

    add-int/lit8 v4, v4, 0x1

    goto :goto_4b

    :cond_aa
    iget p3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/lit8 v0, p3, 0x1

    iget-boolean v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-eqz v4, :cond_bb

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v4, v0, p3

    if-ne v4, v2, :cond_b9

    goto :goto_bc

    :cond_b9
    array-length p3, v0

    goto :goto_bc

    :cond_bb
    move p3, v0

    :goto_bc
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v4, v0

    if-lt p3, v4, :cond_d5

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    array-length v0, v0

    if-ge v4, v0, :cond_d5

    move v0, v1

    :goto_c7
    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v6, v4

    if-ge v0, v6, :cond_d5

    aget v4, v4, v0

    if-ne v4, v2, :cond_d2

    move p3, v0

    goto :goto_d5

    :cond_d2
    add-int/lit8 v0, v0, 0x1

    goto :goto_c7

    :cond_d5
    :goto_d5
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v4, v0

    if-lt p3, v4, :cond_103

    array-length p3, v0

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    mul-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    iput-boolean v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    add-int/lit8 v1, p3, -0x1

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    invoke-static {v1, v0}, Ljava/util/Arrays;->copyOf([FI)[F

    move-result-object v0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    :cond_103
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget v1, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    aput v1, v0, p3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aput p2, v0, p3

    if-eq v5, v2, :cond_118

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, p2, v5

    aput v0, p2, p3

    aput p3, p2, v5

    goto :goto_120

    :cond_118
    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    aput v0, p2, p3

    iput p3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    :goto_120
    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    add-int/2addr p2, v3

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->addToRow(Landroidx/constraintlayout/core/ArrayRow;)V

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    add-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    iget-boolean p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-nez p1, :cond_138

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_138
    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length p3, p2

    if-lt p1, p3, :cond_145

    iput-boolean v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    array-length p1, p2

    sub-int/2addr p1, v3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_145
    return-void
.end method

.method public final clear()V
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    move v2, v1

    :goto_4
    const/4 v3, -0x1

    if-eq v0, v3, :cond_23

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v2, v4, :cond_23

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mCache:Landroidx/constraintlayout/core/Cache;

    iget-object v3, v3, Landroidx/constraintlayout/core/Cache;->mIndexedVariables:[Landroidx/constraintlayout/core/SolverVariable;

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v4, v4, v0

    aget-object v3, v3, v4

    if-eqz v3, :cond_1c

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {v3, v4}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_1c
    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v3, v0

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_23
    iput v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    iput v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iput-boolean v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    return-void
.end method

.method public contains(Landroidx/constraintlayout/core/SolverVariable;)Z
    .registers 8

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_7

    return v1

    :cond_7
    move v3, v1

    :goto_8
    if-eq v0, v2, :cond_1f

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v3, v4, :cond_1f

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v4, v4, v0

    iget v5, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v4, v5, :cond_18

    const/4 p1, 0x1

    return p1

    :cond_18
    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v4, v0

    add-int/lit8 v3, v3, 0x1

    goto :goto_8

    :cond_1f
    return v1
.end method

.method public display()V
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "{ "

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    const/4 v1, 0x0

    :goto_a
    if-ge v1, v0, :cond_3c

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    if-nez v2, :cond_13

    goto :goto_39

    :cond_13
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " = "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->getVariableValue(I)F

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    :goto_39
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_3c
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    return-void
.end method

.method public divideByAmount(F)V
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    :goto_3
    const/4 v2, -0x1

    if-eq v0, v2, :cond_18

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v2, :cond_18

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v3, v2, v0

    div-float/2addr v3, p1

    aput v3, v2, v0

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v2, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_18
    return-void
.end method

.method public final get(Landroidx/constraintlayout/core/SolverVariable;)F
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    :goto_3
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1e

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v2, :cond_1e

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v2, v2, v0

    iget v3, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v2, v3, :cond_17

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget p1, p1, v0

    return p1

    :cond_17
    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v2, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_1e
    const/4 p1, 0x0

    return p1
.end method

.method public getCurrentSize()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    return v0
.end method

.method public getHead()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    return v0
.end method

.method public final getId(I)I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget p1, v0, p1

    return p1
.end method

.method public final getNextIndice(I)I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget p1, v0, p1

    return p1
.end method

.method getPivotCandidate()Landroidx/constraintlayout/core/SolverVariable;
    .registers 7

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->candidate:Landroidx/constraintlayout/core/SolverVariable;

    if-nez v0, :cond_33

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_8
    const/4 v3, -0x1

    if-eq v0, v3, :cond_32

    iget v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v3, :cond_32

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v3, v3, v0

    const/4 v4, 0x0

    cmpg-float v3, v3, v4

    if-gez v3, :cond_2b

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mCache:Landroidx/constraintlayout/core/Cache;

    iget-object v3, v3, Landroidx/constraintlayout/core/Cache;->mIndexedVariables:[Landroidx/constraintlayout/core/SolverVariable;

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v4, v4, v0

    aget-object v3, v3, v4

    if-eqz v2, :cond_2a

    iget v4, v2, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    iget v5, v3, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    if-ge v4, v5, :cond_2b

    :cond_2a
    move-object v2, v3

    :cond_2b
    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v3, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    :cond_32
    return-object v2

    :cond_33
    return-object v0
.end method

.method public final getValue(I)F
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget p1, v0, p1

    return p1
.end method

.method public getVariable(I)Landroidx/constraintlayout/core/SolverVariable;
    .registers 5

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    :goto_3
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1e

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v2, :cond_1e

    if-ne v1, p1, :cond_17

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mCache:Landroidx/constraintlayout/core/Cache;

    iget-object p1, p1, Landroidx/constraintlayout/core/Cache;->mIndexedVariables:[Landroidx/constraintlayout/core/SolverVariable;

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v0, v1, v0

    aget-object p1, p1, v0

    return-object p1

    :cond_17
    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v2, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_1e
    const/4 p1, 0x0

    return-object p1
.end method

.method public getVariableValue(I)F
    .registers 5

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    :goto_3
    const/4 v2, -0x1

    if-eq v0, v2, :cond_18

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v2, :cond_18

    if-ne v1, p1, :cond_11

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget p1, p1, v0

    return p1

    :cond_11
    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v2, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_18
    const/4 p1, 0x0

    return p1
.end method

.method hasAtLeastOnePositiveVariable()Z
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    move v2, v1

    :goto_4
    const/4 v3, -0x1

    if-eq v0, v3, :cond_1d

    iget v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v2, v3, :cond_1d

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v3, v3, v0

    const/4 v4, 0x0

    cmpl-float v3, v3, v4

    if-lez v3, :cond_16

    const/4 v0, 0x1

    return v0

    :cond_16
    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v3, v0

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_1d
    return v1
.end method

.method public indexOf(Landroidx/constraintlayout/core/SolverVariable;)I
    .registers 7

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_6

    return v1

    :cond_6
    const/4 v2, 0x0

    :goto_7
    if-eq v0, v1, :cond_1d

    iget v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v2, v3, :cond_1d

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v3, v3, v0

    iget v4, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v3, v4, :cond_16

    return v0

    :cond_16
    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v3, v0

    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    :cond_1d
    return v1
.end method

.method public invert()V
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    :goto_3
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1a

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v1, v2, :cond_1a

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v3, v2, v0

    const/high16 v4, -0x40800000    # -1.0f

    mul-float/2addr v3, v4

    aput v3, v2, v0

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v2, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_1a
    return-void
.end method

.method public final put(Landroidx/constraintlayout/core/SolverVariable;F)V
    .registers 11

    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    const/4 v1, 0x1

    if-nez v0, :cond_a

    invoke-virtual {p0, p1, v1}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->remove(Landroidx/constraintlayout/core/SolverVariable;Z)F

    return-void

    :cond_a
    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v2, 0x0

    const/4 v3, -0x1

    if-ne v0, v3, :cond_46

    iput v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aput p2, v0, v2

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    aput v0, p2, v2

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    aput v3, p2, v0

    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    add-int/2addr p2, v1

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->addToRow(Landroidx/constraintlayout/core/ArrayRow;)V

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    add-int/2addr p1, v1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    iget-boolean p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-nez p1, :cond_45

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/2addr p1, v1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v0, p2

    if-lt p1, v0, :cond_45

    iput-boolean v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    array-length p1, p2

    sub-int/2addr p1, v1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_45
    return-void

    :cond_46
    move v4, v2

    move v5, v3

    :goto_48
    if-eq v0, v3, :cond_6b

    iget v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v4, v6, :cond_6b

    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v6, v6, v0

    iget v7, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v6, v7, :cond_5b

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aput p2, p1, v0

    return-void

    :cond_5b
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v6, v6, v0

    iget v7, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ge v6, v7, :cond_64

    move v5, v0

    :cond_64
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v6, v0

    add-int/lit8 v4, v4, 0x1

    goto :goto_48

    :cond_6b
    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/lit8 v4, v0, 0x1

    iget-boolean v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-eqz v6, :cond_7c

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v6, v4, v0

    if-ne v6, v3, :cond_7a

    goto :goto_7d

    :cond_7a
    array-length v0, v4

    goto :goto_7d

    :cond_7c
    move v0, v4

    :goto_7d
    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v6, v4

    if-lt v0, v6, :cond_96

    iget v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    array-length v4, v4

    if-ge v6, v4, :cond_96

    move v4, v2

    :goto_88
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v7, v6

    if-ge v4, v7, :cond_96

    aget v6, v6, v4

    if-ne v6, v3, :cond_93

    move v0, v4

    goto :goto_96

    :cond_93
    add-int/lit8 v4, v4, 0x1

    goto :goto_88

    :cond_96
    :goto_96
    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v6, v4

    if-lt v0, v6, :cond_c4

    array-length v0, v4

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    mul-int/lit8 v4, v4, 0x2

    iput v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    iput-boolean v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    add-int/lit8 v2, v0, -0x1

    iput v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    invoke-static {v2, v4}, Ljava/util/Arrays;->copyOf([FI)[F

    move-result-object v2

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    invoke-static {v2, v4}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v2

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->ROW_SIZE:I

    invoke-static {v2, v4}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v2

    iput-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    :cond_c4
    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    iget v4, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    aput v4, v2, v0

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aput p2, v2, v0

    if-eq v5, v3, :cond_d9

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v2, p2, v5

    aput v2, p2, v0

    aput v0, p2, v5

    goto :goto_e1

    :cond_d9
    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    iget v2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    aput v2, p2, v0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    :goto_e1
    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    add-int/2addr p2, v1

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->addToRow(Landroidx/constraintlayout/core/ArrayRow;)V

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    add-int/2addr p1, v1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    iget-boolean p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-nez p2, :cond_f9

    iget p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    add-int/2addr p2, v1

    iput p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_f9
    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v0, p2

    if-lt p1, v0, :cond_100

    iput-boolean v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    :cond_100
    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    array-length v0, p2

    if-lt p1, v0, :cond_10b

    iput-boolean v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    array-length p1, p2

    sub-int/2addr p1, v1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_10b
    return-void
.end method

.method public final remove(Landroidx/constraintlayout/core/SolverVariable;Z)F
    .registers 11

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->candidate:Landroidx/constraintlayout/core/SolverVariable;

    if-ne v0, p1, :cond_7

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->candidate:Landroidx/constraintlayout/core/SolverVariable;

    :cond_7
    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const/4 v1, 0x0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_e

    return v1

    :cond_e
    const/4 v3, 0x0

    move v4, v2

    :goto_10
    if-eq v0, v2, :cond_5b

    iget v5, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v3, v5, :cond_5b

    iget-object v5, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v5, v5, v0

    iget v6, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    if-ne v5, v6, :cond_51

    iget v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    if-ne v0, v1, :cond_29

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v1, v1, v0

    iput v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    goto :goto_2f

    :cond_29
    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v3, v1, v0

    aput v3, v1, v4

    :goto_2f
    if-eqz p2, :cond_36

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mRow:Landroidx/constraintlayout/core/ArrayRow;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_36
    iget p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    add-int/lit8 p2, p2, -0x1

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iget p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aput v2, p1, v0

    iget-boolean p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mDidFillOnce:Z

    if-eqz p1, :cond_4c

    iput v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mLast:I

    :cond_4c
    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget p1, p1, v0

    return p1

    :cond_51
    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v4, v4, v0

    add-int/lit8 v3, v3, 0x1

    move v7, v4

    move v4, v0

    move v0, v7

    goto :goto_10

    :cond_5b
    return v1
.end method

.method public sizeInBytes()I
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    array-length v0, v0

    mul-int/lit8 v0, v0, 0x4

    mul-int/lit8 v0, v0, 0x3

    add-int/lit8 v0, v0, 0x0

    add-int/lit8 v0, v0, 0x24

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mHead:I

    const-string v1, ""

    const/4 v2, 0x0

    :goto_5
    const/4 v3, -0x1

    if-eq v0, v3, :cond_5c

    iget v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->currentSize:I

    if-ge v2, v3, :cond_5c

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " -> "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayValues:[F

    aget v3, v3, v0

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " : "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mCache:Landroidx/constraintlayout/core/Cache;

    iget-object v3, v3, Landroidx/constraintlayout/core/Cache;->mIndexedVariables:[Landroidx/constraintlayout/core/SolverVariable;

    iget-object v4, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayIndices:[I

    aget v4, v4, v0

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayLinkedVariables;->mArrayNextIndices:[I

    aget v0, v3, v0

    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    :cond_5c
    return-object v1
.end method

.method public use(Landroidx/constraintlayout/core/ArrayRow;Z)F
    .registers 8

    iget-object v0, p1, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->get(Landroidx/constraintlayout/core/SolverVariable;)F

    move-result v0

    iget-object v1, p1, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    invoke-virtual {p0, v1, p2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->remove(Landroidx/constraintlayout/core/SolverVariable;Z)F

    iget-object p1, p1, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v1

    const/4 v2, 0x0

    :goto_12
    if-ge v2, v1, :cond_23

    invoke-interface {p1, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v3

    invoke-interface {p1, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->get(Landroidx/constraintlayout/core/SolverVariable;)F

    move-result v4

    mul-float/2addr v4, v0

    invoke-virtual {p0, v3, v4, p2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->add(Landroidx/constraintlayout/core/SolverVariable;FZ)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_12

    :cond_23
    return v0
.end method
