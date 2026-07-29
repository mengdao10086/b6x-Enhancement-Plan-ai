.class public interface abstract Lcom/flydigi/sdk/bluetooth/ota/OtaCallback;
.super Ljava/lang/Object;
.source "OtaCallback.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flydigi/sdk/bluetooth/ota/OtaCallback$DefaultImpls;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\u0008J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0008\u0010\u000c\u001a\u00020\u0003H&J\u0008\u0010\r\u001a\u00020\u0003H&J\u0008\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"
    }
    d2 = {
        "Lcom/flydigi/sdk/bluetooth/ota/OtaCallback;",
        "",
        "onOtaFailed",
        "",
        "code",
        "Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;",
        "internalErrorCode",
        "",
        "(Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Integer;)V",
        "onOtaFileWritten",
        "process",
        "",
        "onOtaPrepared",
        "onOtaStarted",
        "onOtaSuccess",
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


# virtual methods
.method public abstract onOtaFailed(Lcom/flydigi/sdk/bluetooth/ota/OtaStatus;Ljava/lang/Integer;)V
.end method

.method public abstract onOtaFileWritten(F)V
.end method

.method public abstract onOtaPrepared()V
.end method

.method public abstract onOtaStarted()V
.end method

.method public abstract onOtaSuccess()V
.end method
