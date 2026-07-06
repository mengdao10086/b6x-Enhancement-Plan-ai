package a;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ce implements Callable<ge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ be f384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f386a;

    public ce(String str, Context context, be beVar, int i) {
        this.f386a = str;
        this.f385a = context;
        this.f384a = beVar;
        this.f5783a = i;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ge call() {
        return he.c(this.f386a, this.f385a, this.f384a, this.f5783a);
    }
}
