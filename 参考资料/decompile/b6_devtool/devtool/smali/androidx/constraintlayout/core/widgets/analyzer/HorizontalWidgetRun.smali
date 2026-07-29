.class public Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;
.super Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;
.source "HorizontalWidgetRun.java"


# static fields
.field private static tempDimensions:[I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x2

    new-array v0, v0, [I

    sput-object v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    return-void
.end method

.method public constructor <init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V
    .registers 3

    invoke-direct {p0, p1}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    sget-object v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;->LEFT:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;

    iput-object v0, p1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->type:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;

    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    sget-object v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;

    iput-object v0, p1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->type:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode$Type;

    const/4 p1, 0x0

    iput p1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->orientation:I

    return-void
.end method

.method private computeInsetRatio([IIIIIFI)V
    .registers 10

    sub-int/2addr p3, p2

    sub-int/2addr p5, p4

    const/4 p2, -0x1

    const/4 p4, 0x0

    const/high16 v0, 0x3f000000    # 0.5f

    const/4 v1, 0x1

    if-eq p7, p2, :cond_20

    if-eqz p7, :cond_17

    if-eq p7, v1, :cond_e

    goto :goto_35

    :cond_e
    int-to-float p2, p3

    mul-float/2addr p2, p6

    add-float/2addr p2, v0

    float-to-int p2, p2

    aput p3, p1, p4

    aput p2, p1, v1

    goto :goto_35

    :cond_17
    int-to-float p2, p5

    mul-float/2addr p2, p6

    add-float/2addr p2, v0

    float-to-int p2, p2

    aput p2, p1, p4

    aput p5, p1, v1

    goto :goto_35

    :cond_20
    int-to-float p2, p5

    mul-float/2addr p2, p6

    add-float/2addr p2, v0

    float-to-int p2, p2

    int-to-float p7, p3

    div-float/2addr p7, p6

    add-float/2addr p7, v0

    float-to-int p6, p7

    if-gt p2, p3, :cond_2f

    aput p2, p1, p4

    aput p5, p1, v1

    goto :goto_35

    :cond_2f
    if-gt p6, p5, :cond_35

    aput p3, p1, p4

    aput p6, p1, v1

    :cond_35
    :goto_35
    return-void
.end method


# virtual methods
.method apply()V
    .registers 6

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    if-eqz v0, :cond_11

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    :cond_11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-nez v0, :cond_94

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v0

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v0, v1, :cond_d6

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v1, :cond_82

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_82

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v1, v2, :cond_43

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v2, :cond_82

    :cond_43
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v1

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    sub-int/2addr v1, v2

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v4

    invoke-virtual {p0, v2, v3, v4}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    neg-int v3, v3

    invoke-virtual {p0, v2, v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    return-void

    :cond_82
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v1, :cond_d6

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto :goto_d6

    :cond_94
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v1, :cond_d6

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_d6

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq v1, v2, :cond_b2

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v2, :cond_d6

    :cond_b2
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    invoke-virtual {p0, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    neg-int v2, v2

    invoke-virtual {p0, v1, v0, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    return-void

    :cond_d6
    :goto_d6
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_202

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    if-eqz v0, :cond_202

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_160

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_160

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-eqz v0, :cond_11f

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v3, v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v1, v2

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    goto/16 :goto_43c

    :cond_11f
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_13a

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v4, v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual {p0, v3, v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    :cond_13a
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_156

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v3, v3, v2

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    neg-int v3, v3

    invoke-virtual {p0, v1, v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    :cond_156
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->delegateToWidgetRun:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->delegateToWidgetRun:Z

    goto/16 :goto_43c

    :cond_160
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_192

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v3, v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual {p0, v2, v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    invoke-virtual {p0, v0, v1, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    goto/16 :goto_43c

    :cond_192
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_1c6

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v2, v3, v2

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    neg-int v2, v2

    invoke-virtual {p0, v1, v0, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    neg-int v2, v2

    invoke-virtual {p0, v0, v1, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    goto/16 :goto_43c

    :cond_1c6
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    instance-of v0, v0, Landroidx/constraintlayout/core/widgets/Helper;

    if-nez v0, :cond_43c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v0

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v0, :cond_43c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getX()I

    move-result v2

    invoke-virtual {p0, v1, v0, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    invoke-virtual {p0, v0, v1, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    goto/16 :goto_43c

    :cond_202
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v3, :cond_351

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    const/4 v3, 0x2

    if-eq v0, v3, :cond_320

    const/4 v3, 0x3

    if-eq v0, v3, :cond_214

    goto/16 :goto_351

    :cond_214
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-ne v0, v3, :cond_2c9

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    move-result v0

    if-eqz v0, :cond_296

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->updateDelegate:Landroidx/constraintlayout/core/widgets/analyzer/Dependency;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_351

    :cond_296
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-eqz v0, :cond_2ba

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_351

    :cond_2ba
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_351

    :cond_2c9
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->delegateToWidgetRun:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_351

    :cond_320
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-nez v0, :cond_329

    goto :goto_351

    :cond_329
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->targets:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->delegateToWidgetRun:Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->dependencies:Ljava/util/List;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_351
    :goto_351
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_3b0

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_3b0

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-eqz v0, :cond_38c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v3, v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v1, v2

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    neg-int v1, v1

    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    goto/16 :goto_43c

    :cond_38c
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v1, v2

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v1

    if-eqz v0, :cond_3a5

    invoke-virtual {v0, p0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->addDependency(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;)V

    :cond_3a5
    if-eqz v1, :cond_3aa

    invoke-virtual {v1, p0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->addDependency(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;)V

    :cond_3aa
    sget-object v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType;->CENTER:Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType;

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->mRunType:Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType;

    goto/16 :goto_43c

    :cond_3b0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_3df

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v1, v4, v1

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    invoke-virtual {p0, v3, v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {p0, v0, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;ILandroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;)V

    goto :goto_43c

    :cond_3df
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_410

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v0, v0, v2

    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getTarget(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    aget-object v2, v3, v2

    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    neg-int v2, v2

    invoke-virtual {p0, v1, v0, v2}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    const/4 v2, -0x1

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {p0, v0, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;ILandroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;)V

    goto :goto_43c

    :cond_410
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    instance-of v0, v0, Landroidx/constraintlayout/core/widgets/Helper;

    if-nez v0, :cond_43c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_43c

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getX()I

    move-result v3

    invoke-virtual {p0, v1, v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {p0, v0, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->addTarget(Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;ILandroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;)V

    :cond_43c
    :goto_43c
    return-void
.end method

.method public applyToWidget()V
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_f

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setX(I)V

    :cond_f
    return-void
.end method

.method clear()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->runGroup:Landroidx/constraintlayout/core/widgets/analyzer/RunGroup;

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->clear()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->clear()V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->clear()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->resolved:Z

    return-void
.end method

.method reset()V
    .registers 3

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->resolved:Z

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->clear()V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-boolean v0, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->clear()V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iput-boolean v0, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iput-boolean v0, v1, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    return-void
.end method

.method supportsWrapComputation()Z
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v2, 0x1

    if-ne v0, v1, :cond_10

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-nez v0, :cond_e

    return v2

    :cond_e
    const/4 v0, 0x0

    return v0

    :cond_10
    return v2
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "HorizontalRun "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDebugName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public update(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;)V
    .registers 18

    move-object/from16 v8, p0

    sget-object v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun$1;->$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType:[I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->mRunType:Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x2

    const/4 v2, 0x3

    const/4 v9, 0x1

    const/4 v10, 0x0

    if-eq v0, v9, :cond_2b

    if-eq v0, v1, :cond_25

    if-eq v0, v2, :cond_17

    goto :goto_30

    :cond_17
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-object/from16 v3, p1

    invoke-virtual {v8, v3, v0, v1, v10}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->updateRunCenter(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_25
    move-object/from16 v3, p1

    invoke-virtual/range {p0 .. p1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->updateRunEnd(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;)V

    goto :goto_30

    :cond_2b
    move-object/from16 v3, p1

    invoke-virtual/range {p0 .. p1}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->updateRunStart(Landroidx/constraintlayout/core/widgets/analyzer/Dependency;)V

    :goto_30
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    const/high16 v11, 0x3f000000    # 0.5f

    if-nez v0, :cond_351

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v3, :cond_351

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-eq v0, v1, :cond_32e

    if-eq v0, v2, :cond_48

    goto/16 :goto_351

    :cond_48
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    const/4 v1, -0x1

    if-eqz v0, :cond_9e

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    if-ne v0, v2, :cond_56

    goto :goto_9e

    :cond_56
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatioSide()I

    move-result v0

    if-eq v0, v1, :cond_85

    if-eqz v0, :cond_74

    if-eq v0, v9, :cond_64

    move v0, v10

    goto :goto_97

    :cond_64
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    int-to-float v0, v0

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v1

    goto :goto_94

    :cond_74
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    int-to-float v0, v0

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v1

    div-float/2addr v0, v1

    goto :goto_95

    :cond_85
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    int-to-float v0, v0

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v1

    :goto_94
    mul-float/2addr v0, v1

    :goto_95
    add-float/2addr v0, v11

    float-to-int v0, v0

    :goto_97
    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto/16 :goto_351

    :cond_9e
    :goto_9e
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v0, :cond_b4

    move v0, v9

    goto :goto_b5

    :cond_b4
    move v0, v10

    :goto_b5
    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v2, :cond_bf

    move v2, v9

    goto :goto_c0

    :cond_bf
    move v2, v10

    :goto_c0
    iget-object v3, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v3, :cond_ca

    move v3, v9

    goto :goto_cb

    :cond_ca
    move v3, v10

    :goto_cb
    iget-object v4, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v4, :cond_d5

    move v4, v9

    goto :goto_d6

    :cond_d5
    move v4, v10

    :goto_d6
    iget-object v5, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatioSide()I

    move-result v14

    if-eqz v0, :cond_22c

    if-eqz v2, :cond_22c

    if-eqz v3, :cond_22c

    if-eqz v4, :cond_22c

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v15

    iget-boolean v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_14f

    iget-boolean v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_14f

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_14e

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_ff

    goto :goto_14e

    :cond_ff
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v2, v0, v1

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v3, v0, v1

    iget v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v4, v0, v1

    iget v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v5, v0, v1

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    move-object/from16 v0, p0

    move v6, v15

    move v7, v14

    invoke-direct/range {v0 .. v7}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->computeInsetRatio([IIIIIFI)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v10

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v9

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    :cond_14e
    :goto_14e
    return-void

    :cond_14f
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1b5

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_1b5

    iget-boolean v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_1b4

    iget-boolean v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_164

    goto :goto_1b4

    :cond_164
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v2, v0, v1

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v3, v0, v1

    iget-object v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v4, v0, v1

    iget-object v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v5, v0, v1

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    move-object/from16 v0, p0

    move v6, v15

    move v7, v14

    invoke-direct/range {v0 .. v7}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->computeInsetRatio([IIIIIFI)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v10

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v9

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto :goto_1b5

    :cond_1b4
    :goto_1b4
    return-void

    :cond_1b5
    :goto_1b5
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_22b

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_22b

    iget-boolean v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_22b

    iget-boolean v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_1ca

    goto :goto_22b

    :cond_1ca
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v2, v0, v1

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v3, v0, v1

    iget-object v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int v4, v0, v1

    iget-object v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v1, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int v5, v0, v1

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    move-object/from16 v0, p0

    move v6, v15

    move v7, v14

    invoke-direct/range {v0 .. v7}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->computeInsetRatio([IIIIIFI)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v10

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    sget-object v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->tempDimensions:[I

    aget v1, v1, v9

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto/16 :goto_351

    :cond_22b
    :goto_22b
    return-void

    :cond_22c
    if-eqz v0, :cond_2b5

    if-eqz v3, :cond_2b5

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_2b4

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_23e

    goto/16 :goto_2b4

    :cond_23e
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v0

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v2, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v3, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v2, v3

    iget-object v3, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v4, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v4, v4, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int/2addr v3, v4

    if-eq v14, v1, :cond_291

    if-eqz v14, :cond_291

    if-eq v14, v9, :cond_26e

    goto/16 :goto_351

    :cond_26e
    sub-int/2addr v3, v2

    invoke-virtual {v8, v3, v10}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v1

    int-to-float v2, v1

    div-float/2addr v2, v0

    add-float/2addr v2, v11

    float-to-int v2, v2

    invoke-virtual {v8, v2, v9}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v3

    if-eq v2, v3, :cond_281

    int-to-float v1, v3

    mul-float/2addr v1, v0

    add-float/2addr v1, v11

    float-to-int v1, v1

    :cond_281
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto/16 :goto_351

    :cond_291
    sub-int/2addr v3, v2

    invoke-virtual {v8, v3, v10}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v1

    int-to-float v2, v1

    mul-float/2addr v2, v0

    add-float/2addr v2, v11

    float-to-int v2, v2

    invoke-virtual {v8, v2, v9}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v3

    if-eq v2, v3, :cond_2a4

    int-to-float v1, v3

    div-float/2addr v1, v0

    add-float/2addr v1, v11

    float-to-int v1, v1

    :cond_2a4
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto/16 :goto_351

    :cond_2b4
    :goto_2b4
    return-void

    :cond_2b5
    if-eqz v2, :cond_351

    if-eqz v4, :cond_351

    iget-boolean v0, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_32d

    iget-boolean v0, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_2c2

    goto :goto_32d

    :cond_2c2
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionRatio()F

    move-result v0

    iget-object v2, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v2, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v3, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v2, v3

    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v4, v13, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    sub-int/2addr v3, v4

    if-eq v14, v1, :cond_30b

    if-eqz v14, :cond_2e9

    if-eq v14, v9, :cond_30b

    goto :goto_351

    :cond_2e9
    sub-int/2addr v3, v2

    invoke-virtual {v8, v3, v9}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v1

    int-to-float v2, v1

    mul-float/2addr v2, v0

    add-float/2addr v2, v11

    float-to-int v2, v2

    invoke-virtual {v8, v2, v10}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v3

    if-eq v2, v3, :cond_2fc

    int-to-float v1, v3

    div-float/2addr v1, v0

    add-float/2addr v1, v11

    float-to-int v1, v1

    :cond_2fc
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto :goto_351

    :cond_30b
    sub-int/2addr v3, v2

    invoke-virtual {v8, v3, v9}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v1

    int-to-float v2, v1

    div-float/2addr v2, v0

    add-float/2addr v2, v11

    float-to-int v2, v2

    invoke-virtual {v8, v2, v10}, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->getLimitedDimension(II)I

    move-result v3

    if-eq v2, v3, :cond_31e

    int-to-float v1, v3

    mul-float/2addr v1, v0

    add-float/2addr v1, v11

    float-to-int v1, v1

    :cond_31e
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v3}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    goto :goto_351

    :cond_32d
    :goto_32d
    return-void

    :cond_32e
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getParent()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v0

    if-eqz v0, :cond_351

    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v1, :cond_351

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    int-to-float v0, v0

    mul-float/2addr v0, v1

    add-float/2addr v0, v11

    float-to-int v0, v0

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    :cond_351
    :goto_351
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-eqz v0, :cond_47b

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->readyToSolve:Z

    if-nez v0, :cond_35f

    goto/16 :goto_47b

    :cond_35f
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_372

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    if-eqz v0, :cond_372

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-eqz v0, :cond_372

    return-void

    :cond_372
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-nez v0, :cond_3c0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v1, :cond_3c0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    if-nez v0, :cond_3c0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    move-result v0

    if-nez v0, :cond_3c0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v1, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v0, v2

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v1, v2

    sub-int v2, v1, v0

    iget-object v3, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v3, v0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v0, v2}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    return-void

    :cond_3c0
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-nez v0, :cond_426

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimensionBehavior:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_CONSTRAINT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v0, v1, :cond_426

    iget v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->matchConstraintsType:I

    if-ne v0, v9, :cond_426

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_426

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_426

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v1, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v0, v2

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v1, v2

    sub-int/2addr v1, v0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->wrapValue:I

    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    if-lez v1, :cond_421

    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    :cond_421
    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    :cond_426
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolved:Z

    if-nez v0, :cond_42d

    return-void

    :cond_42d
    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v0, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->targets:Ljava/util/List;

    invoke-interface {v1, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v3, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v2, v3

    iget v3, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v4, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v4, v4, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->margin:I

    add-int/2addr v3, v4

    iget-object v4, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->widget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalBiasPercent()F

    move-result v4

    if-ne v0, v1, :cond_45c

    iget v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget v3, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    move v4, v11

    :cond_45c
    sub-int/2addr v3, v2

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    sub-int/2addr v3, v0

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    int-to-float v1, v2

    add-float/2addr v1, v11

    int-to-float v2, v3

    mul-float/2addr v2, v4

    add-float/2addr v1, v2

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    iget-object v0, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget-object v1, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;->dimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->value:I

    add-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    :cond_47b
    :goto_47b
    return-void
.end method
