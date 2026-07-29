.class public Lrx_activity_result2/HolderActivity;
.super Landroid/app/Activity;
.source "HolderActivity.java"


# static fields
.field private static FAILED_REQUEST_CODE:I = -0x38d

.field private static request:Lrx_activity_result2/Request;


# instance fields
.field private data:Landroid/content/Intent;

.field private onPreResult:Lrx_activity_result2/OnPreResult;

.field private onResult:Lrx_activity_result2/OnResult;

.field private requestCode:I

.field private resultCode:I


# direct methods
.method static constructor <clinit>()V
    .registers 0

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .line 27
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static setRequest(Lrx_activity_result2/Request;)V
    .registers 1

    .line 117
    sput-object p0, Lrx_activity_result2/HolderActivity;->request:Lrx_activity_result2/Request;

    return-void
.end method

.method private startIntentSender(Lrx_activity_result2/RequestIntentSender;)V
    .registers 9

    .line 68
    :try_start_0
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getIntentSender()Landroid/content/IntentSender;

    move-result-object v1

    const/4 v2, 0x0

    .line 69
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFillInIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFlagsMask()I

    move-result v4

    .line 70
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFlagsValues()I

    move-result v5

    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getExtraFlags()I

    move-result v6

    move-object v0, p0

    .line 68
    invoke-virtual/range {v0 .. v6}, Lrx_activity_result2/HolderActivity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;III)V
    :try_end_19
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_19} :catch_1a

    goto :goto_27

    :catch_1a
    move-exception p1

    .line 72
    invoke-virtual {p1}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    .line 73
    iget-object p1, p0, Lrx_activity_result2/HolderActivity;->onResult:Lrx_activity_result2/OnResult;

    sget v0, Lrx_activity_result2/HolderActivity;->FAILED_REQUEST_CODE:I

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v1, v2}, Lrx_activity_result2/OnResult;->response(IILandroid/content/Intent;)V

    :goto_27
    return-void
.end method

.method private startIntentSenderWithOptions(Lrx_activity_result2/RequestIntentSender;)V
    .registers 10

    .line 79
    :try_start_0
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getIntentSender()Landroid/content/IntentSender;

    move-result-object v1

    const/4 v2, 0x0

    .line 80
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFillInIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFlagsMask()I

    move-result v4

    .line 81
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getFlagsValues()I

    move-result v5

    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getExtraFlags()I

    move-result v6

    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getOptions()Landroid/os/Bundle;

    move-result-object v7

    move-object v0, p0

    .line 79
    invoke-virtual/range {v0 .. v7}, Lrx_activity_result2/HolderActivity;->startIntentSenderForResult(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V
    :try_end_1d
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_1d} :catch_1e

    goto :goto_2b

    :catch_1e
    move-exception p1

    .line 83
    invoke-virtual {p1}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    .line 84
    iget-object p1, p0, Lrx_activity_result2/HolderActivity;->onResult:Lrx_activity_result2/OnResult;

    sget v0, Lrx_activity_result2/HolderActivity;->FAILED_REQUEST_CODE:I

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v1, v2}, Lrx_activity_result2/OnResult;->response(IILandroid/content/Intent;)V

    :goto_2b
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .registers 5

    .line 90
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 91
    iput p2, p0, Lrx_activity_result2/HolderActivity;->resultCode:I

    .line 92
    iput p1, p0, Lrx_activity_result2/HolderActivity;->requestCode:I

    .line 93
    iput-object p3, p0, Lrx_activity_result2/HolderActivity;->data:Landroid/content/Intent;

    .line 95
    iget-object v0, p0, Lrx_activity_result2/HolderActivity;->onPreResult:Lrx_activity_result2/OnPreResult;

    if-eqz v0, :cond_1e

    .line 96
    invoke-interface {v0, p1, p2, p3}, Lrx_activity_result2/OnPreResult;->response(IILandroid/content/Intent;)Lio/reactivex/Observable;

    move-result-object p1

    new-instance p2, Lrx_activity_result2/HolderActivity$1;

    invoke-direct {p2, p0}, Lrx_activity_result2/HolderActivity$1;-><init>(Lrx_activity_result2/HolderActivity;)V

    .line 97
    invoke-virtual {p1, p2}, Lio/reactivex/Observable;->doOnComplete(Lio/reactivex/functions/Action;)Lio/reactivex/Observable;

    move-result-object p1

    .line 103
    invoke-virtual {p1}, Lio/reactivex/Observable;->subscribe()Lio/reactivex/disposables/Disposable;

    goto :goto_21

    .line 105
    :cond_1e
    invoke-virtual {p0}, Lrx_activity_result2/HolderActivity;->finish()V

    :goto_21
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .registers 3

    .line 38
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 40
    sget-object v0, Lrx_activity_result2/HolderActivity;->request:Lrx_activity_result2/Request;

    if-nez v0, :cond_b

    .line 41
    invoke-virtual {p0}, Lrx_activity_result2/HolderActivity;->finish()V

    return-void

    .line 45
    :cond_b
    invoke-virtual {v0}, Lrx_activity_result2/Request;->onPreResult()Lrx_activity_result2/OnPreResult;

    move-result-object v0

    iput-object v0, p0, Lrx_activity_result2/HolderActivity;->onPreResult:Lrx_activity_result2/OnPreResult;

    .line 46
    sget-object v0, Lrx_activity_result2/HolderActivity;->request:Lrx_activity_result2/Request;

    invoke-virtual {v0}, Lrx_activity_result2/Request;->onResult()Lrx_activity_result2/OnResult;

    move-result-object v0

    iput-object v0, p0, Lrx_activity_result2/HolderActivity;->onResult:Lrx_activity_result2/OnResult;

    if-eqz p1, :cond_1c

    return-void

    .line 50
    :cond_1c
    sget-object p1, Lrx_activity_result2/HolderActivity;->request:Lrx_activity_result2/Request;

    instance-of v0, p1, Lrx_activity_result2/RequestIntentSender;

    if-eqz v0, :cond_32

    .line 51
    check-cast p1, Lrx_activity_result2/RequestIntentSender;

    .line 53
    invoke-virtual {p1}, Lrx_activity_result2/RequestIntentSender;->getOptions()Landroid/os/Bundle;

    move-result-object v0

    if-nez v0, :cond_2e

    invoke-direct {p0, p1}, Lrx_activity_result2/HolderActivity;->startIntentSender(Lrx_activity_result2/RequestIntentSender;)V

    goto :goto_43

    .line 54
    :cond_2e
    invoke-direct {p0, p1}, Lrx_activity_result2/HolderActivity;->startIntentSenderWithOptions(Lrx_activity_result2/RequestIntentSender;)V

    goto :goto_43

    .line 57
    :cond_32
    :try_start_32
    invoke-virtual {p1}, Lrx_activity_result2/Request;->intent()Landroid/content/Intent;

    move-result-object p1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lrx_activity_result2/HolderActivity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_3a
    .catch Landroid/content/ActivityNotFoundException; {:try_start_32 .. :try_end_3a} :catch_3b

    goto :goto_43

    :catch_3b
    move-exception p1

    .line 59
    iget-object v0, p0, Lrx_activity_result2/HolderActivity;->onResult:Lrx_activity_result2/OnResult;

    if-eqz v0, :cond_43

    .line 60
    invoke-interface {v0, p1}, Lrx_activity_result2/OnResult;->error(Ljava/lang/Throwable;)V

    :cond_43
    :goto_43
    return-void
.end method

.method protected onDestroy()V
    .registers 5

    .line 111
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 112
    iget-object v0, p0, Lrx_activity_result2/HolderActivity;->onResult:Lrx_activity_result2/OnResult;

    if-eqz v0, :cond_10

    .line 113
    iget v1, p0, Lrx_activity_result2/HolderActivity;->requestCode:I

    iget v2, p0, Lrx_activity_result2/HolderActivity;->resultCode:I

    iget-object v3, p0, Lrx_activity_result2/HolderActivity;->data:Landroid/content/Intent;

    invoke-interface {v0, v1, v2, v3}, Lrx_activity_result2/OnResult;->response(IILandroid/content/Intent;)V

    :cond_10
    return-void
.end method
