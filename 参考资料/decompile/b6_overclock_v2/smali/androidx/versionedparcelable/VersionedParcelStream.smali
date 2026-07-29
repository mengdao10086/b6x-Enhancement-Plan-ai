.class Landroidx/versionedparcelable/VersionedParcelStream;
.super Landroidx/versionedparcelable/VersionedParcel;
.source "VersionedParcelStream.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;
    }
.end annotation


# static fields
.field private static final TYPE_BOOLEAN:I = 0x5

.field private static final TYPE_BOOLEAN_ARRAY:I = 0x6

.field private static final TYPE_DOUBLE:I = 0x7

.field private static final TYPE_DOUBLE_ARRAY:I = 0x8

.field private static final TYPE_FLOAT:I = 0xd

.field private static final TYPE_FLOAT_ARRAY:I = 0xe

.field private static final TYPE_INT:I = 0x9

.field private static final TYPE_INT_ARRAY:I = 0xa

.field private static final TYPE_LONG:I = 0xb

.field private static final TYPE_LONG_ARRAY:I = 0xc

.field private static final TYPE_NULL:I = 0x0

.field private static final TYPE_STRING:I = 0x3

.field private static final TYPE_STRING_ARRAY:I = 0x4

.field private static final TYPE_SUB_BUNDLE:I = 0x1

.field private static final TYPE_SUB_PERSISTABLE_BUNDLE:I = 0x2

.field private static final UTF_16:Ljava/nio/charset/Charset;


# instance fields
.field mCount:I

.field private mCurrentInput:Ljava/io/DataInputStream;

.field private mCurrentOutput:Ljava/io/DataOutputStream;

.field private mFieldBuffer:Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

.field private mFieldId:I

.field mFieldSize:I

.field private mIgnoreParcelables:Z

.field private final mMasterInput:Ljava/io/DataInputStream;

.field private final mMasterOutput:Ljava/io/DataOutputStream;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    const-string v0, "UTF-16"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Landroidx/versionedparcelable/VersionedParcelStream;->UTF_16:Ljava/nio/charset/Charset;

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 9

    new-instance v3, Landroidx/collection/ArrayMap;

    invoke-direct {v3}, Landroidx/collection/ArrayMap;-><init>()V

    new-instance v4, Landroidx/collection/ArrayMap;

    invoke-direct {v4}, Landroidx/collection/ArrayMap;-><init>()V

    new-instance v5, Landroidx/collection/ArrayMap;

    invoke-direct {v5}, Landroidx/collection/ArrayMap;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Landroidx/versionedparcelable/VersionedParcelStream;-><init>(Ljava/io/InputStream;Ljava/io/OutputStream;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V

    return-void
.end method

.method private constructor <init>(Ljava/io/InputStream;Ljava/io/OutputStream;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            "Ljava/io/OutputStream;",
            "Landroidx/collection/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/reflect/Method;",
            ">;",
            "Landroidx/collection/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/reflect/Method;",
            ">;",
            "Landroidx/collection/ArrayMap<",
            "Ljava/lang/String;",
            "Ljava/lang/Class;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p3, p4, p5}, Landroidx/versionedparcelable/VersionedParcel;-><init>(Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V

    const/4 p3, 0x0

    iput p3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCount:I

    const/4 p3, -0x1

    iput p3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldId:I

    iput p3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldSize:I

    const/4 p3, 0x0

    if-eqz p1, :cond_19

    new-instance p4, Ljava/io/DataInputStream;

    new-instance p5, Landroidx/versionedparcelable/VersionedParcelStream$1;

    invoke-direct {p5, p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream$1;-><init>(Landroidx/versionedparcelable/VersionedParcelStream;Ljava/io/InputStream;)V

    invoke-direct {p4, p5}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    goto :goto_1a

    :cond_19
    move-object p4, p3

    :goto_1a
    iput-object p4, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterInput:Ljava/io/DataInputStream;

    if-eqz p2, :cond_23

    new-instance p3, Ljava/io/DataOutputStream;

    invoke-direct {p3, p2}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    :cond_23
    iput-object p3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterOutput:Ljava/io/DataOutputStream;

    iput-object p4, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    iput-object p3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    return-void
.end method

.method private readObject(ILjava/lang/String;Landroid/os/Bundle;)V
    .registers 6

    packed-switch p1, :pswitch_data_94

    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Ljava/lang/StringBuilder;

    const-string v0, "Unknown type "

    invoke-direct {p3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p2

    :pswitch_18
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readFloatArray()[F

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putFloatArray(Ljava/lang/String;[F)V

    goto/16 :goto_93

    :pswitch_21
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readFloat()F

    move-result p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    goto/16 :goto_93

    :pswitch_2a
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readLongArray()[J

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putLongArray(Ljava/lang/String;[J)V

    goto :goto_93

    :pswitch_32
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readLong()J

    move-result-wide v0

    invoke-virtual {p3, p2, v0, v1}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    goto :goto_93

    :pswitch_3a
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readIntArray()[I

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    goto :goto_93

    :pswitch_42
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readInt()I

    move-result p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_93

    :pswitch_4a
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readDoubleArray()[D

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putDoubleArray(Ljava/lang/String;[D)V

    goto :goto_93

    :pswitch_52
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readDouble()D

    move-result-wide v0

    invoke-virtual {p3, p2, v0, v1}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    goto :goto_93

    :pswitch_5a
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readBooleanArray()[Z

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putBooleanArray(Ljava/lang/String;[Z)V

    goto :goto_93

    :pswitch_62
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readBoolean()Z

    move-result p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_93

    :pswitch_6a
    const/4 p1, 0x0

    new-array p1, p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->readArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_93

    :pswitch_77
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_93

    :pswitch_7f
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readBundle()Landroid/os/Bundle;

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_93

    :pswitch_87
    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readBundle()Landroid/os/Bundle;

    move-result-object p1

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_93

    :pswitch_8f
    const/4 p1, 0x0

    invoke-virtual {p3, p2, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    :goto_93
    return-void

    :pswitch_data_94
    .packed-switch 0x0
        :pswitch_8f
        :pswitch_87
        :pswitch_7f
        :pswitch_77
        :pswitch_6a
        :pswitch_62
        :pswitch_5a
        :pswitch_52
        :pswitch_4a
        :pswitch_42
        :pswitch_3a
        :pswitch_32
        :pswitch_2a
        :pswitch_21
        :pswitch_18
    .end packed-switch
.end method

.method private writeObject(Ljava/lang/Object;)V
    .registers 5

    if-nez p1, :cond_8

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    goto/16 :goto_ea

    :cond_8
    instance-of v0, p1, Landroid/os/Bundle;

    if-eqz v0, :cond_17

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Landroid/os/Bundle;

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeBundle(Landroid/os/Bundle;)V

    goto/16 :goto_ea

    :cond_17
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_26

    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeString(Ljava/lang/String;)V

    goto/16 :goto_ea

    :cond_26
    instance-of v0, p1, [Ljava/lang/String;

    if-eqz v0, :cond_37

    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [Ljava/lang/String;

    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeArray([Ljava/lang/Object;)V

    goto/16 :goto_ea

    :cond_37
    instance-of v0, p1, Ljava/lang/Boolean;

    if-eqz v0, :cond_4a

    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeBoolean(Z)V

    goto/16 :goto_ea

    :cond_4a
    instance-of v0, p1, [Z

    if-eqz v0, :cond_5b

    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [Z

    check-cast p1, [Z

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeBooleanArray([Z)V

    goto/16 :goto_ea

    :cond_5b
    instance-of v0, p1, Ljava/lang/Double;

    if-eqz v0, :cond_6e

    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/Double;

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeDouble(D)V

    goto/16 :goto_ea

    :cond_6e
    instance-of v0, p1, [D

    if-eqz v0, :cond_7f

    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [D

    check-cast p1, [D

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeDoubleArray([D)V

    goto :goto_ea

    :cond_7f
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_92

    const/16 v0, 0x9

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    goto :goto_ea

    :cond_92
    instance-of v0, p1, [I

    if-eqz v0, :cond_a3

    const/16 v0, 0xa

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [I

    check-cast p1, [I

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeIntArray([I)V

    goto :goto_ea

    :cond_a3
    instance-of v0, p1, Ljava/lang/Long;

    if-eqz v0, :cond_b6

    const/16 v0, 0xb

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/Long;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeLong(J)V

    goto :goto_ea

    :cond_b6
    instance-of v0, p1, [J

    if-eqz v0, :cond_c7

    const/16 v0, 0xc

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [J

    check-cast p1, [J

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeLongArray([J)V

    goto :goto_ea

    :cond_c7
    instance-of v0, p1, Ljava/lang/Float;

    if-eqz v0, :cond_da

    const/16 v0, 0xd

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result p1

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeFloat(F)V

    goto :goto_ea

    :cond_da
    instance-of v0, p1, [F

    if-eqz v0, :cond_eb

    const/16 v0, 0xe

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/VersionedParcelStream;->writeInt(I)V

    check-cast p1, [F

    check-cast p1, [F

    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeFloatArray([F)V

    :goto_ea
    return-void

    :cond_eb
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unsupported type "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public closeField()V
    .registers 3

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldBuffer:Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

    if-eqz v0, :cond_1c

    :try_start_4
    iget-object v0, v0, Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;->mOutput:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldBuffer:Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

    invoke-virtual {v0}, Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;->flushField()V
    :try_end_11
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_11} :catch_15

    :cond_11
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldBuffer:Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

    goto :goto_1c

    :catch_15
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_1c
    :goto_1c
    return-void
.end method

.method protected createSubParcel()Landroidx/versionedparcelable/VersionedParcel;
    .registers 8

    new-instance v6, Landroidx/versionedparcelable/VersionedParcelStream;

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    iget-object v2, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    iget-object v3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mReadCache:Landroidx/collection/ArrayMap;

    iget-object v4, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mWriteCache:Landroidx/collection/ArrayMap;

    iget-object v5, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mParcelizerCache:Landroidx/collection/ArrayMap;

    move-object v0, v6

    invoke-direct/range {v0 .. v5}, Landroidx/versionedparcelable/VersionedParcelStream;-><init>(Ljava/io/InputStream;Ljava/io/OutputStream;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;Landroidx/collection/ArrayMap;)V

    return-object v6
.end method

.method public isStream()Z
    .registers 2

    const/4 v0, 0x1

    return v0
.end method

.method public readBoolean()Z
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v0
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readBundle()Landroid/os/Bundle;
    .registers 6

    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readInt()I

    move-result v0

    if-gez v0, :cond_8

    const/4 v0, 0x0

    return-object v0

    :cond_8
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    const/4 v2, 0x0

    :goto_e
    if-ge v2, v0, :cond_1e

    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->readInt()I

    move-result v4

    invoke-direct {p0, v4, v3, v1}, Landroidx/versionedparcelable/VersionedParcelStream;->readObject(ILjava/lang/String;Landroid/os/Bundle;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_e

    :cond_1e
    return-object v1
.end method

.method public readByteArray()[B
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    if-lez v0, :cond_10

    new-array v0, v0, [B

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v1, v0}, Ljava/io/DataInputStream;->readFully([B)V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_f} :catch_12

    return-object v0

    :cond_10
    const/4 v0, 0x0

    return-object v0

    :catch_12
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected readCharSequence()Ljava/lang/CharSequence;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public readDouble()D
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readDouble()D

    move-result-wide v0
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_7

    return-wide v0

    :catch_7
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readField(I)Z
    .registers 6

    :goto_0
    const/4 v0, 0x0

    :try_start_1
    iget v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldId:I

    if-ne v1, p1, :cond_7

    const/4 p1, 0x1

    return p1

    :cond_7
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-lez v1, :cond_16

    return v0

    :cond_16
    iget v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCount:I

    iget v2, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldSize:I

    if-ge v1, v2, :cond_23

    iget-object v3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterInput:Ljava/io/DataInputStream;

    sub-int/2addr v2, v1

    int-to-long v1, v2

    invoke-virtual {v3, v1, v2}, Ljava/io/DataInputStream;->skip(J)J

    :cond_23
    const/4 v1, -0x1

    iput v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldSize:I

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterInput:Ljava/io/DataInputStream;

    invoke-virtual {v1}, Ljava/io/DataInputStream;->readInt()I

    move-result v1

    iput v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCount:I

    const v2, 0xffff

    and-int v3, v1, v2

    if-ne v3, v2, :cond_3b

    iget-object v3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterInput:Ljava/io/DataInputStream;

    invoke-virtual {v3}, Ljava/io/DataInputStream;->readInt()I

    move-result v3

    :cond_3b
    shr-int/lit8 v1, v1, 0x10

    and-int/2addr v1, v2

    iput v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldId:I

    iput v3, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldSize:I
    :try_end_42
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_42} :catch_43

    goto :goto_0

    :catch_43
    return v0
.end method

.method public readFloat()F
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readFloat()F

    move-result v0
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readInt()I
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_7

    return v0

    :catch_7
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readLong()J
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v0
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_7

    return-wide v0

    :catch_7
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readParcelable()Landroid/os/Parcelable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">()TT;"
        }
    .end annotation

    const/4 v0, 0x0

    return-object v0
.end method

.method public readString()Ljava/lang/String;
    .registers 4

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    if-lez v0, :cond_17

    new-array v0, v0, [B

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentInput:Ljava/io/DataInputStream;

    invoke-virtual {v1, v0}, Ljava/io/DataInputStream;->readFully([B)V

    new-instance v1, Ljava/lang/String;

    sget-object v2, Landroidx/versionedparcelable/VersionedParcelStream;->UTF_16:Ljava/nio/charset/Charset;

    invoke-direct {v1, v0, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V
    :try_end_16
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_16} :catch_19

    return-object v1

    :cond_17
    const/4 v0, 0x0

    return-object v0

    :catch_19
    move-exception v0

    new-instance v1, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v1, v0}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public readStrongBinder()Landroid/os/IBinder;
    .registers 2

    const/4 v0, 0x0

    return-object v0
.end method

.method public setOutputField(I)V
    .registers 4

    invoke-virtual {p0}, Landroidx/versionedparcelable/VersionedParcelStream;->closeField()V

    new-instance v0, Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mMasterOutput:Ljava/io/DataOutputStream;

    invoke-direct {v0, p1, v1}, Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;-><init>(ILjava/io/DataOutputStream;)V

    iput-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mFieldBuffer:Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;

    iget-object p1, v0, Landroidx/versionedparcelable/VersionedParcelStream$FieldBuffer;->mDataStream:Ljava/io/DataOutputStream;

    iput-object p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    return-void
.end method

.method public setSerializationFlags(ZZ)V
    .registers 3

    if-eqz p1, :cond_5

    iput-boolean p2, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mIgnoreParcelables:Z

    return-void

    :cond_5
    new-instance p1, Ljava/lang/RuntimeException;

    const-string p2, "Serialization of this object is not allowed"

    invoke-direct {p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public writeBoolean(Z)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeBoolean(Z)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeBundle(Landroid/os/Bundle;)V
    .registers 5

    if-eqz p1, :cond_2a

    :try_start_2
    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    iget-object v1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/io/DataOutputStream;->writeInt(I)V

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_13
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_30

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p0, v1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeString(Ljava/lang/String;)V

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-direct {p0, v1}, Landroidx/versionedparcelable/VersionedParcelStream;->writeObject(Ljava/lang/Object;)V

    goto :goto_13

    :cond_2a
    iget-object p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    const/4 v0, -0x1

    invoke-virtual {p1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_30
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_30} :catch_31

    :cond_30
    return-void

    :catch_31
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeByteArray([B)V
    .registers 4

    if-eqz p1, :cond_e

    :try_start_2
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->write([B)V

    goto :goto_14

    :cond_e
    iget-object p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    const/4 v0, -0x1

    invoke-virtual {p1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_14} :catch_15

    :goto_14
    return-void

    :catch_15
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeByteArray([BII)V
    .registers 5

    if-eqz p1, :cond_d

    :try_start_2
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p3}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/DataOutputStream;->write([BII)V

    goto :goto_13

    :cond_d
    iget-object p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    const/4 p2, -0x1

    invoke-virtual {p1, p2}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_13} :catch_14

    :goto_13
    return-void

    :catch_14
    move-exception p1

    new-instance p2, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {p2, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method

.method protected writeCharSequence(Ljava/lang/CharSequence;)V
    .registers 3

    iget-boolean p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mIgnoreParcelables:Z

    if-eqz p1, :cond_5

    return-void

    :cond_5
    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "CharSequence cannot be written to an OutputStream"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public writeDouble(D)V
    .registers 4

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1, p2}, Ljava/io/DataOutputStream;->writeDouble(D)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance p2, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {p2, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method

.method public writeFloat(F)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeFloat(F)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeInt(I)V
    .registers 3

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeLong(J)V
    .registers 4

    :try_start_0
    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1, p2}, Ljava/io/DataOutputStream;->writeLong(J)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_5} :catch_6

    return-void

    :catch_6
    move-exception p1

    new-instance p2, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {p2, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw p2
.end method

.method public writeParcelable(Landroid/os/Parcelable;)V
    .registers 3

    iget-boolean p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mIgnoreParcelables:Z

    if-eqz p1, :cond_5

    return-void

    :cond_5
    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Parcelables cannot be written to an OutputStream"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public writeString(Ljava/lang/String;)V
    .registers 4

    if-eqz p1, :cond_14

    :try_start_2
    sget-object v0, Landroidx/versionedparcelable/VersionedParcelStream;->UTF_16:Ljava/nio/charset/Charset;

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    array-length v1, p1

    invoke-virtual {v0, v1}, Ljava/io/DataOutputStream;->writeInt(I)V

    iget-object v0, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/DataOutputStream;->write([B)V

    goto :goto_1a

    :cond_14
    iget-object p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mCurrentOutput:Ljava/io/DataOutputStream;

    const/4 v0, -0x1

    invoke-virtual {p1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_1a} :catch_1b

    :goto_1a
    return-void

    :catch_1b
    move-exception p1

    new-instance v0, Landroidx/versionedparcelable/VersionedParcel$ParcelException;

    invoke-direct {v0, p1}, Landroidx/versionedparcelable/VersionedParcel$ParcelException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method

.method public writeStrongBinder(Landroid/os/IBinder;)V
    .registers 3

    iget-boolean p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mIgnoreParcelables:Z

    if-eqz p1, :cond_5

    return-void

    :cond_5
    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Binders cannot be written to an OutputStream"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public writeStrongInterface(Landroid/os/IInterface;)V
    .registers 3

    iget-boolean p1, p0, Landroidx/versionedparcelable/VersionedParcelStream;->mIgnoreParcelables:Z

    if-eqz p1, :cond_5

    return-void

    :cond_5
    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Binders cannot be written to an OutputStream"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
