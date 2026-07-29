package com.bumptech.glide.load.engine;

import e4.a;
import g.n0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d<DataType> implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.a<DataType> f12351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataType f12352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.e f12353c;

    public d(c4.a<DataType> aVar, DataType datatype, c4.e eVar) {
        this.f12351a = aVar;
        this.f12352b = datatype;
        this.f12353c = eVar;
    }

    @Override // e4.a.b
    public boolean a(@n0 File file) {
        return this.f12351a.a(this.f12352b, file, this.f12353c);
    }
}
