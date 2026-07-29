.class public final synthetic Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

.field public final synthetic f$1:[B

.field public final synthetic f$2:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;


# direct methods
.method public synthetic constructor <init>(Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;[BLcom/flydigi/sdk/bluetooth/LeDataInteractionController;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$0:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$1:[B

    iput-object p3, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$2:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$0:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$1:[B

    iget-object v2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda2;->f$2:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    invoke-static {v0, v1, v2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->$r8$lambda$M8wnp4MtRSECE4q2tqOKL9oxG-Q(Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;[BLcom/flydigi/sdk/bluetooth/LeDataInteractionController;)V

    return-void
.end method
