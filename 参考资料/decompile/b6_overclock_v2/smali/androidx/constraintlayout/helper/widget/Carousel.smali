.class public Landroidx/constraintlayout/helper/widget/Carousel;
.super Landroidx/constraintlayout/motion/widget/MotionHelper;
.source "Carousel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/helper/widget/Carousel$Adapter;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "Carousel"

.field public static final TOUCH_UP_CARRY_ON:I = 0x2

.field public static final TOUCH_UP_IMMEDIATE_STOP:I = 0x1


# instance fields
.field private backwardTransition:I

.field private dampening:F

.field private emptyViewBehavior:I

.field private firstViewReference:I

.field private forwardTransition:I

.field private infiniteCarousel:Z

.field private mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

.field private mAnimateTargetDelay:I

.field private mIndex:I

.field mLastStartId:I

.field private final mList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

.field private mPreviousIndex:I

.field private mTargetIndex:I

.field mUpdateRunnable:Ljava/lang/Runnable;

.field private nextState:I

.field private previousState:I

.field private startIndex:I

.field private touchUpMode:I

.field private velocityThreshold:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "context"
        }
    .end annotation

    invoke-direct {p0, p1}, Landroidx/constraintlayout/motion/widget/MotionHelper;-><init>(Landroid/content/Context;)V

    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    iput-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    const/4 p1, 0x0

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    const/4 v0, -0x1

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    iput-boolean p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    const v1, 0x3f666666    # 0.9f

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->startIndex:I

    const/4 p1, 0x4

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    const/4 p1, 0x1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    const/high16 p1, 0x40000000    # 2.0f

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    const/16 p1, 0xc8

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mLastStartId:I

    new-instance p1, Landroidx/constraintlayout/helper/widget/Carousel$1;

    invoke-direct {p1, p0}, Landroidx/constraintlayout/helper/widget/Carousel$1;-><init>(Landroidx/constraintlayout/helper/widget/Carousel;)V

    iput-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mUpdateRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "context",
            "attrs"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Landroidx/constraintlayout/motion/widget/MotionHelper;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    const/4 v1, -0x1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    iput-boolean v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    const v2, 0x3f666666    # 0.9f

    iput v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->startIndex:I

    const/4 v0, 0x4

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    const/4 v0, 0x1

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    const/high16 v0, 0x40000000    # 2.0f

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    const/16 v0, 0xc8

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mLastStartId:I

    new-instance v0, Landroidx/constraintlayout/helper/widget/Carousel$1;

    invoke-direct {v0, p0}, Landroidx/constraintlayout/helper/widget/Carousel$1;-><init>(Landroidx/constraintlayout/helper/widget/Carousel;)V

    iput-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mUpdateRunnable:Ljava/lang/Runnable;

    invoke-direct {p0, p1, p2}, Landroidx/constraintlayout/helper/widget/Carousel;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "context",
            "attrs",
            "defStyleAttr"
        }
    .end annotation

    invoke-direct {p0, p1, p2, p3}, Landroidx/constraintlayout/motion/widget/MotionHelper;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const/4 p3, 0x0

    iput-object p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3}, Ljava/util/ArrayList;-><init>()V

    iput-object p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    const/4 p3, 0x0

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    const/4 v0, -0x1

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    iput-boolean p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    const v1, 0x3f666666    # 0.9f

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->startIndex:I

    const/4 p3, 0x4

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    const/4 p3, 0x1

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    const/high16 p3, 0x40000000    # 2.0f

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    const/16 p3, 0xc8

    iput p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mLastStartId:I

    new-instance p3, Landroidx/constraintlayout/helper/widget/Carousel$1;

    invoke-direct {p3, p0}, Landroidx/constraintlayout/helper/widget/Carousel$1;-><init>(Landroidx/constraintlayout/helper/widget/Carousel;)V

    iput-object p3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mUpdateRunnable:Ljava/lang/Runnable;

    invoke-direct {p0, p1, p2}, Landroidx/constraintlayout/helper/widget/Carousel;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method static synthetic access$000(Landroidx/constraintlayout/helper/widget/Carousel;)Landroidx/constraintlayout/motion/widget/MotionLayout;
    .registers 1

    iget-object p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    return-object p0
.end method

.method static synthetic access$100(Landroidx/constraintlayout/helper/widget/Carousel;)V
    .registers 1

    invoke-direct {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->updateItems()V

    return-void
.end method

.method static synthetic access$200(Landroidx/constraintlayout/helper/widget/Carousel;)I
    .registers 1

    iget p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    return p0
.end method

.method static synthetic access$300(Landroidx/constraintlayout/helper/widget/Carousel;)Landroidx/constraintlayout/helper/widget/Carousel$Adapter;
    .registers 1

    iget-object p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    return-object p0
.end method

.method static synthetic access$400(Landroidx/constraintlayout/helper/widget/Carousel;)I
    .registers 1

    iget p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    return p0
.end method

.method static synthetic access$500(Landroidx/constraintlayout/helper/widget/Carousel;)F
    .registers 1

    iget p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    return p0
.end method

.method static synthetic access$600(Landroidx/constraintlayout/helper/widget/Carousel;)F
    .registers 1

    iget p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    return p0
.end method

.method static synthetic access$700(Landroidx/constraintlayout/helper/widget/Carousel;)I
    .registers 1

    iget p0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    return p0
.end method

.method private enableAllTransitions(Z)V
    .registers 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "enable"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    invoke-virtual {v0}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getDefinedTransitions()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;

    invoke-virtual {v1, p1}, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;->setEnabled(Z)V

    goto :goto_a

    :cond_1a
    return-void
.end method

.method private enableTransition(IZ)Z
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "transitionID",
            "enable"
        }
    .end annotation

    const/4 v0, -0x1

    const/4 v1, 0x0

    if-ne p1, v0, :cond_5

    return v1

    :cond_5
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    if-nez v0, :cond_a

    return v1

    :cond_a
    invoke-virtual {v0, p1}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getTransition(I)Landroidx/constraintlayout/motion/widget/MotionScene$Transition;

    move-result-object p1

    if-nez p1, :cond_11

    return v1

    :cond_11
    invoke-virtual {p1}, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;->isEnabled()Z

    move-result v0

    if-ne p2, v0, :cond_18

    return v1

    :cond_18
    invoke-virtual {p1, p2}, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;->setEnabled(Z)V

    const/4 p1, 0x1

    return p1
.end method

.method private init(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "context",
            "attrs"
        }
    .end annotation

    if-eqz p2, :cond_9d

    sget-object v0, Landroidx/constraintlayout/widget/R$styleable;->Carousel:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/TypedArray;->getIndexCount()I

    move-result p2

    const/4 v0, 0x0

    :goto_d
    if-ge v0, p2, :cond_9a

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->getIndex(I)I

    move-result v1

    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_firstView:I

    if-ne v1, v2, :cond_21

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    goto/16 :goto_96

    :cond_21
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_backwardTransition:I

    if-ne v1, v2, :cond_2f

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    goto/16 :goto_96

    :cond_2f
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_forwardTransition:I

    if-ne v1, v2, :cond_3c

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    goto :goto_96

    :cond_3c
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_emptyViewsBehavior:I

    if-ne v1, v2, :cond_49

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    goto :goto_96

    :cond_49
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_previousState:I

    if-ne v1, v2, :cond_56

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    goto :goto_96

    :cond_56
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_nextState:I

    if-ne v1, v2, :cond_63

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    goto :goto_96

    :cond_63
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_touchUp_dampeningFactor:I

    if-ne v1, v2, :cond_70

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->dampening:F

    goto :goto_96

    :cond_70
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_touchUpMode:I

    if-ne v1, v2, :cond_7d

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    goto :goto_96

    :cond_7d
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_touchUp_velocityThreshold:I

    if-ne v1, v2, :cond_8a

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->velocityThreshold:F

    goto :goto_96

    :cond_8a
    sget v2, Landroidx/constraintlayout/widget/R$styleable;->Carousel_carousel_infinite:I

    if-ne v1, v2, :cond_96

    iget-boolean v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    :cond_96
    :goto_96
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_d

    :cond_9a
    invoke-virtual {p1}, Landroid/content/res/TypedArray;->recycle()V

    :cond_9d
    return-void
.end method

.method private updateItems()V
    .registers 9

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    if-nez v1, :cond_a

    return-void

    :cond_a
    invoke-interface {v0}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v0

    if-nez v0, :cond_11

    return-void

    :cond_11
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_19
    if-ge v2, v0, :cond_bb

    iget-object v3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    add-int/2addr v4, v2

    iget v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->startIndex:I

    sub-int/2addr v4, v5

    iget-boolean v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    if-eqz v5, :cond_99

    const/4 v5, 0x4

    if-gez v4, :cond_5e

    iget v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    if-eq v6, v5, :cond_38

    invoke-direct {p0, v3, v6}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    goto :goto_3b

    :cond_38
    invoke-direct {p0, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    :goto_3b
    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v5

    rem-int v5, v4, v5

    if-nez v5, :cond_4c

    iget-object v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v4, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->populate(Landroid/view/View;I)V

    goto/16 :goto_b7

    :cond_4c
    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v6

    iget-object v7, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v7}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v7

    rem-int/2addr v4, v7

    add-int/2addr v6, v4

    invoke-interface {v5, v3, v6}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->populate(Landroid/view/View;I)V

    goto :goto_b7

    :cond_5e
    iget-object v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v6}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v6

    if-lt v4, v6, :cond_90

    iget-object v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v6}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v6

    if-ne v4, v6, :cond_70

    move v4, v1

    goto :goto_7f

    :cond_70
    iget-object v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v6}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v6

    if-le v4, v6, :cond_7f

    iget-object v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v6}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v6

    rem-int/2addr v4, v6

    :cond_7f
    :goto_7f
    iget v6, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    if-eq v6, v5, :cond_87

    invoke-direct {p0, v3, v6}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    goto :goto_8a

    :cond_87
    invoke-direct {p0, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    :goto_8a
    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->populate(Landroid/view/View;I)V

    goto :goto_b7

    :cond_90
    invoke-direct {p0, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->populate(Landroid/view/View;I)V

    goto :goto_b7

    :cond_99
    if-gez v4, :cond_a1

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    invoke-direct {p0, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    goto :goto_b7

    :cond_a1
    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v5

    if-lt v4, v5, :cond_af

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    invoke-direct {p0, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    goto :goto_b7

    :cond_af
    invoke-direct {p0, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    iget-object v5, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v5, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->populate(Landroid/view/View;I)V

    :goto_b7
    add-int/lit8 v2, v2, 0x1

    goto/16 :goto_19

    :cond_bb
    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    const/4 v2, -0x1

    if-eq v0, v2, :cond_cf

    iget v3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-eq v0, v3, :cond_cf

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    new-instance v3, Landroidx/constraintlayout/helper/widget/Carousel$$ExternalSyntheticLambda0;

    invoke-direct {v3, p0}, Landroidx/constraintlayout/helper/widget/Carousel$$ExternalSyntheticLambda0;-><init>(Landroidx/constraintlayout/helper/widget/Carousel;)V

    invoke-virtual {v0, v3}, Landroidx/constraintlayout/motion/widget/MotionLayout;->post(Ljava/lang/Runnable;)Z

    goto :goto_d5

    :cond_cf
    iget v3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-ne v0, v3, :cond_d5

    iput v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    :cond_d5
    :goto_d5
    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    if-eq v0, v2, :cond_118

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    if-ne v0, v2, :cond_de

    goto :goto_118

    :cond_de
    iget-boolean v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    if-eqz v0, :cond_e3

    return-void

    :cond_e3
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v0}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v0

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    const/4 v3, 0x1

    if-nez v2, :cond_f4

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    invoke-direct {p0, v2, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->enableTransition(IZ)Z

    goto :goto_100

    :cond_f4
    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    invoke-direct {p0, v2, v3}, Landroidx/constraintlayout/helper/widget/Carousel;->enableTransition(IZ)Z

    iget-object v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    invoke-virtual {v2, v4}, Landroidx/constraintlayout/motion/widget/MotionLayout;->setTransition(I)V

    :goto_100
    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    sub-int/2addr v0, v3

    if-ne v2, v0, :cond_10b

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    invoke-direct {p0, v0, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->enableTransition(IZ)Z

    goto :goto_117

    :cond_10b
    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    invoke-direct {p0, v0, v3}, Landroidx/constraintlayout/helper/widget/Carousel;->enableTransition(IZ)Z

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/motion/widget/MotionLayout;->setTransition(I)V

    :goto_117
    return-void

    :cond_118
    :goto_118
    const-string v0, "Carousel"

    const-string v1, "No backward or forward transitions defined for Carousel!"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method private updateViewVisibility(ILandroid/view/View;I)Z
    .registers 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "constraintSetId",
            "view",
            "visibility"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    invoke-virtual {v0, p1}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getConstraintSet(I)Landroidx/constraintlayout/widget/ConstraintSet;

    move-result-object p1

    const/4 v0, 0x0

    if-nez p1, :cond_a

    return v0

    :cond_a
    invoke-virtual {p2}, Landroid/view/View;->getId()I

    move-result v1

    invoke-virtual {p1, v1}, Landroidx/constraintlayout/widget/ConstraintSet;->getConstraint(I)Landroidx/constraintlayout/widget/ConstraintSet$Constraint;

    move-result-object p1

    if-nez p1, :cond_15

    return v0

    :cond_15
    iget-object p1, p1, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->propertySet:Landroidx/constraintlayout/widget/ConstraintSet$PropertySet;

    const/4 v0, 0x1

    iput v0, p1, Landroidx/constraintlayout/widget/ConstraintSet$PropertySet;->mVisibilityMode:I

    invoke-virtual {p2, p3}, Landroid/view/View;->setVisibility(I)V

    return v0
.end method

.method private updateViewVisibility(Landroid/view/View;I)Z
    .registers 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "view",
            "visibility"
        }
    .end annotation

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    invoke-virtual {v0}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getConstraintSetIds()[I

    move-result-object v0

    move v2, v1

    :goto_b
    array-length v3, v0

    if-ge v1, v3, :cond_18

    aget v3, v0, v1

    invoke-direct {p0, v3, p1, p2}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(ILandroid/view/View;I)Z

    move-result v3

    or-int/2addr v2, v3

    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    :cond_18
    return v2
.end method


# virtual methods
.method public getCount()I
    .registers 2

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    if-eqz v0, :cond_9

    invoke-interface {v0}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v0

    return v0

    :cond_9
    const/4 v0, 0x0

    return v0
.end method

.method public getCurrentIndex()I
    .registers 2

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    return v0
.end method

.method public jumpToIndex(I)V
    .registers 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "index"
        }
    .end annotation

    invoke-virtual {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-static {v0, p1}, Ljava/lang/Math;->min(II)I

    move-result p1

    const/4 v0, 0x0

    invoke-static {v0, p1}, Ljava/lang/Math;->max(II)I

    move-result p1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    invoke-virtual {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->refresh()V

    return-void
.end method

.method synthetic lambda$updateItems$0$androidx-constraintlayout-helper-widget-Carousel()V
    .registers 4

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/motion/widget/MotionLayout;->setTransitionDuration(I)V

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-ge v0, v1, :cond_17

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    invoke-virtual {v0, v1, v2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->transitionToState(II)V

    goto :goto_20

    :cond_17
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    invoke-virtual {v0, v1, v2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->transitionToState(II)V

    :goto_20
    return-void
.end method

.method protected onAttachedToWindow()V
    .registers 6

    invoke-super {p0}, Landroidx/constraintlayout/motion/widget/MotionHelper;->onAttachedToWindow()V

    invoke-virtual {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    instance-of v0, v0, Landroidx/constraintlayout/motion/widget/MotionLayout;

    if-eqz v0, :cond_4f

    invoke-virtual {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/motion/widget/MotionLayout;

    const/4 v1, 0x0

    :goto_12
    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mCount:I

    if-ge v1, v2, :cond_2c

    iget-object v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIds:[I

    aget v2, v2, v1

    invoke-virtual {v0, v2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getViewById(I)Landroid/view/View;

    move-result-object v3

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->firstViewReference:I

    if-ne v4, v2, :cond_24

    iput v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->startIndex:I

    :cond_24
    iget-object v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_12

    :cond_2c
    iput-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->touchUpMode:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_4c

    iget v1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->forwardTransition:I

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getTransition(I)Landroidx/constraintlayout/motion/widget/MotionScene$Transition;

    move-result-object v0

    const/4 v1, 0x5

    if-eqz v0, :cond_3f

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;->setOnTouchUp(I)V

    :cond_3f
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget v2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->backwardTransition:I

    invoke-virtual {v0, v2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->getTransition(I)Landroidx/constraintlayout/motion/widget/MotionScene$Transition;

    move-result-object v0

    if-eqz v0, :cond_4c

    invoke-virtual {v0, v1}, Landroidx/constraintlayout/motion/widget/MotionScene$Transition;->setOnTouchUp(I)V

    :cond_4c
    invoke-direct {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->updateItems()V

    :cond_4f
    return-void
.end method

.method public onTransitionChange(Landroidx/constraintlayout/motion/widget/MotionLayout;IIF)V
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "motionLayout",
            "startId",
            "endId",
            "progress"
        }
    .end annotation

    iput p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mLastStartId:I

    return-void
.end method

.method public onTransitionCompleted(Landroidx/constraintlayout/motion/widget/MotionLayout;I)V
    .registers 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "motionLayout",
            "currentId"
        }
    .end annotation

    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    if-ne p2, v0, :cond_d

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    goto :goto_15

    :cond_d
    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    if-ne p2, v0, :cond_15

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    :cond_15
    :goto_15
    iget-boolean p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->infiniteCarousel:Z

    const/4 p2, 0x0

    if-eqz p1, :cond_35

    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v0}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v0

    if-lt p1, v0, :cond_26

    iput p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    :cond_26
    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-gez p1, :cond_4f

    iget-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {p1}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result p1

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    goto :goto_4f

    :cond_35
    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v0}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v0

    if-lt p1, v0, :cond_49

    iget-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {p1}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result p1

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    :cond_49
    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-gez p1, :cond_4f

    iput p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    :cond_4f
    :goto_4f
    iget p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mPreviousIndex:I

    iget p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-eq p1, p2, :cond_5c

    iget-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget-object p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mUpdateRunnable:Ljava/lang/Runnable;

    invoke-virtual {p1, p2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->post(Ljava/lang/Runnable;)Z

    :cond_5c
    return-void
.end method

.method public refresh()V
    .registers 6

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    move v2, v1

    :goto_8
    if-ge v2, v0, :cond_26

    iget-object v3, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mList:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/View;

    iget-object v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    invoke-interface {v4}, Landroidx/constraintlayout/helper/widget/Carousel$Adapter;->count()I

    move-result v4

    if-nez v4, :cond_20

    iget v4, p0, Landroidx/constraintlayout/helper/widget/Carousel;->emptyViewBehavior:I

    invoke-direct {p0, v3, v4}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    goto :goto_23

    :cond_20
    invoke-direct {p0, v3, v1}, Landroidx/constraintlayout/helper/widget/Carousel;->updateViewVisibility(Landroid/view/View;I)Z

    :goto_23
    add-int/lit8 v2, v2, 0x1

    goto :goto_8

    :cond_26
    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    invoke-virtual {v0}, Landroidx/constraintlayout/motion/widget/MotionLayout;->rebuildScene()V

    invoke-direct {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->updateItems()V

    return-void
.end method

.method public setAdapter(Landroidx/constraintlayout/helper/widget/Carousel$Adapter;)V
    .registers 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "adapter"
        }
    .end annotation

    iput-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAdapter:Landroidx/constraintlayout/helper/widget/Carousel$Adapter;

    return-void
.end method

.method public transitionToIndex(II)V
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "index",
            "delay"
        }
    .end annotation

    invoke-virtual {p0}, Landroidx/constraintlayout/helper/widget/Carousel;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-static {v0, p1}, Ljava/lang/Math;->min(II)I

    move-result v0

    const/4 v1, 0x0

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mTargetIndex:I

    invoke-static {v1, p2}, Ljava/lang/Math;->max(II)I

    move-result p2

    iput p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    iget-object v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    invoke-virtual {v0, p2}, Landroidx/constraintlayout/motion/widget/MotionLayout;->setTransitionDuration(I)V

    iget p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mIndex:I

    if-ge p1, p2, :cond_2a

    iget-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->previousState:I

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    invoke-virtual {p1, p2, v0}, Landroidx/constraintlayout/motion/widget/MotionLayout;->transitionToState(II)V

    goto :goto_33

    :cond_2a
    iget-object p1, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mMotionLayout:Landroidx/constraintlayout/motion/widget/MotionLayout;

    iget p2, p0, Landroidx/constraintlayout/helper/widget/Carousel;->nextState:I

    iget v0, p0, Landroidx/constraintlayout/helper/widget/Carousel;->mAnimateTargetDelay:I

    invoke-virtual {p1, p2, v0}, Landroidx/constraintlayout/motion/widget/MotionLayout;->transitionToState(II)V

    :goto_33
    return-void
.end method
