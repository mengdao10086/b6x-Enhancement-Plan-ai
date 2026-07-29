package org.bouncycastle.tsp.cms;

import gt.h;

/* JADX INFO: loaded from: classes6.dex */
public class ImprintDigestInvalidException extends Exception {
    private h token;

    public ImprintDigestInvalidException(String str, h hVar) {
        super(str);
        this.token = hVar;
    }

    public h a() {
        return this.token;
    }
}
