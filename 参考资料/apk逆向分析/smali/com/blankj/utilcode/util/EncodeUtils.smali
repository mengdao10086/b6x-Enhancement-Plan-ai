.class public final Lcom/blankj/utilcode/util/EncodeUtils;
.super Ljava/lang/Object;
.source "EncodeUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static base64Decode(Ljava/lang/String;)[B
    .registers 2

    if-eqz p0, :cond_f

    .line 117
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_f

    :cond_9
    const/4 v0, 0x2

    .line 118
    invoke-static {p0, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object p0

    return-object p0

    :cond_f
    :goto_f
    const/4 p0, 0x0

    new-array p0, p0, [B

    return-object p0
.end method

.method public static base64Decode([B)[B
    .registers 2

    if-eqz p0, :cond_c

    .line 128
    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_c

    :cond_6
    const/4 v0, 0x2

    .line 129
    invoke-static {p0, v0}, Landroid/util/Base64;->decode([BI)[B

    move-result-object p0

    return-object p0

    :cond_c
    :goto_c
    const/4 p0, 0x0

    new-array p0, p0, [B

    return-object p0
.end method

.method public static base64Encode(Ljava/lang/String;)[B
    .registers 1

    .line 85
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncodeUtils;->base64Encode([B)[B

    move-result-object p0

    return-object p0
.end method

.method public static base64Encode([B)[B
    .registers 2

    if-eqz p0, :cond_c

    .line 95
    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_c

    :cond_6
    const/4 v0, 0x2

    .line 96
    invoke-static {p0, v0}, Landroid/util/Base64;->encode([BI)[B

    move-result-object p0

    return-object p0

    :cond_c
    :goto_c
    const/4 p0, 0x0

    new-array p0, p0, [B

    return-object p0
.end method

.method public static base64Encode2String([B)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_c

    .line 106
    array-length v0, p0

    if-nez v0, :cond_6

    goto :goto_c

    :cond_6
    const/4 v0, 0x2

    .line 107
    invoke-static {p0, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_c
    :goto_c
    const-string p0, ""

    return-object p0
.end method

.method public static binaryDecode(Ljava/lang/String;)Ljava/lang/String;
    .registers 6

    if-eqz p0, :cond_2b

    .line 209
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_2b

    :cond_9
    const-string v0, " "

    .line 210
    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object p0

    .line 211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 212
    array-length v1, p0

    const/4 v2, 0x0

    :goto_16
    if-ge v2, v1, :cond_26

    aget-object v3, p0, v2

    const/4 v4, 0x2

    .line 213
    invoke-static {v3, v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v3

    int-to-char v3, v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, 0x1

    goto :goto_16

    .line 215
    :cond_26
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_2b
    :goto_2b
    const-string p0, ""

    return-object p0
.end method

.method public static binaryEncode(Ljava/lang/String;)Ljava/lang/String;
    .registers 6

    if-eqz p0, :cond_37

    .line 194
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_37

    .line 195
    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 196
    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object p0

    array-length v1, p0

    const/4 v2, 0x0

    :goto_14
    if-ge v2, v1, :cond_28

    aget-char v3, p0, v2

    .line 197
    invoke-static {v3}, Ljava/lang/Integer;->toBinaryString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, 0x1

    goto :goto_14

    .line 199
    :cond_28
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result p0

    add-int/lit8 p0, p0, -0x1

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_37
    :goto_37
    const-string p0, ""

    return-object p0
.end method

.method public static htmlDecode(Ljava/lang/String;)Ljava/lang/CharSequence;
    .registers 2

    if-eqz p0, :cond_f

    .line 179
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_f

    :cond_9
    const/4 v0, 0x0

    .line 181
    invoke-static {p0, v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;I)Landroid/text/Spanned;

    move-result-object p0

    return-object p0

    :cond_f
    :goto_f
    const-string p0, ""

    return-object p0
.end method

.method public static htmlEncode(Ljava/lang/CharSequence;)Ljava/lang/String;
    .registers 6

    if-eqz p0, :cond_56

    .line 139
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_56

    .line 140
    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 142
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    const/4 v2, 0x0

    :goto_13
    if-ge v2, v1, :cond_51

    .line 143
    invoke-interface {p0, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    const/16 v4, 0x22

    if-eq v3, v4, :cond_49

    const/16 v4, 0x3c

    if-eq v3, v4, :cond_43

    const/16 v4, 0x3e

    if-eq v3, v4, :cond_3d

    const/16 v4, 0x26

    if-eq v3, v4, :cond_37

    const/16 v4, 0x27

    if-eq v3, v4, :cond_31

    .line 166
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_4e

    :cond_31
    const-string v3, "&#39;"

    .line 160
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4e

    :cond_37
    const-string v3, "&amp;"

    .line 152
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4e

    :cond_3d
    const-string v3, "&gt;"

    .line 149
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4e

    :cond_43
    const-string v3, "&lt;"

    .line 146
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4e

    :cond_49
    const-string v3, "&quot;"

    .line 163
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_4e
    add-int/lit8 v2, v2, 0x1

    goto :goto_13

    .line 169
    :cond_51
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_56
    :goto_56
    const-string p0, ""

    return-object p0
.end method

.method public static urlDecode(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    const-string v0, "UTF-8"

    .line 58
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncodeUtils;->urlDecode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static urlDecode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    if-eqz p0, :cond_25

    .line 69
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_25

    :cond_9
    :try_start_9
    const-string v0, "%(?![0-9a-fA-F]{2})"

    const-string v1, "%25"

    .line 71
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    const-string v0, "\\+"

    const-string v1, "%2B"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 72
    invoke-static {p0, p1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0
    :try_end_1d
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_9 .. :try_end_1d} :catch_1e

    return-object p0

    :catch_1e
    move-exception p0

    .line 74
    new-instance p1, Ljava/lang/AssertionError;

    invoke-direct {p1, p0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw p1

    :cond_25
    :goto_25
    const-string p0, ""

    return-object p0
.end method

.method public static urlEncode(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    const-string v0, "UTF-8"

    .line 32
    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncodeUtils;->urlEncode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static urlEncode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_15

    .line 43
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_15

    .line 45
    :cond_9
    :try_start_9
    invoke-static {p0, p1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0
    :try_end_d
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_9 .. :try_end_d} :catch_e

    return-object p0

    :catch_e
    move-exception p0

    .line 47
    new-instance p1, Ljava/lang/AssertionError;

    invoke-direct {p1, p0}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw p1

    :cond_15
    :goto_15
    const-string p0, ""

    return-object p0
.end method
