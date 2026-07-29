.class public Landroidx/constraintlayout/core/SolverVariable;
.super Ljava/lang/Object;
.source "SolverVariable.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/core/SolverVariable$Type;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Landroidx/constraintlayout/core/SolverVariable;",
        ">;"
    }
.end annotation


# static fields
.field private static final INTERNAL_DEBUG:Z = false

.field static final MAX_STRENGTH:I = 0x9

.field public static final STRENGTH_BARRIER:I = 0x6

.field public static final STRENGTH_CENTERING:I = 0x7

.field public static final STRENGTH_EQUALITY:I = 0x5

.field public static final STRENGTH_FIXED:I = 0x8

.field public static final STRENGTH_HIGH:I = 0x3

.field public static final STRENGTH_HIGHEST:I = 0x4

.field public static final STRENGTH_LOW:I = 0x1

.field public static final STRENGTH_MEDIUM:I = 0x2

.field public static final STRENGTH_NONE:I = 0x0

.field private static final VAR_USE_HASH:Z = false

.field private static uniqueConstantId:I = 0x1

.field private static uniqueErrorId:I = 0x1

.field private static uniqueId:I = 0x1

.field private static uniqueSlackId:I = 0x1

.field private static uniqueUnrestrictedId:I = 0x1


# instance fields
.field public computedValue:F

.field definitionId:I

.field goalStrengthVector:[F

.field public id:I

.field public inGoal:Z

.field inRows:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet<",
            "Landroidx/constraintlayout/core/ArrayRow;",
            ">;"
        }
    .end annotation
.end field

.field public isFinalValue:Z

.field isSynonym:Z

.field mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

.field mClientEquationsCount:I

.field private mName:Ljava/lang/String;

.field mType:Landroidx/constraintlayout/core/SolverVariable$Type;

.field public strength:I

.field strengthVector:[F

.field synonym:I

.field synonymDelta:F

.field public usageInRowCount:I


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>(Landroidx/constraintlayout/core/SolverVariable$Type;Ljava/lang/String;)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 p2, -0x1

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->id:I

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    const/16 v1, 0x9

    new-array v2, v1, [F

    iput-object v2, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    new-array v1, v1, [F

    iput-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->goalStrengthVector:[F

    const/16 v1, 0x10

    new-array v1, v1, [Landroidx/constraintlayout/core/ArrayRow;

    iput-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iput-boolean v0, p0, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    const/4 p2, 0x0

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    const/4 p2, 0x0

    iput-object p2, p0, Landroidx/constraintlayout/core/SolverVariable;->inRows:Ljava/util/HashSet;

    iput-object p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroidx/constraintlayout/core/SolverVariable$Type;)V
    .registers 7

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->id:I

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 v1, 0x0

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    iput-boolean v1, p0, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    const/16 v2, 0x9

    new-array v3, v2, [F

    iput-object v3, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    new-array v2, v2, [F

    iput-object v2, p0, Landroidx/constraintlayout/core/SolverVariable;->goalStrengthVector:[F

    const/16 v2, 0x10

    new-array v2, v2, [Landroidx/constraintlayout/core/ArrayRow;

    iput-object v2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iput-boolean v1, p0, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->inRows:Ljava/util/HashSet;

    iput-object p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    iput-object p2, p0, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    return-void
.end method

.method private static getUniqueName(Landroidx/constraintlayout/core/SolverVariable$Type;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    if-eqz p1, :cond_16

    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueErrorId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_16
    sget-object p1, Landroidx/constraintlayout/core/SolverVariable$1;->$SwitchMap$androidx$constraintlayout$core$SolverVariable$Type:[I

    invoke-virtual {p0}, Landroidx/constraintlayout/core/SolverVariable$Type;->ordinal()I

    move-result v0

    aget p1, p1, v0

    const/4 v0, 0x1

    if-eq p1, v0, :cond_8b

    const/4 v1, 0x2

    if-eq p1, v1, :cond_76

    const/4 v1, 0x3

    if-eq p1, v1, :cond_61

    const/4 v1, 0x4

    if-eq p1, v1, :cond_4c

    const/4 v1, 0x5

    if-ne p1, v1, :cond_42

    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "V"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueId:I

    add-int/2addr p1, v0

    sput p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_42
    new-instance p1, Ljava/lang/AssertionError;

    invoke-virtual {p0}, Landroidx/constraintlayout/core/SolverVariable$Type;->name()Ljava/lang/String;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw p1

    :cond_4c
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "e"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueErrorId:I

    add-int/2addr p1, v0

    sput p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueErrorId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_61
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "S"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueSlackId:I

    add-int/2addr p1, v0

    sput p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueSlackId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_76
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "C"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueConstantId:I

    add-int/2addr p1, v0

    sput p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueConstantId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_8b
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "U"

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueUnrestrictedId:I

    add-int/2addr p1, v0

    sput p1, Landroidx/constraintlayout/core/SolverVariable;->uniqueUnrestrictedId:I

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static increaseErrorId()V
    .registers 1

    sget v0, Landroidx/constraintlayout/core/SolverVariable;->uniqueErrorId:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroidx/constraintlayout/core/SolverVariable;->uniqueErrorId:I

    return-void
.end method


# virtual methods
.method public final addToRow(Landroidx/constraintlayout/core/ArrayRow;)V
    .registers 5

    const/4 v0, 0x0

    :goto_1
    iget v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    if-ge v0, v1, :cond_f

    iget-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aget-object v1, v1, v0

    if-ne v1, p1, :cond_c

    return-void

    :cond_c
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_f
    iget-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    array-length v2, v0

    if-lt v1, v2, :cond_1f

    array-length v1, v0

    mul-int/lit8 v1, v1, 0x2

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/constraintlayout/core/ArrayRow;

    iput-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    :cond_1f
    iget-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    iget v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    aput-object p1, v0, v1

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    return-void
.end method

.method clearStrengths()V
    .registers 4

    const/4 v0, 0x0

    :goto_1
    const/16 v1, 0x9

    if-ge v0, v1, :cond_d

    iget-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    const/4 v2, 0x0

    aput v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_d
    return-void
.end method

.method public compareTo(Landroidx/constraintlayout/core/SolverVariable;)I
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/SolverVariable;->id:I

    iget p1, p1, Landroidx/constraintlayout/core/SolverVariable;->id:I

    sub-int/2addr v0, p1

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 2

    check-cast p1, Landroidx/constraintlayout/core/SolverVariable;

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/SolverVariable;->compareTo(Landroidx/constraintlayout/core/SolverVariable;)I

    move-result p1

    return p1
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public final removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V
    .registers 6

    iget v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    const/4 v1, 0x0

    :goto_3
    if-ge v1, v0, :cond_23

    iget-object v2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aget-object v2, v2, v1

    if-ne v2, p1, :cond_20

    :goto_b
    add-int/lit8 p1, v0, -0x1

    if-ge v1, p1, :cond_19

    iget-object p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    add-int/lit8 v2, v1, 0x1

    aget-object v3, p1, v2

    aput-object v3, p1, v1

    move v1, v2

    goto :goto_b

    :cond_19
    iget p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    return-void

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_23
    return-void
.end method

.method public reset()V
    .registers 7

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    sget-object v1, Landroidx/constraintlayout/core/SolverVariable$Type;->UNKNOWN:Landroidx/constraintlayout/core/SolverVariable$Type;

    iput-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    const/4 v1, 0x0

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v2, -0x1

    iput v2, p0, Landroidx/constraintlayout/core/SolverVariable;->id:I

    iput v2, p0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 v3, 0x0

    iput v3, p0, Landroidx/constraintlayout/core/SolverVariable;->computedValue:F

    iput-boolean v1, p0, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    iput-boolean v1, p0, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    iput v2, p0, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    iput v3, p0, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    iget v2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    move v4, v1

    :goto_1d
    if-ge v4, v2, :cond_26

    iget-object v5, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aput-object v0, v5, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_1d

    :cond_26
    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    iput-boolean v1, p0, Landroidx/constraintlayout/core/SolverVariable;->inGoal:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->goalStrengthVector:[F

    invoke-static {v0, v3}, Ljava/util/Arrays;->fill([FF)V

    return-void
.end method

.method public setFinalValue(Landroidx/constraintlayout/core/LinearSystem;F)V
    .registers 6

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->computedValue:F

    const/4 p2, 0x1

    iput-boolean p2, p0, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    const/4 p2, 0x0

    iput-boolean p2, p0, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    const/4 v0, -0x1

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    const/4 v1, 0x0

    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    iget v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    iput v0, p0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    move v0, p2

    :goto_13
    if-ge v0, v1, :cond_1f

    iget-object v2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1, p0, p2}, Landroidx/constraintlayout/core/ArrayRow;->updateFromFinalVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_13

    :cond_1f
    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .registers 2

    iput-object p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    return-void
.end method

.method public setSynonym(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;F)V
    .registers 6

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    iget p2, p2, Landroidx/constraintlayout/core/SolverVariable;->id:I

    iput p2, p0, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    iput p3, p0, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    iget p2, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    const/4 p3, -0x1

    iput p3, p0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 p3, 0x0

    move v0, p3

    :goto_10
    if-ge v0, p2, :cond_1c

    iget-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1, p0, p3}, Landroidx/constraintlayout/core/ArrayRow;->updateFromSynonymVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_10

    :cond_1c
    iput p3, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    invoke-virtual {p1}, Landroidx/constraintlayout/core/LinearSystem;->displayReadableRows()V

    return-void
.end method

.method public setType(Landroidx/constraintlayout/core/SolverVariable$Type;Ljava/lang/String;)V
    .registers 3

    iput-object p1, p0, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    return-void
.end method

.method strengthsToString()Ljava/lang/String;
    .registers 11

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    move v3, v1

    move v4, v3

    move v5, v2

    :goto_18
    iget-object v6, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    array-length v6, v6

    if-ge v3, v6, :cond_75

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v6, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    aget v6, v6, v3

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v6, p0, Landroidx/constraintlayout/core/SolverVariable;->strengthVector:[F

    aget v7, v6, v3

    const/4 v8, 0x0

    cmpl-float v9, v7, v8

    if-lez v9, :cond_3d

    move v4, v1

    goto :goto_42

    :cond_3d
    cmpg-float v9, v7, v8

    if-gez v9, :cond_42

    move v4, v2

    :cond_42
    :goto_42
    cmpl-float v7, v7, v8

    if-eqz v7, :cond_47

    move v5, v1

    :cond_47
    array-length v6, v6

    sub-int/2addr v6, v2

    if-ge v3, v6, :cond_5f

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ", "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_72

    :cond_5f
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "] "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_72
    add-int/lit8 v3, v3, 0x1

    goto :goto_18

    :cond_75
    if-eqz v4, :cond_8a

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " (-)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_8a
    if-eqz v5, :cond_9f

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " (*)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_9f
    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    const-string v1, ""

    if-eqz v0, :cond_16

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_25

    :cond_16
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Landroidx/constraintlayout/core/SolverVariable;->id:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_25
    return-object v0
.end method

.method public final updateReferencesWithNewDefinition(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/ArrayRow;)V
    .registers 7

    iget v0, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    const/4 v1, 0x0

    move v2, v1

    :goto_4
    if-ge v2, v0, :cond_10

    iget-object v3, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquations:[Landroidx/constraintlayout/core/ArrayRow;

    aget-object v3, v3, v2

    invoke-virtual {v3, p1, p2, v1}, Landroidx/constraintlayout/core/ArrayRow;->updateFromRow(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/ArrayRow;Z)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_10
    iput v1, p0, Landroidx/constraintlayout/core/SolverVariable;->mClientEquationsCount:I

    return-void
.end method
