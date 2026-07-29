package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalEnvStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12834b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12840h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ILogEncryptAction f12845m;
    public Context mAppContext;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12835c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12836d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12837e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f12838f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12839g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12841i = false;
    public long configRefreshDelayMills = 5000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f12842j = 10000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12843k = 10000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map<String, String> f12844l = new HashMap(5);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> f12846n = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<IEfsReporterObserver> f12847o = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (this.f12847o.contains(iEfsReporterObserver)) {
            return;
        }
        this.f12847o.add(iEfsReporterObserver);
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap map2 = new HashMap(this.f12844l);
        map2.putAll(map);
        this.f12844l = map2;
    }

    public String getAppid() {
        return this.f12833a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i10) {
        return (!this.f12846n.containsKey(Integer.valueOf(i10)) || this.f12846n.get(Integer.valueOf(i10)) == null) ? Collections.emptyList() : this.f12846n.get(Integer.valueOf(i10));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.f12847o;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.f12845m;
    }

    public long getLogSendDelayMills() {
        return this.f12842j;
    }

    public long getLogSendIntervalMills() {
        return this.f12843k;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.f12844l;
        return map == null ? Collections.emptyMap() : map;
    }

    public String getSecret() {
        return this.f12834b;
    }

    public String getUid() {
        return this.f12840h;
    }

    public boolean isDebug() {
        return this.f12837e;
    }

    public boolean isEnableSendLog() {
        return this.f12836d;
    }

    public boolean isEnableWaStat() {
        return this.f12835c;
    }

    public boolean isIntl() {
        return this.f12841i;
    }

    public boolean isPrintLogDetail() {
        return this.f12839g;
    }

    public void registerCallback(int i10, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> linkedList = this.f12846n.get(Integer.valueOf(i10));
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f12846n.putIfAbsent(Integer.valueOf(i10), linkedList);
        }
        linkedList.add(valueCallback);
    }

    public void setAppid(String str) {
        this.f12833a = str;
    }

    public void setDebug(boolean z10) {
        this.f12837e = z10;
    }

    public void setEnableSendLog(boolean z10) {
        this.f12836d = z10;
    }

    public void setEnableWaStat(boolean z10) {
        this.f12835c = z10;
    }

    public void setIsIntl(boolean z10) {
        this.f12841i = z10;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.f12845m = iLogEncryptAction;
    }

    public void setPrintLogDetail(boolean z10) {
        this.f12839g = z10;
    }

    public void setSecret(String str) {
        this.f12834b = str;
    }

    public void setUid(String str) {
        this.f12840h = str;
    }
}
