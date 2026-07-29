.class public Landroidx/constraintlayout/core/state/State;
.super Ljava/lang/Object;
.source "State.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/core/state/State$Chain;,
        Landroidx/constraintlayout/core/state/State$Helper;,
        Landroidx/constraintlayout/core/state/State$Direction;,
        Landroidx/constraintlayout/core/state/State$Constraint;
    }
.end annotation


# static fields
.field static final CONSTRAINT_RATIO:I = 0x2

.field static final CONSTRAINT_SPREAD:I = 0x0

.field static final CONSTRAINT_WRAP:I = 0x1

.field public static final PARENT:Ljava/lang/Integer;

.field static final UNKNOWN:I = -0x1


# instance fields
.field protected mHelperReferences:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/Object;",
            "Landroidx/constraintlayout/core/state/HelperReference;",
            ">;"
        }
    .end annotation
.end field

.field public final mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

.field protected mReferences:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/Object;",
            "Landroidx/constraintlayout/core/state/Reference;",
            ">;"
        }
    .end annotation
.end field

.field mTags:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private numHelpers:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Landroidx/constraintlayout/core/state/State;->PARENT:Ljava/lang/Integer;

    return-void
.end method

.method public constructor <init>()V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    new-instance v0, Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/state/ConstraintReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    iput-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    const/4 v1, 0x0

    iput v1, p0, Landroidx/constraintlayout/core/state/State;->numHelpers:I

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    sget-object v2, Landroidx/constraintlayout/core/state/State;->PARENT:Ljava/lang/Integer;

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private createHelperKey()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "__HELPER_KEY_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Landroidx/constraintlayout/core/state/State;->numHelpers:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Landroidx/constraintlayout/core/state/State;->numHelpers:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "__"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public apply(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V
    .registers 9

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->removeAllChildren()V

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getWidth()Landroidx/constraintlayout/core/state/Dimension;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p0, p1, v1}, Landroidx/constraintlayout/core/state/Dimension;->apply(Landroidx/constraintlayout/core/state/State;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getHeight()Landroidx/constraintlayout/core/state/Dimension;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, p0, p1, v1}, Landroidx/constraintlayout/core/state/Dimension;->apply(Landroidx/constraintlayout/core/state/State;Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_21
    :goto_21
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/state/HelperReference;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/state/HelperReference;->getHelperWidget()Landroidx/constraintlayout/core/widgets/HelperWidget;

    move-result-object v2

    if-eqz v2, :cond_21

    iget-object v3, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/state/Reference;

    if-nez v3, :cond_47

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v3

    :cond_47
    invoke-interface {v3, v2}, Landroidx/constraintlayout/core/state/Reference;->setConstraintWidget(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_21

    :cond_4b
    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_55
    :goto_55
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_91

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/state/Reference;

    iget-object v3, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eq v2, v3, :cond_55

    invoke-interface {v2}, Landroidx/constraintlayout/core/state/Reference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v3

    instance-of v3, v3, Landroidx/constraintlayout/core/state/HelperReference;

    if-eqz v3, :cond_55

    invoke-interface {v2}, Landroidx/constraintlayout/core/state/Reference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/state/HelperReference;

    invoke-virtual {v2}, Landroidx/constraintlayout/core/state/HelperReference;->getHelperWidget()Landroidx/constraintlayout/core/widgets/HelperWidget;

    move-result-object v2

    if-eqz v2, :cond_55

    iget-object v3, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/constraintlayout/core/state/Reference;

    if-nez v3, :cond_8d

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v3

    :cond_8d
    invoke-interface {v3, v2}, Landroidx/constraintlayout/core/state/Reference;->setConstraintWidget(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_55

    :cond_91
    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_9b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_d7

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    iget-object v2, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/state/Reference;

    iget-object v2, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eq v1, v2, :cond_d3

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->getConstraintWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v2

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setDebugName(Ljava/lang/String;)V

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setParent(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v3

    instance-of v3, v3, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    if-eqz v3, :cond_cf

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->apply()V

    :cond_cf
    invoke-virtual {p1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_9b

    :cond_d3
    invoke-interface {v1, p1}, Landroidx/constraintlayout/core/state/Reference;->setConstraintWidget(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_9b

    :cond_d7
    iget-object p1, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {p1}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_e1
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_125

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/HelperReference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/HelperReference;->getHelperWidget()Landroidx/constraintlayout/core/widgets/HelperWidget;

    move-result-object v1

    if-eqz v1, :cond_121

    iget-object v1, v0, Landroidx/constraintlayout/core/state/HelperReference;->mReferences:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_ff
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_11d

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v3, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/core/state/Reference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/HelperReference;->getHelperWidget()Landroidx/constraintlayout/core/widgets/HelperWidget;

    move-result-object v3

    invoke-interface {v2}, Landroidx/constraintlayout/core/state/Reference;->getConstraintWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v2

    invoke-virtual {v3, v2}, Landroidx/constraintlayout/core/widgets/HelperWidget;->add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_ff

    :cond_11d
    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/HelperReference;->apply()V

    goto :goto_e1

    :cond_121
    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/HelperReference;->apply()V

    goto :goto_e1

    :cond_125
    iget-object p1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {p1}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_12f
    :goto_12f
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1a2

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/Reference;

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eq v0, v1, :cond_12f

    invoke-interface {v0}, Landroidx/constraintlayout/core/state/Reference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v1

    instance-of v1, v1, Landroidx/constraintlayout/core/state/HelperReference;

    if-eqz v1, :cond_12f

    invoke-interface {v0}, Landroidx/constraintlayout/core/state/Reference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/state/HelperReference;

    invoke-virtual {v1}, Landroidx/constraintlayout/core/state/HelperReference;->getHelperWidget()Landroidx/constraintlayout/core/widgets/HelperWidget;

    move-result-object v2

    if-eqz v2, :cond_12f

    iget-object v1, v1, Landroidx/constraintlayout/core/state/HelperReference;->mReferences:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_15f
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_19e

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    iget-object v4, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v4, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/constraintlayout/core/state/Reference;

    if-eqz v4, :cond_17b

    invoke-interface {v4}, Landroidx/constraintlayout/core/state/Reference;->getConstraintWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/HelperWidget;->add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_15f

    :cond_17b
    instance-of v4, v3, Landroidx/constraintlayout/core/state/Reference;

    if-eqz v4, :cond_189

    check-cast v3, Landroidx/constraintlayout/core/state/Reference;

    invoke-interface {v3}, Landroidx/constraintlayout/core/state/Reference;->getConstraintWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/core/widgets/HelperWidget;->add(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    goto :goto_15f

    :cond_189
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "couldn\'t find reference for "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_15f

    :cond_19e
    invoke-interface {v0}, Landroidx/constraintlayout/core/state/Reference;->apply()V

    goto :goto_12f

    :cond_1a2
    iget-object p1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {p1}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_1ac
    :goto_1ac
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1d0

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/core/state/Reference;

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->apply()V

    invoke-interface {v1}, Landroidx/constraintlayout/core/state/Reference;->getConstraintWidget()Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-result-object v1

    if-eqz v1, :cond_1ac

    if-eqz v0, :cond_1ac

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->stringId:Ljava/lang/String;

    goto :goto_1ac

    :cond_1d0
    return-void
.end method

.method public barrier(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Direction;)Landroidx/constraintlayout/core/state/helpers/BarrierReference;
    .registers 4

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v0

    if-eqz v0, :cond_12

    invoke-virtual {p1}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v0

    instance-of v0, v0, Landroidx/constraintlayout/core/state/helpers/BarrierReference;

    if-nez v0, :cond_1d

    :cond_12
    new-instance v0, Landroidx/constraintlayout/core/state/helpers/BarrierReference;

    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/state/helpers/BarrierReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/state/helpers/BarrierReference;->setBarrierDirection(Landroidx/constraintlayout/core/state/State$Direction;)V

    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->setFacade(Landroidx/constraintlayout/core/state/helpers/Facade;)V

    :cond_1d
    invoke-virtual {p1}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/core/state/helpers/BarrierReference;

    return-object p1
.end method

.method public varargs centerHorizontally([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/AlignHorizontallyReference;
    .registers 4

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->ALIGN_HORIZONTALLY:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/AlignHorizontallyReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/helpers/AlignHorizontallyReference;->add([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/HelperReference;

    return-object v0
.end method

.method public varargs centerVertically([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/AlignVerticallyReference;
    .registers 4

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->ALIGN_VERTICALLY:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/AlignVerticallyReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/helpers/AlignVerticallyReference;->add([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/HelperReference;

    return-object v0
.end method

.method public constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/Reference;

    if-nez v0, :cond_16

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->createConstraintReference(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v0

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface {v0, p1}, Landroidx/constraintlayout/core/state/Reference;->setKey(Ljava/lang/Object;)V

    :cond_16
    instance-of p1, v0, Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eqz p1, :cond_1d

    check-cast v0, Landroidx/constraintlayout/core/state/ConstraintReference;

    return-object v0

    :cond_1d
    const/4 p1, 0x0

    return-object p1
.end method

.method public convertDimension(Ljava/lang/Object;)I
    .registers 3

    instance-of v0, p1, Ljava/lang/Float;

    if-eqz v0, :cond_b

    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->intValue()I

    move-result p1

    return p1

    :cond_b
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_16

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    return p1

    :cond_16
    const/4 p1, 0x0

    return p1
.end method

.method public createConstraintReference(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;
    .registers 2

    new-instance p1, Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-direct {p1, p0}, Landroidx/constraintlayout/core/state/ConstraintReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    return-object p1
.end method

.method public directMapping()V
    .registers 5

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_24

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v2

    instance-of v3, v2, Landroidx/constraintlayout/core/state/ConstraintReference;

    if-nez v3, :cond_1d

    goto :goto_a

    :cond_1d
    move-object v3, v2

    check-cast v3, Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v2, v1}, Landroidx/constraintlayout/core/state/ConstraintReference;->setView(Ljava/lang/Object;)V

    goto :goto_a

    :cond_24
    return-void
.end method

.method public getIdsForTag(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/ArrayList;

    return-object p1

    :cond_11
    const/4 p1, 0x0

    return-object p1
.end method

.method public guideline(Ljava/lang/Object;I)Landroidx/constraintlayout/core/state/helpers/GuidelineReference;
    .registers 5

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v1

    if-eqz v1, :cond_12

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object v1

    instance-of v1, v1, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    if-nez v1, :cond_20

    :cond_12
    new-instance v1, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    invoke-direct {v1, p0}, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    invoke-virtual {v1, p2}, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;->setOrientation(I)V

    invoke-virtual {v1, p1}, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;->setKey(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/core/state/ConstraintReference;->setFacade(Landroidx/constraintlayout/core/state/helpers/Facade;)V

    :cond_20
    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getFacade()Landroidx/constraintlayout/core/state/helpers/Facade;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    return-object p1
.end method

.method public height(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;
    .registers 2

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->setHeight(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;

    move-result-object p1

    return-object p1
.end method

.method public helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;
    .registers 5

    if-nez p1, :cond_6

    invoke-direct {p0}, Landroidx/constraintlayout/core/state/State;->createHelperKey()Ljava/lang/String;

    move-result-object p1

    :cond_6
    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/HelperReference;

    if-nez v0, :cond_53

    sget-object v0, Landroidx/constraintlayout/core/state/State$1;->$SwitchMap$androidx$constraintlayout$core$state$State$Helper:[I

    invoke-virtual {p2}, Landroidx/constraintlayout/core/state/State$Helper;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_45

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3f

    const/4 v1, 0x3

    if-eq v0, v1, :cond_39

    const/4 v1, 0x4

    if-eq v0, v1, :cond_33

    const/4 v1, 0x5

    if-eq v0, v1, :cond_2d

    new-instance v0, Landroidx/constraintlayout/core/state/HelperReference;

    invoke-direct {v0, p0, p2}, Landroidx/constraintlayout/core/state/HelperReference;-><init>(Landroidx/constraintlayout/core/state/State;Landroidx/constraintlayout/core/state/State$Helper;)V

    goto :goto_4b

    :cond_2d
    new-instance p2, Landroidx/constraintlayout/core/state/helpers/BarrierReference;

    invoke-direct {p2, p0}, Landroidx/constraintlayout/core/state/helpers/BarrierReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    goto :goto_4a

    :cond_33
    new-instance p2, Landroidx/constraintlayout/core/state/helpers/AlignVerticallyReference;

    invoke-direct {p2, p0}, Landroidx/constraintlayout/core/state/helpers/AlignVerticallyReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    goto :goto_4a

    :cond_39
    new-instance p2, Landroidx/constraintlayout/core/state/helpers/AlignHorizontallyReference;

    invoke-direct {p2, p0}, Landroidx/constraintlayout/core/state/helpers/AlignHorizontallyReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    goto :goto_4a

    :cond_3f
    new-instance p2, Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;

    invoke-direct {p2, p0}, Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    goto :goto_4a

    :cond_45
    new-instance p2, Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;

    invoke-direct {p2, p0}, Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;-><init>(Landroidx/constraintlayout/core/state/State;)V

    :goto_4a
    move-object v0, p2

    :goto_4b
    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/HelperReference;->setKey(Ljava/lang/Object;)V

    iget-object p2, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {p2, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_53
    return-object v0
.end method

.method public horizontalChain()Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;
    .registers 3

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->HORIZONTAL_CHAIN:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;

    return-object v0
.end method

.method public varargs horizontalChain([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;
    .registers 4

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->HORIZONTAL_CHAIN:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/helpers/HorizontalChainReference;->add([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/HelperReference;

    return-object v0
.end method

.method public horizontalGuideline(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/GuidelineReference;
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroidx/constraintlayout/core/state/State;->guideline(Ljava/lang/Object;I)Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    move-result-object p1

    return-object p1
.end method

.method public map(Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 4

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object p1

    instance-of v0, p1, Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eqz v0, :cond_e

    move-object v0, p1

    check-cast v0, Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/core/state/ConstraintReference;->setView(Ljava/lang/Object;)V

    :cond_e
    return-void
.end method

.method reference(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/Reference;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mReferences:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/core/state/Reference;

    return-object p1
.end method

.method public reset()V
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mHelperReferences:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    return-void
.end method

.method public sameFixedHeight(I)Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getHeight()Landroidx/constraintlayout/core/state/Dimension;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/Dimension;->equalsFixedValue(I)Z

    move-result p1

    return p1
.end method

.method public sameFixedWidth(I)Z
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0}, Landroidx/constraintlayout/core/state/ConstraintReference;->getWidth()Landroidx/constraintlayout/core/state/Dimension;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/Dimension;->equalsFixedValue(I)Z

    move-result p1

    return p1
.end method

.method public setHeight(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/ConstraintReference;->setHeight(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/ConstraintReference;

    return-object p0
.end method

.method public setTag(Ljava/lang/String;Ljava/lang/String;)V
    .registers 5

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->constraints(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/ConstraintReference;

    move-result-object v0

    instance-of v1, v0, Landroidx/constraintlayout/core/state/ConstraintReference;

    if-eqz v1, :cond_2d

    move-object v1, v0

    check-cast v1, Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/state/ConstraintReference;->setTag(Ljava/lang/String;)V

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v1, p2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2a

    :cond_21
    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mTags:Ljava/util/HashMap;

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    move-object v0, p2

    check-cast v0, Ljava/util/ArrayList;

    :goto_2a
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_2d
    return-void
.end method

.method public setWidth(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;
    .registers 3

    iget-object v0, p0, Landroidx/constraintlayout/core/state/State;->mParent:Landroidx/constraintlayout/core/state/ConstraintReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/ConstraintReference;->setWidth(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/ConstraintReference;

    return-object p0
.end method

.method public verticalChain()Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;
    .registers 3

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->VERTICAL_CHAIN:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;

    return-object v0
.end method

.method public varargs verticalChain([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;
    .registers 4

    const/4 v0, 0x0

    sget-object v1, Landroidx/constraintlayout/core/state/State$Helper;->VERTICAL_CHAIN:Landroidx/constraintlayout/core/state/State$Helper;

    invoke-virtual {p0, v0, v1}, Landroidx/constraintlayout/core/state/State;->helper(Ljava/lang/Object;Landroidx/constraintlayout/core/state/State$Helper;)Landroidx/constraintlayout/core/state/HelperReference;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/state/helpers/VerticalChainReference;->add([Ljava/lang/Object;)Landroidx/constraintlayout/core/state/HelperReference;

    return-object v0
.end method

.method public verticalGuideline(Ljava/lang/Object;)Landroidx/constraintlayout/core/state/helpers/GuidelineReference;
    .registers 3

    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroidx/constraintlayout/core/state/State;->guideline(Ljava/lang/Object;I)Landroidx/constraintlayout/core/state/helpers/GuidelineReference;

    move-result-object p1

    return-object p1
.end method

.method public width(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;
    .registers 2

    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/state/State;->setWidth(Landroidx/constraintlayout/core/state/Dimension;)Landroidx/constraintlayout/core/state/State;

    move-result-object p1

    return-object p1
.end method
