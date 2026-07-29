package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import hb.d0;
import hd.c0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f17101a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    public TagPayloadReader(d0 d0Var) {
        this.f17101a = d0Var;
    }

    public final boolean a(c0 c0Var, long j10) throws ParserException {
        return b(c0Var) && c(c0Var, j10);
    }

    public abstract boolean b(c0 c0Var) throws ParserException;

    public abstract boolean c(c0 c0Var, long j10) throws ParserException;

    public abstract void d();
}
