.class final Lcom/google/android/material/color/ColorResourcesLoaderCreator;
.super Ljava/lang/Object;
.source "ColorResourcesLoaderCreator.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "ColorResourcesLoaderCreator"


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static create(Landroid/content/Context;Ljava/util/Map;)Landroid/content/res/loader/ResourcesLoader;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;)",
            "Landroid/content/res/loader/ResourcesLoader;"
        }
    .end annotation

    const-string v0, "Table created, length: "

    const/4 v1, 0x0

    .line 46
    :try_start_3
    invoke-static {p0, p1}, Lcom/google/android/material/color/ColorResourcesTableCreator;->create(Landroid/content/Context;Ljava/util/Map;)[B

    move-result-object p0

    .line 47
    sget-object p1, Lcom/google/android/material/color/ColorResourcesLoaderCreator;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    array-length v0, p0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 48
    array-length p1, p0
    :try_end_1b
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_1b} :catch_6b

    if-nez p1, :cond_1e

    return-object v1

    :cond_1e
    :try_start_1e
    const-string p1, "temp.arsc"

    const/4 v0, 0x0

    .line 53
    invoke-static {p1, v0}, Landroid/system/Os;->memfd_create(Ljava/lang/String;I)Ljava/io/FileDescriptor;

    move-result-object p1
    :try_end_25
    .catchall {:try_start_1e .. :try_end_25} :catchall_63

    .line 55
    :try_start_25
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/FileDescriptor;)V
    :try_end_2a
    .catchall {:try_start_25 .. :try_end_2a} :catchall_61

    .line 56
    :try_start_2a
    invoke-virtual {v0, p0}, Ljava/io/OutputStream;->write([B)V

    .line 58
    invoke-static {p1}, Landroid/os/ParcelFileDescriptor;->dup(Ljava/io/FileDescriptor;)Landroid/os/ParcelFileDescriptor;

    move-result-object p0
    :try_end_31
    .catchall {:try_start_2a .. :try_end_31} :catchall_57

    .line 59
    :try_start_31
    new-instance v2, Landroid/content/res/loader/ResourcesLoader;

    invoke-direct {v2}, Landroid/content/res/loader/ResourcesLoader;-><init>()V

    .line 61
    invoke-static {p0, v1}, Landroid/content/res/loader/ResourcesProvider;->loadFromTable(Landroid/os/ParcelFileDescriptor;Landroid/content/res/loader/AssetsProvider;)Landroid/content/res/loader/ResourcesProvider;

    move-result-object v3

    .line 60
    invoke-virtual {v2, v3}, Landroid/content/res/loader/ResourcesLoader;->addProvider(Landroid/content/res/loader/ResourcesProvider;)V
    :try_end_3d
    .catchall {:try_start_31 .. :try_end_3d} :catchall_4b

    if-eqz p0, :cond_42

    .line 63
    :try_start_3f
    invoke-virtual {p0}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_42
    .catchall {:try_start_3f .. :try_end_42} :catchall_57

    .line 64
    :cond_42
    :try_start_42
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_45
    .catchall {:try_start_42 .. :try_end_45} :catchall_61

    if-eqz p1, :cond_4a

    .line 67
    :try_start_47
    invoke-static {p1}, Landroid/system/Os;->close(Ljava/io/FileDescriptor;)V
    :try_end_4a
    .catch Ljava/lang/Exception; {:try_start_47 .. :try_end_4a} :catch_6b

    :cond_4a
    return-object v2

    :catchall_4b
    move-exception v2

    if-eqz p0, :cond_56

    .line 58
    :try_start_4e
    invoke-virtual {p0}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_51
    .catchall {:try_start_4e .. :try_end_51} :catchall_52

    goto :goto_56

    :catchall_52
    move-exception p0

    :try_start_53
    invoke-virtual {v2, p0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :cond_56
    :goto_56
    throw v2
    :try_end_57
    .catchall {:try_start_53 .. :try_end_57} :catchall_57

    :catchall_57
    move-exception p0

    .line 55
    :try_start_58
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_5b
    .catchall {:try_start_58 .. :try_end_5b} :catchall_5c

    goto :goto_60

    :catchall_5c
    move-exception v0

    :try_start_5d
    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :goto_60
    throw p0
    :try_end_61
    .catchall {:try_start_5d .. :try_end_61} :catchall_61

    :catchall_61
    move-exception p0

    goto :goto_65

    :catchall_63
    move-exception p0

    move-object p1, v1

    :goto_65
    if-eqz p1, :cond_6a

    .line 67
    :try_start_67
    invoke-static {p1}, Landroid/system/Os;->close(Ljava/io/FileDescriptor;)V

    .line 69
    :cond_6a
    throw p0
    :try_end_6b
    .catch Ljava/lang/Exception; {:try_start_67 .. :try_end_6b} :catch_6b

    :catch_6b
    move-exception p0

    .line 71
    sget-object p1, Lcom/google/android/material/color/ColorResourcesLoaderCreator;->TAG:Ljava/lang/String;

    const-string v0, "Failed to create the ColorResourcesTableCreator."

    invoke-static {p1, v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-object v1
.end method
