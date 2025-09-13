
void onHandleMsg(Object msgInfoBean) {
    if (msgInfoBean.isSend()) return;
    if (msgInfoBean.isText()) {
        String content = msgInfoBean.getContent();
        String talker = msgInfoBean.getTalker();
        if (content.equals("在吗")) {
            sendText(talker, "不在");
        } else if (content.equals("想我吗")) {
            sendText(talker, "不想");
        } else if (content.equals("爱我吗")) {
            sendText(talker, "不爱");
        }
    }
}
