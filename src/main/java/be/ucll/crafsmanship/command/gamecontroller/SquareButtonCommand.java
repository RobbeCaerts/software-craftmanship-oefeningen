package be.ucll.crafsmanship.command.gamecontroller;

public class SquareButtonCommand implements Command {
    private final Receiver receiver;

    public SquareButtonCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        receiver.actionSquare();
    }
}
