.class public final synthetic Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

.field public final synthetic f$1:Landroid/bluetooth/BluetoothDevice;


# direct methods
.method public synthetic constructor <init>(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Landroid/bluetooth/BluetoothDevice;)V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda1;->f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda1;->f$1:Landroid/bluetooth/BluetoothDevice;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 3

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda1;->f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda1;->f$1:Landroid/bluetooth/BluetoothDevice;

    invoke-static {v0, v1}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->$r8$lambda$DwFIud2mUETBbVvnYHQHvbGO9BM(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method
