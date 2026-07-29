.class public final Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
.super Ljava/lang/Object;
.source "MaterialDatePicker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/material/datepicker/MaterialDatePicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<S:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

.field final dateSelector:Lcom/google/android/material/datepicker/DateSelector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/material/datepicker/DateSelector<",
            "TS;>;"
        }
    .end annotation
.end field

.field dayViewDecorator:Lcom/google/android/material/datepicker/DayViewDecorator;

.field inputMode:I

.field negativeButtonText:Ljava/lang/CharSequence;

.field negativeButtonTextResId:I

.field overrideThemeResId:I

.field positiveButtonText:Ljava/lang/CharSequence;

.field positiveButtonTextResId:I

.field selection:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TS;"
        }
    .end annotation
.end field

.field titleText:Ljava/lang/CharSequence;

.field titleTextResId:I


# direct methods
.method private constructor <init>(Lcom/google/android/material/datepicker/DateSelector;)V
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/material/datepicker/DateSelector<",
            "TS;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->overrideThemeResId:I

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleTextResId:I

    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleText:Ljava/lang/CharSequence;

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonTextResId:I

    iput-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonText:Ljava/lang/CharSequence;

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonTextResId:I

    iput-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonText:Ljava/lang/CharSequence;

    iput-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->selection:Ljava/lang/Object;

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->inputMode:I

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    return-void
.end method

.method private createDefaultOpenAt()Lcom/google/android/material/datepicker/Month;
    .registers 3

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    invoke-interface {v0}, Lcom/google/android/material/datepicker/DateSelector;->getSelectedDays()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2d

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    invoke-interface {v0}, Lcom/google/android/material/datepicker/DateSelector;->getSelectedDays()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/Month;->create(J)Lcom/google/android/material/datepicker/Month;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->monthInValidRange(Lcom/google/android/material/datepicker/Month;Lcom/google/android/material/datepicker/CalendarConstraints;)Z

    move-result v1

    if-eqz v1, :cond_2d

    return-object v0

    :cond_2d
    invoke-static {}, Lcom/google/android/material/datepicker/Month;->current()Lcom/google/android/material/datepicker/Month;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    invoke-static {v0, v1}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->monthInValidRange(Lcom/google/android/material/datepicker/Month;Lcom/google/android/material/datepicker/CalendarConstraints;)Z

    move-result v1

    if-eqz v1, :cond_3a

    goto :goto_40

    :cond_3a
    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    invoke-virtual {v0}, Lcom/google/android/material/datepicker/CalendarConstraints;->getStart()Lcom/google/android/material/datepicker/Month;

    move-result-object v0

    :goto_40
    return-object v0
.end method

.method public static customDatePicker(Lcom/google/android/material/datepicker/DateSelector;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/google/android/material/datepicker/DateSelector<",
            "TS;>;)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;

    invoke-direct {v0, p0}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;-><init>(Lcom/google/android/material/datepicker/DateSelector;)V

    return-object v0
.end method

.method public static datePicker()Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;

    new-instance v1, Lcom/google/android/material/datepicker/SingleDateSelector;

    invoke-direct {v1}, Lcom/google/android/material/datepicker/SingleDateSelector;-><init>()V

    invoke-direct {v0, v1}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;-><init>(Lcom/google/android/material/datepicker/DateSelector;)V

    return-object v0
.end method

.method public static dateRangePicker()Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "Landroidx/core/util/Pair<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;>;"
        }
    .end annotation

    new-instance v0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;

    new-instance v1, Lcom/google/android/material/datepicker/RangeDateSelector;

    invoke-direct {v1}, Lcom/google/android/material/datepicker/RangeDateSelector;-><init>()V

    invoke-direct {v0, v1}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;-><init>(Lcom/google/android/material/datepicker/DateSelector;)V

    return-object v0
.end method

.method private static monthInValidRange(Lcom/google/android/material/datepicker/Month;Lcom/google/android/material/datepicker/CalendarConstraints;)Z
    .registers 3

    invoke-virtual {p1}, Lcom/google/android/material/datepicker/CalendarConstraints;->getStart()Lcom/google/android/material/datepicker/Month;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/material/datepicker/Month;->compareTo(Lcom/google/android/material/datepicker/Month;)I

    move-result v0

    if-ltz v0, :cond_16

    invoke-virtual {p1}, Lcom/google/android/material/datepicker/CalendarConstraints;->getEnd()Lcom/google/android/material/datepicker/Month;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/datepicker/Month;->compareTo(Lcom/google/android/material/datepicker/Month;)I

    move-result p0

    if-gtz p0, :cond_16

    const/4 p0, 0x1

    goto :goto_17

    :cond_16
    const/4 p0, 0x0

    :goto_17
    return p0
.end method


# virtual methods
.method public build()Lcom/google/android/material/datepicker/MaterialDatePicker;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/android/material/datepicker/MaterialDatePicker<",
            "TS;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    if-nez v0, :cond_f

    new-instance v0, Lcom/google/android/material/datepicker/CalendarConstraints$Builder;

    invoke-direct {v0}, Lcom/google/android/material/datepicker/CalendarConstraints$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/material/datepicker/CalendarConstraints$Builder;->build()Lcom/google/android/material/datepicker/CalendarConstraints;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    :cond_f
    iget v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleTextResId:I

    if-nez v0, :cond_1b

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    invoke-interface {v0}, Lcom/google/android/material/datepicker/DateSelector;->getDefaultTitleResId()I

    move-result v0

    iput v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleTextResId:I

    :cond_1b
    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->selection:Ljava/lang/Object;

    if-eqz v0, :cond_24

    iget-object v1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    invoke-interface {v1, v0}, Lcom/google/android/material/datepicker/DateSelector;->setSelection(Ljava/lang/Object;)V

    :cond_24
    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    invoke-virtual {v0}, Lcom/google/android/material/datepicker/CalendarConstraints;->getOpenAt()Lcom/google/android/material/datepicker/Month;

    move-result-object v0

    if-nez v0, :cond_35

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    invoke-direct {p0}, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->createDefaultOpenAt()Lcom/google/android/material/datepicker/Month;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/material/datepicker/CalendarConstraints;->setOpenAt(Lcom/google/android/material/datepicker/Month;)V

    :cond_35
    invoke-static {p0}, Lcom/google/android/material/datepicker/MaterialDatePicker;->newInstance(Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;)Lcom/google/android/material/datepicker/MaterialDatePicker;

    move-result-object v0

    return-object v0
.end method

.method public setCalendarConstraints(Lcom/google/android/material/datepicker/CalendarConstraints;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/material/datepicker/CalendarConstraints;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->calendarConstraints:Lcom/google/android/material/datepicker/CalendarConstraints;

    return-object p0
.end method

.method public setDayViewDecorator(Lcom/google/android/material/datepicker/DayViewDecorator;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/material/datepicker/DayViewDecorator;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dayViewDecorator:Lcom/google/android/material/datepicker/DayViewDecorator;

    return-object p0
.end method

.method public setInputMode(I)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->inputMode:I

    return-object p0
.end method

.method public setNegativeButtonText(I)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonTextResId:I

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonText:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public setNegativeButtonText(Ljava/lang/CharSequence;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonText:Ljava/lang/CharSequence;

    const/4 p1, 0x0

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->negativeButtonTextResId:I

    return-object p0
.end method

.method public setPositiveButtonText(I)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonTextResId:I

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonText:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public setPositiveButtonText(Ljava/lang/CharSequence;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonText:Ljava/lang/CharSequence;

    const/4 p1, 0x0

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->positiveButtonTextResId:I

    return-object p0
.end method

.method public setSelection(Ljava/lang/Object;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TS;)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->selection:Ljava/lang/Object;

    return-object p0
.end method

.method public setTextInputFormat(Ljava/text/SimpleDateFormat;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/text/SimpleDateFormat;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->dateSelector:Lcom/google/android/material/datepicker/DateSelector;

    invoke-interface {v0, p1}, Lcom/google/android/material/datepicker/DateSelector;->setTextInputFormat(Ljava/text/SimpleDateFormat;)V

    return-object p0
.end method

.method public setTheme(I)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->overrideThemeResId:I

    return-object p0
.end method

.method public setTitleText(I)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleTextResId:I

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleText:Ljava/lang/CharSequence;

    return-object p0
.end method

.method public setTitleText(Ljava/lang/CharSequence;)Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            ")",
            "Lcom/google/android/material/datepicker/MaterialDatePicker$Builder<",
            "TS;>;"
        }
    .end annotation

    iput-object p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleText:Ljava/lang/CharSequence;

    const/4 p1, 0x0

    iput p1, p0, Lcom/google/android/material/datepicker/MaterialDatePicker$Builder;->titleTextResId:I

    return-object p0
.end method
