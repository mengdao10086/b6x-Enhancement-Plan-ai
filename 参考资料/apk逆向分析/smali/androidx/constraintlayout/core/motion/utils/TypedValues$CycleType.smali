.class public interface abstract Landroidx/constraintlayout/core/motion/utils/TypedValues$CycleType;
.super Ljava/lang/Object;
.source "TypedValues.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/motion/utils/TypedValues;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "CycleType"
.end annotation


# static fields
.field public static final KEY_WORDS:[Ljava/lang/String;

.field public static final NAME:Ljava/lang/String; = "KeyCycle"

.field public static final S_ALPHA:Ljava/lang/String; = "alpha"

.field public static final S_CURVE_FIT:Ljava/lang/String; = "curveFit"

.field public static final S_CUSTOM_WAVE_SHAPE:Ljava/lang/String; = "customWave"

.field public static final S_EASING:Ljava/lang/String; = "easing"

.field public static final S_ELEVATION:Ljava/lang/String; = "elevation"

.field public static final S_PATH_ROTATE:Ljava/lang/String; = "pathRotate"

.field public static final S_PIVOT_X:Ljava/lang/String; = "pivotX"

.field public static final S_PIVOT_Y:Ljava/lang/String; = "pivotY"

.field public static final S_PROGRESS:Ljava/lang/String; = "progress"

.field public static final S_ROTATION_X:Ljava/lang/String; = "rotationX"

.field public static final S_ROTATION_Y:Ljava/lang/String; = "rotationY"

.field public static final S_ROTATION_Z:Ljava/lang/String; = "rotationZ"

.field public static final S_SCALE_X:Ljava/lang/String; = "scaleX"

.field public static final S_SCALE_Y:Ljava/lang/String; = "scaleY"

.field public static final S_TRANSLATION_X:Ljava/lang/String; = "translationX"

.field public static final S_TRANSLATION_Y:Ljava/lang/String; = "translationY"

.field public static final S_TRANSLATION_Z:Ljava/lang/String; = "translationZ"

.field public static final S_VISIBILITY:Ljava/lang/String; = "visibility"

.field public static final S_WAVE_OFFSET:Ljava/lang/String; = "offset"

.field public static final S_WAVE_PERIOD:Ljava/lang/String; = "period"

.field public static final S_WAVE_PHASE:Ljava/lang/String; = "phase"

.field public static final S_WAVE_SHAPE:Ljava/lang/String; = "waveShape"

.field public static final TYPE_ALPHA:I = 0x193

.field public static final TYPE_CURVE_FIT:I = 0x191

.field public static final TYPE_CUSTOM_WAVE_SHAPE:I = 0x1a6

.field public static final TYPE_EASING:I = 0x1a4

.field public static final TYPE_ELEVATION:I = 0x133

.field public static final TYPE_PATH_ROTATE:I = 0x1a0

.field public static final TYPE_PIVOT_X:I = 0x139

.field public static final TYPE_PIVOT_Y:I = 0x13a

.field public static final TYPE_PROGRESS:I = 0x13b

.field public static final TYPE_ROTATION_X:I = 0x134

.field public static final TYPE_ROTATION_Y:I = 0x135

.field public static final TYPE_ROTATION_Z:I = 0x136

.field public static final TYPE_SCALE_X:I = 0x137

.field public static final TYPE_SCALE_Y:I = 0x138

.field public static final TYPE_TRANSLATION_X:I = 0x130

.field public static final TYPE_TRANSLATION_Y:I = 0x131

.field public static final TYPE_TRANSLATION_Z:I = 0x132

.field public static final TYPE_VISIBILITY:I = 0x192

.field public static final TYPE_WAVE_OFFSET:I = 0x1a8

.field public static final TYPE_WAVE_PERIOD:I = 0x1a7

.field public static final TYPE_WAVE_PHASE:I = 0x1a9

.field public static final TYPE_WAVE_SHAPE:I = 0x1a5


# direct methods
.method static constructor <clinit>()V
    .registers 22

    const-string v0, "curveFit"

    const-string v1, "visibility"

    const-string v2, "alpha"

    const-string v3, "translationX"

    const-string v4, "translationY"

    const-string v5, "translationZ"

    const-string v6, "elevation"

    const-string v7, "rotationX"

    const-string v8, "rotationY"

    const-string v9, "rotationZ"

    const-string v10, "scaleX"

    const-string v11, "scaleY"

    const-string v12, "pivotX"

    const-string v13, "pivotY"

    const-string v14, "progress"

    const-string v15, "pathRotate"

    const-string v16, "easing"

    const-string v17, "waveShape"

    const-string v18, "customWave"

    const-string v19, "period"

    const-string v20, "offset"

    const-string v21, "phase"

    .line 271
    filled-new-array/range {v0 .. v21}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/constraintlayout/core/motion/utils/TypedValues$CycleType;->KEY_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public static getId(Ljava/lang/String;)I
    .registers 3

    .line 305
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_108

    :goto_b
    move p0, v1

    goto/16 :goto_d3

    :sswitch_e
    const-string v0, "visibility"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_17

    goto :goto_b

    :cond_17
    const/16 p0, 0xf

    goto/16 :goto_d3

    :sswitch_1b
    const-string v0, "pathRotate"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_24

    goto :goto_b

    :cond_24
    const/16 p0, 0xe

    goto/16 :goto_d3

    :sswitch_28
    const-string v0, "curveFit"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_31

    goto :goto_b

    :cond_31
    const/16 p0, 0xd

    goto/16 :goto_d3

    :sswitch_35
    const-string v0, "alpha"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_3e

    goto :goto_b

    :cond_3e
    const/16 p0, 0xc

    goto/16 :goto_d3

    :sswitch_42
    const-string v0, "scaleY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_4b

    goto :goto_b

    :cond_4b
    const/16 p0, 0xb

    goto/16 :goto_d3

    :sswitch_4f
    const-string v0, "scaleX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_58

    goto :goto_b

    :cond_58
    const/16 p0, 0xa

    goto/16 :goto_d3

    :sswitch_5c
    const-string v0, "pivotY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_65

    goto :goto_b

    :cond_65
    const/16 p0, 0x9

    goto/16 :goto_d3

    :sswitch_69
    const-string v0, "pivotX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_72

    goto :goto_b

    :cond_72
    const/16 p0, 0x8

    goto/16 :goto_d3

    :sswitch_76
    const-string v0, "progress"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_7f

    goto :goto_b

    :cond_7f
    const/4 p0, 0x7

    goto :goto_d3

    :sswitch_81
    const-string v0, "translationZ"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_8a

    goto :goto_b

    :cond_8a
    const/4 p0, 0x6

    goto :goto_d3

    :sswitch_8c
    const-string v0, "translationY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_96

    goto/16 :goto_b

    :cond_96
    const/4 p0, 0x5

    goto :goto_d3

    :sswitch_98
    const-string v0, "translationX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_a2

    goto/16 :goto_b

    :cond_a2
    const/4 p0, 0x4

    goto :goto_d3

    :sswitch_a4
    const-string v0, "rotationZ"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_ae

    goto/16 :goto_b

    :cond_ae
    const/4 p0, 0x3

    goto :goto_d3

    :sswitch_b0
    const-string v0, "rotationY"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_ba

    goto/16 :goto_b

    :cond_ba
    const/4 p0, 0x2

    goto :goto_d3

    :sswitch_bc
    const-string v0, "rotationX"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_c6

    goto/16 :goto_b

    :cond_c6
    const/4 p0, 0x1

    goto :goto_d3

    :sswitch_c8
    const-string v0, "easing"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_d2

    goto/16 :goto_b

    :cond_d2
    const/4 p0, 0x0

    :goto_d3
    packed-switch p0, :pswitch_data_14a

    return v1

    :pswitch_d7
    const/16 p0, 0x192

    return p0

    :pswitch_da
    const/16 p0, 0x1a0

    return p0

    :pswitch_dd
    const/16 p0, 0x191

    return p0

    :pswitch_e0
    const/16 p0, 0x193

    return p0

    :pswitch_e3
    const/16 p0, 0x138

    return p0

    :pswitch_e6
    const/16 p0, 0x137

    return p0

    :pswitch_e9
    const/16 p0, 0x13a

    return p0

    :pswitch_ec
    const/16 p0, 0x139

    return p0

    :pswitch_ef
    const/16 p0, 0x13b

    return p0

    :pswitch_f2
    const/16 p0, 0x132

    return p0

    :pswitch_f5
    const/16 p0, 0x131

    return p0

    :pswitch_f8
    const/16 p0, 0x130

    return p0

    :pswitch_fb
    const/16 p0, 0x136

    return p0

    :pswitch_fe
    const/16 p0, 0x135

    return p0

    :pswitch_101
    const/16 p0, 0x134

    return p0

    :pswitch_104
    const/16 p0, 0x1a4

    return p0

    nop

    :sswitch_data_108
    .sparse-switch
        -0x4e19c2d5 -> :sswitch_c8
        -0x4a771f66 -> :sswitch_bc
        -0x4a771f65 -> :sswitch_b0
        -0x4a771f64 -> :sswitch_a4
        -0x490b9c39 -> :sswitch_98
        -0x490b9c38 -> :sswitch_8c
        -0x490b9c37 -> :sswitch_81
        -0x3bab3dd3 -> :sswitch_76
        -0x3ae243aa -> :sswitch_69
        -0x3ae243a9 -> :sswitch_5c
        -0x3621dfb2 -> :sswitch_4f
        -0x3621dfb1 -> :sswitch_42
        0x589b15e -> :sswitch_35
        0x2283b8a2 -> :sswitch_28
        0x2fdfbde0 -> :sswitch_1b
        0x73b66312 -> :sswitch_e
    .end sparse-switch

    :pswitch_data_14a
    .packed-switch 0x0
        :pswitch_104
        :pswitch_101
        :pswitch_fe
        :pswitch_fb
        :pswitch_f8
        :pswitch_f5
        :pswitch_f2
        :pswitch_ef
        :pswitch_ec
        :pswitch_e9
        :pswitch_e6
        :pswitch_e3
        :pswitch_e0
        :pswitch_dd
        :pswitch_da
        :pswitch_d7
    .end packed-switch
.end method

.method public static getType(I)I
    .registers 2

    const/16 v0, 0x64

    if-eq p0, v0, :cond_24

    const/16 v0, 0x65

    if-eq p0, v0, :cond_21

    const/16 v0, 0x1a0

    if-eq p0, v0, :cond_1f

    const/16 v0, 0x1a4

    if-eq p0, v0, :cond_21

    const/16 v0, 0x1a5

    if-eq p0, v0, :cond_21

    packed-switch p0, :pswitch_data_26

    packed-switch p0, :pswitch_data_42

    packed-switch p0, :pswitch_data_4c

    const/4 p0, -0x1

    return p0

    :cond_1f
    :pswitch_1f
    const/4 p0, 0x4

    return p0

    :cond_21
    const/16 p0, 0x8

    return p0

    :cond_24
    :pswitch_24
    const/4 p0, 0x2

    return p0

    :pswitch_data_26
    .packed-switch 0x130
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
    .end packed-switch

    :pswitch_data_42
    .packed-switch 0x191
        :pswitch_24
        :pswitch_24
        :pswitch_1f
    .end packed-switch

    :pswitch_data_4c
    .packed-switch 0x1a7
        :pswitch_1f
        :pswitch_1f
        :pswitch_1f
    .end packed-switch
.end method
