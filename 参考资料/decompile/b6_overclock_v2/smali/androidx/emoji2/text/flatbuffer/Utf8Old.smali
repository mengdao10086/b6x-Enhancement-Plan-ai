.class public Landroidx/emoji2/text/flatbuffer/Utf8Old;
.super Landroidx/emoji2/text/flatbuffer/Utf8;
.source "Utf8Old.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;
    }
.end annotation


# static fields
.field private static final CACHE:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal<",
            "Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/emoji2/text/flatbuffer/Utf8Old$$ExternalSyntheticLambda0;-><init>()V

    invoke-static {v0}, Ljava/lang/ThreadLocal;->withInitial(Ljava/util/function/Supplier;)Ljava/lang/ThreadLocal;

    move-result-object v0

    sput-object v0, Landroidx/emoji2/text/flatbuffer/Utf8Old;->CACHE:Ljava/lang/ThreadLocal;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/emoji2/text/flatbuffer/Utf8;-><init>()V

    return-void
.end method

.method static synthetic lambda$static$0()Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;
    .registers 1

    new-instance v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;

    invoke-direct {v0}, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;-><init>()V

    return-object v0
.end method


# virtual methods
.method public decodeUtf8(Ljava/nio/ByteBuffer;II)Ljava/lang/String;
    .registers 5

    sget-object v0, Landroidx/emoji2/text/flatbuffer/Utf8Old;->CACHE:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;

    iget-object v0, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->decoder:Ljava/nio/charset/CharsetDecoder;

    invoke-virtual {v0}, Ljava/nio/charset/CharsetDecoder;->reset()Ljava/nio/charset/CharsetDecoder;

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->duplicate()Ljava/nio/ByteBuffer;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    add-int/2addr p2, p3

    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    :try_start_18
    invoke-virtual {v0, p1}, Ljava/nio/charset/CharsetDecoder;->decode(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/nio/CharBuffer;->toString()Ljava/lang/String;

    move-result-object p1
    :try_end_20
    .catch Ljava/nio/charset/CharacterCodingException; {:try_start_18 .. :try_end_20} :catch_21

    return-object p1

    :catch_21
    move-exception p1

    new-instance p2, Ljava/lang/IllegalArgumentException;

    const-string p3, "Bad encoding"

    invoke-direct {p2, p3, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw p2
.end method

.method public encodeUtf8(Ljava/lang/CharSequence;Ljava/nio/ByteBuffer;)V
    .registers 5

    sget-object v0, Landroidx/emoji2/text/flatbuffer/Utf8Old;->CACHE:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;

    iget-object v1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastInput:Ljava/lang/CharSequence;

    if-eq v1, p1, :cond_f

    invoke-virtual {p0, p1}, Landroidx/emoji2/text/flatbuffer/Utf8Old;->encodedLength(Ljava/lang/CharSequence;)I

    :cond_f
    iget-object p1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    invoke-virtual {p2, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    return-void
.end method

.method public encodedLength(Ljava/lang/CharSequence;)I
    .registers 6

    sget-object v0, Landroidx/emoji2/text/flatbuffer/Utf8Old;->CACHE:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    int-to-float v1, v1

    iget-object v2, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->encoder:Ljava/nio/charset/CharsetEncoder;

    invoke-virtual {v2}, Ljava/nio/charset/CharsetEncoder;->maxBytesPerChar()F

    move-result v2

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iget-object v2, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    if-eqz v2, :cond_21

    iget-object v2, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v2

    if-ge v2, v1, :cond_2d

    :cond_21
    const/16 v2, 0x80

    invoke-static {v2, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v1

    iput-object v1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    :cond_2d
    iget-object v1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    invoke-virtual {v1}, Ljava/nio/ByteBuffer;->clear()Ljava/nio/Buffer;

    iput-object p1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastInput:Ljava/lang/CharSequence;

    instance-of v1, p1, Ljava/nio/CharBuffer;

    if-eqz v1, :cond_3b

    check-cast p1, Ljava/nio/CharBuffer;

    goto :goto_3f

    :cond_3b
    invoke-static {p1}, Ljava/nio/CharBuffer;->wrap(Ljava/lang/CharSequence;)Ljava/nio/CharBuffer;

    move-result-object p1

    :goto_3f
    iget-object v1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->encoder:Ljava/nio/charset/CharsetEncoder;

    iget-object v2, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    const/4 v3, 0x1

    invoke-virtual {v1, p1, v2, v3}, Ljava/nio/charset/CharsetEncoder;->encode(Ljava/nio/CharBuffer;Ljava/nio/ByteBuffer;Z)Ljava/nio/charset/CoderResult;

    move-result-object p1

    invoke-virtual {p1}, Ljava/nio/charset/CoderResult;->isError()Z

    move-result v1

    if-eqz v1, :cond_5b

    :try_start_4e
    invoke-virtual {p1}, Ljava/nio/charset/CoderResult;->throwException()V
    :try_end_51
    .catch Ljava/nio/charset/CharacterCodingException; {:try_start_4e .. :try_end_51} :catch_52

    goto :goto_5b

    :catch_52
    move-exception p1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "bad character encoding"

    invoke-direct {v0, v1, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0

    :cond_5b
    :goto_5b
    iget-object p1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    iget-object p1, v0, Landroidx/emoji2/text/flatbuffer/Utf8Old$Cache;->lastOutput:Ljava/nio/ByteBuffer;

    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result p1

    return p1
.end method
