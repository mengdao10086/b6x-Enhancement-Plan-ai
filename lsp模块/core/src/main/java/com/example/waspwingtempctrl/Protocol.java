package com.example.waspwingtempctrl;

/**
 * 跨端协议常量。由 {@code python 参数定义/gen_params.py} 从
 * {@code 参数定义/protocol.def.json} 生成，勿手改。
 *
 * <p>C 端对应 {@code lsp模块/daemon/protocol_generated.h}；WebUI 对应 app.js 的生成区块。
 */
public final class Protocol {

    private Protocol() {
    }

    // ==================== WebUI 曲线列（tempctrl_webui.data） ====================
    public static final int WEBUI_COL_TS = 0;
    public static final int WEBUI_COL_BATT = 1;
    public static final int WEBUI_COL_CPU = 2;
    public static final int WEBUI_COL_HOT = 3;
    public static final int WEBUI_COL_COLD = 4;
    public static final int WEBUI_COL_RPM_SET = 5;
    public static final int WEBUI_COL_COLD_SET = 6;
    public static final int WEBUI_COL_COLD_CMD = 7;
    public static final int WEBUI_COL_PID_INPUT = 8;
    public static final int WEBUI_COL_RECOMPUTE = 9;
    public static final int WEBUI_COL_COLD_RUN = 10;
    public static final int WEBUI_COL_RPM_RUN = 11;
    public static final int WEBUI_COL_COUNT = 12;
    public static final int WEBUI_COLS_LEGACY_MIN = 8;

    // ==================== status 文件字段名 ====================
    public static final String STF_BLE = "BLE=";
    public static final String STF_CONNECTED_AT = "CONNECTED_AT=";
    public static final String STF_BLE_OWNER_LAST = "BLE_OWNER_LAST=";
    public static final String STF_HOT_TEMP = "HOT_TEMP=";
    public static final String STF_COLD_TEMP = "COLD_TEMP=";
    public static final String STF_RUN_MODE = "RUN_MODE=";
    public static final String STF_RPM_REAL = "RPM_REAL=";
    public static final String STF_RPM_RUN = "RPM_RUN=";
    public static final String STF_COLD_REAL = "COLD_REAL=";
    public static final String STF_COLD_RUN = "COLD_RUN=";

    // ==================== 广播 action 与 extra ====================
    public static final String ACTION_TEMP_B6 = "com.flydigi.SET_TEMPERATURE";
    public static final String ACTION_TEMP_B7 = "com.flydigi.SET_TEMPERATURE_B7";
    public static final String EXTRA_MODE = "mode";
    public static final String EXTRA_TEMPERATURE = "temperature";
    public static final String EXTRA_WIND_OC = "windOC";
    public static final String EXTRA_COLD_OC = "coldOC";
    public static final String EXTRA_WIND_LEVEL = "windLevel";
    public static final String EXTRA_MODE_CUSTOM = "modeCustom";
    public static final String EXTRA_EXTRA = "extra";

    // ==================== 路径与文件名 ====================
    public static final String PATH_STATUS_B6 = "/data/local/tmp/tempctrl_b6x.status";
    public static final String PATH_STATUS_B7 = "/data/local/tmp/tempctrl_b7x.status";
    public static final String PATH_UIPREFS = "/data/local/tmp/tempctrl_uiprefs";
    public static final String PATH_BT_REQ = "/data/local/tmp/tempctrl_bt_req";
    public static final String PATH_TEMP_STOP = "/data/local/tmp/tempctrl_temp_stop";
    public static final String NAME_TEMP_STOP_BOOT = "tempctrl_temp_stop_boot";
    public static final String NAME_LOG = "tempctrl.log";
    public static final String PATH_LOG_FALLBACK = "/cache/tempctrl.log";
    public static final String PATH_CACHE_DIR = "/cache";
    public static final String LOG_EXT = ".log";
    public static final String NAME_DATA = "tempctrl_webui.data";
    public static final String NAME_COLDMAX = "tempctrl_coldmax";
    public static final String PATH_BIN = "/data/local/tmp/tempctrl";
    public static final String PATH_BIN_NEW = "/data/local/tmp/tempctrl.new";
    public static final String PATH_BIN_NEW_APP = "/data/local/tmp/tempctrl.new.app";
    public static final String PATH_BIN_PREV = "/data/local/tmp/tempctrl.prev";
    public static final String PATH_SERVICE_LOG = "/data/local/tmp/tempctrl_service.log";
    public static final String PATH_LAST_DEV = "/data/local/tmp/tempctrl_last_dev";
    public static final String PATH_LOCK_FALLBACK = "/data/local/tmp/tempctrl.lock";
    public static final String NAME_LOCK_PRIVATE = "tempctrl.lock";
    public static final String PATH_SCRIPT_MODERN = "/data/adb/service.d/b6x-tempctrl.sh";
    public static final String PATH_SCRIPT_KSU = "/data/adb/ksu/service.d/b6x-tempctrl.sh";
    public static final String NAME_MANIFEST = "tempctrl_sync_manifest";
    public static final String NAME_DEPLOY_STAMP = "tempctrl_deploy_stamp";
    public static final String NAME_WD_SPAWN = "tempctrl_wd_spawn";
    public static final String NAME_CONFIG = "profile.conf";
    public static final String HOST_PKG = "com.example.waspwingtempctrl";
    public static final String SCRIPT_NAME = "b6x-tempctrl.sh";
    public static final String COLDMAX_FIELD = "COLD_MAX=";
    public static final String BT_REQ_FIELD = "REQ=";

    /** 卸载清理清单（app 执行面）。 */
    public static final String[] CLEANUP_APP = {
        "/data/adb/service.d/b6x-tempctrl.sh",
        "/data/adb/ksu/service.d/b6x-tempctrl.sh",
        "/data/local/tmp/tempctrl",
        "/data/local/tmp/tempctrl.new",
        "/data/local/tmp/tempctrl.new.app",
        "/data/local/tmp/tempctrl.prev",
        "/data/local/tmp/tempctrl.lock",
        "/data/local/tmp/tempctrl_b6x.status",
        "/data/local/tmp/tempctrl_b7x.status",
        "/data/local/tmp/tempctrl_uiprefs",
        "/data/local/tmp/tempctrl_service.log",
        "/data/local/tmp/tempctrl_last_dev",
        "/cache/tempctrl.log",
    };

    /** 卸载清理清单（app_private 执行面）。 */
    public static final String[] CLEANUP_APP_PRIVATE = {
        "tempctrl.lock",
        "tempctrl.log",
        "tempctrl_webui.data",
        "tempctrl_sync_manifest",
        "tempctrl_deploy_stamp",
        "tempctrl_wd_spawn",
    };
}
