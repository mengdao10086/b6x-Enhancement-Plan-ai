.class public final Lcom/permissionx/guolindev/dialog/PermissionMapKt;
.super Ljava/lang/Object;
.source "PermissionMap.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\t\"\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008\"\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0008\"\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0008\u00a8\u0006\u000f"
    }
    d2 = {
        "allSpecialPermissions",
        "",
        "",
        "getAllSpecialPermissions",
        "()Ljava/util/Set;",
        "permissionMapOnQ",
        "",
        "getPermissionMapOnQ",
        "()Ljava/util/Map;",
        "permissionMapOnR",
        "getPermissionMapOnR",
        "permissionMapOnS",
        "getPermissionMapOnS",
        "permissionMapOnT",
        "getPermissionMapOnT",
        "permissionx_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x7,
        0x1
    }
    xi = 0x30
.end annotation


# static fields
.field private static final allSpecialPermissions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final permissionMapOnQ:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final permissionMapOnR:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final permissionMapOnS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final permissionMapOnT:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 12

    const-string v0, "android.permission.ACCESS_BACKGROUND_LOCATION"

    const-string v1, "android.permission.SYSTEM_ALERT_WINDOW"

    const-string v2, "android.permission.WRITE_SETTINGS"

    const-string v3, "android.permission.MANAGE_EXTERNAL_STORAGE"

    const-string v4, "android.permission.REQUEST_INSTALL_PACKAGES"

    const-string v5, "android.permission.POST_NOTIFICATIONS"

    const-string v6, "android.permission.BODY_SENSORS_BACKGROUND"

    .line 38
    filled-new-array/range {v0 .. v6}, [Ljava/lang/String;

    move-result-object v0

    .line 31
    invoke-static {v0}, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v0

    sput-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->allSpecialPermissions:Ljava/util/Set;

    const/16 v0, 0x1e

    new-array v0, v0, [Lkotlin/Pair;

    const-string v1, "android.permission.READ_CALENDAR"

    const-string v2, "android.permission-group.CALENDAR"

    .line 49
    invoke-static {v1, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v3, 0x0

    aput-object v1, v0, v3

    const-string v1, "android.permission.WRITE_CALENDAR"

    .line 50
    invoke-static {v1, v2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    const-string v1, "android.permission.READ_CALL_LOG"

    const-string v4, "android.permission-group.CALL_LOG"

    .line 51
    invoke-static {v1, v4}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v5, 0x2

    aput-object v1, v0, v5

    const-string v1, "android.permission.WRITE_CALL_LOG"

    .line 52
    invoke-static {v1, v4}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v6, 0x3

    aput-object v1, v0, v6

    const-string v1, "android.permission.PROCESS_OUTGOING_CALLS"

    .line 53
    invoke-static {v1, v4}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v4, 0x4

    aput-object v1, v0, v4

    const-string v1, "android.permission.CAMERA"

    const-string v7, "android.permission-group.CAMERA"

    .line 54
    invoke-static {v1, v7}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v7, 0x5

    aput-object v1, v0, v7

    const-string v1, "android.permission.READ_CONTACTS"

    const-string v8, "android.permission-group.CONTACTS"

    .line 55
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v9, 0x6

    aput-object v1, v0, v9

    const-string v1, "android.permission.WRITE_CONTACTS"

    .line 56
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/4 v10, 0x7

    aput-object v1, v0, v10

    const-string v1, "android.permission.GET_ACCOUNTS"

    .line 57
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v8, 0x8

    aput-object v1, v0, v8

    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    const-string v8, "android.permission-group.LOCATION"

    .line 58
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x9

    aput-object v1, v0, v10

    const-string v1, "android.permission.ACCESS_COARSE_LOCATION"

    .line 59
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0xa

    aput-object v1, v0, v10

    const-string v1, "android.permission.ACCESS_BACKGROUND_LOCATION"

    .line 60
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v8, 0xb

    aput-object v1, v0, v8

    const-string v1, "android.permission.RECORD_AUDIO"

    const-string v8, "android.permission-group.MICROPHONE"

    .line 61
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v8, 0xc

    aput-object v1, v0, v8

    const-string v1, "android.permission.READ_PHONE_STATE"

    const-string v8, "android.permission-group.PHONE"

    .line 62
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0xd

    aput-object v1, v0, v10

    const-string v1, "android.permission.READ_PHONE_NUMBERS"

    .line 63
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0xe

    aput-object v1, v0, v10

    const-string v1, "android.permission.CALL_PHONE"

    .line 64
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0xf

    aput-object v1, v0, v10

    const-string v1, "android.permission.ANSWER_PHONE_CALLS"

    .line 65
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x10

    aput-object v1, v0, v10

    const-string v1, "com.android.voicemail.permission.ADD_VOICEMAIL"

    .line 66
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x11

    aput-object v1, v0, v10

    const-string v1, "android.permission.USE_SIP"

    .line 67
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x12

    aput-object v1, v0, v10

    const-string v1, "android.permission.ACCEPT_HANDOVER"

    .line 68
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v8, 0x13

    aput-object v1, v0, v8

    const-string v1, "android.permission.BODY_SENSORS"

    const-string v8, "android.permission-group.SENSORS"

    .line 69
    invoke-static {v1, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x14

    aput-object v1, v0, v10

    const-string v1, "android.permission.ACTIVITY_RECOGNITION"

    const-string v10, "android.permission-group.ACTIVITY_RECOGNITION"

    .line 70
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x15

    aput-object v1, v0, v10

    const-string v1, "android.permission.SEND_SMS"

    const-string v10, "android.permission-group.SMS"

    .line 71
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x16

    aput-object v1, v0, v11

    const-string v1, "android.permission.RECEIVE_SMS"

    .line 72
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x17

    aput-object v1, v0, v11

    const-string v1, "android.permission.READ_SMS"

    .line 73
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x18

    aput-object v1, v0, v11

    const-string v1, "android.permission.RECEIVE_WAP_PUSH"

    .line 74
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x19

    aput-object v1, v0, v11

    const-string v1, "android.permission.RECEIVE_MMS"

    .line 75
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v10, 0x1a

    aput-object v1, v0, v10

    const-string v1, "android.permission.READ_EXTERNAL_STORAGE"

    const-string v10, "android.permission-group.STORAGE"

    .line 76
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x1b

    aput-object v1, v0, v11

    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"

    .line 77
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x1c

    aput-object v1, v0, v11

    const-string v1, "android.permission.ACCESS_MEDIA_LOCATION"

    .line 78
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    const/16 v11, 0x1d

    aput-object v1, v0, v11

    .line 48
    invoke-static {v0}, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnQ:Ljava/util/Map;

    const-string v1, "android.permission.MANAGE_EXTERNAL_STORAGE"

    .line 86
    invoke-static {v1, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v1

    .line 85
    invoke-static {v1}, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v1

    .line 87
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 88
    invoke-interface {v1, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 89
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnR:Ljava/util/Map;

    new-array v1, v6, [Lkotlin/Pair;

    const-string v10, "android.permission.BLUETOOTH_SCAN"

    const-string v11, "android.permission-group.NEARBY_DEVICES"

    .line 96
    invoke-static {v10, v11}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v10

    aput-object v10, v1, v3

    const-string v10, "android.permission.BLUETOOTH_ADVERTISE"

    .line 97
    invoke-static {v10, v11}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v10

    aput-object v10, v1, v2

    const-string v10, "android.permission.BLUETOOTH_CONNECT"

    .line 98
    invoke-static {v10, v11}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v10

    aput-object v10, v1, v5

    .line 95
    invoke-static {v1}, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v1

    .line 99
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 100
    invoke-interface {v1, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 101
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnS:Ljava/util/Map;

    new-array v1, v9, [Lkotlin/Pair;

    const-string v9, "android.permission.READ_MEDIA_IMAGES"

    const-string v10, "android.permission-group.READ_MEDIA_VISUAL"

    .line 108
    invoke-static {v9, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v9

    aput-object v9, v1, v3

    const-string v3, "android.permission.READ_MEDIA_VIDEO"

    .line 109
    invoke-static {v3, v10}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v3

    aput-object v3, v1, v2

    const-string v2, "android.permission.READ_MEDIA_AUDIO"

    const-string v3, "android.permission-group.READ_MEDIA_AURAL"

    .line 110
    invoke-static {v2, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    aput-object v2, v1, v5

    const-string v2, "android.permission.POST_NOTIFICATIONS"

    const-string v3, "android.permission-group.NOTIFICATIONS"

    .line 111
    invoke-static {v2, v3}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    aput-object v2, v1, v6

    const-string v2, "android.permission.NEARBY_WIFI_DEVICES"

    .line 112
    invoke-static {v2, v11}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    aput-object v2, v1, v4

    const-string v2, "android.permission.BODY_SENSORS_BACKGROUND"

    .line 113
    invoke-static {v2, v8}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v2

    aput-object v2, v1, v7

    .line 107
    invoke-static {v1}, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v1

    .line 114
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    .line 115
    invoke-interface {v1, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 116
    invoke-static {v1}, Lkotlin/collections/MapsKt;->toMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnT:Ljava/util/Map;

    return-void
.end method

.method public static final getAllSpecialPermissions()Ljava/util/Set;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 31
    sget-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->allSpecialPermissions:Ljava/util/Set;

    return-object v0
.end method

.method public static final getPermissionMapOnQ()Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 48
    sget-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnQ:Ljava/util/Map;

    return-object v0
.end method

.method public static final getPermissionMapOnR()Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 85
    sget-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnR:Ljava/util/Map;

    return-object v0
.end method

.method public static final getPermissionMapOnS()Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 95
    sget-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnS:Ljava/util/Map;

    return-object v0
.end method

.method public static final getPermissionMapOnT()Ljava/util/Map;
    .registers 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 107
    sget-object v0, Lcom/permissionx/guolindev/dialog/PermissionMapKt;->permissionMapOnT:Ljava/util/Map;

    return-object v0
.end method
