package y8;

import com.flydigi.game.data.api.GameApiService;
import m5.c0;
import m5.f0;
import o5.l;
import y8.a;

/* JADX INFO: loaded from: classes7.dex */
public class b implements a.InterfaceC0666a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56519d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56520e = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.b f56521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56522b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f56523c;

    public b(a.b bVar) {
        this.f56521a = bVar;
    }

    @Override // y8.a.InterfaceC0666a
    public void B(String str) {
        this.f56523c = str;
        this.f56522b = 1;
        this.f56521a.p0(((GameApiService) f0.i().k().g(GameApiService.class)).getSearchResult(str, "", 15, this.f56522b).s0(c0.t()).s0(l.d()), this.f56522b);
    }

    @Override // y8.a.InterfaceC0666a
    public void K() {
        this.f56521a.m1(((GameApiService) f0.i().k().g(GameApiService.class)).getSearchReco(6).s0(c0.t()).s0(l.d()));
    }

    @Override // y8.a.InterfaceC0666a
    public void Q() {
        this.f56522b++;
        this.f56521a.p0(((GameApiService) f0.i().k().g(GameApiService.class)).getSearchResult(this.f56523c, "", 15, this.f56522b).s0(c0.t()).s0(l.d()), this.f56522b);
    }
}
