
void onHandleMsg(Object msgInfoBean) {
    if (msgInfoBean.isGroupChat()) return;
    if (msgInfoBean.isSend()) return;
    if (msgInfoBean.isText()) {
        String content = msgInfoBean.getContent();
        String talker = msgInfoBean.getTalker();
        if (content.equals("进群")) {
            inviteChatroomMember("demo@chatroom", talker);
        }
    }
}
