.class public interface abstract Landroidx/constraintlayout/core/motion/utils/TypedValues$PositionType;
.super Ljava/lang/Object;
.source "TypedValues.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/motion/utils/TypedValues;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PositionType"
.end annotation


# static fields
.field public static final KEY_WORDS:[Ljava/lang/String;

.field public static final NAME:Ljava/lang/String; = "KeyPosition"

.field public static final S_DRAWPATH:Ljava/lang/String; = "drawPath"

.field public static final S_PERCENT_HEIGHT:Ljava/lang/String; = "percentHeight"

.field public static final S_PERCENT_WIDTH:Ljava/lang/String; = "percentWidth"

.field public static final S_PERCENT_X:Ljava/lang/String; = "percentX"

.field public static final S_PERCENT_Y:Ljava/lang/String; = "percentY"

.field public static final S_SIZE_PERCENT:Ljava/lang/String; = "sizePercent"

.field public static final S_TRANSITION_EASING:Ljava/lang/String; = "transitionEasing"

.field public static final TYPE_CURVE_FIT:I = 0x1fc

.field public static final TYPE_DRAWPATH:I = 0x1f6

.field public static final TYPE_PATH_MOTION_ARC:I = 0x1fd

.field public static final TYPE_PERCENT_HEIGHT:I = 0x1f8

.field public static final TYPE_PERCENT_WIDTH:I = 0x1f7

.field public static final TYPE_PERCENT_X:I = 0x1fa

.field public static final TYPE_PERCENT_Y:I = 0x1fb

.field public static final TYPE_POSITION_TYPE:I = 0x1fe

.field public static final TYPE_SIZE_PERCENT:I = 0x1f9

.field public static final TYPE_TRANSITION_EASING:I = 0x1f5


# direct methods
.method static constructor <clinit>()V
    .registers 7

    const-string v0, "transitionEasing"

    const-string v1, "drawPath"

    const-string v2, "percentWidth"

    const-string v3, "percentHeight"

    const-string v4, "sizePercent"

    const-string v5, "percentX"

    const-string v6, "percentY"

    .line 474
    filled-new-array/range {v0 .. v6}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/constraintlayout/core/motion/utils/TypedValues$PositionType;->KEY_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public static getId(Ljava/lang/String;)I
    .registers 3

    .line 492
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_72

    :goto_b
    move p0, v1

    goto :goto_59

    :sswitch_d
    const-string v0, "percentY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_16

    goto :goto_b

    :cond_16
    const/4 p0, 0x6

    goto :goto_59

    :sswitch_18
    const-string v0, "percentX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_21

    goto :goto_b

    :cond_21
    const/4 p0, 0x5

    goto :goto_59

    :sswitch_23
    const-string v0, "sizePercent"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2c

    goto :goto_b

    :cond_2c
    const/4 p0, 0x4

    goto :goto_59

    :sswitch_2e
    const-string v0, "drawPath"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_37

    goto :goto_b

    :cond_37
    const/4 p0, 0x3

    goto :goto_59

    :sswitch_39
    const-string v0, "percentHeight"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_42

    goto :goto_b

    :cond_42
    const/4 p0, 0x2

    goto :goto_59

    :sswitch_44
    const-string v0, "percentWidth"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_4d

    goto :goto_b

    :cond_4d
    const/4 p0, 0x1

    goto :goto_59

    :sswitch_4f
    const-string v0, "transitionEasing"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_58

    goto :goto_b

    :cond_58
    const/4 p0, 0x0

    :goto_59
    packed-switch p0, :pswitch_data_90

    return v1

    :pswitch_5d
    const/16 p0, 0x1fb

    return p0

    :pswitch_60
    const/16 p0, 0x1fa

    return p0

    :pswitch_63
    const/16 p0, 0x1f9

    return p0

    :pswitch_66
    const/16 p0, 0x1f6

    return p0

    :pswitch_69
    const/16 p0, 0x1f8

    return p0

    :pswitch_6c
    const/16 p0, 0x1f7

    return p0

    :pswitch_6f
    const/16 p0, 0x1f5

    return p0

    :sswitch_data_72
    .sparse-switch
        -0x6c0d7d20 -> :sswitch_4f
        -0x4330437f -> :sswitch_44
        -0x3ca72634 -> :sswitch_39
        -0x314b3c77 -> :sswitch_2e
        -0xbefb6fc -> :sswitch_23
        0x198424b3 -> :sswitch_18
        0x198424b4 -> :sswitch_d
    .end sparse-switch

    :pswitch_data_90
    .packed-switch 0x0
        :pswitch_6f
        :pswitch_6c
        :pswitch_69
        :pswitch_66
        :pswitch_63
        :pswitch_60
        :pswitch_5d
    .end packed-switch
.end method

.method public static getType(I)I
    .registers 2

    const/16 v0, 0x64

    if-eq p0, v0, :cond_12

    const/16 v0, 0x65

    if-eq p0, v0, :cond_f

    packed-switch p0, :pswitch_data_14

    const/4 p0, -0x1

    return p0

    :pswitch_d
    const/4 p0, 0x4

    return p0

    :cond_f
    :pswitch_f
    const/16 p0, 0x8

    return p0

    :cond_12
    :pswitch_12
    const/4 p0, 0x2

    return p0

    :pswitch_data_14
    .packed-switch 0x1f5
        :pswitch_f
        :pswitch_f
        :pswitch_d
        :pswitch_d
        :pswitch_d
        :pswitch_d
        :pswitch_d
        :pswitch_12
    .end packed-switch
.end method
