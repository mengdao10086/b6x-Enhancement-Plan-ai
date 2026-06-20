.class public final Lcom/flydigi/sdk/waspwing/WaspWingInfo;
.super Ljava/lang/Object;
.source "WaspWingInfo.kt"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008k\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B\u00ab\u0002\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0008\u0002\u0010\"\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010$J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010k\u001a\u00020\u000bH\u00c6\u0003J\t\u0010l\u001a\u00020\u000bH\u00c6\u0003J\t\u0010m\u001a\u00020\u000bH\u00c6\u0003J\t\u0010n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010o\u001a\u00020\u000bH\u00c6\u0003J\t\u0010p\u001a\u00020\u000bH\u00c6\u0003J\t\u0010q\u001a\u00020\u000bH\u00c6\u0003J\t\u0010r\u001a\u00020\u000bH\u00c6\u0003J\t\u0010s\u001a\u00020\u000bH\u00c6\u0003J\t\u0010t\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\u0019H\u00c6\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\t\u0010x\u001a\u00020\u0006H\u00c6\u0003J\t\u0010y\u001a\u00020\u0006H\u00c6\u0003J\t\u0010z\u001a\u00020\u001fH\u00c6\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010:J\u0010\u0010|\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010:J\t\u0010}\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010:J\t\u0010\u007f\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\u000c\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000bH\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000bH\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u000bH\u00c6\u0003J\u00b6\u0002\u0010\u0086\u0001\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\u0008\u0008\u0002\u0010\"\u001a\u00020\u00062\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0003\u0010\u0087\u0001J\n\u0010\u0088\u0001\u001a\u00020\u000bH\u00d6\u0001J\u0016\u0010\u0089\u0001\u001a\u00020\u00062\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u00d6\u0003J\u0007\u0010\u008c\u0001\u001a\u00020\u0003J\u0010\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u008e\u0001\u001a\u00020\u000bJ\u0007\u0010\u008f\u0001\u001a\u00020\u0003J\u0007\u0010\u0090\u0001\u001a\u00020\u000bJ\u0007\u0010\u0091\u0001\u001a\u00020\u000bJ\u0008\u0010\u0092\u0001\u001a\u00030\u0093\u0001J\n\u0010\u0094\u0001\u001a\u00020\u000bH\u00d6\u0001J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00d6\u0001J\u001e\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u000bH\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008\'\u0010(R\u001a\u0010\u000c\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010*\"\u0004\u0008.\u0010,R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010*\"\u0004\u00084\u0010,R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00085\u0010&\"\u0004\u00086\u0010(R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u00087\u0010&\"\u0004\u00088\u0010(R\u001e\u0010#\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010=\u001a\u0004\u00089\u0010:\"\u0004\u0008;\u0010<R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010&\"\u0004\u0008?\u0010(R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008@\u00100\"\u0004\u0008A\u00102R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER\u001e\u0010 \u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010=\u001a\u0004\u0008F\u0010:\"\u0004\u0008G\u0010<R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u00100\"\u0004\u0008H\u00102R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u00100\"\u0004\u0008I\u00102R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008J\u0010K\"\u0004\u0008L\u0010MR\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010*\"\u0004\u0008O\u0010,R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008P\u00100\"\u0004\u0008Q\u00102R\u001e\u0010!\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010=\u001a\u0004\u0008R\u0010:\"\u0004\u0008S\u0010<R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008T\u00100\"\u0004\u0008U\u00102R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008V\u0010*\"\u0004\u0008W\u0010,R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008X\u0010*\"\u0004\u0008Y\u0010,R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010*\"\u0004\u0008[\u0010,R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\\\u0010]\"\u0004\u0008^\u0010_R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008`\u0010*\"\u0004\u0008a\u0010,R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008b\u0010*\"\u0004\u0008c\u0010,R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008d\u0010*\"\u0004\u0008e\u0010,R\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008f\u0010*\"\u0004\u0008g\u0010,R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008h\u0010*\"\u0004\u0008i\u0010,\u00a8\u0006\u009c\u0001"
    }
    d2 = {
        "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "Landroid/os/Parcelable;",
        "deviceName",
        "",
        "address",
        "isConnected",
        "",
        "deviceCode",
        "firmwareVersion",
        "lightState",
        "windLevel",
        "",
        "coldLevel",
        "temperature",
        "temperatureDecimal",
        "runMode",
        "targetTemperature",
        "overClockUsable",
        "windLevelOverclock",
        "coldLevelOverclock",
        "speed",
        "windRunLevel",
        "coldRunLevel",
        "ledType",
        "hotSurfaceTemperature",
        "",
        "ledData",
        "Lcom/flydigi/sdk/waspwing/LedData;",
        "coldProtection",
        "hotProtectionEnabled",
        "tempHistories",
        "",
        "ipType",
        "modeCustom",
        "isExperimentalRunModeOn",
        "experimentalRunModeValue",
        "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)V",
        "getAddress",
        "()Ljava/lang/String;",
        "setAddress",
        "(Ljava/lang/String;)V",
        "getColdLevel",
        "()I",
        "setColdLevel",
        "(I)V",
        "getColdLevelOverclock",
        "setColdLevelOverclock",
        "getColdProtection",
        "()Z",
        "setColdProtection",
        "(Z)V",
        "getColdRunLevel",
        "setColdRunLevel",
        "getDeviceCode",
        "setDeviceCode",
        "getDeviceName",
        "setDeviceName",
        "getExperimentalRunModeValue",
        "()Ljava/lang/Integer;",
        "setExperimentalRunModeValue",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "getFirmwareVersion",
        "setFirmwareVersion",
        "getHotProtectionEnabled",
        "setHotProtectionEnabled",
        "getHotSurfaceTemperature",
        "()B",
        "setHotSurfaceTemperature",
        "(B)V",
        "getIpType",
        "setIpType",
        "setConnected",
        "setExperimentalRunModeOn",
        "getLedData",
        "()Lcom/flydigi/sdk/waspwing/LedData;",
        "setLedData",
        "(Lcom/flydigi/sdk/waspwing/LedData;)V",
        "getLedType",
        "setLedType",
        "getLightState",
        "setLightState",
        "getModeCustom",
        "setModeCustom",
        "getOverClockUsable",
        "setOverClockUsable",
        "getRunMode",
        "setRunMode",
        "getSpeed",
        "setSpeed",
        "getTargetTemperature",
        "setTargetTemperature",
        "getTempHistories",
        "()[B",
        "setTempHistories",
        "([B)V",
        "getTemperature",
        "setTemperature",
        "getTemperatureDecimal",
        "setTemperatureDecimal",
        "getWindLevel",
        "setWindLevel",
        "getWindLevelOverclock",
        "setWindLevelOverclock",
        "getWindRunLevel",
        "setWindRunLevel",
        "component1",
        "component10",
        "component11",
        "component12",
        "component13",
        "component14",
        "component15",
        "component16",
        "component17",
        "component18",
        "component19",
        "component2",
        "component20",
        "component21",
        "component22",
        "component23",
        "component24",
        "component25",
        "component26",
        "component27",
        "component28",
        "component3",
        "component4",
        "component5",
        "component6",
        "component7",
        "component8",
        "component9",
        "copy",
        "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
        "describeContents",
        "equals",
        "other",
        "",
        "getReadableCold",
        "getReadableLevel",
        "pwm",
        "getReadableWind",
        "getRealColdLevel",
        "getRealWindLevel",
        "getRunModeSmartLevel",
        "",
        "hashCode",
        "toString",
        "writeToParcel",
        "",
        "parcel",
        "Landroid/os/Parcel;",
        "flags",
        "Companion",
        "sdk_waspwing_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lcom/flydigi/sdk/waspwing/WaspWingInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static final Companion:Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;

.field public static final DEFAULT_COLD_LEVEL:I = 0x73

.field public static final DEFAULT_COLD_LEVEL_OVERCLOCK_MAX:I = 0x86

.field public static final DEFAULT_COLD_LEVEL_OVERCLOCK_MIDDLE:I = 0x99

.field public static final DEFAULT_COLD_LEVEL_OVERCLOCK_MIN:I = 0xad

.field public static final DEFAULT_WIND_LEVEL_MAX:I = 0x4d

.field public static final DEFAULT_WIND_LEVEL_MIDDLE:I = 0x5f

.field public static final DEFAULT_WIND_LEVEL_MIN:I = 0x73

.field public static final DEFAULT_WIND_LEVEL_OVERCLOCK_MAX:I = 0x4d

.field public static final DEFAULT_WIND_LEVEL_OVERCLOCK_MIDDLE:I = 0x5f

.field public static final DEFAULT_WIND_LEVEL_OVERCLOCK_MIN:I = 0x86

.field public static final EXPERIMENTAL_RUN_MODE_COLD_LEVEL:I = 0xe6

.field public static final EXPERIMENTAL_RUN_MODE_WIND_LEVEL:I = 0x1644

.field public static final LED_OFF:I = 0x0

.field public static final LED_ON:I = 0x1

.field public static final SPEED_MAX:I = 0xff

.field public static final SPEED_MAX_B5:I = 0x73

.field public static final SPEED_MIN_B3:I = 0x78

.field public static final SPEED_MIN_B5:I = 0x39

.field public static final TEMPERATURE_MIDDLE:I = 0x12

.field public static final TEMPERATURE_MIN:I = 0x10

.field public static final WIND_LEVEL_MAX:I = 0x157c

.field public static final WIND_LEVEL_MIN:I = 0xfa0


# instance fields
.field private address:Ljava/lang/String;

.field private coldLevel:I

.field private coldLevelOverclock:I

.field private coldProtection:Z

.field private coldRunLevel:I

.field private deviceCode:Ljava/lang/String;

.field private deviceName:Ljava/lang/String;

.field private experimentalRunModeValue:Ljava/lang/Integer;

.field private firmwareVersion:Ljava/lang/String;

.field private hotProtectionEnabled:Z

.field private hotSurfaceTemperature:B

.field private ipType:Ljava/lang/Integer;

.field private isConnected:Z

.field private isExperimentalRunModeOn:Z

.field private ledData:Lcom/flydigi/sdk/waspwing/LedData;

.field private ledType:I

.field private lightState:Z

.field private modeCustom:Ljava/lang/Integer;

.field private overClockUsable:Z

.field private runMode:I

.field private speed:I

.field private targetTemperature:I

.field private tempHistories:[B

.field private temperature:I

.field private temperatureDecimal:I

.field private windLevel:I

.field private windLevelOverclock:I

.field private windRunLevel:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    new-instance v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->Companion:Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;

    new-instance v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Creator;

    invoke-direct {v0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Creator;-><init>()V

    check-cast v0, Landroid/os/Parcelable$Creator;

    sput-object v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 32

    move-object/from16 v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    const/16 v25, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    const/16 v28, 0x0

    const v29, 0xfffffff

    const/16 v30, 0x0

    invoke-direct/range {v0 .. v30}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)V
    .registers 33

    move-object v0, p0

    move-object v1, p4

    move-object/from16 v2, p24

    const-string v3, "deviceCode"

    invoke-static {p4, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v3, "tempHistories"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    move-object v3, p1

    .line 13
    iput-object v3, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    move-object v3, p2

    .line 14
    iput-object v3, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    move v3, p3

    .line 15
    iput-boolean v3, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    .line 16
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    move-object v1, p5

    .line 17
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    move v1, p6

    .line 18
    iput-boolean v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    move v1, p7

    .line 19
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    move v1, p8

    .line 20
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    move v1, p9

    .line 21
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    move v1, p10

    .line 22
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    move v1, p11

    .line 23
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    move/from16 v1, p12

    .line 24
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    move/from16 v1, p13

    .line 25
    iput-boolean v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    move/from16 v1, p14

    .line 26
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    move/from16 v1, p15

    .line 27
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    move/from16 v1, p16

    .line 28
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    move/from16 v1, p17

    .line 29
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    move/from16 v1, p18

    .line 30
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    move/from16 v1, p19

    .line 31
    iput v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    move/from16 v1, p20

    .line 32
    iput-byte v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    move-object/from16 v1, p21

    .line 33
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    move/from16 v1, p22

    .line 34
    iput-boolean v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    move/from16 v1, p23

    .line 35
    iput-boolean v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    .line 36
    iput-object v2, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    move-object/from16 v1, p25

    .line 37
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    move-object/from16 v1, p26

    .line 38
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    move/from16 v1, p27

    .line 39
    iput-boolean v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    move-object/from16 v1, p28

    .line 40
    iput-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .registers 60

    move/from16 v0, p29

    and-int/lit8 v1, v0, 0x1

    if-eqz v1, :cond_8

    const/4 v1, 0x0

    goto :goto_a

    :cond_8
    move-object/from16 v1, p1

    :goto_a
    and-int/lit8 v3, v0, 0x2

    if-eqz v3, :cond_10

    const/4 v3, 0x0

    goto :goto_12

    :cond_10
    move-object/from16 v3, p2

    :goto_12
    and-int/lit8 v4, v0, 0x4

    if-eqz v4, :cond_18

    const/4 v4, 0x0

    goto :goto_1a

    :cond_18
    move/from16 v4, p3

    :goto_1a
    and-int/lit8 v6, v0, 0x8

    if-eqz v6, :cond_21

    const-string v6, "all"

    goto :goto_23

    :cond_21
    move-object/from16 v6, p4

    :goto_23
    and-int/lit8 v7, v0, 0x10

    if-eqz v7, :cond_29

    const/4 v7, 0x0

    goto :goto_2b

    :cond_29
    move-object/from16 v7, p5

    :goto_2b
    and-int/lit8 v8, v0, 0x20

    if-eqz v8, :cond_31

    const/4 v8, 0x0

    goto :goto_33

    :cond_31
    move/from16 v8, p6

    :goto_33
    and-int/lit8 v9, v0, 0x40

    if-eqz v9, :cond_39

    const/4 v9, 0x0

    goto :goto_3b

    :cond_39
    move/from16 v9, p7

    :goto_3b
    and-int/lit16 v10, v0, 0x80

    if-eqz v10, :cond_41

    const/4 v10, 0x0

    goto :goto_43

    :cond_41
    move/from16 v10, p8

    :goto_43
    and-int/lit16 v11, v0, 0x100

    if-eqz v11, :cond_49

    const/4 v11, 0x0

    goto :goto_4b

    :cond_49
    move/from16 v11, p9

    :goto_4b
    and-int/lit16 v12, v0, 0x200

    if-eqz v12, :cond_51

    const/4 v12, 0x0

    goto :goto_53

    :cond_51
    move/from16 v12, p10

    :goto_53
    and-int/lit16 v13, v0, 0x400

    if-eqz v13, :cond_59

    const/4 v13, 0x1

    goto :goto_5b

    :cond_59
    move/from16 v13, p11

    :goto_5b
    and-int/lit16 v15, v0, 0x800

    if-eqz v15, :cond_61

    const/4 v15, 0x0

    goto :goto_63

    :cond_61
    move/from16 v15, p12

    :goto_63
    and-int/lit16 v2, v0, 0x1000

    if-eqz v2, :cond_69

    const/4 v2, 0x0

    goto :goto_6b

    :cond_69
    move/from16 v2, p13

    :goto_6b
    and-int/lit16 v14, v0, 0x2000

    if-eqz v14, :cond_71

    const/4 v14, 0x0

    goto :goto_73

    :cond_71
    move/from16 v14, p14

    :goto_73
    and-int/lit16 v5, v0, 0x4000

    if-eqz v5, :cond_79

    const/4 v5, 0x0

    goto :goto_7b

    :cond_79
    move/from16 v5, p15

    :goto_7b
    const v16, 0x8000

    and-int v16, v0, v16

    if-eqz v16, :cond_85

    const/16 v16, 0x0

    goto :goto_87

    :cond_85
    move/from16 v16, p16

    :goto_87
    const/high16 v17, 0x10000

    and-int v17, v0, v17

    if-eqz v17, :cond_90

    const/16 v17, 0x0

    goto :goto_92

    :cond_90
    move/from16 v17, p17

    :goto_92
    const/high16 v18, 0x20000

    and-int v18, v0, v18

    if-eqz v18, :cond_9b

    const/16 v18, 0x0

    goto :goto_9d

    :cond_9b
    move/from16 v18, p18

    :goto_9d
    const/high16 v19, 0x40000

    and-int v19, v0, v19

    if-eqz v19, :cond_a6

    const/16 v19, 0x0

    goto :goto_a8

    :cond_a6
    move/from16 v19, p19

    :goto_a8
    const/high16 v20, 0x80000

    and-int v20, v0, v20

    if-eqz v20, :cond_b1

    const/16 v20, 0x0

    goto :goto_b3

    :cond_b1
    move/from16 v20, p20

    :goto_b3
    const/high16 v21, 0x100000

    and-int v21, v0, v21

    if-eqz v21, :cond_bc

    const/16 v21, 0x0

    goto :goto_be

    :cond_bc
    move-object/from16 v21, p21

    :goto_be
    const/high16 v22, 0x200000

    and-int v22, v0, v22

    if-eqz v22, :cond_c7

    const/16 v22, 0x1

    goto :goto_c9

    :cond_c7
    move/from16 v22, p22

    :goto_c9
    const/high16 v23, 0x400000

    and-int v23, v0, v23

    if-eqz v23, :cond_d2

    const/16 v23, 0x0

    goto :goto_d4

    :cond_d2
    move/from16 v23, p23

    :goto_d4
    const/high16 v24, 0x800000

    and-int v24, v0, v24

    move/from16 p30, v5

    if-eqz v24, :cond_e2

    move/from16 v24, v14

    const/4 v5, 0x0

    new-array v14, v5, [B

    goto :goto_e7

    :cond_e2
    move/from16 v24, v14

    const/4 v5, 0x0

    move-object/from16 v14, p24

    :goto_e7
    const/high16 v25, 0x1000000

    and-int v25, v0, v25

    if-eqz v25, :cond_f2

    .line 37
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v25

    goto :goto_f4

    :cond_f2
    move-object/from16 v25, p25

    :goto_f4
    const/high16 v26, 0x2000000

    and-int v26, v0, v26

    if-eqz v26, :cond_ff

    .line 38
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v26

    goto :goto_101

    :cond_ff
    move-object/from16 v26, p26

    :goto_101
    const/high16 v27, 0x4000000

    and-int v27, v0, v27

    if-eqz v27, :cond_10a

    move/from16 v27, v5

    goto :goto_10c

    :cond_10a
    move/from16 v27, p27

    :goto_10c
    const/high16 v28, 0x8000000

    and-int v0, v0, v28

    if-eqz v0, :cond_117

    .line 40
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_119

    :cond_117
    move-object/from16 v0, p28

    :goto_119
    move-object/from16 p1, p0

    move-object/from16 p2, v1

    move-object/from16 p3, v3

    move/from16 p4, v4

    move-object/from16 p5, v6

    move-object/from16 p6, v7

    move/from16 p7, v8

    move/from16 p8, v9

    move/from16 p9, v10

    move/from16 p10, v11

    move/from16 p11, v12

    move/from16 p12, v13

    move/from16 p13, v15

    move/from16 p14, v2

    move/from16 p15, v24

    move/from16 p16, p30

    move/from16 p17, v16

    move/from16 p18, v17

    move/from16 p19, v18

    move/from16 p20, v19

    move/from16 p21, v20

    move-object/from16 p22, v21

    move/from16 p23, v22

    move/from16 p24, v23

    move-object/from16 p25, v14

    move-object/from16 p26, v25

    move-object/from16 p27, v26

    move/from16 p28, v27

    move-object/from16 p29, v0

    .line 12
    invoke-direct/range {p1 .. p29}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)V

    return-void
.end method

.method public static final convertFromDevice(Landroid/bluetooth/BluetoothDevice;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 2
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->Companion:Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;

    invoke-virtual {v0, p0}, Lcom/flydigi/sdk/waspwing/WaspWingInfo$Companion;->convertFromDevice(Landroid/bluetooth/BluetoothDevice;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic copy$default(Lcom/flydigi/sdk/waspwing/WaspWingInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/Object;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 48

    move-object/from16 v0, p0

    move/from16 v1, p29

    and-int/lit8 v2, v1, 0x1

    if-eqz v2, :cond_b

    iget-object v2, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    goto :goto_d

    :cond_b
    move-object/from16 v2, p1

    :goto_d
    and-int/lit8 v3, v1, 0x2

    if-eqz v3, :cond_14

    iget-object v3, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    goto :goto_16

    :cond_14
    move-object/from16 v3, p2

    :goto_16
    and-int/lit8 v4, v1, 0x4

    if-eqz v4, :cond_1d

    iget-boolean v4, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    goto :goto_1f

    :cond_1d
    move/from16 v4, p3

    :goto_1f
    and-int/lit8 v5, v1, 0x8

    if-eqz v5, :cond_26

    iget-object v5, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    goto :goto_28

    :cond_26
    move-object/from16 v5, p4

    :goto_28
    and-int/lit8 v6, v1, 0x10

    if-eqz v6, :cond_2f

    iget-object v6, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    goto :goto_31

    :cond_2f
    move-object/from16 v6, p5

    :goto_31
    and-int/lit8 v7, v1, 0x20

    if-eqz v7, :cond_38

    iget-boolean v7, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    goto :goto_3a

    :cond_38
    move/from16 v7, p6

    :goto_3a
    and-int/lit8 v8, v1, 0x40

    if-eqz v8, :cond_41

    iget v8, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    goto :goto_43

    :cond_41
    move/from16 v8, p7

    :goto_43
    and-int/lit16 v9, v1, 0x80

    if-eqz v9, :cond_4a

    iget v9, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    goto :goto_4c

    :cond_4a
    move/from16 v9, p8

    :goto_4c
    and-int/lit16 v10, v1, 0x100

    if-eqz v10, :cond_53

    iget v10, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    goto :goto_55

    :cond_53
    move/from16 v10, p9

    :goto_55
    and-int/lit16 v11, v1, 0x200

    if-eqz v11, :cond_5c

    iget v11, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    goto :goto_5e

    :cond_5c
    move/from16 v11, p10

    :goto_5e
    and-int/lit16 v12, v1, 0x400

    if-eqz v12, :cond_65

    iget v12, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    goto :goto_67

    :cond_65
    move/from16 v12, p11

    :goto_67
    and-int/lit16 v13, v1, 0x800

    if-eqz v13, :cond_6e

    iget v13, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    goto :goto_70

    :cond_6e
    move/from16 v13, p12

    :goto_70
    and-int/lit16 v14, v1, 0x1000

    if-eqz v14, :cond_77

    iget-boolean v14, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    goto :goto_79

    :cond_77
    move/from16 v14, p13

    :goto_79
    and-int/lit16 v15, v1, 0x2000

    if-eqz v15, :cond_80

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    goto :goto_82

    :cond_80
    move/from16 v15, p14

    :goto_82
    move/from16 p14, v15

    and-int/lit16 v15, v1, 0x4000

    if-eqz v15, :cond_8b

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    goto :goto_8d

    :cond_8b
    move/from16 v15, p15

    :goto_8d
    const v16, 0x8000

    and-int v16, v1, v16

    move/from16 p15, v15

    if-eqz v16, :cond_99

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    goto :goto_9b

    :cond_99
    move/from16 v15, p16

    :goto_9b
    const/high16 v16, 0x10000

    and-int v16, v1, v16

    move/from16 p16, v15

    if-eqz v16, :cond_a6

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    goto :goto_a8

    :cond_a6
    move/from16 v15, p17

    :goto_a8
    const/high16 v16, 0x20000

    and-int v16, v1, v16

    move/from16 p17, v15

    if-eqz v16, :cond_b3

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    goto :goto_b5

    :cond_b3
    move/from16 v15, p18

    :goto_b5
    const/high16 v16, 0x40000

    and-int v16, v1, v16

    move/from16 p18, v15

    if-eqz v16, :cond_c0

    iget v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    goto :goto_c2

    :cond_c0
    move/from16 v15, p19

    :goto_c2
    const/high16 v16, 0x80000

    and-int v16, v1, v16

    move/from16 p19, v15

    if-eqz v16, :cond_cd

    iget-byte v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    goto :goto_cf

    :cond_cd
    move/from16 v15, p20

    :goto_cf
    const/high16 v16, 0x100000

    and-int v16, v1, v16

    move/from16 p20, v15

    if-eqz v16, :cond_da

    iget-object v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    goto :goto_dc

    :cond_da
    move-object/from16 v15, p21

    :goto_dc
    const/high16 v16, 0x200000

    and-int v16, v1, v16

    move-object/from16 p21, v15

    if-eqz v16, :cond_e7

    iget-boolean v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    goto :goto_e9

    :cond_e7
    move/from16 v15, p22

    :goto_e9
    const/high16 v16, 0x400000

    and-int v16, v1, v16

    move/from16 p22, v15

    if-eqz v16, :cond_f4

    iget-boolean v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    goto :goto_f6

    :cond_f4
    move/from16 v15, p23

    :goto_f6
    const/high16 v16, 0x800000

    and-int v16, v1, v16

    move/from16 p23, v15

    if-eqz v16, :cond_101

    iget-object v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    goto :goto_103

    :cond_101
    move-object/from16 v15, p24

    :goto_103
    const/high16 v16, 0x1000000

    and-int v16, v1, v16

    move-object/from16 p24, v15

    if-eqz v16, :cond_10e

    iget-object v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    goto :goto_110

    :cond_10e
    move-object/from16 v15, p25

    :goto_110
    const/high16 v16, 0x2000000

    and-int v16, v1, v16

    move-object/from16 p25, v15

    if-eqz v16, :cond_11b

    iget-object v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    goto :goto_11d

    :cond_11b
    move-object/from16 v15, p26

    :goto_11d
    const/high16 v16, 0x4000000

    and-int v16, v1, v16

    move-object/from16 p26, v15

    if-eqz v16, :cond_128

    iget-boolean v15, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    goto :goto_12a

    :cond_128
    move/from16 v15, p27

    :goto_12a
    const/high16 v16, 0x8000000

    and-int v1, v1, v16

    if-eqz v1, :cond_133

    iget-object v1, v0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    goto :goto_135

    :cond_133
    move-object/from16 v1, p28

    :goto_135
    move-object/from16 p1, v2

    move-object/from16 p2, v3

    move/from16 p3, v4

    move-object/from16 p4, v5

    move-object/from16 p5, v6

    move/from16 p6, v7

    move/from16 p7, v8

    move/from16 p8, v9

    move/from16 p9, v10

    move/from16 p10, v11

    move/from16 p11, v12

    move/from16 p12, v13

    move/from16 p13, v14

    move/from16 p27, v15

    move-object/from16 p28, v1

    invoke-virtual/range {p0 .. p28}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->copy(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final component1()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public final component10()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    return v0
.end method

.method public final component11()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    return v0
.end method

.method public final component12()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    return v0
.end method

.method public final component13()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    return v0
.end method

.method public final component14()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    return v0
.end method

.method public final component15()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    return v0
.end method

.method public final component16()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    return v0
.end method

.method public final component17()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    return v0
.end method

.method public final component18()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    return v0
.end method

.method public final component19()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    return v0
.end method

.method public final component2()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    return-object v0
.end method

.method public final component20()B
    .registers 2

    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    return v0
.end method

.method public final component21()Lcom/flydigi/sdk/waspwing/LedData;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    return-object v0
.end method

.method public final component22()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    return v0
.end method

.method public final component23()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    return v0
.end method

.method public final component24()[B
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    return-object v0
.end method

.method public final component25()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    return-object v0
.end method

.method public final component26()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    return-object v0
.end method

.method public final component27()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    return v0
.end method

.method public final component28()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    return-object v0
.end method

.method public final component3()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    return v0
.end method

.method public final component4()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    return-object v0
.end method

.method public final component5()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    return-object v0
.end method

.method public final component6()Z
    .registers 2

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    return v0
.end method

.method public final component7()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    return v0
.end method

.method public final component8()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    return v0
.end method

.method public final component9()I
    .registers 2

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    return v0
.end method

.method public final copy(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)Lcom/flydigi/sdk/waspwing/WaspWingInfo;
    .registers 59

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    move/from16 v10, p10

    move/from16 v11, p11

    move/from16 v12, p12

    move/from16 v13, p13

    move/from16 v14, p14

    move/from16 v15, p15

    move/from16 v16, p16

    move/from16 v17, p17

    move/from16 v18, p18

    move/from16 v19, p19

    move/from16 v20, p20

    move-object/from16 v21, p21

    move/from16 v22, p22

    move/from16 v23, p23

    move-object/from16 v24, p24

    move-object/from16 v25, p25

    move-object/from16 v26, p26

    move/from16 v27, p27

    move-object/from16 v28, p28

    const-string v0, "deviceCode"

    move-object/from16 v1, p4

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "tempHistories"

    move-object/from16 v1, p24

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v29, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    move-object/from16 v0, v29

    move-object/from16 v1, p1

    invoke-direct/range {v0 .. v28}, Lcom/flydigi/sdk/waspwing/WaspWingInfo;-><init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZIIIIIIZIIIIIIBLcom/flydigi/sdk/waspwing/LedData;ZZ[BLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;)V

    return-object v29
.end method

.method public describeContents()I
    .registers 2

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 6

    const/4 v0, 0x1

    if-ne p0, p1, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    const/4 v2, 0x0

    if-nez v1, :cond_a

    return v2

    :cond_a
    check-cast p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;

    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_17

    return v2

    :cond_17
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_22

    return v2

    :cond_22
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    if-eq v1, v3, :cond_29

    return v2

    :cond_29
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_34

    return v2

    :cond_34
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3f

    return v2

    :cond_3f
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    if-eq v1, v3, :cond_46

    return v2

    :cond_46
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    if-eq v1, v3, :cond_4d

    return v2

    :cond_4d
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    if-eq v1, v3, :cond_54

    return v2

    :cond_54
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    if-eq v1, v3, :cond_5b

    return v2

    :cond_5b
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    if-eq v1, v3, :cond_62

    return v2

    :cond_62
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    if-eq v1, v3, :cond_69

    return v2

    :cond_69
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    if-eq v1, v3, :cond_70

    return v2

    :cond_70
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    if-eq v1, v3, :cond_77

    return v2

    :cond_77
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    if-eq v1, v3, :cond_7e

    return v2

    :cond_7e
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    if-eq v1, v3, :cond_85

    return v2

    :cond_85
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    if-eq v1, v3, :cond_8c

    return v2

    :cond_8c
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    if-eq v1, v3, :cond_93

    return v2

    :cond_93
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    if-eq v1, v3, :cond_9a

    return v2

    :cond_9a
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    iget v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    if-eq v1, v3, :cond_a1

    return v2

    :cond_a1
    iget-byte v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    iget-byte v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    if-eq v1, v3, :cond_a8

    return v2

    :cond_a8
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b3

    return v2

    :cond_b3
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    if-eq v1, v3, :cond_ba

    return v2

    :cond_ba
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    if-eq v1, v3, :cond_c1

    return v2

    :cond_c1
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_cc

    return v2

    :cond_cc
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_d7

    return v2

    :cond_d7
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    iget-object v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_e2

    return v2

    :cond_e2
    iget-boolean v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    iget-boolean v3, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    if-eq v1, v3, :cond_e9

    return v2

    :cond_e9
    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    iget-object p1, p1, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    invoke-static {v1, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_f4

    return v2

    :cond_f4
    return v0
.end method

.method public final getAddress()Ljava/lang/String;
    .registers 2

    .line 14
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    return-object v0
.end method

.method public final getColdLevel()I
    .registers 2

    .line 20
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    return v0
.end method

.method public final getColdLevelOverclock()I
    .registers 2

    .line 27
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    return v0
.end method

.method public final getColdProtection()Z
    .registers 2

    .line 34
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    return v0
.end method

.method public final getColdRunLevel()I
    .registers 2

    .line 30
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    return v0
.end method

.method public final getDeviceCode()Ljava/lang/String;
    .registers 2

    .line 16
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    return-object v0
.end method

.method public final getDeviceName()Ljava/lang/String;
    .registers 2

    .line 13
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public final getExperimentalRunModeValue()Ljava/lang/Integer;
    .registers 2

    .line 40
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getFirmwareVersion()Ljava/lang/String;
    .registers 2

    .line 17
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    return-object v0
.end method

.method public final getHotProtectionEnabled()Z
    .registers 2

    .line 35
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    return v0
.end method

.method public final getHotSurfaceTemperature()B
    .registers 2

    .line 32
    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    return v0
.end method

.method public final getIpType()Ljava/lang/Integer;
    .registers 2

    .line 37
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getLedData()Lcom/flydigi/sdk/waspwing/LedData;
    .registers 2

    .line 33
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    return-object v0
.end method

.method public final getLedType()I
    .registers 2

    .line 31
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    return v0
.end method

.method public final getLightState()Z
    .registers 2

    .line 18
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    return v0
.end method

.method public final getModeCustom()Ljava/lang/Integer;
    .registers 2

    .line 38
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getOverClockUsable()Z
    .registers 2

    .line 25
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    return v0
.end method

.method public final getReadableCold()Ljava/lang/String;
    .registers 3

    .line 108
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    if-eqz v0, :cond_48

    const/16 v1, 0x13

    if-eq v0, v1, :cond_45

    const/16 v1, 0x26

    if-eq v0, v1, :cond_42

    const/16 v1, 0x39

    if-eq v0, v1, :cond_3f

    const/16 v1, 0x4d

    if-eq v0, v1, :cond_3c

    const/16 v1, 0x5f

    if-eq v0, v1, :cond_39

    const/16 v1, 0x73

    if-eq v0, v1, :cond_36

    const/16 v1, 0x86

    if-eq v0, v1, :cond_33

    const/16 v1, 0x99

    if-eq v0, v1, :cond_30

    const/16 v1, 0xad

    if-eq v0, v1, :cond_2d

    .line 119
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4a

    :cond_2d
    const-string v0, "5.5V"

    goto :goto_4a

    :cond_30
    const-string v0, "5.0V"

    goto :goto_4a

    :cond_33
    const-string v0, "4.5V"

    goto :goto_4a

    :cond_36
    const-string v0, "4.0V"

    goto :goto_4a

    :cond_39
    const-string v0, "3.5V"

    goto :goto_4a

    :cond_3c
    const-string v0, "3.0V"

    goto :goto_4a

    :cond_3f
    const-string v0, "2.5V"

    goto :goto_4a

    :cond_42
    const-string v0, "2.0V"

    goto :goto_4a

    :cond_45
    const-string v0, "1.5V"

    goto :goto_4a

    :cond_48
    const-string v0, "--"

    :goto_4a
    return-object v0
.end method

.method public final getReadableLevel(I)Ljava/lang/String;
    .registers 9

    .line 93
    sget-object v0, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/Object;

    const/16 v2, 0x13

    sub-int/2addr p1, v2

    int-to-double v3, p1

    const-wide/high16 v5, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v3, v5

    int-to-double v5, v2

    div-double/2addr v3, v5

    const-wide/high16 v5, 0x3ff8000000000000L    # 1.5

    add-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object p1

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v1, v0}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p1

    const-string v0, "%.2fV"

    invoke-static {v0, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string v0, "format(format, *args)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method public final getReadableWind()Ljava/lang/String;
    .registers 3

    .line 96
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    if-eqz v0, :cond_2c

    const/16 v1, 0x39

    if-eq v0, v1, :cond_29

    const/16 v1, 0x4d

    if-eq v0, v1, :cond_26

    const/16 v1, 0x5f

    if-eq v0, v1, :cond_23

    const/16 v1, 0x73

    if-eq v0, v1, :cond_20

    const/16 v1, 0x86

    if-eq v0, v1, :cond_1d

    .line 103
    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_2e

    :cond_1d
    const-string v0, "4.5V"

    goto :goto_2e

    :cond_20
    const-string v0, "4.0V"

    goto :goto_2e

    :cond_23
    const-string v0, "3.5V"

    goto :goto_2e

    :cond_26
    const-string v0, "3.0V"

    goto :goto_2e

    :cond_29
    const-string v0, "2.5V"

    goto :goto_2e

    :cond_2c
    const-string v0, "--"

    :goto_2e
    return-object v0
.end method

.method public final getRealColdLevel()I
    .registers 2

    .line 89
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    if-nez v0, :cond_b

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    if-eqz v0, :cond_b

    .line 90
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    goto :goto_d

    .line 91
    :cond_b
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    :goto_d
    return v0
.end method

.method public final getRealWindLevel()I
    .registers 2

    .line 85
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    if-nez v0, :cond_b

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    if-eqz v0, :cond_b

    .line 86
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    goto :goto_d

    .line 87
    :cond_b
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    :goto_d
    return v0
.end method

.method public final getRunMode()I
    .registers 2

    .line 23
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    return v0
.end method

.method public final getRunModeSmartLevel()F
    .registers 7

    .line 125
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    const/16 v1, 0x12

    const/16 v2, 0x86

    const/16 v3, 0x73

    if-ne v0, v1, :cond_1e

    .line 126
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    const/16 v4, 0x4d

    if-ne v1, v4, :cond_1e

    .line 127
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    if-ne v1, v3, :cond_1e

    .line 128
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    if-ne v1, v4, :cond_1e

    .line 129
    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    if-ne v1, v2, :cond_1e

    const/4 v0, 0x0

    return v0

    :cond_1e
    const/16 v1, 0x10

    if-ne v0, v1, :cond_39

    .line 131
    iget v4, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    const/16 v5, 0x5f

    if-ne v4, v5, :cond_39

    .line 132
    iget v4, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    if-ne v4, v3, :cond_39

    .line 133
    iget v4, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    if-ne v4, v5, :cond_39

    .line 134
    iget v4, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    const/16 v5, 0x99

    if-ne v4, v5, :cond_39

    const/high16 v0, 0x3f800000    # 1.0f

    return v0

    :cond_39
    if-ne v0, v1, :cond_50

    .line 136
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    if-ne v0, v3, :cond_50

    .line 137
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    if-ne v0, v3, :cond_50

    .line 138
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    if-ne v0, v2, :cond_50

    .line 139
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    const/16 v1, 0xad

    if-ne v0, v1, :cond_50

    const/high16 v0, 0x40000000    # 2.0f

    return v0

    :cond_50
    const/high16 v0, -0x40800000    # -1.0f

    return v0
.end method

.method public final getSpeed()I
    .registers 2

    .line 28
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    return v0
.end method

.method public final getTargetTemperature()I
    .registers 2

    .line 24
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    return v0
.end method

.method public final getTempHistories()[B
    .registers 2

    .line 36
    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    return-object v0
.end method

.method public final getTemperature()I
    .registers 2

    .line 21
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    return v0
.end method

.method public final getTemperatureDecimal()I
    .registers 2

    .line 22
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    return v0
.end method

.method public final getWindLevel()I
    .registers 2

    .line 19
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    return v0
.end method

.method public final getWindLevelOverclock()I
    .registers 2

    .line 26
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    return v0
.end method

.method public final getWindRunLevel()I
    .registers 2

    .line 29
    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    return v0
.end method

.method public hashCode()I
    .registers 5

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    const/4 v1, 0x0

    if-nez v0, :cond_7

    move v0, v1

    goto :goto_b

    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_b
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    if-nez v2, :cond_13

    move v2, v1

    goto :goto_17

    :cond_13
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_17
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    const/4 v3, 0x1

    if-eqz v2, :cond_20

    move v2, v3

    :cond_20
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    if-nez v2, :cond_32

    move v2, v1

    goto :goto_36

    :cond_32
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_36
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    if-eqz v2, :cond_3e

    move v2, v3

    :cond_3e
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    if-eqz v2, :cond_7c

    move v2, v3

    :cond_7c
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    invoke-static {v2}, Ljava/lang/Integer;->hashCode(I)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-byte v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    invoke-static {v2}, Ljava/lang/Byte;->hashCode(B)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    if-nez v2, :cond_c4

    move v2, v1

    goto :goto_c8

    :cond_c4
    invoke-virtual {v2}, Lcom/flydigi/sdk/waspwing/LedData;->hashCode()I

    move-result v2

    :goto_c8
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    if-eqz v2, :cond_d0

    move v2, v3

    :cond_d0
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    if-eqz v2, :cond_d8

    move v2, v3

    :cond_d8
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    invoke-static {v2}, Ljava/util/Arrays;->hashCode([B)I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    if-nez v2, :cond_ea

    move v2, v1

    goto :goto_ee

    :cond_ea
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_ee
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    if-nez v2, :cond_f7

    move v2, v1

    goto :goto_fb

    :cond_f7
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_fb
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    if-eqz v2, :cond_103

    goto :goto_104

    :cond_103
    move v3, v2

    :goto_104
    add-int/2addr v0, v3

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    if-nez v2, :cond_10c

    goto :goto_110

    :cond_10c
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_110
    add-int/2addr v0, v1

    return v0
.end method

.method public final isConnected()Z
    .registers 2

    .line 15
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    return v0
.end method

.method public final isExperimentalRunModeOn()Z
    .registers 2

    .line 39
    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    return v0
.end method

.method public final setAddress(Ljava/lang/String;)V
    .registers 2

    .line 14
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    return-void
.end method

.method public final setColdLevel(I)V
    .registers 2

    .line 20
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    return-void
.end method

.method public final setColdLevelOverclock(I)V
    .registers 2

    .line 27
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    return-void
.end method

.method public final setColdProtection(Z)V
    .registers 2

    .line 34
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    return-void
.end method

.method public final setColdRunLevel(I)V
    .registers 2

    .line 30
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    return-void
.end method

.method public final setConnected(Z)V
    .registers 2

    .line 15
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    return-void
.end method

.method public final setDeviceCode(Ljava/lang/String;)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 16
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    return-void
.end method

.method public final setDeviceName(Ljava/lang/String;)V
    .registers 2

    .line 13
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    return-void
.end method

.method public final setExperimentalRunModeOn(Z)V
    .registers 2

    .line 39
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    return-void
.end method

.method public final setExperimentalRunModeValue(Ljava/lang/Integer;)V
    .registers 2

    .line 40
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    return-void
.end method

.method public final setFirmwareVersion(Ljava/lang/String;)V
    .registers 2

    .line 17
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    return-void
.end method

.method public final setHotProtectionEnabled(Z)V
    .registers 2

    .line 35
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    return-void
.end method

.method public final setHotSurfaceTemperature(B)V
    .registers 2

    .line 32
    iput-byte p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    return-void
.end method

.method public final setIpType(Ljava/lang/Integer;)V
    .registers 2

    .line 37
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    return-void
.end method

.method public final setLedData(Lcom/flydigi/sdk/waspwing/LedData;)V
    .registers 2

    .line 33
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    return-void
.end method

.method public final setLedType(I)V
    .registers 2

    .line 31
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    return-void
.end method

.method public final setLightState(Z)V
    .registers 2

    .line 18
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    return-void
.end method

.method public final setModeCustom(Ljava/lang/Integer;)V
    .registers 2

    .line 38
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    return-void
.end method

.method public final setOverClockUsable(Z)V
    .registers 2

    .line 25
    iput-boolean p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    return-void
.end method

.method public final setRunMode(I)V
    .registers 2

    .line 23
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    return-void
.end method

.method public final setSpeed(I)V
    .registers 2

    .line 28
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    return-void
.end method

.method public final setTargetTemperature(I)V
    .registers 2

    .line 24
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    return-void
.end method

.method public final setTempHistories([B)V
    .registers 3

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 36
    iput-object p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    return-void
.end method

.method public final setTemperature(I)V
    .registers 2

    .line 21
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    return-void
.end method

.method public final setTemperatureDecimal(I)V
    .registers 2

    .line 22
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    return-void
.end method

.method public final setWindLevel(I)V
    .registers 2

    .line 19
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    return-void
.end method

.method public final setWindLevelOverclock(I)V
    .registers 2

    .line 26
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    return-void
.end method

.method public final setWindRunLevel(I)V
    .registers 2

    .line 29
    iput p1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "WaspWingInfo(deviceName="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", address="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", isConnected="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", deviceCode="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", firmwareVersion="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", lightState="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", windLevel="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", coldLevel="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", temperature="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", temperatureDecimal="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", runMode="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", targetTemperature="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", overClockUsable="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", windLevelOverclock="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", coldLevelOverclock="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", speed="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", windRunLevel="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", coldRunLevel="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", ledType="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", hotSurfaceTemperature="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-byte v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", ledData="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", coldProtection="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", hotProtectionEnabled="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v1, ", tempHistories="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    invoke-static {v2}, Ljava/util/Arrays;->toString([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", ipType="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", modeCustom="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", isExperimentalRunModeOn="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", experimentalRunModeValue="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x29

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6

    const-string v0, "out"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->address:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isConnected:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->deviceCode:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->firmwareVersion:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->lightState:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperature:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->temperatureDecimal:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->runMode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->targetTemperature:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-boolean v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->overClockUsable:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windLevelOverclock:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldLevelOverclock:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->speed:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->windRunLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldRunLevel:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-byte v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotSurfaceTemperature:B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v0, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ledData:Lcom/flydigi/sdk/waspwing/LedData;

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-nez v0, :cond_73

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_79

    :cond_73
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {v0, p1, p2}, Lcom/flydigi/sdk/waspwing/LedData;->writeToParcel(Landroid/os/Parcel;I)V

    :goto_79
    iget-boolean p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->coldProtection:Z

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-boolean p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->hotProtectionEnabled:Z

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->tempHistories:[B

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeByteArray([B)V

    iget-object p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->ipType:Ljava/lang/Integer;

    if-nez p2, :cond_90

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9a

    :cond_90
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    :goto_9a
    iget-object p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->modeCustom:Ljava/lang/Integer;

    if-nez p2, :cond_a2

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_ac

    :cond_a2
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    :goto_ac
    iget-boolean p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->isExperimentalRunModeOn:Z

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lcom/flydigi/sdk/waspwing/WaspWingInfo;->experimentalRunModeValue:Ljava/lang/Integer;

    if-nez p2, :cond_b9

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_c3

    :cond_b9
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    :goto_c3
    return-void
.end method
