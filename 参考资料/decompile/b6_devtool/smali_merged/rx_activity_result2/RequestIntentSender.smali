.class public Lrx_activity_result2/RequestIntentSender;
.super Lrx_activity_result2/Request;
.source "RequestIntentSender.java"


# instance fields
.field private final extraFlags:I

.field private final fillInIntent:Landroid/content/Intent;

.field private final flagsMask:I

.field private final flagsValues:I

.field private final intentSender:Landroid/content/IntentSender;

.field private final options:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Landroid/content/IntentSender;Landroid/content/Intent;IIILandroid/os/Bundle;)V
    .registers 8

    const/4 v0, 0x0

    .line 31
    invoke-direct {p0, v0}, Lrx_activity_result2/Request;-><init>(Landroid/content/Intent;)V

    .line 32
    iput-object p1, p0, Lrx_activity_result2/RequestIntentSender;->intentSender:Landroid/content/IntentSender;

    .line 33
    iput-object p2, p0, Lrx_activity_result2/RequestIntentSender;->fillInIntent:Landroid/content/Intent;

    .line 34
    iput p3, p0, Lrx_activity_result2/RequestIntentSender;->flagsMask:I

    .line 35
    iput p4, p0, Lrx_activity_result2/RequestIntentSender;->flagsValues:I

    .line 36
    iput p5, p0, Lrx_activity_result2/RequestIntentSender;->extraFlags:I

    .line 37
    iput-object p6, p0, Lrx_activity_result2/RequestIntentSender;->options:Landroid/os/Bundle;

    return-void
.end method


# virtual methods
.method public getExtraFlags()I
    .registers 2

    .line 57
    iget v0, p0, Lrx_activity_result2/RequestIntentSender;->extraFlags:I

    return v0
.end method

.method public getFillInIntent()Landroid/content/Intent;
    .registers 2

    .line 45
    iget-object v0, p0, Lrx_activity_result2/RequestIntentSender;->fillInIntent:Landroid/content/Intent;

    return-object v0
.end method

.method public getFlagsMask()I
    .registers 2

    .line 49
    iget v0, p0, Lrx_activity_result2/RequestIntentSender;->flagsMask:I

    return v0
.end method

.method public getFlagsValues()I
    .registers 2

    .line 53
    iget v0, p0, Lrx_activity_result2/RequestIntentSender;->flagsValues:I

    return v0
.end method

.method public getIntentSender()Landroid/content/IntentSender;
    .registers 2

    .line 41
    iget-object v0, p0, Lrx_activity_result2/RequestIntentSender;->intentSender:Landroid/content/IntentSender;

    return-object v0
.end method

.method public getOptions()Landroid/os/Bundle;
    .registers 2

    .line 61
    iget-object v0, p0, Lrx_activity_result2/RequestIntentSender;->options:Landroid/os/Bundle;

    return-object v0
.end method

.method public bridge synthetic intent()Landroid/content/Intent;
    .registers 2

    .line 24
    invoke-super {p0}, Lrx_activity_result2/Request;->intent()Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onResult()Lrx_activity_result2/OnResult;
    .registers 2

    .line 24
    invoke-super {p0}, Lrx_activity_result2/Request;->onResult()Lrx_activity_result2/OnResult;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic setOnResult(Lrx_activity_result2/OnResult;)V
    .registers 2

    .line 24
    invoke-super {p0, p1}, Lrx_activity_result2/Request;->setOnResult(Lrx_activity_result2/OnResult;)V

    return-void
.end method
