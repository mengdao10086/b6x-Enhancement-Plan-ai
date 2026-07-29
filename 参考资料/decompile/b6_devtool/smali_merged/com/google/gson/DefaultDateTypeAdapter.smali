.class final Lcom/google/gson/DefaultDateTypeAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "DefaultDateTypeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/gson/TypeAdapter<",
        "Ljava/util/Date;",
        ">;"
    }
.end annotation


# static fields
.field private static final SIMPLE_NAME:Ljava/lang/String; = "DefaultDateTypeAdapter"


# instance fields
.field private final dateFormats:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/text/DateFormat;",
            ">;"
        }
    .end annotation
.end field

.field private final dateType:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(II)V
    .registers 4

    .line 87
    const-class v0, Ljava/util/Date;

    invoke-direct {p0, v0, p1, p2}, Lcom/google/gson/DefaultDateTypeAdapter;-><init>(Ljava/lang/Class;II)V

    return-void
.end method

.method constructor <init>(Ljava/lang/Class;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;)V"
        }
    .end annotation

    .line 56
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    .line 57
    invoke-static {p1}, Lcom/google/gson/DefaultDateTypeAdapter;->verifyDateType(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object p1

    iput-object p1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateType:Ljava/lang/Class;

    .line 58
    sget-object p1, Ljava/util/Locale;->US:Ljava/util/Locale;

    const/4 v1, 0x2

    invoke-static {v1, v1, p1}, Ljava/text/DateFormat;->getDateTimeInstance(IILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 59
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v2}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2d

    .line 60
    invoke-static {v1, v1}, Ljava/text/DateFormat;->getDateTimeInstance(II)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 62
    :cond_2d
    invoke-static {}, Lcom/google/gson/internal/JavaVersion;->isJava9OrLater()Z

    move-result p1

    if-eqz p1, :cond_3a

    .line 63
    invoke-static {v1, v1}, Lcom/google/gson/internal/PreJava9DateFormatProvider;->getUSDateTimeFormat(II)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_3a
    return-void
.end method

.method constructor <init>(Ljava/lang/Class;I)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;I)V"
        }
    .end annotation

    .line 75
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    .line 76
    invoke-static {p1}, Lcom/google/gson/DefaultDateTypeAdapter;->verifyDateType(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object p1

    iput-object p1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateType:Ljava/lang/Class;

    .line 77
    sget-object p1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-static {p2, p1}, Ljava/text/DateFormat;->getDateInstance(ILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2c

    .line 79
    invoke-static {p2}, Ljava/text/DateFormat;->getDateInstance(I)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 81
    :cond_2c
    invoke-static {}, Lcom/google/gson/internal/JavaVersion;->isJava9OrLater()Z

    move-result p1

    if-eqz p1, :cond_39

    .line 82
    invoke-static {p2}, Lcom/google/gson/internal/PreJava9DateFormatProvider;->getUSDateFormat(I)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_39
    return-void
.end method

.method public constructor <init>(Ljava/lang/Class;II)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;II)V"
        }
    .end annotation

    .line 90
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    .line 91
    invoke-static {p1}, Lcom/google/gson/DefaultDateTypeAdapter;->verifyDateType(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object p1

    iput-object p1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateType:Ljava/lang/Class;

    .line 92
    sget-object p1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-static {p2, p3, p1}, Ljava/text/DateFormat;->getDateTimeInstance(IILjava/util/Locale;)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2c

    .line 94
    invoke-static {p2, p3}, Ljava/text/DateFormat;->getDateTimeInstance(II)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 96
    :cond_2c
    invoke-static {}, Lcom/google/gson/internal/JavaVersion;->isJava9OrLater()Z

    move-result p1

    if-eqz p1, :cond_39

    .line 97
    invoke-static {p2, p3}, Lcom/google/gson/internal/PreJava9DateFormatProvider;->getUSDateTimeFormat(II)Ljava/text/DateFormat;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_39
    return-void
.end method

.method constructor <init>(Ljava/lang/Class;Ljava/lang/String;)V
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 67
    invoke-direct {p0}, Lcom/google/gson/TypeAdapter;-><init>()V

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    .line 68
    invoke-static {p1}, Lcom/google/gson/DefaultDateTypeAdapter;->verifyDateType(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object p1

    iput-object p1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateType:Ljava/lang/Class;

    .line 69
    new-instance p1, Ljava/text/SimpleDateFormat;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {p1, p2, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 70
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p1

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_2e

    .line 71
    new-instance p1, Ljava/text/SimpleDateFormat;

    invoke-direct {p1, p2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_2e
    return-void
.end method

.method private deserializeToDate(Ljava/lang/String;)Ljava/util/Date;
    .registers 5

    .line 142
    iget-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    monitor-enter v0

    .line 143
    :try_start_3
    iget-object v1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :catch_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/text/DateFormat;
    :try_end_15
    .catchall {:try_start_3 .. :try_end_15} :catchall_2e

    .line 145
    :try_start_15
    invoke-virtual {v2, p1}, Ljava/text/DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object p1
    :try_end_19
    .catch Ljava/text/ParseException; {:try_start_15 .. :try_end_19} :catch_9
    .catchall {:try_start_15 .. :try_end_19} :catchall_2e

    :try_start_19
    monitor-exit v0
    :try_end_1a
    .catchall {:try_start_19 .. :try_end_1a} :catchall_2e

    return-object p1

    .line 149
    :cond_1b
    :try_start_1b
    new-instance v1, Ljava/text/ParsePosition;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Ljava/text/ParsePosition;-><init>(I)V

    invoke-static {p1, v1}, Lcom/google/gson/internal/bind/util/ISO8601Utils;->parse(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;

    move-result-object p1
    :try_end_25
    .catch Ljava/text/ParseException; {:try_start_1b .. :try_end_25} :catch_27
    .catchall {:try_start_1b .. :try_end_25} :catchall_2e

    :try_start_25
    monitor-exit v0

    return-object p1

    :catch_27
    move-exception v1

    .line 151
    new-instance v2, Lcom/google/gson/JsonSyntaxException;

    invoke-direct {v2, p1, v1}, Lcom/google/gson/JsonSyntaxException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    :catchall_2e
    move-exception p1

    .line 153
    monitor-exit v0
    :try_end_30
    .catchall {:try_start_25 .. :try_end_30} :catchall_2e

    throw p1
.end method

.method private static verifyDateType(Ljava/lang/Class;)Ljava/lang/Class;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;)",
            "Ljava/lang/Class<",
            "+",
            "Ljava/util/Date;",
            ">;"
        }
    .end annotation

    .line 102
    const-class v0, Ljava/util/Date;

    if-eq p0, v0, :cond_46

    const-class v0, Ljava/sql/Date;

    if-eq p0, v0, :cond_46

    const-class v0, Ljava/sql/Timestamp;

    if-ne p0, v0, :cond_d

    goto :goto_46

    .line 103
    :cond_d
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Date type must be one of "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-class v2, Ljava/util/Date;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-class v2, Ljava/sql/Timestamp;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", or "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-class v2, Ljava/sql/Date;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " but was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_46
    :goto_46
    return-object p0
.end method


# virtual methods
.method public bridge synthetic read(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 44
    invoke-virtual {p0, p1}, Lcom/google/gson/DefaultDateTypeAdapter;->read(Lcom/google/gson/stream/JsonReader;)Ljava/util/Date;

    move-result-object p1

    return-object p1
.end method

.method public read(Lcom/google/gson/stream/JsonReader;)Ljava/util/Date;
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 124
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;

    move-result-object v0

    sget-object v1, Lcom/google/gson/stream/JsonToken;->NULL:Lcom/google/gson/stream/JsonToken;

    if-ne v0, v1, :cond_d

    .line 125
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->nextNull()V

    const/4 p1, 0x0

    return-object p1

    .line 128
    :cond_d
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonReader;->nextString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/google/gson/DefaultDateTypeAdapter;->deserializeToDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object p1

    .line 129
    iget-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateType:Ljava/lang/Class;

    const-class v1, Ljava/util/Date;

    if-ne v0, v1, :cond_1c

    return-object p1

    .line 131
    :cond_1c
    const-class v1, Ljava/sql/Timestamp;

    if-ne v0, v1, :cond_2a

    .line 132
    new-instance v0, Ljava/sql/Timestamp;

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/sql/Timestamp;-><init>(J)V

    return-object v0

    .line 133
    :cond_2a
    const-class v1, Ljava/sql/Date;

    if-ne v0, v1, :cond_38

    .line 134
    new-instance v0, Ljava/sql/Date;

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v1

    invoke-direct {v0, v1, v2}, Ljava/sql/Date;-><init>(J)V

    return-object v0

    .line 137
    :cond_38
    new-instance p1, Ljava/lang/AssertionError;

    invoke-direct {p1}, Ljava/lang/AssertionError;-><init>()V

    throw p1
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .line 158
    iget-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/text/DateFormat;

    .line 159
    instance-of v1, v0, Ljava/text/SimpleDateFormat;

    const/16 v2, 0x29

    const-string v3, "DefaultDateTypeAdapter("

    if-eqz v1, :cond_29

    .line 160
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    check-cast v0, Ljava/text/SimpleDateFormat;

    invoke-virtual {v0}, Ljava/text/SimpleDateFormat;->toPattern()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 162
    :cond_29
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic write(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 44
    check-cast p2, Ljava/util/Date;

    invoke-virtual {p0, p1, p2}, Lcom/google/gson/DefaultDateTypeAdapter;->write(Lcom/google/gson/stream/JsonWriter;Ljava/util/Date;)V

    return-void
.end method

.method public write(Lcom/google/gson/stream/JsonWriter;Ljava/util/Date;)V
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p2, :cond_6

    .line 113
    invoke-virtual {p1}, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;

    return-void

    .line 116
    :cond_6
    iget-object v0, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    monitor-enter v0

    .line 117
    :try_start_9
    iget-object v1, p0, Lcom/google/gson/DefaultDateTypeAdapter;->dateFormats:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/text/DateFormat;

    invoke-virtual {v1, p2}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p2

    .line 118
    invoke-virtual {p1, p2}, Lcom/google/gson/stream/JsonWriter;->value(Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;

    .line 119
    monitor-exit v0

    return-void

    :catchall_1b
    move-exception p1

    monitor-exit v0
    :try_end_1d
    .catchall {:try_start_9 .. :try_end_1d} :catchall_1b

    throw p1
.end method
