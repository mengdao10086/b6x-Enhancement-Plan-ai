.class synthetic Lio/reactivex/internal/operators/flowable/FlowableConcatMap$1;
.super Ljava/lang/Object;
.source "FlowableConcatMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/reactivex/internal/operators/flowable/FlowableConcatMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$io$reactivex$internal$util$ErrorMode:[I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .line 49
    invoke-static {}, Lio/reactivex/internal/util/ErrorMode;->values()[Lio/reactivex/internal/util/ErrorMode;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lio/reactivex/internal/operators/flowable/FlowableConcatMap$1;->$SwitchMap$io$reactivex$internal$util$ErrorMode:[I

    :try_start_9
    sget-object v1, Lio/reactivex/internal/util/ErrorMode;->BOUNDARY:Lio/reactivex/internal/util/ErrorMode;

    invoke-virtual {v1}, Lio/reactivex/internal/util/ErrorMode;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_12} :catch_12

    :catch_12
    :try_start_12
    sget-object v0, Lio/reactivex/internal/operators/flowable/FlowableConcatMap$1;->$SwitchMap$io$reactivex$internal$util$ErrorMode:[I

    sget-object v1, Lio/reactivex/internal/util/ErrorMode;->END:Lio/reactivex/internal/util/ErrorMode;

    invoke-virtual {v1}, Lio/reactivex/internal/util/ErrorMode;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_1d} :catch_1d

    :catch_1d
    return-void
.end method
