package com.omarea.scene_mode;

import a.f92;
import a.u61;
import a.wu0;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.omarea.vtools.activities.ActivityPowerModeTile;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SceneTileService extends TileService {
    public final Icon a(int i) {
        return Icon.createWithResource(getApplicationContext(), i);
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        startActivityAndCollapse(new Intent(this, (Class<?>) ActivityPowerModeTile.class).addFlags(268435456).addFlags(65536).addFlags(1073741824));
        super.onClick();
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        Tile qsTile;
        int i;
        super.onStartListening();
        String strD = wu0.f3480a.d();
        if (f92.a(strD, wu0.f3480a.p())) {
            qsTile = getQsTile();
            qsTile.setState(2);
            qsTile.setIcon(a(2131231100));
            i = u61.powersave;
        } else if (f92.a(strD, wu0.f3480a.c())) {
            qsTile = getQsTile();
            qsTile.setState(2);
            qsTile.setIcon(a(2131231101));
            i = u61.balance;
        } else if (f92.a(strD, wu0.f3480a.o())) {
            qsTile = getQsTile();
            qsTile.setState(2);
            qsTile.setIcon(a(2131231102));
            i = u61.performance;
        } else if (f92.a(strD, wu0.f3480a.i())) {
            qsTile = getQsTile();
            qsTile.setState(2);
            qsTile.setIcon(a(2131231103));
            i = u61.fast;
        } else {
            qsTile = getQsTile();
            qsTile.setState(1);
            qsTile.setIcon(a(2131231101));
            i = u61.app_name;
        }
        qsTile.setLabel(getString(i));
        getQsTile().updateTile();
    }
}
