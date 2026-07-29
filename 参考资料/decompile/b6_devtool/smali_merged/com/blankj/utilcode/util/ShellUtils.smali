.class public final Lcom/blankj/utilcode/util/ShellUtils;
.super Ljava/lang/Object;
.source "ShellUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    }
.end annotation


# static fields
.field private static final LINE_SEP:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, "line.separator"

    .line 21
    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/blankj/utilcode/util/ShellUtils;->LINE_SEP:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static execCmd(Ljava/lang/String;Ljava/util/List;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;Z)",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;"
        }
    .end annotation

    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    if-nez p1, :cond_a

    const/4 p0, 0x0

    goto :goto_12

    :cond_a
    new-array p0, v2, [Ljava/lang/String;

    .line 146
    invoke-interface {p1, p0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    .line 145
    :goto_12
    invoke-static {v1, p0, p2, v0}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/lang/String;Ljava/util/List;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;ZZ)",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;"
        }
    .end annotation

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    if-nez p1, :cond_a

    const/4 p0, 0x0

    goto :goto_12

    :cond_a
    new-array p0, v1, [Ljava/lang/String;

    .line 217
    invoke-interface {p1, p0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_12
    invoke-static {v0, p0, p2, p3}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/lang/String;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 5

    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    .line 133
    invoke-static {v1, p1, v0}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 5

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    .line 201
    invoke-static {v0, p1, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 6

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    .line 235
    invoke-static {v0, p1, p2, p3}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/util/List;Ljava/util/List;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;Z)",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;"
        }
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x0

    if-nez p0, :cond_6

    move-object p0, v0

    goto :goto_e

    :cond_6
    new-array v2, v1, [Ljava/lang/String;

    .line 173
    invoke-interface {p0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_e
    if-nez p1, :cond_11

    goto :goto_1a

    :cond_11
    new-array v0, v1, [Ljava/lang/String;

    .line 174
    invoke-interface {p1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    move-object v0, p1

    check-cast v0, [Ljava/lang/String;

    :goto_1a
    const/4 p1, 0x1

    .line 173
    invoke-static {p0, v0, p2, p1}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/util/List;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;Z)",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_d

    :cond_4
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    .line 159
    invoke-interface {p0, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_d
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd(Ljava/util/List;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;ZZ)",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_d

    :cond_4
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    .line 249
    invoke-interface {p0, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_d
    invoke-static {p0, p1, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd([Ljava/lang/String;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 3

    const/4 v0, 0x1

    .line 187
    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd([Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 4

    const/4 v0, 0x0

    .line 265
    invoke-static {p0, v0, p1, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    return-object p0
.end method

.method public static execCmd([Ljava/lang/String;[Ljava/lang/String;ZZ)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;
    .registers 12

    const-string v0, "UTF-8"

    const-string v1, ""

    const/4 v2, -0x1

    if-eqz p0, :cond_17b

    .line 286
    array-length v3, p0

    if-nez v3, :cond_c

    goto/16 :goto_17b

    :cond_c
    const/4 v3, 0x0

    .line 296
    :try_start_d
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v4

    if-eqz p2, :cond_16

    const-string p2, "su"

    goto :goto_18

    :cond_16
    const-string p2, "sh"

    :goto_18
    invoke-virtual {v4, p2, p1, v3}, Ljava/lang/Runtime;->exec(Ljava/lang/String;[Ljava/lang/String;Ljava/io/File;)Ljava/lang/Process;

    move-result-object p1
    :try_end_1c
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_1c} :catch_114
    .catchall {:try_start_d .. :try_end_1c} :catchall_10f

    .line 297
    :try_start_1c
    new-instance p2, Ljava/io/DataOutputStream;

    invoke-virtual {p1}, Ljava/lang/Process;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    invoke-direct {p2, v4}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_25
    .catch Ljava/lang/Exception; {:try_start_1c .. :try_end_25} :catch_10c
    .catchall {:try_start_1c .. :try_end_25} :catchall_109

    .line 298
    :try_start_25
    array-length v4, p0

    const/4 v5, 0x0

    :goto_27
    if-ge v5, v4, :cond_40

    aget-object v6, p0, v5

    if-nez v6, :cond_2e

    goto :goto_3d

    .line 300
    :cond_2e
    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {p2, v6}, Ljava/io/DataOutputStream;->write([B)V

    .line 301
    sget-object v6, Lcom/blankj/utilcode/util/ShellUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p2, v6}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 302
    invoke-virtual {p2}, Ljava/io/DataOutputStream;->flush()V

    :goto_3d
    add-int/lit8 v5, v5, 0x1

    goto :goto_27

    .line 304
    :cond_40
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "exit"

    invoke-virtual {p0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    sget-object v4, Lcom/blankj/utilcode/util/ShellUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p2, p0}, Ljava/io/DataOutputStream;->writeBytes(Ljava/lang/String;)V

    .line 305
    invoke-virtual {p2}, Ljava/io/DataOutputStream;->flush()V

    .line 306
    invoke-virtual {p1}, Ljava/lang/Process;->waitFor()I

    move-result v2

    if-eqz p3, :cond_d6

    .line 308
    new-instance p0, Ljava/lang/StringBuilder;

    invoke-direct {p0}, Ljava/lang/StringBuilder;-><init>()V
    :try_end_66
    .catch Ljava/lang/Exception; {:try_start_25 .. :try_end_66} :catch_102
    .catchall {:try_start_25 .. :try_end_66} :catchall_fc

    .line 309
    :try_start_66
    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V
    :try_end_6b
    .catch Ljava/lang/Exception; {:try_start_66 .. :try_end_6b} :catch_cd
    .catchall {:try_start_66 .. :try_end_6b} :catchall_fc

    .line 310
    :try_start_6b
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    .line 311
    invoke-virtual {p1}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    invoke-direct {v5, v6, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v4, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_79
    .catch Ljava/lang/Exception; {:try_start_6b .. :try_end_79} :catch_c5
    .catchall {:try_start_6b .. :try_end_79} :catchall_fc

    .line 313
    :try_start_79
    new-instance v5, Ljava/io/BufferedReader;

    new-instance v6, Ljava/io/InputStreamReader;

    .line 314
    invoke-virtual {p1}, Ljava/lang/Process;->getErrorStream()Ljava/io/InputStream;

    move-result-object v7

    invoke-direct {v6, v7, v0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v5, v6}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_87
    .catch Ljava/lang/Exception; {:try_start_79 .. :try_end_87} :catch_c2
    .catchall {:try_start_79 .. :try_end_87} :catchall_bf

    .line 317
    :try_start_87
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a0

    .line 318
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 319
    :goto_90
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a0

    .line 320
    sget-object v3, Lcom/blankj/utilcode/util/ShellUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_90

    .line 323
    :cond_a0
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_b9

    .line 324
    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 325
    :goto_a9
    invoke-virtual {v5}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_b9

    .line 326
    sget-object v3, Lcom/blankj/utilcode/util/ShellUtils;->LINE_SEP:Ljava/lang/String;

    invoke-virtual {p3, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_b8
    .catch Ljava/lang/Exception; {:try_start_87 .. :try_end_b8} :catch_bd
    .catchall {:try_start_87 .. :try_end_b8} :catchall_bb

    goto :goto_a9

    :cond_b9
    move-object v3, v4

    goto :goto_d9

    :catchall_bb
    move-exception p0

    goto :goto_ff

    :catch_bd
    move-exception v0

    goto :goto_c8

    :catchall_bf
    move-exception p0

    move-object v5, v3

    goto :goto_ff

    :catch_c2
    move-exception v0

    move-object v5, v3

    goto :goto_c8

    :catch_c5
    move-exception v0

    move-object v4, v3

    move-object v5, v4

    :goto_c8
    move-object v3, p2

    move-object p2, p0

    move-object p0, v0

    goto/16 :goto_11a

    :catch_cd
    move-exception p3

    move-object v4, v3

    move-object v5, v4

    move-object v3, p2

    move-object p2, p0

    move-object p0, p3

    move-object p3, v5

    goto/16 :goto_11a

    :cond_d6
    move-object p0, v3

    move-object p3, p0

    move-object v5, p3

    .line 335
    :goto_d9
    :try_start_d9
    invoke-virtual {p2}, Ljava/io/DataOutputStream;->close()V
    :try_end_dc
    .catch Ljava/io/IOException; {:try_start_d9 .. :try_end_dc} :catch_dd

    goto :goto_e1

    :catch_dd
    move-exception p2

    .line 338
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :goto_e1
    if-eqz v3, :cond_eb

    .line 342
    :try_start_e3
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_e6
    .catch Ljava/io/IOException; {:try_start_e3 .. :try_end_e6} :catch_e7

    goto :goto_eb

    :catch_e7
    move-exception p2

    .line 345
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :cond_eb
    :goto_eb
    if-eqz v5, :cond_f5

    .line 349
    :try_start_ed
    invoke-virtual {v5}, Ljava/io/BufferedReader;->close()V
    :try_end_f0
    .catch Ljava/io/IOException; {:try_start_ed .. :try_end_f0} :catch_f1

    goto :goto_f5

    :catch_f1
    move-exception p2

    .line 352
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :cond_f5
    :goto_f5
    if-eqz p1, :cond_141

    .line 355
    invoke-virtual {p1}, Ljava/lang/Process;->destroy()V

    goto/16 :goto_141

    :catchall_fc
    move-exception p0

    move-object v4, v3

    move-object v5, v4

    :goto_ff
    move-object v3, p2

    goto/16 :goto_157

    :catch_102
    move-exception p0

    move-object p3, v3

    move-object v4, p3

    move-object v5, v4

    move-object v3, p2

    move-object p2, v5

    goto :goto_11a

    :catchall_109
    move-exception p0

    move-object v4, v3

    goto :goto_112

    :catch_10c
    move-exception p0

    move-object p2, v3

    goto :goto_117

    :catchall_10f
    move-exception p0

    move-object p1, v3

    move-object v4, p1

    :goto_112
    move-object v5, v4

    goto :goto_157

    :catch_114
    move-exception p0

    move-object p1, v3

    move-object p2, p1

    :goto_117
    move-object p3, p2

    move-object v4, p3

    move-object v5, v4

    .line 331
    :goto_11a
    :try_start_11a
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_11d
    .catchall {:try_start_11a .. :try_end_11d} :catchall_156

    if-eqz v3, :cond_127

    .line 335
    :try_start_11f
    invoke-virtual {v3}, Ljava/io/DataOutputStream;->close()V
    :try_end_122
    .catch Ljava/io/IOException; {:try_start_11f .. :try_end_122} :catch_123

    goto :goto_127

    :catch_123
    move-exception p0

    .line 338
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_127
    :goto_127
    if-eqz v4, :cond_131

    .line 342
    :try_start_129
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_12c
    .catch Ljava/io/IOException; {:try_start_129 .. :try_end_12c} :catch_12d

    goto :goto_131

    :catch_12d
    move-exception p0

    .line 345
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_131
    :goto_131
    if-eqz v5, :cond_13b

    .line 349
    :try_start_133
    invoke-virtual {v5}, Ljava/io/BufferedReader;->close()V
    :try_end_136
    .catch Ljava/io/IOException; {:try_start_133 .. :try_end_136} :catch_137

    goto :goto_13b

    :catch_137
    move-exception p0

    .line 352
    invoke-virtual {p0}, Ljava/io/IOException;->printStackTrace()V

    :cond_13b
    :goto_13b
    if-eqz p1, :cond_140

    .line 355
    invoke-virtual {p1}, Ljava/lang/Process;->destroy()V

    :cond_140
    move-object p0, p2

    .line 358
    :cond_141
    :goto_141
    new-instance p1, Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    if-nez p0, :cond_147

    move-object p0, v1

    goto :goto_14b

    .line 360
    :cond_147
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    :goto_14b
    if-nez p3, :cond_14e

    goto :goto_152

    .line 361
    :cond_14e
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_152
    invoke-direct {p1, v2, p0, v1}, Lcom/blankj/utilcode/util/ShellUtils$CommandResult;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    return-object p1

    :catchall_156
    move-exception p0

    :goto_157
    if-eqz v3, :cond_161

    .line 335
    :try_start_159
    invoke-virtual {v3}, Ljava/io/DataOutputStream;->close()V
    :try_end_15c
    .catch Ljava/io/IOException; {:try_start_159 .. :try_end_15c} :catch_15d

    goto :goto_161

    :catch_15d
    move-exception p2

    .line 338
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :cond_161
    :goto_161
    if-eqz v4, :cond_16b

    .line 342
    :try_start_163
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_166
    .catch Ljava/io/IOException; {:try_start_163 .. :try_end_166} :catch_167

    goto :goto_16b

    :catch_167
    move-exception p2

    .line 345
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :cond_16b
    :goto_16b
    if-eqz v5, :cond_175

    .line 349
    :try_start_16d
    invoke-virtual {v5}, Ljava/io/BufferedReader;->close()V
    :try_end_170
    .catch Ljava/io/IOException; {:try_start_16d .. :try_end_170} :catch_171

    goto :goto_175

    :catch_171
    move-exception p2

    .line 352
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V

    :cond_175
    :goto_175
    if-eqz p1, :cond_17a

    .line 355
    invoke-virtual {p1}, Ljava/lang/Process;->destroy()V

    .line 357
    :cond_17a
    throw p0

    .line 287
    :cond_17b
    :goto_17b
    new-instance p0, Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    invoke-direct {p0, v2, v1, v1}, Lcom/blankj/utilcode/util/ShellUtils$CommandResult;-><init>(ILjava/lang/String;Ljava/lang/String;)V

    return-object p0
.end method

.method public static execCmdAsync(Ljava/lang/String;ZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    .line 38
    invoke-static {v1, p1, v0, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static execCmdAsync(Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "ZZ",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    .line 82
    invoke-static {v0, p1, p2, p3}, Lcom/blankj/utilcode/util/ShellUtils;->execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static execCmdAsync(Ljava/util/List;ZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;Z",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_d

    :cond_4
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    .line 52
    invoke-interface {p0, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_d
    const/4 v0, 0x1

    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static execCmdAsync(Ljava/util/List;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;ZZ",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    if-nez p0, :cond_4

    const/4 p0, 0x0

    goto :goto_d

    :cond_4
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    .line 98
    invoke-interface {p0, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [Ljava/lang/String;

    :goto_d
    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/ShellUtils;->execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static execCmdAsync([Ljava/lang/String;ZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "Z",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 66
    invoke-static {p0, p1, v0, p2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static execCmdAsync([Ljava/lang/String;ZZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "ZZ",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Lcom/blankj/utilcode/util/ShellUtils$CommandResult;",
            ">;"
        }
    .end annotation

    .line 117
    new-instance v0, Lcom/blankj/utilcode/util/ShellUtils$1;

    invoke-direct {v0, p3, p0, p1, p2}, Lcom/blankj/utilcode/util/ShellUtils$1;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;[Ljava/lang/String;ZZ)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method
