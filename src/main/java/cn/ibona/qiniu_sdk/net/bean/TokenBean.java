package cn.ibona.qiniu_sdk.net.bean;

/**
 * Created by yuanmingzhuo on 16-3-10.
 * token 实体
 */
public class TokenBean {


    /**
     * status : 0
     * info : 成功
     * data : {"token":"5H2lLNLrMyCNlRQPLXvNGwDiC5b-f8t9E-hhk4cS:DorVU-LQlrCLU7MRGSA3w1s6v70=:eyJzY29wZSI6ImRlbW8iLCJkZWFkbGluZSI6MTQ1NzYwMTkwMCwiY2FsbGJhY2tVcmwiOiJodHRwOlwvXC8xODIuMjU0LjIyOC4yMTE6OTAwMFwvaW5kZXgucGhwXC9hcGlcL2luZGV4XC9jYWxsQmFjayIsImNhbGxiYWNrQm9keSI6IntcImZuYW1lXCI6XCIkKGZuYW1lKVwiLCBcImZrZXlcIjpcIiQoa2V5KVwiIH0ifQ=="}
     */

    private int status;
    private String info;
    /**
     * token : 5H2lLNLrMyCNlRQPLXvNGwDiC5b-f8t9E-hhk4cS:DorVU-LQlrCLU7MRGSA3w1s6v70=:eyJzY29wZSI6ImRlbW8iLCJkZWFkbGluZSI6MTQ1NzYwMTkwMCwiY2FsbGJhY2tVcmwiOiJodHRwOlwvXC8xODIuMjU0LjIyOC4yMTE6OTAwMFwvaW5kZXgucGhwXC9hcGlcL2luZGV4XC9jYWxsQmFjayIsImNhbGxiYWNrQm9keSI6IntcImZuYW1lXCI6XCIkKGZuYW1lKVwiLCBcImZrZXlcIjpcIiQoa2V5KVwiIH0ifQ==
     */

    private Data data;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        private String token;

        public void setToken(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
