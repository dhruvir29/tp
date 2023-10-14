package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;

import seedu.address.model.Model;

import seedu.address.model.ingredient.NameContainsKeywordsPredicate;

import static java.util.Objects.requireNonNull;


    public class StockCommand extends Command {

        public static final String COMMAND_WORD = "stock";

        public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all specified ingredients and their respective"
                + "quantities. "
                + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
                + "Example: " + COMMAND_WORD + " flour milk";

        private final NameContainsKeywordsPredicate predicate;

        public StockCommand(NameContainsKeywordsPredicate predicate) {
            this.predicate = predicate;
        }

        @Override
        public CommandResult execute(Model model) {
            requireNonNull(model);
            model.updateFilteredIngredientList(predicate);
            return new CommandResult(
                    String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredIngredientList().size()));
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof StockCommand)) {
                return false;
            }

            StockCommand otherStockCommand = (StockCommand) other;
            return predicate.equals(otherStockCommand.predicate);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .add("predicate", predicate)
                    .toString();
        }

}
