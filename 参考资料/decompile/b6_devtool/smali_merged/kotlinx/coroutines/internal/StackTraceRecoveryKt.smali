.class public final Lkotlinx/coroutines/internal/StackTraceRecoveryKt;
.super Ljava/lang/Object;
.source "StackTraceRecovery.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n37#2:225\n36#2,3:226\n12701#3,2:229\n1620#3,6:233\n12701#3,2:239\n1620#3,6:242\n26#4:231\n26#4:232\n1#5:241\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n110#1:225\n110#1:226,3\n135#1:229,2\n145#1:233,6\n176#1:239,2\n202#1:242,6\n137#1:231\n139#1:232\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\u00082\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u0010H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00192\u0010\u0010\u000e\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u0010H\u0002\u00a2\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000cH\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u00a2\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000\u00a2\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030#H\u0080\u0008\u00a2\u0006\u0002\u0010$\u001a!\u0010%\u001a\u0004\u0018\u0001H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010\"\u001a \u0010&\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0080\u0008\u00a2\u0006\u0002\u0010\"\u001a\u001f\u0010\'\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000\u00a2\u0006\u0002\u0010\"\u001a1\u0010(\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00190)\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020,*\u00060\u0007j\u0002`\u00082\n\u0010-\u001a\u00060\u0007j\u0002`\u0008H\u0002\u001a#\u0010.\u001a\u00020/*\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00192\u0006\u00100\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0017*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0000\u001a\u0010\u00103\u001a\u00020,*\u00060\u0007j\u0002`\u0008H\u0000\u001a\u001b\u00104\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000*\u000c\u0008\u0000\u00105\"\u00020\u00142\u00020\u0014*\u000c\u0008\u0000\u00106\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u00067"
    }
    d2 = {
        "baseContinuationImplClass",
        "",
        "baseContinuationImplClassName",
        "kotlin.jvm.PlatformType",
        "stackTraceRecoveryClass",
        "stackTraceRecoveryClassName",
        "artificialFrame",
        "Ljava/lang/StackTraceElement;",
        "Lkotlinx/coroutines/internal/StackTraceElement;",
        "message",
        "createFinalException",
        "E",
        "",
        "cause",
        "result",
        "resultStackTrace",
        "Ljava/util/ArrayDeque;",
        "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;",
        "createStackTrace",
        "continuation",
        "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;",
        "Lkotlinx/coroutines/internal/CoroutineStackFrame;",
        "mergeRecoveredTraces",
        "",
        "recoveredStacktrace",
        "",
        "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V",
        "recoverAndThrow",
        "",
        "exception",
        "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "recoverFromStackFrame",
        "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;",
        "recoverStackTrace",
        "(Ljava/lang/Throwable;)Ljava/lang/Throwable;",
        "Lkotlin/coroutines/Continuation;",
        "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;",
        "tryCopyAndVerify",
        "unwrap",
        "unwrapImpl",
        "causeAndStacktrace",
        "Lkotlin/Pair;",
        "(Ljava/lang/Throwable;)Lkotlin/Pair;",
        "elementWiseEquals",
        "",
        "e",
        "frameIndex",
        "",
        "methodName",
        "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I",
        "initCause",
        "isArtificial",
        "sanitizeStackTrace",
        "CoroutineStackFrame",
        "StackTraceElement",
        "kotlinx-coroutines-core"
    }
    k = 0x2
    mv = {
        0x1,
        0x6,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final baseContinuationImplClass:Ljava/lang/String; = "kotlin.coroutines.jvm.internal.BaseContinuationImpl"

.field private static final baseContinuationImplClassName:Ljava/lang/String;

.field private static final stackTraceRecoveryClass:Ljava/lang/String; = "kotlinx.coroutines.internal.StackTraceRecoveryKt"

.field private static final stackTraceRecoveryClassName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    const-string v0, "kotlinx.coroutines.internal.StackTraceRecoveryKt"

    const-string v1, "kotlin.coroutines.jvm.internal.BaseContinuationImpl"

    .line 21
    :try_start_4
    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    .line 22
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v2

    .line 21
    invoke-static {v2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2
    :try_end_12
    .catchall {:try_start_4 .. :try_end_12} :catchall_13

    goto :goto_1e

    :catchall_13
    move-exception v2

    sget-object v3, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v2}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 23
    :goto_1e
    invoke-static {v2}, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v3

    if-nez v3, :cond_25

    move-object v1, v2

    :cond_25
    check-cast v1, Ljava/lang/String;

    sput-object v1, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->baseContinuationImplClassName:Ljava/lang/String;

    .line 25
    :try_start_29
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    .line 26
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v1

    .line 25
    invoke-static {v1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1
    :try_end_37
    .catchall {:try_start_29 .. :try_end_37} :catchall_38

    goto :goto_43

    :catchall_38
    move-exception v1

    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v1}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 27
    :goto_43
    invoke-static {v1}, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;

    move-result-object v2

    if-nez v2, :cond_4a

    move-object v0, v1

    :cond_4a
    check-cast v0, Ljava/lang/String;

    sput-object v0, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->stackTraceRecoveryClassName:Ljava/lang/String;

    return-void
.end method

.method public static synthetic CoroutineStackFrame$annotations()V
    .registers 0

    return-void
.end method

.method public static synthetic StackTraceElement$annotations()V
    .registers 0

    return-void
.end method

.method public static final synthetic access$recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    .registers 2

    .line 1
    invoke-static {p0, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;

    move-result-object p0

    return-object p0
.end method

.method public static final artificialFrame(Ljava/lang/String;)Ljava/lang/StackTraceElement;
    .registers 4

    .line 200
    new-instance v0, Ljava/lang/StackTraceElement;

    const-string v1, "\u0008\u0008\u0008("

    invoke-static {v1, p0}, Lkotlin/jvm/internal/Intrinsics;->stringPlus(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    const-string v1, "\u0008"

    const/4 v2, -0x1

    invoke-direct {v0, p0, v1, v1, v2}, Ljava/lang/StackTraceElement;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    return-object v0
.end method

.method private static final causeAndStacktrace(Ljava/lang/Throwable;)Lkotlin/Pair;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)",
            "Lkotlin/Pair<",
            "TE;[",
            "Ljava/lang/StackTraceElement;",
            ">;"
        }
    .end annotation

    .line 132
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_38

    .line 133
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_38

    .line 134
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    .line 229
    array-length v3, v2

    move v4, v1

    :cond_1b
    if-ge v4, v3, :cond_29

    aget-object v5, v2, v4

    add-int/lit8 v4, v4, 0x1

    .line 135
    invoke-static {v5}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->isArtificial(Ljava/lang/StackTraceElement;)Z

    move-result v5

    if-eqz v5, :cond_1b

    const/4 v3, 0x1

    goto :goto_2a

    :cond_29
    move v3, v1

    :goto_2a
    if-eqz v3, :cond_31

    .line 136
    invoke-static {v0, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object p0

    goto :goto_3e

    :cond_31
    new-array v0, v1, [Ljava/lang/StackTraceElement;

    .line 137
    invoke-static {p0, v0}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object p0

    goto :goto_3e

    :cond_38
    new-array v0, v1, [Ljava/lang/StackTraceElement;

    .line 139
    invoke-static {p0, v0}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object p0

    :goto_3e
    return-object p0
.end method

.method private static final createFinalException(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;TE;",
            "Ljava/util/ArrayDeque<",
            "Ljava/lang/StackTraceElement;",
            ">;)TE;"
        }
    .end annotation

    const-string v0, "Coroutine boundary"

    .line 106
    invoke-static {v0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->artificialFrame(Ljava/lang/String;)Ljava/lang/StackTraceElement;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/util/ArrayDeque;->addFirst(Ljava/lang/Object;)V

    .line 107
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object p0

    .line 108
    sget-object v0, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->baseContinuationImplClassName:Ljava/lang/String;

    invoke-static {p0, v0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->frameIndex([Ljava/lang/StackTraceElement;Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    const/4 v2, 0x0

    if-ne v0, v1, :cond_2f

    .line 110
    check-cast p2, Ljava/util/Collection;

    new-array p0, v2, [Ljava/lang/StackTraceElement;

    .line 228
    invoke-interface {p2, p0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    if-eqz p0, :cond_27

    check-cast p0, [Ljava/lang/StackTraceElement;

    .line 110
    invoke-virtual {p1, p0}, Ljava/lang/Throwable;->setStackTrace([Ljava/lang/StackTraceElement;)V

    return-object p1

    .line 228
    :cond_27
    new-instance p0, Ljava/lang/NullPointerException;

    const-string p1, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"

    invoke-direct {p0, p1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0

    .line 114
    :cond_2f
    invoke-virtual {p2}, Ljava/util/ArrayDeque;->size()I

    move-result v1

    add-int/2addr v1, v0

    new-array v1, v1, [Ljava/lang/StackTraceElement;

    move v3, v2

    :goto_37
    if-ge v3, v0, :cond_41

    add-int/lit8 v4, v3, 0x1

    .line 116
    aget-object v5, p0, v3

    aput-object v5, v1, v3

    move v3, v4

    goto :goto_37

    .line 119
    :cond_41
    invoke-virtual {p2}, Ljava/util/ArrayDeque;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_45
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_58

    add-int/lit8 p2, v2, 0x1

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/StackTraceElement;

    add-int/2addr v2, v0

    .line 120
    aput-object v3, v1, v2

    move v2, p2

    goto :goto_45

    .line 123
    :cond_58
    invoke-virtual {p1, v1}, Ljava/lang/Throwable;->setStackTrace([Ljava/lang/StackTraceElement;)V

    return-object p1
.end method

.method private static final createStackTrace(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;",
            ")",
            "Ljava/util/ArrayDeque<",
            "Ljava/lang/StackTraceElement;",
            ">;"
        }
    .end annotation

    .line 185
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    .line 186
    invoke-interface {p0}, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;->getStackTraceElement()Ljava/lang/StackTraceElement;

    move-result-object v1

    if-nez v1, :cond_c

    goto :goto_f

    :cond_c
    invoke-virtual {v0, v1}, Ljava/util/ArrayDeque;->add(Ljava/lang/Object;)Z

    .line 190
    :goto_f
    instance-of v1, p0, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    const/4 v2, 0x0

    if-eqz v1, :cond_15

    goto :goto_16

    :cond_15
    move-object p0, v2

    :goto_16
    if-nez p0, :cond_1a

    move-object p0, v2

    goto :goto_1e

    :cond_1a
    invoke-interface {p0}, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;->getCallerFrame()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    move-result-object p0

    :goto_1e
    if-nez p0, :cond_21

    return-object v0

    .line 191
    :cond_21
    invoke-interface {p0}, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;->getStackTraceElement()Ljava/lang/StackTraceElement;

    move-result-object v1

    if-nez v1, :cond_28

    goto :goto_f

    :cond_28
    invoke-virtual {v0, v1}, Ljava/util/ArrayDeque;->add(Ljava/lang/Object;)Z

    goto :goto_f
.end method

.method private static final elementWiseEquals(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z
    .registers 4

    .line 209
    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v0

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v1

    if-ne v0, v1, :cond_36

    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_36

    .line 210
    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_36

    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object p1

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_36

    const/4 p0, 0x1

    goto :goto_37

    :cond_36
    const/4 p0, 0x0

    :goto_37
    return p0
.end method

.method private static final frameIndex([Ljava/lang/StackTraceElement;Ljava/lang/String;)I
    .registers 6

    .line 242
    array-length v0, p0

    const/4 v1, 0x0

    :goto_2
    if-ge v1, v0, :cond_15

    add-int/lit8 v2, v1, 0x1

    .line 243
    aget-object v3, p0, v1

    .line 202
    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v3

    invoke-static {p1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    goto :goto_16

    :cond_13
    move v1, v2

    goto :goto_2

    :cond_15
    const/4 v1, -0x1

    :goto_16
    return v1
.end method

.method public static final initCause(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    .registers 2

    .line 222
    invoke-virtual {p0, p1}, Ljava/lang/Throwable;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    return-void
.end method

.method public static final isArtificial(Ljava/lang/StackTraceElement;)Z
    .registers 5

    .line 201
    invoke-virtual {p0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object p0

    const/4 v0, 0x2

    const/4 v1, 0x0

    const-string v2, "\u0008\u0008\u0008"

    const/4 v3, 0x0

    invoke-static {p0, v2, v3, v0, v1}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static final mergeRecoveredTraces([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/StackTraceElement;",
            "Ljava/util/ArrayDeque<",
            "Ljava/lang/StackTraceElement;",
            ">;)V"
        }
    .end annotation

    .line 233
    array-length v0, p0

    const/4 v1, 0x0

    :goto_2
    if-ge v1, v0, :cond_11

    add-int/lit8 v2, v1, 0x1

    .line 234
    aget-object v3, p0, v1

    .line 145
    invoke-static {v3}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->isArtificial(Ljava/lang/StackTraceElement;)Z

    move-result v3

    if-eqz v3, :cond_f

    goto :goto_12

    :cond_f
    move v1, v2

    goto :goto_2

    :cond_11
    const/4 v1, -0x1

    :goto_12
    add-int/lit8 v1, v1, 0x1

    .line 146
    array-length v0, p0

    add-int/lit8 v0, v0, -0x1

    if-gt v1, v0, :cond_36

    :goto_19
    add-int/lit8 v2, v0, -0x1

    .line 148
    aget-object v3, p0, v0

    .line 149
    invoke-virtual {p1}, Ljava/util/ArrayDeque;->getLast()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/StackTraceElement;

    invoke-static {v3, v4}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->elementWiseEquals(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z

    move-result v3

    if-eqz v3, :cond_2c

    .line 150
    invoke-virtual {p1}, Ljava/util/ArrayDeque;->removeLast()Ljava/lang/Object;

    .line 152
    :cond_2c
    aget-object v3, p0, v0

    invoke-virtual {p1, v3}, Ljava/util/ArrayDeque;->addFirst(Ljava/lang/Object;)V

    if-ne v0, v1, :cond_34

    goto :goto_36

    :cond_34
    move v0, v2

    goto :goto_19

    :cond_36
    :goto_36
    return-void
.end method

.method public static final recoverAndThrow(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 158
    invoke-static {}, Lkotlinx/coroutines/DebugKt;->getRECOVER_STACK_TRACES()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 160
    instance-of v0, p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    if-nez v0, :cond_b

    throw p0

    .line 161
    :cond_b
    check-cast p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    # invokes: Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    invoke-static {p0, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->access$recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;

    move-result-object p0

    throw p0

    .line 158
    :cond_12
    throw p0
.end method

.method private static final recoverAndThrow$$forInline(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 158
    invoke-static {}, Lkotlinx/coroutines/DebugKt;->getRECOVER_STACK_TRACES()Z

    move-result v0

    if-eqz v0, :cond_16

    const/4 v0, 0x0

    .line 159
    invoke-static {v0}, Lkotlin/jvm/internal/InlineMarker;->mark(I)V

    .line 160
    instance-of v0, p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    if-nez v0, :cond_f

    throw p0

    .line 161
    :cond_f
    check-cast p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    # invokes: Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    invoke-static {p0, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->access$recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;

    move-result-object p0

    throw p0

    .line 158
    :cond_16
    throw p0
.end method

.method private static final recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;",
            "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;",
            ")TE;"
        }
    .end annotation

    .line 66
    invoke-static {p0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->causeAndStacktrace(Ljava/lang/Throwable;)Lkotlin/Pair;

    move-result-object v0

    invoke-virtual {v0}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    invoke-virtual {v0}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/StackTraceElement;

    .line 69
    invoke-static {v1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->tryCopyAndVerify(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v2

    if-nez v2, :cond_17

    return-object p0

    .line 71
    :cond_17
    invoke-static {p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->createStackTrace(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;

    move-result-object p1

    .line 72
    invoke-virtual {p1}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_22

    return-object p0

    :cond_22
    if-eq v1, p0, :cond_27

    .line 75
    invoke-static {v0, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->mergeRecoveredTraces([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V

    .line 78
    :cond_27
    invoke-static {v1, v2, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->createFinalException(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;

    move-result-object p0

    return-object p0
.end method

.method public static final recoverStackTrace(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)TE;"
        }
    .end annotation

    .line 30
    invoke-static {}, Lkotlinx/coroutines/DebugKt;->getRECOVER_STACK_TRACES()Z

    move-result v0

    if-nez v0, :cond_7

    return-object p0

    .line 32
    :cond_7
    invoke-static {p0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->tryCopyAndVerify(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v0

    if-nez v0, :cond_e

    return-object p0

    .line 33
    :cond_e
    invoke-static {v0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->sanitizeStackTrace(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object p0

    return-object p0
.end method

.method public static final recoverStackTrace(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)TE;"
        }
    .end annotation

    .line 57
    invoke-static {}, Lkotlinx/coroutines/DebugKt;->getRECOVER_STACK_TRACES()Z

    move-result v0

    if-eqz v0, :cond_11

    instance-of v0, p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    if-nez v0, :cond_b

    goto :goto_11

    .line 58
    :cond_b
    check-cast p1, Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;

    # invokes: Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;
    invoke-static {p0, p1}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->access$recoverFromStackFrame(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;

    move-result-object p0

    :cond_11
    :goto_11
    return-object p0
.end method

.method private static final sanitizeStackTrace(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)TE;"
        }
    .end annotation

    .line 37
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    .line 38
    array-length v1, v0

    .line 39
    sget-object v2, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->stackTraceRecoveryClassName:Ljava/lang/String;

    invoke-static {v0, v2}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->frameIndex([Ljava/lang/StackTraceElement;Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v3, v2, 0x1

    .line 41
    sget-object v4, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->baseContinuationImplClassName:Ljava/lang/String;

    invoke-static {v0, v4}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->frameIndex([Ljava/lang/StackTraceElement;Ljava/lang/String;)I

    move-result v4

    const/4 v5, -0x1

    const/4 v6, 0x0

    if-ne v4, v5, :cond_19

    move v4, v6

    goto :goto_1b

    :cond_19
    sub-int v4, v1, v4

    :goto_1b
    sub-int/2addr v1, v2

    sub-int/2addr v1, v4

    .line 43
    new-array v2, v1, [Ljava/lang/StackTraceElement;

    :goto_1f
    if-ge v6, v1, :cond_35

    if-nez v6, :cond_2a

    const-string v4, "Coroutine boundary"

    .line 45
    invoke-static {v4}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->artificialFrame(Ljava/lang/String;)Ljava/lang/StackTraceElement;

    move-result-object v4

    goto :goto_30

    :cond_2a
    add-int v4, v3, v6

    add-int/lit8 v4, v4, -0x1

    .line 47
    aget-object v4, v0, v4

    :goto_30
    aput-object v4, v2, v6

    add-int/lit8 v6, v6, 0x1

    goto :goto_1f

    .line 51
    :cond_35
    invoke-virtual {p0, v2}, Ljava/lang/Throwable;->setStackTrace([Ljava/lang/StackTraceElement;)V

    return-object p0
.end method

.method private static final tryCopyAndVerify(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)TE;"
        }
    .end annotation

    .line 82
    invoke-static {p0}, Lkotlinx/coroutines/internal/ExceptionsConstructorKt;->tryCopyException(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return-object v1

    .line 85
    :cond_8
    instance-of v2, p0, Lkotlinx/coroutines/CopyableThrowable;

    if-nez v2, :cond_1b

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-static {v2, p0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_1b

    return-object v1

    :cond_1b
    return-object v0
.end method

.method public static final unwrap(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)TE;"
        }
    .end annotation

    .line 167
    invoke-static {}, Lkotlinx/coroutines/DebugKt;->getRECOVER_STACK_TRACES()Z

    move-result v0

    if-nez v0, :cond_7

    goto :goto_b

    :cond_7
    invoke-static {p0}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->unwrapImpl(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object p0

    :goto_b
    return-object p0
.end method

.method public static final unwrapImpl(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<E:",
            "Ljava/lang/Throwable;",
            ">(TE;)TE;"
        }
    .end annotation

    .line 170
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    if-eqz v0, :cond_2c

    .line 172
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_15

    goto :goto_2c

    .line 176
    :cond_15
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    .line 239
    array-length v2, v1

    const/4 v3, 0x0

    move v4, v3

    :cond_1c
    if-ge v4, v2, :cond_29

    aget-object v5, v1, v4

    add-int/lit8 v4, v4, 0x1

    .line 176
    invoke-static {v5}, Lkotlinx/coroutines/internal/StackTraceRecoveryKt;->isArtificial(Ljava/lang/StackTraceElement;)Z

    move-result v5

    if-eqz v5, :cond_1c

    const/4 v3, 0x1

    :cond_29
    if-eqz v3, :cond_2c

    return-object v0

    :cond_2c
    :goto_2c
    return-object p0
.end method
