.class public final Lcom/blankj/utilcode/util/EncryptUtils;
.super Ljava/lang/Object;
.source "EncryptUtils.java"


# direct methods
.method private constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static decrypt3DES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "DESede"

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptAES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "AES"

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptBase64AES([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Decode([B)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptAES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptBase64DES([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Decode([B)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptDES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptBase64RSA([B[BILjava/lang/String;)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Decode([B)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptRSA([B[BILjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptBase64_3DES([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Decode([B)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decrypt3DES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptDES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "DES"

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptHexString3DES(Ljava/lang/String;[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->hexString2Bytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decrypt3DES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptHexStringAES(Ljava/lang/String;[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->hexString2Bytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptAES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptHexStringDES(Ljava/lang/String;[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->hexString2Bytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptDES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptHexStringRSA(Ljava/lang/String;[BILjava/lang/String;)[B
    .registers 4

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->hexString2Bytes(Ljava/lang/String;)[B

    move-result-object p0

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->decryptRSA([B[BILjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static decryptRSA([B[BILjava/lang/String;)[B
    .registers 5

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, p3, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->rsaTemplate([B[BILjava/lang/String;Z)[B

    move-result-object p0

    return-object p0
.end method

.method public static encrypt3DES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "DESede"

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static encrypt3DES2Base64([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encrypt3DES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Encode([B)[B

    move-result-object p0

    return-object p0
.end method

.method public static encrypt3DES2HexString([B[BLjava/lang/String;[B)Ljava/lang/String;
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encrypt3DES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptAES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "AES"

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptAES2Base64([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptAES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Encode([B)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptAES2HexString([B[BLjava/lang/String;[B)Ljava/lang/String;
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptAES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptDES([B[BLjava/lang/String;[B)[B
    .registers 10

    const-string v2, "DES"

    const/4 v5, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lcom/blankj/utilcode/util/EncryptUtils;->symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptDES2Base64([B[BLjava/lang/String;[B)[B
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptDES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Encode([B)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptDES2HexString([B[BLjava/lang/String;[B)Ljava/lang/String;
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptDES([B[BLjava/lang/String;[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacMD5([B[B)[B
    .registers 3

    const-string v0, "HmacMD5"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacMD5ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacMD5ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacMD5ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacMD5([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA1([B[B)[B
    .registers 3

    const-string v0, "HmacSHA1"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA1ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA1ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacSHA1ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA1([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA224([B[B)[B
    .registers 3

    const-string v0, "HmacSHA224"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA224ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA224ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacSHA224ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA224([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA256([B[B)[B
    .registers 3

    const-string v0, "HmacSHA256"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA256ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA256ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacSHA256ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA256([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA384([B[B)[B
    .registers 3

    const-string v0, "HmacSHA384"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA384ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA384ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacSHA384ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA384([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA512([B[B)[B
    .registers 3

    const-string v0, "HmacSHA512"

    invoke-static {p0, p1, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hmacTemplate([B[BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptHmacSHA512ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-eqz p0, :cond_1e

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1e

    if-eqz p1, :cond_1e

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_11

    goto :goto_1e

    :cond_11
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p1

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA512ToString([B[B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1e
    :goto_1e
    const-string p0, ""

    return-object p0
.end method

.method public static encryptHmacSHA512ToString([B[B)Ljava/lang/String;
    .registers 2

    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptHmacSHA512([B[B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD2([B)[B
    .registers 2

    const-string v0, "MD2"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD2ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD2ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptMD2ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD2([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5([B)[B
    .registers 2

    const-string v0, "MD5"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5File(Ljava/io/File;)[B
    .registers 5

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return-object v0

    :cond_4
    :try_start_4
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_9
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_4 .. :try_end_9} :catch_37
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_9} :catch_35
    .catchall {:try_start_4 .. :try_end_9} :catchall_33

    :try_start_9
    const-string p0, "MD5"

    invoke-static {p0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object p0

    new-instance v2, Ljava/security/DigestInputStream;

    invoke-direct {v2, v1, p0}, Ljava/security/DigestInputStream;-><init>(Ljava/io/InputStream;Ljava/security/MessageDigest;)V

    const/high16 p0, 0x40000

    new-array p0, p0, [B

    :cond_18
    invoke-virtual {v2, p0}, Ljava/security/DigestInputStream;->read([B)I

    move-result v3

    if-gtz v3, :cond_18

    invoke-virtual {v2}, Ljava/security/DigestInputStream;->getMessageDigest()Ljava/security/MessageDigest;

    move-result-object p0

    invoke-virtual {p0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0
    :try_end_26
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_9 .. :try_end_26} :catch_31
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_26} :catch_2f
    .catchall {:try_start_9 .. :try_end_26} :catchall_47

    :try_start_26
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V
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
    move-object v1, v0

    :goto_39
    :try_start_39
    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3c
    .catchall {:try_start_39 .. :try_end_3c} :catchall_47

    if-eqz v1, :cond_46

    :try_start_3e
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V
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

    move-object v0, v1

    :goto_49
    if-eqz v0, :cond_53

    :try_start_4b
    invoke-virtual {v0}, Ljava/io/FileInputStream;->close()V
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

.method public static encryptMD5File(Ljava/lang/String;)[B
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
    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5File(Ljava/io/File;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5File2String(Ljava/io/File;)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5File(Ljava/io/File;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5File2String(Ljava/lang/String;)Ljava/lang/String;
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
    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5File2String(Ljava/io/File;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptMD5ToString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-nez p0, :cond_7

    if-nez p1, :cond_7

    const-string p0, ""

    return-object p0

    :cond_7
    if-nez p1, :cond_16

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_16
    if-nez p0, :cond_25

    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_25
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptMD5ToString([B[B)Ljava/lang/String;
    .registers 5

    if-nez p0, :cond_7

    if-nez p1, :cond_7

    const-string p0, ""

    return-object p0

    :cond_7
    if-nez p1, :cond_12

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    if-nez p0, :cond_1d

    invoke-static {p1}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1d
    array-length v0, p0

    array-length v1, p1

    add-int/2addr v0, v1

    new-array v0, v0, [B

    array-length v1, p0

    const/4 v2, 0x0

    invoke-static {p0, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    array-length p0, p0

    array-length v1, p1

    invoke-static {p1, v2, v0, p0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptMD5([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptRSA([B[BILjava/lang/String;)[B
    .registers 5

    const/4 v0, 0x1

    invoke-static {p0, p1, p2, p3, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->rsaTemplate([B[BILjava/lang/String;Z)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptRSA2Base64([B[BILjava/lang/String;)[B
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptRSA([B[BILjava/lang/String;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->base64Encode([B)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptRSA2HexString([B[BILjava/lang/String;)Ljava/lang/String;
    .registers 4

    invoke-static {p0, p1, p2, p3}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptRSA([B[BILjava/lang/String;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA1([B)[B
    .registers 2

    const-string v0, "SHA-1"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA1ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA1ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptSHA1ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA1([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA224([B)[B
    .registers 2

    const-string v0, "SHA224"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA224ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA224ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptSHA224ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA224([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA256([B)[B
    .registers 2

    const-string v0, "SHA-256"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA256ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA256ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptSHA256ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA256([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA384([B)[B
    .registers 2

    const-string v0, "SHA-384"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA384ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA384ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptSHA384ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA384([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA512([B)[B
    .registers 2

    const-string v0, "SHA-512"

    invoke-static {p0, v0}, Lcom/blankj/utilcode/util/EncryptUtils;->hashTemplate([BLjava/lang/String;)[B

    move-result-object p0

    return-object p0
.end method

.method public static encryptSHA512ToString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2

    if-eqz p0, :cond_12

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_9

    goto :goto_12

    :cond_9
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA512ToString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_12
    :goto_12
    const-string p0, ""

    return-object p0
.end method

.method public static encryptSHA512ToString([B)Ljava/lang/String;
    .registers 1

    invoke-static {p0}, Lcom/blankj/utilcode/util/EncryptUtils;->encryptSHA512([B)[B

    move-result-object p0

    invoke-static {p0}, Lcom/blankj/utilcode/util/UtilsBridge;->bytes2HexString([B)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method static hashTemplate([BLjava/lang/String;)[B
    .registers 4

    const/4 v0, 0x0

    if-eqz p0, :cond_17

    array-length v1, p0

    if-gtz v1, :cond_7

    goto :goto_17

    :cond_7
    :try_start_7
    invoke-static {p1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object p1

    invoke-virtual {p1, p0}, Ljava/security/MessageDigest;->update([B)V

    invoke-virtual {p1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0
    :try_end_12
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_7 .. :try_end_12} :catch_13

    return-object p0

    :catch_13
    move-exception p0

    invoke-virtual {p0}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    :cond_17
    :goto_17
    return-object v0
.end method

.method private static hmacTemplate([B[BLjava/lang/String;)[B
    .registers 5

    const/4 v0, 0x0

    if-eqz p0, :cond_23

    array-length v1, p0

    if-eqz v1, :cond_23

    if-eqz p1, :cond_23

    array-length v1, p1

    if-nez v1, :cond_c

    goto :goto_23

    :cond_c
    :try_start_c
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    invoke-direct {v1, p1, p2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    invoke-static {p2}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object p1

    invoke-virtual {p1, v1}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    invoke-virtual {p1, p0}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object p0
    :try_end_1c
    .catch Ljava/security/InvalidKeyException; {:try_start_c .. :try_end_1c} :catch_1f
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_c .. :try_end_1c} :catch_1d

    return-object p0

    :catch_1d
    move-exception p0

    goto :goto_20

    :catch_1f
    move-exception p0

    :goto_20
    invoke-virtual {p0}, Ljava/security/GeneralSecurityException;->printStackTrace()V

    :cond_23
    :goto_23
    return-object v0
.end method

.method private static joins([B[B)[B
    .registers 5

    array-length v0, p0

    array-length v1, p1

    add-int/2addr v0, v1

    new-array v0, v0, [B

    array-length v1, p0

    const/4 v2, 0x0

    invoke-static {p0, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    array-length p0, p0

    array-length v1, p1

    invoke-static {p1, v2, v0, p0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v0
.end method

.method public static rc4([B[B)[B
    .registers 10

    if-eqz p0, :cond_69

    array-length v0, p0

    if-eqz v0, :cond_69

    if-nez p1, :cond_8

    goto :goto_69

    :cond_8
    array-length v0, p1

    const/4 v1, 0x1

    if-lt v0, v1, :cond_61

    array-length v0, p1

    const/16 v2, 0x100

    if-gt v0, v2, :cond_61

    new-array v0, v2, [B

    new-array v3, v2, [B

    array-length v4, p1

    const/4 v5, 0x0

    move v6, v5

    :goto_18
    if-ge v6, v2, :cond_26

    int-to-byte v7, v6

    aput-byte v7, v0, v6

    rem-int v7, v6, v4

    aget-byte v7, p1, v7

    aput-byte v7, v3, v6

    add-int/lit8 v6, v6, 0x1

    goto :goto_18

    :cond_26
    move p1, v5

    move v4, p1

    :goto_28
    if-ge p1, v2, :cond_3b

    aget-byte v6, v0, p1

    add-int/2addr v4, v6

    aget-byte v7, v3, p1

    add-int/2addr v4, v7

    and-int/lit16 v4, v4, 0xff

    aget-byte v7, v0, v4

    aput-byte v6, v0, v4

    aput-byte v7, v0, p1

    add-int/lit8 p1, p1, 0x1

    goto :goto_28

    :cond_3b
    array-length p1, p0

    new-array p1, p1, [B

    move v2, v5

    :goto_3f
    array-length v3, p0

    if-ge v5, v3, :cond_60

    add-int/2addr v2, v1

    and-int/lit16 v2, v2, 0xff

    aget-byte v3, v0, v2

    add-int/2addr v4, v3

    and-int/lit16 v4, v4, 0xff

    aget-byte v6, v0, v4

    aput-byte v3, v0, v4

    aput-byte v6, v0, v2

    aget-byte v3, v0, v4

    add-int/2addr v6, v3

    and-int/lit16 v3, v6, 0xff

    aget-byte v3, v0, v3

    aget-byte v6, p0, v5

    xor-int/2addr v3, v6

    int-to-byte v3, v3

    aput-byte v3, p1, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_3f

    :cond_60
    return-object p1

    :cond_61
    new-instance p0, Ljava/lang/IllegalArgumentException;

    const-string p1, "key must be between 1 and 256 bytes"

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_69
    :goto_69
    const/4 p0, 0x0

    return-object p0
.end method

.method private static rsaTemplate([B[BILjava/lang/String;Z)[B
    .registers 12

    const/4 v0, 0x0

    if-eqz p0, :cond_8d

    array-length v1, p0

    if-eqz v1, :cond_8d

    if-eqz p1, :cond_8d

    array-length v1, p1

    if-nez v1, :cond_d

    goto/16 :goto_8d

    :cond_d
    :try_start_d
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_f} :catch_89

    const/16 v2, 0x1c

    const-string v3, "RSA"

    if-ge v1, v2, :cond_1c

    :try_start_15
    const-string v1, "BC"

    invoke-static {v3, v1}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v1

    goto :goto_20

    :cond_1c
    invoke-static {v3}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v1

    :goto_20
    if-eqz p4, :cond_2c

    new-instance v2, Ljava/security/spec/X509EncodedKeySpec;

    invoke-direct {v2, p1}, Ljava/security/spec/X509EncodedKeySpec;-><init>([B)V

    invoke-virtual {v1, v2}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object p1

    goto :goto_35

    :cond_2c
    new-instance v2, Ljava/security/spec/PKCS8EncodedKeySpec;

    invoke-direct {v2, p1}, Ljava/security/spec/PKCS8EncodedKeySpec;-><init>([B)V

    invoke-virtual {v1, v2}, Ljava/security/KeyFactory;->generatePrivate(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;

    move-result-object p1

    :goto_35
    if-nez p1, :cond_38

    return-object v0

    :cond_38
    invoke-static {p3}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    if-eqz p4, :cond_40

    const/4 v2, 0x1

    goto :goto_41

    :cond_40
    const/4 v2, 0x2

    :goto_41
    invoke-virtual {v1, v2, p1}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    array-length p1, p0

    div-int/lit8 p2, p2, 0x8

    if-eqz p4, :cond_57

    invoke-virtual {p3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p3

    const-string p4, "pkcs1padding"

    invoke-virtual {p3, p4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result p3

    if-eqz p3, :cond_57

    add-int/lit8 p2, p2, -0xb

    :cond_57
    div-int p3, p1, p2

    if-lez p3, :cond_84

    const/4 p4, 0x0

    new-array v2, p4, [B

    new-array v3, p2, [B

    move v4, p4

    move v5, v4

    :goto_62
    if-ge v4, p3, :cond_73

    invoke-static {p0, v5, v3, p4, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-virtual {v1, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v6

    invoke-static {v2, v6}, Lcom/blankj/utilcode/util/EncryptUtils;->joins([B[B)[B

    move-result-object v2

    add-int/2addr v5, p2

    add-int/lit8 v4, v4, 0x1

    goto :goto_62

    :cond_73
    if-eq v5, p1, :cond_83

    sub-int/2addr p1, v5

    new-array p2, p1, [B

    invoke-static {p0, v5, p2, p4, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-virtual {v1, p2}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object p0

    invoke-static {v2, p0}, Lcom/blankj/utilcode/util/EncryptUtils;->joins([B[B)[B

    move-result-object v2

    :cond_83
    return-object v2

    :cond_84
    invoke-virtual {v1, p0}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object p0
    :try_end_88
    .catch Ljava/lang/Exception; {:try_start_15 .. :try_end_88} :catch_89

    return-object p0

    :catch_89
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_8d
    :goto_8d
    return-object v0
.end method

.method private static symmetricTemplate([B[BLjava/lang/String;Ljava/lang/String;[BZ)[B
    .registers 9

    const/4 v0, 0x0

    if-eqz p0, :cond_51

    array-length v1, p0

    if-eqz v1, :cond_51

    if-eqz p1, :cond_51

    array-length v1, p1

    if-nez v1, :cond_c

    goto :goto_51

    :cond_c
    :try_start_c
    const-string v1, "DES"

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    new-instance v1, Ljavax/crypto/spec/DESKeySpec;

    invoke-direct {v1, p1}, Ljavax/crypto/spec/DESKeySpec;-><init>([B)V

    invoke-static {p2}, Ljavax/crypto/SecretKeyFactory;->getInstance(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;

    move-result-object p1

    invoke-virtual {p1, v1}, Ljavax/crypto/SecretKeyFactory;->generateSecret(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;

    move-result-object p1

    goto :goto_28

    :cond_22
    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    invoke-direct {v1, p1, p2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    move-object p1, v1

    :goto_28
    invoke-static {p3}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object p2

    const/4 p3, 0x1

    const/4 v1, 0x2

    if-eqz p4, :cond_41

    array-length v2, p4

    if-nez v2, :cond_34

    goto :goto_41

    :cond_34
    new-instance v2, Ljavax/crypto/spec/IvParameterSpec;

    invoke-direct {v2, p4}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    if-eqz p5, :cond_3c

    goto :goto_3d

    :cond_3c
    move p3, v1

    :goto_3d
    invoke-virtual {p2, p3, p1, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    goto :goto_48

    :cond_41
    :goto_41
    if-eqz p5, :cond_44

    goto :goto_45

    :cond_44
    move p3, v1

    :goto_45
    invoke-virtual {p2, p3, p1}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    :goto_48
    invoke-virtual {p2, p0}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object p0
    :try_end_4c
    .catchall {:try_start_c .. :try_end_4c} :catchall_4d

    return-object p0

    :catchall_4d
    move-exception p0

    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_51
    :goto_51
    return-object v0
.end method
