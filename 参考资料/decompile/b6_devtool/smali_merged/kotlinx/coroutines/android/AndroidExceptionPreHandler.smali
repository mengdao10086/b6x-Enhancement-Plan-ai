.class public final Lkotlinx/coroutines/android/AndroidExceptionPreHandler;
.super Lkotlin/coroutines/AbstractCoroutineContextElement;
.source "AndroidExceptionPreHandler.kt"

# interfaces
.implements Lkotlinx/coroutines/CoroutineExceptionHandler;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"
    }
    d2 = {
        "Lkotlinx/coroutines/android/AndroidExceptionPreHandler;",
        "Lkotlin/coroutines/AbstractCoroutineContextElement;",
        "Lkotlinx/coroutines/CoroutineExceptionHandler;",
        "()V",
        "_preHandler",
        "",
        "handleException",
        "",
        "context",
        "Lkotlin/coroutines/CoroutineContext;",
        "exception",
        "",
        "preHandler",
        "Ljava/lang/reflect/Method;",
        "kotlinx-coroutines-android"
    }
    k = 0x1
    mv = {
        0x1,
        0x6,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field private volatile _preHandler:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .registers 2

    .line 15
    sget-object v0, Lkotlinx/coroutines/CoroutineExceptionHandler;->Key:Lkotlinx/coroutines/CoroutineExceptionHandler$Key;

    check-cast v0, Lkotlin/coroutines/CoroutineContext$Key;

    invoke-direct {p0, v0}, Lkotlin/coroutines/AbstractCoroutineContextElement;-><init>(Lkotlin/coroutines/CoroutineContext$Key;)V

    .line 18
    iput-object p0, p0, Lkotlinx/coroutines/android/AndroidExceptionPreHandler;->_preHandler:Ljava/lang/Object;

    return-void
.end method

.method private final preHandler()Ljava/lang/reflect/Method;
    .registers 6

    .line 22
    iget-object v0, p0, Lkotlinx/coroutines/android/AndroidExceptionPreHandler;->_preHandler:Ljava/lang/Object;

    if-eq v0, p0, :cond_7

    .line 23
    check-cast v0, Ljava/lang/reflect/Method;

    return-object v0

    :cond_7
    const/4 v0, 0x0

    .line 24
    :try_start_8
    const-class v1, Ljava/lang/Thread;

    const-string v2, "getUncaughtExceptionPreHandler"

    const/4 v3, 0x0

    new-array v4, v3, [Ljava/lang/Class;

    .line 25
    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 26
    invoke-virtual {v1}, Ljava/lang/reflect/Method;->getModifiers()I

    move-result v2

    invoke-static {v2}, Ljava/lang/reflect/Modifier;->isPublic(I)Z

    move-result v2

    if-eqz v2, :cond_28

    invoke-virtual {v1}, Ljava/lang/reflect/Method;->getModifiers()I

    move-result v2

    invoke-static {v2}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v2
    :try_end_25
    .catchall {:try_start_8 .. :try_end_25} :catchall_2c

    if-eqz v2, :cond_28

    const/4 v3, 0x1

    :cond_28
    if-eqz v3, :cond_2f

    move-object v0, v1

    goto :goto_2f

    .line 29
    :catchall_2c
    move-object v1, v0

    check-cast v1, Ljava/lang/reflect/Method;

    .line 31
    :cond_2f
    :goto_2f
    iput-object v0, p0, Lkotlinx/coroutines/android/AndroidExceptionPreHandler;->_preHandler:Ljava/lang/Object;

    return-object v0
.end method


# virtual methods
.method public handleException(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V
    .registers 5

    .line 49
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v0, 0x1c

    const/4 v1, 0x0

    if-ge p1, v0, :cond_9

    const/4 p1, 0x1

    goto :goto_a

    :cond_9
    move p1, v1

    :goto_a
    if-eqz p1, :cond_2c

    .line 50
    invoke-direct {p0}, Lkotlinx/coroutines/android/AndroidExceptionPreHandler;->preHandler()Ljava/lang/reflect/Method;

    move-result-object p1

    const/4 v0, 0x0

    if-nez p1, :cond_15

    move-object p1, v0

    goto :goto_1b

    :cond_15
    new-array v1, v1, [Ljava/lang/Object;

    invoke-virtual {p1, v0, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    :goto_1b
    instance-of v1, p1, Ljava/lang/Thread$UncaughtExceptionHandler;

    if-eqz v1, :cond_22

    move-object v0, p1

    check-cast v0, Ljava/lang/Thread$UncaughtExceptionHandler;

    :cond_22
    if-nez v0, :cond_25

    goto :goto_2c

    .line 51
    :cond_25
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object p1

    invoke-interface {v0, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    :cond_2c
    :goto_2c
    return-void
.end method
