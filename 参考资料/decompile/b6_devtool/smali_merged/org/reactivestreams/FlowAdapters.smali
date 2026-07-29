.class public final Lorg/reactivestreams/FlowAdapters;
.super Ljava/lang/Object;
.source "FlowAdapters.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;,
        Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;,
        Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;,
        Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;,
        Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;,
        Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;,
        Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscription;,
        Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscription;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No instances!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static toFlowProcessor(Lorg/reactivestreams/Processor;)Ljava/util/concurrent/Flow$Processor;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "U:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/reactivestreams/Processor<",
            "-TT;+TU;>;)",
            "Ljava/util/concurrent/Flow$Processor<",
            "TT;TU;>;"
        }
    .end annotation

    const-string v0, "reactiveStreamsProcessor"

    .line 103
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 105
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;

    if-eqz v0, :cond_e

    .line 106
    check-cast p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;->flow:Ljava/util/concurrent/Flow$Processor;

    goto :goto_1b

    .line 107
    :cond_e
    instance-of v0, p0, Ljava/util/concurrent/Flow$Processor;

    if-eqz v0, :cond_15

    .line 108
    check-cast p0, Ljava/util/concurrent/Flow$Processor;

    goto :goto_1b

    .line 110
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;-><init>(Lorg/reactivestreams/Processor;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method

.method public static toFlowPublisher(Lorg/reactivestreams/Publisher;)Ljava/util/concurrent/Flow$Publisher;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/reactivestreams/Publisher<",
            "+TT;>;)",
            "Ljava/util/concurrent/Flow$Publisher<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "reactiveStreamsPublisher"

    .line 57
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 59
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;

    if-eqz v0, :cond_e

    .line 60
    check-cast p0, Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;->flow:Ljava/util/concurrent/Flow$Publisher;

    goto :goto_1b

    .line 61
    :cond_e
    instance-of v0, p0, Ljava/util/concurrent/Flow$Publisher;

    if-eqz v0, :cond_15

    .line 62
    check-cast p0, Ljava/util/concurrent/Flow$Publisher;

    goto :goto_1b

    .line 64
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;-><init>(Lorg/reactivestreams/Publisher;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method

.method public static toFlowSubscriber(Lorg/reactivestreams/Subscriber;)Ljava/util/concurrent/Flow$Subscriber;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/reactivestreams/Subscriber<",
            "TT;>;)",
            "Ljava/util/concurrent/Flow$Subscriber<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "reactiveStreamsSubscriber"

    .line 123
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 125
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;

    if-eqz v0, :cond_e

    .line 126
    check-cast p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;->flow:Ljava/util/concurrent/Flow$Subscriber;

    goto :goto_1b

    .line 127
    :cond_e
    instance-of v0, p0, Ljava/util/concurrent/Flow$Subscriber;

    if-eqz v0, :cond_15

    .line 128
    check-cast p0, Ljava/util/concurrent/Flow$Subscriber;

    goto :goto_1b

    .line 130
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;-><init>(Lorg/reactivestreams/Subscriber;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method

.method public static toProcessor(Ljava/util/concurrent/Flow$Processor;)Lorg/reactivestreams/Processor;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "U:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Flow$Processor<",
            "-TT;+TU;>;)",
            "Lorg/reactivestreams/Processor<",
            "TT;TU;>;"
        }
    .end annotation

    const-string v0, "flowProcessor"

    .line 80
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 82
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;

    if-eqz v0, :cond_e

    .line 83
    check-cast p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveProcessor;->reactiveStreams:Lorg/reactivestreams/Processor;

    goto :goto_1b

    .line 84
    :cond_e
    instance-of v0, p0, Lorg/reactivestreams/Processor;

    if-eqz v0, :cond_15

    .line 85
    check-cast p0, Lorg/reactivestreams/Processor;

    goto :goto_1b

    .line 87
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowProcessor;-><init>(Ljava/util/concurrent/Flow$Processor;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method

.method public static toPublisher(Ljava/util/concurrent/Flow$Publisher;)Lorg/reactivestreams/Publisher;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Flow$Publisher<",
            "+TT;>;)",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "flowPublisher"

    .line 35
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 37
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;

    if-eqz v0, :cond_e

    .line 38
    check-cast p0, Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$FlowPublisherFromReactive;->reactiveStreams:Lorg/reactivestreams/Publisher;

    goto :goto_1b

    .line 39
    :cond_e
    instance-of v0, p0, Lorg/reactivestreams/Publisher;

    if-eqz v0, :cond_15

    .line 40
    check-cast p0, Lorg/reactivestreams/Publisher;

    goto :goto_1b

    .line 42
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$ReactivePublisherFromFlow;-><init>(Ljava/util/concurrent/Flow$Publisher;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method

.method public static toSubscriber(Ljava/util/concurrent/Flow$Subscriber;)Lorg/reactivestreams/Subscriber;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Flow$Subscriber<",
            "TT;>;)",
            "Lorg/reactivestreams/Subscriber<",
            "TT;>;"
        }
    .end annotation

    const-string v0, "flowSubscriber"

    .line 143
    invoke-static {p0, v0}, Ljava/util/Objects;->requireNonNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 145
    instance-of v0, p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;

    if-eqz v0, :cond_e

    .line 146
    check-cast p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;

    iget-object p0, p0, Lorg/reactivestreams/FlowAdapters$FlowToReactiveSubscriber;->reactiveStreams:Lorg/reactivestreams/Subscriber;

    goto :goto_1b

    .line 147
    :cond_e
    instance-of v0, p0, Lorg/reactivestreams/Subscriber;

    if-eqz v0, :cond_15

    .line 148
    check-cast p0, Lorg/reactivestreams/Subscriber;

    goto :goto_1b

    .line 150
    :cond_15
    new-instance v0, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;

    invoke-direct {v0, p0}, Lorg/reactivestreams/FlowAdapters$ReactiveToFlowSubscriber;-><init>(Ljava/util/concurrent/Flow$Subscriber;)V

    move-object p0, v0

    :goto_1b
    return-object p0
.end method
