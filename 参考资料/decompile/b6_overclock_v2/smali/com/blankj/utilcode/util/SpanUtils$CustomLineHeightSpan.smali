.class Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;
.super Ljava/lang/Object;
.source "SpanUtils.java"

# interfaces
.implements Landroid/text/style/LineHeightSpan;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/blankj/utilcode/util/SpanUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "CustomLineHeightSpan"
.end annotation


# static fields
.field static final ALIGN_CENTER:I = 0x2

.field static final ALIGN_TOP:I = 0x3

.field static sfm:Landroid/graphics/Paint$FontMetricsInt;


# instance fields
.field private final height:I

.field final mVerticalAlignment:I


# direct methods
.method constructor <init>(II)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->height:I

    iput p2, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->mVerticalAlignment:I

    return-void
.end method


# virtual methods
.method public chooseHeight(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V
    .registers 10

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    if-nez p2, :cond_28

    new-instance p2, Landroid/graphics/Paint$FontMetricsInt;

    invoke-direct {p2}, Landroid/graphics/Paint$FontMetricsInt;-><init>()V

    sput-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    iput v0, p2, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput v0, p2, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iput v0, p2, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    iput v0, p2, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->leading:I

    iput v0, p2, Landroid/graphics/Paint$FontMetricsInt;->leading:I

    goto :goto_44

    :cond_28
    iget p2, p2, Landroid/graphics/Paint$FontMetricsInt;->top:I

    iput p2, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget p2, p2, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput p2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget p2, p2, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iput p2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget p2, p2, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    iput p2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    sget-object p2, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    iget p2, p2, Landroid/graphics/Paint$FontMetricsInt;->leading:I

    iput p2, p6, Landroid/graphics/Paint$FontMetricsInt;->leading:I

    :goto_44
    iget p2, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->height:I

    iget v0, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr v0, p5

    iget v1, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v0, v1

    sub-int/2addr v0, p4

    sub-int/2addr p2, v0

    const/4 v0, 0x3

    const/4 v1, 0x2

    if-lez p2, :cond_6f

    iget v2, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->mVerticalAlignment:I

    if-ne v2, v0, :cond_5c

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr v2, p2

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    goto :goto_6f

    :cond_5c
    if-ne v2, v1, :cond_6a

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    div-int/2addr p2, v1

    add-int/2addr v2, p2

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v2, p2

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    goto :goto_6f

    :cond_6a
    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v2, p2

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    :cond_6f
    :goto_6f
    iget p2, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->height:I

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr p5, v2

    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p5, v2

    sub-int/2addr p5, p4

    sub-int/2addr p2, p5

    if-lez p2, :cond_98

    iget p4, p0, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->mVerticalAlignment:I

    if-ne p4, v0, :cond_85

    iget p4, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr p4, p2

    iput p4, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    goto :goto_98

    :cond_85
    if-ne p4, v1, :cond_93

    iget p4, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    div-int/2addr p2, v1

    add-int/2addr p4, p2

    iput p4, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    iget p4, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p4, p2

    iput p4, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    goto :goto_98

    :cond_93
    iget p4, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p4, p2

    iput p4, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    :cond_98
    :goto_98
    check-cast p1, Landroid/text/Spanned;

    invoke-interface {p1, p0}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result p1

    if-ne p3, p1, :cond_a3

    const/4 p1, 0x0

    sput-object p1, Lcom/blankj/utilcode/util/SpanUtils$CustomLineHeightSpan;->sfm:Landroid/graphics/Paint$FontMetricsInt;

    :cond_a3
    return-void
.end method
