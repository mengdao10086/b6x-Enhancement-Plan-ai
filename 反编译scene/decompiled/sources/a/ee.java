package a;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ee implements Callable<ge> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ be f723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f725a;

    public ee(String str, Context context, be beVar, int i) {
        this.f725a = str;
        this.f724a = context;
        this.f723a = beVar;
        this.f5992a = i;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ge call() {
        return he.c(this.f725a, this.f724a, this.f723a, this.f5992a);
    }
}
