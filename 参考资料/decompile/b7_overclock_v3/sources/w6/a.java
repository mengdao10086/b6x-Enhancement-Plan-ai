package w6;

import androidx.lifecycle.LiveData;
import androidx.room.e1;
import androidx.room.j3;
import androidx.room.l0;
import androidx.room.p1;
import androidx.room.q0;
import com.flydigi.data.bean.InstalledGameBean;
import g.p0;
import java.util.List;
import xi.i0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@l0
public interface a {
    @p1("DELETE FROM installed_game")
    void a();

    @p1("SELECT * FROM installed_game WHERE local_package_name = :packageName OR standard_package_name = :packageName")
    @p0
    @l
    InstalledGameBean b(@k String str);

    @j3
    void c(@k InstalledGameBean... installedGameBeanArr);

    @p1("SELECT * FROM installed_game WHERE local_package_name = :packageName ")
    @l
    InstalledGameBean d(@k String str);

    @p1("SELECT * FROM installed_game WHERE local_package_name = :packageName ")
    @k
    i0<InstalledGameBean> e(@k String str);

    @e1(onConflict = 1)
    void f(@k InstalledGameBean... installedGameBeanArr);

    @q0
    void g(@k InstalledGameBean... installedGameBeanArr);

    @p1("SELECT * FROM installed_game ORDER BY update_time desc")
    @k
    List<InstalledGameBean> getAll();

    @j3
    @k
    xi.a h(@k InstalledGameBean... installedGameBeanArr);

    @p1("SELECT * FROM installed_game ORDER BY update_time desc")
    @k
    LiveData<List<InstalledGameBean>> i();
}
