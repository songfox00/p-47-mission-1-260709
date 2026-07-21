public class Rq {

    private String cmd;

    public Rq(String cmd) {
        this.cmd=cmd;
    }

    public String getActionName(){
        String[] cmdBits = cmd.split("\\?");

        return cmdBits[0];
    }
}
