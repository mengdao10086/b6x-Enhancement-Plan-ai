.class public Landroidx/constraintlayout/core/widgets/analyzer/Grouping;
.super Ljava/lang/Object;
.source "Grouping.java"


# static fields
.field private static final DEBUG:Z = false

.field private static final DEBUG_GROUPING:Z = false


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/constraintlayout/core/widgets/ConstraintWidget;",
            "I",
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;",
            ">;",
            "Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;",
            ")",
            "Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;"
        }
    .end annotation

    if-nez p1, :cond_5

    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    goto :goto_7

    :cond_5
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    :goto_7
    const/4 v1, 0x0

    const/4 v2, -0x1

    if-eq v0, v2, :cond_31

    if-eqz p3, :cond_11

    iget v3, p3, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->id:I

    if-eq v0, v3, :cond_31

    :cond_11
    move v3, v1

    :goto_12
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v3, v4, :cond_34

    invoke-virtual {p2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getId()I

    move-result v5

    if-ne v5, v0, :cond_2e

    if-eqz p3, :cond_2c

    invoke-virtual {p3, p1, v4}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->moveTo(ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    invoke-virtual {p2, p3}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_2c
    move-object p3, v4

    goto :goto_34

    :cond_2e
    add-int/lit8 v3, v3, 0x1

    goto :goto_12

    :cond_31
    if-eq v0, v2, :cond_34

    return-object p3

    :cond_34
    :goto_34
    if-nez p3, :cond_65

    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/HelperWidget;

    if-eqz v0, :cond_5b

    move-object v0, p0

    check-cast v0, Landroidx/constraintlayout/core/widgets/HelperWidget;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/HelperWidget;->findGroupInDependents(I)I

    move-result v0

    if-eq v0, v2, :cond_5b

    move v2, v1

    :goto_44
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v2, v3, :cond_5b

    invoke-virtual {p2, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getId()I

    move-result v4

    if-ne v4, v0, :cond_58

    move-object p3, v3

    goto :goto_5b

    :cond_58
    add-int/lit8 v2, v2, 0x1

    goto :goto_44

    :cond_5b
    :goto_5b
    if-nez p3, :cond_62

    new-instance p3, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    invoke-direct {p3, p1}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;-><init>(I)V

    :cond_62
    invoke-virtual {p2, p3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_65
    invoke-virtual {p3, p0}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)Z

    move-result v0

    if-eqz v0, :cond_ad

    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v0, :cond_80

    move-object v0, p0

    check-cast v0, Landroidx/constraintlayout/core/widgets/Guideline;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/Guideline;->getAnchor()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v2

    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/Guideline;->getOrientation()I

    move-result v0

    if-nez v0, :cond_7d

    const/4 v1, 0x1

    :cond_7d
    invoke-virtual {v2, v1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    :cond_80
    if-nez p1, :cond_93

    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getId()I

    move-result v0

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    goto :goto_a8

    :cond_93
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getId()I

    move-result v0

    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    :goto_a8
    iget-object p0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p0, p1, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->findDependents(ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    :cond_ad
    return-object p3
.end method

.method private static findGroup(Ljava/util/ArrayList;I)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;",
            ">;I)",
            "Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;"
        }
    .end annotation

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge v1, v0, :cond_15

    invoke-virtual {p0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    iget v3, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->id:I

    if-ne p1, v3, :cond_12

    return-object v2

    :cond_12
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_15
    const/4 p0, 0x0

    return-object p0
.end method

.method public static simpleSolvingPass(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;)Z
    .registers 18

    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getChildren()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x0

    move v4, v3

    :goto_c
    if-ge v4, v2, :cond_33

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v6

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v7

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v8

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v9

    invoke-static {v6, v7, v8, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->validInGroup(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)Z

    move-result v6

    if-nez v6, :cond_2b

    return v3

    :cond_2b
    instance-of v5, v5, Landroidx/constraintlayout/core/widgets/Flow;

    if-eqz v5, :cond_30

    return v3

    :cond_30
    add-int/lit8 v4, v4, 0x1

    goto :goto_c

    :cond_33
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    if-eqz v4, :cond_40

    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMetrics:Landroidx/constraintlayout/core/Metrics;

    iget-wide v5, v4, Landroidx/constraintlayout/core/Metrics;->grouping:J

    const-wide/16 v7, 0x1

    add-long/2addr v5, v7

    iput-wide v5, v4, Landroidx/constraintlayout/core/Metrics;->grouping:J

    :cond_40
    move v5, v3

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    :goto_47
    if-ge v5, v2, :cond_121

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v14

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v15

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v4

    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v12

    invoke-static {v14, v15, v4, v12}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->validInGroup(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)Z

    move-result v4

    if-nez v4, :cond_6f

    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    sget v12, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->SELF_DIMENSIONS:I

    move-object/from16 v14, p1

    invoke-static {v3, v13, v14, v4, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->measure(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;I)Z

    goto :goto_71

    :cond_6f
    move-object/from16 v14, p1

    :goto_71
    instance-of v4, v13, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v4, :cond_99

    move-object v12, v13

    check-cast v12, Landroidx/constraintlayout/core/widgets/Guideline;

    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/Guideline;->getOrientation()I

    move-result v15

    if-nez v15, :cond_88

    if-nez v8, :cond_85

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    :cond_85
    invoke-virtual {v8, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_88
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/Guideline;->getOrientation()I

    move-result v15

    const/4 v3, 0x1

    if-ne v15, v3, :cond_99

    if-nez v6, :cond_96

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    :cond_96
    invoke-virtual {v6, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_99
    instance-of v3, v13, Landroidx/constraintlayout/core/widgets/HelperWidget;

    if-eqz v3, :cond_dd

    instance-of v3, v13, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v3, :cond_c6

    move-object v3, v13

    check-cast v3, Landroidx/constraintlayout/core/widgets/Barrier;

    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    move-result v12

    if-nez v12, :cond_b4

    if-nez v7, :cond_b1

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    :cond_b1
    invoke-virtual {v7, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_b4
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    move-result v12

    const/4 v15, 0x1

    if-ne v12, v15, :cond_dd

    if-nez v9, :cond_c2

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    :cond_c2
    invoke-virtual {v9, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_dd

    :cond_c6
    move-object v3, v13

    check-cast v3, Landroidx/constraintlayout/core/widgets/HelperWidget;

    if-nez v7, :cond_d0

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    :cond_d0
    invoke-virtual {v7, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    if-nez v9, :cond_da

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    :cond_da
    invoke-virtual {v9, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_dd
    :goto_dd
    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v3, :cond_f9

    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v3, :cond_f9

    if-nez v4, :cond_f9

    instance-of v3, v13, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v3, :cond_f9

    if-nez v10, :cond_f6

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    :cond_f6
    invoke-virtual {v10, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_f9
    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v3, :cond_11c

    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v3, :cond_11c

    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v3, :cond_11c

    if-nez v4, :cond_11c

    instance-of v3, v13, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v3, :cond_11c

    if-nez v11, :cond_119

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object v11, v3

    :cond_119
    invoke-virtual {v11, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_11c
    add-int/lit8 v5, v5, 0x1

    const/4 v3, 0x0

    goto/16 :goto_47

    :cond_121
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    if-eqz v6, :cond_13e

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_12c
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_13e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/Guideline;

    const/4 v6, 0x0

    const/4 v12, 0x0

    invoke-static {v5, v12, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_12c

    :cond_13e
    const/4 v6, 0x0

    const/4 v12, 0x0

    if-eqz v7, :cond_15f

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_146
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_15f

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/HelperWidget;

    invoke-static {v5, v12, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    move-result-object v7

    invoke-virtual {v5, v3, v12, v7}, Landroidx/constraintlayout/core/widgets/HelperWidget;->addDependents(Ljava/util/ArrayList;ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    invoke-virtual {v7, v3}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->cleanup(Ljava/util/ArrayList;)V

    const/4 v6, 0x0

    const/4 v12, 0x0

    goto :goto_146

    :cond_15f
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->LEFT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_187

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_173
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_187

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_173

    :cond_187
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->RIGHT:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_1af

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_19b
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1af

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_19b

    :cond_1af
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_1d7

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1c3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1d7

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_1c3

    :cond_1d7
    const/4 v6, 0x0

    const/4 v7, 0x0

    if-eqz v10, :cond_1ef

    invoke-virtual {v10}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1df
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1ef

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_1df

    :cond_1ef
    if-eqz v8, :cond_206

    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1f5
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_206

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/Guideline;

    const/4 v7, 0x1

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_1f5

    :cond_206
    const/4 v7, 0x1

    if-eqz v9, :cond_226

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_20d
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_226

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/HelperWidget;

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    move-result-object v8

    invoke-virtual {v5, v3, v7, v8}, Landroidx/constraintlayout/core/widgets/HelperWidget;->addDependents(Ljava/util/ArrayList;ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    invoke-virtual {v8, v3}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->cleanup(Ljava/util/ArrayList;)V

    const/4 v6, 0x0

    const/4 v7, 0x1

    goto :goto_20d

    :cond_226
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->TOP:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_24e

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_23a
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_24e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-static {v5, v6, v3, v7}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_23a

    :cond_24e
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BASELINE:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_276

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_262
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_276

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-static {v5, v6, v3, v7}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_262

    :cond_276
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->BOTTOM:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_29e

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_28a
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_29e

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-static {v5, v6, v3, v7}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_28a

    :cond_29e
    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;->CENTER:Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;

    invoke-virtual {v0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getAnchor(Landroidx/constraintlayout/core/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v4

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v5

    if-eqz v5, :cond_2c6

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getDependents()Ljava/util/HashSet;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2b2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2c6

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_2b2

    :cond_2c6
    const/4 v6, 0x0

    const/4 v7, 0x1

    if-eqz v11, :cond_2de

    invoke-virtual {v11}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2ce
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2de

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-static {v5, v7, v3, v6}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    goto :goto_2ce

    :cond_2de
    const/4 v4, 0x0

    :goto_2df
    if-ge v4, v2, :cond_30b

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->oppositeDimensionsTied()Z

    move-result v7

    if-eqz v7, :cond_308

    iget v7, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    invoke-static {v3, v7}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findGroup(Ljava/util/ArrayList;I)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    move-result-object v7

    iget v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    invoke-static {v3, v5}, Landroidx/constraintlayout/core/widgets/analyzer/Grouping;->findGroup(Ljava/util/ArrayList;I)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    move-result-object v5

    if-eqz v7, :cond_308

    if-eqz v5, :cond_308

    const/4 v8, 0x0

    invoke-virtual {v7, v8, v5}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->moveTo(ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    const/4 v8, 0x2

    invoke-virtual {v5, v8}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->setOrientation(I)V

    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_308
    add-int/lit8 v4, v4, 0x1

    goto :goto_2df

    :cond_30b
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x1

    if-gt v1, v2, :cond_314

    const/4 v1, 0x0

    return v1

    :cond_314
    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getHorizontalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v2, :cond_356

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    move-object v2, v6

    const/4 v12, 0x0

    :cond_322
    :goto_322
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_347

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getOrientation()I

    move-result v5

    const/4 v7, 0x1

    if-ne v5, v7, :cond_336

    goto :goto_322

    :cond_336
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->setAuthoritative(Z)V

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getSystem()Landroidx/constraintlayout/core/LinearSystem;

    move-result-object v7

    invoke-virtual {v4, v7, v5}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->measureWrap(Landroidx/constraintlayout/core/LinearSystem;I)I

    move-result v7

    if-le v7, v12, :cond_322

    move-object v2, v4

    move v12, v7

    goto :goto_322

    :cond_347
    if-eqz v2, :cond_356

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setHorizontalDimensionBehaviour(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)V

    invoke-virtual {v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setWidth(I)V

    const/4 v1, 0x1

    invoke-virtual {v2, v1}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->setAuthoritative(Z)V

    goto :goto_357

    :cond_356
    move-object v2, v6

    :goto_357
    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getVerticalDimensionBehaviour()Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    move-result-object v1

    sget-object v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne v1, v4, :cond_39b

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    move-object v3, v6

    const/4 v12, 0x0

    :cond_365
    :goto_365
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_38a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->getOrientation()I

    move-result v5

    if-nez v5, :cond_378

    goto :goto_365

    :cond_378
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->setAuthoritative(Z)V

    invoke-virtual/range {p0 .. p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->getSystem()Landroidx/constraintlayout/core/LinearSystem;

    move-result-object v7

    const/4 v8, 0x1

    invoke-virtual {v4, v7, v8}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->measureWrap(Landroidx/constraintlayout/core/LinearSystem;I)I

    move-result v7

    if-le v7, v12, :cond_365

    move-object v3, v4

    move v12, v7

    goto :goto_365

    :cond_38a
    const/4 v5, 0x0

    const/4 v8, 0x1

    if-eqz v3, :cond_39d

    sget-object v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setVerticalDimensionBehaviour(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)V

    invoke-virtual {v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->setHeight(I)V

    invoke-virtual {v3, v8}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->setAuthoritative(Z)V

    move-object v4, v3

    goto :goto_39e

    :cond_39b
    const/4 v5, 0x0

    const/4 v8, 0x1

    :cond_39d
    move-object v4, v6

    :goto_39e
    if-nez v2, :cond_3a5

    if-eqz v4, :cond_3a3

    goto :goto_3a5

    :cond_3a3
    move v3, v5

    goto :goto_3a6

    :cond_3a5
    :goto_3a5
    move v3, v8

    :goto_3a6
    return v3
.end method

.method public static validInGroup(Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;)Z
    .registers 7

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eq p2, v0, :cond_15

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq p2, v0, :cond_15

    sget-object v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p2, v0, :cond_13

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq p0, p2, :cond_13

    goto :goto_15

    :cond_13
    move p0, v1

    goto :goto_16

    :cond_15
    :goto_15
    move p0, v2

    :goto_16
    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->FIXED:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq p3, p2, :cond_29

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq p3, p2, :cond_29

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->MATCH_PARENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-ne p3, p2, :cond_27

    sget-object p2, Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;->WRAP_CONTENT:Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;

    if-eq p1, p2, :cond_27

    goto :goto_29

    :cond_27
    move p1, v1

    goto :goto_2a

    :cond_29
    :goto_29
    move p1, v2

    :goto_2a
    if-nez p0, :cond_30

    if-eqz p1, :cond_2f

    goto :goto_30

    :cond_2f
    return v1

    :cond_30
    :goto_30
    return v2
.end method
