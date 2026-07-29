.class public final Lcom/google/android/material/badge/BadgeState;
.super Ljava/lang/Object;
.source "BadgeState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/material/badge/BadgeState$State;
    }
.end annotation


# static fields
.field private static final BADGE_RESOURCE_TAG:Ljava/lang/String; = "badge"

.field private static final DEFAULT_MAX_BADGE_CHARACTER_COUNT:I = 0x4


# instance fields
.field final badgeRadius:F

.field final badgeWidePadding:F

.field final badgeWithTextRadius:F

.field private final currentState:Lcom/google/android/material/badge/BadgeState$State;

.field private final overridingState:Lcom/google/android/material/badge/BadgeState$State;


# direct methods
.method constructor <init>(Landroid/content/Context;IIILcom/google/android/material/badge/BadgeState$State;)V
    .registers 9

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/google/android/material/badge/BadgeState$State;

    invoke-direct {v0}, Lcom/google/android/material/badge/BadgeState$State;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    if-nez p5, :cond_11

    new-instance p5, Lcom/google/android/material/badge/BadgeState$State;

    invoke-direct {p5}, Lcom/google/android/material/badge/BadgeState$State;-><init>()V

    :cond_11
    if-eqz p2, :cond_16

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeResId:I
    invoke-static {p5, p2}, Lcom/google/android/material/badge/BadgeState$State;->access$002(Lcom/google/android/material/badge/BadgeState$State;I)I

    :cond_16
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeResId:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$000(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p2

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/android/material/badge/BadgeState;->generateTypedArray(Landroid/content/Context;III)Landroid/content/res/TypedArray;

    move-result-object p2

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p3

    sget p4, Lcom/google/android/material/R$styleable;->Badge_badgeRadius:I

    sget v1, Lcom/google/android/material/R$dimen;->mtrl_badge_radius:I

    invoke-virtual {p3, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p2, p4, v1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p4

    int-to-float p4, p4

    iput p4, p0, Lcom/google/android/material/badge/BadgeState;->badgeRadius:F

    sget p4, Lcom/google/android/material/R$styleable;->Badge_badgeWidePadding:I

    sget v1, Lcom/google/android/material/R$dimen;->mtrl_badge_long_text_horizontal_padding:I

    invoke-virtual {p3, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p2, p4, v1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p4

    int-to-float p4, p4

    iput p4, p0, Lcom/google/android/material/badge/BadgeState;->badgeWidePadding:F

    sget p4, Lcom/google/android/material/R$styleable;->Badge_badgeWithTextRadius:I

    sget v1, Lcom/google/android/material/R$dimen;->mtrl_badge_with_text_radius:I

    invoke-virtual {p3, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result p3

    invoke-virtual {p2, p4, p3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p3

    int-to-float p3, p3

    iput p3, p0, Lcom/google/android/material/badge/BadgeState;->badgeWithTextRadius:F

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$100(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    const/4 p4, -0x2

    if-ne p3, p4, :cond_59

    const/16 p3, 0xff

    goto :goto_5d

    :cond_59
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$100(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    :goto_5d
    # setter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$102(Lcom/google/android/material/badge/BadgeState$State;I)I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/CharSequence;

    move-result-object p3

    if-nez p3, :cond_6d

    sget p3, Lcom/google/android/material/R$string;->mtrl_badge_numberless_content_description:I

    invoke-virtual {p1, p3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p3

    goto :goto_71

    :cond_6d
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/CharSequence;

    move-result-object p3

    :goto_71
    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$300(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    if-nez p3, :cond_7d

    sget p3, Lcom/google/android/material/R$plurals;->mtrl_badge_content_description:I

    goto :goto_81

    :cond_7d
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$300(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    :goto_81
    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$302(Lcom/google/android/material/badge/BadgeState$State;I)I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$400(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    if-nez p3, :cond_8d

    sget p3, Lcom/google/android/material/R$string;->mtrl_exceed_max_badge_number_content_description:I

    goto :goto_91

    :cond_8d
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$400(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    :goto_91
    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$402(Lcom/google/android/material/badge/BadgeState$State;I)I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Boolean;

    move-result-object p3

    const/4 v1, 0x0

    if-eqz p3, :cond_a8

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Boolean;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p3

    if-eqz p3, :cond_a6

    goto :goto_a8

    :cond_a6
    move p3, v1

    goto :goto_a9

    :cond_a8
    :goto_a8
    const/4 p3, 0x1

    :goto_a9
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p3

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$600(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    if-ne p3, p4, :cond_be

    sget p3, Lcom/google/android/material/R$styleable;->Badge_maxCharacterCount:I

    const/4 v2, 0x4

    invoke-virtual {p2, p3, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p3

    goto :goto_c2

    :cond_be
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$600(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    :goto_c2
    # setter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$602(Lcom/google/android/material/badge/BadgeState$State;I)I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$700(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    if-eq p3, p4, :cond_d3

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$700(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result p3

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$702(Lcom/google/android/material/badge/BadgeState$State;I)I

    goto :goto_e9

    :cond_d3
    sget p3, Lcom/google/android/material/R$styleable;->Badge_number:I

    invoke-virtual {p2, p3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result p3

    if-eqz p3, :cond_e5

    sget p3, Lcom/google/android/material/R$styleable;->Badge_number:I

    invoke-virtual {p2, p3, v1}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p3

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$702(Lcom/google/android/material/badge/BadgeState$State;I)I

    goto :goto_e9

    :cond_e5
    const/4 p3, -0x1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$702(Lcom/google/android/material/badge/BadgeState$State;I)I

    :goto_e9
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$800(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p3

    if-nez p3, :cond_f6

    sget p3, Lcom/google/android/material/R$styleable;->Badge_backgroundColor:I

    invoke-static {p1, p2, p3}, Lcom/google/android/material/badge/BadgeState;->readColorFromAttributes(Landroid/content/Context;Landroid/content/res/TypedArray;I)I

    move-result p3

    goto :goto_fe

    :cond_f6
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$800(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    :goto_fe
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {v0, p3}, Lcom/google/android/material/badge/BadgeState$State;->access$802(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$900(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p3

    if-eqz p3, :cond_113

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$900(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$902(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    goto :goto_13f

    :cond_113
    sget p3, Lcom/google/android/material/R$styleable;->Badge_badgeTextColor:I

    invoke-virtual {p2, p3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result p3

    if-eqz p3, :cond_129

    sget p3, Lcom/google/android/material/R$styleable;->Badge_badgeTextColor:I

    invoke-static {p1, p2, p3}, Lcom/google/android/material/badge/BadgeState;->readColorFromAttributes(Landroid/content/Context;Landroid/content/res/TypedArray;I)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$902(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    goto :goto_13f

    :cond_129
    new-instance p3, Lcom/google/android/material/resources/TextAppearance;

    sget p4, Lcom/google/android/material/R$style;->TextAppearance_MaterialComponents_Badge:I

    invoke-direct {p3, p1, p4}, Lcom/google/android/material/resources/TextAppearance;-><init>(Landroid/content/Context;I)V

    invoke-virtual {p3}, Lcom/google/android/material/resources/TextAppearance;->getTextColor()Landroid/content/res/ColorStateList;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$902(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    :goto_13f
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1000(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_14f

    sget p1, Lcom/google/android/material/R$styleable;->Badge_badgeGravity:I

    const p3, 0x800035

    invoke-virtual {p2, p1, p3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p1

    goto :goto_157

    :cond_14f
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1000(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_157
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1002(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1100(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_16b

    sget p1, Lcom/google/android/material/R$styleable;->Badge_horizontalOffset:I

    invoke-virtual {p2, p1, v1}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result p1

    goto :goto_173

    :cond_16b
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1100(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_173
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1102(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_187

    sget p1, Lcom/google/android/material/R$styleable;->Badge_verticalOffset:I

    invoke-virtual {p2, p1, v1}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result p1

    goto :goto_18f

    :cond_187
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_18f
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1300(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_1ab

    sget p1, Lcom/google/android/material/R$styleable;->Badge_horizontalOffsetWithText:I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1100(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    invoke-virtual {p2, p1, p3}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result p1

    goto :goto_1b3

    :cond_1ab
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1300(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_1b3
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1302(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1400(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_1cf

    sget p1, Lcom/google/android/material/R$styleable;->Badge_verticalOffsetWithText:I

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p3

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    invoke-virtual {p2, p1, p3}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result p1

    goto :goto_1d7

    :cond_1cf
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1400(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_1d7
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1402(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_1e6

    move p1, v1

    goto :goto_1ee

    :cond_1e6
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    :goto_1ee
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1600(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    if-nez p1, :cond_1fc

    goto :goto_204

    :cond_1fc
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1600(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    :goto_204
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1602(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1700(Lcom/google/android/material/badge/BadgeState$State;)Ljava/util/Locale;

    move-result-object p1

    if-nez p1, :cond_21e

    sget-object p1, Ljava/util/Locale$Category;->FORMAT:Ljava/util/Locale$Category;

    invoke-static {p1}, Ljava/util/Locale;->getDefault(Ljava/util/Locale$Category;)Ljava/util/Locale;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1702(Lcom/google/android/material/badge/BadgeState$State;Ljava/util/Locale;)Ljava/util/Locale;

    goto :goto_225

    :cond_21e
    # getter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {p5}, Lcom/google/android/material/badge/BadgeState$State;->access$1700(Lcom/google/android/material/badge/BadgeState$State;)Ljava/util/Locale;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1702(Lcom/google/android/material/badge/BadgeState$State;Ljava/util/Locale;)Ljava/util/Locale;

    :goto_225
    iput-object p5, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    return-void
.end method

.method private generateTypedArray(Landroid/content/Context;III)Landroid/content/res/TypedArray;
    .registers 12

    const/4 v0, 0x0

    if-eqz p2, :cond_f

    const-string v1, "badge"

    invoke-static {p1, p2, v1}, Lcom/google/android/material/drawable/DrawableUtils;->parseDrawableXml(Landroid/content/Context;ILjava/lang/CharSequence;)Landroid/util/AttributeSet;

    move-result-object p2

    invoke-interface {p2}, Landroid/util/AttributeSet;->getStyleAttribute()I

    move-result v1

    move-object v2, p2

    goto :goto_12

    :cond_f
    const/4 p2, 0x0

    move-object v2, p2

    move v1, v0

    :goto_12
    if-nez v1, :cond_16

    move v5, p4

    goto :goto_17

    :cond_16
    move v5, v1

    :goto_17
    sget-object v3, Lcom/google/android/material/R$styleable;->Badge:[I

    new-array v6, v0, [I

    move-object v1, p1

    move v4, p3

    invoke-static/range {v1 .. v6}, Lcom/google/android/material/internal/ThemeEnforcement;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroid/content/res/TypedArray;

    move-result-object p1

    return-object p1
.end method

.method private static readColorFromAttributes(Landroid/content/Context;Landroid/content/res/TypedArray;I)I
    .registers 3

    invoke-static {p0, p1, p2}, Lcom/google/android/material/resources/MaterialResources;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    move-result-object p0

    invoke-virtual {p0}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result p0

    return p0
.end method


# virtual methods
.method clearNumber()V
    .registers 2

    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/google/android/material/badge/BadgeState;->setNumber(I)V

    return-void
.end method

.method getAdditionalHorizontalOffset()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getAdditionalVerticalOffset()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1600(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getAlpha()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$100(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    return v0
.end method

.method getBackgroundColor()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$800(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getBadgeGravity()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1000(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getBadgeTextColor()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$900(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getContentDescriptionExceedsMaxBadgeNumberStringResource()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$400(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    return v0
.end method

.method getContentDescriptionNumberless()Ljava/lang/CharSequence;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method getContentDescriptionQuantityStrings()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$300(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    return v0
.end method

.method getHorizontalOffsetWithText()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1300(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getHorizontalOffsetWithoutText()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1100(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getMaxCharacterCount()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$600(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    return v0
.end method

.method getNumber()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$700(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    return v0
.end method

.method getNumberLocale()Ljava/util/Locale;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1700(Lcom/google/android/material/badge/BadgeState$State;)Ljava/util/Locale;

    move-result-object v0

    return-object v0
.end method

.method getOverridingState()Lcom/google/android/material/badge/BadgeState$State;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    return-object v0
.end method

.method getVerticalOffsetWithText()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1400(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getVerticalOffsetWithoutText()I
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$1200(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method hasNumber()Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$700(Lcom/google/android/material/badge/BadgeState$State;)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_b

    const/4 v0, 0x1

    goto :goto_c

    :cond_b
    const/4 v0, 0x0

    :goto_c
    return v0
.end method

.method isVisible()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # getter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {v0}, Lcom/google/android/material/badge/BadgeState$State;->access$500(Lcom/google/android/material/badge/BadgeState$State;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method setAdditionalHorizontalOffset(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalHorizontalOffset:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setAdditionalVerticalOffset(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1602(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->additionalVerticalOffset:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1602(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setAlpha(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$102(Lcom/google/android/material/badge/BadgeState$State;I)I

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->alpha:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$102(Lcom/google/android/material/badge/BadgeState$State;I)I

    return-void
.end method

.method setBackgroundColor(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$802(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->backgroundColor:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$802(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setBadgeGravity(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1002(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeGravity:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1002(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setBadgeTextColor(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$902(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->badgeTextColor:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$902(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setContentDescriptionExceedsMaxBadgeNumberStringResource(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$402(Lcom/google/android/material/badge/BadgeState$State;I)I

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionExceedsMaxBadgeNumberRes:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$402(Lcom/google/android/material/badge/BadgeState$State;I)I

    return-void
.end method

.method setContentDescriptionNumberless(Ljava/lang/CharSequence;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionNumberless:Ljava/lang/CharSequence;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    return-void
.end method

.method setContentDescriptionQuantityStringsResource(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$302(Lcom/google/android/material/badge/BadgeState$State;I)I

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->contentDescriptionQuantityStrings:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$302(Lcom/google/android/material/badge/BadgeState$State;I)I

    return-void
.end method

.method setHorizontalOffsetWithText(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1302(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1302(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setHorizontalOffsetWithoutText(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1102(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->horizontalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1102(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setMaxCharacterCount(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$602(Lcom/google/android/material/badge/BadgeState$State;I)I

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->maxCharacterCount:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$602(Lcom/google/android/material/badge/BadgeState$State;I)I

    return-void
.end method

.method setNumber(I)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$702(Lcom/google/android/material/badge/BadgeState$State;I)I

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->number:I
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$702(Lcom/google/android/material/badge/BadgeState$State;I)I

    return-void
.end method

.method setNumberLocale(Ljava/util/Locale;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1702(Lcom/google/android/material/badge/BadgeState$State;Ljava/util/Locale;)Ljava/util/Locale;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->numberLocale:Ljava/util/Locale;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1702(Lcom/google/android/material/badge/BadgeState$State;Ljava/util/Locale;)Ljava/util/Locale;

    return-void
.end method

.method setVerticalOffsetWithText(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1402(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1402(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setVerticalOffsetWithoutText(I)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$1202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->verticalOffsetWithoutText:Ljava/lang/Integer;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$1202(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Integer;)Ljava/lang/Integer;

    return-void
.end method

.method setVisible(Z)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->overridingState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {v0, v1}, Lcom/google/android/material/badge/BadgeState$State;->access$502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    iget-object v0, p0, Lcom/google/android/material/badge/BadgeState;->currentState:Lcom/google/android/material/badge/BadgeState$State;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    # setter for: Lcom/google/android/material/badge/BadgeState$State;->isVisible:Ljava/lang/Boolean;
    invoke-static {v0, p1}, Lcom/google/android/material/badge/BadgeState$State;->access$502(Lcom/google/android/material/badge/BadgeState$State;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    return-void
.end method
