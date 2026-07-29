.class public final Landroidx/localbroadcastmanager/content/LocalBroadcastManager;
.super Ljava/lang/Object;
.source "LocalBroadcastManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;,
        Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field static final MSG_EXEC_PENDING_BROADCASTS:I = 0x1

.field private static final TAG:Ljava/lang/String; = "LocalBroadcastManager"

.field private static mInstance:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

.field private static final mLock:Ljava/lang/Object;


# instance fields
.field private final mActions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList<",
            "Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mAppContext:Landroid/content/Context;

.field private final mHandler:Landroid/os/Handler;

.field private final mPendingBroadcasts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;",
            ">;"
        }
    .end annotation
.end field

.field private final mReceivers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Landroid/content/BroadcastReceiver;",
            "Ljava/util/ArrayList<",
            "Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 100
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mLock:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .registers 3

    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    .line 92
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    .line 94
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    .line 114
    iput-object p1, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    .line 115
    new-instance v0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$1;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object p1

    invoke-direct {v0, p0, p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$1;-><init>(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Landroid/os/Looper;)V

    iput-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Landroidx/localbroadcastmanager/content/LocalBroadcastManager;
    .registers 3

    .line 105
    sget-object v0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mLock:Ljava/lang/Object;

    monitor-enter v0

    .line 106
    :try_start_3
    sget-object v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mInstance:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    if-nez v1, :cond_12

    .line 107
    new-instance v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object p0

    invoke-direct {v1, p0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;-><init>(Landroid/content/Context;)V

    sput-object v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mInstance:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    .line 109
    :cond_12
    sget-object p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mInstance:Landroidx/localbroadcastmanager/content/LocalBroadcastManager;

    monitor-exit v0

    return-object p0

    :catchall_16
    move-exception p0

    .line 110
    monitor-exit v0
    :try_end_18
    .catchall {:try_start_3 .. :try_end_18} :catchall_16

    throw p0
.end method


# virtual methods
.method executePendingBroadcasts()V
    .registers 11

    .line 298
    :cond_0
    iget-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v0

    .line 299
    :try_start_3
    iget-object v1, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gtz v1, :cond_d

    .line 301
    monitor-exit v0

    return-void

    .line 303
    :cond_d
    new-array v2, v1, [Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;

    .line 304
    iget-object v3, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 305
    iget-object v3, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V

    .line 306
    monitor-exit v0
    :try_end_1a
    .catchall {:try_start_3 .. :try_end_1a} :catchall_44

    const/4 v0, 0x0

    move v3, v0

    :goto_1c
    if-ge v3, v1, :cond_0

    .line 308
    aget-object v4, v2, v3

    .line 309
    iget-object v5, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    move v6, v0

    :goto_27
    if-ge v6, v5, :cond_41

    .line 311
    iget-object v7, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    .line 312
    iget-boolean v8, v7, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->dead:Z

    if-nez v8, :cond_3e

    .line 313
    iget-object v7, v7, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->receiver:Landroid/content/BroadcastReceiver;

    iget-object v8, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    iget-object v9, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;->intent:Landroid/content/Intent;

    invoke-virtual {v7, v8, v9}, Landroid/content/BroadcastReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    :cond_3e
    add-int/lit8 v6, v6, 0x1

    goto :goto_27

    :cond_41
    add-int/lit8 v3, v3, 0x1

    goto :goto_1c

    :catchall_44
    move-exception v1

    .line 306
    :try_start_45
    monitor-exit v0
    :try_end_46
    .catchall {:try_start_45 .. :try_end_46} :catchall_44

    throw v1
.end method

.method public registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    .registers 9

    .line 140
    iget-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v0

    .line 141
    :try_start_3
    new-instance v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    invoke-direct {v1, p2, p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;-><init>(Landroid/content/IntentFilter;Landroid/content/BroadcastReceiver;)V

    .line 142
    iget-object v2, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    const/4 v3, 0x1

    if-nez v2, :cond_1d

    .line 144
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 145
    iget-object v4, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v4, p1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    :cond_1d
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/4 p1, 0x0

    .line 148
    :goto_21
    invoke-virtual {p2}, Landroid/content/IntentFilter;->countActions()I

    move-result v2

    if-ge p1, v2, :cond_45

    .line 149
    invoke-virtual {p2, p1}, Landroid/content/IntentFilter;->getAction(I)Ljava/lang/String;

    move-result-object v2

    .line 150
    iget-object v4, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v4, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    if-nez v4, :cond_3f

    .line 152
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 153
    iget-object v5, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v5, v2, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    :cond_3f
    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 p1, p1, 0x1

    goto :goto_21

    .line 157
    :cond_45
    monitor-exit v0

    return-void

    :catchall_47
    move-exception p1

    monitor-exit v0
    :try_end_49
    .catchall {:try_start_3 .. :try_end_49} :catchall_47

    throw p1
.end method

.method public sendBroadcast(Landroid/content/Intent;)Z
    .registers 24

    move-object/from16 v1, p0

    move-object/from16 v0, p1

    const-string v2, "Action list: "

    const-string v3, "Resolving type "

    .line 213
    iget-object v4, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v4

    .line 214
    :try_start_b
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v12

    .line 215
    iget-object v5, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mAppContext:Landroid/content/Context;

    .line 216
    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    .line 215
    invoke-virtual {v0, v5}, Landroid/content/Intent;->resolveTypeIfNeeded(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v13

    .line 217
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v14

    .line 218
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getScheme()Ljava/lang/String;

    move-result-object v15

    .line 219
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getCategories()Ljava/util/Set;

    move-result-object v16

    .line 222
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getFlags()I

    move-result v5

    and-int/lit8 v5, v5, 0x8

    const/4 v11, 0x0

    const/4 v10, 0x1

    if-eqz v5, :cond_32

    move/from16 v17, v10

    goto :goto_34

    :cond_32
    move/from16 v17, v11

    :goto_34
    if-eqz v17, :cond_5c

    const-string v5, "LocalBroadcastManager"

    .line 223
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, " scheme "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, " of intent "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    :cond_5c
    iget-object v3, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    if-eqz v3, :cond_173

    if-eqz v17, :cond_7e

    const-string v5, "LocalBroadcastManager"

    .line 229
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7e
    const/4 v2, 0x0

    move v9, v11

    .line 232
    :goto_80
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v9, v5, :cond_142

    .line 233
    invoke-virtual {v3, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    move-object v8, v5

    check-cast v8, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    if-eqz v17, :cond_a9

    const-string v5, "LocalBroadcastManager"

    .line 234
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Matching against filter "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, v8, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 236
    :cond_a9
    iget-boolean v5, v8, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    if-eqz v5, :cond_bf

    if-eqz v17, :cond_b6

    const-string v5, "LocalBroadcastManager"

    const-string v6, "  Filter\'s target already added"

    .line 238
    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_b6
    move-object/from16 v19, v3

    move/from16 v20, v9

    move-object/from16 v21, v12

    move v12, v10

    goto/16 :goto_138

    .line 243
    :cond_bf
    iget-object v5, v8, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    const-string v18, "LocalBroadcastManager"

    move-object v6, v12

    move-object v7, v13

    move-object/from16 v19, v3

    move-object v3, v8

    move-object v8, v15

    move/from16 v20, v9

    move-object v9, v14

    move-object/from16 v21, v12

    move v12, v10

    move-object/from16 v10, v16

    move-object/from16 v11, v18

    invoke-virtual/range {v5 .. v11}, Landroid/content/IntentFilter;->match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Set;Ljava/lang/String;)I

    move-result v5

    if-ltz v5, :cond_104

    if-eqz v17, :cond_f7

    const-string v6, "LocalBroadcastManager"

    .line 246
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "  Filter matched!  match=0x"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 247
    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 246
    invoke-static {v6, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_f7
    if-nez v2, :cond_fe

    .line 249
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 251
    :cond_fe
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 252
    iput-boolean v12, v3, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    goto :goto_138

    :cond_104
    if-eqz v17, :cond_138

    const/4 v3, -0x4

    if-eq v5, v3, :cond_11e

    const/4 v3, -0x3

    if-eq v5, v3, :cond_11b

    const/4 v3, -0x2

    if-eq v5, v3, :cond_118

    const/4 v3, -0x1

    if-eq v5, v3, :cond_115

    const-string v3, "unknown reason"

    goto :goto_120

    :cond_115
    const-string v3, "type"

    goto :goto_120

    :cond_118
    const-string v3, "data"

    goto :goto_120

    :cond_11b
    const-string v3, "action"

    goto :goto_120

    :cond_11e
    const-string v3, "category"

    :goto_120
    const-string v5, "LocalBroadcastManager"

    .line 263
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "  Filter did not match: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v5, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_138
    :goto_138
    add-int/lit8 v9, v20, 0x1

    move v10, v12

    move-object/from16 v3, v19

    move-object/from16 v12, v21

    const/4 v11, 0x0

    goto/16 :goto_80

    :cond_142
    move v12, v10

    if-eqz v2, :cond_171

    const/4 v11, 0x0

    .line 269
    :goto_146
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v11, v3, :cond_158

    .line 270
    invoke-virtual {v2, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    const/4 v5, 0x0

    iput-boolean v5, v3, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->broadcasting:Z

    add-int/lit8 v11, v11, 0x1

    goto :goto_146

    .line 272
    :cond_158
    iget-object v3, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mPendingBroadcasts:Ljava/util/ArrayList;

    new-instance v5, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;

    invoke-direct {v5, v0, v2}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$BroadcastRecord;-><init>(Landroid/content/Intent;Ljava/util/ArrayList;)V

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 273
    iget-object v0, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, v12}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_16f

    .line 274
    iget-object v0, v1, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mHandler:Landroid/os/Handler;

    invoke-virtual {v0, v12}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 276
    :cond_16f
    monitor-exit v4

    return v12

    :cond_171
    const/4 v5, 0x0

    goto :goto_174

    :cond_173
    move v5, v11

    .line 279
    :goto_174
    monitor-exit v4

    return v5

    :catchall_176
    move-exception v0

    monitor-exit v4
    :try_end_178
    .catchall {:try_start_b .. :try_end_178} :catchall_176

    throw v0
.end method

.method public sendBroadcastSync(Landroid/content/Intent;)V
    .registers 2

    .line 289
    invoke-virtual {p0, p1}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    move-result p1

    if-eqz p1, :cond_9

    .line 290
    invoke-virtual {p0}, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->executePendingBroadcasts()V

    :cond_9
    return-void
.end method

.method public unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    .registers 13

    .line 170
    iget-object v0, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    monitor-enter v0

    .line 171
    :try_start_3
    iget-object v1, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mReceivers:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    if-nez v1, :cond_f

    .line 173
    monitor-exit v0

    return-void

    .line 175
    :cond_f
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    :goto_15
    if-ltz v2, :cond_62

    .line 176
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    .line 177
    iput-boolean v3, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->dead:Z

    const/4 v5, 0x0

    .line 178
    :goto_20
    iget-object v6, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    invoke-virtual {v6}, Landroid/content/IntentFilter;->countActions()I

    move-result v6

    if-ge v5, v6, :cond_5f

    .line 179
    iget-object v6, v4, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->filter:Landroid/content/IntentFilter;

    invoke-virtual {v6, v5}, Landroid/content/IntentFilter;->getAction(I)Ljava/lang/String;

    move-result-object v6

    .line 180
    iget-object v7, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v7, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/ArrayList;

    if-eqz v7, :cond_5c

    .line 182
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v8

    sub-int/2addr v8, v3

    :goto_3d
    if-ltz v8, :cond_51

    .line 183
    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;

    .line 184
    iget-object v10, v9, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->receiver:Landroid/content/BroadcastReceiver;

    if-ne v10, p1, :cond_4e

    .line 185
    iput-boolean v3, v9, Landroidx/localbroadcastmanager/content/LocalBroadcastManager$ReceiverRecord;->dead:Z

    .line 186
    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    :cond_4e
    add-int/lit8 v8, v8, -0x1

    goto :goto_3d

    .line 189
    :cond_51
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-gtz v7, :cond_5c

    .line 190
    iget-object v7, p0, Landroidx/localbroadcastmanager/content/LocalBroadcastManager;->mActions:Ljava/util/HashMap;

    invoke-virtual {v7, v6}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5c
    add-int/lit8 v5, v5, 0x1

    goto :goto_20

    :cond_5f
    add-int/lit8 v2, v2, -0x1

    goto :goto_15

    .line 195
    :cond_62
    monitor-exit v0

    return-void

    :catchall_64
    move-exception p1

    monitor-exit v0
    :try_end_66
    .catchall {:try_start_3 .. :try_end_66} :catchall_64

    throw p1
.end method
