.class Lrx_activity_result2/ActivitiesLifecycleCallbacks;
.super Ljava/lang/Object;
.source "ActivitiesLifecycleCallbacks.java"


# instance fields
.field activityLifecycleCallbacks:Landroid/app/Application$ActivityLifecycleCallbacks;

.field final application:Landroid/app/Application;

.field volatile emitted:Z

.field volatile liveActivityOrNull:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Application;)V
    .registers 3

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 59
    iput-boolean v0, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->emitted:Z

    .line 19
    iput-object p1, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->application:Landroid/app/Application;

    .line 20
    invoke-direct {p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->registerActivityLifeCycle()V

    return-void
.end method

.method private registerActivityLifeCycle()V
    .registers 3

    .line 24
    iget-object v0, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->activityLifecycleCallbacks:Landroid/app/Application$ActivityLifecycleCallbacks;

    if-eqz v0, :cond_9

    iget-object v1, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->application:Landroid/app/Application;

    invoke-virtual {v1, v0}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 26
    :cond_9
    new-instance v0, Lrx_activity_result2/ActivitiesLifecycleCallbacks$1;

    invoke-direct {v0, p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks$1;-><init>(Lrx_activity_result2/ActivitiesLifecycleCallbacks;)V

    iput-object v0, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->activityLifecycleCallbacks:Landroid/app/Application$ActivityLifecycleCallbacks;

    .line 48
    iget-object v1, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->application:Landroid/app/Application;

    invoke-virtual {v1, v0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void
.end method


# virtual methods
.method getLiveActivity()Landroid/app/Activity;
    .registers 2

    .line 52
    iget-object v0, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->liveActivityOrNull:Landroid/app/Activity;

    return-object v0
.end method

.method getOLiveActivity()Lio/reactivex/Observable;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/reactivex/Observable<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    .line 61
    iput-boolean v0, p0, Lrx_activity_result2/ActivitiesLifecycleCallbacks;->emitted:Z

    const-wide/16 v0, 0x32

    .line 62
    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v0, v1, v2}, Lio/reactivex/Observable;->interval(JJLjava/util/concurrent/TimeUnit;)Lio/reactivex/Observable;

    move-result-object v0

    new-instance v1, Lrx_activity_result2/ActivitiesLifecycleCallbacks$5;

    invoke-direct {v1, p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks$5;-><init>(Lrx_activity_result2/ActivitiesLifecycleCallbacks;)V

    .line 63
    invoke-virtual {v0, v1}, Lio/reactivex/Observable;->map(Lio/reactivex/functions/Function;)Lio/reactivex/Observable;

    move-result-object v0

    new-instance v1, Lrx_activity_result2/ActivitiesLifecycleCallbacks$4;

    invoke-direct {v1, p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks$4;-><init>(Lrx_activity_result2/ActivitiesLifecycleCallbacks;)V

    .line 69
    invoke-virtual {v0, v1}, Lio/reactivex/Observable;->takeWhile(Lio/reactivex/functions/Predicate;)Lio/reactivex/Observable;

    move-result-object v0

    new-instance v1, Lrx_activity_result2/ActivitiesLifecycleCallbacks$3;

    invoke-direct {v1, p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks$3;-><init>(Lrx_activity_result2/ActivitiesLifecycleCallbacks;)V

    .line 77
    invoke-virtual {v0, v1}, Lio/reactivex/Observable;->filter(Lio/reactivex/functions/Predicate;)Lio/reactivex/Observable;

    move-result-object v0

    new-instance v1, Lrx_activity_result2/ActivitiesLifecycleCallbacks$2;

    invoke-direct {v1, p0}, Lrx_activity_result2/ActivitiesLifecycleCallbacks$2;-><init>(Lrx_activity_result2/ActivitiesLifecycleCallbacks;)V

    .line 82
    invoke-virtual {v0, v1}, Lio/reactivex/Observable;->map(Lio/reactivex/functions/Function;)Lio/reactivex/Observable;

    move-result-object v0

    return-object v0
.end method
