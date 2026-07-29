.class public final Lcom/blankj/utilcode/util/UiMessageUtils;
.super Ljava/lang/Object;
.source "UiMessageUtils.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/UiMessageUtils$LazyHolder;,
        Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;,
        Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static final TAG:Ljava/lang/String; = "UiMessageUtils"


# instance fields
.field private final mDefensiveCopyList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;",
            ">;"
        }
    .end annotation
.end field

.field private final mHandler:Landroid/os/Handler;

.field private final mListenersSpecific:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mListenersUniversal:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;",
            ">;"
        }
    .end annotation
.end field

.field private final mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 25
    invoke-static {}, Lcom/blankj/utilcode/util/UtilsBridge;->isAppDebug()Z

    move-result v0

    sput-boolean v0, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mHandler:Landroid/os/Handler;

    .line 28
    new-instance v0, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    const/4 v1, 0x0

    invoke-direct {v0, v1, v1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;-><init>(Landroid/os/Message;Lcom/blankj/utilcode/util/UiMessageUtils$1;)V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    .line 30
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/blankj/utilcode/util/UiMessageUtils$1;)V
    .registers 2

    .line 22
    invoke-direct {p0}, Lcom/blankj/utilcode/util/UiMessageUtils;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/blankj/utilcode/util/UiMessageUtils;
    .registers 1

    .line 35
    # getter for: Lcom/blankj/utilcode/util/UiMessageUtils$LazyHolder;->INSTANCE:Lcom/blankj/utilcode/util/UiMessageUtils;
    invoke-static {}, Lcom/blankj/utilcode/util/UiMessageUtils$LazyHolder;->access$100()Lcom/blankj/utilcode/util/UiMessageUtils;

    move-result-object v0

    return-object v0
.end method

.method private logMessageHandling(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;)V
    .registers 7

    .line 194
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    if-eqz v0, :cond_14

    .line 196
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_44

    :cond_14
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_44

    const-string v0, "UiMessageUtils"

    .line 197
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Delivering FAILED for message ID "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". No listeners. "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_103

    .line 199
    :cond_44
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Delivering message ID "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 201
    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, ", Specific listeners: "

    .line 202
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v2, 0x0

    if-eqz v0, :cond_9b

    .line 203
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_61

    goto :goto_9b

    .line 206
    :cond_61
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, " ["

    .line 207
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move v3, v2

    .line 208
    :goto_6e
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_95

    .line 209
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 210
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v3, v4, :cond_92

    const-string v4, ","

    .line 211
    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_92
    add-int/lit8 v3, v3, 0x1

    goto :goto_6e

    :cond_95
    const-string v0, "]"

    .line 214
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_9e

    .line 204
    :cond_9b
    :goto_9b
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    :goto_9e
    const-string v0, ", Universal listeners: "

    .line 217
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 218
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    monitor-enter v0

    .line 219
    :try_start_a6
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_b2

    .line 220
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    goto :goto_f2

    .line 222
    :cond_b2
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, " ["

    .line 223
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 224
    :goto_c0
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_ed

    .line 225
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 226
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    if-ge v2, v3, :cond_ea

    const-string v3, ","

    .line 227
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_ea
    add-int/lit8 v2, v2, 0x1

    goto :goto_c0

    :cond_ed
    const-string v2, "], Message: "

    .line 230
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 232
    :goto_f2
    monitor-exit v0
    :try_end_f3
    .catchall {:try_start_a6 .. :try_end_f3} :catchall_104

    .line 233
    invoke-virtual {p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "UiMessageUtils"

    .line 235
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :goto_103
    return-void

    :catchall_104
    move-exception p1

    .line 232
    :try_start_105
    monitor-exit v0
    :try_end_106
    .catchall {:try_start_105 .. :try_end_106} :catchall_104

    throw p1
.end method


# virtual methods
.method public addListener(ILcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;)V
    .registers 6

    .line 69
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    monitor-enter v0

    .line 70
    :try_start_3
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    if-nez v1, :cond_17

    .line 72
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 73
    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {v2, p1, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 75
    :cond_17
    invoke-interface {v1, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_20

    .line 76
    invoke-interface {v1, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    :cond_20
    monitor-exit v0

    return-void

    :catchall_22
    move-exception p1

    monitor-exit v0
    :try_end_24
    .catchall {:try_start_3 .. :try_end_24} :catchall_22

    throw p1
.end method

.method public addListener(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;)V
    .registers 6

    const-string v0, "Listener is already added. "

    .line 87
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    monitor-enter v1

    .line 88
    :try_start_5
    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_13

    .line 89
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2d

    .line 91
    :cond_13
    sget-boolean v2, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v2, :cond_2d

    const-string v2, "UiMessageUtils"

    .line 92
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v2, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    :cond_2d
    :goto_2d
    monitor-exit v1

    return-void

    :catchall_2f
    move-exception p1

    monitor-exit v1
    :try_end_31
    .catchall {:try_start_5 .. :try_end_31} :catchall_2f

    throw p1
.end method

.method public handleMessage(Landroid/os/Message;)Z
    .registers 5

    .line 156
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    # invokes: Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->setMessage(Landroid/os/Message;)V
    invoke-static {v0, p1}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->access$200(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;Landroid/os/Message;)V

    .line 157
    sget-boolean v0, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v0, :cond_e

    .line 158
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    invoke-direct {p0, v0}, Lcom/blankj/utilcode/util/UiMessageUtils;->logMessageHandling(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;)V

    .line 162
    :cond_e
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    monitor-enter v0

    .line 163
    :try_start_11
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    if-eqz v1, :cond_4d

    .line 165
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_2b

    .line 166
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    iget p1, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->remove(I)V

    goto :goto_4d

    .line 168
    :cond_2b
    iget-object p1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    invoke-interface {p1, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 169
    iget-object p1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_36
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_48

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;

    .line 170
    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    invoke-interface {v1, v2}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;->handleMessage(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;)V

    goto :goto_36

    .line 172
    :cond_48
    iget-object p1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    invoke-interface {p1}, Ljava/util/List;->clear()V

    .line 175
    :cond_4d
    :goto_4d
    monitor-exit v0
    :try_end_4e
    .catchall {:try_start_11 .. :try_end_4e} :catchall_89

    .line 178
    iget-object p1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    monitor-enter p1

    .line 179
    :try_start_51
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7d

    .line 180
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 181
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_66
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_78

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;

    .line 182
    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    invoke-interface {v1, v2}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;->handleMessage(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;)V

    goto :goto_66

    .line 184
    :cond_78
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mDefensiveCopyList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 186
    :cond_7d
    monitor-exit p1
    :try_end_7e
    .catchall {:try_start_51 .. :try_end_7e} :catchall_86

    .line 188
    iget-object p1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mMessage:Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;

    const/4 v0, 0x0

    # invokes: Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->setMessage(Landroid/os/Message;)V
    invoke-static {p1, v0}, Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;->access$200(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessage;Landroid/os/Message;)V

    const/4 p1, 0x1

    return p1

    :catchall_86
    move-exception v0

    .line 186
    :try_start_87
    monitor-exit p1
    :try_end_88
    .catchall {:try_start_87 .. :try_end_88} :catchall_86

    throw v0

    :catchall_89
    move-exception p1

    .line 175
    :try_start_8a
    monitor-exit v0
    :try_end_8b
    .catchall {:try_start_8a .. :try_end_8b} :catchall_89

    throw p1
.end method

.method public removeListener(ILcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;)V
    .registers 8

    const-string v0, "Trying to remove specific listener that is not registered. ID "

    const-string v1, "Trying to remove specific listener that is not registered. ID "

    .line 136
    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    monitor-enter v2

    .line 137
    :try_start_7
    iget-object v3, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {v3, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    if-eqz v3, :cond_43

    .line 138
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_43

    .line 139
    sget-boolean v1, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v1, :cond_3f

    .line 140
    invoke-interface {v3, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3f

    const-string v1, "UiMessageUtils"

    .line 141
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v0, ", "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 142
    monitor-exit v2

    return-void

    .line 145
    :cond_3f
    invoke-interface {v3, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_63

    .line 147
    :cond_43
    sget-boolean v0, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v0, :cond_63

    const-string v0, "UiMessageUtils"

    .line 148
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v1, ", "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    :cond_63
    :goto_63
    monitor-exit v2

    return-void

    :catchall_65
    move-exception p1

    monitor-exit v2
    :try_end_67
    .catchall {:try_start_7 .. :try_end_67} :catchall_65

    throw p1
.end method

.method public removeListener(Lcom/blankj/utilcode/util/UiMessageUtils$UiMessageCallback;)V
    .registers 6

    const-string v0, "Trying to remove a listener that is not registered. "

    .line 104
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    monitor-enter v1

    .line 105
    :try_start_5
    sget-boolean v2, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v2, :cond_27

    iget-object v2, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_27

    const-string v2, "UiMessageUtils"

    .line 106
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 108
    :cond_27
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersUniversal:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 109
    monitor-exit v1

    return-void

    :catchall_2e
    move-exception p1

    monitor-exit v1
    :try_end_30
    .catchall {:try_start_5 .. :try_end_30} :catchall_2e

    throw p1
.end method

.method public removeListeners(I)V
    .registers 5

    .line 118
    sget-boolean v0, Lcom/blankj/utilcode/util/UiMessageUtils;->DEBUG:Z

    if-eqz v0, :cond_28

    .line 119
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    if-eqz v0, :cond_14

    .line 120
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_28

    :cond_14
    const-string v0, "UiMessageUtils"

    .line 121
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Trying to remove specific listeners that are not registered. ID "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    :cond_28
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    monitor-enter v0

    .line 125
    :try_start_2b
    iget-object v1, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mListenersSpecific:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->delete(I)V

    .line 126
    monitor-exit v0

    return-void

    :catchall_32
    move-exception p1

    monitor-exit v0
    :try_end_34
    .catchall {:try_start_2b .. :try_end_34} :catchall_32

    throw p1
.end method

.method public final send(I)V
    .registers 3

    .line 47
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    return-void
.end method

.method public final send(ILjava/lang/Object;)V
    .registers 4

    .line 57
    iget-object v0, p0, Lcom/blankj/utilcode/util/UiMessageUtils;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object p1

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
