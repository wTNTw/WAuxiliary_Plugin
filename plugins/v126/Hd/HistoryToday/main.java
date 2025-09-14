import org.json.JSONObject;

import java.io.File;

import me.hd.wauxv.plugin.api.callback.PluginCallBack;

void sendToday(String talker) {
    String api = "https://v2.xxapi.cn/api/historypic";
    get(api, null, new PluginCallBack.HttpCallback() {
        public void onSuccess(int respCode, String respContent) {
            JSONObject json = new JSONObject(respContent);
            int code = json.getInt("code");
            if (code == 200) {
                String url = json.getString("data");
                String path = cacheDir + "/image.png";
                download(url, path, null, new PluginCallBack.DownloadCallback() {
                    public void onSuccess(File file) {
                        sendImage(talker, file.getAbsolutePath());
                        file.delete();
                    }

                    public void onError(Exception e) {
                        sendText(talker, "[小小API]下载异常:" + e.getMessage());
                    }
                });
            }
        }

        public void onError(Exception e) {
            sendText(talker, "[小小API]获取异常:" + e.getMessage());
        }
    });
}

void onHandleMsg(Object msgInfoBean) {
    if (msgInfoBean.isText()) {
        String content = msgInfoBean.getContent();
        String talker = msgInfoBean.getTalker();
        if (content.equals("/历史今天")) {
            sendToday(talker);
        }
    }
}
