package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;

/* JADX INFO: loaded from: classes5.dex */
public class SocialApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SocialApiIml f22602a;

    public SocialApi(QQToken qQToken) {
        this.f22602a = new SocialApiIml(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22602a.ask(activity, bundle, iUiListener);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22602a.gift(activity, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22602a.invite(activity, bundle, iUiListener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f22602a.story(activity, bundle, iUiListener);
    }
}
