package com.umeng.socialize.net;

import com.umeng.socialize.net.analytics.AnalyticsReqeust;
import com.umeng.socialize.net.analytics.AnalyticsResponse;
import com.umeng.socialize.net.base.SocializeClient;

/* JADX INFO: loaded from: classes5.dex */
public class RestAPI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SocializeClient f24710a = new SocializeClient();

    public static LinkCardResponse convertLinkCard(LinkcardRequest linkcardRequest) {
        return (LinkCardResponse) f24710a.execute(linkcardRequest);
    }

    public static AnalyticsResponse doShareByRequest(AnalyticsReqeust analyticsReqeust) {
        return (AnalyticsResponse) f24710a.execute(analyticsReqeust);
    }

    public static ActionBarResponse queryShareId(ActionBarRequest actionBarRequest) {
        return (ActionBarResponse) f24710a.execute(actionBarRequest);
    }
}
