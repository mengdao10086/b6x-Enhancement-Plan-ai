.class public interface abstract Landroidx/constraintlayout/core/motion/utils/TypedValues$TransitionType;
.super Ljava/lang/Object;
.source "TypedValues.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/motion/utils/TypedValues;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "TransitionType"
.end annotation


# static fields
.field public static final KEY_WORDS:[Ljava/lang/String;

.field public static final NAME:Ljava/lang/String; = "Transitions"

.field public static final S_AUTO_TRANSITION:Ljava/lang/String; = "autoTransition"

.field public static final S_DURATION:Ljava/lang/String; = "duration"

.field public static final S_FROM:Ljava/lang/String; = "from"

.field public static final S_INTERPOLATOR:Ljava/lang/String; = "motionInterpolator"

.field public static final S_PATH_MOTION_ARC:Ljava/lang/String; = "pathMotionArc"

.field public static final S_STAGGERED:Ljava/lang/String; = "staggered"

.field public static final S_TO:Ljava/lang/String; = "to"

.field public static final S_TRANSITION_FLAGS:Ljava/lang/String; = "transitionFlags"

.field public static final TYPE_AUTO_TRANSITION:I = 0x2c0

.field public static final TYPE_DURATION:I = 0x2bc

.field public static final TYPE_FROM:I = 0x2bd

.field public static final TYPE_INTERPOLATOR:I = 0x2c1

.field public static final TYPE_PATH_MOTION_ARC:I = 0x1fd

.field public static final TYPE_STAGGERED:I = 0x2c2

.field public static final TYPE_TO:I = 0x2be

.field public static final TYPE_TRANSITION_FLAGS:I = 0x2c3


# direct methods
.method static constructor <clinit>()V
    .registers 9

    const-string v0, "duration"

    const-string v1, "from"

    const-string v2, "to"

    const-string v3, "pathMotionArc"

    const-string v4, "autoTransition"

    const-string v5, "motionInterpolator"

    const-string v6, "staggered"

    const-string v7, "from"

    const-string v8, "transitionFlags"

    .line 733
    filled-new-array/range {v0 .. v8}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/constraintlayout/core/motion/utils/TypedValues$TransitionType;->KEY_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public static getId(Ljava/lang/String;)I
    .registers 3

    .line 770
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_82

    :goto_b
    move p0, v1

    goto/16 :goto_65

    :sswitch_e
    const-string v0, "staggered"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_17

    goto :goto_b

    :cond_17
    const/4 p0, 0x7

    goto :goto_65

    :sswitch_19
    const-string v0, "pathMotionArc"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_22

    goto :goto_b

    :cond_22
    const/4 p0, 0x6

    goto :goto_65

    :sswitch_24
    const-string v0, "from"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2d

    goto :goto_b

    :cond_2d
    const/4 p0, 0x5

    goto :goto_65

    :sswitch_2f
    const-string v0, "to"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_38

    goto :goto_b

    :cond_38
    const/4 p0, 0x4

    goto :goto_65

    :sswitch_3a
    const-string v0, "autoTransition"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_43

    goto :goto_b

    :cond_43
    const/4 p0, 0x3

    goto :goto_65

    :sswitch_45
    const-string v0, "motionInterpolator"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_4e

    goto :goto_b

    :cond_4e
    const/4 p0, 0x2

    goto :goto_65

    :sswitch_50
    const-string v0, "duration"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_59

    goto :goto_b

    :cond_59
    const/4 p0, 0x1

    goto :goto_65

    :sswitch_5b
    const-string v0, "transitionFlags"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_64

    goto :goto_b

    :cond_64
    const/4 p0, 0x0

    :goto_65
    packed-switch p0, :pswitch_data_a4

    return v1

    :pswitch_69
    const/16 p0, 0x2c2

    return p0

    :pswitch_6c
    const/16 p0, 0x1fd

    return p0

    :pswitch_6f
    const/16 p0, 0x2bd

    return p0

    :pswitch_72
    const/16 p0, 0x2be

    return p0

    :pswitch_75
    const/16 p0, 0x2c0

    return p0

    :pswitch_78
    const/16 p0, 0x2c1

    return p0

    :pswitch_7b
    const/16 p0, 0x2bc

    return p0

    :pswitch_7e
    const/16 p0, 0x2c3

    return p0

    nop

    :sswitch_data_82
    .sparse-switch
        -0x770661ce -> :sswitch_5b
        -0x76bbb26c -> :sswitch_50
        -0x50ef8463 -> :sswitch_45
        -0x4d5ee79c -> :sswitch_3a
        0xe7b -> :sswitch_2f
        0x3017aa -> :sswitch_24
        0x4e203417 -> :sswitch_19
        0x6da0e50c -> :sswitch_e
    .end sparse-switch

    :pswitch_data_a4
    .packed-switch 0x0
        :pswitch_7e
        :pswitch_7b
        :pswitch_78
        :pswitch_75
        :pswitch_72
        :pswitch_6f
        :pswitch_6c
        :pswitch_69
    .end packed-switch
.end method

.method public static getType(I)I
    .registers 2

    const/16 v0, 0x1fd

    if-eq p0, v0, :cond_11

    packed-switch p0, :pswitch_data_14

    packed-switch p0, :pswitch_data_1e

    const/4 p0, -0x1

    return p0

    :pswitch_c
    const/4 p0, 0x4

    return p0

    :pswitch_e
    const/16 p0, 0x8

    return p0

    :cond_11
    :pswitch_11
    const/4 p0, 0x2

    return p0

    nop

    :pswitch_data_14
    .packed-switch 0x2bc
        :pswitch_11
        :pswitch_e
        :pswitch_e
    .end packed-switch

    :pswitch_data_1e
    .packed-switch 0x2c1
        :pswitch_e
        :pswitch_c
        :pswitch_e
    .end packed-switch
.end method
