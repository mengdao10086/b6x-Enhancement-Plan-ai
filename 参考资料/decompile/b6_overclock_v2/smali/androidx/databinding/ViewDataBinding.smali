.class public abstract Landroidx/databinding/ViewDataBinding;
.super Landroidx/databinding/BaseObservable;
.source "ViewDataBinding.java"

# interfaces
.implements Landroidx/viewbinding/ViewBinding;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/databinding/ViewDataBinding$OnStartListener;,
        Landroidx/databinding/ViewDataBinding$PropertyChangedInverseListener;,
        Landroidx/databinding/ViewDataBinding$IncludedLayouts;,
        Landroidx/databinding/ViewDataBinding$LiveDataListener;,
        Landroidx/databinding/ViewDataBinding$WeakMapListener;,
        Landroidx/databinding/ViewDataBinding$WeakListListener;,
        Landroidx/databinding/ViewDataBinding$WeakPropertyListener;
    }
.end annotation


# static fields
.field private static final BINDING_NUMBER_START:I = 0x8

.field public static final BINDING_TAG_PREFIX:Ljava/lang/String; = "binding_"

.field private static final CREATE_LIST_LISTENER:Landroidx/databinding/CreateWeakListener;

.field private static final CREATE_LIVE_DATA_LISTENER:Landroidx/databinding/CreateWeakListener;

.field private static final CREATE_MAP_LISTENER:Landroidx/databinding/CreateWeakListener;

.field private static final CREATE_PROPERTY_LISTENER:Landroidx/databinding/CreateWeakListener;

.field private static final HALTED:I = 0x2

.field private static final REBIND:I = 0x1

.field private static final REBIND_NOTIFIER:Landroidx/databinding/CallbackRegistry$NotifierCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/databinding/CallbackRegistry$NotifierCallback<",
            "Landroidx/databinding/OnRebindCallback;",
            "Landroidx/databinding/ViewDataBinding;",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private static final REBOUND:I = 0x3

.field private static final ROOT_REATTACHED_LISTENER:Landroid/view/View$OnAttachStateChangeListener;

.field static SDK_INT:I

.field private static final USE_CHOREOGRAPHER:Z

.field private static final sReferenceQueue:Ljava/lang/ref/ReferenceQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/ReferenceQueue<",
            "Landroidx/databinding/ViewDataBinding;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected final mBindingComponent:Landroidx/databinding/DataBindingComponent;

.field private mChoreographer:Landroid/view/Choreographer;

.field private mContainingBinding:Landroidx/databinding/ViewDataBinding;

.field private final mFrameCallback:Landroid/view/Choreographer$FrameCallback;

.field private mInLiveDataRegisterObserver:Z

.field protected mInStateFlowRegisterObserver:Z

.field private mIsExecutingPendingBindings:Z

.field private mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

.field private mLocalFieldObservers:[Landroidx/databinding/WeakListener;

.field private mOnStartListener:Landroidx/databinding/ViewDataBinding$OnStartListener;

.field private mPendingRebind:Z

.field private mRebindCallbacks:Landroidx/databinding/CallbackRegistry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/databinding/CallbackRegistry<",
            "Landroidx/databinding/OnRebindCallback;",
            "Landroidx/databinding/ViewDataBinding;",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field private mRebindHalted:Z

.field private final mRebindRunnable:Ljava/lang/Runnable;

.field private final mRoot:Landroid/view/View;

.field private mUIThreadHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    sput v0, Landroidx/databinding/ViewDataBinding;->SDK_INT:I

    const/4 v0, 0x1

    sput-boolean v0, Landroidx/databinding/ViewDataBinding;->USE_CHOREOGRAPHER:Z

    new-instance v0, Landroidx/databinding/ViewDataBinding$1;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$1;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_PROPERTY_LISTENER:Landroidx/databinding/CreateWeakListener;

    new-instance v0, Landroidx/databinding/ViewDataBinding$2;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$2;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_LIST_LISTENER:Landroidx/databinding/CreateWeakListener;

    new-instance v0, Landroidx/databinding/ViewDataBinding$3;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$3;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_MAP_LISTENER:Landroidx/databinding/CreateWeakListener;

    new-instance v0, Landroidx/databinding/ViewDataBinding$4;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$4;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_LIVE_DATA_LISTENER:Landroidx/databinding/CreateWeakListener;

    new-instance v0, Landroidx/databinding/ViewDataBinding$5;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$5;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->REBIND_NOTIFIER:Landroidx/databinding/CallbackRegistry$NotifierCallback;

    new-instance v0, Ljava/lang/ref/ReferenceQueue;

    invoke-direct {v0}, Ljava/lang/ref/ReferenceQueue;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->sReferenceQueue:Ljava/lang/ref/ReferenceQueue;

    new-instance v0, Landroidx/databinding/ViewDataBinding$6;

    invoke-direct {v0}, Landroidx/databinding/ViewDataBinding$6;-><init>()V

    sput-object v0, Landroidx/databinding/ViewDataBinding;->ROOT_REATTACHED_LISTENER:Landroid/view/View$OnAttachStateChangeListener;

    return-void
.end method

.method protected constructor <init>(Landroidx/databinding/DataBindingComponent;Landroid/view/View;I)V
    .registers 5

    invoke-direct {p0}, Landroidx/databinding/BaseObservable;-><init>()V

    new-instance v0, Landroidx/databinding/ViewDataBinding$7;

    invoke-direct {v0, p0}, Landroidx/databinding/ViewDataBinding$7;-><init>(Landroidx/databinding/ViewDataBinding;)V

    iput-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindRunnable:Ljava/lang/Runnable;

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mPendingRebind:Z

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mBindingComponent:Landroidx/databinding/DataBindingComponent;

    new-array p1, p3, [Landroidx/databinding/WeakListener;

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    iput-object p2, p0, Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object p1

    if-eqz p1, :cond_3e

    sget-boolean p1, Landroidx/databinding/ViewDataBinding;->USE_CHOREOGRAPHER:Z

    if-eqz p1, :cond_2f

    invoke-static {}, Landroid/view/Choreographer;->getInstance()Landroid/view/Choreographer;

    move-result-object p1

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mChoreographer:Landroid/view/Choreographer;

    new-instance p1, Landroidx/databinding/ViewDataBinding$8;

    invoke-direct {p1, p0}, Landroidx/databinding/ViewDataBinding$8;-><init>(Landroidx/databinding/ViewDataBinding;)V

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mFrameCallback:Landroid/view/Choreographer$FrameCallback;

    goto :goto_3d

    :cond_2f
    const/4 p1, 0x0

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mFrameCallback:Landroid/view/Choreographer$FrameCallback;

    new-instance p1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object p2

    invoke-direct {p1, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mUIThreadHandler:Landroid/os/Handler;

    :goto_3d
    return-void

    :cond_3e
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "DataBinding must be created in view\'s UI Thread"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method protected constructor <init>(Ljava/lang/Object;Landroid/view/View;I)V
    .registers 4

    invoke-static {p1}, Landroidx/databinding/ViewDataBinding;->checkAndCastToBindingComponent(Ljava/lang/Object;)Landroidx/databinding/DataBindingComponent;

    move-result-object p1

    invoke-direct {p0, p1, p2, p3}, Landroidx/databinding/ViewDataBinding;-><init>(Landroidx/databinding/DataBindingComponent;Landroid/view/View;I)V

    return-void
.end method

.method static synthetic access$002(Landroidx/databinding/ViewDataBinding;Z)Z
    .registers 2

    iput-boolean p1, p0, Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z

    return p1
.end method

.method static synthetic access$100(Landroidx/databinding/ViewDataBinding;)Ljava/lang/Runnable;
    .registers 1

    iget-object p0, p0, Landroidx/databinding/ViewDataBinding;->mRebindRunnable:Ljava/lang/Runnable;

    return-object p0
.end method

.method static synthetic access$202(Landroidx/databinding/ViewDataBinding;Z)Z
    .registers 2

    iput-boolean p1, p0, Landroidx/databinding/ViewDataBinding;->mPendingRebind:Z

    return p1
.end method

.method static synthetic access$300()V
    .registers 0

    invoke-static {}, Landroidx/databinding/ViewDataBinding;->processReferenceQueue()V

    return-void
.end method

.method static synthetic access$400(Landroidx/databinding/ViewDataBinding;)Landroid/view/View;
    .registers 1

    iget-object p0, p0, Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;

    return-object p0
.end method

.method static synthetic access$500()Landroid/view/View$OnAttachStateChangeListener;
    .registers 1

    sget-object v0, Landroidx/databinding/ViewDataBinding;->ROOT_REATTACHED_LISTENER:Landroid/view/View$OnAttachStateChangeListener;

    return-object v0
.end method

.method protected static bind(Ljava/lang/Object;Landroid/view/View;I)Landroidx/databinding/ViewDataBinding;
    .registers 3

    invoke-static {p0}, Landroidx/databinding/ViewDataBinding;->checkAndCastToBindingComponent(Ljava/lang/Object;)Landroidx/databinding/DataBindingComponent;

    move-result-object p0

    invoke-static {p0, p1, p2}, Landroidx/databinding/DataBindingUtil;->bind(Landroidx/databinding/DataBindingComponent;Landroid/view/View;I)Landroidx/databinding/ViewDataBinding;

    move-result-object p0

    return-object p0
.end method

.method private static checkAndCastToBindingComponent(Ljava/lang/Object;)Landroidx/databinding/DataBindingComponent;
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    instance-of v0, p0, Landroidx/databinding/DataBindingComponent;

    if-eqz v0, :cond_b

    check-cast p0, Landroidx/databinding/DataBindingComponent;

    return-object p0

    :cond_b
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string v0, "The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent"

    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private executeBindingsInternal()V
    .registers 5

    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mIsExecutingPendingBindings:Z

    if-eqz v0, :cond_8

    invoke-virtual {p0}, Landroidx/databinding/ViewDataBinding;->requestRebind()V

    return-void

    :cond_8
    invoke-virtual {p0}, Landroidx/databinding/ViewDataBinding;->hasPendingBindings()Z

    move-result v0

    if-nez v0, :cond_f

    return-void

    :cond_f
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mIsExecutingPendingBindings:Z

    const/4 v1, 0x0

    iput-boolean v1, p0, Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z

    iget-object v2, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    const/4 v3, 0x0

    if-eqz v2, :cond_27

    invoke-virtual {v2, p0, v0, v3}, Landroidx/databinding/CallbackRegistry;->notifyCallbacks(Ljava/lang/Object;ILjava/lang/Object;)V

    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z

    if-eqz v0, :cond_27

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    const/4 v2, 0x2

    invoke-virtual {v0, p0, v2, v3}, Landroidx/databinding/CallbackRegistry;->notifyCallbacks(Ljava/lang/Object;ILjava/lang/Object;)V

    :cond_27
    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindHalted:Z

    if-nez v0, :cond_36

    invoke-virtual {p0}, Landroidx/databinding/ViewDataBinding;->executeBindings()V

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    if-eqz v0, :cond_36

    const/4 v2, 0x3

    invoke-virtual {v0, p0, v2, v3}, Landroidx/databinding/CallbackRegistry;->notifyCallbacks(Ljava/lang/Object;ILjava/lang/Object;)V

    :cond_36
    iput-boolean v1, p0, Landroidx/databinding/ViewDataBinding;->mIsExecutingPendingBindings:Z

    return-void
.end method

.method protected static executeBindingsOn(Landroidx/databinding/ViewDataBinding;)V
    .registers 1

    invoke-direct {p0}, Landroidx/databinding/ViewDataBinding;->executeBindingsInternal()V

    return-void
.end method

.method private static findIncludeIndex(Ljava/lang/String;ILandroidx/databinding/ViewDataBinding$IncludedLayouts;I)I
    .registers 6

    const/16 v0, 0x2f

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x2

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object p0

    iget-object p2, p2, Landroidx/databinding/ViewDataBinding$IncludedLayouts;->layouts:[[Ljava/lang/String;

    aget-object p2, p2, p3

    array-length p3, p2

    :goto_17
    if-ge p1, p3, :cond_25

    aget-object v0, p2, p1

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_22

    return p1

    :cond_22
    add-int/lit8 p1, p1, 0x1

    goto :goto_17

    :cond_25
    const/4 p0, -0x1

    return p0
.end method

.method private static findLastMatching(Landroid/view/ViewGroup;I)I
    .registers 10

    invoke-virtual {p0, p1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v3

    add-int/lit8 v4, p1, 0x1

    :goto_1f
    if-ge v4, v3, :cond_60

    invoke-virtual {p0, v4}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    instance-of v6, v6, Ljava/lang/String;

    if-eqz v6, :cond_34

    invoke-virtual {v5}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    goto :goto_35

    :cond_34
    const/4 v5, 0x0

    :goto_35
    if-eqz v5, :cond_5d

    invoke-virtual {v5, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5d

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v7

    if-ne v6, v7, :cond_56

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x30

    if-ne v6, v7, :cond_56

    return p1

    :cond_56
    invoke-static {v5, v2}, Landroidx/databinding/ViewDataBinding;->isNumeric(Ljava/lang/String;I)Z

    move-result v5

    if-eqz v5, :cond_5d

    move p1, v4

    :cond_5d
    add-int/lit8 v4, v4, 0x1

    goto :goto_1f

    :cond_60
    return p1
.end method

.method static getBinding(Landroid/view/View;)Landroidx/databinding/ViewDataBinding;
    .registers 2

    if-eqz p0, :cond_b

    sget v0, Landroidx/databinding/library/R$id;->dataBinding:I

    invoke-virtual {p0, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Landroidx/databinding/ViewDataBinding;

    return-object p0

    :cond_b
    const/4 p0, 0x0

    return-object p0
.end method

.method public static getBuildSdkInt()I
    .registers 1

    sget v0, Landroidx/databinding/ViewDataBinding;->SDK_INT:I

    return v0
.end method

.method protected static getColorFromResource(Landroid/view/View;I)I
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroid/content/Context;->getColor(I)I

    move-result p0

    return p0
.end method

.method protected static getColorStateListFromResource(Landroid/view/View;I)Landroid/content/res/ColorStateList;
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroid/content/Context;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object p0

    return-object p0
.end method

.method protected static getDrawableFromResource(Landroid/view/View;I)Landroid/graphics/drawable/Drawable;
    .registers 2

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p0

    invoke-virtual {p0, p1}, Landroid/content/Context;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method protected static getFrom(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map<",
            "TK;TT;>;TK;)TT;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method protected static getFromArray([BI)B
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-byte p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromArray([CI)C
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-char p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromArray([DI)D
    .registers 4

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-wide v0, p0, p1

    return-wide v0

    :cond_b
    :goto_b
    const-wide/16 p0, 0x0

    return-wide p0
.end method

.method protected static getFromArray([FI)F
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromArray([II)I
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromArray([JI)J
    .registers 4

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-wide v0, p0, p1

    return-wide v0

    :cond_b
    :goto_b
    const-wide/16 p0, 0x0

    return-wide p0
.end method

.method protected static getFromArray([Ljava/lang/Object;I)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;I)TT;"
        }
    .end annotation

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-object p0, p0, p1

    return-object p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return-object p0
.end method

.method protected static getFromArray([SI)S
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-short p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromArray([ZI)Z
    .registers 3

    if-eqz p0, :cond_b

    if-ltz p1, :cond_b

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_b

    :cond_8
    aget-boolean p0, p0, p1

    return p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromList(Landroid/util/SparseIntArray;I)I
    .registers 2

    if-eqz p0, :cond_a

    if-gez p1, :cond_5

    goto :goto_a

    :cond_5
    invoke-virtual {p0, p1}, Landroid/util/SparseIntArray;->get(I)I

    move-result p0

    return p0

    :cond_a
    :goto_a
    const/4 p0, 0x0

    return p0
.end method

.method protected static getFromList(Landroid/util/SparseLongArray;I)J
    .registers 2

    if-eqz p0, :cond_a

    if-gez p1, :cond_5

    goto :goto_a

    :cond_5
    invoke-virtual {p0, p1}, Landroid/util/SparseLongArray;->get(I)J

    move-result-wide p0

    return-wide p0

    :cond_a
    :goto_a
    const-wide/16 p0, 0x0

    return-wide p0
.end method

.method protected static getFromList(Landroid/util/LongSparseArray;I)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/util/LongSparseArray<",
            "TT;>;I)TT;"
        }
    .end annotation

    if-eqz p0, :cond_b

    if-gez p1, :cond_5

    goto :goto_b

    :cond_5
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1}, Landroid/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return-object p0
.end method

.method protected static getFromList(Landroid/util/SparseArray;I)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/util/SparseArray<",
            "TT;>;I)TT;"
        }
    .end annotation

    if-eqz p0, :cond_a

    if-gez p1, :cond_5

    goto :goto_a

    :cond_5
    invoke-virtual {p0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_a
    :goto_a
    const/4 p0, 0x0

    return-object p0
.end method

.method protected static getFromList(Landroidx/collection/LongSparseArray;I)Ljava/lang/Object;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroidx/collection/LongSparseArray<",
            "TT;>;I)TT;"
        }
    .end annotation

    if-eqz p0, :cond_b

    if-gez p1, :cond_5

    goto :goto_b

    :cond_5
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1}, Landroidx/collection/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_b
    :goto_b
    const/4 p0, 0x0

    return-object p0
.end method

.method protected static getFromList(Ljava/util/List;I)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List<",
            "TT;>;I)TT;"
        }
    .end annotation

    if-eqz p0, :cond_10

    if-ltz p1, :cond_10

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_10

    :cond_b
    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p0

    return-object p0

    :cond_10
    :goto_10
    const/4 p0, 0x0

    return-object p0
.end method

.method protected static getFromList(Landroid/util/SparseBooleanArray;I)Z
    .registers 2

    if-eqz p0, :cond_a

    if-gez p1, :cond_5

    goto :goto_a

    :cond_5
    invoke-virtual {p0, p1}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result p0

    return p0

    :cond_a
    :goto_a
    const/4 p0, 0x0

    return p0
.end method

.method protected static inflateInternal(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;ZLjava/lang/Object;)Landroidx/databinding/ViewDataBinding;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroidx/databinding/ViewDataBinding;",
            ">(",
            "Landroid/view/LayoutInflater;",
            "I",
            "Landroid/view/ViewGroup;",
            "Z",
            "Ljava/lang/Object;",
            ")TT;"
        }
    .end annotation

    invoke-static {p4}, Landroidx/databinding/ViewDataBinding;->checkAndCastToBindingComponent(Ljava/lang/Object;)Landroidx/databinding/DataBindingComponent;

    move-result-object p4

    invoke-static {p0, p1, p2, p3, p4}, Landroidx/databinding/DataBindingUtil;->inflate(Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;ZLandroidx/databinding/DataBindingComponent;)Landroidx/databinding/ViewDataBinding;

    move-result-object p0

    return-object p0
.end method

.method private static isNumeric(Ljava/lang/String;I)Z
    .registers 5

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    if-ne v0, p1, :cond_8

    return v1

    :cond_8
    :goto_8
    if-ge p1, v0, :cond_18

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-static {v2}, Ljava/lang/Character;->isDigit(C)Z

    move-result v2

    if-nez v2, :cond_15

    return v1

    :cond_15
    add-int/lit8 p1, p1, 0x1

    goto :goto_8

    :cond_18
    const/4 p0, 0x1

    return p0
.end method

.method private static mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;Landroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;Z)V
    .registers 23

    move-object/from16 v6, p0

    move-object/from16 v0, p1

    move-object/from16 v7, p3

    move-object/from16 v8, p4

    invoke-static/range {p1 .. p1}, Landroidx/databinding/ViewDataBinding;->getBinding(Landroid/view/View;)Landroidx/databinding/ViewDataBinding;

    move-result-object v1

    if-eqz v1, :cond_f

    return-void

    :cond_f
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    instance-of v2, v1, Ljava/lang/String;

    if-eqz v2, :cond_1a

    check-cast v1, Ljava/lang/String;

    goto :goto_1b

    :cond_1a
    const/4 v1, 0x0

    :goto_1b
    const-string v9, "layout"

    const/4 v2, -0x1

    const/4 v11, 0x1

    if-eqz p5, :cond_4b

    if-eqz v1, :cond_4b

    invoke-virtual {v1, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4b

    const/16 v3, 0x5f

    invoke-virtual {v1, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    if-lez v3, :cond_47

    add-int/2addr v3, v11

    invoke-static {v1, v3}, Landroidx/databinding/ViewDataBinding;->isNumeric(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_47

    invoke-static {v1, v3}, Landroidx/databinding/ViewDataBinding;->parseTagInt(Ljava/lang/String;I)I

    move-result v1

    aget-object v3, p2, v1

    if-nez v3, :cond_42

    aput-object v0, p2, v1

    :cond_42
    if-nez v7, :cond_45

    move v1, v2

    :cond_45
    move v3, v11

    goto :goto_49

    :cond_47
    move v1, v2

    const/4 v3, 0x0

    :goto_49
    move v12, v1

    goto :goto_69

    :cond_4b
    if-eqz v1, :cond_67

    const-string v3, "binding_"

    invoke-virtual {v1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_67

    sget v3, Landroidx/databinding/ViewDataBinding;->BINDING_NUMBER_START:I

    invoke-static {v1, v3}, Landroidx/databinding/ViewDataBinding;->parseTagInt(Ljava/lang/String;I)I

    move-result v1

    aget-object v3, p2, v1

    if-nez v3, :cond_61

    aput-object v0, p2, v1

    :cond_61
    if-nez v7, :cond_64

    move v1, v2

    :cond_64
    move v12, v1

    move v3, v11

    goto :goto_69

    :cond_67
    move v12, v2

    const/4 v3, 0x0

    :goto_69
    if-nez v3, :cond_7f

    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v1

    if-lez v1, :cond_7f

    if-eqz v8, :cond_7f

    invoke-virtual {v8, v1, v2}, Landroid/util/SparseIntArray;->get(II)I

    move-result v1

    if-ltz v1, :cond_7f

    aget-object v2, p2, v1

    if-nez v2, :cond_7f

    aput-object v0, p2, v1

    :cond_7f
    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_119

    move-object v13, v0

    check-cast v13, Landroid/view/ViewGroup;

    invoke-virtual {v13}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v14

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_8c
    if-ge v0, v14, :cond_119

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-ltz v12, :cond_fc

    invoke-virtual {v2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Ljava/lang/String;

    if-eqz v3, :cond_fc

    invoke-virtual {v2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    const-string v4, "_0"

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_fc

    invoke-virtual {v3, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_fc

    const/16 v4, 0x2f

    invoke-virtual {v3, v4}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    if-lez v4, :cond_fc

    invoke-static {v3, v1, v7, v12}, Landroidx/databinding/ViewDataBinding;->findIncludeIndex(Ljava/lang/String;ILandroidx/databinding/ViewDataBinding$IncludedLayouts;I)I

    move-result v3

    if-ltz v3, :cond_fc

    add-int/lit8 v1, v3, 0x1

    iget-object v4, v7, Landroidx/databinding/ViewDataBinding$IncludedLayouts;->indexes:[[I

    aget-object v4, v4, v12

    aget v4, v4, v3

    iget-object v5, v7, Landroidx/databinding/ViewDataBinding$IncludedLayouts;->layoutIds:[[I

    aget-object v5, v5, v12

    aget v3, v5, v3

    invoke-static {v13, v0}, Landroidx/databinding/ViewDataBinding;->findLastMatching(Landroid/view/ViewGroup;I)I

    move-result v5

    if-ne v5, v0, :cond_dc

    invoke-static {v6, v2, v3}, Landroidx/databinding/DataBindingUtil;->bind(Landroidx/databinding/DataBindingComponent;Landroid/view/View;I)Landroidx/databinding/ViewDataBinding;

    move-result-object v3

    aput-object v3, p2, v4

    move v10, v0

    move v0, v11

    move v11, v1

    goto :goto_ff

    :cond_dc
    sub-int/2addr v5, v0

    add-int/2addr v5, v11

    new-array v15, v5, [Landroid/view/View;

    const/4 v10, 0x0

    :goto_e1
    if-ge v10, v5, :cond_ef

    add-int v11, v0, v10

    invoke-virtual {v13, v11}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v11

    aput-object v11, v15, v10

    add-int/lit8 v10, v10, 0x1

    const/4 v11, 0x1

    goto :goto_e1

    :cond_ef
    invoke-static {v6, v15, v3}, Landroidx/databinding/DataBindingUtil;->bind(Landroidx/databinding/DataBindingComponent;[Landroid/view/View;I)Landroidx/databinding/ViewDataBinding;

    move-result-object v3

    aput-object v3, p2, v4

    add-int/lit8 v5, v5, -0x1

    add-int/2addr v0, v5

    move v10, v0

    move v11, v1

    const/4 v0, 0x1

    goto :goto_ff

    :cond_fc
    move v10, v0

    move v11, v1

    const/4 v0, 0x0

    :goto_ff
    if-nez v0, :cond_10e

    const/4 v5, 0x0

    move-object/from16 v0, p0

    move-object v1, v2

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    invoke-static/range {v0 .. v5}, Landroidx/databinding/ViewDataBinding;->mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;Landroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;Z)V

    :cond_10e
    const/4 v0, 0x1

    add-int/lit8 v1, v10, 0x1

    move/from16 v16, v11

    move v11, v0

    move v0, v1

    move/from16 v1, v16

    goto/16 :goto_8c

    :cond_119
    return-void
.end method

.method protected static mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;ILandroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;)[Ljava/lang/Object;
    .registers 11

    new-array p2, p2, [Ljava/lang/Object;

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Landroidx/databinding/ViewDataBinding;->mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;Landroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;Z)V

    return-object p2
.end method

.method protected static mapBindings(Landroidx/databinding/DataBindingComponent;[Landroid/view/View;ILandroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;)[Ljava/lang/Object;
    .registers 12

    new-array p2, p2, [Ljava/lang/Object;

    const/4 v0, 0x0

    move v6, v0

    :goto_4
    array-length v0, p1

    if-ge v6, v0, :cond_14

    aget-object v1, p1, v6

    const/4 v5, 0x1

    move-object v0, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-static/range {v0 .. v5}, Landroidx/databinding/ViewDataBinding;->mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;Landroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;Z)V

    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    :cond_14
    return-object p2
.end method

.method protected static parse(Ljava/lang/String;B)B
    .registers 2

    :try_start_0
    invoke-static {p0}, Ljava/lang/Byte;->parseByte(Ljava/lang/String;)B

    move-result p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return p0

    :catch_5
    return p1
.end method

.method protected static parse(Ljava/lang/String;C)C
    .registers 3

    if-eqz p0, :cond_f

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    goto :goto_f

    :cond_9
    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result p0

    return p0

    :cond_f
    :goto_f
    return p1
.end method

.method protected static parse(Ljava/lang/String;D)D
    .registers 3

    :try_start_0
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return-wide p0

    :catch_5
    return-wide p1
.end method

.method protected static parse(Ljava/lang/String;F)F
    .registers 2

    :try_start_0
    invoke-static {p0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return p0

    :catch_5
    return p1
.end method

.method protected static parse(Ljava/lang/String;I)I
    .registers 2

    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return p0

    :catch_5
    return p1
.end method

.method protected static parse(Ljava/lang/String;J)J
    .registers 3

    :try_start_0
    invoke-static {p0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return-wide p0

    :catch_5
    return-wide p1
.end method

.method protected static parse(Ljava/lang/String;S)S
    .registers 2

    :try_start_0
    invoke-static {p0}, Ljava/lang/Short;->parseShort(Ljava/lang/String;)S

    move-result p0
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_4} :catch_5

    return p0

    :catch_5
    return p1
.end method

.method protected static parse(Ljava/lang/String;Z)Z
    .registers 2

    if-nez p0, :cond_3

    return p1

    :cond_3
    invoke-static {p0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method private static parseTagInt(Ljava/lang/String;I)I
    .registers 5

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    :goto_5
    if-ge p1, v0, :cond_13

    mul-int/lit8 v1, v1, 0xa

    invoke-virtual {p0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    add-int/lit8 v2, v2, -0x30

    add-int/2addr v1, v2

    add-int/lit8 p1, p1, 0x1

    goto :goto_5

    :cond_13
    return v1
.end method

.method private static processReferenceQueue()V
    .registers 2

    :cond_0
    :goto_0
    sget-object v0, Landroidx/databinding/ViewDataBinding;->sReferenceQueue:Ljava/lang/ref/ReferenceQueue;

    invoke-virtual {v0}, Ljava/lang/ref/ReferenceQueue;->poll()Ljava/lang/ref/Reference;

    move-result-object v0

    if-eqz v0, :cond_12

    instance-of v1, v0, Landroidx/databinding/WeakListener;

    if-eqz v1, :cond_0

    check-cast v0, Landroidx/databinding/WeakListener;

    invoke-virtual {v0}, Landroidx/databinding/WeakListener;->unregister()Z

    goto :goto_0

    :cond_12
    return-void
.end method

.method protected static safeUnbox(Ljava/lang/Byte;)B
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Byte;->byteValue()B

    move-result p0

    :goto_8
    return p0
.end method

.method protected static safeUnbox(Ljava/lang/Character;)C
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Character;->charValue()C

    move-result p0

    :goto_8
    return p0
.end method

.method protected static safeUnbox(Ljava/lang/Double;)D
    .registers 3

    if-nez p0, :cond_5

    const-wide/16 v0, 0x0

    goto :goto_9

    :cond_5
    invoke-virtual {p0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    :goto_9
    return-wide v0
.end method

.method protected static safeUnbox(Ljava/lang/Float;)F
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Float;->floatValue()F

    move-result p0

    :goto_8
    return p0
.end method

.method protected static safeUnbox(Ljava/lang/Integer;)I
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result p0

    :goto_8
    return p0
.end method

.method protected static safeUnbox(Ljava/lang/Long;)J
    .registers 3

    if-nez p0, :cond_5

    const-wide/16 v0, 0x0

    goto :goto_9

    :cond_5
    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    :goto_9
    return-wide v0
.end method

.method protected static safeUnbox(Ljava/lang/Short;)S
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Short;->shortValue()S

    move-result p0

    :goto_8
    return p0
.end method

.method protected static safeUnbox(Ljava/lang/Boolean;)Z
    .registers 1

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_8

    :cond_4
    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p0

    :goto_8
    return p0
.end method

.method protected static setBindingInverseListener(Landroidx/databinding/ViewDataBinding;Landroidx/databinding/InverseBindingListener;Landroidx/databinding/ViewDataBinding$PropertyChangedInverseListener;)V
    .registers 3

    if-eq p1, p2, :cond_e

    if-eqz p1, :cond_9

    check-cast p1, Landroidx/databinding/ViewDataBinding$PropertyChangedInverseListener;

    invoke-virtual {p0, p1}, Landroidx/databinding/ViewDataBinding;->removeOnPropertyChangedCallback(Landroidx/databinding/Observable$OnPropertyChangedCallback;)V

    :cond_9
    if-eqz p2, :cond_e

    invoke-virtual {p0, p2}, Landroidx/databinding/ViewDataBinding;->addOnPropertyChangedCallback(Landroidx/databinding/Observable$OnPropertyChangedCallback;)V

    :cond_e
    return-void
.end method

.method protected static setTo(Landroid/util/LongSparseArray;ILjava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/util/LongSparseArray<",
            "TT;>;ITT;)V"
        }
    .end annotation

    if-eqz p0, :cond_f

    if-ltz p1, :cond_f

    invoke-virtual {p0}, Landroid/util/LongSparseArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_f

    :cond_b
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1, p2}, Landroid/util/LongSparseArray;->put(JLjava/lang/Object;)V

    :cond_f
    :goto_f
    return-void
.end method

.method protected static setTo(Landroid/util/SparseArray;ILjava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/util/SparseArray<",
            "TT;>;ITT;)V"
        }
    .end annotation

    if-eqz p0, :cond_e

    if-ltz p1, :cond_e

    invoke-virtual {p0}, Landroid/util/SparseArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_e

    :cond_b
    invoke-virtual {p0, p1, p2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    :cond_e
    :goto_e
    return-void
.end method

.method protected static setTo(Landroid/util/SparseBooleanArray;IZ)V
    .registers 4

    if-eqz p0, :cond_e

    if-ltz p1, :cond_e

    invoke-virtual {p0}, Landroid/util/SparseBooleanArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_e

    :cond_b
    invoke-virtual {p0, p1, p2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    :cond_e
    :goto_e
    return-void
.end method

.method protected static setTo(Landroid/util/SparseIntArray;II)V
    .registers 4

    if-eqz p0, :cond_e

    if-ltz p1, :cond_e

    invoke-virtual {p0}, Landroid/util/SparseIntArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_e

    :cond_b
    invoke-virtual {p0, p1, p2}, Landroid/util/SparseIntArray;->put(II)V

    :cond_e
    :goto_e
    return-void
.end method

.method protected static setTo(Landroid/util/SparseLongArray;IJ)V
    .registers 5

    if-eqz p0, :cond_e

    if-ltz p1, :cond_e

    invoke-virtual {p0}, Landroid/util/SparseLongArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_e

    :cond_b
    invoke-virtual {p0, p1, p2, p3}, Landroid/util/SparseLongArray;->put(IJ)V

    :cond_e
    :goto_e
    return-void
.end method

.method protected static setTo(Landroidx/collection/LongSparseArray;ILjava/lang/Object;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroidx/collection/LongSparseArray<",
            "TT;>;ITT;)V"
        }
    .end annotation

    if-eqz p0, :cond_f

    if-ltz p1, :cond_f

    invoke-virtual {p0}, Landroidx/collection/LongSparseArray;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_f

    :cond_b
    int-to-long v0, p1

    invoke-virtual {p0, v0, v1, p2}, Landroidx/collection/LongSparseArray;->put(JLjava/lang/Object;)V

    :cond_f
    :goto_f
    return-void
.end method

.method protected static setTo(Ljava/util/List;ILjava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List<",
            "TT;>;ITT;)V"
        }
    .end annotation

    if-eqz p0, :cond_e

    if-ltz p1, :cond_e

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_b

    goto :goto_e

    :cond_b
    invoke-interface {p0, p1, p2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    :cond_e
    :goto_e
    return-void
.end method

.method protected static setTo(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map<",
            "TK;TT;>;TK;TT;)V"
        }
    .end annotation

    if-nez p0, :cond_3

    return-void

    :cond_3
    invoke-interface {p0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method protected static setTo([BIB)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-byte p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([CIC)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-char p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([DID)V
    .registers 5

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-wide p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([FIF)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([III)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([JIJ)V
    .registers 5

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-wide p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([Ljava/lang/Object;ILjava/lang/Object;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;ITT;)V"
        }
    .end annotation

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-object p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([SIS)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-short p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method

.method protected static setTo([ZIZ)V
    .registers 4

    if-eqz p0, :cond_a

    if-ltz p1, :cond_a

    array-length v0, p0

    if-lt p1, v0, :cond_8

    goto :goto_a

    :cond_8
    aput-boolean p2, p0, p1

    :cond_a
    :goto_a
    return-void
.end method


# virtual methods
.method public addOnRebindCallback(Landroidx/databinding/OnRebindCallback;)V
    .registers 4

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    if-nez v0, :cond_d

    new-instance v0, Landroidx/databinding/CallbackRegistry;

    sget-object v1, Landroidx/databinding/ViewDataBinding;->REBIND_NOTIFIER:Landroidx/databinding/CallbackRegistry$NotifierCallback;

    invoke-direct {v0, v1}, Landroidx/databinding/CallbackRegistry;-><init>(Landroidx/databinding/CallbackRegistry$NotifierCallback;)V

    iput-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    :cond_d
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    invoke-virtual {v0, p1}, Landroidx/databinding/CallbackRegistry;->add(Ljava/lang/Object;)V

    return-void
.end method

.method protected ensureBindingComponentIsNotNull(Ljava/lang/Class;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)V"
        }
    .end annotation

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mBindingComponent:Landroidx/databinding/DataBindingComponent;

    if-eqz v0, :cond_5

    return-void

    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Required DataBindingComponent is null in class "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". A BindingAdapter in "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v0, " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don\'t use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static."

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected abstract executeBindings()V
.end method

.method public executePendingBindings()V
    .registers 2

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mContainingBinding:Landroidx/databinding/ViewDataBinding;

    if-nez v0, :cond_8

    invoke-direct {p0}, Landroidx/databinding/ViewDataBinding;->executeBindingsInternal()V

    goto :goto_b

    :cond_8
    invoke-virtual {v0}, Landroidx/databinding/ViewDataBinding;->executePendingBindings()V

    :goto_b
    return-void
.end method

.method forceExecuteBindings()V
    .registers 1

    invoke-virtual {p0}, Landroidx/databinding/ViewDataBinding;->executeBindings()V

    return-void
.end method

.method public getLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    .registers 2

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    return-object v0
.end method

.method protected getObservedField(I)Ljava/lang/Object;
    .registers 3

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    aget-object p1, v0, p1

    if-nez p1, :cond_8

    const/4 p1, 0x0

    return-object p1

    :cond_8
    invoke-virtual {p1}, Landroidx/databinding/WeakListener;->getTarget()Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public getRoot()Landroid/view/View;
    .registers 2

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRoot:Landroid/view/View;

    return-object v0
.end method

.method protected handleFieldChange(ILjava/lang/Object;I)V
    .registers 5

    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mInLiveDataRegisterObserver:Z

    if-nez v0, :cond_12

    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mInStateFlowRegisterObserver:Z

    if-eqz v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0, p1, p2, p3}, Landroidx/databinding/ViewDataBinding;->onFieldChange(ILjava/lang/Object;I)Z

    move-result p1

    if-eqz p1, :cond_12

    invoke-virtual {p0}, Landroidx/databinding/ViewDataBinding;->requestRebind()V

    :cond_12
    :goto_12
    return-void
.end method

.method public abstract hasPendingBindings()Z
.end method

.method public abstract invalidateAll()V
.end method

.method protected abstract onFieldChange(ILjava/lang/Object;I)Z
.end method

.method protected registerTo(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)V
    .registers 5

    if-nez p2, :cond_3

    return-void

    :cond_3
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    aget-object v0, v0, p1

    if-nez v0, :cond_1a

    sget-object v0, Landroidx/databinding/ViewDataBinding;->sReferenceQueue:Ljava/lang/ref/ReferenceQueue;

    invoke-interface {p3, p0, p1, v0}, Landroidx/databinding/CreateWeakListener;->create(Landroidx/databinding/ViewDataBinding;ILjava/lang/ref/ReferenceQueue;)Landroidx/databinding/WeakListener;

    move-result-object v0

    iget-object p3, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    aput-object v0, p3, p1

    iget-object p1, p0, Landroidx/databinding/ViewDataBinding;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    if-eqz p1, :cond_1a

    invoke-virtual {v0, p1}, Landroidx/databinding/WeakListener;->setLifecycleOwner(Landroidx/lifecycle/LifecycleOwner;)V

    :cond_1a
    invoke-virtual {v0, p2}, Landroidx/databinding/WeakListener;->setTarget(Ljava/lang/Object;)V

    return-void
.end method

.method public removeOnRebindCallback(Landroidx/databinding/OnRebindCallback;)V
    .registers 3

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mRebindCallbacks:Landroidx/databinding/CallbackRegistry;

    if-eqz v0, :cond_7

    invoke-virtual {v0, p1}, Landroidx/databinding/CallbackRegistry;->remove(Ljava/lang/Object;)V

    :cond_7
    return-void
.end method

.method protected requestRebind()V
    .registers 3

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mContainingBinding:Landroidx/databinding/ViewDataBinding;

    if-eqz v0, :cond_8

    invoke-virtual {v0}, Landroidx/databinding/ViewDataBinding;->requestRebind()V

    goto :goto_3b

    :cond_8
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    if-eqz v0, :cond_1d

    invoke-interface {v0}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;

    move-result-object v0

    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->STARTED:Landroidx/lifecycle/Lifecycle$State;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z

    move-result v0

    if-nez v0, :cond_1d

    return-void

    :cond_1d
    monitor-enter p0

    :try_start_1e
    iget-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mPendingRebind:Z

    if-eqz v0, :cond_24

    monitor-exit p0

    return-void

    :cond_24
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mPendingRebind:Z

    monitor-exit p0
    :try_end_28
    .catchall {:try_start_1e .. :try_end_28} :catchall_3c

    sget-boolean v0, Landroidx/databinding/ViewDataBinding;->USE_CHOREOGRAPHER:Z

    if-eqz v0, :cond_34

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mChoreographer:Landroid/view/Choreographer;

    iget-object v1, p0, Landroidx/databinding/ViewDataBinding;->mFrameCallback:Landroid/view/Choreographer$FrameCallback;

    invoke-virtual {v0, v1}, Landroid/view/Choreographer;->postFrameCallback(Landroid/view/Choreographer$FrameCallback;)V

    goto :goto_3b

    :cond_34
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mUIThreadHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroidx/databinding/ViewDataBinding;->mRebindRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :goto_3b
    return-void

    :catchall_3c
    move-exception v0

    :try_start_3d
    monitor-exit p0
    :try_end_3e
    .catchall {:try_start_3d .. :try_end_3e} :catchall_3c

    throw v0
.end method

.method protected setContainedBinding(Landroidx/databinding/ViewDataBinding;)V
    .registers 2

    if-eqz p1, :cond_4

    iput-object p0, p1, Landroidx/databinding/ViewDataBinding;->mContainingBinding:Landroidx/databinding/ViewDataBinding;

    :cond_4
    return-void
.end method

.method public setLifecycleOwner(Landroidx/lifecycle/LifecycleOwner;)V
    .registers 6

    instance-of v0, p1, Landroidx/fragment/app/Fragment;

    if-eqz v0, :cond_b

    const-string v0, "DataBinding"

    const-string v1, "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment\'s view lifecycle"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_b
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    if-ne v0, p1, :cond_10

    return-void

    :cond_10
    if-eqz v0, :cond_1b

    invoke-interface {v0}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v0

    iget-object v1, p0, Landroidx/databinding/ViewDataBinding;->mOnStartListener:Landroidx/databinding/ViewDataBinding$OnStartListener;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/Lifecycle;->removeObserver(Landroidx/lifecycle/LifecycleObserver;)V

    :cond_1b
    iput-object p1, p0, Landroidx/databinding/ViewDataBinding;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    if-eqz p1, :cond_34

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mOnStartListener:Landroidx/databinding/ViewDataBinding$OnStartListener;

    if-nez v0, :cond_2b

    new-instance v0, Landroidx/databinding/ViewDataBinding$OnStartListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroidx/databinding/ViewDataBinding$OnStartListener;-><init>(Landroidx/databinding/ViewDataBinding;Landroidx/databinding/ViewDataBinding$1;)V

    iput-object v0, p0, Landroidx/databinding/ViewDataBinding;->mOnStartListener:Landroidx/databinding/ViewDataBinding$OnStartListener;

    :cond_2b
    invoke-interface {p1}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v0

    iget-object v1, p0, Landroidx/databinding/ViewDataBinding;->mOnStartListener:Landroidx/databinding/ViewDataBinding$OnStartListener;

    invoke-virtual {v0, v1}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    :cond_34
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_38
    if-ge v2, v1, :cond_44

    aget-object v3, v0, v2

    if-eqz v3, :cond_41

    invoke-virtual {v3, p1}, Landroidx/databinding/WeakListener;->setLifecycleOwner(Landroidx/lifecycle/LifecycleOwner;)V

    :cond_41
    add-int/lit8 v2, v2, 0x1

    goto :goto_38

    :cond_44
    return-void
.end method

.method protected setRootTag(Landroid/view/View;)V
    .registers 3

    sget v0, Landroidx/databinding/library/R$id;->dataBinding:I

    invoke-virtual {p1, v0, p0}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    return-void
.end method

.method protected setRootTag([Landroid/view/View;)V
    .registers 6

    array-length v0, p1

    const/4 v1, 0x0

    :goto_2
    if-ge v1, v0, :cond_e

    aget-object v2, p1, v1

    sget v3, Landroidx/databinding/library/R$id;->dataBinding:I

    invoke-virtual {v2, v3, p0}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_e
    return-void
.end method

.method public abstract setVariable(ILjava/lang/Object;)Z
.end method

.method public unbind()V
    .registers 5

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_4
    if-ge v2, v1, :cond_10

    aget-object v3, v0, v2

    if-eqz v3, :cond_d

    invoke-virtual {v3}, Landroidx/databinding/WeakListener;->unregister()Z

    :cond_d
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    :cond_10
    return-void
.end method

.method protected unregisterFrom(I)Z
    .registers 3

    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    aget-object p1, v0, p1

    if-eqz p1, :cond_b

    invoke-virtual {p1}, Landroidx/databinding/WeakListener;->unregister()Z

    move-result p1

    return p1

    :cond_b
    const/4 p1, 0x0

    return p1
.end method

.method protected updateLiveDataRegistration(ILandroidx/lifecycle/LiveData;)Z
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/lifecycle/LiveData<",
            "*>;)Z"
        }
    .end annotation

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mInLiveDataRegisterObserver:Z

    const/4 v0, 0x0

    :try_start_4
    sget-object v1, Landroidx/databinding/ViewDataBinding;->CREATE_LIVE_DATA_LISTENER:Landroidx/databinding/CreateWeakListener;

    invoke-virtual {p0, p1, p2, v1}, Landroidx/databinding/ViewDataBinding;->updateRegistration(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)Z

    move-result p1
    :try_end_a
    .catchall {:try_start_4 .. :try_end_a} :catchall_d

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mInLiveDataRegisterObserver:Z

    return p1

    :catchall_d
    move-exception p1

    iput-boolean v0, p0, Landroidx/databinding/ViewDataBinding;->mInLiveDataRegisterObserver:Z

    throw p1
.end method

.method protected updateRegistration(ILandroidx/databinding/Observable;)Z
    .registers 4

    sget-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_PROPERTY_LISTENER:Landroidx/databinding/CreateWeakListener;

    invoke-virtual {p0, p1, p2, v0}, Landroidx/databinding/ViewDataBinding;->updateRegistration(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)Z

    move-result p1

    return p1
.end method

.method protected updateRegistration(ILandroidx/databinding/ObservableList;)Z
    .registers 4

    sget-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_LIST_LISTENER:Landroidx/databinding/CreateWeakListener;

    invoke-virtual {p0, p1, p2, v0}, Landroidx/databinding/ViewDataBinding;->updateRegistration(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)Z

    move-result p1

    return p1
.end method

.method protected updateRegistration(ILandroidx/databinding/ObservableMap;)Z
    .registers 4

    sget-object v0, Landroidx/databinding/ViewDataBinding;->CREATE_MAP_LISTENER:Landroidx/databinding/CreateWeakListener;

    invoke-virtual {p0, p1, p2, v0}, Landroidx/databinding/ViewDataBinding;->updateRegistration(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)Z

    move-result p1

    return p1
.end method

.method protected updateRegistration(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)Z
    .registers 6

    if-nez p2, :cond_7

    invoke-virtual {p0, p1}, Landroidx/databinding/ViewDataBinding;->unregisterFrom(I)Z

    move-result p1

    return p1

    :cond_7
    iget-object v0, p0, Landroidx/databinding/ViewDataBinding;->mLocalFieldObservers:[Landroidx/databinding/WeakListener;

    aget-object v0, v0, p1

    const/4 v1, 0x1

    if-nez v0, :cond_12

    invoke-virtual {p0, p1, p2, p3}, Landroidx/databinding/ViewDataBinding;->registerTo(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)V

    return v1

    :cond_12
    invoke-virtual {v0}, Landroidx/databinding/WeakListener;->getTarget()Ljava/lang/Object;

    move-result-object v0

    if-ne v0, p2, :cond_1a

    const/4 p1, 0x0

    return p1

    :cond_1a
    invoke-virtual {p0, p1}, Landroidx/databinding/ViewDataBinding;->unregisterFrom(I)Z

    invoke-virtual {p0, p1, p2, p3}, Landroidx/databinding/ViewDataBinding;->registerTo(ILjava/lang/Object;Landroidx/databinding/CreateWeakListener;)V

    return v1
.end method
