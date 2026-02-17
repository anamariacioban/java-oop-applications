package isp.lab11;

public class ATcCommandClass {
    String command;
    public ATcCommandClass(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "AtcCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}
