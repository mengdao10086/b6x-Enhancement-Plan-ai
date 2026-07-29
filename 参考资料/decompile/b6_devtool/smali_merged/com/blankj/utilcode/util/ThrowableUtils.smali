.class public Lcom/blankj/utilcode/util/ThrowableUtils;
.super Ljava/lang/Object;
.source "ThrowableUtils.java"


# static fields
.field private static final LINE_SEP:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, "line.separator"

    .line 19
    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/ThrowableUtils;->LINE_SEP:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static getFullStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
    .registers 8

    .line 26
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    :goto_5
    if-eqz p0, :cond_15

    .line 27
    invoke-interface {v0, p0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_15

    .line 28
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 29
    invoke-virtual {p0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object p0

    goto :goto_5

    .line 31
    :cond_15
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result p0

    .line 32
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    add-int/lit8 v2, p0, -0x1

    .line 33
    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Throwable;

    invoke-static {v3}, Lcom/blankj/utilcode/util/ThrowableUtils;->getStackFrameList(Ljava/lang/Throwable;)Ljava/util/List;

    move-result-object v3

    :goto_2a
    add-int/lit8 p0, p0, -0x1

    if-ltz p0, :cond_72

    if-eqz p0, :cond_40

    add-int/lit8 v4, p0, -0x1

    .line 37
    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Throwable;

    invoke-static {v4}, Lcom/blankj/utilcode/util/ThrowableUtils;->getStackFrameList(Ljava/lang/Throwable;)Ljava/util/List;

    move-result-object v4

    .line 38
    invoke-static {v3, v4}, Lcom/blankj/utilcode/util/ThrowableUtils;->removeCommonFrames(Ljava/util/List;Ljava/util/List;)V

    goto :goto_41

    :cond_40
    move-object v4, v3

    :goto_41
    if-ne p0, v2, :cond_51

    .line 41
    invoke-interface {v0, p0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Throwable;

    invoke-virtual {v5}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6d

    .line 43
    :cond_51
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, " Caused by: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Throwable;

    invoke-virtual {v6}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 45
    :goto_6d
    invoke-interface {v1, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    move-object v3, v4

    goto :goto_2a

    .line 47
    :cond_72
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    .line 48
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_7b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_91

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 49
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/blankj/utilcode/util/ThrowableUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_7b

    .line 51
    :cond_91
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static getStackFrameList(Ljava/lang/Throwable;)Ljava/util/List;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 55
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 56
    new-instance v1, Ljava/io/PrintWriter;

    const/4 v2, 0x1

    invoke-direct {v1, v0, v2}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;Z)V

    .line 57
    invoke-virtual {p0, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 58
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object p0

    .line 59
    new-instance v0, Ljava/util/StringTokenizer;

    sget-object v1, Lcom/blankj/utilcode/util/ThrowableUtils;->LINE_SEP:Ljava/lang/String;

    invoke-direct {v0, p0, v1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, 0x0

    move v3, v1

    .line 62
    :cond_20
    :goto_20
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v4

    if-eqz v4, :cond_48

    .line 63
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v4

    const-string v5, "at"

    .line 65
    invoke-virtual {v4, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_46

    .line 66
    invoke-virtual {v4, v1, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_46

    .line 68
    invoke-interface {p0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move v3, v2

    goto :goto_20

    :cond_46
    if-eqz v3, :cond_20

    :cond_48
    return-object p0
.end method

.method private static removeCommonFrames(Ljava/util/List;Ljava/util/List;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .line 77
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .line 78
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    :goto_c
    if-ltz v0, :cond_2a

    if-ltz v1, :cond_2a

    .line 82
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 83
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 84
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_25

    .line 85
    invoke-interface {p0, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    :cond_25
    add-int/lit8 v0, v0, -0x1

    add-int/lit8 v1, v1, -0x1

    goto :goto_c

    :cond_2a
    return-void
.end method
