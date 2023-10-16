package seedu.address.logic.parser;
import seedu.address.logic.commands.StockCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ingredient.NameContainsKeywordsPredicate;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class StockCommandParser implements Parser<StockCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the StockCommand
     * and returns a StockCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public StockCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        // show the entire stock for when there are no arguments - check!
        if (trimmedArgs.isEmpty()) {
            return new StockCommand(PREDICATE_SHOW_ALL_PERSONS);
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new StockCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}