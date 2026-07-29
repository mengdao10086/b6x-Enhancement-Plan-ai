.class public Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;
.super Ljava/lang/Object;
.source "BasicMeasure.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;,
        Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;
    }
.end annotation


# static fields
.field public static final AT_MOST:I = -0x80000000

.field private static final DEBUG:Z = false

.field public static final EXACTLY:I = 0x40000000

.field public static final FIXED:I = -0x3

.field public static final MATCH_PARENT:I = -0x1

.field private static final MODE_SHIFT:I = 0x1e

.field public static final UNSPECIFIED:I = 0x0

.field public static final WRAP_CONTENT:I = -0x2


# instance fields
.field private constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

.field private mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

.field private final mVariableDimensionsWidgets:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-direct {v0}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iput-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    return-void
.end method

.method private measure(Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)Z
    .registers 8

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    iput-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    iput-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalDimension:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-virtual {p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalDimension:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredNeedsSolverPass:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iput p3, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measureStrategy:I

    iget-object p3, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget-object p3, p3, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x1

    if-ne p3, v0, :cond_34

    move p3, v2

    goto :goto_35

    :cond_34
    move p3, v1

    :goto_35
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v3, :cond_3f

    move v0, v2

    goto :goto_40

    :cond_3f
    move v0, v1

    :goto_40
    const/4 v3, 0x0

    if-eqz p3, :cond_4b

    iget p3, p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    cmpl-float p3, p3, v3

    if-lez p3, :cond_4b

    move p3, v2

    goto :goto_4c

    :cond_4b
    move p3, v1

    :goto_4c
    if-eqz v0, :cond_56

    iget v0, p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    cmpl-float v0, v0, v3

    if-lez v0, :cond_56

    move v0, v2

    goto :goto_57

    :cond_56
    move v0, v1

    :goto_57
    const/4 v3, 0x4

    if-eqz p3, :cond_66

    iget-object p3, p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    aget p3, p3, v1

    if-ne p3, v3, :cond_66

    iget-object p3, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v1, p3, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    :cond_66
    if-eqz v0, :cond_74

    iget-object p3, p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    aget p3, p3, v2

    if-ne p3, v3, :cond_74

    iget-object p3, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iput-object v0, p3, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    :cond_74
    iget-object p3, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    invoke-interface {p1, p2, p3}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredWidth:I

    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHeight:I

    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget-boolean p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHasBaseline:Z

    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHasBaseline(Z)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredBaseline:I

    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setBaselineDistance(I)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    sget p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->SELF_DIMENSIONS:I

    iput p2, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measureStrategy:I

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    iget-boolean p1, p1, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredNeedsSolverPass:Z

    return p1
.end method

.method private measureChildren(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V
    .registers 13

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x40

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    move-result v1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMeasurer()Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;

    move-result-object v2

    const/4 v3, 0x0

    move v4, v3

    :goto_12
    if-ge v4, v0, :cond_c4

    iget-object v5, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v6, :cond_22

    goto/16 :goto_c0

    :cond_22
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v6, :cond_28

    goto/16 :goto_c0

    :cond_28
    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVirtualLayout()Z

    move-result v6

    if-eqz v6, :cond_30

    goto/16 :goto_c0

    :cond_30
    if-eqz v1, :cond_4c

    iget-object v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    if-eqz v6, :cond_4c

    iget-object v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    if-eqz v6, :cond_4c

    iget-object v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v6, v6, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v6, :cond_4c

    iget-object v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v6, v6, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v6, v6, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v6, :cond_4c

    goto/16 :goto_c0

    :cond_4c
    invoke-virtual {v5, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v6

    const/4 v7, 0x1

    invoke-virtual {v5, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v8

    sget-object v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v6, v9, :cond_67

    iget v9, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-eq v9, v7, :cond_67

    sget-object v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v8, v9, :cond_67

    iget v9, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-eq v9, v7, :cond_67

    move v9, v7

    goto :goto_68

    :cond_67
    move v9, v3

    :goto_68
    if-nez v9, :cond_aa

    invoke-virtual {p1, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    move-result v10

    if-eqz v10, :cond_aa

    instance-of v10, v5, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-nez v10, :cond_aa

    sget-object v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v6, v10, :cond_87

    iget v10, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-nez v10, :cond_87

    sget-object v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v8, v10, :cond_87

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v10

    if-nez v10, :cond_87

    move v9, v7

    :cond_87
    sget-object v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v8, v10, :cond_9a

    iget v10, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-nez v10, :cond_9a

    sget-object v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v6, v10, :cond_9a

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v10

    if-nez v10, :cond_9a

    move v9, v7

    :cond_9a
    sget-object v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v6, v10, :cond_a2

    sget-object v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v8, v6, :cond_aa

    :cond_a2
    iget v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v8, 0x0

    cmpl-float v6, v6, v8

    if-lez v6, :cond_aa

    goto :goto_ab

    :cond_aa
    move v7, v9

    :goto_ab
    if-eqz v7, :cond_ae

    goto :goto_c0

    :cond_ae
    sget v6, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->SELF_DIMENSIONS:I

    invoke-direct {p0, v2, v5, v6}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->measure(Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)Z

    iget-object v5, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v5, :cond_c0

    iget-object v5, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v6, v5, Landroidx/constraintlayout/core/Metrics;->measuredWidgets:J

    const-wide/16 v8, 0x1

    add-long/2addr v6, v8

    iput-wide v6, v5, Landroidx/constraintlayout/core/Metrics;->measuredWidgets:J

    :cond_c0
    :goto_c0
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_12

    :cond_c4
    invoke-interface {v2}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;->didMeasures()V

    return-void
.end method

.method private solveLinearSystem(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Ljava/lang/String;III)V
    .registers 8

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMinWidth()I

    move-result p2

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMinHeight()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setMinWidth(I)V

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setMinHeight(I)V

    invoke-virtual {p1, p4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setWidth(I)V

    invoke-virtual {p1, p5}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setHeight(I)V

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setMinWidth(I)V

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setMinHeight(I)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {p1, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setPass(I)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->layout()V

    return-void
.end method


# virtual methods
.method public solverMeasure(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;IIIIIIIII)J
    .registers 34

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    move/from16 v3, p5

    move/from16 v4, p7

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMeasurer()Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;

    move-result-object v5

    iget-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getWidth()I

    move-result v7

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHeight()I

    move-result v8

    const/16 v9, 0x80

    invoke-static {v2, v9}, Landroidx/constraintlayout/core/widgets/Optimizer;->enabled(II)Z

    move-result v9

    const/4 v10, 0x0

    if-nez v9, :cond_30

    const/16 v12, 0x40

    invoke-static {v2, v12}, Landroidx/constraintlayout/core/widgets/Optimizer;->enabled(II)Z

    move-result v2

    if-eqz v2, :cond_2e

    goto :goto_30

    :cond_2e
    move v2, v10

    goto :goto_31

    :cond_30
    :goto_30
    const/4 v2, 0x1

    :goto_31
    if-eqz v2, :cond_8c

    move v12, v10

    :goto_34
    if-ge v12, v6, :cond_8c

    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v13, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v14

    sget-object v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v14, v15, :cond_48

    const/4 v14, 0x1

    goto :goto_49

    :cond_48
    move v14, v10

    :goto_49
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v15

    sget-object v11, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v15, v11, :cond_53

    const/4 v11, 0x1

    goto :goto_54

    :cond_53
    move v11, v10

    :goto_54
    if-eqz v14, :cond_63

    if-eqz v11, :cond_63

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v11

    const/4 v14, 0x0

    cmpl-float v11, v11, v14

    if-lez v11, :cond_63

    const/4 v11, 0x1

    goto :goto_64

    :cond_63
    move v11, v10

    :goto_64
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v14

    if-eqz v14, :cond_6e

    if-eqz v11, :cond_6e

    :cond_6c
    :goto_6c
    move v2, v10

    goto :goto_8c

    :cond_6e
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v14

    if-eqz v14, :cond_77

    if-eqz v11, :cond_77

    goto :goto_6c

    :cond_77
    instance-of v11, v13, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-eqz v11, :cond_7c

    goto :goto_6c

    :cond_7c
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v11

    if-nez v11, :cond_6c

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v11

    if-eqz v11, :cond_89

    goto :goto_6c

    :cond_89
    add-int/lit8 v12, v12, 0x1

    goto :goto_34

    :cond_8c
    :goto_8c
    const-wide/16 v11, 0x1

    if-eqz v2, :cond_9b

    sget-object v13, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v13, :cond_9b

    sget-object v13, Landroidx/constraintlayout/core/LinearSystem;->sMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v14, v13, Landroidx/constraintlayout/core/Metrics;->measures:J

    add-long/2addr v14, v11

    iput-wide v14, v13, Landroidx/constraintlayout/core/Metrics;->measures:J

    :cond_9b
    const/high16 v13, 0x40000000    # 2.0f

    if-ne v3, v13, :cond_a1

    if-eq v4, v13, :cond_a3

    :cond_a1
    if-eqz v9, :cond_a5

    :cond_a3
    const/4 v14, 0x1

    goto :goto_a6

    :cond_a5
    move v14, v10

    :goto_a6
    and-int/2addr v2, v14

    const/4 v14, 0x2

    if-eqz v2, :cond_10e

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMaxWidth()I

    move-result v15

    move/from16 v11, p6

    invoke-static {v15, v11}, Ljava/lang/Math;->min(II)I

    move-result v11

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMaxHeight()I

    move-result v12

    move/from16 v15, p8

    invoke-static {v12, v15}, Ljava/lang/Math;->min(II)I

    move-result v12

    if-ne v3, v13, :cond_cc

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getWidth()I

    move-result v15

    if-eq v15, v11, :cond_cc

    invoke-virtual {v1, v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setWidth(I)V

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->invalidateGraph()V

    :cond_cc
    if-ne v4, v13, :cond_da

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHeight()I

    move-result v11

    if-eq v11, v12, :cond_da

    invoke-virtual {v1, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setHeight(I)V

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->invalidateGraph()V

    :cond_da
    if-ne v3, v13, :cond_e4

    if-ne v4, v13, :cond_e4

    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->directMeasure(Z)Z

    move-result v9

    move v12, v14

    goto :goto_fe

    :cond_e4
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->directMeasureSetup(Z)Z

    move-result v11

    if-ne v3, v13, :cond_f1

    invoke-virtual {v1, v9, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->directMeasureWithOrientation(ZI)Z

    move-result v12

    and-int/2addr v11, v12

    const/4 v12, 0x1

    goto :goto_f2

    :cond_f1
    move v12, v10

    :goto_f2
    if-ne v4, v13, :cond_fd

    const/4 v15, 0x1

    invoke-virtual {v1, v9, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->directMeasureWithOrientation(ZI)Z

    move-result v9

    and-int/2addr v9, v11

    add-int/lit8 v12, v12, 0x1

    goto :goto_fe

    :cond_fd
    move v9, v11

    :goto_fe
    if-eqz v9, :cond_110

    if-ne v3, v13, :cond_104

    const/4 v15, 0x1

    goto :goto_105

    :cond_104
    move v15, v10

    :goto_105
    if-ne v4, v13, :cond_109

    const/4 v3, 0x1

    goto :goto_10a

    :cond_109
    move v3, v10

    :goto_10a
    invoke-virtual {v1, v15, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->updateFromRuns(ZZ)V

    goto :goto_110

    :cond_10e
    move v9, v10

    move v12, v9

    :cond_110
    :goto_110
    if-eqz v9, :cond_114

    if-eq v12, v14, :cond_327

    :cond_114
    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getOptimizationLevel()I

    move-result v3

    if-lez v6, :cond_11d

    invoke-direct/range {p0 .. p1}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->measureChildren(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V

    :cond_11d
    invoke-virtual/range {p0 .. p1}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->updateHierarchy(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V

    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v6, :cond_13a

    const-string v6, "First pass"

    const/4 v9, 0x0

    move-object/from16 p2, p0

    move-object/from16 p3, p1

    move-object/from16 p4, v6

    move/from16 p5, v9

    move/from16 p6, v7

    move/from16 p7, v8

    invoke-direct/range {p2 .. p7}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->solveLinearSystem(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Ljava/lang/String;III)V

    :cond_13a
    if-lez v4, :cond_323

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v6

    sget-object v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v6, v9, :cond_146

    const/4 v15, 0x1

    goto :goto_147

    :cond_146
    move v15, v10

    :goto_147
    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v6

    sget-object v9, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v6, v9, :cond_151

    const/4 v6, 0x1

    goto :goto_152

    :cond_151
    move v6, v10

    :goto_152
    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getWidth()I

    move-result v9

    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMinWidth()I

    move-result v11

    invoke-static {v9, v11}, Ljava/lang/Math;->max(II)I

    move-result v9

    invoke-virtual/range {p1 .. p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHeight()I

    move-result v11

    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->constraintWidgetContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getMinHeight()I

    move-result v12

    invoke-static {v11, v12}, Ljava/lang/Math;->max(II)I

    move-result v11

    move v12, v10

    move v13, v12

    :goto_170
    if-ge v12, v4, :cond_213

    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    invoke-virtual {v10, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    instance-of v14, v10, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-nez v14, :cond_186

    move/from16 p8, v3

    move/from16 v19, v7

    move/from16 v18, v8

    goto/16 :goto_207

    :cond_186
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v14

    move/from16 p8, v3

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v3

    move/from16 v18, v8

    sget v8, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->TRY_GIVEN_DIMENSIONS:I

    invoke-direct {v0, v5, v10, v8}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->measure(Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)Z

    move-result v8

    or-int/2addr v8, v13

    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v13, :cond_1ac

    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    move/from16 v19, v7

    move/from16 p2, v8

    iget-wide v7, v13, Landroidx/constraintlayout/core/Metrics;->measuredMatchWidgets:J

    const-wide/16 v16, 0x1

    add-long v7, v7, v16

    iput-wide v7, v13, Landroidx/constraintlayout/core/Metrics;->measuredMatchWidgets:J

    goto :goto_1b0

    :cond_1ac
    move/from16 v19, v7

    move/from16 p2, v8

    :goto_1b0
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v7

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v8

    if-eq v7, v14, :cond_1db

    invoke-virtual {v10, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    if-eqz v15, :cond_1d9

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getRight()I

    move-result v7

    if-le v7, v9, :cond_1d9

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getRight()I

    move-result v7

    sget-object v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v10, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v13

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v13

    add-int/2addr v7, v13

    invoke-static {v9, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    move v9, v7

    :cond_1d9
    const/4 v7, 0x1

    goto :goto_1dd

    :cond_1db
    move/from16 v7, p2

    :goto_1dd
    if-eq v8, v3, :cond_1ff

    invoke-virtual {v10, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    if-eqz v6, :cond_1fe

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBottom()I

    move-result v3

    if-le v3, v11, :cond_1fe

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBottom()I

    move-result v3

    sget-object v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v10, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v7

    invoke-virtual {v7}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v7

    add-int/2addr v3, v7

    invoke-static {v11, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    move v11, v3

    :cond_1fe
    const/4 v7, 0x1

    :cond_1ff
    check-cast v10, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/VirtualLayout;->needSolverPass()Z

    move-result v3

    or-int v13, v7, v3

    :goto_207
    add-int/lit8 v12, v12, 0x1

    move/from16 v3, p8

    move/from16 v8, v18

    move/from16 v7, v19

    const/4 v10, 0x0

    const/4 v14, 0x2

    goto/16 :goto_170

    :cond_213
    move/from16 p8, v3

    move/from16 v19, v7

    move/from16 v18, v8

    move v7, v14

    const/4 v3, 0x0

    :goto_21b
    if-ge v3, v7, :cond_320

    const/4 v8, 0x0

    :goto_21e
    if-ge v8, v4, :cond_2f9

    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    invoke-virtual {v10, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    instance-of v12, v10, Landroidx/constraintlayout/core/widgets/Helper;

    if-eqz v12, :cond_230

    instance-of v12, v10, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-eqz v12, :cond_255

    :cond_230
    instance-of v12, v10, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v12, :cond_235

    goto :goto_255

    :cond_235
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVisibility()I

    move-result v12

    const/16 v14, 0x8

    if-ne v12, v14, :cond_23e

    goto :goto_255

    :cond_23e
    if-eqz v2, :cond_251

    iget-object v12, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v12, :cond_251

    iget-object v12, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v12, :cond_251

    goto :goto_255

    :cond_251
    instance-of v12, v10, Landroidx/constraintlayout/core/widgets/VirtualLayout;

    if-eqz v12, :cond_25f

    :cond_255
    :goto_255
    move/from16 v21, v2

    move/from16 v22, v4

    move-object/from16 v20, v5

    const-wide/16 v16, 0x1

    goto/16 :goto_2ee

    :cond_25f
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v12

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v14

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBaselineDistance()I

    move-result v7

    sget v20, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->TRY_GIVEN_DIMENSIONS:I

    move/from16 v21, v2

    const/4 v2, 0x1

    if-ne v3, v2, :cond_274

    sget v20, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->USE_GIVEN_DIMENSIONS:I

    :cond_274
    move/from16 v2, v20

    invoke-direct {v0, v5, v10, v2}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->measure(Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)Z

    move-result v2

    or-int/2addr v2, v13

    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v13, :cond_28e

    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    move/from16 v22, v4

    move-object/from16 v20, v5

    iget-wide v4, v13, Landroidx/constraintlayout/core/Metrics;->measuredMatchWidgets:J

    const-wide/16 v16, 0x1

    add-long v4, v4, v16

    iput-wide v4, v13, Landroidx/constraintlayout/core/Metrics;->measuredMatchWidgets:J

    goto :goto_294

    :cond_28e
    move/from16 v22, v4

    move-object/from16 v20, v5

    const-wide/16 v16, 0x1

    :goto_294
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v4

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    move-result v5

    if-eq v4, v12, :cond_2bd

    invoke-virtual {v10, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    if-eqz v15, :cond_2bc

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getRight()I

    move-result v2

    if-le v2, v9, :cond_2bc

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getRight()I

    move-result v2

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v10, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v4

    add-int/2addr v2, v4

    invoke-static {v9, v2}, Ljava/lang/Math;->max(II)I

    move-result v9

    :cond_2bc
    const/4 v2, 0x1

    :cond_2bd
    if-eq v5, v14, :cond_2df

    invoke-virtual {v10, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    if-eqz v6, :cond_2de

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBottom()I

    move-result v2

    if-le v2, v11, :cond_2de

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBottom()I

    move-result v2

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v10, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v4

    add-int/2addr v2, v4

    invoke-static {v11, v2}, Ljava/lang/Math;->max(II)I

    move-result v2

    move v11, v2

    :cond_2de
    const/4 v2, 0x1

    :cond_2df
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasBaseline()Z

    move-result v4

    if-eqz v4, :cond_2ed

    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getBaselineDistance()I

    move-result v4

    if-eq v7, v4, :cond_2ed

    const/4 v13, 0x1

    goto :goto_2ee

    :cond_2ed
    move v13, v2

    :goto_2ee
    add-int/lit8 v8, v8, 0x1

    move-object/from16 v5, v20

    move/from16 v2, v21

    move/from16 v4, v22

    const/4 v7, 0x2

    goto/16 :goto_21e

    :cond_2f9
    move/from16 v21, v2

    move/from16 v22, v4

    move-object/from16 v20, v5

    const-wide/16 v16, 0x1

    if-eqz v13, :cond_320

    const-string v2, "intermediate pass"

    add-int/lit8 v3, v3, 0x1

    move-object/from16 p2, p0

    move-object/from16 p3, p1

    move-object/from16 p4, v2

    move/from16 p5, v3

    move/from16 p6, v19

    move/from16 p7, v18

    invoke-direct/range {p2 .. p7}, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->solveLinearSystem(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Ljava/lang/String;III)V

    move-object/from16 v5, v20

    move/from16 v2, v21

    move/from16 v4, v22

    const/4 v7, 0x2

    const/4 v13, 0x0

    goto/16 :goto_21b

    :cond_320
    move/from16 v2, p8

    goto :goto_324

    :cond_323
    move v2, v3

    :goto_324
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setOptimizationLevel(I)V

    :cond_327
    const-wide/16 v1, 0x0

    return-wide v1
.end method

.method public updateHierarchy(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V
    .registers 7

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_c
    if-ge v1, v0, :cond_2e

    iget-object v2, p1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v3, v4, :cond_26

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v3

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v3, v4, :cond_2b

    :cond_26
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure;->mVariableDimensionsWidgets:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2b
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    :cond_2e
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->invalidateGraph()V

    return-void
.end method
