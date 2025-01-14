package seedu.bigpp.command.viewercommand;

import org.junit.jupiter.api.Test;
import seedu.bigpp.exceptions.PPException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import seedu.bigpp.datastorage.DataStorage;

public class AddCommandTest {

    private DataStorage dataStorage = new DataStorage();

    @Test
    public void executeCommand_addCommand_success() throws PPException {
        String pcName = "Test PC";
        ViewerAddCommand viewerAddCommand = new ViewerAddCommand(pcName);
        String commandResult = viewerAddCommand.executeCommand(dataStorage);
        assertEquals("Custom PC: [ Test PC ] has been created", commandResult);
    }
}
