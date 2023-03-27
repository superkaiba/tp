package seedu.bigpp.command.buildercommand;

import seedu.bigpp.component.cpu.CPU;
import seedu.bigpp.component.motherboard.Motherboard;
import seedu.bigpp.datastorage.DataStorage;
import seedu.bigpp.exceptions.PPException;
import seedu.bigpp.ui.UI;

public class BuilderCustomMotherboardCommand extends BuilderCustomComponentCommand {

    public BuilderCustomMotherboardCommand(String arguments) {
        super(arguments);
    }

    public int getExpectedArgumentLength() {
        return 8;
    }
    public String addNewComponent(String[] argumentList, DataStorage dataStorage, String name, String brand)
            throws PPException {
        float price = 0;
        float power = 0;

        try {
            price = Float.parseFloat(argumentList[2]);
            power = Float.parseFloat(argumentList[5]);

            // Check if all the values are positive
            if (price < 0 || power < 0) {
                throw new PPException("price and power should be positive");
            }

        } catch (NumberFormatException e) {
            throw new PPException(
                    "price and power should be floats");
        }

        String formfactor = argumentList[3].trim();
        String socket = argumentList[4].trim();
        if (socket.equals("") || formfactor.equals("")) {
            throw new PPException("Please enter a valid socket/formfactor for the custom component");
        }
        Motherboard motherboard = new Motherboard(name, brand, price, formfactor, socket, power);

        dataStorage.pcList.get(UI.pcBuilderMenu.getPCIndex()).setMotherboard(motherboard);

        return "Motherboard added: " + motherboard.getName();
    }
}