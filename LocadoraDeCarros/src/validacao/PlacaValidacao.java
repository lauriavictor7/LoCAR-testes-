package validacao;

/**
 *
 * @author lolinha
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlacaValidacao {
  private Pattern pattern;
    private Matcher matcher;

    private static final String Placa_PATTERN = 
        "[a-zA-Z]{3,3}-\\\\d{4,4}";

    public PlacaValidacao() {
        pattern = Pattern.compile(Placa_PATTERN);
    }

    /**
     * Validate hex with regular expression
     * 
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    public boolean validate(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();

    }   
}
