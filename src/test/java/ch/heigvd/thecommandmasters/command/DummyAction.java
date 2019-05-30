package ch.heigvd.thecommandmasters.command;

public class DummyAction extends Action {

    public Value data;

    public DummyAction(Value data) {
        super(null, 1);
        this.data = data;
    }

    @Override
    public void execute() {
        ++data.value;
    }

    @Override
    public void undo() {
        --data.value;
    }
}
