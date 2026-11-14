/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。
 * 唯一手写处：参数定义/protocol.def.json；改动后重跑生成脚本。
 * 私有目录路径依赖 PRIVATE_DIR，故本头须在 PRIVATE_DIR 定义之后包含。 */
#ifndef PROTOCOL_GENERATED_H
#define PROTOCOL_GENERATED_H

/* status 文件字段名（行格式「字段名=值」，字段名含 '='） */
#define STF_BLE              "BLE="
#define STF_CONNECTED_AT     "CONNECTED_AT="
#define STF_BLE_OWNER_LAST   "BLE_OWNER_LAST="
#define STF_HOT_TEMP         "HOT_TEMP="
#define STF_COLD_TEMP        "COLD_TEMP="
#define STF_RUN_MODE         "RUN_MODE="
#define STF_RPM_REAL         "RPM_REAL="
#define STF_RPM_RUN          "RPM_RUN="
#define STF_COLD_REAL        "COLD_REAL="
#define STF_COLD_RUN         "COLD_RUN="

/* 广播 action（与 Java Protocol.ACTION_* 同值） */
#define BROADCAST_ACTION_B6X "com.flydigi.SET_TEMPERATURE"
#define BROADCAST_ACTION_B7X "com.flydigi.SET_TEMPERATURE_B7"

/* 路径与文件名（R10：core/daemon/脚本三方同源） */
#define PROTO_PATH_STATUS_B6        "/data/local/tmp/tempctrl_b6x.status"
#define PROTO_PATH_STATUS_B7        "/data/local/tmp/tempctrl_b7x.status"
#define PROTO_PATH_UIPREFS          "/data/local/tmp/tempctrl_uiprefs"
#define PROTO_PATH_BT_REQ           "/data/local/tmp/tempctrl_bt_req"
#define PROTO_PATH_TEMP_STOP        "/data/local/tmp/tempctrl_temp_stop"
#define PROTO_NAME_TEMP_STOP_BOOT   "tempctrl_temp_stop_boot"
#define PROTO_PATH_TEMP_STOP_BOOT   PRIVATE_DIR "/tempctrl_temp_stop_boot"
#define PROTO_NAME_LOG              "tempctrl.log"
#define PROTO_PATH_LOG              PRIVATE_DIR "/tempctrl.log"
#define PROTO_PATH_LOG_FALLBACK     "/cache/tempctrl.log"
#define PROTO_PATH_CACHE_DIR        "/cache"
#define PROTO_LOG_EXT               ".log"
#define PROTO_NAME_DATA             "tempctrl_webui.data"
#define PROTO_PATH_DATA             PRIVATE_DIR "/tempctrl_webui.data"
#define PROTO_NAME_COLDMAX          "tempctrl_coldmax"
#define PROTO_PATH_COLDMAX          PRIVATE_DIR "/tempctrl_coldmax"
#define PROTO_PATH_BIN              "/data/local/tmp/tempctrl"
#define PROTO_PATH_BIN_NEW          "/data/local/tmp/tempctrl.new"
#define PROTO_PATH_BIN_NEW_APP      "/data/local/tmp/tempctrl.new.app"
#define PROTO_PATH_BIN_PREV         "/data/local/tmp/tempctrl.prev"
#define PROTO_PATH_SERVICE_LOG      "/data/local/tmp/tempctrl_service.log"
#define PROTO_PATH_LAST_DEV         "/data/local/tmp/tempctrl_last_dev"
#define PROTO_PATH_LOCK_FALLBACK    "/data/local/tmp/tempctrl.lock"
#define PROTO_NAME_LOCK_PRIVATE     "tempctrl.lock"
#define PROTO_PATH_LOCK_PRIVATE     PRIVATE_DIR "/tempctrl.lock"
#define PROTO_PATH_SCRIPT_MODERN    "/data/adb/service.d/b6x-tempctrl.sh"
#define PROTO_PATH_SCRIPT_KSU       "/data/adb/ksu/service.d/b6x-tempctrl.sh"
#define PROTO_NAME_MANIFEST         "tempctrl_sync_manifest"
#define PROTO_PATH_MANIFEST         PRIVATE_DIR "/tempctrl_sync_manifest"
#define PROTO_NAME_DEPLOY_STAMP     "tempctrl_deploy_stamp"
#define PROTO_PATH_DEPLOY_STAMP     PRIVATE_DIR "/tempctrl_deploy_stamp"
#define PROTO_NAME_WD_SPAWN         "tempctrl_wd_spawn"
#define PROTO_PATH_WD_SPAWN         PRIVATE_DIR "/tempctrl_wd_spawn"
#define PROTO_NAME_CONFIG           "profile.conf"
#define PROTO_PATH_CONFIG           PRIVATE_DIR "/profile.conf"

/* 宿主包名与脚本名（R22：与 params.def.json appPackage 一致，CI 断言） */
#define PROTO_HOST_PKG       "com.example.waspwingtempctrl"
#define PROTO_HOST_DATA_DIR  "/data/data/" PROTO_HOST_PKG
#define PROTO_SCRIPT_NAME    "b6x-tempctrl.sh"

#define PROTO_COLDMAX_FIELD  "COLD_MAX="
#define PROTO_BT_REQ_FIELD   "REQ="

/* WebUI 曲线列下标（写端用位置实参，读端按这些常量取列） */
enum WebuiDataCol {
    WEBUI_COL_TS = 0,   /* 时间戳（s） */
    WEBUI_COL_BATT = 1,   /* 电池温度（0.1°C） */
    WEBUI_COL_CPU = 2,   /* CPU温度（0.1°C） */
    WEBUI_COL_HOT = 3,   /* 热端温度（0.1°C） */
    WEBUI_COL_COLD = 4,   /* 冷端温度（0.1°C） */
    WEBUI_COL_RPM_SET = 5,   /* 目标风速（档位） */
    WEBUI_COL_COLD_SET = 6,   /* 目标制冷（档位） */
    WEBUI_COL_COLD_CMD = 7,   /* 下发目标制冷（0.1°C） */
    WEBUI_COL_PID_INPUT = 8,   /* PID输入（0.01°C） */
    WEBUI_COL_RECOMPUTE = 9,   /* 重算标记（0/1） */
    WEBUI_COL_COLD_RUN = 10,   /* 实际制冷（档位） */
    WEBUI_COL_RPM_RUN = 11,   /* 实际转速（RPM） */
    WEBUI_COL_COUNT = 12
};
#define WEBUI_COLS_LEGACY_MIN 8

/* 卸载清理清单（daemon 执行面）：X(绝对路径宏) */
#define PROTO_CLEANUP_DAEMON(X) \
    X(PROTO_PATH_STATUS_B6) \
    X(PROTO_PATH_STATUS_B7) \
    X(PROTO_PATH_UIPREFS) \
    X(PROTO_PATH_SERVICE_LOG) \
    X(PROTO_PATH_LOCK_FALLBACK) \
    X(PROTO_PATH_SCRIPT_MODERN) \
    X(PROTO_PATH_SCRIPT_KSU) \
    X(PROTO_PATH_LOG_FALLBACK)

#endif  /* PROTOCOL_GENERATED_H */
