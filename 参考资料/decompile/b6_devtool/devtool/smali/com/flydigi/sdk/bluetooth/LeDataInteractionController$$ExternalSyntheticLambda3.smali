.class public final synthetic Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

.field public final synthetic f$1:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

.field public final synthetic f$2:[B


# direct methods
.method public synthetic constructor <init>(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;[B)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    iput-object p2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$1:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    iput-object p3, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$2:[B

    return-void
.end method


# virtual methods
.method public final run()V
    .registers 4

    iget-object v0, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$0:Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;

    iget-object v1, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$1:Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;

    iget-object v2, p0, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController$$ExternalSyntheticLambda3;->f$2:[B

    invoke-static {v0, v1, v2}, Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;->$r8$lambda$oGNVaDzM7-q6nsbyQAnuk2Pli2g(Lcom/flydigi/sdk/bluetooth/LeDataInteractionController;Lcom/flydigi/sdk/bluetooth/ota/OtaFactory;[B)V

    return-void
.end method
