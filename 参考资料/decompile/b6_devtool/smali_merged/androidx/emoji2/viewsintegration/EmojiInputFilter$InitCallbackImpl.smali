.class Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;
.super Landroidx/emoji2/text/EmojiCompat$InitCallback;
.source "EmojiInputFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/emoji2/viewsintegration/EmojiInputFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "InitCallbackImpl"
.end annotation


# instance fields
.field private final mEmojiInputFilterReference:Ljava/lang/ref/Reference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/Reference<",
            "Landroidx/emoji2/viewsintegration/EmojiInputFilter;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewRef:Ljava/lang/ref/Reference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/Reference<",
            "Landroid/widget/TextView;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/widget/TextView;Landroidx/emoji2/viewsintegration/EmojiInputFilter;)V
    .registers 4

    .line 105
    invoke-direct {p0}, Landroidx/emoji2/text/EmojiCompat$InitCallback;-><init>()V

    .line 106
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;->mViewRef:Ljava/lang/ref/Reference;

    .line 107
    new-instance p1, Ljava/lang/ref/WeakReference;

    invoke-direct {p1, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;->mEmojiInputFilterReference:Ljava/lang/ref/Reference;

    return-void
.end method

.method private isInputFilterCurrentlyRegisteredOnTextView(Landroid/widget/TextView;Landroid/text/InputFilter;)Z
    .registers 6

    const/4 v0, 0x0

    if-eqz p2, :cond_1a

    if-nez p1, :cond_6

    goto :goto_1a

    .line 148
    :cond_6
    invoke-virtual {p1}, Landroid/widget/TextView;->getFilters()[Landroid/text/InputFilter;

    move-result-object p1

    if-nez p1, :cond_d

    return v0

    :cond_d
    move v1, v0

    .line 153
    :goto_e
    array-length v2, p1

    if-ge v1, v2, :cond_1a

    .line 154
    aget-object v2, p1, v1

    if-ne v2, p2, :cond_17

    const/4 p1, 0x1

    return p1

    :cond_17
    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    :cond_1a
    :goto_1a
    return v0
.end method


# virtual methods
.method public onInitialized()V
    .registers 5

    .line 112
    invoke-super {p0}, Landroidx/emoji2/text/EmojiCompat$InitCallback;->onInitialized()V

    .line 113
    iget-object v0, p0, Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;->mViewRef:Ljava/lang/ref/Reference;

    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 114
    iget-object v1, p0, Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;->mEmojiInputFilterReference:Ljava/lang/ref/Reference;

    invoke-virtual {v1}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/text/InputFilter;

    .line 115
    invoke-direct {p0, v0, v1}, Landroidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl;->isInputFilterCurrentlyRegisteredOnTextView(Landroid/widget/TextView;Landroid/text/InputFilter;)Z

    move-result v1

    if-nez v1, :cond_1a

    return-void

    .line 116
    :cond_1a
    invoke-virtual {v0}, Landroid/widget/TextView;->isAttachedToWindow()Z

    move-result v1

    if-eqz v1, :cond_43

    .line 117
    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    .line 118
    invoke-static {}, Landroidx/emoji2/text/EmojiCompat;->get()Landroidx/emoji2/text/EmojiCompat;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroidx/emoji2/text/EmojiCompat;->process(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v2

    if-ne v1, v2, :cond_2f

    return-void

    .line 131
    :cond_2f
    invoke-static {v2}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v1

    .line 132
    invoke-static {v2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v3

    .line 134
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 136
    instance-of v0, v2, Landroid/text/Spannable;

    if-eqz v0, :cond_43

    .line 137
    check-cast v2, Landroid/text/Spannable;

    invoke-static {v2, v1, v3}, Landroidx/emoji2/viewsintegration/EmojiInputFilter;->updateSelection(Landroid/text/Spannable;II)V

    :cond_43
    return-void
.end method
