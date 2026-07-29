.class public interface abstract Landroidx/constraintlayout/core/motion/utils/TypedValues$TriggerType;
.super Ljava/lang/Object;
.source "TypedValues.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/constraintlayout/core/motion/utils/TypedValues;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "TriggerType"
.end annotation


# static fields
.field public static final CROSS:Ljava/lang/String; = "CROSS"

.field public static final KEY_WORDS:[Ljava/lang/String;

.field public static final NAME:Ljava/lang/String; = "KeyTrigger"

.field public static final NEGATIVE_CROSS:Ljava/lang/String; = "negativeCross"

.field public static final POSITIVE_CROSS:Ljava/lang/String; = "positiveCross"

.field public static final POST_LAYOUT:Ljava/lang/String; = "postLayout"

.field public static final TRIGGER_COLLISION_ID:Ljava/lang/String; = "triggerCollisionId"

.field public static final TRIGGER_COLLISION_VIEW:Ljava/lang/String; = "triggerCollisionView"

.field public static final TRIGGER_ID:Ljava/lang/String; = "triggerID"

.field public static final TRIGGER_RECEIVER:Ljava/lang/String; = "triggerReceiver"

.field public static final TRIGGER_SLACK:Ljava/lang/String; = "triggerSlack"

.field public static final TYPE_CROSS:I = 0x138

.field public static final TYPE_NEGATIVE_CROSS:I = 0x136

.field public static final TYPE_POSITIVE_CROSS:I = 0x135

.field public static final TYPE_POST_LAYOUT:I = 0x130

.field public static final TYPE_TRIGGER_COLLISION_ID:I = 0x133

.field public static final TYPE_TRIGGER_COLLISION_VIEW:I = 0x132

.field public static final TYPE_TRIGGER_ID:I = 0x134

.field public static final TYPE_TRIGGER_RECEIVER:I = 0x137

.field public static final TYPE_TRIGGER_SLACK:I = 0x131

.field public static final TYPE_VIEW_TRANSITION_ON_CROSS:I = 0x12d

.field public static final TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS:I = 0x12f

.field public static final TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS:I = 0x12e

.field public static final VIEW_TRANSITION_ON_CROSS:Ljava/lang/String; = "viewTransitionOnCross"

.field public static final VIEW_TRANSITION_ON_NEGATIVE_CROSS:Ljava/lang/String; = "viewTransitionOnNegativeCross"

.field public static final VIEW_TRANSITION_ON_POSITIVE_CROSS:Ljava/lang/String; = "viewTransitionOnPositiveCross"


# direct methods
.method static constructor <clinit>()V
    .registers 12

    const-string v0, "viewTransitionOnCross"

    const-string v1, "viewTransitionOnPositiveCross"

    const-string v2, "viewTransitionOnNegativeCross"

    const-string v3, "postLayout"

    const-string v4, "triggerSlack"

    const-string v5, "triggerCollisionView"

    const-string v6, "triggerCollisionId"

    const-string v7, "triggerID"

    const-string v8, "positiveCross"

    const-string v9, "negativeCross"

    const-string v10, "triggerReceiver"

    const-string v11, "CROSS"

    .line 389
    filled-new-array/range {v0 .. v11}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/constraintlayout/core/motion/utils/TypedValues$TriggerType;->KEY_WORDS:[Ljava/lang/String;

    return-void
.end method

.method public static getId(Ljava/lang/String;)I
    .registers 3

    .line 424
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, -0x1

    sparse-switch v0, :sswitch_data_c4

    :goto_b
    move p0, v1

    goto/16 :goto_9b

    :sswitch_e
    const-string v0, "triggerReceiver"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_17

    goto :goto_b

    :cond_17
    const/16 p0, 0xb

    goto/16 :goto_9b

    :sswitch_1b
    const-string v0, "postLayout"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_24

    goto :goto_b

    :cond_24
    const/16 p0, 0xa

    goto/16 :goto_9b

    :sswitch_28
    const-string v0, "viewTransitionOnCross"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_31

    goto :goto_b

    :cond_31
    const/16 p0, 0x9

    goto/16 :goto_9b

    :sswitch_35
    const-string v0, "triggerSlack"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_3e

    goto :goto_b

    :cond_3e
    const/16 p0, 0x8

    goto/16 :goto_9b

    :sswitch_42
    const-string v0, "CROSS"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_4b

    goto :goto_b

    :cond_4b
    const/4 p0, 0x7

    goto :goto_9b

    :sswitch_4d
    const-string v0, "viewTransitionOnNegativeCross"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_56

    goto :goto_b

    :cond_56
    const/4 p0, 0x6

    goto :goto_9b

    :sswitch_58
    const-string v0, "triggerCollisionView"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_61

    goto :goto_b

    :cond_61
    const/4 p0, 0x5

    goto :goto_9b

    :sswitch_63
    const-string v0, "negativeCross"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_6c

    goto :goto_b

    :cond_6c
    const/4 p0, 0x4

    goto :goto_9b

    :sswitch_6e
    const-string v0, "triggerID"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_77

    goto :goto_b

    :cond_77
    const/4 p0, 0x3

    goto :goto_9b

    :sswitch_79
    const-string v0, "triggerCollisionId"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_82

    goto :goto_b

    :cond_82
    const/4 p0, 0x2

    goto :goto_9b

    :sswitch_84
    const-string v0, "viewTransitionOnPositiveCross"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_8e

    goto/16 :goto_b

    :cond_8e
    const/4 p0, 0x1

    goto :goto_9b

    :sswitch_90
    const-string v0, "positiveCross"

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_9a

    goto/16 :goto_b

    :cond_9a
    const/4 p0, 0x0

    :goto_9b
    packed-switch p0, :pswitch_data_f6

    return v1

    :pswitch_9f
    const/16 p0, 0x137

    return p0

    :pswitch_a2
    const/16 p0, 0x130

    return p0

    :pswitch_a5
    const/16 p0, 0x12d

    return p0

    :pswitch_a8
    const/16 p0, 0x131

    return p0

    :pswitch_ab
    const/16 p0, 0x138

    return p0

    :pswitch_ae
    const/16 p0, 0x12f

    return p0

    :pswitch_b1
    const/16 p0, 0x132

    return p0

    :pswitch_b4
    const/16 p0, 0x136

    return p0

    :pswitch_b7
    const/16 p0, 0x134

    return p0

    :pswitch_ba
    const/16 p0, 0x133

    return p0

    :pswitch_bd
    const/16 p0, 0x12e

    return p0

    :pswitch_c0
    const/16 p0, 0x135

    return p0

    nop

    :sswitch_data_c4
    .sparse-switch
        -0x5f0e9e39 -> :sswitch_90
        -0x399a6b12 -> :sswitch_84
        -0x2ee3a4eb -> :sswitch_79
        -0x26ab2f2d -> :sswitch_6e
        -0x26090af5 -> :sswitch_63
        -0x4880de1 -> :sswitch_58
        -0x94d7ce -> :sswitch_4d
        0x3d6a020 -> :sswitch_42
        0x15b9acb8 -> :sswitch_35
        0x4d99e267 -> :sswitch_28
        0x538787ea -> :sswitch_1b
        0x5b846bc7 -> :sswitch_e
    .end sparse-switch

    :pswitch_data_f6
    .packed-switch 0x0
        :pswitch_c0
        :pswitch_bd
        :pswitch_ba
        :pswitch_b7
        :pswitch_b4
        :pswitch_b1
        :pswitch_ae
        :pswitch_ab
        :pswitch_a8
        :pswitch_a5
        :pswitch_a2
        :pswitch_9f
    .end packed-switch
.end method
