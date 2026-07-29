.class public Lcom/google/android/material/datepicker/SingleDateSelector;
.super Ljava/lang/Object;
.source "SingleDateSelector.java"

# interfaces
.implements Lcom/google/android/material/datepicker/DateSelector;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/material/datepicker/DateSelector<",
        "Ljava/lang/Long;",
        ">;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/google/android/material/datepicker/SingleDateSelector;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private error:Ljava/lang/CharSequence;

.field private selectedItem:Ljava/lang/Long;

.field private textInputFormat:Ljava/text/SimpleDateFormat;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/google/android/material/datepicker/SingleDateSelector$2;

    invoke-direct {v0}, Lcom/google/android/material/datepicker/SingleDateSelector$2;-><init>()V

    sput-object v0, Lcom/google/android/material/datepicker/SingleDateSelector;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/material/datepicker/SingleDateSelector;)V
    .registers 1

    invoke-direct {p0}, Lcom/google/android/material/datepicker/SingleDateSelector;->clearSelection()V

    return-void
.end method

.method static synthetic access$102(Lcom/google/android/material/datepicker/SingleDateSelector;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->error:Ljava/lang/CharSequence;

    return-object p1
.end method

.method static synthetic access$202(Lcom/google/android/material/datepicker/SingleDateSelector;Ljava/lang/Long;)Ljava/lang/Long;
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    return-object p1
.end method

.method private clearSelection()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public getDefaultThemeResId(Landroid/content/Context;)I
    .registers 4

    sget v0, Lcom/google/android/material/R$attr;->materialCalendarTheme:I

    const-class v1, Lcom/google/android/material/datepicker/MaterialDatePicker;

    invoke-virtual {v1}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lcom/google/android/material/resources/MaterialAttributes;->resolveOrThrow(Landroid/content/Context;ILjava/lang/String;)I

    move-result p1

    return p1
.end method

.method public getDefaultTitleResId()I
    .registers 2

    sget v0, Lcom/google/android/material/R$string;->mtrl_picker_date_header_title:I

    return v0
.end method

.method public getError()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->error:Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_a

    const/4 v0, 0x0

    goto :goto_10

    :cond_a
    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->error:Ljava/lang/CharSequence;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_10
    return-object v0
.end method

.method public getSelectedDays()Ljava/util/Collection;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    if-eqz v1, :cond_c

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_c
    return-object v0
.end method

.method public getSelectedRanges()Ljava/util/Collection;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection<",
            "Landroidx/core/util/Pair<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    return-object v0
.end method

.method public getSelection()Ljava/lang/Long;
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    return-object v0
.end method

.method public bridge synthetic getSelection()Ljava/lang/Object;
    .registers 2

    invoke-virtual {p0}, Lcom/google/android/material/datepicker/SingleDateSelector;->getSelection()Ljava/lang/Long;

    move-result-object v0

    return-object v0
.end method

.method public getSelectionContentDescription(Landroid/content/Context;)Ljava/lang/String;
    .registers 6

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    if-nez v0, :cond_f

    sget v0, Lcom/google/android/material/R$string;->mtrl_picker_announce_current_selection_none:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_17

    :cond_f
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/DateStrings;->getYearMonthDay(J)Ljava/lang/String;

    move-result-object v0

    :goto_17
    sget v1, Lcom/google/android/material/R$string;->mtrl_picker_announce_current_selection:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p1, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public getSelectionDisplayString(Landroid/content/Context;)Ljava/lang/String;
    .registers 6

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    if-nez v0, :cond_f

    sget v0, Lcom/google/android/material/R$string;->mtrl_picker_date_header_unselected:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_f
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/DateStrings;->getYearMonthDay(J)Ljava/lang/String;

    move-result-object v0

    sget v1, Lcom/google/android/material/R$string;->mtrl_picker_date_header_selected:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p1, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public isSelectionComplete()Z
    .registers 2

    iget-object v0, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    goto :goto_7

    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0
.end method

.method public onCreateTextInputView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;Lcom/google/android/material/datepicker/CalendarConstraints;Lcom/google/android/material/datepicker/OnSelectionChangedListener;)Landroid/view/View;
    .registers 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            "Landroid/view/ViewGroup;",
            "Landroid/os/Bundle;",
            "Lcom/google/android/material/datepicker/CalendarConstraints;",
            "Lcom/google/android/material/datepicker/OnSelectionChangedListener<",
            "Ljava/lang/Long;",
            ">;)",
            "Landroid/view/View;"
        }
    .end annotation

    sget p3, Lcom/google/android/material/R$layout;->mtrl_picker_text_input_date:I

    const/4 v0, 0x0

    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    sget p2, Lcom/google/android/material/R$id;->mtrl_picker_text_input_date:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    move-object v8, p2

    check-cast v8, Lcom/google/android/material/textfield/TextInputLayout;

    invoke-virtual {v8, v0}, Lcom/google/android/material/textfield/TextInputLayout;->setErrorAccessibilityLiveRegion(I)V

    invoke-virtual {v8}, Lcom/google/android/material/textfield/TextInputLayout;->getEditText()Landroid/widget/EditText;

    move-result-object p2

    invoke-static {}, Lcom/google/android/material/internal/ManufacturerUtils;->isDateInputKeyboardMissingSeparatorCharacters()Z

    move-result p3

    if-eqz p3, :cond_22

    const/16 p3, 0x11

    invoke-virtual {p2, p3}, Landroid/widget/EditText;->setInputType(I)V

    :cond_22
    iget-object p3, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->textInputFormat:Ljava/text/SimpleDateFormat;

    const/4 v9, 0x1

    if-eqz p3, :cond_29

    move v1, v9

    goto :goto_2a

    :cond_29
    move v1, v0

    :goto_2a
    if-eqz v1, :cond_2d

    goto :goto_31

    :cond_2d
    invoke-static {}, Lcom/google/android/material/datepicker/UtcDates;->getDefaultTextInputFormat()Ljava/text/SimpleDateFormat;

    move-result-object p3

    :goto_31
    move-object v4, p3

    if-eqz v1, :cond_39

    invoke-virtual {v4}, Ljava/text/SimpleDateFormat;->toPattern()Ljava/lang/String;

    move-result-object p3

    goto :goto_41

    :cond_39
    invoke-virtual {p1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object p3

    invoke-static {p3, v4}, Lcom/google/android/material/datepicker/UtcDates;->getDefaultTextInputHint(Landroid/content/res/Resources;Ljava/text/SimpleDateFormat;)Ljava/lang/String;

    move-result-object p3

    :goto_41
    move-object v3, p3

    invoke-virtual {v8, v3}, Lcom/google/android/material/textfield/TextInputLayout;->setPlaceholderText(Ljava/lang/CharSequence;)V

    iget-object p3, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    if-eqz p3, :cond_50

    invoke-virtual {v4, p3}, Ljava/text/SimpleDateFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p3

    invoke-virtual {p2, p3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    :cond_50
    new-instance p3, Lcom/google/android/material/datepicker/SingleDateSelector$1;

    move-object v1, p3

    move-object v2, p0

    move-object v5, v8

    move-object v6, p4

    move-object v7, p5

    invoke-direct/range {v1 .. v8}, Lcom/google/android/material/datepicker/SingleDateSelector$1;-><init>(Lcom/google/android/material/datepicker/SingleDateSelector;Ljava/lang/String;Ljava/text/DateFormat;Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/datepicker/CalendarConstraints;Lcom/google/android/material/datepicker/OnSelectionChangedListener;Lcom/google/android/material/textfield/TextInputLayout;)V

    invoke-virtual {p2, p3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    new-array p3, v9, [Landroid/widget/EditText;

    aput-object p2, p3, v0

    invoke-static {p3}, Lcom/google/android/material/datepicker/DateSelector;->showKeyboardWithAutoHideBehavior([Landroid/widget/EditText;)V

    return-object p1
.end method

.method public select(J)V
    .registers 3

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    return-void
.end method

.method public setSelection(Ljava/lang/Long;)V
    .registers 4

    if-nez p1, :cond_4

    const/4 p1, 0x0

    goto :goto_10

    :cond_4
    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/UtcDates;->canonicalYearMonthDay(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    :goto_10
    iput-object p1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    return-void
.end method

.method public bridge synthetic setSelection(Ljava/lang/Object;)V
    .registers 2

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p0, p1}, Lcom/google/android/material/datepicker/SingleDateSelector;->setSelection(Ljava/lang/Long;)V

    return-void
.end method

.method public setTextInputFormat(Ljava/text/SimpleDateFormat;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->textInputFormat:Ljava/text/SimpleDateFormat;

    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 3

    iget-object p2, p0, Lcom/google/android/material/datepicker/SingleDateSelector;->selectedItem:Ljava/lang/Long;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeValue(Ljava/lang/Object;)V

    return-void
.end method
