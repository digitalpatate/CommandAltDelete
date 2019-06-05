package ch.heigvd.thecommandmasters.command;

public class DummyCommand extends Command {

    public Value data;

    public DummyCommand(Value data) {
        this(1, data);
    }

    public DummyCommand(int priority, Value data) {
        super(priority);
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
