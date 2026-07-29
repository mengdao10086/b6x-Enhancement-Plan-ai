.class public final Lcom/blankj/utilcode/util/FileUtils;
.super Ljava/lang/Object;
.source "FileUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;
    }
.end annotation


# static fields
.field private static final LINE_SEP:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/FileUtils;->LINE_SEP:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static copy(Ljava/io/File;Ljava/io/File;)Z
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileUtils;->copy(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static copy(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->copyDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0

    :cond_f
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->copyFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static copy(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p1

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileUtils;->copy(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static copy(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p1

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->copy(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method private static copyDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result p0

    return p0
.end method

.method private static copyFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result p0

    return p0
.end method

.method private static copyOrMoveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z
    .registers 12

    const/4 v0, 0x0

    if-eqz p0, :cond_9f

    if-nez p1, :cond_7

    goto/16 :goto_9f

    :cond_7
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3c

    return v0

    :cond_3c
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_9f

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-nez v1, :cond_49

    goto :goto_9f

    :cond_49
    invoke-static {p1}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsDir(Ljava/io/File;)Z

    move-result p1

    if-nez p1, :cond_50

    return v0

    :cond_50
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object p1

    if-eqz p1, :cond_96

    array-length v1, p1

    if-lez v1, :cond_96

    array-length v1, p1

    move v3, v0

    :goto_5b
    if-ge v3, v1, :cond_96

    aget-object v4, p1, v3

    new-instance v5, Ljava/io/File;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->isFile()Z

    move-result v6

    if-eqz v6, :cond_86

    invoke-static {v4, v5, p2, p3}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result v4

    if-nez v4, :cond_93

    return v0

    :cond_86
    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v6

    if-eqz v6, :cond_93

    invoke-static {v4, v5, p2, p3}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result v4

    if-nez v4, :cond_93

    return v0

    :cond_93
    add-int/lit8 v3, v3, 0x1

    goto :goto_5b

    :cond_96
    if-eqz p3, :cond_9e

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteDir(Ljava/io/File;)Z

    move-result p0

    if-eqz p0, :cond_9f

    :cond_9e
    const/4 v0, 0x1

    :cond_9f
    :goto_9f
    return v0
.end method

.method private static copyOrMoveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z
    .registers 7

    const/4 v0, 0x0

    if-eqz p0, :cond_5a

    if-nez p1, :cond_6

    goto :goto_5a

    :cond_6
    invoke-virtual {p0, p1}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    return v0

    :cond_d
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_5a

    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result v1

    if-nez v1, :cond_1a

    goto :goto_5a

    :cond_1a
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_32

    if-eqz p2, :cond_2b

    invoke-interface {p2, p0, p1}, Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;->onReplace(Ljava/io/File;Ljava/io/File;)Z

    move-result p2

    if-eqz p2, :cond_2a

    goto :goto_2b

    :cond_2a
    return v2

    :cond_2b
    :goto_2b
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result p2

    if-nez p2, :cond_32

    return v0

    :cond_32
    invoke-virtual {p1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object p2

    invoke-static {p2}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsDir(Ljava/io/File;)Z

    move-result p2

    if-nez p2, :cond_3d

    return v0

    :cond_3d
    :try_start_3d
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p1

    new-instance p2, Ljava/io/FileInputStream;

    invoke-direct {p2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-static {p1, p2}, Lcom/blankj/utilcode/util/UtilsBridge;->writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;)Z

    move-result p1

    if-eqz p1, :cond_55

    if-eqz p3, :cond_54

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteFile(Ljava/io/File;)Z

    move-result p0
    :try_end_52
    .catch Ljava/io/FileNotFoundException; {:try_start_3d .. :try_end_52} :catch_56

    if-eqz p0, :cond_55

    :cond_54
    move v0, v2

    :cond_55
    return v0

    :catch_56
    move-exception p0

    invoke-virtual {p0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    :cond_5a
    :goto_5a
    return v0
.end method

.method public static createFileByDeleteOldFile(Ljava/io/File;)Z
    .registers 3

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_11

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_11

    return v0

    :cond_11
    invoke-virtual {p0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    invoke-static {v1}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsDir(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_1c

    return v0

    :cond_1c
    :try_start_1c
    invoke-virtual {p0}, Ljava/io/File;->createNewFile()Z

    move-result p0
    :try_end_20
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_20} :catch_21

    return p0

    :catch_21
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    return v0
.end method

.method public static createFileByDeleteOldFile(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->createFileByDeleteOldFile(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static createOrExistsDir(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_17

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result p0

    if-eqz p0, :cond_17

    goto :goto_15

    :cond_f
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    move-result p0

    if-eqz p0, :cond_17

    :goto_15
    const/4 p0, 0x1

    goto :goto_18

    :cond_17
    const/4 p0, 0x0

    :goto_18
    return p0
.end method

.method public static createOrExistsDir(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsDir(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static createOrExistsFile(Ljava/io/File;)Z
    .registers 3

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result p0

    return p0

    :cond_f
    invoke-virtual {p0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    invoke-static {v1}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsDir(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_1a

    return v0

    :cond_1a
    :try_start_1a
    invoke-virtual {p0}, Ljava/io/File;->createNewFile()Z

    move-result p0
    :try_end_1e
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1e} :catch_1f

    return p0

    :catch_1f
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    return v0
.end method

.method public static createOrExistsFile(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->createOrExistsFile(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static delete(Ljava/io/File;)Z
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteDir(Ljava/io/File;)Z

    move-result p0

    return p0

    :cond_f
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteFile(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static delete(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->delete(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static deleteAllInDir(Ljava/io/File;)Z
    .registers 2

    new-instance v0, Lcom/blankj/utilcode/util/FileUtils$1;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/FileUtils$1;-><init>()V

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileUtils;->deleteFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Z

    move-result p0

    return p0
.end method

.method public static deleteAllInDir(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteAllInDir(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method private static deleteDir(Ljava/io/File;)Z
    .registers 7

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_c

    const/4 p0, 0x1

    return p0

    :cond_c
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-nez v1, :cond_13

    return v0

    :cond_13
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v1

    if-eqz v1, :cond_3f

    array-length v2, v1

    if-lez v2, :cond_3f

    array-length v2, v1

    move v3, v0

    :goto_1e
    if-ge v3, v2, :cond_3f

    aget-object v4, v1, v3

    invoke-virtual {v4}, Ljava/io/File;->isFile()Z

    move-result v5

    if-eqz v5, :cond_2f

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_3c

    return v0

    :cond_2f
    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_3c

    invoke-static {v4}, Lcom/blankj/utilcode/util/FileUtils;->deleteDir(Ljava/io/File;)Z

    move-result v4

    if-nez v4, :cond_3c

    return v0

    :cond_3c
    add-int/lit8 v3, v3, 0x1

    goto :goto_1e

    :cond_3f
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result p0

    return p0
.end method

.method private static deleteFile(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_16

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    move-result p0

    if-eqz p0, :cond_16

    :cond_14
    const/4 p0, 0x1

    goto :goto_17

    :cond_16
    const/4 p0, 0x0

    :goto_17
    return p0
.end method

.method public static deleteFilesInDir(Ljava/io/File;)Z
    .registers 2

    new-instance v0, Lcom/blankj/utilcode/util/FileUtils$2;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/FileUtils$2;-><init>()V

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileUtils;->deleteFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Z

    move-result p0

    return p0
.end method

.method public static deleteFilesInDir(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->deleteFilesInDir(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static deleteFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Z
    .registers 8

    const/4 v0, 0x0

    if-eqz p0, :cond_48

    if-nez p1, :cond_6

    goto :goto_48

    :cond_6
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    const/4 v2, 0x1

    if-nez v1, :cond_e

    return v2

    :cond_e
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v1

    if-nez v1, :cond_15

    return v0

    :cond_15
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_47

    array-length v1, p0

    if-eqz v1, :cond_47

    array-length v1, p0

    move v3, v0

    :goto_20
    if-ge v3, v1, :cond_47

    aget-object v4, p0, v3

    invoke-interface {p1, v4}, Ljava/io/FileFilter;->accept(Ljava/io/File;)Z

    move-result v5

    if-eqz v5, :cond_44

    invoke-virtual {v4}, Ljava/io/File;->isFile()Z

    move-result v5

    if-eqz v5, :cond_37

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v4

    if-nez v4, :cond_44

    return v0

    :cond_37
    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_44

    invoke-static {v4}, Lcom/blankj/utilcode/util/FileUtils;->deleteDir(Ljava/io/File;)Z

    move-result v4

    if-nez v4, :cond_44

    return v0

    :cond_44
    add-int/lit8 v3, v3, 0x1

    goto :goto_20

    :cond_47
    return v2

    :cond_48
    :goto_48
    return v0
.end method

.method public static deleteFilesInDirWithFilter(Ljava/lang/String;Ljava/io/FileFilter;)Z
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileUtils;->deleteFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Z

    move-result p0

    return p0
.end method

.method private static getDirLength(Ljava/io/File;)J
    .registers 7

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isDir(Ljava/io/File;)Z

    move-result v0

    const-wide/16 v1, 0x0

    if-nez v0, :cond_9

    return-wide v1

    :cond_9
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_2b

    array-length v0, p0

    if-lez v0, :cond_2b

    array-length v0, p0

    const/4 v3, 0x0

    :goto_14
    if-ge v3, v0, :cond_2b

    aget-object v4, p0, v3

    invoke-virtual {v4}, Ljava/io/File;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_23

    invoke-static {v4}, Lcom/blankj/utilcode/util/FileUtils;->getDirLength(Ljava/io/File;)J

    move-result-wide v4

    goto :goto_27

    :cond_23
    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v4

    :goto_27
    add-long/2addr v1, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_14

    :cond_2b
    return-wide v1
.end method

.method public static getDirName(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getDirName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getDirName(Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    const-string v1, ""

    if-eqz v0, :cond_9

    return-object v1

    :cond_9
    sget-object v0, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_13

    goto :goto_1a

    :cond_13
    add-int/lit8 v0, v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    :goto_1a
    return-object v1
.end method

.method private static getDirSize(Ljava/io/File;)Ljava/lang/String;
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getDirLength(Ljava/io/File;)J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long p0, v0, v2

    if-nez p0, :cond_d

    const-string p0, ""

    goto :goto_11

    :cond_d
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->byte2FitMemorySize(J)Ljava/lang/String;

    move-result-object p0

    :goto_11
    return-object p0
.end method

.method public static getFileByPath(Ljava/lang/String;)Ljava/io/File;
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 p0, 0x0

    goto :goto_e

    :cond_8
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object p0, v0

    :goto_e
    return-object p0
.end method

.method public static getFileCharsetSimple(Ljava/io/File;)Ljava/lang/String;
    .registers 4

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isUtf8(Ljava/io/File;)Z

    move-result v0

    if-eqz v0, :cond_e

    const-string p0, "UTF-8"

    return-object p0

    :cond_e
    const/4 v0, 0x0

    :try_start_f
    new-instance v1, Ljava/io/BufferedInputStream;

    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_19} :catch_35
    .catchall {:try_start_f .. :try_end_19} :catchall_33

    :try_start_19
    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result p0

    shl-int/lit8 p0, p0, 0x8

    invoke-virtual {v1}, Ljava/io/InputStream;->read()I

    move-result v0
    :try_end_23
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_23} :catch_30
    .catchall {:try_start_19 .. :try_end_23} :catchall_2d

    add-int/2addr p0, v0

    :try_start_24
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_27
    .catch Ljava/io/IOException; {:try_start_24 .. :try_end_27} :catch_28

    goto :goto_44

    :catch_28
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_44

    :catchall_2d
    move-exception p0

    move-object v0, v1

    goto :goto_57

    :catch_30
    move-exception p0

    move-object v0, v1

    goto :goto_36

    :catchall_33
    move-exception p0

    goto :goto_57

    :catch_35
    move-exception p0

    :goto_36
    :try_start_36
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_39
    .catchall {:try_start_36 .. :try_end_39} :catchall_33

    if-eqz v0, :cond_43

    :try_start_3b
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_3e
    .catch Ljava/io/IOException; {:try_start_3b .. :try_end_3e} :catch_3f

    goto :goto_43

    :catch_3f
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_43
    :goto_43
    const/4 p0, 0x0

    :goto_44
    const v0, 0xfeff

    if-eq p0, v0, :cond_54

    const v0, 0xfffe

    if-eq p0, v0, :cond_51

    const-string p0, "GBK"

    return-object p0

    :cond_51
    const-string p0, "Unicode"

    return-object p0

    :cond_54
    const-string p0, "UTF-16BE"

    return-object p0

    :goto_57
    if-eqz v0, :cond_61

    :try_start_59
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_5c
    .catch Ljava/io/IOException; {:try_start_59 .. :try_end_5c} :catch_5d

    goto :goto_61

    :catch_5d
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :cond_61
    :goto_61
    throw p0
.end method

.method public static getFileCharsetSimple(Ljava/lang/String;)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileCharsetSimple(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileExtension(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileExtension(Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    const-string v1, ""

    if-eqz v0, :cond_9

    return-object v1

    :cond_9
    const/16 v0, 0x2e

    invoke-virtual {p0, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    const/4 v3, -0x1

    if-eq v0, v3, :cond_22

    if-lt v2, v0, :cond_1b

    goto :goto_22

    :cond_1b
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_22
    :goto_22
    return-object v1
.end method

.method public static getFileLastModified(Ljava/io/File;)J
    .registers 3

    if-nez p0, :cond_5

    const-wide/16 v0, -0x1

    return-wide v0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    return-wide v0
.end method

.method public static getFileLastModified(Ljava/lang/String;)J
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileLastModified(Ljava/io/File;)J

    move-result-wide v0

    return-wide v0
.end method

.method private static getFileLength(Ljava/io/File;)J
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isFile(Ljava/io/File;)Z

    move-result v0

    if-nez v0, :cond_9

    const-wide/16 v0, -0x1

    return-wide v0

    :cond_9
    invoke-virtual {p0}, Ljava/io/File;->length()J

    move-result-wide v0

    return-wide v0
.end method

.method public static getFileLength(Ljava/lang/String;)J
    .registers 4

    const-string v0, "[a-zA-z]+://[^\\s]*"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_32

    :try_start_8
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljavax/net/ssl/HttpsURLConnection;

    const-string v1, "Accept-Encoding"

    const-string v2, "identity"

    invoke-virtual {v0, v1, v2}, Ljavax/net/ssl/HttpsURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->connect()V

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getResponseCode()I

    move-result v1

    const/16 v2, 0xc8

    if-ne v1, v2, :cond_2b

    invoke-virtual {v0}, Ljavax/net/ssl/HttpsURLConnection;->getContentLength()I

    move-result p0
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_29} :catch_2e

    int-to-long v0, p0

    return-wide v0

    :cond_2b
    const-wide/16 v0, -0x1

    return-wide v0

    :catch_2e
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :cond_32
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileLength(Ljava/io/File;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getFileLines(Ljava/io/File;)I
    .registers 10

    const/4 v0, 0x1

    const/4 v1, 0x0

    :try_start_2
    new-instance v2, Ljava/io/BufferedInputStream;

    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_c} :catch_55
    .catchall {:try_start_2 .. :try_end_c} :catchall_53

    const/16 p0, 0x400

    :try_start_e
    new-array v1, p0, [B

    sget-object v3, Lcom/blankj/utilcode/util/FileUtils;->LINE_SEP:Ljava/lang/String;

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    const/4 v4, -0x1

    const/4 v5, 0x0

    if-eqz v3, :cond_30

    :cond_1c
    invoke-virtual {v2, v1, v5, p0}, Ljava/io/InputStream;->read([BII)I

    move-result v3

    if-eq v3, v4, :cond_44

    move v6, v5

    :goto_23
    if-ge v6, v3, :cond_1c

    aget-byte v7, v1, v6

    const/16 v8, 0xa

    if-ne v7, v8, :cond_2d

    add-int/lit8 v0, v0, 0x1

    :cond_2d
    add-int/lit8 v6, v6, 0x1

    goto :goto_23

    :cond_30
    invoke-virtual {v2, v1, v5, p0}, Ljava/io/InputStream;->read([BII)I

    move-result v3

    if-eq v3, v4, :cond_44

    move v6, v5

    :goto_37
    if-ge v6, v3, :cond_30

    aget-byte v7, v1, v6
    :try_end_3b
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_3b} :catch_50
    .catchall {:try_start_e .. :try_end_3b} :catchall_4d

    const/16 v8, 0xd

    if-ne v7, v8, :cond_41

    add-int/lit8 v0, v0, 0x1

    :cond_41
    add-int/lit8 v6, v6, 0x1

    goto :goto_37

    :cond_44
    :try_start_44
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_44 .. :try_end_47} :catch_48

    goto :goto_5e

    :catch_48
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5e

    :catchall_4d
    move-exception p0

    move-object v1, v2

    goto :goto_5f

    :catch_50
    move-exception p0

    move-object v1, v2

    goto :goto_56

    :catchall_53
    move-exception p0

    goto :goto_5f

    :catch_55
    move-exception p0

    :goto_56
    :try_start_56
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_59
    .catchall {:try_start_56 .. :try_end_59} :catchall_53

    if-eqz v1, :cond_5e

    :try_start_5b
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_5e
    .catch Ljava/io/IOException; {:try_start_5b .. :try_end_5e} :catch_48

    :cond_5e
    :goto_5e
    return v0

    :goto_5f
    if-eqz v1, :cond_69

    :try_start_61
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_64
    .catch Ljava/io/IOException; {:try_start_61 .. :try_end_64} :catch_65

    goto :goto_69

    :catch_65
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :cond_69
    :goto_69
    throw p0
.end method

.method public static getFileLines(Ljava/lang/String;)I
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileLines(Ljava/io/File;)I

    move-result p0

    return p0
.end method

.method public static getFileMD5(Ljava/io/File;)[B
    .registers 4

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    const-string p0, "MD5"

    invoke-static {p0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object p0

    new-instance v2, Ljava/security/DigestInputStream;

    invoke-direct {v2, v1, p0}, Ljava/security/DigestInputStream;-><init>(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    :try_end_14
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_4 .. :try_end_14} :catch_37
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_14} :catch_35
    .catchall {:try_start_4 .. :try_end_14} :catchall_33

    const/high16 p0, 0x40000

    :try_start_16
    new-array p0, p0, [B

    :cond_18
    invoke-virtual {v2, p0}, Ljava/security/DigestInputStream;->read([B)I

    move-result v1

    if-gtz v1, :cond_18

    invoke-virtual {v2}, Ljava/security/DigestInputStream;->getMessageDigest()Ljava/security/MessageDigest;

    move-result-object p0

    invoke-virtual {p0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0
    :try_end_26
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_16 .. :try_end_26} :catch_31
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_26} :catch_2f
    .catchall {:try_start_16 .. :try_end_26} :catchall_47

    :try_start_26
    invoke-virtual {v2}, Ljava/security/DigestInputStream;->close()V
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_26 .. :try_end_29} :catch_2a

    goto :goto_2e

    :catch_2a
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :goto_2e
    return-object p0

    :catch_2f
    move-exception p0

    goto :goto_39

    :catch_31
    move-exception p0

    goto :goto_39

    :catchall_33
    move-exception p0

    goto :goto_49

    :catch_35
    move-exception p0

    goto :goto_38

    :catch_37
    move-exception p0

    :goto_38
    move-object v2, v0

    :goto_39
    :try_start_39
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3c
    .catchall {:try_start_39 .. :try_end_3c} :catchall_47

    if-eqz v2, :cond_46

    :try_start_3e
    invoke-virtual {v2}, Ljava/security/DigestInputStream;->close()V
    :try_end_41
    .catch Ljava/io/IOException; {:try_start_3e .. :try_end_41} :catch_42

    goto :goto_46

    :catch_42
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_46
    :goto_46
    return-object v0

    :catchall_47
    move-exception p0

    move-object v0, v2

    :goto_49
    if-eqz v0, :cond_53

    :try_start_4b
    invoke-virtual {v0}, Ljava/security/DigestInputStream;->close()V
    :try_end_4e
    .catch Ljava/io/IOException; {:try_start_4b .. :try_end_4e} :catch_4f

    goto :goto_53

    :catch_4f
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :cond_53
    :goto_53
    throw p0
.end method

.method public static getFileMD5(Ljava/lang/String;)[B
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileMD5(Ljava/io/File;)[B

    move-result-object p0

    return-object p0
.end method

.method public static getFileMD5ToString(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileMD5(Ljava/io/File;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileMD5ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 p0, 0x0

    goto :goto_e

    :cond_8
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    move-object p0, v0

    :goto_e
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileMD5ToString(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileName(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileName(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-string p0, ""

    return-object p0

    :cond_9
    sget-object v0, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_13

    goto :goto_19

    :cond_13
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    :goto_19
    return-object p0
.end method

.method public static getFileNameNoExtension(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileNameNoExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getFileNameNoExtension(Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-string p0, ""

    return-object p0

    :cond_9
    const/16 v0, 0x2e

    invoke-virtual {p0, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_21

    if-ne v0, v2, :cond_1b

    goto :goto_20

    :cond_1b
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    :goto_20
    return-object p0

    :cond_21
    if-eq v0, v2, :cond_2d

    if-le v1, v0, :cond_26

    goto :goto_2d

    :cond_26
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_2d
    :goto_2d
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static getFileSize(Ljava/io/File;)Ljava/lang/String;
    .registers 5

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileLength(Ljava/io/File;)J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long p0, v0, v2

    if-nez p0, :cond_d

    const-string p0, ""

    goto :goto_11

    :cond_d
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->byte2FitMemorySize(J)Ljava/lang/String;

    move-result-object p0

    :goto_11
    return-object p0
.end method

.method public static getFsAvailableSize(Ljava/lang/String;)J
    .registers 6

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-wide/16 v0, 0x0

    return-wide v0

    :cond_9
    new-instance v0, Landroid/os/StatFs;

    invoke-direct {v0, p0}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockSizeLong()J

    move-result-wide v1

    invoke-virtual {v0}, Landroid/os/StatFs;->getAvailableBlocksLong()J

    move-result-wide v3

    mul-long/2addr v1, v3

    return-wide v1
.end method

.method public static getFsTotalSize(Ljava/lang/String;)J
    .registers 6

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-wide/16 v0, 0x0

    return-wide v0

    :cond_9
    new-instance v0, Landroid/os/StatFs;

    invoke-direct {v0, p0}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockSizeLong()J

    move-result-wide v1

    invoke-virtual {v0}, Landroid/os/StatFs;->getBlockCountLong()J

    move-result-wide v3

    mul-long/2addr v1, v3

    return-wide v1
.end method

.method public static getLength(Ljava/io/File;)J
    .registers 3

    if-nez p0, :cond_5

    const-wide/16 v0, 0x0

    return-wide v0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getDirLength(Ljava/io/File;)J

    move-result-wide v0

    return-wide v0

    :cond_10
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileLength(Ljava/io/File;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getLength(Ljava/lang/String;)J
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getLength(Ljava/io/File;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static getSize(Ljava/io/File;)Ljava/lang/String;
    .registers 2

    if-nez p0, :cond_5

    const-string p0, ""

    return-object p0

    :cond_5
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getDirSize(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_10
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileSize(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getSize(Ljava/lang/String;)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getSize(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static isDir(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result p0

    if-eqz p0, :cond_10

    const/4 p0, 0x1

    goto :goto_11

    :cond_10
    const/4 p0, 0x0

    :goto_11
    return p0
.end method

.method public static isDir(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isDir(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static isFile(Ljava/io/File;)Z
    .registers 2

    if-eqz p0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-virtual {p0}, Ljava/io/File;->isFile()Z

    move-result p0

    if-eqz p0, :cond_10

    const/4 p0, 0x1

    goto :goto_11

    :cond_10
    const/4 p0, 0x0

    :goto_11
    return p0
.end method

.method public static isFile(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isFile(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static isFileExists(Ljava/io/File;)Z
    .registers 2

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_c

    const/4 p0, 0x1

    return p0

    :cond_c
    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isFileExists(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static isFileExists(Ljava/lang/String;)Z
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-nez v0, :cond_8

    const/4 p0, 0x0

    return p0

    :cond_8
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_10

    const/4 p0, 0x1

    return p0

    :cond_10
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isFileExistsApi29(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method private static isFileExistsApi29(Ljava/lang/String;)Z
    .registers 4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1d

    const/4 v2, 0x0

    if-lt v0, v1, :cond_21

    :try_start_7
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p0

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "r"

    invoke-virtual {v0, p0, v1}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object p0
    :try_end_19
    .catch Ljava/io/FileNotFoundException; {:try_start_7 .. :try_end_19} :catch_21

    if-nez p0, :cond_1c

    return v2

    :cond_1c
    :try_start_1c
    invoke-virtual {p0}, Landroid/content/res/AssetFileDescriptor;->close()V
    :try_end_1f
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_1f} :catch_1f
    .catch Ljava/io/FileNotFoundException; {:try_start_1c .. :try_end_1f} :catch_21

    :catch_1f
    const/4 p0, 0x1

    return p0

    :catch_21
    :cond_21
    return v2
.end method

.method private static isUtf8([B)I
    .registers 15

    array-length v0, p0

    const/4 v1, 0x3

    const/16 v2, 0x64

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-le v0, v1, :cond_1c

    aget-byte v0, p0, v4

    const/16 v1, -0x11

    if-ne v0, v1, :cond_1c

    aget-byte v0, p0, v3

    const/16 v1, -0x45

    if-ne v0, v1, :cond_1c

    const/4 v0, 0x2

    aget-byte v0, p0, v0

    const/16 v1, -0x41

    if-ne v0, v1, :cond_1c

    return v2

    :cond_1c
    array-length v0, p0

    move v1, v4

    move v5, v1

    move v6, v5

    move v7, v6

    :goto_21
    if-ge v1, v0, :cond_8c

    aget-byte v8, p0, v1

    and-int/lit8 v9, v8, -0x1

    const/4 v10, -0x1

    if-eq v9, v10, :cond_8b

    and-int/lit8 v9, v8, -0x2

    const/4 v10, -0x2

    if-ne v9, v10, :cond_31

    goto/16 :goto_8b

    :cond_31
    if-nez v7, :cond_5d

    and-int/lit8 v9, v8, 0x7f

    if-ne v9, v8, :cond_3c

    if-eqz v8, :cond_3c

    add-int/lit8 v5, v5, 0x1

    goto :goto_5a

    :cond_3c
    and-int/lit8 v8, v8, -0x40

    const/16 v9, -0x40

    if-ne v8, v9, :cond_5a

    move v8, v7

    move v7, v4

    :goto_44
    const/16 v9, 0x8

    if-ge v7, v9, :cond_57

    const/16 v9, 0x80

    shr-int/2addr v9, v7

    int-to-byte v9, v9

    aget-byte v10, p0, v1

    and-int/2addr v10, v9

    if-ne v10, v9, :cond_57

    add-int/lit8 v8, v7, 0x1

    move v13, v8

    move v8, v7

    move v7, v13

    goto :goto_44

    :cond_57
    add-int/lit8 v6, v6, 0x1

    move v7, v8

    :cond_5a
    :goto_5a
    add-int/lit8 v1, v1, 0x1

    goto :goto_21

    :cond_5d
    array-length v8, p0

    sub-int/2addr v8, v1

    if-le v8, v7, :cond_62

    goto :goto_64

    :cond_62
    array-length v7, p0

    sub-int/2addr v7, v1

    :goto_64
    move v8, v4

    move v9, v8

    :goto_66
    if-ge v8, v7, :cond_80

    add-int v10, v1, v8

    aget-byte v10, p0, v10

    and-int/lit8 v11, v10, -0x80

    const/16 v12, -0x80

    if-eq v11, v12, :cond_7d

    and-int/lit8 v9, v10, 0x7f

    if-ne v9, v10, :cond_7c

    aget-byte v9, p0, v1

    if-eqz v9, :cond_7c

    add-int/lit8 v5, v5, 0x1

    :cond_7c
    move v9, v3

    :cond_7d
    add-int/lit8 v8, v8, 0x1

    goto :goto_66

    :cond_80
    if-eqz v9, :cond_87

    add-int/lit8 v6, v6, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_89

    :cond_87
    add-int/2addr v6, v7

    add-int/2addr v1, v7

    :goto_89
    move v7, v4

    goto :goto_21

    :cond_8b
    :goto_8b
    return v4

    :cond_8c
    if-ne v5, v0, :cond_8f

    return v2

    :cond_8f
    add-int/2addr v6, v5

    int-to-float p0, v6

    int-to-float v0, v0

    div-float/2addr p0, v0

    const/high16 v0, 0x42c80000    # 100.0f

    mul-float/2addr p0, v0

    float-to-int p0, p0

    return p0
.end method

.method public static isUtf8(Ljava/io/File;)Z
    .registers 6

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    const/16 v1, 0x18

    const/4 v2, 0x0

    :try_start_7
    new-array v1, v1, [B

    new-instance v3, Ljava/io/BufferedInputStream;

    new-instance v4, Ljava/io/FileInputStream;

    invoke-direct {v4, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v3, v4}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_13} :catch_42
    .catchall {:try_start_7 .. :try_end_13} :catchall_40

    :try_start_13
    invoke-virtual {v3, v1}, Ljava/io/InputStream;->read([B)I

    move-result p0

    const/4 v2, -0x1

    if-eq p0, v2, :cond_31

    new-array v2, p0, [B

    invoke-static {v1, v0, v2, v0, p0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {v2}, Lcom/blankj/utilcode/util/FileUtils;->isUtf8([B)I

    move-result p0
    :try_end_23
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_23} :catch_3d
    .catchall {:try_start_13 .. :try_end_23} :catchall_3a

    const/16 v1, 0x64

    if-ne p0, v1, :cond_28

    const/4 v0, 0x1

    :cond_28
    :try_start_28
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_2b
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_2b} :catch_2c

    goto :goto_30

    :catch_2c
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_30
    return v0

    :cond_31
    :try_start_31
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_34
    .catch Ljava/io/IOException; {:try_start_31 .. :try_end_34} :catch_35

    goto :goto_39

    :catch_35
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_39
    return v0

    :catchall_3a
    move-exception p0

    move-object v2, v3

    goto :goto_51

    :catch_3d
    move-exception p0

    move-object v2, v3

    goto :goto_43

    :catchall_40
    move-exception p0

    goto :goto_51

    :catch_42
    move-exception p0

    :goto_43
    :try_start_43
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_46
    .catchall {:try_start_43 .. :try_end_46} :catchall_40

    if-eqz v2, :cond_50

    :try_start_48
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4b
    .catch Ljava/io/IOException; {:try_start_48 .. :try_end_4b} :catch_4c

    goto :goto_50

    :catch_4c
    move-exception p0

    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_50
    :goto_50
    return v0

    :goto_51
    if-eqz v2, :cond_5b

    :try_start_53
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_56
    .catch Ljava/io/IOException; {:try_start_53 .. :try_end_56} :catch_57

    goto :goto_5b

    :catch_57
    move-exception v0

    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    :cond_5b
    :goto_5b
    throw p0
.end method

.method public static isUtf8(Ljava/lang/String;)Z
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isUtf8(Ljava/io/File;)Z

    move-result p0

    return p0
.end method

.method public static listFilesInDir(Ljava/io/File;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            ")",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/io/File;Ljava/util/Comparator;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/io/File;Z)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Z)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/io/File;ZLjava/util/Comparator;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Z",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    new-instance v0, Lcom/blankj/utilcode/util/FileUtils$3;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/FileUtils$3;-><init>()V

    invoke-static {p0, v0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/lang/String;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/lang/String;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/lang/String;Ljava/util/Comparator;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/lang/String;Z)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;Z)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDir(Ljava/lang/String;ZLjava/util/Comparator;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDir(Ljava/io/File;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/io/FileFilter;",
            ")",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;Ljava/util/Comparator;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/io/FileFilter;",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;Z)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/io/FileFilter;",
            "Z)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/io/FileFilter;",
            "Z",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilterInner(Ljava/io/File;Ljava/io/FileFilter;Z)Ljava/util/List;

    move-result-object p0

    if-eqz p3, :cond_9

    invoke-static {p0, p3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    :cond_9
    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/lang/String;Ljava/io/FileFilter;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/FileFilter;",
            ")",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/lang/String;Ljava/io/FileFilter;Ljava/util/Comparator;)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/FileFilter;",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;Ljava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/lang/String;Ljava/io/FileFilter;Z)Ljava/util/List;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/FileFilter;",
            "Z)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;Z)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static listFilesInDirWithFilter(Ljava/lang/String;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/FileFilter;",
            "Z",
            "Ljava/util/Comparator<",
            "Ljava/io/File;",
            ">;)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilter(Ljava/io/File;Ljava/io/FileFilter;ZLjava/util/Comparator;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method private static listFilesInDirWithFilterInner(Ljava/io/File;Ljava/io/FileFilter;Z)Ljava/util/List;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/io/FileFilter;",
            "Z)",
            "Ljava/util/List<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->isDir(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_c

    return-object v0

    :cond_c
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object p0

    if-eqz p0, :cond_37

    array-length v1, p0

    if-lez v1, :cond_37

    array-length v1, p0

    const/4 v2, 0x0

    :goto_17
    if-ge v2, v1, :cond_37

    aget-object v3, p0, v2

    invoke-interface {p1, v3}, Ljava/io/FileFilter;->accept(Ljava/io/File;)Z

    move-result v4

    if-eqz v4, :cond_24

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_24
    if-eqz p2, :cond_34

    invoke-virtual {v3}, Ljava/io/File;->isDirectory()Z

    move-result v4

    if-eqz v4, :cond_34

    const/4 v4, 0x1

    invoke-static {v3, p1, v4}, Lcom/blankj/utilcode/util/FileUtils;->listFilesInDirWithFilterInner(Ljava/io/File;Ljava/io/FileFilter;Z)Ljava/util/List;

    move-result-object v3

    invoke-interface {v0, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :cond_34
    add-int/lit8 v2, v2, 0x1

    goto :goto_17

    :cond_37
    return-object v0
.end method

.method public static move(Ljava/io/File;Ljava/io/File;)Z
    .registers 3

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileUtils;->move(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static move(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return p0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->moveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0

    :cond_f
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->moveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static move(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p1

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileUtils;->move(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static move(Ljava/lang/String;Ljava/lang/String;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 3

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p1}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p1

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileUtils;->move(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z

    move-result p0

    return p0
.end method

.method public static moveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveDir(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result p0

    return p0
.end method

.method public static moveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;)Z
    .registers 4

    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileUtils;->copyOrMoveFile(Ljava/io/File;Ljava/io/File;Lcom/blankj/utilcode/util/FileUtils$OnReplaceListener;Z)Z

    move-result p0

    return p0
.end method

.method public static notifySystemToScan(Ljava/io/File;)V
    .registers 4

    if-eqz p0, :cond_31

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_9

    goto :goto_31

    :cond_9
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object p0

    invoke-virtual {v0, p0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object p0

    invoke-virtual {p0, v0}, Landroid/app/Application;->sendBroadcast(Landroid/content/Intent;)V

    :cond_31
    :goto_31
    return-void
.end method

.method public static notifySystemToScan(Ljava/lang/String;)V
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->notifySystemToScan(Ljava/io/File;)V

    return-void
.end method

.method public static rename(Ljava/io/File;Ljava/lang/String;)Z
    .registers 7

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_b

    return v0

    :cond_b
    invoke-static {p1}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_12

    return v0

    :cond_12
    invoke-virtual {p0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_1e

    return v2

    :cond_1e
    new-instance v1, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result p1

    if-nez p1, :cond_4b

    invoke-virtual {p0, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result p0

    if-eqz p0, :cond_4b

    move v0, v2

    :cond_4b
    return v0
.end method

.method public static rename(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 2

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileUtils;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileUtils;->rename(Ljava/io/File;Ljava/lang/String;)Z

    move-result p0

    return p0
.end method
