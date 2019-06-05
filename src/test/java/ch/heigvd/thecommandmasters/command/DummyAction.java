package ch.heigvd.thecommandmasters.command;

public class DummyAction extends Action {

    public Value data;

    public DummyAction(Value data) {
        this(data, 1);
    }

    public DummyAction(Value data, int priority) {
        super(null, priority);
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
