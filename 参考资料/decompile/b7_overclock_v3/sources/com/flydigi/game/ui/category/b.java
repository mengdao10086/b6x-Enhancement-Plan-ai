package com.flydigi.game.ui.category;

import com.flydigi.game.data.api.GameApiService;
import com.flydigi.game.ui.category.a;
import m5.c0;
import m5.f0;
import o5.l;

/* JADX INFO: loaded from: classes7.dex */
public class b implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.InterfaceC0161a f15844a;

    public b(a.InterfaceC0161a interfaceC0161a) {
        this.f15844a = interfaceC0161a;
    }

    @Override // com.flydigi.game.ui.category.a.b
    public void E() {
        d0();
    }

    public final void d0() {
        this.f15844a.D1(((GameApiService) f0.i().k().g(GameApiService.class)).getGameCatList().s0(c0.t()).s0(l.d()));
    }
}
