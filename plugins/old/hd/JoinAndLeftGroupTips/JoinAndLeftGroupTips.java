
void onMemberChange(String type, String groupWxid, String userWxid, String userName) {
    if (type.equals("join")) {
        sendText(groupWxid, "[AtWx=" + userWxid + "]\n欢迎进群");
    } else if (type.equals("left")) {
        sendText(groupWxid, userName + "\n永远离开了我们");
    }
}
