.class public final Lcom/blankj/utilcode/util/FileIOUtils;
.super Ljava/lang/Object;
.source "FileIOUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;
    }
.end annotation


# static fields
.field private static sBufferSize:I = 0x80000


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static readFile2BytesByChannel(Ljava/io/File;)[B
    .registers 5

    .line 867
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isFileExists(Ljava/io/File;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return-object v1

    .line 870
    :cond_8
    :try_start_8
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v2, "r"

    invoke-direct {v0, p0, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object p0
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_13} :catch_4c
    .catchall {:try_start_8 .. :try_end_13} :catchall_4a

    if-nez p0, :cond_2a

    :try_start_15
    const-string v0, "FileIOUtils"

    const-string v2, "fc is null."

    .line 872
    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    new-array v0, v0, [B
    :try_end_1f
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_1f} :catch_48
    .catchall {:try_start_15 .. :try_end_1f} :catchall_5c

    if-eqz p0, :cond_29

    .line 886
    :try_start_21
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_24
    .catch Ljava/io/IOException; {:try_start_21 .. :try_end_24} :catch_25

    goto :goto_29

    :catch_25
    move-exception p0

    .line 889
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_29
    :goto_29
    return-object v0

    .line 875
    :cond_2a
    :try_start_2a
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v2

    long-to-int v0, v2

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 877
    :cond_33
    invoke-virtual {p0, v0}, Ljava/nio/channels/FileChannel;->read(Ljava/nio/ByteBuffer;)I

    move-result v2

    if-gtz v2, :cond_33

    .line 879
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0
    :try_end_3d
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_3d} :catch_48
    .catchall {:try_start_2a .. :try_end_3d} :catchall_5c

    if-eqz p0, :cond_47

    .line 886
    :try_start_3f
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_3f .. :try_end_42} :catch_43

    goto :goto_47

    :catch_43
    move-exception p0

    .line 889
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_47
    :goto_47
    return-object v0

    :catch_48
    move-exception v0

    goto :goto_4e

    :catchall_4a
    move-exception v0

    goto :goto_5e

    :catch_4c
    move-exception v0

    move-object p0, v1

    .line 881
    :goto_4e
    :try_start_4e
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_51
    .catchall {:try_start_4e .. :try_end_51} :catchall_5c

    if-eqz p0, :cond_5b

    .line 886
    :try_start_53
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_56
    .catch Ljava/io/IOException; {:try_start_53 .. :try_end_56} :catch_57

    goto :goto_5b

    :catch_57
    move-exception p0

    .line 889
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_5b
    :goto_5b
    return-object v1

    :catchall_5c
    move-exception v0

    move-object v1, p0

    :goto_5e
    if-eqz v1, :cond_68

    .line 886
    :try_start_60
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_63
    .catch Ljava/io/IOException; {:try_start_60 .. :try_end_63} :catch_64

    goto :goto_68

    :catch_64
    move-exception p0

    .line 889
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 891
    :cond_68
    :goto_68
    throw v0
.end method

.method public static readFile2BytesByChannel(Ljava/lang/String;)[B
    .registers 1

    .line 857
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByChannel(Ljava/io/File;)[B

    move-result-object p0

    return-object p0
.end method

.method public static readFile2BytesByMap(Ljava/io/File;)[B
    .registers 10

    .line 911
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isFileExists(Ljava/io/File;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return-object v1

    .line 914
    :cond_8
    :try_start_8
    new-instance v0, Ljava/io/RandomAccessFile;

    const-string v2, "r"

    invoke-direct {v0, p0, v2}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/RandomAccessFile;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object p0
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_13} :catch_51
    .catchall {:try_start_8 .. :try_end_13} :catchall_4f

    const/4 v0, 0x0

    if-nez p0, :cond_2a

    :try_start_16
    const-string v2, "FileIOUtils"

    const-string v3, "fc is null."

    .line 916
    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    new-array v0, v0, [B
    :try_end_1f
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_1f} :catch_4d
    .catchall {:try_start_16 .. :try_end_1f} :catchall_61

    if-eqz p0, :cond_29

    .line 930
    :try_start_21
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_24
    .catch Ljava/io/IOException; {:try_start_21 .. :try_end_24} :catch_25

    goto :goto_29

    :catch_25
    move-exception p0

    .line 933
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_29
    :goto_29
    return-object v0

    .line 919
    :cond_2a
    :try_start_2a
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v2

    long-to-int v2, v2

    .line 920
    sget-object v4, Ljava/nio/channels/FileChannel$MapMode;->READ_ONLY:Ljava/nio/channels/FileChannel$MapMode;

    const-wide/16 v5, 0x0

    int-to-long v7, v2

    move-object v3, p0

    invoke-virtual/range {v3 .. v8}, Ljava/nio/channels/FileChannel;->map(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/nio/MappedByteBuffer;->load()Ljava/nio/MappedByteBuffer;

    move-result-object v3

    .line 921
    new-array v4, v2, [B

    .line 922
    invoke-virtual {v3, v4, v0, v2}, Ljava/nio/MappedByteBuffer;->get([BII)Ljava/nio/ByteBuffer;
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_42} :catch_4d
    .catchall {:try_start_2a .. :try_end_42} :catchall_61

    if-eqz p0, :cond_4c

    .line 930
    :try_start_44
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_44 .. :try_end_47} :catch_48

    goto :goto_4c

    :catch_48
    move-exception p0

    .line 933
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_4c
    :goto_4c
    return-object v4

    :catch_4d
    move-exception v0

    goto :goto_53

    :catchall_4f
    move-exception v0

    goto :goto_63

    :catch_51
    move-exception v0

    move-object p0, v1

    .line 925
    :goto_53
    :try_start_53
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_56
    .catchall {:try_start_53 .. :try_end_56} :catchall_61

    if-eqz p0, :cond_60

    .line 930
    :try_start_58
    invoke-virtual {p0}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_5b
    .catch Ljava/io/IOException; {:try_start_58 .. :try_end_5b} :catch_5c

    goto :goto_60

    :catch_5c
    move-exception p0

    .line 933
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_60
    :goto_60
    return-object v1

    :catchall_61
    move-exception v0

    move-object v1, p0

    :goto_63
    if-eqz v1, :cond_6d

    .line 930
    :try_start_65
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_68
    .catch Ljava/io/IOException; {:try_start_65 .. :try_end_68} :catch_69

    goto :goto_6d

    :catch_69
    move-exception p0

    .line 933
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 935
    :cond_6d
    :goto_6d
    throw v0
.end method

.method public static readFile2BytesByMap(Ljava/lang/String;)[B
    .registers 1

    .line 901
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByMap(Ljava/io/File;)[B

    move-result-object p0

    return-object p0
.end method

.method public static readFile2BytesByStream(Ljava/io/File;)[B
    .registers 2

    const/4 v0, 0x0

    .line 776
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByStream(Ljava/io/File;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)[B

    move-result-object p0

    return-object p0
.end method

.method public static readFile2BytesByStream(Ljava/io/File;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)[B
    .registers 12

    .line 804
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isFileExists(Ljava/io/File;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return-object v1

    .line 807
    :cond_8
    :try_start_8
    new-instance v0, Ljava/io/BufferedInputStream;

    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    sget p0, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    invoke-direct {v0, v2, p0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_14
    .catch Ljava/io/FileNotFoundException; {:try_start_8 .. :try_end_14} :catch_90

    .line 809
    :try_start_14
    new-instance p0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_19} :catch_64
    .catchall {:try_start_14 .. :try_end_19} :catchall_61

    .line 810
    :try_start_19
    sget v2, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    new-array v2, v2, [B

    const/4 v3, -0x1

    const/4 v4, 0x0

    if-nez p1, :cond_2d

    .line 813
    :goto_21
    sget p1, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    invoke-virtual {v0, v2, v4, p1}, Ljava/io/InputStream;->read([BII)I

    move-result p1

    if-eq p1, v3, :cond_4a

    .line 814
    invoke-virtual {p0, v2, v4, p1}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_21

    .line 817
    :cond_2d
    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v5

    int-to-double v5, v5

    const-wide/16 v7, 0x0

    .line 819
    invoke-interface {p1, v7, v8}, Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;->onProgressUpdate(D)V

    move v7, v4

    .line 820
    :goto_38
    sget v8, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    invoke-virtual {v0, v2, v4, v8}, Ljava/io/InputStream;->read([BII)I

    move-result v8

    if-eq v8, v3, :cond_4a

    .line 821
    invoke-virtual {p0, v2, v4, v8}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    add-int/2addr v7, v8

    int-to-double v8, v7

    div-double/2addr v8, v5

    .line 823
    invoke-interface {p1, v8, v9}, Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;->onProgressUpdate(D)V

    goto :goto_38

    .line 826
    :cond_4a
    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p1
    :try_end_4e
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_4e} :catch_5f
    .catchall {:try_start_19 .. :try_end_4e} :catchall_7c

    .line 832
    :try_start_4e
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_51
    .catch Ljava/io/IOException; {:try_start_4e .. :try_end_51} :catch_52
    .catch Ljava/io/FileNotFoundException; {:try_start_4e .. :try_end_51} :catch_90

    goto :goto_56

    :catch_52
    move-exception v0

    .line 834
    :try_start_53
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_56
    .catch Ljava/io/FileNotFoundException; {:try_start_53 .. :try_end_56} :catch_90

    .line 838
    :goto_56
    :try_start_56
    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_59
    .catch Ljava/io/IOException; {:try_start_56 .. :try_end_59} :catch_5a
    .catch Ljava/io/FileNotFoundException; {:try_start_56 .. :try_end_59} :catch_90

    goto :goto_5e

    :catch_5a
    move-exception p0

    .line 841
    :try_start_5b
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5e
    .catch Ljava/io/FileNotFoundException; {:try_start_5b .. :try_end_5e} :catch_90

    :goto_5e
    return-object p1

    :catch_5f
    move-exception p1

    goto :goto_66

    :catchall_61
    move-exception p1

    move-object p0, v1

    goto :goto_7d

    :catch_64
    move-exception p1

    move-object p0, v1

    .line 828
    :goto_66
    :try_start_66
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_69
    .catchall {:try_start_66 .. :try_end_69} :catchall_7c

    .line 832
    :try_start_69
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_6c
    .catch Ljava/io/IOException; {:try_start_69 .. :try_end_6c} :catch_6d
    .catch Ljava/io/FileNotFoundException; {:try_start_69 .. :try_end_6c} :catch_90

    goto :goto_71

    :catch_6d
    move-exception p1

    .line 834
    :try_start_6e
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_71
    .catch Ljava/io/FileNotFoundException; {:try_start_6e .. :try_end_71} :catch_90

    :goto_71
    if-eqz p0, :cond_7b

    .line 838
    :try_start_73
    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_76
    .catch Ljava/io/IOException; {:try_start_73 .. :try_end_76} :catch_77
    .catch Ljava/io/FileNotFoundException; {:try_start_73 .. :try_end_76} :catch_90

    goto :goto_7b

    :catch_77
    move-exception p0

    .line 841
    :try_start_78
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_7b
    .catch Ljava/io/FileNotFoundException; {:try_start_78 .. :try_end_7b} :catch_90

    :cond_7b
    :goto_7b
    return-object v1

    :catchall_7c
    move-exception p1

    .line 832
    :goto_7d
    :try_start_7d
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_80
    .catch Ljava/io/IOException; {:try_start_7d .. :try_end_80} :catch_81
    .catch Ljava/io/FileNotFoundException; {:try_start_7d .. :try_end_80} :catch_90

    goto :goto_85

    :catch_81
    move-exception v0

    .line 834
    :try_start_82
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_85
    .catch Ljava/io/FileNotFoundException; {:try_start_82 .. :try_end_85} :catch_90

    :goto_85
    if-eqz p0, :cond_8f

    .line 838
    :try_start_87
    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_8a
    .catch Ljava/io/IOException; {:try_start_87 .. :try_end_8a} :catch_8b
    .catch Ljava/io/FileNotFoundException; {:try_start_87 .. :try_end_8a} :catch_90

    goto :goto_8f

    :catch_8b
    move-exception p0

    .line 841
    :try_start_8c
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 843
    :cond_8f
    :goto_8f
    throw p1
    :try_end_90
    .catch Ljava/io/FileNotFoundException; {:try_start_8c .. :try_end_90} :catch_90

    :catch_90
    move-exception p0

    .line 845
    invoke-virtual {p0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    return-object v1
.end method

.method public static readFile2BytesByStream(Ljava/lang/String;)[B
    .registers 2

    .line 766
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByStream(Ljava/io/File;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)[B

    move-result-object p0

    return-object p0
.end method

.method public static readFile2BytesByStream(Ljava/lang/String;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)[B
    .registers 2

    .line 792
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByStream(Ljava/io/File;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)[B

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/io/File;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const v0, 0x7fffffff

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 601
    invoke-static {p0, v2, v0, v1}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/io/File;II)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "II)",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    .line 652
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "II",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 668
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->isFileExists(Ljava/io/File;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_8

    return-object v1

    :cond_8
    if-le p1, p2, :cond_b

    return-object v1

    .line 674
    :cond_b
    :try_start_b
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 675
    invoke-static {p3}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v2

    const/4 v3, 0x1

    if-eqz v2, :cond_27

    .line 676
    new-instance p3, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    new-instance v4, Ljava/io/FileInputStream;

    invoke-direct {v4, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {p3, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    goto :goto_37

    .line 678
    :cond_27
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v4, v5, p3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v2, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_36
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_36} :catch_59
    .catchall {:try_start_b .. :try_end_36} :catchall_57

    move-object p3, v2

    .line 682
    :goto_37
    :try_start_37
    invoke-virtual {p3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_4a

    if-le v3, p2, :cond_40

    goto :goto_4a

    :cond_40
    if-gt p1, v3, :cond_47

    if-gt v3, p2, :cond_47

    .line 684
    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_37 .. :try_end_47} :catch_55
    .catchall {:try_start_37 .. :try_end_47} :catchall_69

    :cond_47
    add-int/lit8 v3, v3, 0x1

    goto :goto_37

    :cond_4a
    :goto_4a
    if-eqz p3, :cond_54

    .line 694
    :try_start_4c
    invoke-virtual {p3}, Ljava/io/BufferedReader;->close()V
    :try_end_4f
    .catch Ljava/io/IOException; {:try_start_4c .. :try_end_4f} :catch_50

    goto :goto_54

    :catch_50
    move-exception p0

    .line 697
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_54
    :goto_54
    return-object v0

    :catch_55
    move-exception p0

    goto :goto_5b

    :catchall_57
    move-exception p0

    goto :goto_6b

    :catch_59
    move-exception p0

    move-object p3, v1

    .line 689
    :goto_5b
    :try_start_5b
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_5e
    .catchall {:try_start_5b .. :try_end_5e} :catchall_69

    if-eqz p3, :cond_68

    .line 694
    :try_start_60
    invoke-virtual {p3}, Ljava/io/BufferedReader;->close()V
    :try_end_63
    .catch Ljava/io/IOException; {:try_start_60 .. :try_end_63} :catch_64

    goto :goto_68

    :catch_64
    move-exception p0

    .line 697
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_68
    :goto_68
    return-object v1

    :catchall_69
    move-exception p0

    move-object v1, p3

    :goto_6b
    if-eqz v1, :cond_75

    .line 694
    :try_start_6d
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_70
    .catch Ljava/io/IOException; {:try_start_6d .. :try_end_70} :catch_71

    goto :goto_75

    :catch_71
    move-exception p1

    .line 697
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 699
    :cond_75
    :goto_75
    throw p0
.end method

.method public static readFile2List(Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    const v1, 0x7fffffff

    .line 612
    invoke-static {p0, v0, v1, p1}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/lang/String;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 580
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;Ljava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/lang/String;II)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "II)",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 624
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/lang/String;IILjava/lang/String;)Ljava/util/List;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "II",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 640
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;IILjava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2List(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 591
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2List(Ljava/io/File;Ljava/lang/String;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2String(Ljava/io/File;)Ljava/lang/String;
    .registers 2

    const/4 v0, 0x0

    .line 730
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2String(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2String(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    .line 741
    invoke-static {p0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2BytesByStream(Ljava/io/File;)[B

    move-result-object p0

    if-nez p0, :cond_8

    const/4 p0, 0x0

    return-object p0

    .line 743
    :cond_8
    invoke-static {p1}, Lcom/blankj/utilcode/util/UtilsBridge;->isSpace(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 744
    new-instance p1, Ljava/lang/String;

    invoke-direct {p1, p0}, Ljava/lang/String;-><init>([B)V

    return-object p1

    .line 747
    :cond_14
    :try_start_14
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p0, p1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_19
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_14 .. :try_end_19} :catch_1a

    return-object v0

    :catch_1a
    move-exception p0

    .line 749
    invoke-virtual {p0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    const-string p0, ""

    return-object p0
.end method

.method public static readFile2String(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    .line 709
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2String(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static readFile2String(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    .line 720
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/FileIOUtils;->readFile2String(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static setBufferSize(I)V
    .registers 1

    .line 945
    sput p0, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    return-void
.end method

.method public static writeFileFromBytesByChannel(Ljava/io/File;[BZ)Z
    .registers 4

    const/4 v0, 0x0

    .line 363
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByChannel(Ljava/io/File;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByChannel(Ljava/io/File;[BZZ)Z
    .registers 9

    const-string v0, "FileIOUtils"

    const/4 v1, 0x0

    if-nez p1, :cond_b

    const-string p0, "bytes is null."

    .line 380
    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v1

    .line 383
    :cond_b
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->createOrExistsFile(Ljava/io/File;)Z

    move-result v2

    if-nez v2, :cond_2a

    .line 384
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p2, "create file <"

    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, "> failed."

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v1

    :cond_2a
    const/4 v2, 0x0

    .line 389
    :try_start_2b
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p0, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    invoke-virtual {v3}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v2

    if-nez v2, :cond_46

    const-string p0, "fc is null."

    .line 391
    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3b
    .catch Ljava/io/IOException; {:try_start_2b .. :try_end_3b} :catch_67
    .catchall {:try_start_2b .. :try_end_3b} :catchall_65

    if-eqz v2, :cond_45

    .line 404
    :try_start_3d
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_40
    .catch Ljava/io/IOException; {:try_start_3d .. :try_end_40} :catch_41

    goto :goto_45

    :catch_41
    move-exception p0

    .line 407
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_45
    :goto_45
    return v1

    .line 394
    :cond_46
    :try_start_46
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/nio/channels/FileChannel;->position(J)Ljava/nio/channels/FileChannel;

    .line 395
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p0

    invoke-virtual {v2, p0}, Ljava/nio/channels/FileChannel;->write(Ljava/nio/ByteBuffer;)I

    const/4 p0, 0x1

    if-eqz p3, :cond_5a

    .line 396
    invoke-virtual {v2, p0}, Ljava/nio/channels/FileChannel;->force(Z)V
    :try_end_5a
    .catch Ljava/io/IOException; {:try_start_46 .. :try_end_5a} :catch_67
    .catchall {:try_start_46 .. :try_end_5a} :catchall_65

    :cond_5a
    if-eqz v2, :cond_64

    .line 404
    :try_start_5c
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_5f
    .catch Ljava/io/IOException; {:try_start_5c .. :try_end_5f} :catch_60

    goto :goto_64

    :catch_60
    move-exception p1

    .line 407
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    :cond_64
    :goto_64
    return p0

    :catchall_65
    move-exception p0

    goto :goto_76

    :catch_67
    move-exception p0

    .line 399
    :try_start_68
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_6b
    .catchall {:try_start_68 .. :try_end_6b} :catchall_65

    if-eqz v2, :cond_75

    .line 404
    :try_start_6d
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_70
    .catch Ljava/io/IOException; {:try_start_6d .. :try_end_70} :catch_71

    goto :goto_75

    :catch_71
    move-exception p0

    .line 407
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_75
    :goto_75
    return v1

    :goto_76
    if-eqz v2, :cond_80

    .line 404
    :try_start_78
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_7b
    .catch Ljava/io/IOException; {:try_start_78 .. :try_end_7b} :catch_7c

    goto :goto_80

    :catch_7c
    move-exception p1

    .line 407
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 409
    :cond_80
    :goto_80
    throw p0
.end method

.method public static writeFileFromBytesByChannel(Ljava/lang/String;[BZ)Z
    .registers 4

    .line 333
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByChannel(Ljava/io/File;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByChannel(Ljava/lang/String;[BZZ)Z
    .registers 4

    .line 349
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByChannel(Ljava/io/File;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByMap(Ljava/io/File;[BZ)Z
    .registers 4

    const/4 v0, 0x0

    .line 453
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByMap(Ljava/io/File;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByMap(Ljava/io/File;[BZZ)Z
    .registers 14

    const-string v0, "FileIOUtils"

    const/4 v1, 0x0

    if-eqz p1, :cond_65

    .line 469
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->createOrExistsFile(Ljava/io/File;)Z

    move-result v2

    if-nez v2, :cond_c

    goto :goto_65

    :cond_c
    const/4 v2, 0x0

    .line 475
    :try_start_d
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p0, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    invoke-virtual {v3}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v2

    if-nez v2, :cond_28

    const-string p0, "fc is null."

    .line 477
    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_1d} :catch_4b
    .catchall {:try_start_d .. :try_end_1d} :catchall_49

    if-eqz v2, :cond_27

    .line 490
    :try_start_1f
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_22
    .catch Ljava/io/IOException; {:try_start_1f .. :try_end_22} :catch_23

    goto :goto_27

    :catch_23
    move-exception p0

    .line 493
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_27
    :goto_27
    return v1

    .line 480
    :cond_28
    :try_start_28
    sget-object v5, Ljava/nio/channels/FileChannel$MapMode;->READ_WRITE:Ljava/nio/channels/FileChannel$MapMode;

    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v6

    array-length p0, p1

    int-to-long v8, p0

    move-object v4, v2

    invoke-virtual/range {v4 .. v9}, Ljava/nio/channels/FileChannel;->map(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;

    move-result-object p0

    .line 481
    invoke-virtual {p0, p1}, Ljava/nio/MappedByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    if-eqz p3, :cond_3d

    .line 482
    invoke-virtual {p0}, Ljava/nio/MappedByteBuffer;->force()Ljava/nio/MappedByteBuffer;
    :try_end_3d
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_3d} :catch_4b
    .catchall {:try_start_28 .. :try_end_3d} :catchall_49

    :cond_3d
    if-eqz v2, :cond_47

    .line 490
    :try_start_3f
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_3f .. :try_end_42} :catch_43

    goto :goto_47

    :catch_43
    move-exception p0

    .line 493
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_47
    :goto_47
    const/4 p0, 0x1

    return p0

    :catchall_49
    move-exception p0

    goto :goto_5a

    :catch_4b
    move-exception p0

    .line 485
    :try_start_4c
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4f
    .catchall {:try_start_4c .. :try_end_4f} :catchall_49

    if-eqz v2, :cond_59

    .line 490
    :try_start_51
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_54
    .catch Ljava/io/IOException; {:try_start_51 .. :try_end_54} :catch_55

    goto :goto_59

    :catch_55
    move-exception p0

    .line 493
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_59
    :goto_59
    return v1

    :goto_5a
    if-eqz v2, :cond_64

    .line 490
    :try_start_5c
    invoke-virtual {v2}, Ljava/nio/channels/FileChannel;->close()V
    :try_end_5f
    .catch Ljava/io/IOException; {:try_start_5c .. :try_end_5f} :catch_60

    goto :goto_64

    :catch_60
    move-exception p1

    .line 493
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 495
    :cond_64
    :goto_64
    throw p0

    .line 470
    :cond_65
    :goto_65
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p2, "create file <"

    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, "> failed."

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v1
.end method

.method public static writeFileFromBytesByMap(Ljava/lang/String;[BZ)Z
    .registers 4

    const/4 v0, 0x0

    .line 423
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByMap(Ljava/lang/String;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByMap(Ljava/lang/String;[BZZ)Z
    .registers 4

    .line 439
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByMap(Ljava/io/File;[BZZ)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/io/File;[B)Z
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 240
    invoke-static {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/io/File;[BLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    const/4 v0, 0x0

    .line 302
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/io/File;[BZ)Z
    .registers 4

    const/4 v0, 0x0

    .line 254
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 5

    if-nez p1, :cond_4

    const/4 p0, 0x0

    return p0

    .line 319
    :cond_4
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-static {p0, v0, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/lang/String;[B)Z
    .registers 4

    .line 215
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/lang/String;[BLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    .line 272
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/lang/String;[BZ)Z
    .registers 4

    .line 229
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromBytesByStream(Ljava/lang/String;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    .line 288
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromBytesByStream(Ljava/io/File;[BZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;)Z
    .registers 4

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 81
    invoke-static {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    const/4 v0, 0x0

    .line 143
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;Z)Z
    .registers 4

    const/4 v0, 0x0

    .line 95
    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 11

    const/4 v0, 0x0

    if-eqz p1, :cond_8c

    .line 159
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->createOrExistsFile(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_b

    goto/16 :goto_8c

    :cond_b
    const/4 v1, 0x0

    .line 165
    :try_start_c
    new-instance v2, Ljava/io/BufferedOutputStream;

    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, p0, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    sget p0, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    invoke-direct {v2, v3, p0}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_18
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_18} :catch_62
    .catchall {:try_start_c .. :try_end_18} :catchall_60

    const/4 p0, -0x1

    if-nez p3, :cond_29

    .line 167
    :try_start_1b
    sget p2, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    new-array p2, p2, [B

    .line 168
    :goto_1f
    invoke-virtual {p1, p2}, Ljava/io/InputStream;->read([B)I

    move-result p3

    if-eq p3, p0, :cond_48

    .line 169
    invoke-virtual {v2, p2, v0, p3}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_1f

    .line 172
    :cond_29
    invoke-virtual {p1}, Ljava/io/InputStream;->available()I

    move-result p2

    int-to-double v3, p2

    const-wide/16 v5, 0x0

    .line 174
    invoke-interface {p3, v5, v6}, Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;->onProgressUpdate(D)V

    .line 175
    sget p2, Lcom/blankj/utilcode/util/FileIOUtils;->sBufferSize:I

    new-array p2, p2, [B

    move v1, v0

    .line 176
    :goto_38
    invoke-virtual {p1, p2}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-eq v5, p0, :cond_48

    .line 177
    invoke-virtual {v2, p2, v0, v5}, Ljava/io/OutputStream;->write([BII)V

    add-int/2addr v1, v5

    int-to-double v5, v1

    div-double/2addr v5, v3

    .line 179
    invoke-interface {p3, v5, v6}, Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;->onProgressUpdate(D)V
    :try_end_47
    .catch Ljava/io/IOException; {:try_start_1b .. :try_end_47} :catch_5d
    .catchall {:try_start_1b .. :try_end_47} :catchall_5a

    goto :goto_38

    .line 188
    :cond_48
    :try_start_48
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_4b
    .catch Ljava/io/IOException; {:try_start_48 .. :try_end_4b} :catch_4c

    goto :goto_50

    :catch_4c
    move-exception p0

    .line 190
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    .line 194
    :goto_50
    :try_start_50
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V
    :try_end_53
    .catch Ljava/io/IOException; {:try_start_50 .. :try_end_53} :catch_54

    goto :goto_58

    :catch_54
    move-exception p0

    .line 197
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_58
    const/4 p0, 0x1

    return p0

    :catchall_5a
    move-exception p0

    move-object v1, v2

    goto :goto_79

    :catch_5d
    move-exception p0

    move-object v1, v2

    goto :goto_63

    :catchall_60
    move-exception p0

    goto :goto_79

    :catch_62
    move-exception p0

    .line 184
    :goto_63
    :try_start_63
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_66
    .catchall {:try_start_63 .. :try_end_66} :catchall_60

    .line 188
    :try_start_66
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_69
    .catch Ljava/io/IOException; {:try_start_66 .. :try_end_69} :catch_6a

    goto :goto_6e

    :catch_6a
    move-exception p0

    .line 190
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_6e
    if-eqz v1, :cond_78

    .line 194
    :try_start_70
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_73
    .catch Ljava/io/IOException; {:try_start_70 .. :try_end_73} :catch_74

    goto :goto_78

    :catch_74
    move-exception p0

    .line 197
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_78
    :goto_78
    return v0

    .line 188
    :goto_79
    :try_start_79
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V
    :try_end_7c
    .catch Ljava/io/IOException; {:try_start_79 .. :try_end_7c} :catch_7d

    goto :goto_81

    :catch_7d
    move-exception p1

    .line 190
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    :goto_81
    if-eqz v1, :cond_8b

    .line 194
    :try_start_83
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_86
    .catch Ljava/io/IOException; {:try_start_83 .. :try_end_86} :catch_87

    goto :goto_8b

    :catch_87
    move-exception p1

    .line 197
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 199
    :cond_8b
    :goto_8b
    throw p0

    .line 160
    :cond_8c
    :goto_8c
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p2, "create file <"

    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, "> failed."

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string p1, "FileIOUtils"

    invoke-static {p1, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v0
.end method

.method public static writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;)Z
    .registers 4

    .line 56
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;Lcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    .line 113
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;Z)Z
    .registers 4

    .line 70
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromIS(Ljava/lang/String;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z
    .registers 4

    .line 129
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromIS(Ljava/io/File;Ljava/io/InputStream;ZLcom/blankj/utilcode/util/FileIOUtils$OnProgressUpdateListener;)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromString(Ljava/io/File;Ljava/lang/String;)Z
    .registers 3

    const/4 v0, 0x0

    .line 531
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromString(Ljava/io/File;Ljava/lang/String;Z)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromString(Ljava/io/File;Ljava/lang/String;Z)Z
    .registers 7

    const/4 v0, 0x0

    if-eqz p0, :cond_61

    if-nez p1, :cond_6

    goto :goto_61

    .line 546
    :cond_6
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->createOrExistsFile(Ljava/io/File;)Z

    move-result v1

    if-nez v1, :cond_27

    .line 547
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p2, "create file <"

    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p1, "> failed."

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string p1, "FileIOUtils"

    invoke-static {p1, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return v0

    :cond_27
    const/4 v1, 0x0

    .line 552
    :try_start_28
    new-instance v2, Ljava/io/BufferedWriter;

    new-instance v3, Ljava/io/FileWriter;

    invoke-direct {v3, p0, p2}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    invoke-direct {v2, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_32
    .catch Ljava/io/IOException; {:try_start_28 .. :try_end_32} :catch_47
    .catchall {:try_start_28 .. :try_end_32} :catchall_45

    .line 553
    :try_start_32
    invoke-virtual {v2, p1}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_35
    .catch Ljava/io/IOException; {:try_start_32 .. :try_end_35} :catch_42
    .catchall {:try_start_32 .. :try_end_35} :catchall_3f

    .line 561
    :try_start_35
    invoke-virtual {v2}, Ljava/io/BufferedWriter;->close()V
    :try_end_38
    .catch Ljava/io/IOException; {:try_start_35 .. :try_end_38} :catch_39

    goto :goto_3d

    :catch_39
    move-exception p0

    .line 564
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :goto_3d
    const/4 p0, 0x1

    return p0

    :catchall_3f
    move-exception p0

    move-object v1, v2

    goto :goto_56

    :catch_42
    move-exception p0

    move-object v1, v2

    goto :goto_48

    :catchall_45
    move-exception p0

    goto :goto_56

    :catch_47
    move-exception p0

    .line 556
    :goto_48
    :try_start_48
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4b
    .catchall {:try_start_48 .. :try_end_4b} :catchall_45

    if-eqz v1, :cond_55

    .line 561
    :try_start_4d
    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V
    :try_end_50
    .catch Ljava/io/IOException; {:try_start_4d .. :try_end_50} :catch_51

    goto :goto_55

    :catch_51
    move-exception p0

    .line 564
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_55
    :goto_55
    return v0

    :goto_56
    if-eqz v1, :cond_60

    .line 561
    :try_start_58
    invoke-virtual {v1}, Ljava/io/BufferedWriter;->close()V
    :try_end_5b
    .catch Ljava/io/IOException; {:try_start_58 .. :try_end_5b} :catch_5c

    goto :goto_60

    :catch_5c
    move-exception p1

    .line 564
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    .line 566
    :cond_60
    :goto_60
    throw p0

    :cond_61
    :goto_61
    return v0
.end method

.method public static writeFileFromString(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 3

    .line 506
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromString(Ljava/io/File;Ljava/lang/String;Z)Z

    move-result p0

    return p0
.end method

.method public static writeFileFromString(Ljava/lang/String;Ljava/lang/String;Z)Z
    .registers 3

    .line 520
    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->getFileByPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/FileIOUtils;->writeFileFromString(Ljava/io/File;Ljava/lang/String;Z)Z

    move-result p0

    return p0
.end method
