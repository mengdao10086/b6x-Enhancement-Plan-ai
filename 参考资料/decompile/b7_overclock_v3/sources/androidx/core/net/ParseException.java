package androidx.core.net;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class ParseException extends RuntimeException {

    @n0
    public final String response;

    public ParseException(@n0 String str) {
        super(str);
        this.response = str;
    }
}
