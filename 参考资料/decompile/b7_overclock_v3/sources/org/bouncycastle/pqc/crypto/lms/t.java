package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMSigParameters f45775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LMOtsParameters f45776b;

    public t(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters) {
        this.f45775a = lMSigParameters;
        this.f45776b = lMOtsParameters;
    }

    public LMOtsParameters a() {
        return this.f45776b;
    }

    public LMSigParameters b() {
        return this.f45775a;
    }
}
