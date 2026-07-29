.class public Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;
.super Lcom/example/extool/databinding/ActivityExperimentalB6Binding;
.source "ActivityExperimentalB6BindingImpl.java"

# interfaces
.implements Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;
.implements Lcom/example/extool/generated/callback/OnClickListener$Listener;
.implements Lcom/example/extool/generated/callback/OnProgressChanged$Listener;


# static fields
.field private static final sIncludes:Landroidx/databinding/ViewDataBinding$IncludedLayouts;

.field private static final sViewsWithIds:Landroid/util/SparseIntArray;


# instance fields
.field private final mCallback1:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private final mCallback10:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

.field private final mCallback11:Landroid/view/View$OnClickListener;

.field private final mCallback12:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private final mCallback2:Landroid/widget/CompoundButton$OnCheckedChangeListener;

.field private final mCallback3:Landroid/view/View$OnClickListener;

.field private final mCallback4:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

.field private final mCallback5:Landroid/view/View$OnClickListener;

.field private final mCallback6:Landroid/view/View$OnClickListener;

.field private final mCallback7:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

.field private final mCallback8:Landroid/view/View$OnClickListener;

.field private final mCallback9:Landroid/view/View$OnClickListener;

.field private mDirtyFlags:J

.field private final mboundView0:Landroidx/core/widget/NestedScrollView;

.field private final mboundView11:Landroid/widget/LinearLayout;

.field private final mboundView12:Landroid/widget/TextView;

.field private final mboundView13:Landroid/widget/LinearLayout;

.field private final mboundView14:Landroid/widget/Button;

.field private final mboundView15:Landroid/widget/SeekBar;

.field private final mboundView16:Landroid/widget/Button;

.field private final mboundView17:Landroid/widget/TextView;

.field private final mboundView18:Landroid/widget/Button;

.field private final mboundView2:Landroid/widget/TextView;

.field private final mboundView20:Landroid/widget/Button;

.field private final mboundView21:Landroid/widget/LinearLayout;

.field private final mboundView22:Landroid/widget/TextView;

.field private final mboundView23:Landroid/widget/LinearLayout;

.field private final mboundView24:Landroid/widget/Button;

.field private final mboundView26:Landroid/widget/Button;

.field private final mboundView27:Landroid/widget/LinearLayout;

.field private final mboundView28:Lcom/google/android/material/switchmaterial/SwitchMaterial;

.field private final mboundView29:Landroid/widget/TextView;

.field private final mboundView3:Landroid/widget/TextView;

.field private final mboundView30:Landroid/widget/TextView;

.field private final mboundView4:Landroid/widget/TextView;

.field private final mboundView5:Landroid/widget/TextView;

.field private final mboundView6:Landroid/widget/TextView;

.field private final mboundView7:Landroid/widget/TextView;

.field private final mboundView8:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .line 16
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    sput-object v0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sViewsWithIds:Landroid/util/SparseIntArray;

    const v1, 0x7f080164

    const/16 v2, 0x1f

    .line 17
    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->put(II)V

    return-void
.end method

.method public constructor <init>(Landroidx/databinding/DataBindingComponent;Landroid/view/View;)V
    .registers 6

    .line 102
    sget-object v0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sIncludes:Landroidx/databinding/ViewDataBinding$IncludedLayouts;

    sget-object v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sViewsWithIds:Landroid/util/SparseIntArray;

    const/16 v2, 0x20

    invoke-static {p1, p2, v2, v0, v1}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mapBindings(Landroidx/databinding/DataBindingComponent;Landroid/view/View;ILandroidx/databinding/ViewDataBinding$IncludedLayouts;Landroid/util/SparseIntArray;)[Ljava/lang/Object;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;-><init>(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;)V

    return-void
.end method

.method private constructor <init>(Landroidx/databinding/DataBindingComponent;Landroid/view/View;[Ljava/lang/Object;)V
    .registers 19

    move-object v10, p0

    const/4 v3, 0x0

    const/16 v11, 0xa

    .line 105
    aget-object v0, p3, v11

    move-object v4, v0

    check-cast v4, Landroid/widget/RadioButton;

    const/16 v12, 0x9

    aget-object v0, p3, v12

    move-object v5, v0

    check-cast v5, Landroid/widget/RadioButton;

    const/16 v0, 0x1f

    aget-object v0, p3, v0

    move-object v6, v0

    check-cast v6, Landroid/widget/RadioGroup;

    const/16 v0, 0x19

    aget-object v0, p3, v0

    move-object v7, v0

    check-cast v7, Landroid/widget/SeekBar;

    const/16 v0, 0x13

    aget-object v0, p3, v0

    move-object v8, v0

    check-cast v8, Landroid/widget/SeekBar;

    const/4 v13, 0x1

    aget-object v0, p3, v13

    move-object v9, v0

    check-cast v9, Landroid/widget/TextView;

    move-object v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-direct/range {v0 .. v9}, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;-><init>(Ljava/lang/Object;Landroid/view/View;ILandroid/widget/RadioButton;Landroid/widget/RadioButton;Landroid/widget/RadioGroup;Landroid/widget/SeekBar;Landroid/widget/SeekBar;Landroid/widget/TextView;)V

    const-wide/16 v0, -0x1

    .line 853
    iput-wide v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    const/4 v0, 0x0

    .line 113
    aget-object v0, p3, v0

    check-cast v0, Landroidx/core/widget/NestedScrollView;

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView0:Landroidx/core/widget/NestedScrollView;

    const/4 v1, 0x0

    .line 114
    invoke-virtual {v0, v1}, Landroidx/core/widget/NestedScrollView;->setTag(Ljava/lang/Object;)V

    const/16 v0, 0xb

    .line 115
    aget-object v2, p3, v0

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView11:Landroid/widget/LinearLayout;

    .line 116
    invoke-virtual {v2, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    const/16 v2, 0xc

    .line 117
    aget-object v3, p3, v2

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView12:Landroid/widget/TextView;

    .line 118
    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0xd

    .line 119
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView13:Landroid/widget/LinearLayout;

    .line 120
    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0xe

    .line 121
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView14:Landroid/widget/Button;

    .line 122
    invoke-virtual {v3, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0xf

    .line 123
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/SeekBar;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    .line 124
    invoke-virtual {v3, v1}, Landroid/widget/SeekBar;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0x10

    .line 125
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView16:Landroid/widget/Button;

    .line 126
    invoke-virtual {v3, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0x11

    .line 127
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView17:Landroid/widget/TextView;

    .line 128
    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v3, 0x12

    .line 129
    aget-object v3, p3, v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView18:Landroid/widget/Button;

    .line 130
    invoke-virtual {v3, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/4 v3, 0x2

    .line 131
    aget-object v4, p3, v3

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView2:Landroid/widget/TextView;

    .line 132
    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x14

    .line 133
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView20:Landroid/widget/Button;

    .line 134
    invoke-virtual {v4, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x15

    .line 135
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView21:Landroid/widget/LinearLayout;

    .line 136
    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x16

    .line 137
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView22:Landroid/widget/TextView;

    .line 138
    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x17

    .line 139
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView23:Landroid/widget/LinearLayout;

    .line 140
    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x18

    .line 141
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView24:Landroid/widget/Button;

    .line 142
    invoke-virtual {v4, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x1a

    .line 143
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView26:Landroid/widget/Button;

    .line 144
    invoke-virtual {v4, v1}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x1b

    .line 145
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/LinearLayout;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView27:Landroid/widget/LinearLayout;

    .line 146
    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x1c

    .line 147
    aget-object v4, p3, v4

    check-cast v4, Lcom/google/android/material/switchmaterial/SwitchMaterial;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView28:Lcom/google/android/material/switchmaterial/SwitchMaterial;

    .line 148
    invoke-virtual {v4, v1}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setTag(Ljava/lang/Object;)V

    const/16 v4, 0x1d

    .line 149
    aget-object v4, p3, v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView29:Landroid/widget/TextView;

    .line 150
    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/4 v4, 0x3

    .line 151
    aget-object v5, p3, v4

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView3:Landroid/widget/TextView;

    .line 152
    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v5, 0x1e

    .line 153
    aget-object v5, p3, v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView30:Landroid/widget/TextView;

    .line 154
    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/4 v5, 0x4

    .line 155
    aget-object v6, p3, v5

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView4:Landroid/widget/TextView;

    .line 156
    invoke-virtual {v6, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/4 v6, 0x5

    .line 157
    aget-object v7, p3, v6

    check-cast v7, Landroid/widget/TextView;

    iput-object v7, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView5:Landroid/widget/TextView;

    .line 158
    invoke-virtual {v7, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/4 v7, 0x6

    .line 159
    aget-object v8, p3, v7

    check-cast v8, Landroid/widget/TextView;

    iput-object v8, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView6:Landroid/widget/TextView;

    .line 160
    invoke-virtual {v8, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/4 v8, 0x7

    .line 161
    aget-object v9, p3, v8

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView7:Landroid/widget/TextView;

    .line 162
    invoke-virtual {v9, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    const/16 v9, 0x8

    .line 163
    aget-object v14, p3, v9

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView8:Landroid/widget/TextView;

    .line 164
    invoke-virtual {v14, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 165
    iget-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbManual:Landroid/widget/RadioButton;

    invoke-virtual {v14, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 166
    iget-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbSmart:Landroid/widget/RadioButton;

    invoke-virtual {v14, v1}, Landroid/widget/RadioButton;->setTag(Ljava/lang/Object;)V

    .line 167
    iget-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    invoke-virtual {v14, v1}, Landroid/widget/SeekBar;->setTag(Ljava/lang/Object;)V

    .line 168
    iget-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    invoke-virtual {v14, v1}, Landroid/widget/SeekBar;->setTag(Ljava/lang/Object;)V

    .line 169
    iget-object v14, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->tvConnectState:Landroid/widget/TextView;

    invoke-virtual {v14, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    move-object/from16 v1, p2

    .line 170
    invoke-virtual {p0, v1}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->setRootTag(Landroid/view/View;)V

    .line 172
    new-instance v1, Lcom/example/extool/generated/callback/OnCheckedChangeListener;

    invoke-direct {v1, p0, v3}, Lcom/example/extool/generated/callback/OnCheckedChangeListener;-><init>(Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback2:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 173
    new-instance v1, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v1, p0, v12}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback9:Landroid/view/View$OnClickListener;

    .line 174
    new-instance v1, Lcom/example/extool/generated/callback/OnCheckedChangeListener;

    invoke-direct {v1, p0, v13}, Lcom/example/extool/generated/callback/OnCheckedChangeListener;-><init>(Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback1:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 175
    new-instance v1, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v1, p0, v9}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback8:Landroid/view/View$OnClickListener;

    .line 176
    new-instance v1, Lcom/example/extool/generated/callback/OnProgressChanged;

    invoke-direct {v1, p0, v8}, Lcom/example/extool/generated/callback/OnProgressChanged;-><init>(Lcom/example/extool/generated/callback/OnProgressChanged$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback7:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    .line 177
    new-instance v1, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v1, p0, v0}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v1, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback11:Landroid/view/View$OnClickListener;

    .line 178
    new-instance v0, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v0, p0, v7}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback6:Landroid/view/View$OnClickListener;

    .line 179
    new-instance v0, Lcom/example/extool/generated/callback/OnCheckedChangeListener;

    invoke-direct {v0, p0, v2}, Lcom/example/extool/generated/callback/OnCheckedChangeListener;-><init>(Lcom/example/extool/generated/callback/OnCheckedChangeListener$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback12:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 180
    new-instance v0, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v0, p0, v6}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback5:Landroid/view/View$OnClickListener;

    .line 181
    new-instance v0, Lcom/example/extool/generated/callback/OnProgressChanged;

    invoke-direct {v0, p0, v5}, Lcom/example/extool/generated/callback/OnProgressChanged;-><init>(Lcom/example/extool/generated/callback/OnProgressChanged$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback4:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    .line 182
    new-instance v0, Lcom/example/extool/generated/callback/OnProgressChanged;

    invoke-direct {v0, p0, v11}, Lcom/example/extool/generated/callback/OnProgressChanged;-><init>(Lcom/example/extool/generated/callback/OnProgressChanged$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback10:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    .line 183
    new-instance v0, Lcom/example/extool/generated/callback/OnClickListener;

    invoke-direct {v0, p0, v4}, Lcom/example/extool/generated/callback/OnClickListener;-><init>(Lcom/example/extool/generated/callback/OnClickListener$Listener;I)V

    iput-object v0, v10, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback3:Landroid/view/View$OnClickListener;

    .line 184
    invoke-virtual {p0}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->invalidateAll()V

    return-void
.end method


# virtual methods
.method public final _internalCallbackOnCheckedChanged(ILandroid/widget/CompoundButton;Z)V
    .registers 7

    const/4 v0, 0x0

    const/4 v1, 0x1

    if-eq p1, v1, :cond_28

    const/4 v2, 0x2

    if-eq p1, v2, :cond_17

    const/16 p2, 0xc

    if-eq p1, p2, :cond_c

    goto :goto_38

    .line 650
    :cond_c
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_11

    move v0, v1

    :cond_11
    if-eqz v0, :cond_38

    .line 661
    invoke-virtual {p1, p3}, Lcom/example/extool/WaspWingViewModel;->enableExperimentalMode(Z)V

    goto :goto_38

    .line 598
    :cond_17
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_1c

    move v0, v1

    :cond_1c
    if-eqz v0, :cond_38

    if-eqz p2, :cond_38

    .line 613
    invoke-virtual {p2}, Landroid/widget/CompoundButton;->getId()I

    move-result p2

    .line 616
    invoke-virtual {p1, p2, p3}, Lcom/example/extool/WaspWingViewModel;->updateDefaultMode(IZ)V

    goto :goto_38

    .line 624
    :cond_28
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_2d

    move v0, v1

    :cond_2d
    if-eqz v0, :cond_38

    if-eqz p2, :cond_38

    .line 639
    invoke-virtual {p2}, Landroid/widget/CompoundButton;->getId()I

    move-result p2

    .line 642
    invoke-virtual {p1, p2, p3}, Lcom/example/extool/WaspWingViewModel;->updateDefaultMode(IZ)V

    :cond_38
    :goto_38
    return-void
.end method

.method public final _internalCallbackOnClick(ILandroid/view/View;)V
    .registers 5

    const/4 p2, 0x3

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eq p1, p2, :cond_54

    const/16 p2, 0xb

    if-eq p1, p2, :cond_48

    const/4 p2, 0x5

    if-eq p1, p2, :cond_3c

    const/4 p2, 0x6

    if-eq p1, p2, :cond_30

    const/16 p2, 0x8

    if-eq p1, p2, :cond_24

    const/16 p2, 0x9

    if-eq p1, p2, :cond_18

    goto :goto_5f

    .line 672
    :cond_18
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_1d

    goto :goto_1e

    :cond_1d
    move v0, v1

    :goto_1e
    if-eqz v0, :cond_5f

    .line 682
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->downColdPwm()V

    goto :goto_5f

    .line 689
    :cond_24
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_29

    goto :goto_2a

    :cond_29
    move v0, v1

    :goto_2a
    if-eqz v0, :cond_5f

    .line 699
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->upWindPwm()V

    goto :goto_5f

    .line 723
    :cond_30
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_35

    goto :goto_36

    :cond_35
    move v0, v1

    :goto_36
    if-eqz v0, :cond_5f

    .line 733
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->downWindPwm()V

    goto :goto_5f

    .line 740
    :cond_3c
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_41

    goto :goto_42

    :cond_41
    move v0, v1

    :goto_42
    if-eqz v0, :cond_5f

    .line 750
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->upTargetTemperature()V

    goto :goto_5f

    .line 706
    :cond_48
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_4d

    goto :goto_4e

    :cond_4d
    move v0, v1

    :goto_4e
    if-eqz v0, :cond_5f

    .line 716
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->upColdPwm()V

    goto :goto_5f

    .line 757
    :cond_54
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p1, :cond_59

    goto :goto_5a

    :cond_59
    move v0, v1

    :goto_5a
    if-eqz v0, :cond_5f

    .line 767
    invoke-virtual {p1}, Lcom/example/extool/WaspWingViewModel;->downTargetTemperature()V

    :cond_5f
    :goto_5f
    return-void
.end method

.method public final _internalCallbackOnProgressChanged(ILandroid/widget/SeekBar;IZ)V
    .registers 7

    const/4 p2, 0x4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eq p1, p2, :cond_29

    const/4 p2, 0x7

    if-eq p1, p2, :cond_1b

    const/16 p2, 0xa

    if-eq p1, p2, :cond_d

    goto :goto_36

    .line 828
    :cond_d
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p4, :cond_36

    if-eqz p1, :cond_14

    goto :goto_15

    :cond_14
    move v0, v1

    :goto_15
    if-eqz v0, :cond_36

    .line 843
    invoke-virtual {p1, p3, p4}, Lcom/example/extool/WaspWingViewModel;->updateColdPwm(IZ)V

    goto :goto_36

    .line 778
    :cond_1b
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p4, :cond_36

    if-eqz p1, :cond_22

    goto :goto_23

    :cond_22
    move v0, v1

    :goto_23
    if-eqz v0, :cond_36

    .line 793
    invoke-virtual {p1, p3, p4}, Lcom/example/extool/WaspWingViewModel;->updateWindPwm(IZ)V

    goto :goto_36

    .line 803
    :cond_29
    iget-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    if-eqz p4, :cond_36

    if-eqz p1, :cond_30

    goto :goto_31

    :cond_30
    move v0, v1

    :goto_31
    if-eqz v0, :cond_36

    .line 818
    invoke-virtual {p1, p3, p4}, Lcom/example/extool/WaspWingViewModel;->updateDefaultTemperature(IZ)V

    :cond_36
    :goto_36
    return-void
.end method

.method protected executeBindings()V
    .registers 38

    move-object/from16 v1, p0

    .line 247
    monitor-enter p0

    .line 248
    :try_start_3
    iget-wide v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    const-wide/16 v4, 0x0

    .line 249
    iput-wide v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    .line 250
    monitor-exit p0
    :try_end_a
    .catchall {:try_start_3 .. :try_end_a} :catchall_3f5

    .line 281
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mData:Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    .line 301
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    const-wide/16 v6, 0x5

    and-long v8, v2, v6

    cmp-long v8, v8, v4

    const-wide/16 v9, 0x400

    const-wide/16 v11, 0x1000

    const-wide/32 v13, 0x40000

    if-eqz v8, :cond_14a

    if-eqz v0, :cond_4a

    .line 311
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getFirmwareVersion()Ljava/lang/String;

    move-result-object v18

    .line 313
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected()Z

    move-result v19

    .line 315
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealWindLevel()I

    move-result v20

    .line 317
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected()Z

    move-result v21

    .line 319
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getOverClockUsable()Z

    move-result v22

    .line 321
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRunMode()I

    move-result v23

    .line 323
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getExperimentalRunModeValue()Ljava/lang/Integer;

    move-result-object v24

    .line 325
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTargetTemperature()I

    move-result v25

    .line 327
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getAddress()Ljava/lang/String;

    move-result-object v26

    .line 329
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getRealColdLevel()I

    move-result v27

    move/from16 v15, v23

    goto :goto_5d

    :cond_4a
    const/4 v15, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    :goto_5d
    if-eqz v8, :cond_68

    if-eqz v19, :cond_64

    const-wide/16 v28, 0x4000

    goto :goto_66

    :cond_64
    const-wide/16 v28, 0x2000

    :goto_66
    or-long v2, v2, v28

    :cond_68
    and-long v28, v2, v6

    cmp-long v8, v28, v4

    if-eqz v8, :cond_8b

    if-eqz v21, :cond_79

    or-long/2addr v2, v9

    or-long/2addr v2, v11

    or-long/2addr v2, v13

    const-wide/32 v16, 0x100000

    or-long v2, v2, v16

    goto :goto_8b

    :cond_79
    const-wide/16 v28, 0x200

    or-long v2, v2, v28

    const-wide/16 v28, 0x800

    or-long v2, v2, v28

    const-wide/32 v28, 0x20000

    or-long v2, v2, v28

    const-wide/32 v28, 0x80000

    or-long v2, v2, v28

    :cond_8b
    :goto_8b
    and-long v28, v2, v6

    cmp-long v8, v28, v4

    if-eqz v8, :cond_9a

    if-eqz v22, :cond_96

    const-wide/16 v28, 0x10

    goto :goto_98

    :cond_96
    const-wide/16 v28, 0x8

    :goto_98
    or-long v2, v2, v28

    :cond_9a
    if-nez v18, :cond_9f

    const/16 v28, 0x1

    goto :goto_a1

    :cond_9f
    const/16 v28, 0x0

    :goto_a1
    if-eqz v19, :cond_a6

    const-string v19, "\u5df2\u8fde\u63a5"

    goto :goto_a8

    :cond_a6
    const-string v19, "\u626b\u63cf\u4e2d"

    :goto_a8
    move-object/from16 v8, v19

    .line 368
    invoke-static/range {v20 .. v20}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    if-eqz v22, :cond_b3

    const-string v10, "\u53ef\u7528"

    goto :goto_b5

    :cond_b3
    const-string v10, "\u4e0d\u53ef\u7528"

    :goto_b5
    if-nez v15, :cond_ba

    const/16 v19, 0x1

    goto :goto_bc

    :cond_ba
    const/16 v19, 0x0

    :goto_bc
    if-eqz v15, :cond_c1

    const/16 v31, 0x1

    goto :goto_c3

    :cond_c1
    const/16 v31, 0x0

    :goto_c3
    const/4 v11, 0x2

    if-ne v15, v11, :cond_c8

    const/4 v11, 0x1

    goto :goto_c9

    :cond_c8
    const/4 v11, 0x0

    .line 378
    :goto_c9
    invoke-static/range {v24 .. v24}, Landroidx/databinding/ViewDataBinding;->safeUnbox(Ljava/lang/Integer;)I

    move-result v12

    .line 380
    invoke-static/range {v25 .. v25}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v15

    if-nez v26, :cond_d6

    const/16 v24, 0x1

    goto :goto_d8

    :cond_d6
    const/16 v24, 0x0

    .line 384
    :goto_d8
    invoke-static/range {v27 .. v27}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v13

    and-long v33, v2, v6

    cmp-long v14, v33, v4

    if-eqz v14, :cond_eb

    if-eqz v28, :cond_e7

    const-wide/16 v33, 0x40

    goto :goto_e9

    :cond_e7
    const-wide/16 v33, 0x20

    :goto_e9
    or-long v2, v2, v33

    :cond_eb
    and-long v33, v2, v6

    cmp-long v14, v33, v4

    if-eqz v14, :cond_fa

    if-eqz v19, :cond_f6

    const-wide/16 v33, 0x100

    goto :goto_f8

    :cond_f6
    const-wide/16 v33, 0x80

    :goto_f8
    or-long v2, v2, v33

    :cond_fa
    and-long v33, v2, v6

    cmp-long v14, v33, v4

    if-eqz v14, :cond_10b

    if-eqz v24, :cond_106

    const-wide/32 v33, 0x10000

    goto :goto_109

    :cond_106
    const-wide/32 v33, 0x8000

    :goto_109
    or-long v2, v2, v33

    :cond_10b
    const-string v14, "\u8fde\u63a5\u72b6\u6001\uff1a"

    .line 412
    invoke-virtual {v14, v8}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const-string v14, "\u8d85\u9891\u529f\u80fd\uff1a"

    .line 414
    invoke-virtual {v14, v10}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    if-eqz v19, :cond_11c

    const-string v14, "\u6700\u5927\u98ce\u901f\uff1a"

    goto :goto_11e

    :cond_11c
    const-string v14, "\u98ce\u901f\uff1a"

    :goto_11e
    if-eqz v12, :cond_123

    const/16 v29, 0x1

    goto :goto_125

    :cond_123
    const/16 v29, 0x0

    :goto_125
    const-string v12, "\u76ee\u6807\u6e29\u5ea6\uff1a"

    .line 420
    invoke-virtual {v12, v15}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    const-string v15, "\u5236\u51b7\u7247\u5f3a\u5ea6\uff1a"

    .line 422
    invoke-virtual {v15, v13}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 427
    invoke-virtual {v14, v9}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    move/from16 v14, v19

    move/from16 v15, v22

    move/from16 v35, v27

    move-object/from16 v19, v8

    move/from16 v22, v11

    move/from16 v8, v21

    move/from16 v11, v31

    move-object/from16 v21, v10

    move/from16 v10, v25

    move/from16 v25, v29

    goto :goto_166

    :cond_14a
    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v28, 0x0

    const/16 v35, 0x0

    :goto_166
    and-long/2addr v6, v2

    cmp-long v6, v6, v4

    if-eqz v6, :cond_184

    if-eqz v28, :cond_16f

    const-string v18, ""

    :cond_16f
    move-object/from16 v7, v18

    if-eqz v24, :cond_175

    const-string v26, ""

    :cond_175
    move-object/from16 v4, v26

    const-string v5, "\u56fa\u4ef6\u7248\u672c\uff1a"

    .line 441
    invoke-virtual {v5, v7}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v7, "Mac\uff1a"

    .line 443
    invoke-virtual {v7, v4}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_186

    :cond_184
    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_186
    const-wide/32 v16, 0x100000

    and-long v16, v2, v16

    const-wide/16 v26, 0x0

    cmp-long v7, v16, v26

    if-eqz v7, :cond_1b1

    if-eqz v0, :cond_19a

    .line 449
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getSpeed()I

    move-result v7

    move-object/from16 v16, v5

    goto :goto_19d

    :cond_19a
    move-object/from16 v16, v5

    const/4 v7, 0x0

    .line 454
    :goto_19d
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, ""

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_1b4

    :cond_1b1
    move-object/from16 v16, v5

    const/4 v5, 0x0

    :goto_1b4
    const-wide/32 v17, 0x40000

    and-long v17, v2, v17

    const-wide/16 v26, 0x0

    cmp-long v7, v17, v26

    if-eqz v7, :cond_1fd

    if-eqz v0, :cond_1d2

    .line 460
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTemperature()I

    move-result v7

    .line 462
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getTemperatureDecimal()I

    move-result v17

    move-object/from16 v18, v13

    move/from16 v36, v17

    move-object/from16 v17, v5

    move/from16 v5, v36

    goto :goto_1d8

    :cond_1d2
    move-object/from16 v17, v5

    move-object/from16 v18, v13

    const/4 v5, 0x0

    const/4 v7, 0x0

    .line 467
    :goto_1d8
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v13, "."

    invoke-virtual {v7, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 471
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_202

    :cond_1fd
    move-object/from16 v17, v5

    move-object/from16 v18, v13

    const/4 v5, 0x0

    :goto_202
    const-wide/16 v31, 0x1000

    and-long v31, v2, v31

    const-wide/16 v26, 0x0

    cmp-long v7, v31, v26

    if-eqz v7, :cond_228

    if-eqz v0, :cond_213

    .line 477
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getHotSurfaceTemperature()B

    move-result v7

    goto :goto_214

    :cond_213
    const/4 v7, 0x0

    .line 482
    :goto_214
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v13, "\u00b0"

    invoke-virtual {v7, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_229

    :cond_228
    const/4 v7, 0x0

    :goto_229
    const-wide/16 v29, 0x400

    and-long v29, v2, v29

    const-wide/16 v26, 0x0

    cmp-long v13, v29, v26

    if-eqz v13, :cond_24f

    if-eqz v0, :cond_23a

    .line 488
    invoke-virtual {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->getColdRunLevel()I

    move-result v0

    goto :goto_23b

    :cond_23a
    const/4 v0, 0x0

    .line 493
    :goto_23b
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v13, ""

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_250

    :cond_24f
    const/4 v0, 0x0

    :goto_250
    if-eqz v6, :cond_28f

    if-eqz v8, :cond_255

    goto :goto_257

    :cond_255
    const-string v0, "--"

    :goto_257
    if-eqz v8, :cond_25a

    goto :goto_25c

    :cond_25a
    const-string v7, "--"

    :goto_25c
    if-eqz v8, :cond_25f

    goto :goto_261

    :cond_25f
    const-string v5, "--"

    :goto_261
    if-eqz v8, :cond_268

    move-wide/from16 v29, v2

    move-object/from16 v13, v17

    goto :goto_26c

    :cond_268
    const-string v13, "--"

    move-wide/from16 v29, v2

    :goto_26c
    const-string v2, "\u5236\u51b7\u7247\u5f3a\u5ea6\r\n"

    .line 509
    invoke-virtual {v2, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "\u70ed\u9762\u6e29\u5ea6\r\n"

    .line 511
    invoke-virtual {v2, v7}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\u51b7\u9762\u6e29\u5ea6\r\n"

    .line 513
    invoke-virtual {v3, v5}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v5, "\u98ce\u6247\u8f6c\u901f\r\n"

    .line 515
    invoke-virtual {v5, v13}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    if-eqz v3, :cond_28d

    const-string v7, "\u00b0"

    .line 520
    invoke-virtual {v3, v7}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_295

    :cond_28d
    const/4 v3, 0x0

    goto :goto_295

    :cond_28f
    move-wide/from16 v29, v2

    const/4 v0, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v5, 0x0

    :goto_295
    if-eqz v6, :cond_35b

    .line 527
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView11:Landroid/widget/LinearLayout;

    invoke-static {v6, v14}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 528
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView12:Landroid/widget/TextView;

    invoke-static {v6, v12}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 529
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView13:Landroid/widget/LinearLayout;

    invoke-virtual {v6, v15}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 530
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView14:Landroid/widget/Button;

    invoke-virtual {v6, v8}, Landroid/widget/Button;->setEnabled(Z)V

    .line 531
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    invoke-virtual {v6, v8}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 532
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    invoke-static {v6, v10}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setProgress(Landroid/widget/SeekBar;I)V

    .line 533
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView16:Landroid/widget/Button;

    invoke-virtual {v6, v8}, Landroid/widget/Button;->setEnabled(Z)V

    .line 534
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView17:Landroid/widget/TextView;

    invoke-static {v6, v9}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 535
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView18:Landroid/widget/Button;

    invoke-virtual {v6, v15}, Landroid/widget/Button;->setEnabled(Z)V

    .line 536
    iget-object v6, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView2:Landroid/widget/TextView;

    invoke-static {v6, v4}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 537
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView20:Landroid/widget/Button;

    invoke-virtual {v4, v15}, Landroid/widget/Button;->setEnabled(Z)V

    .line 538
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView21:Landroid/widget/LinearLayout;

    invoke-static {v4, v11}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 539
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView22:Landroid/widget/TextView;

    move-object/from16 v13, v18

    invoke-static {v4, v13}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 540
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView23:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v15}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 541
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView24:Landroid/widget/Button;

    invoke-virtual {v4, v15}, Landroid/widget/Button;->setEnabled(Z)V

    .line 542
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView26:Landroid/widget/Button;

    invoke-virtual {v4, v15}, Landroid/widget/Button;->setEnabled(Z)V

    .line 543
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView27:Landroid/widget/LinearLayout;

    invoke-static {v4, v15}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 544
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView28:Lcom/google/android/material/switchmaterial/SwitchMaterial;

    move/from16 v6, v25

    invoke-static {v4, v6}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setChecked(Landroid/widget/CompoundButton;Z)V

    .line 545
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView28:Lcom/google/android/material/switchmaterial/SwitchMaterial;

    move/from16 v11, v22

    invoke-static {v4, v11}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 546
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView29:Landroid/widget/TextView;

    invoke-static {v4, v11}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 547
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView3:Landroid/widget/TextView;

    move-object/from16 v6, v16

    invoke-static {v4, v6}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 548
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView30:Landroid/widget/TextView;

    invoke-static {v4, v11}, Lcom/example/extool/BindingAdapterKt;->goneUnless(Landroid/view/View;Z)V

    .line 549
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView4:Landroid/widget/TextView;

    move-object/from16 v10, v21

    invoke-static {v4, v10}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 550
    iget-object v4, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView5:Landroid/widget/TextView;

    invoke-static {v4, v3}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 551
    iget-object v3, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView6:Landroid/widget/TextView;

    invoke-static {v3, v2}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 552
    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView7:Landroid/widget/TextView;

    invoke-static {v2, v5}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 553
    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView8:Landroid/widget/TextView;

    invoke-static {v2, v0}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    .line 554
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbManual:Landroid/widget/RadioButton;

    invoke-static {v0, v11}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setChecked(Landroid/widget/CompoundButton;Z)V

    .line 555
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbManual:Landroid/widget/RadioButton;

    invoke-virtual {v0, v8}, Landroid/widget/RadioButton;->setEnabled(Z)V

    .line 556
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbSmart:Landroid/widget/RadioButton;

    invoke-static {v0, v14}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setChecked(Landroid/widget/CompoundButton;Z)V

    .line 557
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbSmart:Landroid/widget/RadioButton;

    invoke-virtual {v0, v8}, Landroid/widget/RadioButton;->setEnabled(Z)V

    .line 558
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    invoke-virtual {v0, v15}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 559
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    move/from16 v2, v35

    invoke-static {v0, v2}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setProgress(Landroid/widget/SeekBar;I)V

    .line 560
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    invoke-virtual {v0, v15}, Landroid/widget/SeekBar;->setEnabled(Z)V

    .line 561
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    move/from16 v2, v20

    invoke-static {v0, v2}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setProgress(Landroid/widget/SeekBar;I)V

    .line 562
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->tvConnectState:Landroid/widget/TextView;

    move-object/from16 v8, v19

    invoke-static {v0, v8}, Landroidx/databinding/adapters/TextViewBindingAdapter;->setText(Landroid/widget/TextView;Ljava/lang/CharSequence;)V

    :cond_35b
    const-wide/16 v2, 0x4

    and-long v2, v29, v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-eqz v0, :cond_3f4

    .line 567
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView14:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback3:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 568
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    const/16 v2, 0x23

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMax(I)V

    .line 569
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    const/4 v2, 0x0

    move-object v15, v2

    check-cast v15, Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStartTrackingTouch;

    move-object v15, v2

    check-cast v15, Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStopTrackingTouch;

    iget-object v3, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback4:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    move-object v15, v2

    check-cast v15, Landroidx/databinding/InverseBindingListener;

    invoke-static {v0, v2, v2, v3, v2}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setOnSeekBarChangeListener(Landroid/widget/SeekBar;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStartTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStopTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;Landroidx/databinding/InverseBindingListener;)V

    .line 570
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView16:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback5:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 571
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView18:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback6:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 572
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView20:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback8:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 573
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView24:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback9:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 574
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView26:Landroid/widget/Button;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback11:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 575
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView28:Lcom/google/android/material/switchmaterial/SwitchMaterial;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback12:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    const/4 v3, 0x0

    invoke-static {v0, v2, v3}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setListeners(Landroid/widget/CompoundButton;Landroid/widget/CompoundButton$OnCheckedChangeListener;Landroidx/databinding/InverseBindingListener;)V

    .line 576
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbManual:Landroid/widget/RadioButton;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback2:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-static {v0, v2, v3}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setListeners(Landroid/widget/CompoundButton;Landroid/widget/CompoundButton$OnCheckedChangeListener;Landroidx/databinding/InverseBindingListener;)V

    .line 577
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->rbSmart:Landroid/widget/RadioButton;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback1:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    invoke-static {v0, v2, v3}, Landroidx/databinding/adapters/CompoundButtonBindingAdapter;->setListeners(Landroid/widget/CompoundButton;Landroid/widget/CompoundButton$OnCheckedChangeListener;Landroidx/databinding/InverseBindingListener;)V

    .line 578
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    const/16 v2, 0xe5

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMax(I)V

    .line 579
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback10:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    invoke-static {v0, v3, v3, v2, v3}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setOnSeekBarChangeListener(Landroid/widget/SeekBar;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStartTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStopTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;Landroidx/databinding/InverseBindingListener;)V

    .line 580
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    const/16 v2, 0x1770

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMax(I)V

    .line 581
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    iget-object v2, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mCallback7:Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;

    invoke-static {v0, v3, v3, v2, v3}, Landroidx/databinding/adapters/SeekBarBindingAdapter;->setOnSeekBarChangeListener(Landroid/widget/SeekBar;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStartTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnStopTrackingTouch;Landroidx/databinding/adapters/SeekBarBindingAdapter$OnProgressChanged;Landroidx/databinding/InverseBindingListener;)V

    .line 583
    invoke-static {}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->getBuildSdkInt()I

    move-result v0

    const/16 v2, 0x1a

    if-lt v0, v2, :cond_3f4

    .line 585
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mboundView15:Landroid/widget/SeekBar;

    const/4 v2, 0x5

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMin(I)V

    .line 586
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbCold:Landroid/widget/SeekBar;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMin(I)V

    .line 587
    iget-object v0, v1, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->sbWind:Landroid/widget/SeekBar;

    const/16 v2, 0x7d0

    invoke-virtual {v0, v2}, Landroid/widget/SeekBar;->setMin(I)V

    :cond_3f4
    return-void

    :catchall_3f5
    move-exception v0

    .line 250
    :try_start_3f6
    monitor-exit p0
    :try_end_3f7
    .catchall {:try_start_3f6 .. :try_end_3f7} :catchall_3f5

    throw v0
.end method

.method public hasPendingBindings()Z
    .registers 5

    .line 197
    monitor-enter p0

    .line 198
    :try_start_1
    iget-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_c

    .line 199
    monitor-exit p0

    const/4 v0, 0x1

    return v0

    .line 201
    :cond_c
    monitor-exit p0

    const/4 v0, 0x0

    return v0

    :catchall_f
    move-exception v0

    monitor-exit p0
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_f

    throw v0
.end method

.method public invalidateAll()V
    .registers 3

    .line 189
    monitor-enter p0

    const-wide/16 v0, 0x4

    .line 190
    :try_start_3
    iput-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    .line 191
    monitor-exit p0
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_a

    .line 192
    invoke-virtual {p0}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->requestRebind()V

    return-void

    :catchall_a
    move-exception v0

    .line 191
    :try_start_b
    monitor-exit p0
    :try_end_c
    .catchall {:try_start_b .. :try_end_c} :catchall_a

    throw v0
.end method

.method protected onFieldChange(ILjava/lang/Object;I)Z
    .registers 4

    const/4 p1, 0x0

    return p1
.end method

.method public setData(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V
    .registers 6

    .line 221
    iput-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mData:Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    .line 222
    monitor-enter p0

    .line 223
    :try_start_3
    iget-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    const-wide/16 v2, 0x1

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    .line 224
    monitor-exit p0
    :try_end_b
    .catchall {:try_start_3 .. :try_end_b} :catchall_13

    const/4 p1, 0x1

    .line 225
    invoke-virtual {p0, p1}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->notifyPropertyChanged(I)V

    .line 226
    invoke-super {p0}, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;->requestRebind()V

    return-void

    :catchall_13
    move-exception p1

    .line 224
    :try_start_14
    monitor-exit p0
    :try_end_15
    .catchall {:try_start_14 .. :try_end_15} :catchall_13

    throw p1
.end method

.method public setVariable(ILjava/lang/Object;)Z
    .registers 5

    const/4 v0, 0x1

    if-ne v0, p1, :cond_9

    .line 209
    check-cast p2, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    invoke-virtual {p0, p2}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->setData(Lcom/flydigi/sdk/waspwing/WaspWingInfo;)V

    goto :goto_13

    :cond_9
    const/4 v1, 0x2

    if-ne v1, p1, :cond_12

    .line 212
    check-cast p2, Lcom/example/extool/WaspWingViewModel;

    invoke-virtual {p0, p2}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->setViewModel(Lcom/example/extool/WaspWingViewModel;)V

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    return v0
.end method

.method public setViewModel(Lcom/example/extool/WaspWingViewModel;)V
    .registers 6

    .line 229
    iput-object p1, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mViewModel:Lcom/example/extool/WaspWingViewModel;

    .line 230
    monitor-enter p0

    .line 231
    :try_start_3
    iget-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    const-wide/16 v2, 0x2

    or-long/2addr v0, v2

    iput-wide v0, p0, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->mDirtyFlags:J

    .line 232
    monitor-exit p0
    :try_end_b
    .catchall {:try_start_3 .. :try_end_b} :catchall_13

    const/4 p1, 0x2

    .line 233
    invoke-virtual {p0, p1}, Lcom/example/extool/databinding/ActivityExperimentalB6BindingImpl;->notifyPropertyChanged(I)V

    .line 234
    invoke-super {p0}, Lcom/example/extool/databinding/ActivityExperimentalB6Binding;->requestRebind()V

    return-void

    :catchall_13
    move-exception p1

    .line 232
    :try_start_14
    monitor-exit p0
    :try_end_15
    .catchall {:try_start_14 .. :try_end_15} :catchall_13

    throw p1
.end method
