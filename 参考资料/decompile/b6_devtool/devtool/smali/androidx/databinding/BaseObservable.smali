.class public Landroidx/databinding/BaseObservable;
.super Ljava/lang/Object;
.source "BaseObservable.java"

# interfaces
.implements Landroidx/databinding/Observable;


# instance fields
.field private transient mCallbacks:Landroidx/databinding/PropertyChangeRegistry;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addOnPropertyChangedCallback(Landroidx/databinding/Observable$OnPropertyChangedCallback;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    if-nez v0, :cond_c

    new-instance v0, Landroidx/databinding/PropertyChangeRegistry;

    invoke-direct {v0}, Landroidx/databinding/PropertyChangeRegistry;-><init>()V

    iput-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    :cond_c
    monitor-exit p0
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_13

    iget-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    invoke-virtual {v0, p1}, Landroidx/databinding/PropertyChangeRegistry;->add(Ljava/lang/Object;)V

    return-void

    :catchall_13
    move-exception p1

    :try_start_14
    monitor-exit p0
    :try_end_15
    .catchall {:try_start_14 .. :try_end_15} :catchall_13

    throw p1
.end method

.method public notifyChange()V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_e

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Landroidx/databinding/PropertyChangeRegistry;->notifyCallbacks(Ljava/lang/Object;ILjava/lang/Object;)V

    return-void

    :catchall_e
    move-exception v0

    :try_start_f
    monitor-exit p0
    :try_end_10
    .catchall {:try_start_f .. :try_end_10} :catchall_e

    throw v0
.end method

.method public notifyPropertyChanged(I)V
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_d

    const/4 v1, 0x0

    invoke-virtual {v0, p0, p1, v1}, Landroidx/databinding/PropertyChangeRegistry;->notifyCallbacks(Ljava/lang/Object;ILjava/lang/Object;)V

    return-void

    :catchall_d
    move-exception p1

    :try_start_e
    monitor-exit p0
    :try_end_f
    .catchall {:try_start_e .. :try_end_f} :catchall_d

    throw p1
.end method

.method public removeOnPropertyChangedCallback(Landroidx/databinding/Observable$OnPropertyChangedCallback;)V
    .registers 3

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroidx/databinding/BaseObservable;->mCallbacks:Landroidx/databinding/PropertyChangeRegistry;

    if-nez v0, :cond_7

    monitor-exit p0

    return-void

    :cond_7
    monitor-exit p0
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_c

    invoke-virtual {v0, p1}, Landroidx/databinding/PropertyChangeRegistry;->remove(Ljava/lang/Object;)V

    return-void

    :catchall_c
    move-exception p1

    :try_start_d
    monitor-exit p0
    :try_end_e
    .catchall {:try_start_d .. :try_end_e} :catchall_c

    throw p1
.end method
