
void onMemberChange(String type, String groupWxid, String userWxid, String userName) {
    List list = Arrays.asList({"demo@chatroom"});
    if (!list.contains(groupWxid)) return;
    if (type.equals("join")) {
        sendText(groupWxid, "[AtWx=" + userWxid + "]\n欢迎进群");
    } else if (type.equals("left")) {
        sendText(groupWxid, userName + "\n退出了群聊");
    }
}
