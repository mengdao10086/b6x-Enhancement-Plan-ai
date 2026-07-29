.class Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;
.super Landroid/text/style/TypefaceSpan;
.source "SpanUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/SpanUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CustomTypefaceSpan"
.end annotation


# instance fields
.field private final newType:Landroid/graphics/Typeface;


# direct methods
.method private constructor <init>(Landroid/graphics/Typeface;)V
    .registers 3

    const-string v0, ""

    invoke-direct {p0, v0}, Landroid/text/style/TypefaceSpan;-><init>(Ljava/lang/String;)V

    iput-object p1, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;->newType:Landroid/graphics/Typeface;

    return-void
.end method

.method synthetic constructor <init>(Landroid/graphics/Typeface;Lcom/blankj/utilcode/util/SpanUtils$1;)V
    .registers 3

    invoke-direct {p0, p1}, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;-><init>(Landroid/graphics/Typeface;)V

    return-void
.end method

.method private apply(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V
    .registers 5

    invoke-virtual {p1}, Landroid/graphics/Paint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v0

    if-nez v0, :cond_8

    const/4 v0, 0x0

    goto :goto_c

    :cond_8
    invoke-virtual {v0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v0

    :goto_c
    invoke-virtual {p2}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    not-int v1, v1

    and-int/2addr v0, v1

    and-int/lit8 v1, v0, 0x1

    if-eqz v1, :cond_1a

    const/4 v1, 0x1

    invoke-virtual {p1, v1}, Landroid/graphics/Paint;->setFakeBoldText(Z)V

    :cond_1a
    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_23

    const/high16 v0, -0x41800000    # -0.25f

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setTextSkewX(F)V

    :cond_23
    invoke-virtual {p1}, Landroid/graphics/Paint;->getShader()Landroid/graphics/Shader;

    invoke-virtual {p1, p2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    return-void
.end method


# virtual methods
.method public updateDrawState(Landroid/text/TextPaint;)V
    .registers 3

    iget-object v0, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;->newType:Landroid/graphics/Typeface;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;->apply(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    return-void
.end method

.method public updateMeasureState(Landroid/text/TextPaint;)V
    .registers 3

    iget-object v0, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;->newType:Landroid/graphics/Typeface;

    invoke-direct {p0, p1, v0}, Lcom/blankj/utilcode/util/SpanUtils$CustomTypefaceSpan;->apply(Landroid/graphics/Paint;Landroid/graphics/Typeface;)V

    return-void
.end method
