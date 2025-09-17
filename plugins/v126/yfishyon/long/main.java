import org.json.JSONObject;

import java.io.File;

import me.hd.wauxv.plugin.api.callback.PluginCallBack;

boolean onClickSendBtn(String text) {
    if ("龙图".equals(text)) { //龙哥就是龙！
        get("https://api.yujn.cn/api/long.php?type=json", null, new PluginCallBack.HttpCallback() {
            public void onSuccess(int respCode, String respContent) {
                JSONObject json = new JSONObject(respContent);
                int code = json.getInt("code");
                if (code == 200) {
                    String url = json.getString("data");
                    download(url, cacheDir + "/long.jpg", null, new PluginCallBack.DownloadCallback() {
                        public void onSuccess(File file) {
                            sendEmoji(getTargetTalker(), file.getAbsolutePath());
                            file.delete();
                        }
                    });
                }
            }
        });
        return true;
    }
    return false;
}
