package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ingredient.Name;
import seedu.address.model.ingredient.Unit;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    // Todo Add JavaDocs
    /**
     * Stub
     * @param amount Stub
     * @return Stub
     * @throws ParseException Stub
     */
    public static double parseAmount(String amount) throws ParseException {
        requireNonNull(amount);
        try {
            return Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid amount format: " + amount);
        }
    }

    // Todo Add JavaDocs

    /**
     * Stub
     * @param unit Stub
     * @return Stub
     * @throws ParseException Stub
     */
    public static Unit parseUnitOfIngredient(String unit) throws ParseException {
        requireNonNull(unit);
        return Unit.parseUnit(unit);
    }

    //    /**
    //     * Parses a {@code String tag} into a {@code Tag}.
    //     * Leading and trailing whitespaces will be trimmed.
    //     *
    //     * @throws ParseException if the given {@code tag} is invalid.
    //     */
    //    public static Tag parseTag(String tag) throws ParseException {
    //        requireNonNull(tag);
    //        String trimmedTag = tag.trim();
    //        if (!Tag.isValidTagName(trimmedTag)) {
    //            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
    //        }
    //        return new Tag(trimmedTag);
    //    }
    //
    //    /**
    //     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
    //     */
    //    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
    //        requireNonNull(tags);
    //        final Set<Tag> tagSet = new HashSet<>();
    //        for (String tagName : tags) {
    //            tagSet.add(parseTag(tagName));
    //        }
    //        return tagSet;
    //    }
}
