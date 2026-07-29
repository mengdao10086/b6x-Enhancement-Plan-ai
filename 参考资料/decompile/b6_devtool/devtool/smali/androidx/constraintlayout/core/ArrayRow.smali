.class public Landroidx/constraintlayout/core/ArrayRow;
.super Ljava/lang/Object;
.source "ArrayRow.java"

# interfaces
.implements Landroidx/constraintlayout/core/LinearSystem$Row;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field private static final FULL_NEW_CHECK:Z = false


# instance fields
.field constantValue:F

.field isSimpleDefinition:Z

.field used:Z

.field variable:Landroidx/constraintlayout/core/SolverVariable;

.field public variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

.field variablesToUpdate:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/SolverVariable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->used:Z

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    return-void
.end method

.method public constructor <init>(Landroidx/constraintlayout/core/Cache;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->used:Z

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    new-instance v0, Landroidx/constraintlayout/core/ArrayLinkedVariables;

    invoke-direct {v0, p0, p1}, Landroidx/constraintlayout/core/ArrayLinkedVariables;-><init>(Landroidx/constraintlayout/core/ArrayRow;Landroidx/constraintlayout/core/Cache;)V

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    return-void
.end method

.method private isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z
    .registers 3

    iget p1, p1, Landroidx/constraintlayout/core/SolverVariable;->usageInRowCount:I

    const/4 p2, 0x1

    if-gt p1, p2, :cond_6

    goto :goto_7

    :cond_6
    const/4 p2, 0x0

    :goto_7
    return p2
.end method

.method private pickPivotInVariables([ZLandroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/SolverVariable;
    .registers 12

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    move v4, v1

    :goto_a
    if-ge v3, v0, :cond_3b

    iget-object v5, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v5, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariableValue(I)F

    move-result v5

    cmpg-float v6, v5, v1

    if-gez v6, :cond_38

    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v6, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v6

    if-eqz p1, :cond_24

    iget v7, v6, Landroidx/constraintlayout/core/SolverVariable;->id:I

    aget-boolean v7, p1, v7

    if-nez v7, :cond_38

    :cond_24
    if-eq v6, p2, :cond_38

    iget-object v7, v6, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    sget-object v8, Landroidx/constraintlayout/core/SolverVariable$Type;->SLACK:Landroidx/constraintlayout/core/SolverVariable$Type;

    if-eq v7, v8, :cond_32

    iget-object v7, v6, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    sget-object v8, Landroidx/constraintlayout/core/SolverVariable$Type;->ERROR:Landroidx/constraintlayout/core/SolverVariable$Type;

    if-ne v7, v8, :cond_38

    :cond_32
    cmpg-float v7, v5, v4

    if-gez v7, :cond_38

    move v4, v5

    move-object v2, v6

    :cond_38
    add-int/lit8 v3, v3, 0x1

    goto :goto_a

    :cond_3b
    return-object v2
.end method


# virtual methods
.method public addError(Landroidx/constraintlayout/core/LinearSystem;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 6

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const-string v1, "ep"

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/LinearSystem;->createErrorVariable(ILjava/lang/String;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v1

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-interface {v0, v1, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const-string v1, "em"

    invoke-virtual {p1, p2, v1}, Landroidx/constraintlayout/core/LinearSystem;->createErrorVariable(ILjava/lang/String;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object p1

    const/high16 p2, -0x40800000    # -1.0f

    invoke-interface {v0, p1, p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0
.end method

.method public addError(Landroidx/constraintlayout/core/SolverVariable;)V
    .registers 5

    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v1, 0x1

    const/high16 v2, 0x3f800000    # 1.0f

    if-ne v0, v1, :cond_8

    goto :goto_2a

    :cond_8
    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_10

    const/high16 v2, 0x447a0000    # 1000.0f

    goto :goto_2a

    :cond_10
    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_19

    const v2, 0x49742400    # 1000000.0f

    goto :goto_2a

    :cond_19
    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_22

    const v2, 0x4e6e6b28    # 1.0E9f

    goto :goto_2a

    :cond_22
    iget v0, p1, Landroidx/constraintlayout/core/SolverVariable;->strength:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_2a

    const v2, 0x5368d4a5    # 1.0E12f

    :cond_2a
    :goto_2a
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-void
.end method

.method addSingleError(Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    int-to-float p2, p2

    invoke-interface {v0, p1, p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0
.end method

.method chooseSubject(Landroidx/constraintlayout/core/LinearSystem;)Z
    .registers 4

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/ArrayRow;->chooseSubjectInVariables(Landroidx/constraintlayout/core/LinearSystem;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object p1

    const/4 v0, 0x1

    if-nez p1, :cond_9

    move p1, v0

    goto :goto_d

    :cond_9
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/ArrayRow;->pivot(Landroidx/constraintlayout/core/SolverVariable;)V

    const/4 p1, 0x0

    :goto_d
    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v1

    if-nez v1, :cond_17

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    :cond_17
    return p1
.end method

.method chooseSubjectInVariables(Landroidx/constraintlayout/core/LinearSystem;)Landroidx/constraintlayout/core/SolverVariable;
    .registers 16

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    move v7, v2

    move v8, v7

    move v4, v3

    move v5, v4

    move v6, v5

    move-object v3, v1

    :goto_f
    if-ge v4, v0, :cond_6a

    iget-object v9, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v9, v4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariableValue(I)F

    move-result v9

    iget-object v10, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v10, v4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v10

    iget-object v11, v10, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    sget-object v12, Landroidx/constraintlayout/core/SolverVariable$Type;->UNRESTRICTED:Landroidx/constraintlayout/core/SolverVariable$Type;

    const/4 v13, 0x1

    if-ne v11, v12, :cond_43

    if-nez v1, :cond_2e

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v1

    :goto_2a
    move v5, v1

    move v7, v9

    move-object v1, v10

    goto :goto_67

    :cond_2e
    cmpl-float v11, v7, v9

    if-lez v11, :cond_37

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v1

    goto :goto_2a

    :cond_37
    if-nez v5, :cond_67

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v11

    if-eqz v11, :cond_67

    move v7, v9

    move-object v1, v10

    move v5, v13

    goto :goto_67

    :cond_43
    if-nez v1, :cond_67

    cmpg-float v11, v9, v2

    if-gez v11, :cond_67

    if-nez v3, :cond_53

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v3

    :goto_4f
    move v6, v3

    move v8, v9

    move-object v3, v10

    goto :goto_67

    :cond_53
    cmpl-float v11, v8, v9

    if-lez v11, :cond_5c

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v3

    goto :goto_4f

    :cond_5c
    if-nez v6, :cond_67

    invoke-direct {p0, v10, p1}, Landroidx/constraintlayout/core/ArrayRow;->isNew(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/LinearSystem;)Z

    move-result v11

    if-eqz v11, :cond_67

    move v8, v9

    move-object v3, v10

    move v6, v13

    :cond_67
    :goto_67
    add-int/lit8 v4, v4, 0x1

    goto :goto_f

    :cond_6a
    if-eqz v1, :cond_6d

    return-object v1

    :cond_6d
    return-object v3
.end method

.method public clear()V
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->clear()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    return-void
.end method

.method createRowCentering(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 13

    const/high16 v0, 0x3f800000    # 1.0f

    if-ne p2, p5, :cond_16

    iget-object p3, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p3, p1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 p3, -0x40000000    # -2.0f

    invoke-interface {p1, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0

    :cond_16
    const/high16 v1, 0x3f000000    # 0.5f

    cmpl-float v1, p4, v1

    const/high16 v2, -0x40800000    # -1.0f

    if-nez v1, :cond_3c

    iget-object p4, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p4, p1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p5, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    if-gtz p3, :cond_36

    if-lez p7, :cond_8a

    :cond_36
    neg-int p1, p3

    add-int/2addr p1, p7

    int-to-float p1, p1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    goto :goto_8a

    :cond_3c
    const/4 v1, 0x0

    cmpg-float v1, p4, v1

    if-gtz v1, :cond_4f

    iget-object p4, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p4, p1, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    int-to-float p1, p3

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    goto :goto_8a

    :cond_4f
    cmpl-float v1, p4, v0

    if-ltz v1, :cond_62

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p5, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    neg-int p1, p7

    int-to-float p1, p1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    goto :goto_8a

    :cond_62
    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    sub-float v3, v0, p4

    mul-float v4, v3, v0

    invoke-interface {v1, p1, v4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    mul-float v1, v3, v2

    invoke-interface {p1, p2, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    mul-float/2addr v2, p4

    invoke-interface {p1, p5, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    mul-float/2addr v0, p4

    invoke-interface {p1, p6, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    if-gtz p3, :cond_82

    if-lez p7, :cond_8a

    :cond_82
    neg-int p1, p3

    int-to-float p1, p1

    mul-float/2addr p1, v3

    int-to-float p2, p7

    mul-float/2addr p2, p4

    add-float/2addr p1, p2

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    :cond_8a
    :goto_8a
    return-object p0
.end method

.method createRowDefinition(Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 3

    iput-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    int-to-float p2, p2

    iput p2, p1, Landroidx/constraintlayout/core/SolverVariable;->computedValue:F

    iput p2, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 p1, 0x1

    iput-boolean p1, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    return-object p0
.end method

.method createRowDimensionPercent(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;F)Landroidx/constraintlayout/core/ArrayRow;
    .registers 6

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v1, -0x40800000    # -1.0f

    invoke-interface {v0, p1, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0
.end method

.method public createRowDimensionRatio(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;F)Landroidx/constraintlayout/core/ArrayRow;
    .registers 8

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v1, -0x40800000    # -1.0f

    invoke-interface {v0, p1, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-interface {p1, p2, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p3, p5}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    neg-float p2, p5

    invoke-interface {p1, p4, p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0
.end method

.method public createRowEqualDimension(FFFLandroidx/constraintlayout/core/SolverVariable;ILandroidx/constraintlayout/core/SolverVariable;ILandroidx/constraintlayout/core/SolverVariable;ILandroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 15

    const/4 v0, 0x0

    cmpl-float v0, p2, v0

    const/high16 v1, -0x40800000    # -1.0f

    const/high16 v2, 0x3f800000    # 1.0f

    if-eqz v0, :cond_32

    cmpl-float v0, p1, p3

    if-nez v0, :cond_e

    goto :goto_32

    :cond_e
    div-float/2addr p1, p2

    div-float/2addr p3, p2

    div-float/2addr p1, p3

    neg-int p2, p5

    sub-int/2addr p2, p7

    int-to-float p2, p2

    int-to-float p3, p9

    mul-float/2addr p3, p1

    add-float/2addr p2, p3

    int-to-float p3, p11

    mul-float/2addr p3, p1

    add-float/2addr p2, p3

    iput p2, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p4, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p6, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p10, p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    neg-float p1, p1

    invoke-interface {p2, p8, p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_4d

    :cond_32
    :goto_32
    neg-int p1, p5

    sub-int/2addr p1, p7

    add-int/2addr p1, p9

    add-int/2addr p1, p11

    int-to-float p1, p1

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p4, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p10, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p8, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_4d
    return-object p0
.end method

.method public createRowEqualMatchDimensions(FFFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/ArrayRow;
    .registers 12

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    cmpl-float v1, p2, v0

    const/high16 v2, -0x40800000    # -1.0f

    const/high16 v3, 0x3f800000    # 1.0f

    if-eqz v1, :cond_47

    cmpl-float v1, p1, p3

    if-nez v1, :cond_10

    goto :goto_47

    :cond_10
    cmpl-float v1, p1, v0

    if-nez v1, :cond_1f

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p4, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p5, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_5b

    :cond_1f
    cmpl-float v0, p3, v0

    if-nez v0, :cond_2e

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p7, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_5b

    :cond_2e
    div-float/2addr p1, p2

    div-float/2addr p3, p2

    div-float/2addr p1, p3

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p4, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p5, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2, p7, p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    neg-float p1, p1

    invoke-interface {p2, p6, p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_5b

    :cond_47
    :goto_47
    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p4, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p5, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p7, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p6, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_5b
    return-object p0
.end method

.method public createRowEquals(Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 4

    if-gez p2, :cond_f

    mul-int/lit8 p2, p2, -0x1

    int-to-float p2, p2

    iput p2, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v0, 0x3f800000    # 1.0f

    invoke-interface {p2, p1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_19

    :cond_f
    int-to-float p2, p2

    iput p2, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v0, -0x40800000    # -1.0f

    invoke-interface {p2, p1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_19
    return-object p0
.end method

.method public createRowEquals(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 6

    const/4 v0, 0x0

    if-eqz p3, :cond_b

    if-gez p3, :cond_8

    mul-int/lit8 p3, p3, -0x1

    const/4 v0, 0x1

    :cond_8
    int-to-float p3, p3

    iput p3, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    :cond_b
    const/high16 p3, -0x40800000    # -1.0f

    const/high16 v1, 0x3f800000    # 1.0f

    if-nez v0, :cond_1c

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_26

    :cond_1c
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_26
    return-object p0
.end method

.method public createRowGreaterThan(Landroidx/constraintlayout/core/SolverVariable;ILandroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/ArrayRow;
    .registers 4

    int-to-float p2, p2

    iput p2, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 p3, -0x40800000    # -1.0f

    invoke-interface {p2, p1, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    return-object p0
.end method

.method public createRowGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 7

    const/4 v0, 0x0

    if-eqz p4, :cond_b

    if-gez p4, :cond_8

    mul-int/lit8 p4, p4, -0x1

    const/4 v0, 0x1

    :cond_8
    int-to-float p4, p4

    iput p4, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    :cond_b
    const/high16 p4, -0x40800000    # -1.0f

    const/high16 v1, 0x3f800000    # 1.0f

    if-nez v0, :cond_21

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p3, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_30

    :cond_21
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p3, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_30
    return-object p0
.end method

.method public createRowLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;I)Landroidx/constraintlayout/core/ArrayRow;
    .registers 7

    const/4 v0, 0x0

    if-eqz p4, :cond_b

    if-gez p4, :cond_8

    mul-int/lit8 p4, p4, -0x1

    const/4 v0, 0x1

    :cond_8
    int-to-float p4, p4

    iput p4, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    :cond_b
    const/high16 p4, -0x40800000    # -1.0f

    const/high16 v1, 0x3f800000    # 1.0f

    if-nez v0, :cond_21

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p3, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    goto :goto_30

    :cond_21
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p3, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    :goto_30
    return-object p0
.end method

.method public createRowWithAngle(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;F)Landroidx/constraintlayout/core/ArrayRow;
    .registers 8

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 v1, 0x3f000000    # 0.5f

    invoke-interface {v0, p3, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p3, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p3, p4, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p3, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/high16 p4, -0x41000000    # -0.5f

    invoke-interface {p3, p1, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, p2, p4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    neg-float p1, p5

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    return-object p0
.end method

.method ensurePositiveConstant()V
    .registers 3

    iget v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v1, 0x0

    cmpg-float v1, v0, v1

    if-gez v1, :cond_11

    const/high16 v1, -0x40800000    # -1.0f

    mul-float/2addr v0, v1

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->invert()V

    :cond_11
    return-void
.end method

.method public getKey()Landroidx/constraintlayout/core/SolverVariable;
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    return-object v0
.end method

.method public getPivotCandidate(Landroidx/constraintlayout/core/LinearSystem;[Z)Landroidx/constraintlayout/core/SolverVariable;
    .registers 3

    const/4 p1, 0x0

    invoke-direct {p0, p2, p1}, Landroidx/constraintlayout/core/ArrayRow;->pickPivotInVariables([ZLandroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object p1

    return-object p1
.end method

.method hasKeyVariable()Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    if-eqz v0, :cond_13

    iget-object v0, v0, Landroidx/constraintlayout/core/SolverVariable;->mType:Landroidx/constraintlayout/core/SolverVariable$Type;

    sget-object v1, Landroidx/constraintlayout/core/SolverVariable$Type;->UNRESTRICTED:Landroidx/constraintlayout/core/SolverVariable$Type;

    if-eq v0, v1, :cond_11

    iget v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v1, 0x0

    cmpg-float v0, v0, v1

    if-ltz v0, :cond_13

    :cond_11
    const/4 v0, 0x1

    goto :goto_14

    :cond_13
    const/4 v0, 0x0

    :goto_14
    return v0
.end method

.method hasVariable(Landroidx/constraintlayout/core/SolverVariable;)Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->contains(Landroidx/constraintlayout/core/SolverVariable;)Z

    move-result p1

    return p1
.end method

.method public initFromRow(Landroidx/constraintlayout/core/LinearSystem$Row;)V
    .registers 7

    instance-of v0, p1, Landroidx/constraintlayout/core/ArrayRow;

    if-eqz v0, :cond_2c

    check-cast p1, Landroidx/constraintlayout/core/ArrayRow;

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->clear()V

    const/4 v0, 0x0

    :goto_f
    iget-object v1, p1, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v1

    if-ge v0, v1, :cond_2c

    iget-object v1, p1, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v1

    iget-object v2, p1, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v2, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariableValue(I)F

    move-result v2

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/4 v4, 0x1

    invoke-interface {v3, v1, v2, v4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->add(Landroidx/constraintlayout/core/SolverVariable;FZ)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_f

    :cond_2c
    return-void
.end method

.method public isEmpty()Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    if-nez v0, :cond_15

    iget v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_15

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v0

    if-nez v0, :cond_15

    const/4 v0, 0x1

    goto :goto_16

    :cond_15
    const/4 v0, 0x0

    :goto_16
    return v0
.end method

.method public pickPivot(Landroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/SolverVariable;
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Landroidx/constraintlayout/core/ArrayRow;->pickPivotInVariables([ZLandroidx/constraintlayout/core/SolverVariable;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object p1

    return-object p1
.end method

.method pivot(Landroidx/constraintlayout/core/SolverVariable;)V
    .registers 5

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/high16 v1, -0x40800000    # -1.0f

    if-eqz v0, :cond_13

    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v2, v0, v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/4 v2, -0x1

    iput v2, v0, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    :cond_13
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    const/4 v2, 0x1

    invoke-interface {v0, p1, v2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->remove(Landroidx/constraintlayout/core/SolverVariable;Z)F

    move-result v0

    mul-float/2addr v0, v1

    iput-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/high16 p1, 0x3f800000    # 1.0f

    cmpl-float p1, v0, p1

    if-nez p1, :cond_24

    return-void

    :cond_24
    iget p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    div-float/2addr p1, v0

    iput p1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object p1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p1, v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->divideByAmount(F)V

    return-void
.end method

.method public reset()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->clear()V

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    return-void
.end method

.method sizeInBytes()I
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    const/4 v1, 0x4

    if-eqz v0, :cond_7

    move v0, v1

    goto :goto_8

    :cond_7
    const/4 v0, 0x0

    :goto_8
    add-int/2addr v0, v1

    add-int/2addr v0, v1

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v1}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->sizeInBytes()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method toReadableString()Ljava/lang/String;
    .registers 11

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    if-nez v0, :cond_7

    const-string v0, "0"

    goto :goto_18

    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_18
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    const/4 v2, 0x0

    cmpl-float v1, v1, v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-eqz v1, :cond_49

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move v1, v4

    goto :goto_4a

    :cond_49
    move v1, v3

    :goto_4a
    iget-object v5, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v5}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v5

    :goto_50
    if-ge v3, v5, :cond_ea

    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v6, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v6

    if-nez v6, :cond_5c

    goto/16 :goto_e6

    :cond_5c
    iget-object v7, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v7, v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariableValue(I)F

    move-result v7

    cmpl-float v8, v7, v2

    if-nez v8, :cond_68

    goto/16 :goto_e6

    :cond_68
    invoke-virtual {v6}, Landroidx/constraintlayout/core/SolverVariable;->toString()Ljava/lang/String;

    move-result-object v6

    const/high16 v9, -0x40800000    # -1.0f

    if-nez v1, :cond_88

    cmpg-float v1, v7, v2

    if-gez v1, :cond_b2

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "- "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_b1

    :cond_88
    if-lez v8, :cond_9e

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " + "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_b2

    :cond_9e
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_b1
    mul-float/2addr v7, v9

    :cond_b2
    :goto_b2
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, v7, v1

    if-nez v1, :cond_ca

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_e5

    :cond_ca
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_e5
    move v1, v4

    :goto_e6
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_50

    :cond_ea
    if-nez v1, :cond_ff

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "0.0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_ff
    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    invoke-virtual {p0}, Landroidx/constraintlayout/core/ArrayRow;->toReadableString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateFromFinalVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V
    .registers 7

    if-eqz p2, :cond_30

    iget-boolean v0, p2, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-nez v0, :cond_7

    goto :goto_30

    :cond_7
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->get(Landroidx/constraintlayout/core/SolverVariable;)F

    move-result v0

    iget v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget v2, p2, Landroidx/constraintlayout/core/SolverVariable;->computedValue:F

    mul-float/2addr v2, v0

    add-float/2addr v1, v2

    iput v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->remove(Landroidx/constraintlayout/core/SolverVariable;Z)F

    if-eqz p3, :cond_1f

    invoke-virtual {p2, p0}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_1f
    sget-boolean p2, Landroidx/constraintlayout/core/LinearSystem;->SIMPLIFY_SYNONYMS:Z

    if-eqz p2, :cond_30

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result p2

    if-nez p2, :cond_30

    const/4 p2, 0x1

    iput-boolean p2, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    iput-boolean p2, p1, Landroidx/constraintlayout/core/LinearSystem;->hasSimpleDefinition:Z

    :cond_30
    :goto_30
    return-void
.end method

.method public updateFromRow(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/ArrayRow;Z)V
    .registers 7

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->use(Landroidx/constraintlayout/core/ArrayRow;Z)F

    move-result v0

    iget v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget v2, p2, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    mul-float/2addr v2, v0

    add-float/2addr v1, v2

    iput v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    if-eqz p3, :cond_15

    iget-object p2, p2, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    invoke-virtual {p2, p0}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_15
    sget-boolean p2, Landroidx/constraintlayout/core/LinearSystem;->SIMPLIFY_SYNONYMS:Z

    if-eqz p2, :cond_2a

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    if-eqz p2, :cond_2a

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result p2

    if-nez p2, :cond_2a

    const/4 p2, 0x1

    iput-boolean p2, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    iput-boolean p2, p1, Landroidx/constraintlayout/core/LinearSystem;->hasSimpleDefinition:Z

    :cond_2a
    return-void
.end method

.method public updateFromSynonymVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V
    .registers 7

    if-eqz p2, :cond_3d

    iget-boolean v0, p2, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    if-nez v0, :cond_7

    goto :goto_3d

    :cond_7
    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0, p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->get(Landroidx/constraintlayout/core/SolverVariable;)F

    move-result v0

    iget v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget v2, p2, Landroidx/constraintlayout/core/SolverVariable;->synonymDelta:F

    mul-float/2addr v2, v0

    add-float/2addr v1, v2

    iput v1, p0, Landroidx/constraintlayout/core/ArrayRow;->constantValue:F

    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v1, p2, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->remove(Landroidx/constraintlayout/core/SolverVariable;Z)F

    if-eqz p3, :cond_1f

    invoke-virtual {p2, p0}, Landroidx/constraintlayout/core/SolverVariable;->removeFromRow(Landroidx/constraintlayout/core/ArrayRow;)V

    :cond_1f
    iget-object v1, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    iget-object v2, p1, Landroidx/constraintlayout/core/LinearSystem;->mCache:Landroidx/constraintlayout/core/Cache;

    iget-object v2, v2, Landroidx/constraintlayout/core/Cache;->mIndexedVariables:[Landroidx/constraintlayout/core/SolverVariable;

    iget p2, p2, Landroidx/constraintlayout/core/SolverVariable;->synonym:I

    aget-object p2, v2, p2

    invoke-interface {v1, p2, v0, p3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->add(Landroidx/constraintlayout/core/SolverVariable;FZ)V

    sget-boolean p2, Landroidx/constraintlayout/core/LinearSystem;->SIMPLIFY_SYNONYMS:Z

    if-eqz p2, :cond_3d

    iget-object p2, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {p2}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result p2

    if-nez p2, :cond_3d

    const/4 p2, 0x1

    iput-boolean p2, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    iput-boolean p2, p1, Landroidx/constraintlayout/core/LinearSystem;->hasSimpleDefinition:Z

    :cond_3d
    :goto_3d
    return-void
.end method

.method public updateFromSystem(Landroidx/constraintlayout/core/LinearSystem;)V
    .registers 10

    iget-object v0, p1, Landroidx/constraintlayout/core/LinearSystem;->mRows:[Landroidx/constraintlayout/core/ArrayRow;

    array-length v0, v0

    if-nez v0, :cond_6

    return-void

    :cond_6
    const/4 v0, 0x0

    move v1, v0

    :goto_8
    const/4 v2, 0x1

    if-nez v1, :cond_66

    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v3}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v3

    move v4, v0

    :goto_12
    if-ge v4, v3, :cond_2f

    iget-object v5, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v5, v4}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getVariable(I)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v5

    iget v6, v5, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    const/4 v7, -0x1

    if-ne v6, v7, :cond_27

    iget-boolean v6, v5, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-nez v6, :cond_27

    iget-boolean v6, v5, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    if-eqz v6, :cond_2c

    :cond_27
    iget-object v6, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2c
    add-int/lit8 v4, v4, 0x1

    goto :goto_12

    :cond_2f
    iget-object v3, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_64

    move v4, v0

    :goto_38
    if-ge v4, v3, :cond_5e

    iget-object v5, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/SolverVariable;

    iget-boolean v6, v5, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v6, :cond_4a

    invoke-virtual {p0, p1, v5, v2}, Landroidx/constraintlayout/core/ArrayRow;->updateFromFinalVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V

    goto :goto_5b

    :cond_4a
    iget-boolean v6, v5, Landroidx/constraintlayout/core/SolverVariable;->isSynonym:Z

    if-eqz v6, :cond_52

    invoke-virtual {p0, p1, v5, v2}, Landroidx/constraintlayout/core/ArrayRow;->updateFromSynonymVariable(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/SolverVariable;Z)V

    goto :goto_5b

    :cond_52
    iget-object v6, p1, Landroidx/constraintlayout/core/LinearSystem;->mRows:[Landroidx/constraintlayout/core/ArrayRow;

    iget v5, v5, Landroidx/constraintlayout/core/SolverVariable;->definitionId:I

    aget-object v5, v6, v5

    invoke-virtual {p0, p1, v5, v2}, Landroidx/constraintlayout/core/ArrayRow;->updateFromRow(Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/ArrayRow;Z)V

    :goto_5b
    add-int/lit8 v4, v4, 0x1

    goto :goto_38

    :cond_5e
    iget-object v2, p0, Landroidx/constraintlayout/core/ArrayRow;->variablesToUpdate:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    goto :goto_8

    :cond_64
    move v1, v2

    goto :goto_8

    :cond_66
    sget-boolean v0, Landroidx/constraintlayout/core/LinearSystem;->SIMPLIFY_SYNONYMS:Z

    if-eqz v0, :cond_7a

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variable:Landroidx/constraintlayout/core/SolverVariable;

    if-eqz v0, :cond_7a

    iget-object v0, p0, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;

    invoke-interface {v0}, Landroidx/constraintlayout/core/ArrayRow$ArrayRowVariables;->getCurrentSize()I

    move-result v0

    if-nez v0, :cond_7a

    iput-boolean v2, p0, Landroidx/constraintlayout/core/ArrayRow;->isSimpleDefinition:Z

    iput-boolean v2, p1, Landroidx/constraintlayout/core/LinearSystem;->hasSimpleDefinition:Z

    :cond_7a
    return-void
.end method
