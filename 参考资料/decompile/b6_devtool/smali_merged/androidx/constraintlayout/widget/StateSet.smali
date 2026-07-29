.class public Landroidx/constraintlayout/widget/StateSet;
.super Ljava/lang/Object;
.source "StateSet.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/constraintlayout/widget/StateSet$Variant;,
        Landroidx/constraintlayout/widget/StateSet$State;
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field public static final TAG:Ljava/lang/String; = "ConstraintLayoutStates"


# instance fields
.field private mConstraintSetMap:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/constraintlayout/widget/ConstraintSet;",
            ">;"
        }
    .end annotation
.end field

.field private mConstraintsChangedListener:Landroidx/constraintlayout/widget/ConstraintsChangedListener;

.field mCurrentConstraintNumber:I

.field mCurrentStateId:I

.field mDefaultConstraintSet:Landroidx/constraintlayout/widget/ConstraintSet;

.field mDefaultState:I

.field private mStateList:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/constraintlayout/widget/StateSet$State;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "context",
            "parser"
        }
    .end annotation

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    .line 41
    iput v0, p0, Landroidx/constraintlayout/widget/StateSet;->mDefaultState:I

    .line 44
    iput v0, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentStateId:I

    .line 45
    iput v0, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentConstraintNumber:I

    .line 46
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    .line 47
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/constraintlayout/widget/StateSet;->mConstraintSetMap:Landroid/util/SparseArray;

    const/4 v0, 0x0

    .line 48
    iput-object v0, p0, Landroidx/constraintlayout/widget/StateSet;->mConstraintsChangedListener:Landroidx/constraintlayout/widget/ConstraintsChangedListener;

    .line 56
    invoke-direct {p0, p1, p2}, Landroidx/constraintlayout/widget/StateSet;->load(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)V

    return-void
.end method

.method private load(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 11
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "context",
            "parser"
        }
    .end annotation

    .line 70
    invoke-static {p2}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v0

    .line 71
    sget-object v1, Landroidx/constraintlayout/widget/R$styleable;->StateSet:[I

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 72
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->getIndexCount()I

    move-result v1

    const/4 v2, 0x0

    move v3, v2

    :goto_10
    if-ge v3, v1, :cond_25

    .line 75
    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getIndex(I)I

    move-result v4

    .line 76
    sget v5, Landroidx/constraintlayout/widget/R$styleable;->StateSet_defaultState:I

    if-ne v4, v5, :cond_22

    .line 77
    iget v5, p0, Landroidx/constraintlayout/widget/StateSet;->mDefaultState:I

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v4

    iput v4, p0, Landroidx/constraintlayout/widget/StateSet;->mDefaultState:I

    :cond_22
    add-int/lit8 v3, v3, 0x1

    goto :goto_10

    .line 80
    :cond_25
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 87
    :try_start_28
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0
    :try_end_2c
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_28 .. :try_end_2c} :catch_a2
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_2c} :catch_9d

    const/4 v1, 0x0

    :goto_2d
    const/4 v3, 0x1

    if-eq v0, v3, :cond_a6

    if-eqz v0, :cond_95

    const-string v4, "StateSet"

    const/4 v5, 0x3

    const/4 v6, 0x2

    if-eq v0, v6, :cond_46

    if-eq v0, v5, :cond_3b

    goto :goto_98

    .line 121
    :cond_3b
    :try_start_3b
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_98

    return-void

    .line 96
    :cond_46
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v7

    sparse-switch v7, :sswitch_data_a8

    goto :goto_77

    :sswitch_52
    const-string v3, "Variant"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_77

    move v3, v5

    goto :goto_78

    :sswitch_5c
    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_77

    goto :goto_78

    :sswitch_63
    const-string v3, "LayoutDescription"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_77

    move v3, v2

    goto :goto_78

    :sswitch_6d
    const-string v3, "State"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_77

    move v3, v6

    goto :goto_78

    :cond_77
    :goto_77
    const/4 v3, -0x1

    :goto_78
    if-eq v3, v6, :cond_88

    if-eq v3, v5, :cond_7d

    goto :goto_98

    .line 107
    :cond_7d
    new-instance v0, Landroidx/constraintlayout/widget/StateSet$Variant;

    invoke-direct {v0, p1, p2}, Landroidx/constraintlayout/widget/StateSet$Variant;-><init>(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)V

    if-eqz v1, :cond_98

    .line 109
    invoke-virtual {v1, v0}, Landroidx/constraintlayout/widget/StateSet$State;->add(Landroidx/constraintlayout/widget/StateSet$Variant;)V

    goto :goto_98

    .line 103
    :cond_88
    new-instance v1, Landroidx/constraintlayout/widget/StateSet$State;

    invoke-direct {v1, p1, p2}, Landroidx/constraintlayout/widget/StateSet$State;-><init>(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;)V

    .line 104
    iget-object v0, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    iget v3, v1, Landroidx/constraintlayout/widget/StateSet$State;->mId:I

    invoke-virtual {v0, v3, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_98

    .line 93
    :cond_95
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    .line 89
    :cond_98
    :goto_98
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0
    :try_end_9c
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_3b .. :try_end_9c} :catch_a2
    .catch Ljava/io/IOException; {:try_start_3b .. :try_end_9c} :catch_9d

    goto :goto_2d

    :catch_9d
    move-exception p1

    .line 138
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_a6

    :catch_a2
    move-exception p1

    .line 136
    invoke-virtual {p1}, Lorg/xmlpull/v1/XmlPullParserException;->printStackTrace()V

    :cond_a6
    :goto_a6
    return-void

    nop

    :sswitch_data_a8
    .sparse-switch
        0x4c7d471 -> :sswitch_6d
        0x4d92b252 -> :sswitch_63
        0x526c4e31 -> :sswitch_5c
        0x7155a865 -> :sswitch_52
    .end sparse-switch
.end method


# virtual methods
.method public convertToConstraintSet(IIFF)I
    .registers 9
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "currentConstrainSettId",
            "stateId",
            "width",
            "height"
        }
    .end annotation

    .line 179
    iget-object v0, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    invoke-virtual {v0, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/StateSet$State;

    if-nez v0, :cond_b

    return p2

    :cond_b
    const/high16 p2, -0x40800000    # -1.0f

    cmpl-float v1, p3, p2

    if-eqz v1, :cond_3e

    cmpl-float p2, p4, p2

    if-nez p2, :cond_16

    goto :goto_3e

    .line 195
    :cond_16
    iget-object p2, v0, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p2

    const/4 v1, 0x0

    :cond_1d
    :goto_1d
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_36

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/constraintlayout/widget/StateSet$Variant;

    .line 196
    invoke-virtual {v2, p3, p4}, Landroidx/constraintlayout/widget/StateSet$Variant;->match(FF)Z

    move-result v3

    if-eqz v3, :cond_1d

    .line 197
    iget v1, v2, Landroidx/constraintlayout/widget/StateSet$Variant;->mConstraintID:I

    if-ne p1, v1, :cond_34

    return p1

    :cond_34
    move-object v1, v2

    goto :goto_1d

    :cond_36
    if-eqz v1, :cond_3b

    .line 204
    iget p1, v1, Landroidx/constraintlayout/widget/StateSet$Variant;->mConstraintID:I

    return p1

    .line 207
    :cond_3b
    iget p1, v0, Landroidx/constraintlayout/widget/StateSet$State;->mConstraintID:I

    return p1

    .line 184
    :cond_3e
    :goto_3e
    iget p2, v0, Landroidx/constraintlayout/widget/StateSet$State;->mConstraintID:I

    if-ne p2, p1, :cond_43

    return p1

    .line 187
    :cond_43
    iget-object p2, v0, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :cond_49
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result p3

    if-eqz p3, :cond_5a

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p3

    check-cast p3, Landroidx/constraintlayout/widget/StateSet$Variant;

    .line 188
    iget p3, p3, Landroidx/constraintlayout/widget/StateSet$Variant;->mConstraintID:I

    if-ne p1, p3, :cond_49

    return p1

    .line 192
    :cond_5a
    iget p1, v0, Landroidx/constraintlayout/widget/StateSet$State;->mConstraintID:I

    return p1
.end method

.method public needsToChange(IFF)Z
    .registers 8
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "id",
            "width",
            "height"
        }
    .end annotation

    .line 143
    iget v0, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentStateId:I

    const/4 v1, 0x1

    if-eq v0, p1, :cond_6

    return v1

    :cond_6
    const/4 v2, -0x1

    const/4 v3, 0x0

    if-ne p1, v2, :cond_11

    .line 147
    iget-object p1, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    invoke-virtual {p1, v3}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object p1

    goto :goto_17

    :cond_11
    iget-object p1, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    invoke-virtual {p1, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object p1

    :goto_17
    check-cast p1, Landroidx/constraintlayout/widget/StateSet$State;

    .line 149
    iget v0, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentConstraintNumber:I

    if-eq v0, v2, :cond_2e

    .line 150
    iget-object v0, p1, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    iget v2, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentConstraintNumber:I

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/constraintlayout/widget/StateSet$Variant;

    invoke-virtual {v0, p2, p3}, Landroidx/constraintlayout/widget/StateSet$Variant;->match(FF)Z

    move-result v0

    if-eqz v0, :cond_2e

    return v3

    .line 155
    :cond_2e
    iget v0, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentConstraintNumber:I

    invoke-virtual {p1, p2, p3}, Landroidx/constraintlayout/widget/StateSet$State;->findMatch(FF)I

    move-result p1

    if-ne v0, p1, :cond_37

    return v3

    :cond_37
    return v1
.end method

.method public setOnConstraintsChanged(Landroidx/constraintlayout/widget/ConstraintsChangedListener;)V
    .registers 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "constraintsChangedListener"
        }
    .end annotation

    .line 162
    iput-object p1, p0, Landroidx/constraintlayout/widget/StateSet;->mConstraintsChangedListener:Landroidx/constraintlayout/widget/ConstraintsChangedListener;

    return-void
.end method

.method public stateGetConstraintID(III)I
    .registers 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "id",
            "width",
            "height"
        }
    .end annotation

    int-to-float p2, p2

    int-to-float p3, p3

    const/4 v0, -0x1

    .line 166
    invoke-virtual {p0, v0, p1, p2, p3}, Landroidx/constraintlayout/widget/StateSet;->updateConstraints(IIFF)I

    move-result p1

    return p1
.end method

.method public updateConstraints(IIFF)I
    .registers 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "currentId",
            "id",
            "width",
            "height"
        }
    .end annotation

    const/4 v0, -0x1

    if-ne p1, p2, :cond_46

    if-ne p2, v0, :cond_f

    .line 215
    iget-object p2, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    const/4 v1, 0x0

    invoke-virtual {p2, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/constraintlayout/widget/StateSet$State;

    goto :goto_19

    .line 217
    :cond_f
    iget-object p2, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    iget v1, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentStateId:I

    invoke-virtual {p2, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/constraintlayout/widget/StateSet$State;

    :goto_19
    if-nez p2, :cond_1c

    return v0

    .line 223
    :cond_1c
    iget v1, p0, Landroidx/constraintlayout/widget/StateSet;->mCurrentConstraintNumber:I

    if-eq v1, v0, :cond_2f

    .line 224
    iget-object v1, p2, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/constraintlayout/widget/StateSet$Variant;

    invoke-virtual {v1, p3, p4}, Landroidx/constraintlayout/widget/StateSet$Variant;->match(FF)Z

    move-result v1

    if-eqz v1, :cond_2f

    return p1

    .line 228
    :cond_2f
    invoke-virtual {p2, p3, p4}, Landroidx/constraintlayout/widget/StateSet$State;->findMatch(FF)I

    move-result p3

    if-ne p1, p3, :cond_36

    return p1

    :cond_36
    if-ne p3, v0, :cond_3b

    .line 233
    iget p1, p2, Landroidx/constraintlayout/widget/StateSet$State;->mConstraintID:I

    goto :goto_45

    :cond_3b
    iget-object p1, p2, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    invoke-virtual {p1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/widget/StateSet$Variant;

    iget p1, p1, Landroidx/constraintlayout/widget/StateSet$Variant;->mConstraintID:I

    :goto_45
    return p1

    .line 236
    :cond_46
    iget-object p1, p0, Landroidx/constraintlayout/widget/StateSet;->mStateList:Landroid/util/SparseArray;

    invoke-virtual {p1, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/widget/StateSet$State;

    if-nez p1, :cond_51

    return v0

    .line 240
    :cond_51
    invoke-virtual {p1, p3, p4}, Landroidx/constraintlayout/widget/StateSet$State;->findMatch(FF)I

    move-result p2

    if-ne p2, v0, :cond_5a

    .line 241
    iget p1, p1, Landroidx/constraintlayout/widget/StateSet$State;->mConstraintID:I

    goto :goto_64

    :cond_5a
    iget-object p1, p1, Landroidx/constraintlayout/widget/StateSet$State;->mVariants:Ljava/util/ArrayList;

    invoke-virtual {p1, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/constraintlayout/widget/StateSet$Variant;

    iget p1, p1, Landroidx/constraintlayout/widget/StateSet$Variant;->mConstraintID:I

    :goto_64
    return p1
.end method
