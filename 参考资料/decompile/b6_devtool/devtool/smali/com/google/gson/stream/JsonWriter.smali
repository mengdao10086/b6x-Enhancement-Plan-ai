.class public Lcom/google/gson/stream/JsonWriter;
.super Ljava/lang/Object;
.source "JsonWriter.java"

# interfaces
.implements Ljava/io/Closeable;
.implements Ljava/io/Flushable;


# static fields
.field private static final HTML_SAFE_REPLACEMENT_CHARS:[Ljava/lang/String;

.field private static final REPLACEMENT_CHARS:[Ljava/lang/String;


# instance fields
.field private deferredName:Ljava/lang/String;

.field private htmlSafe:Z

.field private indent:Ljava/lang/String;

.field private lenient:Z

.field private final out:Ljava/io/Writer;

.field private separator:Ljava/lang/String;

.field private serializeNulls:Z

.field private stack:[I

.field private stackSize:I


# direct methods
.method static constructor <clinit>()V
    .registers 5

    const/16 v0, 0x80

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lcom/google/gson/stream/JsonWriter;->REPLACEMENT_CHARS:[Ljava/lang/String;

    const/4 v0, 0x0

    move v1, v0

    :goto_8
    const/16 v2, 0x1f

    if-gt v1, v2, :cond_22

    sget-object v2, Lcom/google/gson/stream/JsonWriter;->REPLACEMENT_CHARS:[Ljava/lang/String;

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const-string v4, "\\u%04x"

    invoke-static {v4, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    :cond_22
    sget-object v0, Lcom/google/gson/stream/JsonWriter;->REPLACEMENT_CHARS:[Ljava/lang/String;

    const/16 v1, 0x22

    const-string v2, "\\\""

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    const-string v2, "\\\\"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "\\t"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "\\b"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "\\n"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "\\r"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "\\f"

    aput-object v2, v0, v1

    invoke-virtual {v0}, [Ljava/lang/String;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    sput-object v0, Lcom/google/gson/stream/JsonWriter;->HTML_SAFE_REPLACEMENT_CHARS:[Ljava/lang/String;

    const/16 v1, 0x3c

    const-string v2, "\\u003c"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "\\u003e"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "\\u0026"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "\\u003d"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "\\u0027"

    aput-object v2, v0, v1

    return-void
.end method

.method public constructor <init>(Ljava/io/Writer;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/16 v0, 0x20

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    const/4 v0, 0x6

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonWriter;->push(I)V

    const-string v0, ":"

    iput-object v0, p0, Lcom/google/gson/stream/JsonWriter;->separator:Ljava/lang/String;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->serializeNulls:Z

    if-eqz p1, :cond_1c

    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    return-void

    :cond_1c
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "out == null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private beforeName()V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->peek()I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_f

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    const/16 v1, 0x2c

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(I)V

    goto :goto_12

    :cond_f
    const/4 v1, 0x3

    if-ne v0, v1, :cond_1a

    :goto_12
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->newline()V

    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonWriter;->replaceTop(I)V

    return-void

    :cond_1a
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Nesting problem."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private beforeValue()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->peek()I

    move-result v0

    const/4 v1, 0x1

    const/4 v2, 0x2

    if-eq v0, v1, :cond_43

    if-eq v0, v2, :cond_38

    const/4 v1, 0x4

    if-eq v0, v1, :cond_2c

    const/4 v1, 0x6

    const/4 v2, 0x7

    if-eq v0, v1, :cond_28

    if-ne v0, v2, :cond_20

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->lenient:Z

    if-eqz v0, :cond_18

    goto :goto_28

    :cond_18
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "JSON must have only one top-level value."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_20
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Nesting problem."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    :goto_28
    invoke-direct {p0, v2}, Lcom/google/gson/stream/JsonWriter;->replaceTop(I)V

    goto :goto_49

    :cond_2c
    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    iget-object v1, p0, Lcom/google/gson/stream/JsonWriter;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    const/4 v0, 0x5

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonWriter;->replaceTop(I)V

    goto :goto_49

    :cond_38
    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    const/16 v1, 0x2c

    invoke-virtual {v0, v1}, Ljava/io/Writer;->append(C)Ljava/io/Writer;

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->newline()V

    goto :goto_49

    :cond_43
    invoke-direct {p0, v2}, Lcom/google/gson/stream/JsonWriter;->replaceTop(I)V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->newline()V

    :goto_49
    return-void
.end method

.method private close(IILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->peek()I

    move-result v0

    if-eq v0, p2, :cond_11

    if-ne v0, p1, :cond_9

    goto :goto_11

    :cond_9
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Nesting problem."

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_11
    :goto_11
    iget-object p1, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    if-nez p1, :cond_26

    iget p1, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    if-ne v0, p2, :cond_20

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->newline()V

    :cond_20
    iget-object p1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {p1, p3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0

    :cond_26
    new-instance p1, Ljava/lang/IllegalStateException;

    new-instance p2, Ljava/lang/StringBuilder;

    const-string p3, "Dangling name: "

    invoke-direct {p2, p3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object p3, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private newline()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->indent:Ljava/lang/String;

    if-nez v0, :cond_5

    return-void

    :cond_5
    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    const/4 v1, 0x1

    :goto_f
    if-ge v1, v0, :cond_1b

    iget-object v2, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    iget-object v3, p0, Lcom/google/gson/stream/JsonWriter;->indent:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    :cond_1b
    return-void
.end method

.method private open(ILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    invoke-direct {p0, p1}, Lcom/google/gson/stream/JsonWriter;->push(I)V

    iget-object p1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {p1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0
.end method

.method private peek()I
    .registers 3

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    if-eqz v0, :cond_b

    iget-object v1, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    add-int/lit8 v0, v0, -0x1

    aget v0, v1, v0

    return v0

    :cond_b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "JsonWriter is closed."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private push(I)V
    .registers 6

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    iget-object v1, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    array-length v2, v1

    if-ne v0, v2, :cond_11

    mul-int/lit8 v2, v0, 0x2

    new-array v2, v2, [I

    const/4 v3, 0x0

    invoke-static {v1, v3, v2, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v2, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    :cond_11
    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    iget v1, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    aput p1, v0, v1

    return-void
.end method

.method private replaceTop(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    iget v1, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    add-int/lit8 v1, v1, -0x1

    aput p1, v0, v1

    return-void
.end method

.method private string(Ljava/lang/String;)V
    .registers 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->htmlSafe:Z

    if-eqz v0, :cond_7

    sget-object v0, Lcom/google/gson/stream/JsonWriter;->HTML_SAFE_REPLACEMENT_CHARS:[Ljava/lang/String;

    goto :goto_9

    :cond_7
    sget-object v0, Lcom/google/gson/stream/JsonWriter;->REPLACEMENT_CHARS:[Ljava/lang/String;

    :goto_9
    iget-object v1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v3, 0x0

    move v4, v3

    :goto_16
    if-ge v3, v1, :cond_45

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v5

    const/16 v6, 0x80

    if-ge v5, v6, :cond_25

    aget-object v5, v0, v5

    if-nez v5, :cond_32

    goto :goto_42

    :cond_25
    const/16 v6, 0x2028

    if-ne v5, v6, :cond_2c

    const-string v5, "\\u2028"

    goto :goto_32

    :cond_2c
    const/16 v6, 0x2029

    if-ne v5, v6, :cond_42

    const-string v5, "\\u2029"

    :cond_32
    :goto_32
    if-ge v4, v3, :cond_3b

    iget-object v6, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    sub-int v7, v3, v4

    invoke-virtual {v6, p1, v4, v7}, Ljava/io/Writer;->write(Ljava/lang/String;II)V

    :cond_3b
    iget-object v4, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {v4, v5}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    add-int/lit8 v4, v3, 0x1

    :cond_42
    :goto_42
    add-int/lit8 v3, v3, 0x1

    goto :goto_16

    :cond_45
    if-ge v4, v1, :cond_4d

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    sub-int/2addr v1, v4

    invoke-virtual {v0, p1, v4, v1}, Ljava/io/Writer;->write(Ljava/lang/String;II)V

    :cond_4d
    iget-object p1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {p1, v2}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-void
.end method

.method private writeDeferredName()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    if-eqz v0, :cond_f

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeName()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/google/gson/stream/JsonWriter;->string(Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    :cond_f
    return-void
.end method


# virtual methods
.method public beginArray()Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    const/4 v0, 0x1

    const-string v1, "["

    invoke-direct {p0, v0, v1}, Lcom/google/gson/stream/JsonWriter;->open(ILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;

    move-result-object v0

    return-object v0
.end method

.method public beginObject()Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    const/4 v0, 0x3

    const-string v1, "{"

    invoke-direct {p0, v0, v1}, Lcom/google/gson/stream/JsonWriter;->open(ILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->close()V

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    const/4 v1, 0x1

    if-gt v0, v1, :cond_18

    if-ne v0, v1, :cond_14

    iget-object v2, p0, Lcom/google/gson/stream/JsonWriter;->stack:[I

    sub-int/2addr v0, v1

    aget v0, v2, v0

    const/4 v1, 0x7

    if-ne v0, v1, :cond_18

    :cond_14
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    return-void

    :cond_18
    new-instance v0, Ljava/io/IOException;

    const-string v1, "Incomplete document"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public endArray()Lcom/google/gson/stream/JsonWriter;
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x2

    const-string v1, "]"

    const/4 v2, 0x1

    invoke-direct {p0, v2, v0, v1}, Lcom/google/gson/stream/JsonWriter;->close(IILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;

    move-result-object v0

    return-object v0
.end method

.method public endObject()Lcom/google/gson/stream/JsonWriter;
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v0, 0x5

    const-string v1, "}"

    const/4 v2, 0x3

    invoke-direct {p0, v2, v0, v1}, Lcom/google/gson/stream/JsonWriter;->close(IILjava/lang/String;)Lcom/google/gson/stream/JsonWriter;

    move-result-object v0

    return-object v0
.end method

.method public flush()V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {v0}, Ljava/io/Writer;->flush()V

    return-void

    :cond_a
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "JsonWriter is closed."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final getSerializeNulls()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->serializeNulls:Z

    return v0
.end method

.method public final isHtmlSafe()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->htmlSafe:Z

    return v0
.end method

.method public isLenient()Z
    .registers 2

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->lenient:Z

    return v0
.end method

.method public jsonValue(Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_7

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;

    move-result-object p1

    return-object p1

    :cond_7
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {v0, p1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    return-object p0
.end method

.method public name(Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-eqz p1, :cond_1b

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    if-nez v0, :cond_15

    iget v0, p0, Lcom/google/gson/stream/JsonWriter;->stackSize:I

    if-eqz v0, :cond_d

    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    return-object p0

    :cond_d
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "JsonWriter is closed."

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_15
    new-instance p1, Ljava/lang/IllegalStateException;

    invoke-direct {p1}, Ljava/lang/IllegalStateException;-><init>()V

    throw p1

    :cond_1b
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "name == null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public nullValue()Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    if-eqz v0, :cond_10

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->serializeNulls:Z

    if-eqz v0, :cond_c

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    goto :goto_10

    :cond_c
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/gson/stream/JsonWriter;->deferredName:Ljava/lang/String;

    return-object p0

    :cond_10
    :goto_10
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    const-string v1, "null"

    invoke-virtual {v0, v1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0
.end method

.method public final setHtmlSafe(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/gson/stream/JsonWriter;->htmlSafe:Z

    return-void
.end method

.method public final setIndent(Ljava/lang/String;)V
    .registers 3

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_e

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->indent:Ljava/lang/String;

    const-string p1, ":"

    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->separator:Ljava/lang/String;

    goto :goto_14

    :cond_e
    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->indent:Ljava/lang/String;

    const-string p1, ": "

    iput-object p1, p0, Lcom/google/gson/stream/JsonWriter;->separator:Ljava/lang/String;

    :goto_14
    return-void
.end method

.method public final setLenient(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/gson/stream/JsonWriter;->lenient:Z

    return-void
.end method

.method public final setSerializeNulls(Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/gson/stream/JsonWriter;->serializeNulls:Z

    return-void
.end method

.method public value(D)Lcom/google/gson/stream/JsonWriter;
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    iget-boolean v0, p0, Lcom/google/gson/stream/JsonWriter;->lenient:Z

    if-nez v0, :cond_29

    invoke-static {p1, p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_14

    invoke-static {p1, p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-nez v0, :cond_14

    goto :goto_29

    :cond_14
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Numeric values must be finite, but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_29
    :goto_29
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-static {p1, p2}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    return-object p0
.end method

.method public value(J)Lcom/google/gson/stream/JsonWriter;
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0
.end method

.method public value(Ljava/lang/Boolean;)Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_7

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;

    move-result-object p1

    return-object p1

    :cond_7
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    if-eqz p1, :cond_18

    const-string p1, "true"

    goto :goto_1a

    :cond_18
    const-string p1, "false"

    :goto_1a
    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0
.end method

.method public value(Ljava/lang/Number;)Lcom/google/gson/stream/JsonWriter;
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_7

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;

    move-result-object p1

    return-object p1

    :cond_7
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-boolean v1, p0, Lcom/google/gson/stream/JsonWriter;->lenient:Z

    if-nez v1, :cond_40

    const-string v1, "-Infinity"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2b

    const-string v1, "Infinity"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2b

    const-string v1, "NaN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2b

    goto :goto_40

    :cond_2b
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Numeric values must be finite, but was "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_40
    :goto_40
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object p1, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    invoke-virtual {p1, v0}, Ljava/io/Writer;->append(Ljava/lang/CharSequence;)Ljava/io/Writer;

    return-object p0
.end method

.method public value(Ljava/lang/String;)Lcom/google/gson/stream/JsonWriter;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    if-nez p1, :cond_7

    invoke-virtual {p0}, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;

    move-result-object p1

    return-object p1

    :cond_7
    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    invoke-direct {p0, p1}, Lcom/google/gson/stream/JsonWriter;->string(Ljava/lang/String;)V

    return-object p0
.end method

.method public value(Z)Lcom/google/gson/stream/JsonWriter;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->writeDeferredName()V

    invoke-direct {p0}, Lcom/google/gson/stream/JsonWriter;->beforeValue()V

    iget-object v0, p0, Lcom/google/gson/stream/JsonWriter;->out:Ljava/io/Writer;

    if-eqz p1, :cond_d

    const-string p1, "true"

    goto :goto_f

    :cond_d
    const-string p1, "false"

    :goto_f
    invoke-virtual {v0, p1}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    return-object p0
.end method
