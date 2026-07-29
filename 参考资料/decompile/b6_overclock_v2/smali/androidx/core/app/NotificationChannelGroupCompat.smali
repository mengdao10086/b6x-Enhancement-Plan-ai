.class public Landroidx/core/app/NotificationChannelGroupCompat;
.super Ljava/lang/Object;
.source "NotificationChannelGroupCompat.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/NotificationChannelGroupCompat$Builder;
    }
.end annotation


# instance fields
.field private mBlocked:Z

.field private mChannels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/core/app/NotificationChannelCompat;",
            ">;"
        }
    .end annotation
.end field

.field mDescription:Ljava/lang/String;

.field final mId:Ljava/lang/String;

.field mName:Ljava/lang/CharSequence;


# direct methods
.method constructor <init>(Landroid/app/NotificationChannelGroup;)V
    .registers 3

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Landroidx/core/app/NotificationChannelGroupCompat;-><init>(Landroid/app/NotificationChannelGroup;Ljava/util/List;)V

    return-void
.end method

.method constructor <init>(Landroid/app/NotificationChannelGroup;Ljava/util/List;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/NotificationChannelGroup;",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannel;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p1}, Landroid/app/NotificationChannelGroup;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/core/app/NotificationChannelGroupCompat;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/app/NotificationChannelGroup;->getName()Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mName:Ljava/lang/CharSequence;

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_19

    invoke-virtual {p1}, Landroid/app/NotificationChannelGroup;->getDescription()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mDescription:Ljava/lang/String;

    :cond_19
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v1, :cond_2e

    invoke-virtual {p1}, Landroid/app/NotificationChannelGroup;->isBlocked()Z

    move-result p2

    iput-boolean p2, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mBlocked:Z

    invoke-virtual {p1}, Landroid/app/NotificationChannelGroup;->getChannels()Ljava/util/List;

    move-result-object p1

    invoke-direct {p0, p1}, Landroidx/core/app/NotificationChannelGroupCompat;->getChannelsCompat(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mChannels:Ljava/util/List;

    goto :goto_34

    :cond_2e
    invoke-direct {p0, p2}, Landroidx/core/app/NotificationChannelGroupCompat;->getChannelsCompat(Ljava/util/List;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mChannels:Ljava/util/List;

    :goto_34
    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mChannels:Ljava/util/List;

    invoke-static {p1}, Landroidx/core/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iput-object p1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mId:Ljava/lang/String;

    return-void
.end method

.method private getChannelsCompat(Ljava/util/List;)Ljava/util/List;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/app/NotificationChannel;",
            ">;)",
            "Ljava/util/List<",
            "Landroidx/core/app/NotificationChannelCompat;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_9
    :goto_9
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2a

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationChannel;

    iget-object v2, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mId:Ljava/lang/String;

    invoke-virtual {v1}, Landroid/app/NotificationChannel;->getGroup()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    new-instance v2, Landroidx/core/app/NotificationChannelCompat;

    invoke-direct {v2, v1}, Landroidx/core/app/NotificationChannelCompat;-><init>(Landroid/app/NotificationChannel;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_9

    :cond_2a
    return-object v0
.end method


# virtual methods
.method public getChannels()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/core/app/NotificationChannelCompat;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mChannels:Ljava/util/List;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mName:Ljava/lang/CharSequence;

    return-object v0
.end method

.method getNotificationChannelGroup()Landroid/app/NotificationChannelGroup;
    .registers 4

    new-instance v0, Landroid/app/NotificationChannelGroup;

    iget-object v1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mId:Ljava/lang/String;

    iget-object v2, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mName:Ljava/lang/CharSequence;

    invoke-direct {v0, v1, v2}, Landroid/app/NotificationChannelGroup;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;)V

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_14

    iget-object v1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mDescription:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/app/NotificationChannelGroup;->setDescription(Ljava/lang/String;)V

    :cond_14
    return-object v0
.end method

.method public isBlocked()Z
    .registers 2

    iget-boolean v0, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mBlocked:Z

    return v0
.end method

.method public toBuilder()Landroidx/core/app/NotificationChannelGroupCompat$Builder;
    .registers 3

    new-instance v0, Landroidx/core/app/NotificationChannelGroupCompat$Builder;

    iget-object v1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mId:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroidx/core/app/NotificationChannelGroupCompat$Builder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mName:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroidx/core/app/NotificationChannelGroupCompat$Builder;->setName(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationChannelGroupCompat$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/core/app/NotificationChannelGroupCompat;->mDescription:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroidx/core/app/NotificationChannelGroupCompat$Builder;->setDescription(Ljava/lang/String;)Landroidx/core/app/NotificationChannelGroupCompat$Builder;

    move-result-object v0

    return-object v0
.end method
