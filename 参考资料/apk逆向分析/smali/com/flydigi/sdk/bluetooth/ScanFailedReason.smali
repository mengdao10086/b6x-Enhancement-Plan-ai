.class public final Lcom/flydigi/sdk/bluetooth/ScanFailedReason;
.super Ljava/lang/Object;
.source "Constance.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ScanFailedReason$Code;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ScanFailedReason;",
        "",
        "()V",
        "SCAN_FAILED_ALREADY_STARTED",
        "",
        "SCAN_FAILED_APPLICATION_REGISTRATION_FAILED",
        "SCAN_FAILED_BLUETOOTH_CLOSED",
        "SCAN_FAILED_FEATURE_UNSUPPORTED",
        "SCAN_FAILED_INTERNAL_ERROR",
        "SCAN_FAILED_LOCATION_PERMISSION_REQUIRED",
        "SCAN_FAILED_LOCATION_SERVICE_DISABLED",
        "SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES",
        "SCAN_FAILED_SCANNING_TOO_FREQUENTLY",
        "Code",
        "bluetooth_release"
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
.field public static final INSTANCE:Lcom/flydigi/sdk/bluetooth/ScanFailedReason;

.field public static final SCAN_FAILED_ALREADY_STARTED:I = 0x1

.field public static final SCAN_FAILED_APPLICATION_REGISTRATION_FAILED:I = 0x2

.field public static final SCAN_FAILED_BLUETOOTH_CLOSED:I = 0x7

.field public static final SCAN_FAILED_FEATURE_UNSUPPORTED:I = 0x4

.field public static final SCAN_FAILED_INTERNAL_ERROR:I = 0x3

.field public static final SCAN_FAILED_LOCATION_PERMISSION_REQUIRED:I = 0x9

.field public static final SCAN_FAILED_LOCATION_SERVICE_DISABLED:I = 0x8

.field public static final SCAN_FAILED_OUT_OF_HARDWARE_RESOURCES:I = 0x5

.field public static final SCAN_FAILED_SCANNING_TOO_FREQUENTLY:I = 0x6


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/flydigi/sdk/bluetooth/ScanFailedReason;

    invoke-direct {v0}, Lcom/flydigi/sdk/bluetooth/ScanFailedReason;-><init>()V

    sput-object v0, Lcom/flydigi/sdk/bluetooth/ScanFailedReason;->INSTANCE:Lcom/flydigi/sdk/bluetooth/ScanFailedReason;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
