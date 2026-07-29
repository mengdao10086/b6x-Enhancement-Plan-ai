.class final Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;
.super Ljava/lang/Object;
.source "UtilsActivityLifecycleImpl.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;


# static fields
.field static final INSTANCE:Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;

.field private static final STUB:Landroid/app/Activity;


# instance fields
.field private final mActivityLifecycleCallbacksMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Landroid/app/Activity;",
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mActivityList:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private mConfigCount:I

.field private mForegroundCount:I

.field private mIsBackground:Z

.field private final mStatusListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 33
    new-instance v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->INSTANCE:Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;

    .line 40
    new-instance v0, Landroid/app/Activity;

    invoke-direct {v0}, Landroid/app/Activity;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->STUB:Landroid/app/Activity;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    .line 37
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mStatusListeners:Ljava/util/List;

    .line 38
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    const/4 v0, 0x0

    .line 42
    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mForegroundCount:I

    .line 43
    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mConfigCount:I

    .line 44
    iput-boolean v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    return-void
.end method

.method static synthetic access$000(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 3

    .line 31
    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->addActivityLifecycleCallbacksInner(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method static synthetic access$100(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;)Ljava/util/Map;
    .registers 1

    .line 31
    iget-object p0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    return-object p0
.end method

.method static synthetic access$200(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 3

    .line 31
    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->removeActivityLifecycleCallbacksInner(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method private addActivityLifecycleCallbacksInner(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 5

    .line 104
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    if-nez v0, :cond_15

    .line 106
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    .line 107
    iget-object v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1c

    .line 109
    :cond_15
    invoke-interface {v0, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1c

    return-void

    .line 111
    :cond_1c
    :goto_1c
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V
    .registers 5

    .line 148
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeLifecycle(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;Ljava/util/List;)V

    .line 149
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    sget-object v1, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->STUB:Landroid/app/Activity;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-direct {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeLifecycle(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;Ljava/util/List;)V

    return-void
.end method

.method private consumeLifecycle(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;Ljava/util/List;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Landroidx/lifecycle/Lifecycle$Event;",
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;",
            ">;)V"
        }
    .end annotation

    if-nez p3, :cond_3

    return-void

    .line 154
    :cond_3
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p3

    :cond_7
    :goto_7
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5e

    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;

    .line 155
    invoke-virtual {v0, p1, p2}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onLifecycleChanged(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    .line 156
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    .line 157
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityCreated(Landroid/app/Activity;)V

    goto :goto_7

    .line 158
    :cond_22
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_START:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2e

    .line 159
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityStarted(Landroid/app/Activity;)V

    goto :goto_7

    .line 160
    :cond_2e
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_RESUME:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3a

    .line 161
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityResumed(Landroid/app/Activity;)V

    goto :goto_7

    .line 162
    :cond_3a
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_PAUSE:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_46

    .line 163
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityPaused(Landroid/app/Activity;)V

    goto :goto_7

    .line 164
    :cond_46
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_STOP:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_52

    .line 165
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityStopped(Landroid/app/Activity;)V

    goto :goto_7

    .line 166
    :cond_52
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_DESTROY:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, v1}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 167
    invoke-virtual {v0, p1}, Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;->onActivityDestroyed(Landroid/app/Activity;)V

    goto :goto_7

    .line 170
    :cond_5e
    sget-object p3, Landroidx/lifecycle/Lifecycle$Event;->ON_DESTROY:Landroidx/lifecycle/Lifecycle$Event;

    invoke-virtual {p2, p3}, Landroidx/lifecycle/Lifecycle$Event;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_6b

    .line 171
    iget-object p2, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    invoke-interface {p2, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_6b
    return-void
.end method

.method private getActivitiesByReflect()Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .line 361
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    const/4 v1, 0x0

    .line 364
    :try_start_6
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivityThread()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_d

    return-object v0

    .line 366
    :cond_d
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    const-string v4, "mActivities"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    const/4 v4, 0x1

    .line 367
    invoke-virtual {v3, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 368
    invoke-virtual {v3, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 369
    instance-of v3, v2, Ljava/util/Map;

    if-nez v3, :cond_24

    return-object v0

    .line 372
    :cond_24
    check-cast v2, Ljava/util/Map;

    .line 373
    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2e
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_7f

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 374
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    const-string v6, "activity"

    .line 375
    invoke-virtual {v5, v6}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v6

    .line 376
    invoke-virtual {v6, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 377
    invoke-virtual {v6, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/Activity;

    if-nez v1, :cond_62

    const-string v7, "paused"

    .line 379
    invoke-virtual {v5, v7}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v5

    .line 380
    invoke-virtual {v5, v4}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 381
    invoke-virtual {v5, v3}, Ljava/lang/reflect/Field;->getBoolean(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5e

    move-object v1, v6

    goto :goto_2e

    .line 384
    :cond_5e
    invoke-virtual {v0, v6}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_2e

    .line 387
    :cond_62
    invoke-virtual {v0, v6}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V
    :try_end_65
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_65} :catch_66

    goto :goto_2e

    :catch_66
    move-exception v2

    .line 391
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "getActivitiesByReflect: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "UtilsActivityLifecycle"

    invoke-static {v3, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7f
    if-eqz v1, :cond_84

    .line 394
    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    :cond_84
    return-object v0
.end method

.method private getActivityThread()Ljava/lang/Object;
    .registers 2

    .line 400
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivityThreadInActivityThreadStaticField()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_7

    return-object v0

    .line 402
    :cond_7
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivityThreadInActivityThreadStaticMethod()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private getActivityThreadInActivityThreadStaticField()Ljava/lang/Object;
    .registers 5

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "android.app.ActivityThread"

    .line 407
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v2, "sCurrentActivityThread"

    .line 408
    invoke-virtual {v1, v2}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    const/4 v2, 0x1

    .line 409
    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 410
    invoke-virtual {v1, v0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_15} :catch_16

    return-object v0

    :catch_16
    move-exception v1

    .line 412
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "getActivityThreadInActivityThreadStaticField: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "UtilsActivityLifecycle"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-object v0
.end method

.method private getActivityThreadInActivityThreadStaticMethod()Ljava/lang/Object;
    .registers 6

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "android.app.ActivityThread"

    .line 419
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-string v2, "currentActivityThread"

    const/4 v3, 0x0

    new-array v4, v3, [Ljava/lang/Class;

    .line 420
    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {v1, v0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_16
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_16} :catch_17

    return-object v0

    :catch_17
    move-exception v1

    .line 422
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "getActivityThreadInActivityThreadStaticMethod: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "UtilsActivityLifecycle"

    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-object v0
.end method

.method private postStatus(Landroid/app/Activity;Z)V
    .registers 5

    .line 336
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mStatusListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    return-void

    .line 337
    :cond_9
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mStatusListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_f
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_25

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;

    if-eqz p2, :cond_21

    .line 339
    invoke-interface {v1, p1}, Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;->onForeground(Landroid/app/Activity;)V

    goto :goto_f

    .line 341
    :cond_21
    invoke-interface {v1, p1}, Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;->onBackground(Landroid/app/Activity;)V

    goto :goto_f

    :cond_25
    return-void
.end method

.method private processHideSoftInputOnActivityDestroy(Landroid/app/Activity;Z)V
    .registers 5

    const/16 v0, -0x7b

    if-eqz p2, :cond_1e

    .line 310
    :try_start_4
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p1

    .line 311
    invoke-virtual {p1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object p2

    .line 312
    iget p2, p2, Landroid/view/WindowManager$LayoutParams;->softInputMode:I

    .line 313
    invoke-virtual {p1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-virtual {v1, v0, p2}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    const/4 p2, 0x3

    .line 314
    invoke-virtual {p1, p2}, Landroid/view/Window;->setSoftInputMode(I)V

    goto :goto_39

    .line 316
    :cond_1e
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p2

    invoke-virtual {p2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p2

    invoke-virtual {p2, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    move-result-object p2

    .line 317
    instance-of v0, p2, Ljava/lang/Integer;

    if-nez v0, :cond_2f

    return-void

    .line 318
    :cond_2f
    new-instance v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$4;

    invoke-direct {v0, p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$4;-><init>(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;Ljava/lang/Object;)V

    const-wide/16 p1, 0x64

    invoke-static {v0, p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThreadDelayed(Ljava/lang/Runnable;J)V
    :try_end_39
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_39} :catch_39

    :catch_39
    :goto_39
    return-void
.end method

.method private removeActivityLifecycleCallbacksInner(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 4

    .line 141
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityLifecycleCallbacksMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/List;

    if-eqz p1, :cond_13

    .line 142
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_13

    .line 143
    invoke-interface {p1, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    :cond_13
    return-void
.end method

.method private static setAnimatorsEnabled()V
    .registers 4

    .line 431
    invoke-static {}, Landroid/animation/ValueAnimator;->areAnimatorsEnabled()Z

    move-result v0

    if-eqz v0, :cond_7

    return-void

    .line 436
    :cond_7
    :try_start_7
    const-class v0, Landroid/animation/ValueAnimator;

    const-string v1, "sDurationScale"

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0

    const/4 v1, 0x1

    .line 437
    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    const/4 v1, 0x0

    .line 439
    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Float;

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    const/4 v3, 0x0

    cmpl-float v2, v2, v3

    if-nez v2, :cond_3d

    const/high16 v2, 0x3f800000    # 1.0f

    .line 441
    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    const-string v0, "UtilsActivityLifecycle"

    const-string v1, "setAnimatorsEnabled: Animators are enabled now!"

    .line 442
    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_33
    .catch Ljava/lang/NoSuchFieldException; {:try_start_7 .. :try_end_33} :catch_39
    .catch Ljava/lang/IllegalAccessException; {:try_start_7 .. :try_end_33} :catch_34

    goto :goto_3d

    :catch_34
    move-exception v0

    .line 447
    invoke-virtual {v0}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_3d

    :catch_39
    move-exception v0

    .line 445
    invoke-virtual {v0}, Ljava/lang/NoSuchFieldException;->printStackTrace()V

    :cond_3d
    :goto_3d
    return-void
.end method

.method private setTopActivity(Landroid/app/Activity;)V
    .registers 3

    .line 347
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    .line 348
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->getFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_26

    .line 349
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->remove(Ljava/lang/Object;)Z

    .line 350
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_26

    .line 353
    :cond_21
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    :cond_26
    :goto_26
    return-void
.end method


# virtual methods
.method addActivityLifecycleCallbacks(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 4

    if-eqz p1, :cond_d

    if-nez p2, :cond_5

    goto :goto_d

    .line 90
    :cond_5
    new-instance v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$1;-><init>(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    :cond_d
    :goto_d
    return-void
.end method

.method addActivityLifecycleCallbacks(Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 3

    .line 84
    sget-object v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->STUB:Landroid/app/Activity;

    invoke-virtual {p0, v0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->addActivityLifecycleCallbacks(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method addOnAppStatusChangedListener(Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;)V
    .registers 3

    .line 76
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mStatusListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method getActivityList()Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .line 67
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_10

    .line 68
    new-instance v0, Ljava/util/LinkedList;

    iget-object v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    return-object v0

    .line 70
    :cond_10
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivitiesByReflect()Ljava/util/List;

    move-result-object v0

    .line 71
    iget-object v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v1, v0}, Ljava/util/LinkedList;->addAll(Ljava/util/Collection;)Z

    .line 72
    new-instance v0, Ljava/util/LinkedList;

    iget-object v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-direct {v0, v1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method getApplicationByReflect()Landroid/app/Application;
    .registers 7

    const/4 v0, 0x0

    :try_start_1
    const-string v1, "android.app.ActivityThread"

    .line 177
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 178
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivityThread()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_e

    return-object v0

    :cond_e
    const-string v3, "getApplication"

    const/4 v4, 0x0

    new-array v5, v4, [Ljava/lang/Class;

    .line 180
    invoke-virtual {v1, v3, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_20

    return-object v0

    .line 182
    :cond_20
    check-cast v1, Landroid/app/Application;
    :try_end_22
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_22} :catch_23

    return-object v1

    :catch_23
    move-exception v1

    .line 184
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    return-object v0
.end method

.method getTopActivity()Landroid/app/Activity;
    .registers 4

    .line 56
    invoke-virtual {p0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->getActivityList()Ljava/util/List;

    move-result-object v0

    .line 57
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    .line 58
    invoke-static {v1}, Lcom/blankj/utilcode/util/UtilsBridge;->isActivityAlive(Landroid/app/Activity;)Z

    move-result v2

    if-nez v2, :cond_1b

    goto :goto_8

    :cond_1b
    return-object v1

    :cond_1c
    const/4 v0, 0x0

    return-object v0
.end method

.method init(Landroid/app/Application;)V
    .registers 2

    .line 47
    invoke-virtual {p1, p0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method isAppForeground()Z
    .registers 2

    .line 99
    iget-boolean v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    .line 197
    iget-object p2, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {p2}, Ljava/util/LinkedList;->size()I

    move-result p2

    if-nez p2, :cond_c

    const/4 p2, 0x1

    .line 198
    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->postStatus(Landroid/app/Activity;Z)V

    .line 200
    :cond_c
    invoke-static {p1}, Lcom/blankj/utilcode/util/LanguageUtils;->applyLanguage(Landroid/app/Activity;)V

    .line 201
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->setAnimatorsEnabled()V

    .line 202
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->setTopActivity(Landroid/app/Activity;)V

    .line 203
    sget-object p2, Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .registers 3

    .line 291
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0, p1}, Ljava/util/LinkedList;->remove(Ljava/lang/Object;)Z

    .line 292
    invoke-static {p1}, Lcom/blankj/utilcode/util/UtilsBridge;->fixSoftInputLeaks(Landroid/app/Activity;)V

    .line 293
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_DESTROY:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .registers 3

    .line 250
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_PAUSE:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public onActivityPostCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityPostDestroyed(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPostPaused(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPostResumed(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPostSaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityPostStarted(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPostStopped(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPreCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityPreDestroyed(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPrePaused(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPreResumed(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPreSaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityPreStarted(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityPreStopped(Landroid/app/Activity;)V
    .registers 2

    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .registers 4

    .line 233
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->setTopActivity(Landroid/app/Activity;)V

    .line 234
    iget-boolean v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_e

    .line 235
    iput-boolean v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    const/4 v0, 0x1

    .line 236
    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->postStatus(Landroid/app/Activity;Z)V

    .line 238
    :cond_e
    invoke-direct {p0, p1, v1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->processHideSoftInputOnActivityDestroy(Landroid/app/Activity;Z)V

    .line 239
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_RESUME:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .registers 3

    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .registers 3

    .line 214
    iget-boolean v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    if-nez v0, :cond_7

    .line 215
    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->setTopActivity(Landroid/app/Activity;)V

    .line 217
    :cond_7
    iget v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mConfigCount:I

    if-gez v0, :cond_10

    add-int/lit8 v0, v0, 0x1

    .line 218
    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mConfigCount:I

    goto :goto_16

    .line 220
    :cond_10
    iget v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mForegroundCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mForegroundCount:I

    .line 222
    :goto_16
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_START:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .registers 4

    .line 261
    invoke-virtual {p1}, Landroid/app/Activity;->isChangingConfigurations()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_d

    .line 262
    iget v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mConfigCount:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mConfigCount:I

    goto :goto_1a

    .line 264
    :cond_d
    iget v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mForegroundCount:I

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mForegroundCount:I

    if-gtz v0, :cond_1a

    .line 266
    iput-boolean v1, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mIsBackground:Z

    const/4 v0, 0x0

    .line 267
    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->postStatus(Landroid/app/Activity;Z)V

    .line 270
    :cond_1a
    :goto_1a
    invoke-direct {p0, p1, v1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->processHideSoftInputOnActivityDestroy(Landroid/app/Activity;Z)V

    .line 271
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_STOP:Landroidx/lifecycle/Lifecycle$Event;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->consumeActivityLifecycleCallbacks(Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V

    return-void
.end method

.method removeActivityLifecycleCallbacks(Landroid/app/Activity;)V
    .registers 3

    if-nez p1, :cond_3

    return-void

    .line 120
    :cond_3
    new-instance v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$2;

    invoke-direct {v0, p0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$2;-><init>(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method removeActivityLifecycleCallbacks(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 4

    if-eqz p1, :cond_d

    if-nez p2, :cond_5

    goto :goto_d

    .line 131
    :cond_5
    new-instance v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$3;

    invoke-direct {v0, p0, p1, p2}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl$3;-><init>(Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    :cond_d
    :goto_d
    return-void
.end method

.method removeActivityLifecycleCallbacks(Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V
    .registers 3

    .line 115
    sget-object v0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->STUB:Landroid/app/Activity;

    invoke-virtual {p0, v0, p1}, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->removeActivityLifecycleCallbacks(Landroid/app/Activity;Lcom/blankj/utilcode/util/Utils$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method removeOnAppStatusChangedListener(Lcom/blankj/utilcode/util/Utils$OnAppStatusChangedListener;)V
    .registers 3

    .line 80
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mStatusListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method unInit(Landroid/app/Application;)V
    .registers 3

    .line 51
    iget-object v0, p0, Lcom/blankj/utilcode/util/UtilsActivityLifecycleImpl;->mActivityList:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->clear()V

    .line 52
    invoke-virtual {p1, p0}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void
.end method
